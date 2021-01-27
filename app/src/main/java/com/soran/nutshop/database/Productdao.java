package com.soran.nutshop.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.soran.nutshop.model.Product;

import java.util.List;

@Dao
public interface Productdao {

    @Query("select * from Product")
    List<Product> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addProduct(Product product);

    @Delete
    void deleteProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Query("select sum(quantity) from product")
    int getSumQuantity();

}
