package com.pindao.infrabase.mdm.core.area.rpcfacade;

import com.alibaba.dubbo.config.annotation.Service;
import com.pindao.infrabase.mdm.base.domain.TestDTO;
import com.pindao.infrabase.mdm.base.testrpc.TestRpcClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wangyongkang
 */
@Service(version = "1.0.0", timeout = 10000, interfaceClass = TestRpcClient.class)
@Component
@Slf4j
public class TestRpcFacade implements TestRpcClient {

    @Override
    public TestDTO testMethod(TestDTO testDTO) {
        log.info("testMethod -> [{}]", testDTO);
        return TestDTO.builder().id("testId").name("testName").build();
    }
}
