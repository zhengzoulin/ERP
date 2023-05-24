package com.eleadmin.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.work.entity.RawMaterials;
import com.eleadmin.work.param.RawMaterialsParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
public interface RawMaterialsService extends IService<RawMaterials> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<RawMaterials>
     */
    PageResult<RawMaterials> pageRel(RawMaterialsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<RawMaterials>
     */
    List<RawMaterials> listRel(RawMaterialsParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return RawMaterials
     */
    RawMaterials getByIdRel(Integer id);



}
