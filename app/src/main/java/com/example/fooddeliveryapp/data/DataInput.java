package com.example.fooddeliveryapp.data;

import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.entities.CartItem;
import com.example.fooddeliveryapp.entities.FoodItem;
import com.example.fooddeliveryapp.entities.Order;
import com.example.fooddeliveryapp.entities.Restaurant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataInput {

    private DataInput() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    private static List<Restaurant> restaurants = new ArrayList<>();
    private static List<FoodItem> foodItems = new ArrayList<>();
    private static List<CartItem> cartItems = new ArrayList<>();
    private static List<Order> orderHistory = new ArrayList<>();
    private static Restaurant.User currentUser;
    private static int nextOrderId = 1;

    static {
        restaurants.add(new Restaurant(1, "Ilustrado", 4.5f, R.drawable.restaurant_1));
        restaurants.add(new Restaurant(2, "Bistros Remedios", 4.3f, R.drawable.restaurant_2));
        restaurants.add(new Restaurant(3, "Jollibee", 4.7f, R.drawable.restaurant_3));
        restaurants.add(new Restaurant(4, "Burger King", 4.1f, R.drawable.restaurant_4));
        restaurants.add(new Restaurant(5, "Pizza Hut", 4.4f, R.drawable.restaurant_5));
        restaurants.add(new Restaurant(6, "Alibaba Shawarma", 4.4f, R.drawable.restaurant_6));

        foodItems.add(new FoodItem(1, "Chicken Adobo", 149.00, R.drawable.food_1, 1));
        foodItems.add(new FoodItem(2, "Lumpia", 120.00, R.drawable.food_2, 1));
        foodItems.add(new FoodItem(3, "Humba", 180.00, R.drawable.food_3, 1));
        foodItems.add(new FoodItem(4, "Pinakbet", 130.00, R.drawable.food_4, 1));
        foodItems.add(new FoodItem(5, "Puto", 65.00, R.drawable.food_5, 1));
        foodItems.add(new FoodItem(6, "Tortang Talong", 140.00, R.drawable.food_6, 1));

        foodItems.add(new FoodItem(7, "Relyenong Talong", 160.00, R.drawable.food_7, 2));
        foodItems.add(new FoodItem(8, "Pork Adobo", 170.00, R.drawable.food_8, 2));
        foodItems.add(new FoodItem(9, "Chicken Adobo", 150.00, R.drawable.food_9, 2));
        foodItems.add(new FoodItem(10, "Fried Chicken", 200.00, R.drawable.food_10, 2));
        foodItems.add(new FoodItem(11, "Halo-halo", 90.00, R.drawable.food_11, 2));
        foodItems.add(new FoodItem(12, "Buttered Shrimp", 180.00, R.drawable.food_12, 2));

        foodItems.add(new FoodItem(13, "Chicken Burger", 150.00, R.drawable.food_13, 3));
        foodItems.add(new FoodItem(14, "Jolly Fries", 60.00, R.drawable.food_14, 3));
        foodItems.add(new FoodItem(15, "Jolly Fried Chicken", 180.00, R.drawable.food_15, 3));
        foodItems.add(new FoodItem(16, "Jolly Spaghetti", 85.00, R.drawable.food_16, 3));
        foodItems.add(new FoodItem(17, "Jollibee Palabok", 120.00, R.drawable.food_17, 3));
        foodItems.add(new FoodItem(18, "Jollibee Sundae", 50.00, R.drawable.food_18, 3));

        foodItems.add(new FoodItem(19, "Burger King Chicken King", 190.00, R.drawable.food_19, 4));
        foodItems.add(new FoodItem(20, "BBQ Bacon", 170.00, R.drawable.food_20, 4));
        foodItems.add(new FoodItem(21, "Grilled Cheese Burger", 120.00, R.drawable.food_21, 4));
        foodItems.add(new FoodItem(22, "Quarter Pound", 110.00, R.drawable.food_22, 4));
        foodItems.add(new FoodItem(23, "King Fries", 70.00, R.drawable.food_23, 4));
        foodItems.add(new FoodItem(24, "Mozarella Sticks", 90.00, R.drawable.food_24, 4));

        foodItems.add(new FoodItem(25, "Hawaiian", 250.00, R.drawable.food_25, 5));
        foodItems.add(new FoodItem(26, "Seafood Deluxe", 320.00, R.drawable.food_26, 5));
        foodItems.add(new FoodItem(27, "Pepperoni", 230.00, R.drawable.food_27, 5));
        foodItems.add(new FoodItem(28, "Ham and Cheese", 210.00, R.drawable.food_28, 5));
        foodItems.add(new FoodItem(29, "Fajita Pepperoni", 280.00, R.drawable.food_29, 5));
        foodItems.add(new FoodItem(30, "Broccoli Pizza", 260.00, R.drawable.food_30, 5));

        foodItems.add(new FoodItem(31, "Chicken Shawarma", 120.00, R.drawable.food_31, 6));
        foodItems.add(new FoodItem(32, "Grilled Shawarma", 150.00, R.drawable.food_32, 6));
        foodItems.add(new FoodItem(33, "Veggie Shawarma", 100.00, R.drawable.food_33, 6));
        foodItems.add(new FoodItem(34, "Beef Shawarma", 130.00, R.drawable.food_34, 6));
        foodItems.add(new FoodItem(35, "Pork Shawarma", 140.00, R.drawable.food_35, 6));
        foodItems.add(new FoodItem(36, "Fried Shawarma", 135.00, R.drawable.food_36, 6));

        List<CartItem> pastOrder1Items = new ArrayList<>();
        pastOrder1Items.add(new CartItem(getFoodItemById(1), 2));
        pastOrder1Items.add(new CartItem(getFoodItemById(4), 1));

        List<CartItem> pastOrder2Items = new ArrayList<>();
        pastOrder2Items.add(new CartItem(getFoodItemById(6), 1));
        pastOrder2Items.add(new CartItem(getFoodItemById(10), 1));

        List<CartItem> pastOrder3Items = new ArrayList<>();
        pastOrder3Items.add(new CartItem(getFoodItemById(8), 1));
        pastOrder3Items.add(new CartItem(getFoodItemById(4), 1));

//        time and date for default data
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_MONTH, -7);
        calendar1.set(Calendar.HOUR, 8);
        calendar1.set(Calendar.AM_PM, Calendar.PM);
        calendar1.set(Calendar.MINUTE, 0);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_MONTH, -5);
        calendar2.set(Calendar.HOUR, 12);
        calendar2.set(Calendar.AM_PM, Calendar.PM);
        calendar2.set(Calendar.MINUTE, 20);

        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(Calendar.DAY_OF_MONTH, -3);
        calendar3.set(Calendar.HOUR, 5);
        calendar3.set(Calendar.AM_PM, Calendar.PM);
        calendar3.set(Calendar.MINUTE, 8);

//        default data for profile order history
        orderHistory.add(new Order(nextOrderId++, pastOrder1Items, 260.97,
                calendar1.getTime(), "Delivered"));

        orderHistory.add(new Order(nextOrderId++, pastOrder2Items, 180.98,
                calendar2.getTime(), "Canceled"));

        orderHistory.add(new Order(nextOrderId++, pastOrder3Items, 547.98,
                calendar3.getTime(), "Delivered"));

        currentUser = new Restaurant.User(1, "James na Red", "jamered@example.com", "0936746734");
    }

    public static List<Restaurant> getRestaurants() {
        return new ArrayList<>(restaurants);
    }

    public static Restaurant getRestaurantById(int id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == id) {
                return restaurant;
            }
        }
        return null;
    }

    public static List<FoodItem> getFoodItemsByRestaurantId(int restaurantId) {
        List<FoodItem> result = new ArrayList<>();
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getRestaurantId() == restaurantId) {
                result.add(foodItem);
                if (result.size() == 6) break;
            }
        }
        return result;
    }

    public static FoodItem getFoodItemById(int id) {
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getId() == id) {
                return foodItem;
            }
        }
        return null;
    }

    public static List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public static void addToCart(FoodItem foodItem, int quantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getFoodItem().getId() == foodItem.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(foodItem, quantity));
    }

    public static void removeFromCart(int position) {
        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
        }
    }

    public static double getCartTotal() {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }

    public static void placeOrder() {
        if (!cartItems.isEmpty()) {
            Order order = new Order(
                    nextOrderId++,
                    new ArrayList<>(cartItems),
                    getCartTotal(),
                    new Date(),
                    "Processing"
            );
            orderHistory.add(order);
            cartItems.clear();
        }
    }

    public static List<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

    public static Restaurant.User getCurrentUser() {
        return currentUser;
    }

    public static String getFormattedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
        return formatter.format(date);
    }
}
