package com.eleadmin.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eleadmin.common.core.web.PageResult;
import com.eleadmin.goods.entity.Goods;
import com.eleadmin.goods.param.GoodsParam;
import com.eleadmin.test.entity.Student;

import java.util.List;

/**
 * Service
 *
 * @author EleAdmin
 * @since 2023-03-07 10:37:59
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 分页关联查询
     *
     * @param param 查询参数
     * @return PageResult<Goods>
     */
    PageResult<Goods> pageRel(GoodsParam param);

    /**
     * 关联查询全部
     *
     * @param param 查询参数
     * @return List<Goods>
     */
    List<Goods> listRel(GoodsParam param);

    /**
     * 根据id查询
     *
     * @param id 
     * @return Goods
     */
    Goods getByIdRel(Integer id);


//    增删改查
    /**
     * 查询所有商品
     * @return
     */
    List<Goods> findAllGoods();

    /**
     * 删除商品
     * @param id
     * @return
     */
    public void deleteGoods(int id);

    /**
     * 更新商品信息
     * @param goods
     */
    boolean updateGoods(Goods goods);

    boolean addGoods(Goods goods);

}
