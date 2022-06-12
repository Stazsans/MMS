package com.stazsans.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stazsans.domain.BillInfo;
import com.stazsans.service.IBillInfoService;
import com.stazsans.utils.ResultMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 账单信息相关的controller
 * @author ss
 */
@Controller
@RequestMapping(value = "/billInfo")
public class BillInfoController {

    @Autowired
    private IBillInfoService billInfoService;

    /**
     * 转向账单信息页面
     */
    @RequestMapping
    public String billInfo(){
        return "/billInfo";
    }

    /**
     * 分页查询账单信息列表
     */
    @RequestMapping(value = "/billInfoQueryPage")
    @ResponseBody
    public Object billInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<BillInfo> iPage = billInfoService.selectBillInfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息新增页面
     */
    @RequestMapping(value = "/billInfoPage")
    public String billInfoPage(){
        return "/billInfoPage";
    }

    /**
     * 添加一个账单信息
     */
    @RequestMapping(value = "/billInfoAdd")
    @ResponseBody
    public Object billInfoAdd(BillInfo billInfo){
        try{
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向账单信息编辑页面
     */
    @RequestMapping(value = "/billInfoQueryById")
    public String billInfoQueryById(@RequestParam(name = "id")Integer id, Model model){
        BillInfo billInfo = billInfoService.queryBillInfoById(id);
        model.addAttribute("obj",billInfo);
        return "/billInfoPage";
    }

    /**
     * 修改一个账单信息
     */
    @RequestMapping(value = "/billInfoEdit")
    @ResponseBody
    public Object billInfoEdit(BillInfo billInfo){
        try{
            int i = billInfoService.editBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个账单信息
     */
    @RequestMapping(value = "/billInfoDelById")
    @ResponseBody
    public Object billInfoDelById(Integer id){
        try{
            int i = billInfoService.delBillInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















