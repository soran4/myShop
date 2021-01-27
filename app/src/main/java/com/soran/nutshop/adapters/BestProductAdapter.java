package com.soran.nutshop.adapters;

import android.content.Context;
import android.graphics.Paint;
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


public class BestProductAdapter extends RecyclerView.Adapter<BestProductAdapter.MyViewHolder> {

    Context context;
    List<Product> productList;

    public BestProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_best_product, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);

        Glide.with(context).load(product.getImage_url()).into(holder.imageViewBest);

        holder.txt_name.setText(product.getName());
        holder.txt_bestPrice.setText(product.getPrice() + "");
        holder.txt_bestPrice.setPaintFlags(holder.txt_bestPrice.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewBest;
        TextView txt_name;
        TextView txt_bestPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewBest = itemView.findViewById(R.id.imageViewbest);
            txt_name = itemView.findViewById(R.id.txt_name_best);
            txt_bestPrice = itemView.findViewById(R.id.txt_price_best);
        }
    }
}
