package com.stazsans.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stazsans.dao.OwInfoMapper;
import com.stazsans.domain.OwInfo;
import com.stazsans.service.IOwInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 药品出入库service实现类
 * @author ss
 */
@Service
public class OwInfoServiceImpl extends ServiceImpl<OwInfoMapper, OwInfo> implements IOwInfoService {

    @Autowired
    private OwInfoMapper owInfoMapper;

    /**
     * 分页查询药品出入库数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品出入库名称
     * @return
     */
    @Override
    public IPage<OwInfo> selectOwInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<OwInfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<OwInfo> page = new Page<>(pageNum,pageSize);
        return owInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条药品出入库信息
     *
     * @param owInfo
     */
    @Override
    public int addOwInfo(OwInfo owInfo) {
        return owInfoMapper.insert(owInfo);
    }

    /**
     * 修改一条药品出入库信息
     *
     * @param owInfo
     */
    @Override
    public int editOwInfo(OwInfo owInfo) {
        return owInfoMapper.updateById(owInfo);
    }

    /**
     * 根据主键id查询一个药品出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public OwInfo queryOwInfoById(Integer id) {
        return owInfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public int delOwInfoById(Integer id) {
        return owInfoMapper.deleteById(id);
    }

}
