package com.jtmall.cartService.impl;

import com.jtmall.cartInterface.ShoppingCartService;
import com.jtmall.cartPojo.JtbShoppingCart;
import com.jtmall.cartPojo.JtbShoppingCartExample;
import com.jtmall.cartService.mapper.JtbShoppingCartMapper;
import com.jtmall.userPojo.UmsMember;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/4/20 14:10
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.cart}")
public class shoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    JtbShoppingCartMapper mapper;


    @Override
    public List<JtbShoppingCart> getAllCartByUser(UmsMember user) {
        JtbShoppingCartExample example=new JtbShoppingCartExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        List<JtbShoppingCart> cartlist=mapper.selectByExample(example);
        return cartlist;
    }
}
