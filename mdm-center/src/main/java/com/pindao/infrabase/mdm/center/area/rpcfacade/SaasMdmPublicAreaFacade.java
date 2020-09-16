package com.pindao.infrabase.mdm.center.area.rpcfacade;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.pindao.common.sdk.domain.vo.RpcResult;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.base.rpcclient.SaasMdmPublicAreaClient;
import com.pindao.infrabase.mdm.center.area.service.ISaasMdmPublicAreaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: wangyongkang
 */
@Service(version = "1.0.0")
@Component
@Slf4j
public class SaasMdmPublicAreaFacade implements SaasMdmPublicAreaClient {

    @Autowired
    private ISaasMdmPublicAreaService iSaasMdmPublicAreaService;

    @Override
    public List<MdmPublicAreaDTO> queryByKeywords(MdmPublicAreaQuery query) {
        return iSaasMdmPublicAreaService.queryByKeywords(query);
    }

    @Override
    public RpcResult<List<MdmPublicAreaDTO>> list(MdmPublicAreaQuery query) {
        return RpcResult.success(iSaasMdmPublicAreaService.queryByKeywords(query));
    }

    @Override
    public RpcResult<List<MdmPublicAreaDTO>> queryByAreaIds(List<Integer> areaIds) {
        if (CollectionUtils.isEmpty(areaIds)) {
            return RpcResult.error(-1, "areaIds不能为空。");
        }
        return RpcResult.success(iSaasMdmPublicAreaService.queryByAreaIds(areaIds));
    }
}
