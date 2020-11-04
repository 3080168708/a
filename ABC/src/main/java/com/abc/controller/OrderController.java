package com.abc.controller;

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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@ContextConfiguration(locations={"classpath:spring/spring.xml"})
public class OrderController {
    //购物车的service层
    @Autowired
    ShopPingCartService shopPingCartService;
    //商品的service层
    @Autowired
    GoodsService goodsService;
    //待收货集合
    static List<ShopPingCart> stayReceivings=new ArrayList<>();
    //未付款集合
    static List<Goods>stayPayments=new ArrayList<>();
    static List<ShopPingCart> stayShipments=new ArrayList<>();
    /**
     * 结算商品
     * @param request
     * @return 结算之后商家没发货的商品
     */
    @RequestMapping("stayShipments")
    public String Empty( HttpServletRequest request){
        //获取域对象
        HttpSession session=request.getSession();
        //取出购物车中剩余数据
        List<ShopPingCart> ShopPingCartList = (List<ShopPingCart>) session.getAttribute("UserShopPingCarts");
        //待发货集合
//        List<ShopPingCart> stayShipments=new ArrayList<>();
        //把剩余的数据加到待发货集合中
        stayShipments.addAll(ShopPingCartList);
        //存入域中
        session.setAttribute("stayShipments",stayShipments);
//        //转移数据 把购物车中的数据转移到已购买表中
//        for (ShopPingCart shopPingCart : ShopPingCartList) {
//            orderService.insertPurchasedGoods(shopPingCart);
//        }
        //结算购物车商品 清空购物车数据
        shopPingCartService.EmptyShopPingCart();
        //返回待发货页面 输出待发货的商品
        return "待发货";
    }

    /**
     * 将待发货中的商品发出
     * @param id 商品Id
     * @param request
     * @return 还未发货的商品
     */
    @RequestMapping("Shipments")
    public String shipments(Integer id,HttpServletRequest request){
        System.out.println(id);
        //获取待发货的商品
//        List<ShopPingCart> stayShipmentsList = (List<ShopPingCart>) request.getSession().getAttribute("stayShipments");
        //遍历待发货的所有商品stayShipments stayShipmentsList
        for (ShopPingCart shopPingCart : stayShipments) {
            //判断与发货商品id相同的商品 Integer类型如果使用==比较的是地址值
            if(shopPingCart.getId().equals(id)){
                System.out.println(shopPingCart);
                //把发货的商品 添加到待收货中
                //创建待收货集合
                stayReceivings.add(shopPingCart);
                //把待收货存入域中
                request.getSession().setAttribute("stayReceivings",stayReceivings);
                //删除与发货商品id相同的商品
                stayShipments.remove(shopPingCart);
//                //创建新的待发货
//                List<ShopPingCart> stayShipments=new ArrayList<>();
                //把剩余待发货的商品添加到待发货中
//                stayShipments.addAll(stayShipments);
                //把待发货存入域中
                request.getSession().setAttribute("stayShipments",stayShipments);
                return "待发货";
            }
        }
        return "待发货";
    }

    /**
     *  取消本次付款
      * @return
     */
    @RequestMapping("cancelBuy")
    public String cancelBuy(Integer id,HttpServletRequest request) throws sysException{
            User shoppingUser = (User) request.getSession().getAttribute("shoppingUser");
            if (shoppingUser==null){
                throw new sysException("当前未登录");
            }
        //根据取消购买的商品的id 获取到取消购买的商品
        System.out.println(id);
        Goods orderDetails = goodsService.goodsDetails(id);
        request.getSession().setAttribute("orderDetails",orderDetails);
        System.out.println(orderDetails+"1");
        //把未付款商品添加到待付款
        stayPayments.add(orderDetails);
        //把待付款存入域中
        request.getSession().setAttribute("stayPayments",stayPayments);
//        回到商品页
        return "orderDetails";
    }

    /**
     * 删除订单
     * @param id 商品id
     * @param request
     * @return 删除订单之后剩余的订单
     */
    @RequestMapping("deleteOrder")
    public String deleteOrder(int id,HttpServletRequest request){
        //获取待付款集合
        List<Goods> payments = (List<Goods>) request.getSession().getAttribute("stayPayments");
        //遍历待付款的商品
        for (Goods payment : payments) {
            if (payment.getId()==id){
                //删除已经购买的商品
                payments.remove(payment);
                //重新创建待付款集合
                List<Goods>stayPayments=new ArrayList<>();
                //把剩余待付款商品添加
                stayPayments.addAll(payments);
                //存入域中
                request.getSession().setAttribute("stayPayments",stayPayments);
                return "待付款";
            }
        }
        return "待付款";
    }

    /**
     * 购买商品加入待发货
     * @param id 购买的商品的id
     * @param goodsTotal 购买的商品的数量
     * @param request
     * @return 待发货
     */
    @RequestMapping("payOrder")
    public String payOrder(Integer id,int goodsTotal,HttpServletRequest request){
        //获取登录的用户
        User shoppingUser = (User) request.getSession().getAttribute("shoppingUser");
        String username = shoppingUser.getUsername();
        //获取要购买的商品的信息
        Goods goods = goodsService.goodsDetails(id);
        //获取商品名称
        String goodsName = goods.getPname();
        //获取商品价格
        double goodsPrice = goods.getPrice();
        //把获取到的信息存入到商品中
        ShopPingCart shopPingCart = new ShopPingCart(id, username, goodsName, goodsPrice, goodsTotal, goodsPrice * goodsPrice);
        //获取待发货集合
//        List<ShopPingCart> stayShipments = (List<ShopPingCart>) request.getSession().getAttribute("stayShipments");
        //添加已经购买的商品
        stayShipments.add(shopPingCart);
        //把待发货集合存入
        request.getSession().setAttribute("stayShipments",stayShipments);
        return "待发货";
    }

    @RequestMapping("Receivings")
    public String Receiving(int id,HttpServletRequest request){
        //获取待收货集合
        List<ShopPingCart> Receiving = (List<ShopPingCart>) request.getSession().getAttribute("stayReceivings");
        //遍历待收货
        for (ShopPingCart shopPingCart : Receiving) {
            //删除已经收货的商品
            if (shopPingCart.getId().equals(id)){
                Receiving.remove(shopPingCart);
                //重新创新待收货集合
                List<ShopPingCart> stayReceivings=new ArrayList<>();
                //把剩余待收货商品添加进去
                stayReceivings.addAll(Receiving);
                return "待收货";
            }
        }
        return "待收货";
    }

    /**
     * 点击立即 检查当前是否登录
     * @param request
     * @return
     * @throws sysException
     */
    @RequestMapping("atonce")
    public String atonce(HttpServletRequest request) throws  sysException{
        //获取登录的用户
        User shoppingUser = (User) request.getSession().getAttribute("shoppingUser");
        if (shoppingUser==null){
            throw new sysException("当前未登录");
        }else{
            return "buyPage";
        }
    }

    /**
     * 点击我的 检查当前是否登录
     * @param request
     * @return
     * @throws sysException
     */
    @RequestMapping("my")
    public String my(HttpServletRequest request) throws sysException{
        User shoppingUser = (User) request.getSession().getAttribute("shoppingUser");
        if (shoppingUser==null){
            throw new sysException("当前未登录");
        }else{
            return "my";
        }
    }
}
//要刷新就new 不刷新就属性
