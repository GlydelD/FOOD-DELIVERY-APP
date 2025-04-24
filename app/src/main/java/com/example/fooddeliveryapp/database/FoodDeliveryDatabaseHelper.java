package com.example.fooddeliveryapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDeliveryDatabaseHelper extends SQLiteOpenHelper {
//wala pay pulos yati
    private static final String DATABASE_NAME = "food_delivery.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "users";
    public static final String TABLE_RESTAURANT = "restaurants";
    public static final String TABLE_FOOD_ITEM = "food_items";
    public static final String TABLE_ORDER = "orders";
    public static final String TABLE_ORDER_ITEMS = "order_items";

    public FoodDeliveryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USER + " (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "email TEXT," +
                "phone TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_RESTAURANT + " (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "rating REAL," +
                "imageResourceId INTEGER)");

        db.execSQL("CREATE TABLE " + TABLE_FOOD_ITEM + " (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "price REAL," +
                "imageResourceId INTEGER," +
                "restaurantId INTEGER," +
                "FOREIGN KEY(restaurantId) REFERENCES " + TABLE_RESTAURANT + "(id))");

        db.execSQL("CREATE TABLE " + TABLE_ORDER + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "total REAL," +
                "orderDate TEXT," +
                "status TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_ORDER_ITEMS + " (" +
                "orderId INTEGER," +
                "foodItemId INTEGER," +
                "quantity INTEGER," +
                "FOREIGN KEY(orderId) REFERENCES " + TABLE_ORDER + "(id)," +
                "FOREIGN KEY(foodItemId) REFERENCES " + TABLE_FOOD_ITEM + "(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    // Example insert methods
    public long insertUser(int id, String name, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        return db.insert(TABLE_USER, null, values);
    }

    public long insertRestaurant(int id, String name, float rating, int imageResourceId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("rating", rating);
        values.put("imageResourceId", imageResourceId);
        return db.insert(TABLE_RESTAURANT, null, values);
    }

    public long insertFoodItem(int id, String name, double price, int imageResourceId, int restaurantId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("price", price);
        values.put("imageResourceId", imageResourceId);
        values.put("restaurantId", restaurantId);
        return db.insert(TABLE_FOOD_ITEM, null, values);
    }
}
