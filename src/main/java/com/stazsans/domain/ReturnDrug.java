package com.stazsans.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.stazsans.utils.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 退货单
 *
 * @author ss
 */
@Data
@TableName(value = "return_drug")
public class ReturnDrug {
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
    @TableField("count")
    private Integer count;

    /**
     * 退货原因
     */
    @TableField("reason")
    private String reason;

    /**
     * 总金额
     */
    @TableField("total")
    private Float total;

    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("operate_time")
    private Date operateTime;

    /**
     * 操作时间转换成年月日
     * @return
     */
    public String getOperateTimeStr() {
        return DateUtil.dateConvert(operateTime);
    }
}
