package com.jtmall.cartInterface;

import com.jtmall.cartPojo.JtbOrderDetail;
import com.jtmall.cartPojo.JtbShowCart;
import com.jtmall.userPojo.UmsMember;

import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/4/23 22:19
 * @Define
 * @Tutorials
 * @Opinion
 */
public interface OrderService {

    String addOrder(List<JtbShowCart> cartList, UmsMember user,float priceTotal,int itemsTotal);
    JtbOrderDetail getOrderDetail (String orderNum);
}
