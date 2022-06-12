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
 * 账单信息
 * @author ss
 */
@Data
@TableName("bill_info")
public class BillInfo {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 供应商名称
     */
    @TableField("supplier_name")
    private String supplierName;

    /**
     * 药品名称
     */
    @TableField("drug_name")
    private String drugName;

    /**
     * 药品数量
     */
    @TableField("count")
    private Integer count;

    /**
     * 总金额
     */
    @TableField("total")
    private Float total;

    /**
     * 进货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("buy_time")
    private Date buyTime;

    /**
     * 转化日期格式
     * @return
     */
    public String getBuyTimeStr(){
        return DateUtil.dateConvert(buyTime);
    }
}
