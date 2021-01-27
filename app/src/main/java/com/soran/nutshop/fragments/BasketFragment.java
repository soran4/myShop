package com.soran.nutshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soran.nutshop.R;
import com.soran.nutshop.adapters.BasketAdapter;
import com.soran.nutshop.database.MyDataBase;
import com.soran.nutshop.listener.OnAdapterUpdate;
import com.soran.nutshop.listener.OnAddProduct;
import com.soran.nutshop.model.Product;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BasketFragment extends Fragment {
    BasketAdapter basketAdapter;
    MyDataBase myDataBase;
    Executor executor = Executors.newSingleThreadExecutor();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.basket_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDataBase = MyDataBase.getInstance(getActivity());
        Executor executor = Executors.newSingleThreadExecutor();
        RecyclerView recyclerView = view.findViewById(R.id.recyclearBasket);


        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Product> productList = myDataBase.productdao().getAllProducts();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        basketAdapter = new BasketAdapter(productList, getActivity());
                        basketAdapter.setOnAdapterUpdate(new OnAdapterUpdate() {
                            @Override
                            public void onAdapterUpdate() {
                                basketAdapter.notifyDataSetChanged();
                            }
                        });
                        recyclerView.setAdapter(basketAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    }
                });
            }
        });
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Product product = basketAdapter.getProductList().get(viewHolder.getAdapterPosition());
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        myDataBase.productdao().deleteProduct(product);
                        updateList();
                    }
                });
            }
        });
        touchHelper.attachToRecyclerView(recyclerView);

    }

    public void updateList() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
               final List<Product> productList = myDataBase.productdao().getAllProducts();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            basketAdapter.adapterUpdaite(productList);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }
}
