package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.Supplier;
import org.apache.ibatis.annotations.Mapper;

/**
 * 供应商的增删改查Mapper
 * @author ss
 */
@Mapper
public interface SupplierMapper extends BaseMapper<Supplier> {
}
