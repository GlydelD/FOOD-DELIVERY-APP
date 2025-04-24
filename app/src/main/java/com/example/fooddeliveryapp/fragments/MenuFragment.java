package com.example.fooddeliveryapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.viewbinders.FoodItemAdapter;
import com.example.fooddeliveryapp.entities.FoodItem;
import com.example.fooddeliveryapp.entities.Restaurant;
import com.example.fooddeliveryapp.data.DataInput;
import java.util.List;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerViewMenu;
    private TextView restaurantNameTextView;
    private FoodItemAdapter foodItemAdapter;
    private int restaurantId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // for getting restaurant ID from arguments
        if (getArguments() != null) {
            restaurantId = getArguments().getInt("restaurant_id", 0);
        }

        recyclerViewMenu = view.findViewById(R.id.recycler_view_menu);
        restaurantNameTextView = view.findViewById(R.id.restaurant_name);

        // for getting restaurant and food items
        Restaurant restaurant = DataInput.getRestaurantById(restaurantId);
        List<FoodItem> foodItems = DataInput.getFoodItemsByRestaurantId(restaurantId);

        // for  restaurant name
        if (restaurant != null) {
            restaurantNameTextView.setText(restaurant.getName());
        }

        foodItemAdapter = new FoodItemAdapter(foodItems, (foodItem, quantity) -> {
            //pang add sa food sa cart
            DataInput.addToCart(foodItem, quantity);
        });

        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMenu.setAdapter(foodItemAdapter);

        return view;
    }
}