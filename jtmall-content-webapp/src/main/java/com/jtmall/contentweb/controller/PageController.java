package com.jtmall.contentweb.controller;

import com.jtmall.annotations.LoginRequired;
import com.jtmall.contentInterface.GoodService;
import com.jtmall.contentPojo.NewJitem;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/3/25 22:37
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class PageController {

    @Reference(version = "${demo.service.content}",check = false)
    private GoodService goodService;

    @LoginRequired(loginSuccess=false)
    @RequestMapping("index")
    public String index(Model model){
        //最新商品
        //TODO:因为图片url可能有多个需要分开，在service中做此功能
        List<NewJitem> list=goodService.getNewsItem(5);
        model.addAttribute("newGoodses",list);
        return  "mall/index";
    }

    @RequestMapping("register")
    public String register(Model model){
        return  "mall/register";
    }
}
