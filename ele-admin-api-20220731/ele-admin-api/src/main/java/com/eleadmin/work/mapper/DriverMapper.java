package com.eleadmin.cartest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.cartest.entity.Driver;
import com.eleadmin.cartest.param.DriverParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverMapper extends BaseMapper<Driver> {
    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Driver>
     */
    List<Driver> selectPageRel(@Param("page") IPage<Driver> page,
                               @Param("param") DriverParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Driver> selectListRel(@Param("param") DriverParam param);

    List<Driver> findByCondition(@Param("driverNumber")String driver_number, @Param("driverName")String driver_name);
}
