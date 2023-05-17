package com.eleadmin.cartest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.cartest.entity.Car;
import com.eleadmin.cartest.entity.Driver;
import com.eleadmin.cartest.param.CarParam;
import com.eleadmin.cartest.param.DriverParam;
import com.eleadmin.common.core.web.PageResult;

import java.util.List;

public interface CarService extends IService<Car> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Car>
     */
    PageResult<Car> pageRel(CarParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Driver>
     */


    //罐车查询
    List<Car> list1Rel(CarParam param);

    //泵车查询
    List<Car> list2Rel(CarParam param);

    /**
     * 根据id查询
     *
     * @param id
     * @return Driver
     */
    Car getByIdRel(Integer id);

    List<Car> findByCondition1(String cName, String cId);

    List<Car> findByCondition2(String cName, String cId);
}
