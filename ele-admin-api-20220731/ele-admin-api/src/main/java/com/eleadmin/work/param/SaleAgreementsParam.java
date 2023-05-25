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
 * @since 2023-05-25 09:20:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "SaleAgreementsParam对象", description = "查询参数")
public class SaleAgreementsParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    private String agreementNumber;

    private String makeDate;

    @QueryField(type = QueryType.EQ)
    private Integer customerId;

    private String customerName;

    private String engineeringId;

    private String engineeringName;

    private String platformRawMaterials;

    @QueryField(type = QueryType.EQ)
    private BigDecimal unitPrice;

    private String planQuantity;

    private String planTotal;

    private String beginTime;

    private String endTime;

    private String status;

    @QueryField(type = QueryType.EQ)
    private Integer userId;

    private Double distance;

}
