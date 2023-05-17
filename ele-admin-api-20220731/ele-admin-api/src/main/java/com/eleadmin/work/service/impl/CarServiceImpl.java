package com.eleadmin.cartest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.cartest.entity.Car;
import com.eleadmin.cartest.mapper.CarMapper;
import com.eleadmin.cartest.param.CarParam;
import com.eleadmin.cartest.service.CarService;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public PageResult<Car> pageRel(CarParam param) {
        PageParam<Car, CarParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Car> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    //罐车查询
    public List<Car> list1Rel(CarParam param) {
        List<Car> list = baseMapper.selectList1Rel(param);
        // 排序
        System.out.println(list);
        PageParam<Car, CarParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    //泵车查询
    public List<Car> list2Rel(CarParam param) {
        List<Car> list = baseMapper.selectList2Rel(param);
        // 排序
        System.out.println(list);
        PageParam<Car, CarParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Car getByIdRel(Integer id) {
        CarParam param = new CarParam();
        param.setId(id);
        return param.getOne(baseMapper.selectList1Rel(param));
    }

    @Override
    public List<Car> findByCondition1(String cName, String cId) {
        return carMapper.findByCondition1(cName,cId);
    }

    @Override
    public List<Car> findByCondition2(String cName, String cId) {
        return carMapper.findByCondition2(cName,cId);
    }
}
