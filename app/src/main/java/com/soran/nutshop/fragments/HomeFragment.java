package com.soran.nutshop.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.premnirmal.textcounter.CounterView;
import com.soran.nutshop.GlideImageLoadingService;
import com.soran.nutshop.MainActivity;
import com.soran.nutshop.R;
import com.soran.nutshop.adapters.BestProductAdapter;
import com.soran.nutshop.adapters.CircleImgAdapter;
import com.soran.nutshop.adapters.HomeProductAdapter;
import com.soran.nutshop.adapters.SliderAdapter;
import com.soran.nutshop.database.MyDataBase;
import com.soran.nutshop.listener.OnAddProduct;
import com.soran.nutshop.model.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import ss.com.bannerslider.Slider;

public class HomeFragment extends Fragment {

    List<Product> productList;
    HomeProductAdapter homeProductAdapter;
    MyDataBase dataBase;
    Executor executor;
    TextView textView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

        @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);

        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataBase = MyDataBase.getInstance(getContext());
        executor = Executors.newSingleThreadExecutor();
        textView = view.findViewById(R.id.txt_counter);


        updateCounter();
        OnAddProduct onAddProduct = new OnAddProduct() {
            @Override
            public void onProductAdded() {
                updateCounter();
            }
        };


        homeProductAdapter = new HomeProductAdapter(getActivity(), productList,onAddProduct);
        Slider.init(new GlideImageLoadingService(getContext()));
        Slider slider = view.findViewById(R.id.banerSlider);
        slider.setAdapter(new SliderAdapter());
        slider.setSelectedSlide(1);

        RecyclerView recyclerView = view.findViewById(R.id.recyclear_best);
        BestProductAdapter bestProductAdapter = new BestProductAdapter(getActivity(),getDammyData());
        recyclerView.setAdapter(bestProductAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        //search
        EditText editText = view.findViewById(R.id.editTextMain);




        //RcyclearViewMain
        RecyclerView recyclerViewMain = view.findViewById(R.id.recyclearViewMain);
        HomeProductAdapter homeProductAdapter = new HomeProductAdapter(getActivity(),getDammyData(),onAddProduct);
        recyclerViewMain.setAdapter(homeProductAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerViewMain.setLayoutManager(gridLayoutManager);

        //rexyXlearCircle

        RecyclerView recyclerViewCircle = view.findViewById(R.id.recyclear_circle_img);
        CircleImgAdapter circleImgAdapter = new CircleImgAdapter(getActivity(),getDammyData());
        recyclerViewCircle.setAdapter(circleImgAdapter);
        recyclerViewCircle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));


    }


    public List<Product> getDammyData() {

        productList = new ArrayList<>();

        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();
        Product product9 = new Product();
        Product product10 = new Product();


        product.setImage_url("https://files.namnak.com/users/km/aup/201807/842_pics/%D9%85%D8%B6%D8%B1%D8%A7%D8%AA-%D9%BE%D8%B3%D8%AA%D9%87.jpg");
        product2.setImage_url("https://hhp-blog.s3.amazonaws.com/2018/08/iStock-481114390.jpg");
        product3.setImage_url("https://images.ctfassets.net/3s5io6mnxfqz/1NwaRiNMXvk8q9APbvPHKR/e329ef2f97a2eeaa7d3716b82c1b69b5/AdobeStock_194033409.jpeg");
        product4.setImage_url("https://image.alkawthartv.com//855x495/2018/03/05/636558460055226346.jpg");
        product5.setImage_url("https://badamsara.ir/wp-content/uploads/2019/05/1546503890_K8vB4.jpg");
        product6.setImage_url("https://aromah.ir/wp-content/uploads/2019/12/1-1-scaled.jpg");
        product7.setImage_url("https://darniko.com/wp-content/uploads/2017/03/%D8%AC%D8%B1%D9%82%D9%87-%D8%A7%DB%8C-%D9%85%D8%B1%D8%AF%D8%A7%D8%B3-2.jpg");
        product8.setImage_url("https://shahregilas.com/wp-content/uploads/2018/04/lg_e4202_bunty_tanagholat-500x500.jpg");
        product9.setImage_url("https://storage.torob.com/backend-api/base/images/Va/tX/VatXmbjpxxIit4vf");
        product10.setImage_url("https://storage.torob.com/backend-api/base/images/PF/-V/PF-VtXaNcJ9Fg4-5.png");


        product.setName("پسته");
        product2.setName("گردو");
        product3.setName("فندق");
        product4.setName("بادام زمینی");
        product5.setName("بادام");
        product6.setName("شکلات شیری");
        product7.setName("مرداس");
        product8.setName("بونتی");
        product9.setName("شونیز طلایی");
        product10.setName("ملیکا");

        product.setPrice(120000);
        product2.setPrice(120000);
        product3.setPrice(120000);
        product4.setPrice(120000);
        product5.setPrice(120000);
        product6.setPrice(120000);
        product7.setPrice(120000);
        product8.setPrice(120000);
        product9.setPrice(120000);
        product10.setPrice(120000);

        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);

        return productList;

    }
    public void updateCounter(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int sum =  dataBase.productdao().getSumQuantity();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(sum+"");
                    }
                });
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        updateCounter();
    }

}
