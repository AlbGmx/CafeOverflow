package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cafeoverflow.Adapter.ProductAdapter;
import com.example.cafeoverflow.Domain.ProductDomain;
import com.example.cafeoverflow.R;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements RecyclerViewProductsInterface{
    public enum ProviderType {
        BASIC
    }

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //  Setup
        Bundle bundle = getIntent().getExtras();
        String email = (bundle != null) ? bundle.getString("email") : "";
        String provider = (bundle != null) ? bundle.getString("provider") : "";
        setUp(email, provider);
        recyclerViewCategory();
    }

    private void setUp(String email, String provider) {
        TextView userEmail = findViewById(R.id.userEmail);
        userEmail.setText(email);
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

        adapter=new ProductAdapter(product, this);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    public void onCart(View view){
        //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, CartActivity.class);
        //Intent intent = new Intent(this, ProductsSubMenu.class);
        //intent.putExtra("position", 0);
        startActivity(intent);
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