package com.eleadmin.work.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.work.service.EngineeringService;
import com.eleadmin.work.entity.Engineering;
import com.eleadmin.work.param.EngineeringParam;
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
import java.util.List;

/**
 * 控制器
 *
 * @author EleAdmin
 * @since 2023-05-26 22:15:37
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/work/engineering")
public class EngineeringController extends BaseController {
    @Resource
    private EngineeringService engineeringService;

    @PreAuthorize("hasAuthority('work:engineering:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<Engineering>> page(EngineeringParam param) {
        PageParam<Engineering, EngineeringParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(engineeringService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(engineeringService.pageRel(param));
    }

    @PreAuthorize("hasAuthority('work:engineering:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<Engineering>> list(EngineeringParam param) {
        PageParam<Engineering, EngineeringParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(engineeringService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(engineeringService.listRel(param));
    }

    @PreAuthorize("hasAuthority('work:engineering:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<Engineering> get(@PathVariable("id") Integer id) {
        return success(engineeringService.getById(id));
        // 使用关联查询
        //return success(engineeringService.getByIdRel(id));
    }

    @PreAuthorize("hasAuthority('work:engineering:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody Engineering engineering) {
        if (engineeringService.save(engineering)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('work:engineering:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody Engineering engineering) {
        if (engineeringService.updateById(engineering)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('work:engineering:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (engineeringService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

    @PreAuthorize("hasAuthority('work:engineering:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<Engineering> list) {
        if (engineeringService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

    @PreAuthorize("hasAuthority('work:engineering:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<Engineering> batchParam) {
        if (batchParam.update(engineeringService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

    @PreAuthorize("hasAuthority('work:engineering:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (engineeringService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
