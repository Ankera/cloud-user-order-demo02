package com.ankers.order.web;

import com.ankers.order.pojo.Order;
import com.ankers.order.pojo.User;
import com.ankers.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

   private static final String USER_SERVICE_URL = "http://userservice";

   @Autowired
   private OrderService orderService;

   @Autowired
   private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        Order order = orderService.queryOrderById(orderId);

        Long userId = order.getUserId();

//        String url = "http://localhost:8081/user/" + userId;
        // 解析urL地址获取被调用的微服务的额名称，然后去注册中心根据名称获取服务列表，最后负载均衡访问
        String url = USER_SERVICE_URL + "/user/" + userId;

        User user = restTemplate.getForObject(url, User.class);

        order.setUser(user);

        // 根据id查询订单并返回
        return order;
    }
}
