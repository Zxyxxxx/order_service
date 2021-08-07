package com.example.order_service.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体类
 */
public class Order implements Serializable {

    private int id;
    //商品名称
    private String productName;
    //价格
    private int price;

    private Date createTime;
    //订单号
    private String tradNo;

    private int userId;

    private String userName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTradNo() {
        return tradNo;
    }

    public void setTradNo(String tradNo) {
        this.tradNo = tradNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
