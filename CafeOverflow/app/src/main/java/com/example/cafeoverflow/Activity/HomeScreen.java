package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cafeoverflow.Adapter.ProductAdapter;
import com.example.cafeoverflow.Domain.ProductDomain;
import com.example.cafeoverflow.R;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements RecyclerViewProductsInterface{
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
        recyclerViewCategoryList = findViewById(R.id.recyclerViewProducts);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductDomain> product= new ArrayList<>();
        product.add(new ProductDomain("Coffee", "cat_1"));
        product.add(new ProductDomain("Food", "cat_2"));
        product.add(new ProductDomain("Desserts", "cat_3"));
        product.add(new ProductDomain("Drink", "cat_4"));
        product.add(new ProductDomain("Donut", "cat_5"));

        adapter=new ProductAdapter(product,this);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    @Override
    public void onProductClick(int position) {
        //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
        //Log.v("DelayedMessageService","Hello");

        Intent intent = new Intent(this, ProductsSubMenu.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}