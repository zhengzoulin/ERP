package com.eleadmin.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.work.entity.Engineering;
import com.eleadmin.work.param.EngineeringParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-26 22:15:37
 */
public interface EngineeringMapper extends BaseMapper<Engineering> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Engineering>
     */
    List<Engineering> selectPageRel(@Param("page") IPage<Engineering> page,
                             @Param("param") EngineeringParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Engineering> selectListRel(@Param("param") EngineeringParam param);

}
