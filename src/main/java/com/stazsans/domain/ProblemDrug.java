package com.stazsans.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题药品
 *
 * @author ss
 */
@Data
@TableName(value = "problem_drug")
public class ProblemDrug {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药瓶名称
     */
    @TableField("drug_name")
    private String drugName;

    /**
     * 数量
     */
    @TableField("drug_count")
    private Integer drugCount;

    /**
     * 药品单价
     */
    @TableField("drug_price")
    private Float drugPrice;

    /**
     * 问题原因
     */
    @TableField("reason")
    private String reason;

    /**
     * 操作时间
     */
    @TableField("create_time")
    private Date createTime;
}
