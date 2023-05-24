package com.eleadmin.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-05-24 14:27:13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Customer对象", description = "")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String unitName;

    private String unitType;

    private String cPhone;

    private String cAdress;

    private Integer status;

}
