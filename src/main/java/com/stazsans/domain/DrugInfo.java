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
 * 药品
 * @author ss
 */
@Data
@TableName("drug_info")
public class DrugInfo {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    @TableField("name")
    private String name;

    /**
     * 生产商
     */
    @TableField("supplier")
    private String supplier;

    /**
     * 生产时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("product_time")
    private Date productTime;

    /**
     * 保质期（月）
     */
    @TableField("warranty")
    private String warranty;

    /**
     * 药品编码
     */
    @TableField("number")
    private String number;

    /**
     * 价格
     */
    @TableField("price")
    private Float price;

    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 转化日期格式
     * @return
     */
    public String getProductTimeStr(){
        return DateUtil.dateConvert(productTime);
    }
}
