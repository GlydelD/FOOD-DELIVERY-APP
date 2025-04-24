package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fooddeliveryapp.viewbinders.ImageAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class FrontActivity extends AppCompatActivity {

    private final int[] imageResIds = {
            R.drawable.page_1,
            R.drawable.page_2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_front);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        CircleIndicator3 dotsIndicator = findViewById(R.id.dotsIndicator);

        ImageAdapter adapter = new ImageAdapter(imageResIds, () -> {
            Intent intent = new Intent(FrontActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
    }
}
