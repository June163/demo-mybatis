package com.pindao.infrabase.mdm.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pindao.infrabase.mdm.base.domain.TestDTO;
import com.pindao.infrabase.mdm.base.testrpc.TestRpcClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MdmApiApplicationTest {

    @Reference(version = "1.0.0", url = "dubbo://192.168.203.72:20880")
    private TestRpcClient testRpcClient;

    @Test
    public void testMethod() {
        log.info("testMethod -> [{}]", testRpcClient.testMethod(TestDTO.builder().id("testId").name("testName").build()));
    }
}
