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
 * 退货给供应商
 *
 * @author ss
 */
@Data
@TableName(value = "return_supplier")
public class ReturnSupplier {
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
     * 数量
     */
    @TableField("drug_count")
    private Integer drugCount;

    /**
     * 供应商名称
     */
    @TableField("supplier_name")
    private String supplierName;

    /**
     * 进货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("buy_time")
    private Date buyTime;

    /**
     * 退货原因
     */
    @TableField("reason")
    private String reason;

    /**
     * 退货时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("return_time")
    private Date returnTime;

    /**
     * 进货时间转换成年月日
     *
     * @return
     */
    public String getBuyTimeStr() {
        return DateUtil.dateConvert(buyTime);
    }

    /**
     * 退货时间转换成年月日
     *
     * @return
     */
    public String getReturnTimeStr() {
        return DateUtil.dateConvert(returnTime);
    }


}
