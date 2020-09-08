package com.pindao.infrabase.mdm.api;

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

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("local")
public class MdmApiApplicationTest {

    @Reference(version = "1.0.0")
    private SaasMdmPublicAreaClient saasMdmPublicAreaClient;

    @Test
    public void testMethod() {
        MdmPublicAreaQuery query = new MdmPublicAreaQuery();
        query.setKeywords("市");
        query.setAreaDepths((byte) 0);
        query.setCountryAbbreviation("CN");
        log.info("入参 -> [{}]", query);
        List<MdmPublicAreaDTO> dtoList = saasMdmPublicAreaClient.queryByKeywords(query);
        log.info("结果 -> [{}]", dtoList);
        RpcResult<List<MdmPublicAreaDTO>> rpcResult = saasMdmPublicAreaClient.query(query);
        log.info("rpc结果 -> [{}]", rpcResult);
    }
}
