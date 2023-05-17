package com.eleadmin.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "RawMaterialSupplier对象", description = "")
public class RawMaterialSupplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String unitName;

    private String unitType;

    private String rmsPhone;

    private String rmsAddress;

    private Integer userId;

    @ApiModelProperty("状态, 0正常, 1冻结")
    private Integer status;

    private String rmsRemarks;

    private Integer tenantId;

    @TableField(exist = false)
    private List<RawMaterials> rawMaterials;



    @TableField(exist = false)
    private String platformRawMaterials;

    @TableField(exist = false)
    private Integer rawMaterialId;

    @TableField(exist = false)
    private Integer rrId;

    @TableField(exist = false)
    private String supplyRawMaterials;
    @TableField(exist = false)
    private Integer rmStatus;
}
