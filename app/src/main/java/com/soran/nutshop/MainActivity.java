package com.soran.nutshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.soran.nutshop.adapters.BasketAdapter;
import com.soran.nutshop.adapters.FragmentsAdapter;
import com.soran.nutshop.adapters.HomeProductAdapter;
import com.soran.nutshop.adapters.SliderAdapter;
import com.soran.nutshop.database.MyDataBase;
import com.soran.nutshop.databinding.ActivityMainBinding;
import com.soran.nutshop.fragments.BasketFragment;
import com.soran.nutshop.fragments.CategoryFragment;
import com.soran.nutshop.fragments.HomeFragment;
import com.soran.nutshop.fragments.ProfileFragment;
import com.soran.nutshop.listener.OnAddProduct;
import com.soran.nutshop.model.Product;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import ss.com.bannerslider.Slider;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
    MyDataBase myDataBase;
    Executor executor;
    List<Product> productList;
    BadgeDrawable badgeDrawable_basket;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDataBase = MyDataBase.getInstance(this);
        executor = Executors.newSingleThreadExecutor();

        Fragment homeFragment = new Fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mainLayout, homeFragment);


        bottomNavigationView = findViewById(R.id.bottonNavigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.homeAction:
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.man_fragment_container, new HomeFragment());
                        transaction.commit();
                        break;
                    case R.id.category:
                        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        transaction2.replace(R.id.man_fragment_container, new CategoryFragment());
                        transaction2.commit();
                        break;
                    case R.id.basket:
                        FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                        transaction3.replace(R.id.man_fragment_container, new BasketFragment());
                        transaction3.commit();
                        BadgeDrawable badgeDrawable_basket = binding.bottonNavigation.getBadge(R.id.basket);
                        badgeDrawable_basket.clearNumber();
                        badgeDrawable_basket.setVisible(false);

                        break;
                    case R.id.profile:
                        FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                        transaction4.replace(R.id.man_fragment_container, new ProfileFragment());
                        transaction4.commit();
                        break;
                }

                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.homeAction);

        updateCounter();
        badgeDrawable_basket = binding.bottonNavigation.getOrCreateBadge(R.id.basket);
        badgeDrawable_basket.setBackgroundColor(Color.RED);
        badgeDrawable_basket.setBadgeTextColor(Color.WHITE);
        badgeDrawable_basket.setMaxCharacterCount(4);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int summ = myDataBase.productdao().getSumQuantity();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        badgeDrawable_basket.setNumber(summ);
                        updateCounter();
                    }
                });
            }
        });

        badgeDrawable_basket.setVisible(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    public void updateCounter(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int summ = myDataBase.productdao().getSumQuantity();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        badgeDrawable_basket.setNumber(summ);
                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateCounter();
    }
}