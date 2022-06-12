package com.stazsans.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stazsans.dao.ReturnDrugMapper;
import com.stazsans.domain.ReturnDrug;
import com.stazsans.service.IReturnDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收到退货service实现类
 */
@Service
public class ReturnDrugServiceImpl extends ServiceImpl<ReturnDrugMapper, ReturnDrug> implements IReturnDrugService {

    @Autowired
    private ReturnDrugMapper returnDrugMapper;

    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return
     */
    @Override
    public IPage<ReturnDrug> selectReturnDrugPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnDrug> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("drugName",param);
        }
        Page<ReturnDrug> page = new Page<>(pageNum,pageSize);
        return returnDrugMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条收到退货信息
     *
     * @param returnDrug
     */
    @Override
    public int addReturnDrug(ReturnDrug returnDrug) {
        return returnDrugMapper.insert(returnDrug);
    }

    /**
     * 修改一条收到退货信息
     *
     * @param returnDrug
     */
    @Override
    public int editReturnDrug(ReturnDrug returnDrug) {
        return returnDrugMapper.updateById(returnDrug);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public ReturnDrug queryReturnDrugById(Integer id) {
        return returnDrugMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public int delReturnDrugById(Integer id) {
        return returnDrugMapper.deleteById(id);
    }

}
