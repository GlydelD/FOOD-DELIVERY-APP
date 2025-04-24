package com.example.fooddeliveryapp.viewbinders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final int[] imageResIds;

    public interface OnContinueClickListener {
        void onContinueClick();
    }

    private final OnContinueClickListener listener;

    public ImageAdapter(int[] imageResIds, OnContinueClickListener listener) {
        this.imageResIds = imageResIds;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(imageResIds[position]);

        if (position == 1) { // second page
            holder.continueButton.setVisibility(View.VISIBLE);
            holder.continueButton.setOnClickListener(v -> listener.onContinueClick());
        } else {
            holder.continueButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return imageResIds.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        Button continueButton;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.backgroundImage);
            continueButton = itemView.findViewById(R.id.continueButton);
        }
    }
}
