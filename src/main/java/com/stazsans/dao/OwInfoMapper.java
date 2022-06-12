package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.OwInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品出入库的增删改查Mapper
 * @author ss
 */
@Mapper
public interface OwInfoMapper extends BaseMapper<OwInfo> {
}
