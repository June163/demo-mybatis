package com.pindao.infrabase.mdm.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.base.rpcclient.SaasMdmPublicAreaClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MdmApiApplicationTest {

    @Reference(version = "1.0.0", url = "dubbo://192.168.203.72:20880")
    private SaasMdmPublicAreaClient saasMdmPublicAreaClient;

    @Test
    public void testMethod() {
        MdmPublicAreaQuery query = new MdmPublicAreaQuery();
        query.setParentAreaID(86);
        log.info("入参 -> [{}]", query);
        List<MdmPublicAreaDTO> dtoList = saasMdmPublicAreaClient.queryByKeywords(query);
        log.info("结果 -> [{}]", dtoList);
    }
}
