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
import com.example.fooddeliveryapp.entities.Order;
import com.example.fooddeliveryapp.data.DataInput;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class ProfileFragment extends Fragment {

    private CircleImageView profileImageView;
    private TextView userNameTextView;
    private RecyclerView recyclerViewOrders;
    private FoodItemAdapter.OrderAdapter orderAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileImageView = view.findViewById(R.id.profile_image);
        userNameTextView = view.findViewById(R.id.user_name);
        recyclerViewOrders = view.findViewById(R.id.recycler_view_orders);

        // user details na mock :)
        userNameTextView.setText(DataInput.getCurrentUser().getName());
        profileImageView.setImageResource(R.drawable.profile);

        // pang  recyclerview para sa  order history
        List<Order> orderList = DataInput.getOrderHistory();
        orderAdapter = new FoodItemAdapter.OrderAdapter(orderList);

        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewOrders.setAdapter(orderAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // for updating order history
        orderAdapter.updateData(DataInput.getOrderHistory());
    }
}