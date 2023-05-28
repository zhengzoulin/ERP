package com.eleadmin.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.work.dto.RawMSDto;
import com.eleadmin.work.entity.RawMaterialSupplier;
import com.eleadmin.work.param.RawMaterialSupplierParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
public interface RawMaterialSupplierMapper extends BaseMapper<RawMaterialSupplier> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<RawMaterialSupplier>
     */
    List<RawMaterialSupplier> selectPageRel(@Param("page") IPage<RawMaterialSupplier> page,
                             @Param("param") RawMaterialSupplierParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<RawMaterialSupplier> selectListRel(@Param("param") RawMaterialSupplierParam param);

    List<RawMSDto> getRMByid(int id);

    List<RawMaterialSupplier> getRMByid2(int id);

    int deleteRMById(int rrId);
    int addSupplyRaw(int rmsId, int rmId);
}
