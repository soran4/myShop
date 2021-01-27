package com.soran.nutshop.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soran.nutshop.R;
import com.soran.nutshop.adapters.CategoryAdapter;
import com.soran.nutshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    View view;
    List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        //recyclear1
        RecyclerView recyclerView = view.findViewById(R.id.recyclearviewCategory);
        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), getDammyData());
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        //recyclear2
        RecyclerView recyclerView2 = view.findViewById(R.id.rexyclearChoclate);
        CategoryAdapter categoryAdapter2 = new CategoryAdapter(getActivity(), getDammyDataChoclate());
        recyclerView2.setAdapter(categoryAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        //recyclear3
        RecyclerView recyclerView3 = view.findViewById(R.id.recyclearFruits);
        CategoryAdapter categoryAdapter3 = new CategoryAdapter(getActivity(), getDammyDataFruits());
        recyclerView3.setAdapter(categoryAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


    }


    public List<Product> getDammyData() {

        List<Product> productList = new ArrayList<>();

        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();


        product.setImage_url("https://files.namnak.com/users/km/aup/201807/842_pics/%D9%85%D8%B6%D8%B1%D8%A7%D8%AA-%D9%BE%D8%B3%D8%AA%D9%87.jpg");
        product2.setImage_url("https://hhp-blog.s3.amazonaws.com/2018/08/iStock-481114390.jpg");
        product3.setImage_url("https://images.ctfassets.net/3s5io6mnxfqz/1NwaRiNMXvk8q9APbvPHKR/e329ef2f97a2eeaa7d3716b82c1b69b5/AdobeStock_194033409.jpeg");
        product4.setImage_url("https://image.alkawthartv.com//855x495/2018/03/05/636558460055226346.jpg");
        product5.setImage_url("https://badamsara.ir/wp-content/uploads/2019/05/1546503890_K8vB4.jpg");

        product.setName("پسته");
        product2.setName("گردو");
        product3.setName("فندق");
        product4.setName("بادام زمینی");
        product5.setName("بادام");

        product.setPrice(120000);
        product2.setPrice(120000);
        product3.setPrice(120000);
        product4.setPrice(120000);
        product5.setPrice(120000);

        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);


        return productList;


    }

    public List<Product> getDammyDataChoclate() {

        List<Product> productList = new ArrayList<>();

        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();


        product.setImage_url("https://storage.torob.com/backend-api/base/images/PF/-V/PF-VtXaNcJ9Fg4-5.png");
        product2.setImage_url("https://storage.torob.com/backend-api/base/images/Va/tX/VatXmbjpxxIit4vf");
        product3.setImage_url("https://shahregilas.com/wp-content/uploads/2018/04/lg_e4202_bunty_tanagholat-500x500.jpg");
        product4.setImage_url("https://darniko.com/wp-content/uploads/2017/03/%D8%AC%D8%B1%D9%82%D9%87-%D8%A7%DB%8C-%D9%85%D8%B1%D8%AF%D8%A7%D8%B3-2.jpg");
        product5.setImage_url("https://aromah.ir/wp-content/uploads/2019/12/1-1-scaled.jpg");

        product.setName("ملیکا");
        product2.setName("شونیز طلایی");
        product3.setName("بونتی");
        product4.setName("مرداس");
        product5.setName("شکلات شیری");

        product.setPrice(120000);
        product2.setPrice(120000);
        product3.setPrice(120000);
        product4.setPrice(120000);
        product5.setPrice(120000);

        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);


        return productList;


    }

    public List<Product> getDammyDataFruits() {

        List<Product> productList = new ArrayList<>();

        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();


        product.setImage_url("https://c.ndtvimg.com/2019-03/ibhn224o_dried-fruits_625x300_13_March_19.jpg");
        product2.setImage_url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_EPZVw_jJjD71EKwT-gpEdIMS1LxF2i6qUQ&usqp=CAU");
        product3.setImage_url("https://www.bellaviva.com/thumbnail.asp?file=assets/images/dried-fruit/mixed-fruit.jpg&maxx=720&maxy=0");
        product4.setImage_url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9rGEHfNUpVgyE4VODp61QS-rh6Z-2Sde-mg&usqp=CAU");
        product5.setImage_url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_EPZVw_jJjD71EKwT-gpEdIMS1LxF2i6qUQ&usqp=CAU");

        product.setName("میوه خشک");
        product2.setName("میوه خشک");
        product3.setName("میوه خشک");
        product4.setName("میوه خشک");
        product5.setName("میوه خشک");

        product.setPrice(120000);
        product2.setPrice(120000);
        product3.setPrice(120000);
        product4.setPrice(120000);
        product5.setPrice(120000);

        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);


        return productList;


    }

}
