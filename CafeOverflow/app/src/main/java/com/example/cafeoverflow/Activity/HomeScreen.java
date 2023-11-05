package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cafeoverflow.Adapter.ProductAdapter;
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
        product.add(new ProductDomain("Coffee", "cat_1"));
        product.add(new ProductDomain("Food", "cat_2"));
        product.add(new ProductDomain("Desserts", "cat_3"));
        product.add(new ProductDomain("Drink", "cat_4"));
        product.add(new ProductDomain("Donut", "cat_5"));

        adapter=new ProductAdapter(product);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    public void onCart(View view){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}