package com.eleadmin.cartest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.cartest.entity.Driver;
import com.eleadmin.cartest.param.DriverParam;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

public interface DriverService extends IService<Driver> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Driver>
     */
    PageResult<Driver> pageRel(DriverParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Driver>
     */
    List<Driver> listRel(DriverParam param);

    /**
     * 根据id查询
     *
     * @param id
     * @return Driver
     */
    Driver getByIdRel(Integer id);
    List<Driver> findByCondition(String driverNumber, String driverName);

}
