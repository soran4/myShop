package com.soran.nutshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogIn;
    EditText editTextname;
    boolean isLogIn;
    public static final String LOGIN = "login";
    String name_txt;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        setUpVeiws();

    }

    private void setUpVeiws() {
        btnLogIn = findViewById(R.id.btnlLogIn);
        editTextname = findViewById(R.id.editext);
        btnLogIn.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        switch (viewID) {

            case R.id.btnlLogIn:

                nameValidation();

                break;

        }
    }

    private void nameValidation() {

        name_txt = editTextname.getText().toString().trim();

        if (name_txt.isEmpty()) {
            Toast.makeText(this, "لطفا نام خود را وارد کنید", Toast.LENGTH_SHORT).show();
        } else {
            saveName();
        }
    }

    private void saveName() {
        isLogIn = !isLogIn;

        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name_txt);
        editor.putBoolean("ISLOGIN",isLogIn);
        editor.apply();
        
        goToHome();
    }

    private void goToHome() {

        Intent intent = new Intent(LogInActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void sace(){
    }
}
