package com.eleadmin.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.work.entity.PurchaseAgreements;
import com.eleadmin.work.param.PurchaseAgreementsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-14 17:23:22
 */
public interface PurchaseAgreementsMapper extends BaseMapper<PurchaseAgreements> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<PurchaseAgreements>
     */
    List<PurchaseAgreements> selectPageRel(@Param("page") IPage<PurchaseAgreements> page,
                             @Param("param") PurchaseAgreementsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<PurchaseAgreements> selectListRel(@Param("param") PurchaseAgreementsParam param);

}
