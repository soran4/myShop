package com.soran.nutshop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        listView = findViewById(R.id.listView_setting);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("پرسش های متداول");
        arrayList.add("درباره ی ما");
        arrayList.add("گزارش خظا");
        arrayList.add("تماس با ما");
        arrayList.add("حریم خصوصی");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}