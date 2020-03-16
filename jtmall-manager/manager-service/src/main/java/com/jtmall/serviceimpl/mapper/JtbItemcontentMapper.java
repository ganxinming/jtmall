package com.jtmall.serviceimpl.mapper;

import com.jtmall.entity.JtbItemcontent;
import com.jtmall.entity.JtbItemcontentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JtbItemcontentMapper {
    long countByExample(JtbItemcontentExample example);

    int deleteByExample(JtbItemcontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JtbItemcontent record);

    int insertSelective(JtbItemcontent record);

    List<JtbItemcontent> selectByExampleWithBLOBs(JtbItemcontentExample example);

    List<JtbItemcontent> selectByExample(JtbItemcontentExample example);

    JtbItemcontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JtbItemcontent record, @Param("example") JtbItemcontentExample example);

    int updateByExampleWithBLOBs(@Param("record") JtbItemcontent record, @Param("example") JtbItemcontentExample example);

    int updateByExample(@Param("record") JtbItemcontent record, @Param("example") JtbItemcontentExample example);

    int updateByPrimaryKeySelective(JtbItemcontent record);

    int updateByPrimaryKeyWithBLOBs(JtbItemcontent record);

    int updateByPrimaryKey(JtbItemcontent record);

    void deleteAllJtItem(int [] array);
}