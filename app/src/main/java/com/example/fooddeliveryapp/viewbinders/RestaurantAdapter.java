package com.example.fooddeliveryapp.viewbinders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.entities.Restaurant;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurant> restaurantList;
    private OnRestaurantClickListener listener;

    public interface OnRestaurantClickListener {
        void onRestaurantClick(int restaurantId);
    }

    public RestaurantAdapter(List<Restaurant> restaurantList, OnRestaurantClickListener listener) {
        this.restaurantList = restaurantList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);

        holder.restaurantImageView.setImageResource(restaurant.getImageResourceId());
        holder.restaurantNameTextView.setText(restaurant.getName());
        holder.ratingBar.setRating(restaurant.getRating());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRestaurantClick(restaurant.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public void updateData(List<Restaurant> newRestaurants) {
        this.restaurantList = newRestaurants;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView restaurantImageView;
        TextView restaurantNameTextView;
        RatingBar ratingBar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImageView = itemView.findViewById(R.id.restaurant_image);
            restaurantNameTextView = itemView.findViewById(R.id.restaurant_name);
            ratingBar = itemView.findViewById(R.id.rating_bar);
        }
    }
}