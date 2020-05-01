package com.jtmall.cartService.impl;

import com.jtmall.cartInterface.OrderService;
import com.jtmall.cartPojo.*;
import com.jtmall.cartService.mapper.JtbOrderItemMapper;
import com.jtmall.cartService.mapper.JtbOrderMapper;
import com.jtmall.commons.utils.OrderUtil;
import com.jtmall.userPojo.UmsMember;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/4/23 22:37
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.cart}")
public class OrderServiceImpl implements OrderService {

    @Autowired
    JtbOrderMapper jtbOrderMapper;

    @Autowired
    JtbOrderItemMapper jtbOrderItemMapper;

    @Override
    public String addOrder(List<JtbShowCart> cartList, UmsMember user, float priceTotal, int itemsTotal) {

        if (cartList == null || user == null){
            return "";
        }

        //先生成订单
        JtbOrder order=new JtbOrder();
        order.setOrderNum(OrderUtil.getOrderNum(user.getId()));
        order.setUserId(user.getId());
        order.setTotalPrice(priceTotal);
        //TODO 地址需要从数据对象中取，这里模拟，还有订单内容
        order.setUserAddress("虬津镇永修县");
        order.setInfo("订单内容需要思考");
        order.setUserName(user.getNickname());
        order.setUserPhone(user.getPhone());
        //插入订单
        int idOrder=jtbOrderMapper.insertSelective(order);
        //在mapper方法下加上这个 @Options(useGeneratedKeys = true),实验是否返回主键
        System.out.println(order.getOrderId());
        //循环插入订单-商品表

        for (JtbShowCart cart : cartList){
            JtbOrderItem orderItem=new JtbOrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setItemId(cart.getCartItemId());
            orderItem.setItemCount(cart.getGoodsCount());
            orderItem.setItemImgurl(cart.getImageUrl());
            orderItem.setItemName(cart.getGoodsName());
            orderItem.setItemPrice(cart.getPrice());
            jtbOrderItemMapper.insertSelective(orderItem);
        }
        //返回订单号
        return order.getOrderNum();
    }

    @Override
    public JtbOrderDetail getOrderDetail(String orderNum) {
        //查询订单
        JtbOrderExample example=new JtbOrderExample();
        example.createCriteria().andOrderNumEqualTo(orderNum);
        List<JtbOrder> orders= jtbOrderMapper.selectByExample(example);
        if (orders == null){
            return  null;
        }
        JtbOrder order=orders.get(0);
        JtbOrderDetail jtbOrderDetail=new JtbOrderDetail();
        //封装订单细节
        jtbOrderDetail.setOrderNum(order.getOrderNum());
        //TODO 时间未封装
        jtbOrderDetail.setCreateTime(LocalDateTime.now());
        jtbOrderDetail.setPayTime(LocalDateTime.now());

        jtbOrderDetail.setOrderStatus(order.getStatus());
        jtbOrderDetail.setOrderStatusString(order.getStatus().toString());
        jtbOrderDetail.setPayType(order.getPayType());
        jtbOrderDetail.setPayTypeString(order.getPayType().toString());
        jtbOrderDetail.setUserAddress(order.getUserAddress());
        jtbOrderDetail.setTotalPrice(order.getTotalPrice());
        //查询该订单相关的商品
        JtbOrderItemExample jtbOrderItemExample=new JtbOrderItemExample();
        jtbOrderItemExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
        List<JtbOrderItem> jtbOrderItems= jtbOrderItemMapper.selectByExample(jtbOrderItemExample);
        jtbOrderDetail.setJtbOrderItemList(jtbOrderItems);

        return jtbOrderDetail;
    }
}
