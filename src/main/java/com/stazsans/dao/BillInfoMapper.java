package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.BillInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 账单信息的增删改查Mapper
 * @author ss
 */
@Mapper
public interface BillInfoMapper extends BaseMapper<BillInfo> {
}
