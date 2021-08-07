package com.example.order_service.service.impl;


import com.example.order_service.domain.Order;

public interface OrderService {



    Order save(int userId, int productId);


}
