package com.example.order_service.controller;


import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrederController {


    @Autowired
    private OrderService orderService;


    /**
     * 创建订单
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping("/save")
    public Object save(@RequestParam("user_id") int userId,@RequestParam("product_id") int productId){
        //ribbon调用
        //        return orderService.save(userId,productId);
        //feign调用
        return orderService.saveByFeign(userId,productId);
    }





}
