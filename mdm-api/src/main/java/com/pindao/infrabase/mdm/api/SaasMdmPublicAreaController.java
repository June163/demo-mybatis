package com.pindao.infrabase.mdm.api;


import com.alibaba.dubbo.config.annotation.Reference;
import com.pindao.common.sdk.domain.vo.ApiResult;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaFuzzyQuery;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaTermQuery;
import com.pindao.infrabase.mdm.base.rpcclient.SaasMdmPublicAreaClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangyongkang
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/publicArea")
@Api(tags = "国家省市区接口")
public class SaasMdmPublicAreaController {

    @Reference(version = "1.0.0", url = "dubbo://192.168.203.72:20880")
    private SaasMdmPublicAreaClient saasMdmPublicAreaClient;

    @ApiOperation(value = "搜索区域")
    @PostMapping("/queryByKeywords")
    public ApiResult<List<MdmPublicAreaDTO>> queryByKeywords(@Validated @RequestBody MdmPublicAreaFuzzyQuery query) {
        MdmPublicAreaQuery mdmPublicAreaQuery = new MdmPublicAreaQuery();
        BeanUtils.copyProperties(query, mdmPublicAreaQuery);
        return ApiResult.success(saasMdmPublicAreaClient.queryByKeywords(mdmPublicAreaQuery));
    }

    @ApiOperation(value = "查询区域")
    @PostMapping("/queryByAreaId")
    public ApiResult<List<MdmPublicAreaDTO>> queryByAreaId(@Validated @RequestBody MdmPublicAreaTermQuery query) {
        MdmPublicAreaQuery mdmPublicAreaQuery = new MdmPublicAreaQuery();
        BeanUtils.copyProperties(query, mdmPublicAreaQuery);
        return ApiResult.success(saasMdmPublicAreaClient.queryByKeywords(mdmPublicAreaQuery));
    }
}
