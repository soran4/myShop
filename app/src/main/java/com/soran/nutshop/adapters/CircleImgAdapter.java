package com.soran.nutshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.soran.nutshop.R;
import com.soran.nutshop.model.Product;

import java.util.List;


public class CircleImgAdapter extends RecyclerView.Adapter<CircleImgAdapter.MyViewHolder> {

    Context context;
    List<Product> productList;

    public CircleImgAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_circle_img, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);

        Glide.with(context).load(product.getImage_url()).into(holder.circleImage);


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView circleImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImage = itemView.findViewById(R.id.circleImage);

        }
    }
}
