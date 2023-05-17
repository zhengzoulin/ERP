package com.eleadmin.goods;


import com.eleadmin.goods.mapper.GoodsMapper;
import com.eleadmin.goods.service.GoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test {
    @Autowired
    GoodsService goodsService;
    GoodsMapper goodsMapper;

    @Test
    public void  test1(){

//        goodsService.findAllGoods();
        goodsService.deleteGoods(1);
//        System.out.println("33");
//        goodsMapper.findAllGoods();
    }

}
