package com.eleadmin.work.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.work.service.SaleAgreementsService;
import com.eleadmin.work.entity.SaleAgreements;
import com.eleadmin.work.param.SaleAgreementsParam;
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
 * @since 2023-05-25 09:20:42
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/work/sale-agreements")
public class SaleAgreementsController extends BaseController {
    @Resource
    private SaleAgreementsService saleAgreementsService;

//    @PreAuthorize("hasAuthority('work:saleAgreements:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<SaleAgreements>> page(SaleAgreementsParam param) {
        PageParam<SaleAgreements, SaleAgreementsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(saleAgreementsService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(saleAgreementsService.pageRel(param));
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<SaleAgreements>> list(SaleAgreementsParam param) {
        PageParam<SaleAgreements, SaleAgreementsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(saleAgreementsService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(saleAgreementsService.listRel(param));
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<SaleAgreements> get(@PathVariable("id") Integer id) {
        return success(saleAgreementsService.getById(id));
        // 使用关联查询
        //return success(saleAgreementsService.getByIdRel(id));
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody SaleAgreements saleAgreements) {
        if (saleAgreementsService.save(saleAgreements)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody SaleAgreements saleAgreements) {
        if (saleAgreementsService.updateById(saleAgreements)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (saleAgreementsService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<SaleAgreements> list) {
        if (saleAgreementsService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<SaleAgreements> batchParam) {
        if (batchParam.update(saleAgreementsService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:saleAgreements:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (saleAgreementsService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
