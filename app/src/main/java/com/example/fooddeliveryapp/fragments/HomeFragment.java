package com.example.fooddeliveryapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.viewbinders.RestaurantAdapter;
import com.example.fooddeliveryapp.entities.Restaurant;
import com.example.fooddeliveryapp.data.DataInput;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewRestaurants;
    private RestaurantAdapter restaurantAdapter;
    private List<Restaurant> restaurantList;
    private SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewRestaurants = view.findViewById(R.id.recycler_view_restaurants);
        searchView = view.findViewById(R.id.search_view);

        // only show keyboard when user taps the searchview
        searchView.setOnQueryTextFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(searchView, InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });

        // for  recyclerview
        restaurantList = DataInput.getRestaurants();
        restaurantAdapter = new RestaurantAdapter(restaurantList, restaurantId -> {
            Bundle bundle = new Bundle();
            bundle.putInt("restaurant_id", restaurantId);

            MenuFragment menuFragment = new MenuFragment();
            menuFragment.setArguments(bundle);

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, menuFragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerViewRestaurants.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRestaurants.setAdapter(restaurantAdapter);

        // function for search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterRestaurants(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterRestaurants(newText);
                return false;
            }
        });

        return view;
    }

    private void filterRestaurants(String query) {
        List<Restaurant> filteredList = new ArrayList<>();
        if (query.isEmpty()) {
            filteredList.addAll(DataInput.getRestaurants());
        } else {
            String lowerCaseQuery = query.toLowerCase().trim();
            for (Restaurant restaurant : DataInput.getRestaurants()) {
                if (restaurant.getName().toLowerCase().contains(lowerCaseQuery)) {
                    filteredList.add(restaurant);
                }
            }
        }
        restaurantAdapter.updateData(filteredList);
    }
}
