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

    @ApiModelProperty(value = "搜索指定areaID下区域第几层数据，默认为1，目前最大4层，大于按4处理", example = "1")
    @NotNull(message = "areaDepths范围1~4")
    @Max(4)
    @Min(1)
    private Byte areaDepths = 1;

    @ApiModelProperty(value = "查询指定areaID下区域", example = "210900")
    private Integer areaId;
}
