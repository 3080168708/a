package com.abc.pojo;

public class ShopPingCart {
    private Integer id;
    private String username;
    private String goodsName;
    private double goodsPrice;
    private int goodsTotal;
    private double goodsTotalPrice;

    public ShopPingCart() {
    }

    public ShopPingCart(Integer id, String username, String goodsName, double goodsPrice, int goodsTotal, double goodsTotalPrice) {

        this.id = id;
        this.username = username;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsTotal = goodsTotal;
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(int goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    @Override
    public String toString() {
        return "shopPingCart{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsTotal=" + goodsTotal +
                ", goodsTotalPrice=" + goodsTotalPrice +
                '}';
    }
}
