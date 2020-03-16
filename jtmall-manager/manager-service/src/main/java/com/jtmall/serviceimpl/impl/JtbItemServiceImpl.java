package com.jtmall.serviceimpl.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jtmall.entity.*;
import com.jtmall.commons.utils.LocalDateUtils;
import com.jtmall.service.JtbItemService;
import com.jtmall.service.RedisService;
import com.jtmall.serviceimpl.mapper.JtbItemAndContentMapper;
import com.jtmall.serviceimpl.mapper.JtbItemMapper;
import com.jtmall.serviceimpl.mapper.JtbItemcontentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/3/6 14:03
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.version}")
public class JtbItemServiceImpl implements JtbItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JtbItemMapper jtbItemMapper;
    @Autowired
    JtbItemcontentMapper jtbItemcontentMapper;
    @Autowired
    JtbItemAndContentMapper jtbItemAndContentMapper;
    @Autowired
    private RedisService redisUtils;

    @Override
    public void insertJtbItem(JtbItem jtbItem) {
        jtbItemMapper.insertSelective(jtbItem);
    }

    @Override
    public void insertJtbItemcontent(JtbItemcontent jtbItemcontent) {
        jtbItemcontentMapper.insertSelective(jtbItemcontent);
    }

    /**
     * 插入一个完整的商品，插入两个表
     * @param jtbItem
     * @param jtbItemcontent
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void insertJtbItemAndContent(JtbItem jtbItem, JtbItemcontent jtbItemcontent) {
        //先插入外表
        Integer cNumber=jtbItem.getcNumber();
        //设置主键
        jtbItemcontent.setId(cNumber);
        String imageUrl=redisUtils.get(cNumber.toString()).toString();
        //设置图片url
        jtbItemcontent.setImage(imageUrl);
        logger.debug(imageUrl);
        //设置创建时间时间
        String time= LocalDateUtils.
                formatterLocalDateTimeToString(LocalDateTime.now(),
                        LocalDateUtils.DEFAULT_PATTERN_DATETIME);
        jtbItemcontent.setCreated(time);
        jtbItemcontent.setUpdated(time);
        this.insertJtbItemcontent(jtbItemcontent);
        //再插入主表(因为主表的外键依赖外表)
        this.insertJtbItem(jtbItem);
        return;
    }
    @Transactional(rollbackFor=Exception.class)
    @Override
    public List<JtbItemAndcontent> getAllJtbItemAndContent() {
        return jtbItemAndContentMapper.getAllJtbItemAndContent();
    }

    @Override
    public PageInfo<JtbItemAndcontent> getAllJtbItemAndContentByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<JtbItemAndcontent> list=jtbItemAndContentMapper.getAllJtbItemAndContent();
        PageInfo<JtbItemAndcontent> page=new PageInfo<>(list);
        return page;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void deleteAllJtItem(int[] array) {
        jtbItemcontentMapper.deleteAllJtItem(array);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void deleteJtItemByid(int id) {
        jtbItemcontentMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public  JtbItemAndcontent getJtbItemAndContentByid(int id) {

        return jtbItemAndContentMapper.getJtbItemAndContentByid(id);
    }
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void updateJtbItemAndContent(JtbItem jtbItem, JtbItemcontent jtbItemcontent) {
        //先插入外表
        Integer cNumber=jtbItem.getcNumber();
        //设置主键
        jtbItemcontent.setId(cNumber);

        String imageUrl=redisUtils.get(cNumber.toString()).toString();
        //设置图片url
        jtbItemcontent.setImage(imageUrl);
        logger.debug(imageUrl);
        //设置创建时间时间
        String time= LocalDateUtils.
                formatterLocalDateTimeToString(LocalDateTime.now(),
                        LocalDateUtils.DEFAULT_PATTERN_DATETIME);
        jtbItemcontent.setUpdated(time);
        //开始更新jtbItemcontent
        JtbItemcontentExample jtbItemcontentExample=new JtbItemcontentExample();
        jtbItemcontentExample.createCriteria().andIdEqualTo(cNumber);
        jtbItemcontentMapper.updateByExampleSelective(jtbItemcontent,jtbItemcontentExample);
        //开始更新jtbitem
        JtbItemExample jtbItemExample=new JtbItemExample();
        jtbItemExample.createCriteria().andCNumberEqualTo(cNumber);
        jtbItemMapper.updateByExampleSelective(jtbItem,jtbItemExample);
        return;
    }

}
