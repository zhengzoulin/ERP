package com.eleadmin.work.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.common.system.entity.Role;
import com.eleadmin.common.system.param.RoleParam;
import com.eleadmin.work.dto.RawMSDto;
import com.eleadmin.work.entity.RawMaterials;
import com.eleadmin.work.service.RawMaterialSupplierService;
import com.eleadmin.work.entity.RawMaterialSupplier;
import com.eleadmin.work.param.RawMaterialSupplierParam;
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
 * @since 2023-04-26 16:05:57
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/work/raw-material-supplier")
public class RawMaterialSupplierController extends BaseController {
    @Resource
    private RawMaterialSupplierService rawMaterialSupplierService;

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<RawMaterialSupplier>> page(RawMaterialSupplierParam param) {
        PageParam<RawMaterialSupplier, RawMaterialSupplierParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(rawMaterialSupplierService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(rawMaterialSupplierService.pageRel(param));
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<RawMaterialSupplier>> list(RawMaterialSupplierParam param) {
        PageParam<RawMaterialSupplier, RawMaterialSupplierParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(rawMaterialSupplierService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(rawMaterialSupplierService.listRel(param));
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<RawMaterialSupplier> get(@PathVariable("id") Integer id) {
        return success(rawMaterialSupplierService.getById(id));
        // 使用关联查询
        //return success(rawMaterialSupplierService.getByIdRel(id));
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody RawMaterialSupplier rawMaterialSupplier) {
        if (rawMaterialSupplierService.save(rawMaterialSupplier)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody RawMaterialSupplier rawMaterialSupplier) {
        if (rawMaterialSupplierService.updateById(rawMaterialSupplier)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (rawMaterialSupplierService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<RawMaterialSupplier> list) {
        if (rawMaterialSupplierService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<RawMaterialSupplier> batchParam) {
        if (batchParam.update(rawMaterialSupplierService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }
    //    @PreAuthorize("hasAuthority('sys:user:update')")
    @OperationLog
    @ApiOperation("修改供应商状态")
    @PutMapping("/status")
    public ApiResult<?> updateStatus(@RequestBody RawMaterialSupplier rawMaterialSupplier) {
        if (rawMaterialSupplier.getId() == null || rawMaterialSupplier.getStatus() == null || !Arrays.asList(0, 1).contains(rawMaterialSupplier.getStatus())) {
            return fail("参数不正确");
        }
        RawMaterialSupplier R = new RawMaterialSupplier();
        R.setId(rawMaterialSupplier.getId());
        R.setStatus(rawMaterialSupplier.getStatus());
        if (rawMaterialSupplierService.updateById(R)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }
//    @PreAuthorize("hasAuthority('work:rawMaterialSupplier:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (rawMaterialSupplierService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @OperationLog
    @ApiOperation("查询原材料")
    @GetMapping("/find/{id}")
    public ApiResult<List<RawMaterialSupplier>> findRm(@PathVariable("id") Integer id){

        return success(rawMaterialSupplierService.getRmByid2(id));

    }

    @OperationLog
    @ApiOperation("删除原材料")
    @DeleteMapping("/deleteRR/{rrId}")
    public ApiResult<?> removeRR(@PathVariable("rrId") int rrId) {

        if (rawMaterialSupplierService.deleteRMById(rrId)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }
    //查询所有数据
    @GetMapping("/unitNames")
    public ApiResult findAllUnitNames(){
        QueryWrapper<RawMaterialSupplier> queryWrapper = new QueryWrapper<>();

        return success(rawMaterialSupplierService.list());
    }

    @OperationLog
    @ApiOperation("供应商添加原材料")
    @GetMapping("/addSupplyRaw/{supplyId}/{RawId}")
    public ApiResult<?> addSupplyRaw(@PathVariable("supplyId") Integer supplyId,
                                     @PathVariable("RawId") Integer RawId) {

        int supplyId1=supplyId;
        int RawId1=RawId;
        System.out.println("1:"+supplyId1+"   2:"+RawId1);
        if (rawMaterialSupplierService.addSupplyRaw(supplyId1,RawId1)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }



}
