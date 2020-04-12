package com.jtmall.contentInterface;

import com.jtmall.contentPojo.NewJitem;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/3/25 21:38
 * @Define
 * @Tutorials
 * @Opinion
 */
public interface GoodService {
    List<NewJitem> getNewsItem(int num);
}
