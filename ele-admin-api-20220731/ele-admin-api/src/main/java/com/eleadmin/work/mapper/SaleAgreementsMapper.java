package com.eleadmin.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.work.entity.SaleAgreements;
import com.eleadmin.work.param.SaleAgreementsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-25 09:20:42
 */
public interface SaleAgreementsMapper extends BaseMapper<SaleAgreements> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<SaleAgreements>
     */
    List<SaleAgreements> selectPageRel(@Param("page") IPage<SaleAgreements> page,
                             @Param("param") SaleAgreementsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<SaleAgreements> selectListRel(@Param("param") SaleAgreementsParam param);

}
