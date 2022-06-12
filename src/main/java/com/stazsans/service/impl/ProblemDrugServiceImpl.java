package com.stazsans.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stazsans.dao.ProblemDrugMapper;
import com.stazsans.domain.ProblemDrug;
import com.stazsans.service.IProblemDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 问题药品service实现类
 */
@Service
public class ProblemDrugServiceImpl extends ServiceImpl<ProblemDrugMapper, ProblemDrug> implements IProblemDrugService {

    @Autowired
    private ProblemDrugMapper problemDrugMapper;

    /**
     * 分页查询问题药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-问题药品名称
     * @return
     */
    @Override
    public IPage<ProblemDrug> selectProblemDrugPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ProblemDrug> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<ProblemDrug> page = new Page<>(pageNum,pageSize);
        return problemDrugMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条问题药品信息
     *
     * @param problemDrug
     */
    @Override
    public int addProblemDrug(ProblemDrug problemDrug) {
        return problemDrugMapper.insert(problemDrug);
    }

    /**
     * 修改一条问题药品信息
     *
     * @param problemDrug
     */
    @Override
    public int editProblemDrug(ProblemDrug problemDrug) {
        return problemDrugMapper.updateById(problemDrug);
    }

    /**
     * 根据主键id查询一个问题药品对象
     *
     * @param id
     * @return
     */
    @Override
    public ProblemDrug queryProblemDrugById(Integer id) {
        return problemDrugMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个问题药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int delProblemDrugById(Integer id) {
        return problemDrugMapper.deleteById(id);
    }

}
