package com.eleadmin.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.work.mapper.EngineeringMapper;
import com.eleadmin.work.service.EngineeringService;
import com.eleadmin.work.entity.Engineering;
import com.eleadmin.work.param.EngineeringParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-05-26 22:15:37
 */
@Service
public class EngineeringServiceImpl extends ServiceImpl<EngineeringMapper, Engineering> implements EngineeringService {

    @Override
    public PageResult<Engineering> pageRel(EngineeringParam param) {
        PageParam<Engineering, EngineeringParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Engineering> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Engineering> listRel(EngineeringParam param) {
        List<Engineering> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Engineering, EngineeringParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Engineering getByIdRel(Integer id) {
        EngineeringParam param = new EngineeringParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

}
