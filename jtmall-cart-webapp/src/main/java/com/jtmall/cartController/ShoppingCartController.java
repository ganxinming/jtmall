package com.jtmall.cartController;

import com.jtmall.cartInterface.ShoppingCartService;
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
 * @create 2020/4/20 14:03
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class ShoppingCartController {
    @Reference(version = "${demo.service.cart}", check = false)
    private ShoppingCartService cartService;

    @Reference(version = "${demo.service.manager}", check = false)
    private JtbItemService jtbItemService;

    @RequestMapping("/getAllCartByUserId")
    public String getAllCartByUserId(Model model) {
        //最新商品
        //TODO 记得获得登录用户的id，这里只是模拟
        UmsMember umsMember = new UmsMember();
        umsMember.setId(1);

        List<JtbShoppingCart> list = cartService.getAllCartByUser(umsMember);
        List<JtbShowCart> cartList = new ArrayList<>();
        //TODO 解决此多处调用代码
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

        model.addAttribute("cartList", cartList);
        model.addAttribute("itemsTotal", itemsTotal);
        model.addAttribute("priceTotal", priceTotal);
        return "mall/cart";
    }

    /**
     * 添加购物车
     * @param model
     * @return
     */
    @RequestMapping("/addCartByUserId")
    public String addCartByUserId(Model model) {
        //TODO 添加购物车时，存入的id是cnumber
        return "";
    }


    @RequestMapping("/shop-cart-settle")
    public String shopCartSettle(Model model) {
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

        model.addAttribute("cartList", cartList);
        model.addAttribute("itemsTotal", itemsTotal);
        model.addAttribute("priceTotal", priceTotal);
        //TODO 以下数据都要从user封装中取，现在只是简单封装
        model.addAttribute("address","江西省九江永修虬津镇");
        model.addAttribute("userId",1);

        return "mall/order-settle";
    }
}

