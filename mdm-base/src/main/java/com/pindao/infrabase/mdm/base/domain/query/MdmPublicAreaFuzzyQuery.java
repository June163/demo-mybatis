package com.pindao.infrabase.mdm.base.domain.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: wangyongkang
 */
@Setter
@Getter
@ToString
@ApiModel(value = "搜索区域入参")
public class MdmPublicAreaFuzzyQuery implements Serializable {

    @ApiModelProperty(value = "keywords支持areaName、areaCode、zipCode这三个字体的搜索", example = "北|001|123000")
    private String keywords;

    @ApiModelProperty(value = "搜索指定areaID下区域第几层数据，默认为1，目前最大2层", example = "1")
    @Max(value = 2, message = "areaDepths范围0~2")
    @Min(value = 0, message = "areaDepths范围0~2")
    private Byte areaDepths = 1;

    @ApiModelProperty(value = "搜索指定areaID下区域", example = "1")
    @NotNull(message = "parentAreaID不能为空")
    private Integer parentAreaID;

    @ApiModelProperty(value = "国际域名缩写，US-美国，JPN-日本，CN-中国", example = "CN")
    private String countryAbbreviation;
}
