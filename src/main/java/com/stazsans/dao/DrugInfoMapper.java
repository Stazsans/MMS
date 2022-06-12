package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.DrugInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 药品的增删改查Mapper
 * @author ss
 */
@Mapper
public interface DrugInfoMapper extends BaseMapper<DrugInfo> {
}
