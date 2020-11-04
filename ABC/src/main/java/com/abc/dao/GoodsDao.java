package com.abc.dao;

import com.abc.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsDao {

    /**
     *  根据父id查询所有的子商品
     * @param cid 父id
     * @return 父id下的所有子商品
     */
    List<Goods> sonGoodsAll(int cid);


    /**
     * 查询所有商品
     * @return 所有商品
     */
    List<Goods>FindAllGoods();


    /**
     * 根据商品名称搜索商品
     * @param goodsName 商品名称
     * @return 搜索到的商品
     */
    List<Goods> searchGoods(String goodsName);


    /**
     * 根据商品id查看商品详情
     * @param id 商品id
     * @return 商品详情
     */
    Goods goodsDetails(int id);
}
