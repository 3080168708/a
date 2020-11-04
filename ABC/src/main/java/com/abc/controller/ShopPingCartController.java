package com.abc.controller;


import com.abc.dao.ShopPingCartDao;
import com.abc.exception.sysException;
import com.abc.pojo.Goods;
import com.abc.pojo.ShopPingCart;
import com.abc.pojo.User;
import com.abc.service.GoodsService;
import com.abc.service.ShopPingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class ShopPingCartController {
    @Autowired
    ShopPingCartDao shopPingCartDao;
    @Autowired
    ShopPingCartService shopPingCartService;
    @Autowired
    GoodsService goodsService;


    /**
     * 把商品添加到购物车
     * @param id 要添加到购物车中的商品的id
     * @param goodsTotal 购买当前商品的个数
     * @param request
     * @return 到商品详情页
     */
    @RequestMapping("addGoodsToShopPingCart")
    public String addGoodsToShopPingCart(int id,int goodsTotal,HttpServletRequest request) throws sysException{
        //判断当前浏览商品的用户有没有登录
        User shoppingUser = (User) request.getSession().getAttribute("shoppingUser");
        if (shoppingUser==null){
            throw new sysException("当前还未登录");
        }
        //根据id 查询到商品
        Goods goods = goodsService.goodsDetails(id);
        //取出查询到的商品的名称
        String goodsName = goods.getPname();
        //取出查询到的商品的价格
        double goodsPrice = goods.getPrice();
        //根据登录的用户信息 取出用户名
        String username = shoppingUser.getUsername();
        System.out.println("当前商品成功的添加到了购物车中");
        //将商品信息和用户信息存入购物车
        shopPingCartDao.addGoodsToShopPingCart(new ShopPingCart(null,username,goodsName,goodsPrice,goodsTotal,goodsPrice*goodsTotal));
        return "goodsDetails";
    }

    /**
     * 查询用户的购物车中的商品
     * @param request
     * @return 购物车列表 取出用户的购物车中的商品
     */
    @RequestMapping("selectUserShopPingCart")
    public String  selectUserShopPingCart(HttpServletRequest request) throws sysException{
        //获取session域中已经登录的用户信息
        String username = null;
        try {
            User shoppingUser = (User) request.getSession().getAttribute("shoppingUser");
            //获取到用户名
            username = shoppingUser.getUsername();
        } catch (Exception e) {
            throw new sysException("当前还未登录");
        }
        System.out.println(username);
        //查询该用户的购物车中的商品
        List<ShopPingCart> UserShopPingCarts = shopPingCartService.selectUserShopPingCartGoods(username);
        //把查询结果放入session域中 在页面循环遍历出
        request.getSession().setAttribute("UserShopPingCarts",UserShopPingCarts);
        //输出用户的购物车中的商品
        return "shopPingCart";
    }

    /**
     * 删除购物车中的商品
     * @param id 要删除的商品的id
     * @param request
     * @return 到购物车列表显示还未删除的商品
     */
    @RequestMapping("AccordingIdDeleteGoods")
    public String AccordingIdDeleteGoods(int id,HttpServletRequest request) throws sysException{
        //根据前台传来的商品的id 在购物车中删除该商品
        shopPingCartService.GroundsGoodsIdDeleteShopPingCartGoods(id);
        //再次查询购物车中的商品 输出到购物车页面
        return selectUserShopPingCart(request);
    }
}

