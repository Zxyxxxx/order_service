package com.example.order_service.service;


import com.example.order_service.domain.Order;

public interface OrderService {



    Order save(int userId, int productId);

    Order saveByFeign(int userId, int productId);


}
