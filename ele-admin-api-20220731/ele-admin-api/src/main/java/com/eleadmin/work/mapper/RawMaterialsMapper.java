package com.eleadmin.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.work.entity.RawMaterials;
import com.eleadmin.work.param.RawMaterialsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
public interface RawMaterialsMapper extends BaseMapper<RawMaterials> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<RawMaterials>
     */
    List<RawMaterials> selectPageRel(@Param("page") IPage<RawMaterials> page,
                             @Param("param") RawMaterialsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<RawMaterials> selectListRel(@Param("param") RawMaterialsParam param);

}
