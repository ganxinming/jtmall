package com.jtmall.cartInterface;

import com.jtmall.cartPojo.JtbShoppingCart;
import com.jtmall.userPojo.UmsMember;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/4/20 14:06
 * @Define
 * @Tutorials
 * @Opinion
 */
public interface ShoppingCartService {
    List<JtbShoppingCart> getAllCartByUser(UmsMember user);
}
