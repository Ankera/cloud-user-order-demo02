package com.ankers.order.service;

import com.ankers.api.UserFeignClient;
import com.ankers.order.mapper.OrderMapper;
import com.ankers.order.pojo.Order;
import com.ankers.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private static final String USER_SERVICE_URL = "http://userservice";

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

//        Long userId = order.getUserId();
//
//        String url = USER_SERVICE_URL + "/user/" + userId;
//
//        User user = restTemplate.getForObject(url, User.class);
//
//        order.setUser(user);

        User user = userFeignClient.queryById(order.getUserId());
        user.setUsername(user.getUsername() + "<h1>这是修改的</h1>");
        order.setUser(user);

        // 4.返回
        return order;
    }
}
