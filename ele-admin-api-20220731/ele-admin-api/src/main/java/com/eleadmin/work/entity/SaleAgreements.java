package com.eleadmin.work.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-05-25 09:20:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SaleAgreements对象", description = "")
public class SaleAgreements implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String agreementNumber;

    private LocalDateTime makeDate;

    private Integer customerId;

    private String customerName;

    private String engineeringId;

    private String engineeringName;

    private String platformRawMaterials;

    private BigDecimal unitPrice;

    private Integer planQuantity;

    private BigDecimal planTotal;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

    private String status;

    private Integer userId;

    private BigDecimal distance;

    private Integer tenantId;

}
