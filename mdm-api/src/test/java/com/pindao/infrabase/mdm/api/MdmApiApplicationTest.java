package com.pindao.infrabase.mdm.api;

import com.alibaba.fastjson.JSON;
import com.pindao.common.sdk.domain.vo.RpcResult;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.base.rpcclient.SaasMdmPublicAreaClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("test")
public class MdmApiApplicationTest {

    @Reference(version = "1.0.0")
    private SaasMdmPublicAreaClient saasMdmPublicAreaClient;

    @Test
    public void testMethod() {
        MdmPublicAreaQuery query = new MdmPublicAreaQuery();
        query.setKeywords("市");
        query.setAreaDepths((byte) 0);
        query.setCountryAbbreviation("CN");
        log.info("入参 -> [{}]" , query);
        List<MdmPublicAreaDTO> dtoList = saasMdmPublicAreaClient.queryByKeywords(query);
        log.info("结果 -> [{}]" , dtoList);
        log.info("json -> [{}]" , JSON.toJSONString(query));
        RpcResult<List<MdmPublicAreaDTO>> rpcResult = saasMdmPublicAreaClient.list(query);
        log.info("rpc结果 -> [{}]" , rpcResult);
    }

    @Test
    public void queryByAreaIds() {
        RpcResult<List<MdmPublicAreaDTO>> listRpcResult = saasMdmPublicAreaClient.queryByAreaIds(null);
        log.info("listRpcResult -> [{}]" , listRpcResult);
        listRpcResult = saasMdmPublicAreaClient.queryByAreaIds(Arrays.asList(141025,
                141026,
                141027,
                141028));
        log.info("listRpcResult -> [{}]" , listRpcResult);
        listRpcResult = saasMdmPublicAreaClient.queryByAreaIds(Collections.emptyList());
        log.info("listRpcResult -> [{}]" , listRpcResult);
    }
}
