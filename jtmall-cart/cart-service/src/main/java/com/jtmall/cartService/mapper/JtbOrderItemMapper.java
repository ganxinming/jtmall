package com.jtmall.cartService.mapper;

import com.jtmall.cartPojo.JtbOrderItem;
import com.jtmall.cartPojo.JtbOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JtbOrderItemMapper {
    long countByExample(JtbOrderItemExample example);

    int deleteByExample(JtbOrderItemExample example);

    int deleteByPrimaryKey(Integer orderItemId);

    int insert(JtbOrderItem record);

    int insertSelective(JtbOrderItem record);

    List<JtbOrderItem> selectByExample(JtbOrderItemExample example);

    JtbOrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByExampleSelective(@Param("record") JtbOrderItem record, @Param("example") JtbOrderItemExample example);

    int updateByExample(@Param("record") JtbOrderItem record, @Param("example") JtbOrderItemExample example);

    int updateByPrimaryKeySelective(JtbOrderItem record);

    int updateByPrimaryKey(JtbOrderItem record);
}