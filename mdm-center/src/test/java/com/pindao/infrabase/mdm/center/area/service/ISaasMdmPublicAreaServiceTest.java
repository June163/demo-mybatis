package com.pindao.infrabase.mdm.center.area.service;

import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.center.MdmCenterApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class ISaasMdmPublicAreaServiceTest extends MdmCenterApplicationTest {

    @Autowired
    private ISaasMdmPublicAreaService iSaasMdmPublicAreaService;

    @Test
    public void queryByKeywords() {
        MdmPublicAreaQuery query = new MdmPublicAreaQuery();
        query.setParentAreaID(86);
        query.setAreaDepths((byte) 1);
        query.setKeywords("省");
        log.info("入参 -> [{}]", query);
        List<MdmPublicAreaDTO> dtoList = iSaasMdmPublicAreaService.queryByKeywords(query);
        log.info("结果 -> [{}]", dtoList);

    }
}