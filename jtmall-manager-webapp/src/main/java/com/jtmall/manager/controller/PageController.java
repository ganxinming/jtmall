package com.jtmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.jtmall.commons.utils.Validators;
import com.jtmall.entity.JtbItemAndcontent;
import com.jtmall.service.JtbItemService;
import com.jtmall.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * PageController
 * 页面显示
 * @author Badribbit
 * @date 2019/6/7
 */
@Controller
public class PageController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(version = "${demo.service.version}")
    private JtbItemService jtbItemService;

    @Reference(version = "${demo.service.version}")
    private RedisService redisUtils;


    @RequestMapping("/index")
    public String inde(Model model) {
        logger.debug("访问主页");
        return "index";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/Products_List")
    public String Products_List(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                                @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize) {
        PageInfo<JtbItemAndcontent> page=jtbItemService.getAllJtbItemAndContentByPage(pageNum,pageSize);
        model.addAttribute("page",page);
        return "Products_List";
    }
    @RequestMapping("/Products_List1")
    public String Products_List1(Model model) {
        PageInfo<JtbItemAndcontent> page=jtbItemService.getAllJtbItemAndContentByPage(1,10);
        model.addAttribute("page",page);
        return "Products_List1";
    }
    /**
     * 局部刷新表格
     * @param model
     * @return
     */

    @RequestMapping("/Products_List_refresh")
    public String Products_List_refresh(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                                        @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize) {
        PageInfo<JtbItemAndcontent> page=jtbItemService.getAllJtbItemAndContentByPage(pageNum,pageSize);
        model.addAttribute("page",page);
        return "Products_List::table_refresh";
    }
    @RequestMapping("/picture-add")
    public String picture_add(Model model) {
        return "picture-add";
    }

    @RequestMapping("/picture-update")
    public String picture_update(Model model) {
        JtbItemAndcontent item= (JtbItemAndcontent) redisUtils.get("item");
        model.addAttribute("item",item);
        return "picture-update";
    }

    @RequestMapping("/file")
    public String file(Model model) {
        return "file";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        return "test";
    }

    @RequestMapping("/uploadPicture/{cNumber}")
    public String uploadPicture(@PathVariable("cNumber") String cNumber, Model model, HttpSession session) {
        if (!Validators.isNumber(cNumber)){
            return "forward:/myerror/请填写正确商品编号";
        }
        session.setAttribute("cNumber",cNumber);
        logger.debug("cNumber已存入session"+cNumber);
        return "uploadPicture";
    }

    @RequestMapping( "/myerror/{message}")
    public String error(Model model,@PathVariable("message") String message){
        model.addAttribute("errorMessage",message);
        return "error";
    }

}
