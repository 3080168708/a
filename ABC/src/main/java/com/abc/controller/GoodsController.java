package com.abc.controller;

import com.abc.pojo.Goods;
import com.abc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * 查询父id下的所有子商品
     * @param cid 父id
     * @param request
     * @return 父id下的所有子商品
     */
    @RequestMapping("sonGoodsAll")
    public String sonGoodsAll(Integer cid, HttpServletRequest request){
        System.out.println("1");
        //父id下的所有子商品
        List<Goods> sonGoods = goodsService.sonGoodsAll(cid);
        //存入session中 在页面循环输出
        request.getSession().setAttribute("sonGoods",sonGoods);
        //返回导航栏
        return "head";
    }

    /**
     * 查询所有商品 暂不使用
     * @param request
     * @return 所有商品
     */
    @RequestMapping("findAllGoods")
    public String findAllGoods(HttpServletRequest request){
        //所有商品
        List<Goods> allGoods = goodsService.FindAllGoods();
        //存入session域中 循环遍历输出
        request.getSession().setAttribute("allGoods",allGoods);
        //返回主页
        return "index";
    }

    /**
     * 根据商品名称搜索商品
     * @param goodsName 商品名称
     * @param request
     * @return 搜索到的商品
     */
    @RequestMapping("searchGoods")
    public String searGoodsName(String goodsName,HttpServletRequest request){
        //根据商品名称查到的商品
        List<Goods> searchResults = goodsService.searchGoods(goodsName);
        System.out.println(searchResults.size());
        //判断是否查到了商品
        if (searchResults.size()!=0){
            //查到了 存入session域中循环遍历输出
            request.getSession().setAttribute("searchResults",searchResults);
            //输出搜索到的商品的页面
            return "searchResults";
        }else{
            //没有搜索到商品的页面
            return "null";
        }
    }

    /**
     * 根据商品id查看商品详情
     * @param id 商品id
     * @param request
     * @return 商品详情
     */
    @RequestMapping("goodsDetails")
    public String goodsDetails(@RequestParam(value="id") Integer id,HttpServletRequest request){
        //根据商品id查询到的商品
        Goods goodsDetails = goodsService.goodsDetails(id);
        //存入session域中 取值输出
        request.getSession().setAttribute("goodsDetails",goodsDetails);
        //商品详情页
        return "goodsDetails";
    }
}
