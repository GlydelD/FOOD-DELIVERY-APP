package com.example.fooddeliveryapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.viewbinders.CartItemAdapter;
import com.example.fooddeliveryapp.entities.CartItem;
import com.example.fooddeliveryapp.data.DataInput;
import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView recyclerViewCart;
    private TextView totalPriceTextView;
    private Button checkoutButton;
    private CartItemAdapter cartItemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerViewCart = view.findViewById(R.id.recycler_view_cart);
        totalPriceTextView = view.findViewById(R.id.total_price);
        checkoutButton = view.findViewById(R.id.checkout_button);

        List<CartItem> cartItems = DataInput.getCartItems();
        cartItemAdapter = new CartItemAdapter(cartItems, (position) -> {

            DataInput.removeFromCart(position);
            updateUI();
        });

        recyclerViewCart.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewCart.setAdapter(cartItemAdapter);

//        update sa ui para sa total price
        updateUI();

        // for check out button
        checkoutButton.setOnClickListener(v -> {
            if (DataInput.getCartItems().isEmpty()) {
                Toast.makeText(getContext(), "your cart is empty", Toast.LENGTH_SHORT).show();
            } else {
                DataInput.placeOrder();
                Toast.makeText(getContext(), "order placed successfully!", Toast.LENGTH_SHORT).show();
                updateUI();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        cartItemAdapter.updateData(DataInput.getCartItems());
        totalPriceTextView.setText(String.format("₱%.2f", DataInput.getCartTotal()));
    }
}
