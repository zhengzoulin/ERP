package com.eleadmin.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eleadmin.goods.entity.Goods;
import com.eleadmin.goods.param.GoodsParam;
import com.eleadmin.test.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author EleAdmin
 * @since 2023-03-07 10:37:59
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 分页查询
     *
     * @param page  分页对象
     * @param param 查询参数
     * @return List<Goods>
     */
    List<Goods> selectPageRel(@Param("page") IPage<Goods> page,
                             @Param("param") GoodsParam param);

    /**
     * 查询全部
     *
     * @param param 查询参数
     * @return List<User>
     */
    List<Goods> selectListRel(@Param("param") GoodsParam param);

    /**
     * 查询所有商品信息
     */
    List<Goods> findAllGoods();

    /**
     * 删除商品信息
     * @param id
     */
    void deleteGoods(int id);

    /**
     * 更新学生信息
     * @param goods
     */
    void updateGoods(Goods goods);

    void addGoods(Goods goods);

}
