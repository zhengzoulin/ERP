package com.eleadmin.work.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.common.system.entity.User;
import com.eleadmin.work.service.RawMaterialsService;
import com.eleadmin.work.entity.RawMaterials;
import com.eleadmin.work.param.RawMaterialsParam;
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
@RequestMapping("/api/work/raw-materials")
public class RawMaterialsController extends BaseController {
    @Resource
    private RawMaterialsService rawMaterialsService;

//    @PreAuthorize("hasAuthority('work:rawMaterials:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<RawMaterials>> page(RawMaterialsParam param) {
        PageParam<RawMaterials, RawMaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(rawMaterialsService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(rawMaterialsService.pageRel(param));
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<RawMaterials>> list(RawMaterialsParam param) {
        PageParam<RawMaterials, RawMaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(rawMaterialsService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(rawMaterialsService.listRel(param));
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<RawMaterials> get(@PathVariable("id") Integer id) {
        return success(rawMaterialsService.getById(id));
        // 使用关联查询
        //return success(rawMaterialsService.getByIdRel(id));
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody RawMaterials rawMaterials) {
        if (rawMaterialsService.save(rawMaterials)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody RawMaterials rawMaterials) {
        if (rawMaterialsService.updateById(rawMaterials)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (rawMaterialsService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<RawMaterials> list) {
        if (rawMaterialsService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<RawMaterials> batchParam) {
        if (batchParam.update(rawMaterialsService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:rawMaterials:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (rawMaterialsService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('sys:user:update')")
    @OperationLog
    @ApiOperation("修改原材料状态")
    @PutMapping("/status")
    public ApiResult<?> updateStatus(@RequestBody RawMaterials rawMaterials) {
        if (rawMaterials.getId() == null || rawMaterials.getStatus() == null || !Arrays.asList(0, 1).contains(rawMaterials.getStatus())) {
            return fail("参数不正确");
        }
        RawMaterials R=new RawMaterials();
        R.setId(rawMaterials.getId());
        R.setStatus(rawMaterials.getStatus());
        if(rawMaterialsService.updateById(R)){
            return success("修改成功");
        }
        return fail("修改失败");


//        if (user.getUserId() == null || user.getStatus() == null || !Arrays.asList(0, 1).contains(user.getStatus())) {
//            return fail("参数不正确");
//        }
//        User u = new User();
//        u.setUserId(user.getUserId());
//        u.setStatus(user.getStatus());
//        if (userService.updateById(u)) {
//            return success("修改成功");
//        }
//        return fail("修改失败");
    }



}
