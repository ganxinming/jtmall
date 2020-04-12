package com.jtmall.contentService.impl;

import com.jtmall.contentInterface.GoodService;
import com.jtmall.contentPojo.NewJitem;
import com.jtmall.contentService.mapper.GoodMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/3/25 21:41
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.content}")
public class GoodServiceImpl implements GoodService {


    @Autowired
    GoodMapper goodMapper;

    @Transactional(rollbackFor=Exception.class)
    @Override
    public List<NewJitem> getNewsItem(int num) {
        List<NewJitem> list =goodMapper.getNewsItem(num);
        return list;
    }
}
