package com.eleadmin.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.work.entity.Customer;
import com.eleadmin.work.param.CustomerParam;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-05-24 14:27:13
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Customer>
     */
    PageResult<Customer> pageRel(CustomerParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Customer>
     */
    List<Customer> listRel(CustomerParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Customer
     */
    Customer getByIdRel(Integer id);

}
