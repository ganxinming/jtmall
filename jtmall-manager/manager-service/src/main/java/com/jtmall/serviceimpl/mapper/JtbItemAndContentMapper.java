package com.jtmall.serviceimpl.mapper;

import com.jtmall.entity.JtbItemAndcontent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/2/18 15:13
 * @Define
 * @Tutorials
 * @Opinion
 */
@Mapper
public interface JtbItemAndContentMapper {

    List<JtbItemAndcontent> getAllJtbItemAndContent();
    JtbItemAndcontent getJtbItemAndContentByid(int id);
}
