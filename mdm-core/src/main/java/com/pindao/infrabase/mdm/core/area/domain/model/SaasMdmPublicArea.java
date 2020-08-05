package com.pindao.infrabase.mdm.core.area.domain.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author wangyongkang
 * @since 2020-08-05
 */
@Setter
@Getter
@TableName(value = "saas_mdm_public_area")
public class SaasMdmPublicArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区ID
     */
    @TableId
    private Integer areaId;

    /**
     * 上级区域ID
     */
    private Integer parentAreaId;

    /**
     * 地区名称
     */
    private String areaName;

    /**
     * 完整名称，包括上级名称.从省份开始的完整名称，用|进行隔开“，例广东省|深圳市|福田区
     */
    private String fullName;

    /**
     * 1层-国家 2层-省，3层-地城市，4层-县、县级市、区
     */
    private Byte areaDepths;

    /**
     * 例如：北京市：BeiJing
     */
    private String areaSimplePinyin;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 排序，数字越大越靠前
     */
    private Integer areaSort;

    /**
     * 国际域名缩写
     */
    private String countryAbbreviation;

    /**
     * 国际域名缩写
     */
    private String countryName;

    /**
     * 英文简称
     */
    private String countryEnglishName;

    /**
     * 国家电话代码
     */
    private String countryPhoneCode;


}
