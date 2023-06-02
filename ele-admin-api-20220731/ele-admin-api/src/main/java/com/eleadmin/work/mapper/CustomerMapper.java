package com.eleadmin.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.work.entity.Customer;
import com.eleadmin.work.param.CustomerParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-05-24 14:27:13
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Customer>
     */
    List<Customer> selectPageRel(@Param("page") IPage<Customer> page,
                                 @Param("param") CustomerParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Customer> selectListRel(@Param("param") CustomerParam param);

}
