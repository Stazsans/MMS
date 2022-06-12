package com.stazsans.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stazsans.domain.SaleInfo;
import com.stazsans.service.ISaleInfoService;
import com.stazsans.utils.ResultMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 销售记录相关的controller
 * @author ss
 */
@Controller
@RequestMapping(value = "/saleInfo")
public class SaleInfoController {

    @Autowired
    private ISaleInfoService saleInfoService;

    /**
     * 转向销售记录页面
     */
    @RequestMapping
    public String saleInfo(){
        return "/saleInfo";
    }

    /**
     * 分页查询销售记录列表
     */
    @RequestMapping(value = "/saleInfoQueryPage")
    @ResponseBody
    public Object saleInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try{
            IPage<SaleInfo> iPage = saleInfoService.selectSaleInfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向销售记录新增页面
     */
    @RequestMapping(value = "/saleInfoPage")
    public String saleInfoPage(){
        return "/saleInfoPage";
    }

    /**
     * 添加一个销售记录
     */
    @RequestMapping(value = "/saleInfoAdd")
    @ResponseBody
    public Object saleInfoAdd(SaleInfo saleInfo){
        try{
            int i = saleInfoService.addSaleInfo(saleInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向销售记录编辑页面
     */
    @RequestMapping(value = "/saleInfoQueryById")
    public String saleInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        SaleInfo saleInfo = saleInfoService.querySaleInfoById(id);
        model.addAttribute("obj",saleInfo);
        return "/saleInfoPage";
    }

    /**
     * 修改一个销售记录
     */
    @RequestMapping(value = "/saleInfoEdit")
    @ResponseBody
    public Object saleInfoEdit(SaleInfo saleInfo){
        try{
            int i = saleInfoService.editSaleInfo(saleInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个销售记录
     */
    @RequestMapping(value = "/saleInfoDelById")
    @ResponseBody
    public Object saleInfoDelById(Integer id){
        try{
            int i = saleInfoService.delSaleInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}





















