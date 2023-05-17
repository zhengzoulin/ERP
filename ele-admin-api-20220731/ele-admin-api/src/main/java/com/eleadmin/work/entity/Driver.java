package com.eleadmin.cartest.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 *
 * @author EleAdmin
 * @since 2023-03-06 15:47:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Driver对象", description = "")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String driverNumber;

    private String driverName;

    private String driverType;

    private Long driverTel;

    private String driverAccount;

    private Integer driverStatus;

    private Integer tenantId;

}
