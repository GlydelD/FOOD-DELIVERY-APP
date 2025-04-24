package com.example.fooddeliveryapp.entities;

public class Restaurant {
    private int id;
    private String name;
    private float rating;
    private int imageResourceId;

    public Restaurant(int id, String name, float rating, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public static class User {
        private int id;
        private String name;
        private String email;
        private String phone;

        public User(int id, String name, String email, String phone) {
            this.id = id;
            this.name = name;
            this.email = email;
                    this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }
    }
}
