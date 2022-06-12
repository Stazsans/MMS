package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.ReturnSupplier;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退货给供应商的增删改查Mapper
 *
 * @author ss
 */
@Mapper
public interface ReturnSupplierMapper extends BaseMapper<ReturnSupplier> {
}
