package com.eleadmin.work.param;

import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2023-05-14 17:23:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "PurchaseAgreementsParam对象", description = "查询参数")
public class PurchaseAgreementsParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    private String agreementNumber;

    private String makeDate;

    @QueryField(type = QueryType.EQ)
    private Integer rmsId;

    private String unitName;

    private String paRemarks;

    @QueryField(type = QueryType.EQ)
    private Integer userId;

    @QueryField(type = QueryType.EQ)
    private Integer status;

    private String supplyRawMaterials;

    @QueryField(type = QueryType.EQ)
    private BigDecimal unitPrice;

    @QueryField(type = QueryType.EQ)
    private Integer planQuantity;

    @QueryField(type = QueryType.EQ)
    private BigDecimal planTotal;

    private String beganTime;

    private String endTime;

    private String rmsPhone;

    private String rmsName;

    private Integer tenantId;
}
