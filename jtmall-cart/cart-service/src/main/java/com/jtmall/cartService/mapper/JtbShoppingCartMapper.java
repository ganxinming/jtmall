package com.jtmall.cartService.mapper;

import com.jtmall.cartPojo.JtbShoppingCart;
import com.jtmall.cartPojo.JtbShoppingCartExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JtbShoppingCartMapper {
    long countByExample(JtbShoppingCartExample example);

    int deleteByExample(JtbShoppingCartExample example);

    int deleteByPrimaryKey(Long cartId);

    int insert(JtbShoppingCart record);

    int insertSelective(JtbShoppingCart record);

    List<JtbShoppingCart> selectByExample(JtbShoppingCartExample example);

    JtbShoppingCart selectByPrimaryKey(Long cartId);

    int updateByExampleSelective(@Param("record") JtbShoppingCart record, @Param("example") JtbShoppingCartExample example);

    int updateByExample(@Param("record") JtbShoppingCart record, @Param("example") JtbShoppingCartExample example);

    int updateByPrimaryKeySelective(JtbShoppingCart record);

    int updateByPrimaryKey(JtbShoppingCart record);
}