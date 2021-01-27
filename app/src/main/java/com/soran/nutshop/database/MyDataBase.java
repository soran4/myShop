package com.soran.nutshop.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.soran.nutshop.model.Product;

@Database(entities = Product.class,exportSchema = false,version = 1)
public abstract class MyDataBase extends RoomDatabase {
    public static final String DB_NAME = "database";
    static MyDataBase instance;

    public static synchronized MyDataBase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context,
                    MyDataBase.class,
                    DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract Productdao productdao();

}
