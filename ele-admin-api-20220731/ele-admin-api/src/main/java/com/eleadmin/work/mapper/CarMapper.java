package com.eleadmin.cartest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.cartest.entity.Car;
import com.eleadmin.cartest.entity.Driver;
import com.eleadmin.cartest.param.CarParam;
import com.eleadmin.cartest.param.DriverParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper extends BaseMapper<Car> {
    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Driver>
     */
    List<Car> selectPageRel(@Param("page") IPage<Car> page,
                               @Param("param") CarParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Car> selectList1Rel(@Param("param") CarParam param);

    List<Car> selectList2Rel(@Param("param") CarParam param);

    List<Car> findByCondition1(@Param("cName")String cName, @Param("cId")String cId);

    List<Car> findByCondition2(@Param("cName")String cName, @Param("cId")String cId);

}
