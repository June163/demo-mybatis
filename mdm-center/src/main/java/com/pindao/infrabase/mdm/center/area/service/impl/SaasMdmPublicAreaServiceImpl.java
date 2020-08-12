package com.pindao.infrabase.mdm.center.area.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pindao.infrabase.mdm.base.domain.dto.MdmPublicAreaDTO;
import com.pindao.infrabase.mdm.base.domain.query.MdmPublicAreaQuery;
import com.pindao.infrabase.mdm.center.area.domain.model.SaasMdmPublicArea;
import com.pindao.infrabase.mdm.center.area.mapper.SaasMdmPublicAreaMapper;
import com.pindao.infrabase.mdm.center.area.service.ISaasMdmPublicAreaService;
import com.pindao.infrabase.mdm.common.utils.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangyongkang
 * @since 2020-08-05
 */
@Service
@Slf4j
public class SaasMdmPublicAreaServiceImpl extends ServiceImpl<SaasMdmPublicAreaMapper, SaasMdmPublicArea> implements ISaasMdmPublicAreaService {

    @Autowired
    private SaasMdmPublicAreaMapper mdmPublicAreaMapper;

    @Override
    public List<MdmPublicAreaDTO> queryByKeywords(MdmPublicAreaQuery query) {
        log.trace("trace log");
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");

        LambdaQueryWrapper<SaasMdmPublicArea> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ObjectUtils.isNotEmpty(query.getAreaId()), SaasMdmPublicArea::getAreaId, query.getAreaId())
                .eq(ObjectUtils.isNotEmpty(query.getParentAreaID()), SaasMdmPublicArea::getParentAreaId, query.getParentAreaID());
        /**
         * 判断是否有模糊查询
         */
        if (StringUtils.isNotEmpty(query.getKeywords())) {
            wrapper.and(Wrapper -> Wrapper
                    .like(SaasMdmPublicArea::getAreaName, query.getKeywords()).or()
                    .like(SaasMdmPublicArea::getAreaCode, query.getKeywords()).or()
                    .like(SaasMdmPublicArea::getZipCode, query.getKeywords()));
        }
        List<SaasMdmPublicArea> saasMdmPublicAreas = mdmPublicAreaMapper.selectList(wrapper);
        return saasMdmPublicAreas.stream().map(saasMdmPublicArea -> {
            MdmPublicAreaDTO mdmPublicAreaDTO = new MdmPublicAreaDTO();
            BeanUtils.copyProperties(saasMdmPublicArea, mdmPublicAreaDTO);
            /**
             * 遍历每一条记录，递归查询下一级
             */
            querySubList(mdmPublicAreaDTO, (byte) (mdmPublicAreaDTO.getAreaDepths() + query.getAreaDepths()));
            return mdmPublicAreaDTO;
        }).collect(Collectors.toList());
    }

    public void querySubList(MdmPublicAreaDTO mdmPublicAreaDTO, Byte depth) {
        /**
         * 当前记录的 subAreaList 为 空 说明没有下级
         * 否则，需要递归查询下级
         */
        if (mdmPublicAreaDTO.getAreaDepths() < depth) {
            List<SaasMdmPublicArea> subAreaList = mdmPublicAreaMapper
                    .selectByMap(
                            Collections.singletonMap("parent_area_id", mdmPublicAreaDTO.getAreaId())
                    );
            mdmPublicAreaDTO.setList(ListUtil.convertModelToDto(subAreaList, MdmPublicAreaDTO.class));
            if (CollectionUtils.isEmpty(mdmPublicAreaDTO.getList())) {
                return;
            }
            mdmPublicAreaDTO.getList().stream().forEach(subArea -> querySubList(subArea, depth));
        }
    }
}
