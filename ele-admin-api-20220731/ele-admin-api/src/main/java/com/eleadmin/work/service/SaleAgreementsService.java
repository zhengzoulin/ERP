package com.eleadmin.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.work.entity.SaleAgreements;
import com.eleadmin.work.param.SaleAgreementsParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-25 09:20:42
 */
public interface SaleAgreementsService extends IService<SaleAgreements> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<SaleAgreements>
     */
    PageResult<SaleAgreements> pageRel(SaleAgreementsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<SaleAgreements>
     */
    List<SaleAgreements> listRel(SaleAgreementsParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return SaleAgreements
     */
    SaleAgreements getByIdRel(Integer id);

}
