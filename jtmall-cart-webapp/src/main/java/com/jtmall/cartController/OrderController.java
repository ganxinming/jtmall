package com.jtmall.cartController;

import com.jtmall.cartInterface.OrderService;
import com.jtmall.cartInterface.ShoppingCartService;
import com.jtmall.cartPojo.JtbOrderDetail;
import com.jtmall.cartPojo.JtbShoppingCart;
import com.jtmall.cartPojo.JtbShowCart;
import com.jtmall.entity.JtbItemAndcontent;
import com.jtmall.service.JtbItemService;
import com.jtmall.userPojo.UmsMember;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/4/21 20:54
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class OrderController {

    @Reference(version = "${demo.service.cart}", check = false)
    private ShoppingCartService cartService;

    @Reference(version = "${demo.service.manager}", check = false)
    private JtbItemService jtbItemService;

    @Reference(version = "${demo.service.cart}", check = false)
    private OrderService orderService;

    @RequestMapping("/saveOrder")
    public String saveOrder(Model model){
        //最新商品
        //TODO 记得获得登录用户的id，这里只是模拟
        UmsMember umsMember = new UmsMember();
        umsMember.setId(1);

        List<JtbShoppingCart> list = cartService.getAllCartByUser(umsMember);
        List<JtbShowCart> cartList = new ArrayList<>();
        int itemsTotal = 0;
        float priceTotal = 0;
        for (JtbShoppingCart cart : list) {
            cart.getItemId();
            JtbItemAndcontent jtbItemAndcontent = jtbItemService.getJtbItemAndContentByid(cart.getItemId());
            if (jtbItemAndcontent != null) {
                JtbShowCart jtbShowCart = new JtbShowCart();
                jtbShowCart.setCartItemId(jtbItemAndcontent.getId());
                jtbShowCart.setGoodsCount(cart.getItemCount());
                itemsTotal = itemsTotal + cart.getItemCount();
                jtbShowCart.setGoodsName(jtbItemAndcontent.getTitle());
                jtbShowCart.setImageUrl(jtbItemAndcontent.getImage());
                jtbShowCart.setPrice(jtbItemAndcontent.getPrice());
                priceTotal = priceTotal + jtbItemAndcontent.getPrice() * cart.getItemCount();
                cartList.add(jtbShowCart);
            }
        }
        //插入订单,得到订单号
        String orderNum=orderService.addOrder(cartList,umsMember,priceTotal,itemsTotal);
        JtbOrderDetail orderDetail= orderService.getOrderDetail(orderNum);

        model.addAttribute("orderDetail",orderDetail);

        return "mall/order-detail";
    }
}
