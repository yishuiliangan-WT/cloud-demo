package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2、利用RestTemplate发起http请求，查询用户
        //String url="http://locahost:8080/user/"+order.getUserId();
        String url="http://userservice/user/"+order.getUserId();  //用服务名称代替IP
        //发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);  //发送请求返回的是json格式数据，但需要返回user类型，所以调用User.class
        //封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
