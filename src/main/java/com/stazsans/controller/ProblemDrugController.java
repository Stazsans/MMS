package com.stazsans.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stazsans.domain.ProblemDrug;
import com.stazsans.service.IProblemDrugService;
import com.stazsans.utils.ResultMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 问题药品相关的controller
 * @author ss
 */
@Controller
@RequestMapping(value = "/problemDrug")
public class ProblemDrugController {

    @Autowired
    private IProblemDrugService problemDrugService;

    /**
     * 转向问题药品页面
     */
    @RequestMapping
    public String problemDrug(){
        return "/problemDrug";
    }

    /**
     * 分页查询问题药品列表
     */
    @RequestMapping(value = "/problemDrugQueryPage")
    @ResponseBody
    public Object problemDrugQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<ProblemDrug> iPage = problemDrugService.selectProblemDrugPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品新增页面
     */
    @RequestMapping(value = "/problemDrugPage")
    public String problemDrugPage(){
        return "/problemDrugPage";
    }

    /**
     * 添加一个问题药品
     */
    @RequestMapping(value = "/problemDrugAdd")
    @ResponseBody
    public Object problemDrugAdd(ProblemDrug problemDrug){
        try{
            problemDrug.setCreateTime(new Date());
            int i = problemDrugService.addProblemDrug(problemDrug);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向问题药品编辑页面
     */
    @RequestMapping(value = "/problemDrugQueryById")
    public String problemDrugQueryById(@RequestParam(name = "id")Integer id, Model model){
        ProblemDrug problemDrug = problemDrugService.queryProblemDrugById(id);
        model.addAttribute("obj",problemDrug);
        return "/problemDrugPage";
    }

    /**
     * 修改一个问题药品
     */
    @RequestMapping(value = "/problemDrugEdit")
    @ResponseBody
    public Object problemDrugEdit(ProblemDrug problemDrug){
        try{
            int i = problemDrugService.editProblemDrug(problemDrug);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个问题药品
     */
    @RequestMapping(value = "/problemDrugDelById")
    @ResponseBody
    public Object problemDrugDelById(Integer id){
        try{
            int i = problemDrugService.delProblemDrugById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















