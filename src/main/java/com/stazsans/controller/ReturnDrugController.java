package com.stazsans.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stazsans.domain.ReturnDrug;
import com.stazsans.service.IReturnDrugService;
import com.stazsans.utils.ResultMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收到退货相关的controller
 * @author ss
 */
@Controller
@RequestMapping("/returnDrug")
public class ReturnDrugController {

    @Autowired
    private IReturnDrugService returnDrugService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping
    public String returnDrug(){
        return "/returnDrug";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping("/returnDrugQueryPage")
    @ResponseBody
    public Object returnDrugQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<ReturnDrug> iPage = returnDrugService.selectReturnDrugPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货新增页面
     */
    @RequestMapping("/returnDrugPage")
    public String returnDrugPage(){
        return "/returnDrugPage";
    }

    /**
     * 添加一个收到退货
     */
    @RequestMapping("/returnDrugAdd")
    @ResponseBody
    public Object returnDrugAdd(ReturnDrug returnDrug){
        try{
            int i = returnDrugService.addReturnDrug(returnDrug);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping("/returnDrugQueryById")
    public String returnDrugQueryById(@RequestParam(name = "id")Integer id, Model model){
        ReturnDrug returnDrug = returnDrugService.queryReturnDrugById(id);
        model.addAttribute("obj",returnDrug);
        return "/returnDrugPage";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping("/returnDrugEdit")
    @ResponseBody
    public Object returnDrugEdit(ReturnDrug returnDrug){
        try{
            int i = returnDrugService.editReturnDrug(returnDrug);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping("/returnDrugDelById")
    @ResponseBody
    public Object returnDrugDelById(Integer id){
        try{
            int i = returnDrugService.delReturnDrugById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















