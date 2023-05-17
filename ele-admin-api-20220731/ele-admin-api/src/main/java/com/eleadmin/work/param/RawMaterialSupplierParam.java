package com.eleadmin.work.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.eleadmin.work.entity.RawMaterials;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2023-04-26 16:05:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "RawMaterialSupplierParam对象", description = "查询参数")
public class RawMaterialSupplierParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    private String unitName;

    private String unitType;

    private String rmsPhone;

    private String rmsAddress;

    @QueryField(type = QueryType.EQ)
    private Integer userId;

    private String rmsState;

    private String rmsRemarks;


}
