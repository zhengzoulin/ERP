package com.eleadmin.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eleadmin.goods.mapper.GoodsMapper;
import com.eleadmin.goods.service.GoodsService;
import com.eleadmin.goods.entity.Goods;
import com.eleadmin.goods.param.GoodsParam;
import com.eleadmin.common.core.web.PageParam;
import com.eleadmin.common.core.web.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现
 *
 * @author EleAdmin
 * @since 2023-03-07 10:37:59
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public PageResult<Goods> pageRel(GoodsParam param) {
        PageParam<Goods, GoodsParam> page = new PageParam<>(param);
        //page.setDefaultOrder("create_time desc");
        List<Goods> list = baseMapper.selectPageRel(page, param);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<Goods> listRel(GoodsParam param) {
        List<Goods> list = baseMapper.selectListRel(param);
        // 排序
        PageParam<Goods, GoodsParam> page = new PageParam<>();
        //page.setDefaultOrder("create_time desc");
        return page.sortRecords(list);
    }

    @Override
    public Goods getByIdRel(Integer id) {
        GoodsParam param = new GoodsParam();
        param.setId(id);
        return param.getOne(baseMapper.selectListRel(param));
    }

    @Override
    public List<Goods> findAllGoods() {
        return goodsMapper.findAllGoods();
    }

    @Override
    public void deleteGoods(int id) {
         goodsMapper.deleteGoods(id);

    }

    @Override
    public boolean updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
        System.out.println("update:"+goods.getName());
        return true;
    }

    @Override
    public boolean addGoods(Goods goods) {
        System.out.println("add:"+goods.getName());
        goodsMapper.addGoods(goods);

        return true;
    }

}
