package com.example.oldagemanagmentsystem;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Food_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_food,new com.example.oldagemanagmentsystem.Stock_fragment()).commit();


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_food);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_food,
                    new com.example.oldagemanagmentsystem.Stock_fragment()).commit();
        }


    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_stock:
                            selectedFragment = new com.example.oldagemanagmentsystem.Stock_fragment();
                            break;
                        case R.id.nav_recipie:s:
                        selectedFragment = new com.example.oldagemanagmentsystem.Recipie_fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_food,
                            selectedFragment).commit();

                    return true;
                }
            };

    }
