package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cafeoverflow.Domain.ProductDomain;
import com.example.cafeoverflow.R;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerViewCategory();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductDomain> product= new ArrayList<>();
        product.add(new ProductDomain("Coffee", "banner_coffee"));
        product.add(new ProductDomain("Burguer", "cat_2"));
        product.add(new ProductDomain("Hotdog", "cat_3"));
        product.add(new ProductDomain("Drink", "cat_4"));
        product.add(new ProductDomain("Donut", "cat_5"));
    }
}