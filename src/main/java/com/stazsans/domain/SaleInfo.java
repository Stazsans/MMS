package com.stazsans.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.stazsans.utils.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 销售记录
 *
 * @author ss
 */
@Data
@TableName(value = "sale_info")
public class SaleInfo {
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
     * 药品编号
     */
    @TableField("drug_number")
    private String drugNumber;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 总金额
     */
    private Float total;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateTime;

    /**
     * 转换时间格式
     * @return operateTime
     */
    public String getOperateTimeStr() {
        return DateUtil.dateConvert(operateTime);
    }
}
