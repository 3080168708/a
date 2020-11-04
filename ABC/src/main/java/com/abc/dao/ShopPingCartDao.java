package com.abc.dao;

import com.abc.pojo.ShopPingCart;

import java.util.List;

public interface ShopPingCartDao {

    /**
     *添加商品到购物车
     * @param shopPingCart 添加商品到购物车中的商品
     */
    void addGoodsToShopPingCart(ShopPingCart shopPingCart);

    /**
     * 查询某个用户的购物车中的商品
     * @param username 用户名
     * @return 用户购物车中的商品
     */
    List<ShopPingCart> selectUserShopPingCartGoods(String username);



    /**
     *从购物车中删除商品
     * @param id 要删除的商品的id
     */
    void GroundsGoodsIdDeleteShopPingCartGoods(int id);



    /**
     * 购物车中所有商品加起来的总价
     * @return 总价
     */
    int sumMoney();


    /**
     * 查询购物车中某个商品的信息
     * @param id 要查询的商品的id
     * @return 查询到的商品信息
     */
    ShopPingCart GroundsGoodsIdSelectShopPingCartGoods(int id);

    /**
     * 结算购物车中所有的商品
     */
    void EmptyShopPingCart();
}

