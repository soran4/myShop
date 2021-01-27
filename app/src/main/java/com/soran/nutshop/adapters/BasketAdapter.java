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
import com.soran.nutshop.listener.OnAdapterUpdate;
import com.soran.nutshop.model.Product;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.BasketViewHolder> {
    List<Product> productList;
    Context context;
    OnAdapterUpdate onAdapterUpdate;
    MyDataBase myDataBase;
    Executor executor = Executors.newSingleThreadExecutor();

    public BasketAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
        this.myDataBase = MyDataBase.getInstance(context);
    }

    public void setOnAdapterUpdate(OnAdapterUpdate onAdapterUpdate) {
        this.onAdapterUpdate = onAdapterUpdate;
    }

    @NonNull
    @Override
    public BasketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_basket, parent, false);
        return new BasketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasketViewHolder holder, int position) {

        Product product = productList.get(position);

        Glide.with(context).load(product.getImage_url()).into(holder.imageViewBasket);
        holder.textViewPrice.setText(product.getPrice() + "");
        holder.textViewName.setText(product.getName());
        holder.textNumbQuantity.setText(product.getQuantity() + "");

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class BasketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageViewBasket;
        TextView textViewPrice;
        TextView textViewName;
        TextView textNumbQuantity;
        ImageView buttonAddQuantity;
        ImageView buttonRemoveQuantity;
        ImageView imgRemoveProduct;

        public BasketViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewBasket = itemView.findViewById(R.id.imageViewBaskett);
            textViewName = itemView.findViewById(R.id.productNameBasket);
            textViewPrice = itemView.findViewById(R.id.productPriceBasket);
            textNumbQuantity = itemView.findViewById(R.id.txt_numb_basket);
            buttonAddQuantity = itemView.findViewById(R.id.img_add_basket);
            buttonRemoveQuantity = itemView.findViewById(R.id.img_remove_basket);
            imgRemoveProduct = itemView.findViewById(R.id.imgRemoveProduct);

            buttonAddQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToProductQuantity(productList.get(getAdapterPosition()));
                }
            });

            buttonRemoveQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reduceProductQuantity(productList.get(getAdapterPosition()));
                }
            });

            imgRemoveProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteProduct(productList.get(getAdapterPosition()));
                }
            });

        }

        @Override
        public void onClick(View v) {

        }

        public void addToProductQuantity(Product product) {

            product.setQuantity(product.getQuantity() + 1);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    myDataBase.productdao().addProduct(product);
                }
            });
            onAdapterUpdate.onAdapterUpdate();

        }

        public void reduceProductQuantity(Product product) {

            if (product.getQuantity() > 1) {
                product.setQuantity(product.getQuantity() - 1);
            }
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    myDataBase.productdao().addProduct(product);
                }
            });
            onAdapterUpdate.onAdapterUpdate();
        }
    }

    public void deleteProduct(Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    myDataBase.productdao().deleteProduct(product);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        productList.remove(product);
        onAdapterUpdate.onAdapterUpdate();
    }

    public void adapterUpdaite(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
