package com.example.fooddeliveryapp.entities;

public class FoodItem {
    private int id;
    private String name;
    private double price;
    private int imageResourceId;
    private int restaurantId;

    public FoodItem(int id, String name, double price, int imageResourceId, int restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.restaurantId = restaurantId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
}
