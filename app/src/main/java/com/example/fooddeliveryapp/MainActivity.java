package com.example.fooddeliveryapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.fooddeliveryapp.fragments.CartFragment;
import com.example.fooddeliveryapp.fragments.HomeFragment;
import com.example.fooddeliveryapp.fragments.MenuFragment;
import com.example.fooddeliveryapp.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for bottom nav
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();


        final Fragment homeFragment = new HomeFragment();
        final Fragment cartFragment = new CartFragment();
        final Fragment profileFragment = new ProfileFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();

        // for nav item selection listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                fragment = homeFragment;
            } else if (itemId == R.id.nav_cart) {
                fragment = cartFragment;
            } else if (itemId == R.id.nav_profile) {
                fragment = profileFragment;
            } else {
                fragment = homeFragment;
            }

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        });
    }
}
