package com.eleadmin.cartest.service.impl.controller;

import com.eleadmin.cartest.entity.Driver;
import com.eleadmin.cartest.param.DriverParam;
import com.eleadmin.cartest.service.DriverService;
import com.eleadmin.common.core.annotation.OperationLog;
import com.eleadmin.common.core.web.*;
import com.eleadmin.common.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@Api(tags = "管理")
@RestController
@RequestMapping("/api/test/driver")
public class DriverController extends BaseController {
    @Resource
    private DriverService driverService;
//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Driver>> page(DriverParam param) {
        PageParam<Driver, DriverParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(driverService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(bookService.pageRel(param));
    }


//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping("/findAllDrivers")
    public ApiResult<List<Driver>> list(DriverParam param) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        PageParam<Driver, DriverParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(driverService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(bookService.listRel(param));
    }

    ///////////////////

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/findByCondition/{driverNumber}/{driverName}")
    public List<Driver> findByCondition(@PathVariable("driverNumber") String driverNumber, @PathVariable("driverName") String driverName){
        return driverService.findByCondition(driverNumber,driverName);
    }

    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("添加")
    @PutMapping("/addDriver")
    public ApiResult<?> save(@RequestBody Driver driver) {
        System.out.println("driver:"+driver);
        if (driverService.save(driver)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateDriver")
    public ApiResult<?> update(@RequestBody Driver driver) {
        if (driverService.updateById(driver)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteDriver/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (driverService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Driver> list) {
        if (driverService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Driver> batchParam) {
        if (batchParam.update(driverService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (driverService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('test:driver:list')")
    @OperationLog
    @ApiOperation("修改用户状态")
    @PutMapping("/status")
    public ApiResult<?> updateStatus(@RequestBody Driver driver) {
        if (driver.getDriverNumber() == null || driver.getDriverStatus() == null || !Arrays.asList(0, 1).contains(driver.getDriverStatus())) {
            return fail("参数不正确");
        }
        Driver u = new Driver();
        u.setDriverNumber(driver.getDriverNumber());
        u.setDriverStatus(driver.getDriverStatus());
        if (driverService.updateById(u)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

}
