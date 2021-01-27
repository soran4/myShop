package com.soran.nutshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.soran.nutshop.R;
import com.soran.nutshop.model.Product;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    Context context;
    List<Product> productList;

    public CategoryAdapter(Context context, List<Product> products) {
        this.context = context;
        this.productList = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Product product = productList.get(position);
        Glide.with(context)
                .load(product.getImage_url()).into(holder.imageViewProduct);
        holder.txt_Price.setText(product.getPrice()+"");
        holder.txt_name.setText(product.getName());

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView txt_Price;
        TextView txt_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(com.soran.nutshop.R.id.img_category);
            txt_Price = itemView.findViewById(R.id.txt_price_category);
            txt_name = itemView.findViewById(R.id.txt_name_categoty);


        }
    }
}
