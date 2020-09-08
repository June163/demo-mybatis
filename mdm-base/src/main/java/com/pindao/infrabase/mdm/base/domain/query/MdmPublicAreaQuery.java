package com.pindao.infrabase.mdm.base.domain.query;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: wangyongkang
 */
@Setter
@Getter
@ToString
@ApiModel(value = "搜索区域入参")
public class MdmPublicAreaQuery implements Serializable {
    private String keywords;
    private Byte areaDepths = 0;
    private Integer parentAreaID;
    private Integer areaId;
    private String countryAbbreviation;
}
