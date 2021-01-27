package com.soran.nutshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.soran.nutshop.R;
import com.soran.nutshop.database.MyDataBase;
import com.soran.nutshop.listener.OnAddProduct;
import com.soran.nutshop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.MyViewHolder> implements View.OnClickListener {

    Context context;
    List<Product> productList;
    OnAddProduct onAddProduct;

    public HomeProductAdapter(Context context, List<Product> productList, OnAddProduct onAddProduct) {
        this.context = context;
        this.productList = productList;
        this.onAddProduct = onAddProduct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main_product, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = productList.get(position);

        Glide.with(context).load(product.getImage_url()).into(holder.imageViewBest);

        holder.txt_name.setText(product.getName());
        holder.txt_bestPrice.setText(product.getPrice() + "");

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void filterList(ArrayList<Product> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements com.soran.nutshop.adapters.MyViewHolder {
        ImageView imageViewBest;
        TextView txt_name;
        TextView txt_bestPrice;
        Button btn_addToBasket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewBest = itemView.findViewById(R.id.imageViewMain);
            txt_name = itemView.findViewById(R.id.txt_name_main);
            txt_bestPrice = itemView.findViewById(R.id.txt_price_main);
            btn_addToBasket = itemView.findViewById(R.id.btn_addToBasket);
            btn_addToBasket.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            Product product = productList.get(getAdapterPosition());
            product.setQuantity(product.getQuantity() + 1);
            MyDataBase myDataBase = MyDataBase.getInstance(context);

            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    myDataBase.productdao().addProduct(product);

                }
            });
            onAddProduct.onProductAdded();
        }
    }


}
