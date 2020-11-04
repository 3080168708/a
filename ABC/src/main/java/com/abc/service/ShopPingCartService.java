package com.abc.service;

import com.abc.dao.ShopPingCartDao;
import com.abc.pojo.ShopPingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;


@Service
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class ShopPingCartService {
    @Autowired
    ShopPingCartDao shopPingCartDao;
    @Autowired
    GoodsService goodsService;

    /**
     * 添加商品到购物车
     * @param shopPingCart 添加的商品
     */
    public void addGoodsToShopPingCart(ShopPingCart shopPingCart){
        //将商品添加到购物车
        shopPingCartDao.addGoodsToShopPingCart(shopPingCart);
        System.out.println("当前商品成功加入购物车");
    }


    /**
     * 查询用户的购物车中的商品
     * @param username 用户名
     * @return 用户的购物车中的商品
     */
    public List<ShopPingCart> selectUserShopPingCartGoods(String username){
        //查询用户的购物车中的商品
        List<ShopPingCart> shopPingCarts = shopPingCartDao.selectUserShopPingCartGoods(username);
        System.out.println("用户购物车中的商品查询完成");
        return shopPingCarts;
    }

    /**
     * 计算购物车中所有商品价格加一起的总价
     * @return 总价
     */
    public int sumMoney(){
        return shopPingCartDao.sumMoney();
    }

    /**
     * 查询购物车中的商品
     * @param id 要查询的商品的id
     * @return 查询到的商品的信息
     */
    public ShopPingCart GroundsGoodsIdSelectShopPingCartGoods(int id) {
        return shopPingCartDao.GroundsGoodsIdSelectShopPingCartGoods(id);
    }

    /**
     * 删除购物车中的商品
     * @param id 要删除的商品的id
     */
    public void GroundsGoodsIdDeleteShopPingCartGoods(int id) {
        shopPingCartDao.GroundsGoodsIdDeleteShopPingCartGoods(id);
    }


    /**
     * 结算购物车中的所有商品
     */
    public void EmptyShopPingCart(){
       shopPingCartDao.EmptyShopPingCart();
    }

}
