package com.pindao.infrabase.mdm.base.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: wangyongkang
 */
@Setter
@Getter
@Builder
@ToString
public class TestDTO implements Serializable {
    private String id;
    private String name;
}
