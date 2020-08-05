package com.pindao.infrabase.mdm.base.rpcclient;

import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;

import java.util.List;

/**
 * @author: wangyongkang
 */
public interface SaasMdmPublicAreaClient {

    /**
     * 搜索区域
     *
     * @param query
     * @return
     */
    List<MdmPublicAreaDTO> queryByKeywords(MdmPublicAreaQuery query);
}
