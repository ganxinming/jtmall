package com.jtmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jtmall.commons.utils.JsonUtils;
import com.jtmall.entity.JtbItem;
import com.jtmall.entity.JtbItemAndcontent;
import com.jtmall.entity.JtbItemcontent;
import com.jtmall.service.JtbItemService;
import com.jtmall.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * PageController
 * 页面显示
 * @author Badribbit
 * @date 2019/6/7
 */
@Controller
public class JtItemController {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Reference(version = "${demo.service.version}")
    private JtbItemService jtbItemService;

    @Reference(version = "${demo.service.version}")
    private RedisService redisUtils;


    @RequestMapping("/insertJtItem")
    public String insertJtItem(JtbItem jtbItem, JtbItemcontent jtbItemcontent) {
       jtbItemService.insertJtbItemAndContent(jtbItem,jtbItemcontent);
        logger.debug("开始插入");
        return "index";
    }
    @RequestMapping("/updateJtItem")
    public String updateJtItem(JtbItem jtbItem, JtbItemcontent jtbItemcontent) {
        jtbItemService.updateJtbItemAndContent(jtbItem,jtbItemcontent);
        logger.debug("开始更新");
        return "index";
    }
    @RequestMapping("/deleteAllJtItem")
    @ResponseBody
    public String deleteAllJtItem(int [] array) {
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        jtbItemService.deleteAllJtItem(array);
        logger.debug("开始批量删除");
        Map result = new HashMap<>();
        result.put("success","成功");
        return JsonUtils.objectToJson(result);
    }

    @RequestMapping("/deleteJtItemByid/{id}")
    @ResponseBody
    public String deleteJtItemByid(@PathVariable("id") int id) {
        jtbItemService.deleteJtItemByid(id);
        logger.debug("删除了id为"+id);
        Map result = new HashMap<>();
        result.put("success","成功");
        return JsonUtils.objectToJson(result);
    }

    @RequestMapping("/getJtbItemByid/{id}")
    @ResponseBody
    public String getJtbItemByid(@PathVariable("id") int id, Model model) {
        JtbItemAndcontent jtbItemAndcontent=jtbItemService.getJtbItemAndContentByid(id);
        redisUtils.set("item",jtbItemAndcontent);
        Map result = new HashMap<>();
        result.put("success","成功");
        return JsonUtils.objectToJson(result);
    }
}
