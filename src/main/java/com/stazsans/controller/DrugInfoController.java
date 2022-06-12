package com.stazsans.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stazsans.domain.DrugInfo;
import com.stazsans.service.IDrugInfoService;
import com.stazsans.utils.ResultMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 药品相关的controller
 * @author ss
 */
@Controller
@RequestMapping(value = "/drugInfo")
public class DrugInfoController {

    @Autowired
    private IDrugInfoService drugInfoService;

    /**
     * 转向药品页面
     */
    @RequestMapping
    public String drugInfo(){
        return "/drugInfo";
    }

    /**
     * 分页查询药品列表
     */
    @RequestMapping(value = "/drugInfoQueryPage")
    @ResponseBody
    public Object drugInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<DrugInfo> iPage = drugInfoService.selectDrugInfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品新增页面
     */
    @RequestMapping(value = "/drugInfoPage")
    public String drugInfoPage(){
        return "/drugInfoPage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/drugInfoAdd")
    @ResponseBody
    public Object drugInfoAdd(DrugInfo drugInfo){
        try{
            int i = drugInfoService.addDrugInfo(drugInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/drugInfoQueryById")
    public String drugInfoQueryById(@RequestParam(name = "id")Integer id, Model model){
        DrugInfo drugInfo = drugInfoService.queryDrugInfoById(id);
        model.addAttribute("obj",drugInfo);
        return "/drugInfoPage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/drugInfoEdit")
    @ResponseBody
    public Object drugInfoEdit(DrugInfo drugInfo){
        try{
            int i = drugInfoService.editDrugInfo(drugInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/drugInfoDelById")
    @ResponseBody
    public Object drugInfoDelById(Integer id){
        try{
            int i = drugInfoService.delDrugInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/drugInfoList")
    @ResponseBody
    public Object drugInfoList(){
        List<DrugInfo> drugInfoList = drugInfoService.queryDrugInfoList();
        return ResultMapUtil.getHashMapList(drugInfoList);
    }

    /**
     * 转向药品保质期检查页面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }
}





















