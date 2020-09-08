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
@ApiModel(value = "查询区域入参")
@Setter
@Getter
@ToString
public class MdmPublicAreaTermQuery implements Serializable {

    @ApiModelProperty(value = "搜索指定areaID下区域第几层数据，默认为1，目前最大3层", example = "1")
    @Max(value = 3, message = "areaDepths范围0~3")
    @Min(value = 0, message = "areaDepths范围0~3")
    private Byte areaDepths = 1;

    @ApiModelProperty(value = "查询指定areaID下区域", example = "210900")
    @NotNull(message = "areaId不能为空")
    private Integer areaId;

    @ApiModelProperty(value = "国际域名缩写，US-美国，JPN-日本，CN-中国", example = "CN")
    private String countryAbbreviation;
}
