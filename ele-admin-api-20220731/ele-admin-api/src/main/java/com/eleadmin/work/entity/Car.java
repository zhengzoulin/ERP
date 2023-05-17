package com.eleadmin.cartest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *
 *
 * @author EleAdmin
 * @since 2023-03-06 15:47:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Car对象", description = "")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cName;

    private String cId;

    private String cType;

    private String cPeople;

    private String cCompany;

    private Integer cStatus;

    private String cRemarks;

    private Integer tenantId;

}
