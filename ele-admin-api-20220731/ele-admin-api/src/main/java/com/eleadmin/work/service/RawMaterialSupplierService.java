package com.eleadmin.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.work.dto.RawMSDto;
import com.eleadmin.work.entity.RawMaterialSupplier;
import com.eleadmin.work.param.RawMaterialSupplierParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
public interface RawMaterialSupplierService extends IService<RawMaterialSupplier> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<RawMaterialSupplier>
     */
    PageResult<RawMaterialSupplier> pageRel(RawMaterialSupplierParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<RawMaterialSupplier>
     */
    List<RawMaterialSupplier> listRel(RawMaterialSupplierParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return RawMaterialSupplier
     */
    RawMaterialSupplier getByIdRel(Integer id);

    List<RawMSDto> getRmByid(int id);

    List<RawMaterialSupplier> getRmByid2(int id);

    boolean deleteRMById(int rrId);
}
