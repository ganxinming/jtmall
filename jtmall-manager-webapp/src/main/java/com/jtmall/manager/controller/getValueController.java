package com.jtmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jtmall.commons.utils.JsonUtils;
import com.jtmall.commons.utils.Validators;
import com.jtmall.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Badribbit
 * @create 2020/3/4 20:50
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class getValueController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(version = "${demo.service.version}")
    private RedisService redisUtils;

    /**
     * 查看商品编号是否存在并返回
     * @return
     */
    @RequestMapping(value = "/getcNumber")
    @ResponseBody
    public String getcNumber(HttpSession session){
        String cNumber= (String) session.getAttribute("cNumber");
        if (Validators.isEmpty(cNumber)){
            return null;
        }
        Map result = new HashMap<>();
        result.put("cNumber", cNumber);
        boolean hasKey = redisUtils.exists(cNumber);
        if (!hasKey){
            redisUtils.set(cNumber,"");
        }
        logger.debug("cNumber已存入redis");
        return JsonUtils.objectToJson(result);
    }
}
