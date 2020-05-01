package com.jtmall.cartService.mapper;

import com.jtmall.cartPojo.JtbOrder;
import com.jtmall.cartPojo.JtbOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JtbOrderMapper {
    long countByExample(JtbOrderExample example);

    int deleteByExample(JtbOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(JtbOrder record);

    int insertSelective(JtbOrder record);

    List<JtbOrder> selectByExample(JtbOrderExample example);

    JtbOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") JtbOrder record, @Param("example") JtbOrderExample example);

    int updateByExample(@Param("record") JtbOrder record, @Param("example") JtbOrderExample example);

    int updateByPrimaryKeySelective(JtbOrder record);

    int updateByPrimaryKey(JtbOrder record);
}