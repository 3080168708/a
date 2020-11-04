package com.abc.service;

import com.abc.dao.GoodsDao;
import com.abc.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;

    /**
     * 根据父id查询所有的子商品
     * @param cid 父id
     * @return 父id下的所有的子商品
     */
    public List<Goods> sonGoodsAll(int cid){
        return goodsDao.sonGoodsAll(cid);
    }

    /**
     * 查询所有商品
     * @return 所有商品
     */
    public List<Goods> FindAllGoods(){ return goodsDao.FindAllGoods();}

    /**
     * 根据商品名称搜索商品
     * @param goodsName 商品名称
     * @return 搜索到的商品
     */
    public List<Goods> searchGoods(String goodsName){
        System.out.println(goodsName);
        List<Goods> goodsList = goodsDao.searchGoods("%"+goodsName+"%");
        return goodsList;
    }

    /**
     * 根据商品id查看商品详情
     * @param id 商品id
     * @return 商品详情
     */
    public Goods goodsDetails(int id){
        Goods goods = goodsDao.goodsDetails(id);
        return goods;
    }
}
