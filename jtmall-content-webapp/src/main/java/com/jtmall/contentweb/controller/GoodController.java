package com.jtmall.contentweb.controller;

import com.jtmall.entity.JtbItemAndcontent;
import com.jtmall.service.JtbItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Badribbit
 * @create 2020/3/26 13:54
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class GoodController {

    @Reference(version = "${demo.service.manager}")
    private JtbItemService jtbItemService;


    @GetMapping("/goods/detail/{id}")
    public String detailPage(@PathVariable("id") int id, Model model) {
        if (id < 1) {
            return "error/error_5xx";
        }
        JtbItemAndcontent jtbItemAndcontent=jtbItemService.getJtbItemAndContentByid(id);
        model.addAttribute("goodsDetail",jtbItemAndcontent);
        System.out.println(jtbItemService);
        return "mall/detail";
    }
}
