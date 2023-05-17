package com.eleadmin;

import com.eleadmin.goods.entity.Goods;
import com.eleadmin.goods.service.GoodsService;
import com.eleadmin.goods.service.impl.GoodsServiceImpl;
import com.eleadmin.work.dto.RawMSDto;
import com.eleadmin.work.entity.RawMaterialSupplier;
import com.eleadmin.work.mapper.RawMaterialSupplierMapper;
import com.eleadmin.work.param.RawMaterialSupplierParam;
import com.eleadmin.work.service.RawMaterialSupplierService;
import com.eleadmin.work.service.impl.RawMaterialSupplierServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class EleAdminApplicationTests {
    @Autowired
    RawMaterialSupplierService service=new RawMaterialSupplierServiceImpl();
    @Autowired
    GoodsService goodsService=new GoodsServiceImpl();

    @Test
    public void contextLoads() {


//        List<RawMSDto> list = service.getRmByid(1);
//        List<RawMaterialSupplier> list=service.all();
        List<Goods> list=goodsService.findAllGoods();
        System.out.println(list);

    }


}
