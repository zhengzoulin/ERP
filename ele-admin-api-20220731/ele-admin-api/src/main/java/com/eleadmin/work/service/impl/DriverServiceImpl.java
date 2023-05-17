package com.eleadmin.cartest.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.cartest.entity.Driver;
import com.eleadmin.cartest.mapper.DriverMapper;
import com.eleadmin.cartest.param.DriverParam;
import com.eleadmin.cartest.service.DriverService;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements DriverService {
    @Autowired
    private DriverMapper driverMapper;

    @Override
    public PageResult<Driver> pageRel(DriverParam param) {
        PageParam<Driver, DriverParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Driver> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Driver> listRel(DriverParam param) {
        List<Driver> list = baseMapper.selectListRel(param);
        // 排序
        System.out.println(list);
        PageParam<Driver, DriverParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Driver getByIdRel(Integer id) {
        DriverParam param = new DriverParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Driver> findByCondition(String driverNumber, String driverName) {
        return driverMapper.findByCondition(driverNumber,driverName);
    }
}
