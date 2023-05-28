package com.eleadmin.work.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.work.entity.RawMaterials;
import com.eleadmin.work.service.CustomerService;
import com.eleadmin.work.entity.Customer;
import com.eleadmin.work.param.CustomerParam;
import com.eleadmin.common.core.web.ApiResult;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.BatchParam;
import com.eleadmin.common.core.annotation.OperationLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-05-24 14:27:13
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/work/customer")
public class CustomerController extends BaseController {
    @Resource
    private CustomerService customerService;

    //    @PreAuthorize("hasAuthority('work:customer:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Customer>> page(CustomerParam param) {
        PageParam<Customer, CustomerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(customerService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(customerService.pageRel(param));
    }

    //    @PreAuthorize("hasAuthority('work:customer:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<Customer>> list(CustomerParam param) {
        PageParam<Customer, CustomerParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(customerService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(customerService.listRel(param));
    }

    //    @PreAuthorize("hasAuthority('work:customer:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Customer> get(@PathVariable("id") Integer id) {
        return success(customerService.getById(id));
        // 使用关联查询
        //return success(customerService.getByIdRel(id));
    }

    //    @PreAuthorize("hasAuthority('work:customer:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Customer customer) {
        if (customerService.save(customer)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    //    @PreAuthorize("hasAuthority('work:customer:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody Customer customer) {
        if (customerService.updateById(customer)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    //    @PreAuthorize("hasAuthority('work:customer:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (customerService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    //    @PreAuthorize("hasAuthority('work:customer:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Customer> list) {
        if (customerService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    //    @PreAuthorize("hasAuthority('work:customer:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Customer> batchParam) {
        if (batchParam.update(customerService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    //    @PreAuthorize("hasAuthority('work:customer:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (customerService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }
}
//    @OperationLog
//    @ApiOperation("修改原材料状态")
//    @PutMapping("/status")
//    public ApiResult<?> updateStatus(@RequestBody RawMaterials rawMaterials) {
//        if (rawMaterials.getId() == null || rawMaterials.getStatus() == null || !Arrays.asList(0, 1).contains(rawMaterials.getStatus())) {
//            return fail("参数不正确");
//        }
//        RawMaterials R=new RawMaterials();
//        R.setId(rawMaterials.getId());
//        R.setStatus(rawMaterials.getStatus());
//        if(rawMaterialsService.updateById(R)){
//            return success("修改成功");
//        }
//        return fail("修改失败");
//
//    }
