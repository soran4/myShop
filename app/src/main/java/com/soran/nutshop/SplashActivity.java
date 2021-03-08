package com.soran.nutshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    public static final String LOGIN = "login";
    boolean isLogIn = false;
    ImageView img_splash;
    TextView textView;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getData();

        img_splash = findViewById(R.id.img_splash);
        textView = findViewById(R.id.textViewSplash);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        img_splash.setAnimation(animation);

        textView.setAnimation(animation);

        if (isLogIn){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },4000);

        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this,LogInActivity.class);
                    startActivity(intent);
                    finish();
                }
            },4000);

        }



    }

    private  void getData(){

        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,MODE_PRIVATE);
        isLogIn = sharedPreferences.getBoolean("ISLOGIN",false);


    }

}