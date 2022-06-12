package com.stazsans.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stazsans.dao.BillInfoMapper;
import com.stazsans.domain.BillInfo;
import com.stazsans.service.IBillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账单信息service实现类
 * @author ss
 */
@Service
public class BillInfoServiceImpl extends ServiceImpl<BillInfoMapper, BillInfo> implements IBillInfoService {

    @Autowired
    private BillInfoMapper billInfoMapper;

    /**
     * 分页查询账单信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<BillInfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            //根据供应商名称精确查询
            queryWrapper.eq("supplierName",param);
        }
        Page<BillInfo> page = new Page<>(pageNum,pageSize);
        return billInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条账单信息信息
     *
     * @param billInfo
     */
    @Override
    public int addBillInfo(BillInfo billInfo) {
        return billInfoMapper.insert(billInfo);
    }

    /**
     * 修改一条账单信息信息
     *
     * @param billInfo
     */
    @Override
    public int editBillInfo(BillInfo billInfo) {
        return billInfoMapper.updateById(billInfo);
    }

    /**
     * 根据主键id查询一个账单信息对象
     *
     * @param id
     * @return
     */
    @Override
    public BillInfo queryBillInfoById(Integer id) {
        return billInfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个账单信息对象
     *
     * @param id
     * @return
     */
    @Override
    public int delBillInfoById(Integer id) {
        return billInfoMapper.deleteById(id);
    }

}
