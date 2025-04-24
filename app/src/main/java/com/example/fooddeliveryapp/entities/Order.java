package com.example.fooddeliveryapp.entities;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private List<CartItem> items;
    private double total;
    private Date orderDate;
    private String status;

    public Order(int id, List<CartItem> items, double total, Date orderDate, String status) {
        this.id = id;
        this.items = items;
        this.total = total;
        this.orderDate = orderDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }
}