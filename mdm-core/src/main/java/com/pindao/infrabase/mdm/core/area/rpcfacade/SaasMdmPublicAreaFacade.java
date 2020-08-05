package com.pindao.infrabase.mdm.core.area.rpcfacade;

import com.alibaba.dubbo.config.annotation.Service;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.base.rpcclient.SaasMdmPublicAreaClient;
import com.pindao.infrabase.mdm.core.area.service.ISaasMdmPublicAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: wangyongkang
 */
@Service(version = "1.0.0", timeout = 10000, interfaceClass = SaasMdmPublicAreaClient.class)
@Component
@Slf4j
public class SaasMdmPublicAreaFacade implements SaasMdmPublicAreaClient {

    @Autowired
    private ISaasMdmPublicAreaService iSaasMdmPublicAreaService;

    @Override
    public List<MdmPublicAreaDTO> queryByKeywords(MdmPublicAreaQuery query) {
        return iSaasMdmPublicAreaService.queryByKeywords(query);
    }
}
