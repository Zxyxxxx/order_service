package com.example.order_service.service.impl;

import com.example.order_service.domain.Order;
import com.example.order_service.service.OrderService;
import com.example.order_service.service.ProductClient;
import com.example.order_service.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 注入rabbon调用
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注入feign
     */
    @Autowired
    private ProductClient productClient;


    /**
     * 通过rabbion调用
     * @param userId
     * @param productId
     * @return
     */
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


    /**
     * 通过feign调用
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public Order saveByFeign(int userId, int productId) {
        //获取商品详情
        String response = productClient.findById(productId);
        JsonNode jsonNode = JsonUtil.str2JsonNode(response);
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setTradNo(UUID.randomUUID().toString());
        order.setProductName(jsonNode.get("name").toString());
        order.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return order;
    }



}
