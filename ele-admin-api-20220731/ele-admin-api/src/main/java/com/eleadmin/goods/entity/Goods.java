package com.eleadmin.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-03-07 10:37:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goodsId")
    private Integer goodsid;

    private String name;

    private Double price;

    private String nums;

    private Integer tenantId;

}
