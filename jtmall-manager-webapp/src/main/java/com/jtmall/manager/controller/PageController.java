package com.jtmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jtmall.service.UserviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PageController
 * 页面显示
 * @author Badribbit
 * @date 2019/6/7
 */
@Controller
public class PageController {

    @Reference(version = "${demo.service.version}")
    private UserviceService demoService;

    @RequestMapping("/index")
    public String inde(Model model) {
        model.addAttribute("title","第一次Thymeleaf");
        return "index";
    }
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title","第一次Thymeleaf");
        return "home";
    }
    @RequestMapping("/Products_List")
    public String Products_List(Model model) {
        model.addAttribute("title","第一次Thymeleaf");
        return "Products_List";
    }

    @RequestMapping("/picture-add")
    public String picture_add(Model model) {
        model.addAttribute("title","第一次Thymeleaf");
        return "picture-add";
    }
}
