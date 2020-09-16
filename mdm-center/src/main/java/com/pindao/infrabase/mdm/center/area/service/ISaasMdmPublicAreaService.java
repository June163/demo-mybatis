package com.pindao.infrabase.mdm.center.area.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.center.area.domain.model.SaasMdmPublicArea;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangyongkang
 * @since 2020-08-05
 */
public interface ISaasMdmPublicAreaService extends IService<SaasMdmPublicArea> {

    List<MdmPublicAreaDTO> queryByKeywords(MdmPublicAreaQuery query);

    List<MdmPublicAreaDTO> queryByAreaIds(List<Integer> areaIds);
}
