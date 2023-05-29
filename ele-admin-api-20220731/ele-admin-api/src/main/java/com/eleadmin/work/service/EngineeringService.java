package com.eleadmin.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.work.entity.Engineering;
import com.eleadmin.work.param.EngineeringParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-26 22:15:37
 */
public interface EngineeringService extends IService<Engineering> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Engineering>
     */
    PageResult<Engineering> pageRel(EngineeringParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Engineering>
     */
    List<Engineering> listRel(EngineeringParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Engineering
     */
    Engineering getByIdRel(Integer id);

}
