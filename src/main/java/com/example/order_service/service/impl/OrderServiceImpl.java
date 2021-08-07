package com.example.order_service.service.impl;

import com.example.order_service.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public Order save(int userId, int productId) {

        //获取商品详情
        Object obj = restTemplate.getForObject("http://PRODUCT-SERVICE/api/v1/product/find?id="+productId,Object.class);
        System.out.println(obj);
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setTradNo(UUID.randomUUID().toString());
        return order;
    }
}
