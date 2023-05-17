package com.eleadmin.work.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-05-14 17:23:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PurchaseAgreements对象", description = "")
public class PurchaseAgreements implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String agreementNumber;

    private LocalDate makeDate;

    private Integer rmsId;

    private String unitName;

    private String paRemarks;

    private Integer userId;

    private Integer status;

    private String supplyRawMaterials;

    private BigDecimal unitPrice;

    private Integer planQuantity;

    private BigDecimal planTotal;

    private LocalDateTime beganTime;

    private LocalDateTime endTime;

    private String rmsPhone;

    private String rmsName;

    private Integer tenantId;
}
