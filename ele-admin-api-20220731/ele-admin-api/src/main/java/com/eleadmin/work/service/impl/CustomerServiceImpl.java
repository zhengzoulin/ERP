package com.eleadmin.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.work.mapper.CustomerMapper;
import com.eleadmin.work.service.CustomerService;
import com.eleadmin.work.entity.Customer;
import com.eleadmin.work.param.CustomerParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-24 14:27:13
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public PageResult<Customer> pageRel(CustomerParam param) {
        PageParam<Customer, CustomerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Customer> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Customer> listRel(CustomerParam param) {
        List<Customer> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Customer, CustomerParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Customer getByIdRel(Integer id) {
        CustomerParam param = new CustomerParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
