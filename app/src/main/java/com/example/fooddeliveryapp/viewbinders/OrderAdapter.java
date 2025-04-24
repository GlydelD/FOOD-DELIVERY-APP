package com.example.fooddeliveryapp.viewbinders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.entities.Order;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<Order> orderList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault());

    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.orderIdTextView.setText(String.format("Order #%d", order.getId()));
        holder.orderDateTextView.setText(dateFormat.format(order.getOrderDate()));
        holder.orderTotalTextView.setText(String.format("₱%.2f", order.getTotal()));
        holder.orderStatusTextView.setText(order.getStatus());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void updateData(List<Order> newOrders) {
        this.orderList = newOrders;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderIdTextView;
        TextView orderDateTextView;
        TextView orderTotalTextView;
        TextView orderStatusTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderIdTextView = itemView.findViewById(R.id.order_id);
            orderDateTextView = itemView.findViewById(R.id.order_date);
            orderTotalTextView = itemView.findViewById(R.id.order_total);
            orderStatusTextView = itemView.findViewById(R.id.order_status);
        }
    }
}
