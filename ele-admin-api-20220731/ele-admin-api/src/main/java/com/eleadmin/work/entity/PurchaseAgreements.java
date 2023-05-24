package com.eleadmin.work.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 *
 *
 * @author EleAdmin
 * @since 2023-05-14 17:23:22
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PurchaseAgreements对象", description = "")
public class PurchaseAgreements implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String agreementNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date makeDate;

    private Integer rmsId;

    private String paRemarks;

    private Integer userId;

    private Integer status;

    private String unitName;

    private String supplyRawMaterials;

    private BigDecimal unitPrice;

    private Integer planQuantity;

    private BigDecimal planTotal;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beganTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private String rmsPhone;

    private String rmsName;

    @TableField(exist = false)
    private List<RawMaterials> rawMaterials;

    @TableField(exist = false)
    private List<RawMaterialSupplier> rawMaterialSuppliers;

    private Integer tenantId;

    public PurchaseAgreements(){};


}
