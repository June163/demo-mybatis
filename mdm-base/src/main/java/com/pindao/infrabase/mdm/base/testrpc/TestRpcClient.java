package com.pindao.infrabase.mdm.base.testrpc;

import com.pindao.infrabase.mdm.base.domain.TestDTO;

/**
 * @author: wangyongkang
 */
public interface TestRpcClient {

    /**
     * 测试方法
     *
     * @param testDTO
     * @return
     */
    TestDTO testMethod(TestDTO testDTO);
}
