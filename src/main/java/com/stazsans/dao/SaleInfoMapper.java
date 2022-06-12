package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.SaleInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品销售记录的增删改查Mapper
 * @author ss
 */
@Mapper
public interface SaleInfoMapper extends BaseMapper<SaleInfo> {
}
