package com.eleadmin.cartest.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "DriverParam对象", description = "查询参数")
public class DriverParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    private String driverNumber;

    private String driverName;

    private String driverType;

    @QueryField(type = QueryType.EQ)
    private Long driverTel;

    private String driverAccount;

    @QueryField(type = QueryType.EQ)
    private Integer driverStatus;


}

