package com.eleadmin.cartest.service.impl.controller;

import com.eleadmin.cartest.entity.Car;
import com.eleadmin.cartest.param.CarParam;
import com.eleadmin.cartest.service.CarService;

import com.eleadmin.common.core.annotation.OperationLog;
import com.eleadmin.common.core.web.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "管理")
@RestController
@RequestMapping("/api/test/car")
public class CarController extends BaseController {
    @Resource
    private CarService carService;
//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Car>> page(CarParam param) {
        PageParam<Car, CarParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(carService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(bookService.pageRel(param));
    }


//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("查询全部罐车")
    @GetMapping("/findGcars")
    public ApiResult<List<Car>> list1(CarParam param) {
        System.out.println("ssssssssssssssssssssssssss");
        PageParam<Car, CarParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
//        return success(carService.list(page.getOrderWrapper()));
        // 使用关联查询
        return success(carService.list1Rel(param));
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("查询全部泵车")
    @GetMapping("/findBcars")
    public ApiResult<List<Car>> list2(CarParam param) {
        PageParam<Car, CarParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
//        return success(carService.list(page.getOrderWrapper()));
        // 使用关联查询
        return success(carService.list2Rel(param));
    }


//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("根据id查询罐车")
    @GetMapping("/findByCondition1/{cId}/{cName}")
    public List<Car> findByCondition1(@PathVariable("cName") String cName, @PathVariable("cId") String cId){
        return carService.findByCondition1(cName,cId);
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("根据id查询泵车")
    @GetMapping("/findByCondition2/{cId}/{cName}")
    public List<Car> findByCondition2(@PathVariable("cName") String cName, @PathVariable("cId") String cId){
        return carService.findByCondition2(cName,cId);
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("添加")
    @PutMapping("/addCar")
    public ApiResult<?> save(@RequestBody Car car) {
        System.out.println("car:"+car);
        if (carService.save(car)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping("/updateCar")
    public ApiResult<?> update(@RequestBody Car car) {
        if (carService.updateById(car)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/deleteCar/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (carService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Car> list) {
        if (carService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Car> batchParam) {
        if (batchParam.update(carService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('test:car:list')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (carService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}