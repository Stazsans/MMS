package com.stazsans.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.stazsans.domain.OwInfo;

/**
 * 药品出入库的service接口
 * @author ss
 */
public interface IOwInfoService extends IService<OwInfo> {
    /**
     * 分页查询药品出入库数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品出入库名称
     * @return
     */
    public IPage<OwInfo> selectOwInfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条药品出入库信息
     * @param owInfo
     */
    public int addOwInfo(OwInfo owInfo);

    /**
     * 修改一条药品出入库信息
     * @param owInfo
     */
    public int editOwInfo(OwInfo owInfo);

    /**
     * 根据主键id查询一个药品出入库对象
     * @param id
     * @return
     */
    public OwInfo queryOwInfoById(Integer id);

    /**
     * 根据主键id删除一个药品出入库对象
     * @param id
     * @return
     */
    public int delOwInfoById(Integer id);

}
