package com.stazsans.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品出入库记录
 *
 * @author ss
 */
@Data
@TableName(value = "ow_info")
public class OwInfo {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    @TableField("drug_name")
    private String drugName;

    /**
     * 出库or入库
     */
    @TableField("type")
    private String type;

    /**
     * 操作数量
     */
    @TableField("count")
    private Integer count;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 操作时间
     */
    @TableField("create_time")
    private Date createTime;
}
