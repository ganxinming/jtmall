package com.jtmall.service;

import com.github.pagehelper.PageInfo;
import com.jtmall.entity.JtbItem;
import com.jtmall.entity.JtbItemAndcontent;
import com.jtmall.entity.JtbItemcontent;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/3/6 14:01
 * @Define
 * @Tutorials
 * @Opinion
 */
public interface JtbItemService {
    void insertJtbItem(JtbItem jtbItem);

    void insertJtbItemcontent(JtbItemcontent jtbItemcontent) ;

    void insertJtbItemAndContent(JtbItem jtbItem,JtbItemcontent jtbItemcontent);

    List<JtbItemAndcontent> getAllJtbItemAndContent();

    PageInfo<JtbItemAndcontent> getAllJtbItemAndContentByPage(int pageNum, int pageSize);

    void deleteAllJtItem(int[] array);

    void deleteJtItemByid(int id);

    JtbItemAndcontent getJtbItemAndContentByid(int id);

    void updateJtbItemAndContent(JtbItem jtbItem,JtbItemcontent jtbItemcontent);

}
