package com.stazsans.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stazsans.domain.ProblemDrug;
import org.apache.ibatis.annotations.Mapper;

/**
 * 问题药品的增删改查Mapper
 *
 * @author ss
 */
@Mapper
public interface ProblemDrugMapper extends BaseMapper<ProblemDrug> {
}
