package com.example.fooddeliveryapp.viewbinders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.entities.CartItem;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {

    private List<CartItem> cartItemList;
    private OnRemoveItemListener listener;

    public interface OnRemoveItemListener {
        void onRemoveItem(int position);
    }

    public CartItemAdapter(List<CartItem> cartItemList, OnRemoveItemListener listener) {
        this.cartItemList = cartItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem cartItem = cartItemList.get(position);

        holder.foodImageView.setImageResource(cartItem.getFoodItem().getImageResourceId());
        holder.foodNameTextView.setText(cartItem.getFoodItem().getName());
        holder.quantityTextView.setText(String.valueOf(cartItem.getQuantity()));
        holder.priceTextView.setText(String.format("₱%.2f",
                cartItem.getFoodItem().getPrice() * cartItem.getQuantity()));

        holder.removeButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRemoveItem(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public void updateData(List<CartItem> newCartItems) {
        this.cartItemList = newCartItems;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;
        TextView quantityTextView;
        TextView priceTextView;
        ImageButton removeButton;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.cart_food_image);
            foodNameTextView = itemView.findViewById(R.id.cart_food_name);
            quantityTextView = itemView.findViewById(R.id.cart_quantity);
            priceTextView = itemView.findViewById(R.id.cart_price);
            removeButton = itemView.findViewById(R.id.remove_button);
        }
    }
}