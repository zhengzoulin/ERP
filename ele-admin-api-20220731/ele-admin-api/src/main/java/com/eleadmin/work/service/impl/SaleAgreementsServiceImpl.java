package com.eleadmin.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.work.mapper.SaleAgreementsMapper;
import com.eleadmin.work.service.SaleAgreementsService;
import com.eleadmin.work.entity.SaleAgreements;
import com.eleadmin.work.param.SaleAgreementsParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-25 09:20:42
 */
@Service
public class SaleAgreementsServiceImpl extends ServiceImpl<SaleAgreementsMapper, SaleAgreements> implements SaleAgreementsService {

    @Override
    public PageResult<SaleAgreements> pageRel(SaleAgreementsParam param) {
        PageParam<SaleAgreements, SaleAgreementsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<SaleAgreements> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<SaleAgreements> listRel(SaleAgreementsParam param) {
        List<SaleAgreements> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<SaleAgreements, SaleAgreementsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public SaleAgreements getByIdRel(Integer id) {
        SaleAgreementsParam param = new SaleAgreementsParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
