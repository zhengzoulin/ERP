package com.eleadmin.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.work.mapper.PurchaseAgreementsMapper;
import com.eleadmin.work.service.PurchaseAgreementsService;
import com.eleadmin.work.entity.PurchaseAgreements;
import com.eleadmin.work.param.PurchaseAgreementsParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-14 17:23:22
 */
@Service
public class PurchaseAgreementsServiceImpl extends ServiceImpl<PurchaseAgreementsMapper, PurchaseAgreements> implements PurchaseAgreementsService {

    @Override
    public PageResult<PurchaseAgreements> pageRel(PurchaseAgreementsParam param) {
        PageParam<PurchaseAgreements, PurchaseAgreementsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<PurchaseAgreements> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<PurchaseAgreements> listRel(PurchaseAgreementsParam param) {
        List<PurchaseAgreements> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<PurchaseAgreements, PurchaseAgreementsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public PurchaseAgreements getByIdRel(Integer id) {
        PurchaseAgreementsParam param = new PurchaseAgreementsParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
