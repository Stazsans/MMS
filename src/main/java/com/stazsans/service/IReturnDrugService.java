package com.stazsans.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stazsans.domain.ReturnDrug;

/**
 * 收到退货的service接口
 * @author ss
 */
public interface IReturnDrugService extends IService<ReturnDrug> {
    /**
     * 分页查询收到退货数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-收到退货名称
     * @return
     */
    public IPage<ReturnDrug> selectReturnDrugPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条收到退货信息
     * @param returnDrug
     */
    public int addReturnDrug(ReturnDrug returnDrug);

    /**
     * 修改一条收到退货信息
     * @param returnDrug
     */
    public int editReturnDrug(ReturnDrug returnDrug);

    /**
     * 根据主键id查询一个收到退货对象
     * @param id
     * @return
     */
    public ReturnDrug queryReturnDrugById(Integer id);

    /**
     * 根据主键id删除一个收到退货对象
     * @param id
     * @return
     */
    public int delReturnDrugById(Integer id);

}
