package com.eleadmin.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.work.mapper.RawMaterialsMapper;
import com.eleadmin.work.service.RawMaterialsService;
import com.eleadmin.work.entity.RawMaterials;
import com.eleadmin.work.param.RawMaterialsParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
@Service
public class RawMaterialsServiceImpl extends ServiceImpl<RawMaterialsMapper, RawMaterials> implements RawMaterialsService {

    @Override
    public PageResult<RawMaterials> pageRel(RawMaterialsParam param) {
        PageParam<RawMaterials, RawMaterialsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<RawMaterials> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<RawMaterials> listRel(RawMaterialsParam param) {
        List<RawMaterials> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<RawMaterials, RawMaterialsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public RawMaterials getByIdRel(Integer id) {
        RawMaterialsParam param = new RawMaterialsParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
