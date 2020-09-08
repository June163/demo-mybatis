package com.pindao.infrabase.mdm.base.rpcclient;

import com.pindao.common.sdk.domain.vo.RpcResult;
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
     * @param query 参数
     * @return: 区域集合
     * @description: 这个方法已被弃用，请使用最新的方法 list，在后面的版本不再更新。
     */
    @Deprecated
    List<MdmPublicAreaDTO> queryByKeywords(MdmPublicAreaQuery query);

    /**
     * 搜索区域
     *
     * @param query 参数
     * @return: 区域集合，根据 code 判断此次请求是否成功，0表示成功，其它表示失败。
     */
    RpcResult<List<MdmPublicAreaDTO>> list(MdmPublicAreaQuery query);
}
