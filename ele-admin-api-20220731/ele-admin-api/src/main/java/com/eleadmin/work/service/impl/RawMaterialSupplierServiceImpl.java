package com.eleadmin.work.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.work.dto.RawMSDto;
import com.eleadmin.work.mapper.RawMaterialSupplierMapper;
import com.eleadmin.work.service.RawMaterialSupplierService;
import com.eleadmin.work.entity.RawMaterialSupplier;
import com.eleadmin.work.param.RawMaterialSupplierParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
@Service
public class RawMaterialSupplierServiceImpl extends ServiceImpl<RawMaterialSupplierMapper, RawMaterialSupplier> implements RawMaterialSupplierService {

    @Resource
    RawMaterialSupplierService rawMaterialSupplierService;
    @Resource
    RawMaterialSupplierMapper rawMaterialSupplierMapper;


    @Override
    public PageResult<RawMaterialSupplier> pageRel(RawMaterialSupplierParam param) {
        PageParam<RawMaterialSupplier, RawMaterialSupplierParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<RawMaterialSupplier> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<RawMaterialSupplier> listRel(RawMaterialSupplierParam param) {
        List<RawMaterialSupplier> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<RawMaterialSupplier, RawMaterialSupplierParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public RawMaterialSupplier getByIdRel(Integer id) {
        RawMaterialSupplierParam param = new RawMaterialSupplierParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }


    @Override
    public List<RawMSDto> getRmByid(int id) {


        List<RawMSDto> list=rawMaterialSupplierMapper.getRMByid(id);

        return list;
    }

    @Override
    public List<RawMaterialSupplier> getRmByid2(int id) {


        List<RawMaterialSupplier> list=rawMaterialSupplierMapper.getRMByid2(id);

        return list;
    }

    @Override
    public boolean deleteRMById(int rrId) {
        if(rawMaterialSupplierMapper.deleteRMById(rrId)==1){
            return  true;
        }
        return false;
    }


}
