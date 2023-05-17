package com.eleadmin.work.controller;

import com.eleadmin.common.core.web.BaseController;
import com.eleadmin.work.service.PurchaseAgreementsService;
import com.eleadmin.work.entity.PurchaseAgreements;
import com.eleadmin.work.param.PurchaseAgreementsParam;
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
 * @since 2023-05-14 17:23:22
 */
@Api(tags = "管理")
@RestController
@RequestMapping("/api/work/purchase-agreements")
public class PurchaseAgreementsController extends BaseController {
    @Resource
    private PurchaseAgreementsService purchaseAgreementsService;

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:list')")
    @OperationLog
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<PageResult<PurchaseAgreements>> page(PurchaseAgreementsParam param) {
        PageParam<PurchaseAgreements, PurchaseAgreementsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(purchaseAgreementsService.page(page, page.getWrapper()));
        // 使用关联查询
        //return success(purchaseAgreementsService.pageRel(param));
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:list')")
    @OperationLog
    @ApiOperation("查询全部")
    @GetMapping()
    public ApiResult<List<PurchaseAgreements>> list(PurchaseAgreementsParam param) {
        PageParam<PurchaseAgreements, PurchaseAgreementsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        return success(purchaseAgreementsService.list(page.getOrderWrapper()));
        // 使用关联查询
        //return success(purchaseAgreementsService.listRel(param));
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:list')")
    @OperationLog
    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public ApiResult<PurchaseAgreements> get(@PathVariable("id") Integer id) {
        return success(purchaseAgreementsService.getById(id));
        // 使用关联查询
        //return success(purchaseAgreementsService.getByIdRel(id));
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:save')")
    @OperationLog
    @ApiOperation("添加")
    @PostMapping()
    public ApiResult<?> save(@RequestBody PurchaseAgreements purchaseAgreements) {
        if (purchaseAgreementsService.save(purchaseAgreements)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:update')")
    @OperationLog
    @ApiOperation("修改")
    @PutMapping()
    public ApiResult<?> update(@RequestBody PurchaseAgreements purchaseAgreements) {
        if (purchaseAgreementsService.updateById(purchaseAgreements)) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:remove')")
    @OperationLog
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ApiResult<?> remove(@PathVariable("id") Integer id) {
        if (purchaseAgreementsService.removeById(id)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:save')")
    @OperationLog
    @ApiOperation("批量添加")
    @PostMapping("/batch")
    public ApiResult<?> saveBatch(@RequestBody List<PurchaseAgreements> list) {
        if (purchaseAgreementsService.saveBatch(list)) {
            return success("添加成功");
        }
        return fail("添加失败");
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:update')")
    @OperationLog
    @ApiOperation("批量修改")
    @PutMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody BatchParam<PurchaseAgreements> batchParam) {
        if (batchParam.update(purchaseAgreementsService, "id")) {
            return success("修改成功");
        }
        return fail("修改失败");
    }

//    @PreAuthorize("hasAuthority('work:purchaseAgreements:remove')")
    @OperationLog
    @ApiOperation("批量删除")
    @DeleteMapping("/batch")
    public ApiResult<?> removeBatch(@RequestBody List<Integer> ids) {
        if (purchaseAgreementsService.removeByIds(ids)) {
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
