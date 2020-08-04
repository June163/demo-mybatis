package com.pindao.infrabase.mdm.common.utils;

import java.text.MessageFormat;

public class DefaultCodeGenerator implements CodeGenerator {

    private static final long TWEPOCH = 687888001020L;
    private final String prefix;
    private final long workerId;
    private long sequence = 0L;
    private int workerIdBits = 2;
    private long maxWorkerId = -1L ^ -1L << workerIdBits;
    private int sequenceBits = 4;
    private int workerIdShift = sequenceBits;
    private int timestampLeftShift = sequenceBits + workerIdBits;
    private long sequenceMask = -1L ^ -1L << sequenceBits;
    private long lastTimestamp = -1L;
    /**
     * 异常时间差（回流时间大于5秒）.
     */
    private static final long ERROR_TIME_DIFFERENCE = 5000;

    /**
     * 默认构造器.
     *
     * @param prefix 编码前缀
     */
    public DefaultCodeGenerator(String prefix) {
        this(prefix, 1L);
    }

    /**
     * 构造器.
     *
     * @param prefix   编码前缀
     * @param workerId 机器码
     */
    public DefaultCodeGenerator(String prefix, long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new RuntimeException(
                    String.format("worker Id can't be greater than %s or less than 0 ", workerId));
        }
        this.prefix = prefix;
        this.workerId = workerId;
    }


    private long tillNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    @Override
    public synchronized String next() {
        long timestamp = timeGen();
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tillNextMillis(lastTimestamp);
            }
        } else if (lastTimestamp > timestamp) {
            long timeDifference = lastTimestamp - timestamp;
            if (timeDifference > ERROR_TIME_DIFFERENCE) {
                throw new RuntimeException(MessageFormat
                        .format("Clock moved backwards.  Refusing to generate id for {0} milliseconds",
                                timeDifference));
            } else {
                try {
                    this.wait(timeDifference);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Thread InterruptedException occurred during generate id", e);
                }
                this.next();
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        long nextId =
                (timestamp - TWEPOCH << timestampLeftShift) | workerId << workerIdShift | sequence;
        return prefix + nextId;
    }
}