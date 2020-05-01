package com.jtmall.commons.utils;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * @Author Badribbit
 * @create 2020/4/23 22:44
 * @Define
 * @Tutorials
 * @Opinion
 */
public class OrderUtil {

    public static String getOrderNum(int orderId){
       String num= LocalDateUtils.formatterLocalDateTimeToString(LocalDateTime.now()
                ,LocalDateUtils.DEFAULT_PATTERN_DATETIME_SIMPLE, Locale.CHINA);
       String orderNum=num+orderId;
       return  orderNum;
    }
}
