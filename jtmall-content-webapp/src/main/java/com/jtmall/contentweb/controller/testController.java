package com.jtmall.contentweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Badribbit
 * @create 2020/3/3 15:00
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class testController {

    @RequestMapping("/{name}")
    public String test(@PathVariable("name") String name){
        return  "mall/"+name;
    }

}
