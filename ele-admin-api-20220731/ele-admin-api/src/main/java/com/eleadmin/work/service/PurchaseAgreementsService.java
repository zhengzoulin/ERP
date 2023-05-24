package com.eleadmin.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.work.entity.PurchaseAgreements;
import com.eleadmin.work.param.PurchaseAgreementsParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-14 17:23:22
 */
public interface PurchaseAgreementsService extends IService<PurchaseAgreements> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<PurchaseAgreements>
     */
    PageResult<PurchaseAgreements> pageRel(PurchaseAgreementsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<PurchaseAgreements>
     */
    List<PurchaseAgreements> listRel(PurchaseAgreementsParam param);

    /**
     * 根据id查询
     *
     * @param id
     * @return PurchaseAgreements
     */
    PurchaseAgreements getByIdRel(Integer id);

    String getUnitNameById(int id);

    String getRMNameById(int id);
}
