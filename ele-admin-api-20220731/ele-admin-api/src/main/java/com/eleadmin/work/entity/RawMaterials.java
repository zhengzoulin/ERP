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
 * @since 2023-04-26 16:05:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "RawMaterials对象", description = "")
public class RawMaterials implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String platformRawMaterials;

    private String supplyRawMaterials;

    private String rmRemarks;

    private String rmSpecification;

    @ApiModelProperty("状态, 0正常, 1冻结")
    private Integer status;

    private Integer tenantId;

}
