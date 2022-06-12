package com.stazsans.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stazsans.domain.ProblemDrug;

/**
 * 问题药品的service接口
 * @author ss
 */
public interface IProblemDrugService extends IService<ProblemDrug> {
    /**
     * 分页查询问题药品数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-问题药品名称
     * @return
     */
    public IPage<ProblemDrug> selectProblemDrugPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条问题药品信息
     * @param problemDrug
     */
    public int addProblemDrug(ProblemDrug problemDrug);

    /**
     * 修改一条问题药品信息
     * @param problemDrug
     */
    public int editProblemDrug(ProblemDrug problemDrug);

    /**
     * 根据主键id查询一个问题药品对象
     * @param id
     * @return
     */
    public ProblemDrug queryProblemDrugById(Integer id);

    /**
     * 根据主键id删除一个问题药品对象
     * @param id
     * @return
     */
    public int delProblemDrugById(Integer id);

}
