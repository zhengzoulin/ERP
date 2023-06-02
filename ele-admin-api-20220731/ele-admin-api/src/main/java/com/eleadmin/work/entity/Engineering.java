package com.eleadmin.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-05-26 22:15:37
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Engineering对象", description = "")
public class Engineering implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String engineeringName;

    private Integer unitId;

//   @TableField(exist = false)

    private String engineeringAddress;

    private Double distance;

    private Date beginTime;

    private Integer status;

    private Integer tenantId;

}
