package com.pindao.infrabase.mdm.common.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : wangyongkang
 */
@Slf4j
public class ListUtil {

    /**
     * 转换为 List
     *
     * @param source
     * @param clazz
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> convertModelToDto(List<S> source, Class<T> clazz) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }
        return source.stream().map(s -> {
            T t = null;
            try {
                t = clazz.newInstance();
            } catch (Exception e) {
                log.error(" new Instance error [{}]", e);
                e.printStackTrace();
            }
            BeanUtils.copyProperties(s, t);
            return t;
        }).collect(Collectors.toList());
    }
}
