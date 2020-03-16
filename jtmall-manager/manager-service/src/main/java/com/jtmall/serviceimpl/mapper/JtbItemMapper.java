package com.jtmall.serviceimpl.mapper;

import com.jtmall.entity.JtbItem;
import com.jtmall.entity.JtbItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JtbItemMapper {
    long countByExample(JtbItemExample example);

    int deleteByExample(JtbItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JtbItem record);

    int insertSelective(JtbItem record);

    List<JtbItem> selectByExample(JtbItemExample example);

    JtbItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JtbItem record, @Param("example") JtbItemExample example);

    int updateByExample(@Param("record") JtbItem record, @Param("example") JtbItemExample example);

    int updateByPrimaryKeySelective(JtbItem record);

    int updateByPrimaryKey(JtbItem record);
}