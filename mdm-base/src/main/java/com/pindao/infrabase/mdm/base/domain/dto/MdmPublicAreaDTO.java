package com.pindao.infrabase.mdm.base.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: wangyongkang
 */
@Setter
@Getter
@ApiModel(value = "搜索区域列表")
@ToString
public class MdmPublicAreaDTO implements Serializable {

    @ApiModelProperty(value = "地区ID", example = "5099")
    private Integer areaId;

    @ApiModelProperty(value = "上级区域ID", example = "5099")
    private Integer parentAreaId;

    @ApiModelProperty(value = "地区名称", example = "阜新市")
    private String areaName;

    @ApiModelProperty(value = "完整名称，包括上级名称.从省份开始的完整名称，用|进行隔开“，例广东省|深圳市|福田区", example = "广东省|深圳市|福田区")
    private String fullName;

    @ApiModelProperty(value = " 1层-国家 2层-省，3层-地城市，4层-县、县级市、区", example = "1")
    private Byte areaDepths;

    @ApiModelProperty(value = "区号", example = "0418")
    private String areaCode;

    @ApiModelProperty(value = "邮政编码", example = "123000")
    private String zipCode;

    @ApiModelProperty(value = "经度", example = "121.648962")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度", example = "42.011796")
    private BigDecimal latitude;

    @ApiModelProperty(value = "下一级数据", example = "list类型")
    private List<MdmPublicAreaDTO> list;
}
