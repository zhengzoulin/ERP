package com.eleadmin.work.param;

import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2023-05-26 22:15:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "EngineeringParam对象", description = "查询参数")
public class EngineeringParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    private String engineeringName;

//    @QueryField(type = QueryType.EQ)
    private Integer unitId;

    private String engineeringAddress;

    private Double distance;

//    @QueryField(type = QueryType.EQ)
    private Integer status;

}
