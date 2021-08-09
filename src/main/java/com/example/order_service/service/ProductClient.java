package com.example.order_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用服务类
 */
@FeignClient(name = "product-service")//name指定需要调用的服务
public interface ProductClient {

    @RequestMapping("/api/v1/product/find")//调用商品服务中的接口，参数要一致
    String findById(@RequestParam("id") int id);





}
