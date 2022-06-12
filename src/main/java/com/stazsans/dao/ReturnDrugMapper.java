package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.ReturnDrug;
import org.apache.ibatis.annotations.Mapper;

/**
 * 收到退货的增删改查Mapper
 * @author ss
 */
@Mapper
public interface ReturnDrugMapper extends BaseMapper<ReturnDrug> {
}
