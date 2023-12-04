package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cafeoverflow.Adapter.ProductAdapter;
import com.example.cafeoverflow.Domain.Product;
import com.example.cafeoverflow.R;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;

public class ProductsSubMenu extends AppCompatActivity {

    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_sub_menu);

        products = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.products_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int pos = (Integer) getIntent().getExtras().get("position");

        switch (pos){
            case 0:
                products.add(new Product("Americano", "americano_id", R.drawable.banner_coffee));
                products.add(new Product("Espresso", "espresso_id", R.drawable.banner_coffee));
                products.add(new Product("Espresso Cortado", "expresso_cortado_id", R.drawable.banner_coffee));
                products.add(new Product("Chai", "chai_id", R.drawable.banner_coffee));
                products.add(new Product("Tisana", "tisana_id", R.drawable.banner_coffee));
                products.add(new Product("Vietnamita", "vietnamita_id", R.drawable.banner_coffee));
                products.add(new Product("Mocha", "mocha_id", R.drawable.banner_coffee));
                products.add(new Product("Chocolate", "chocolate_id", R.drawable.banner_coffee));
                products.add(new Product("Matcha", "matcha_id", R.drawable.banner_coffee));
                products.add(new Product("Capuchino", "cappuccino_id", R.drawable.banner_coffee));
                products.add(new Product("Latte", "latte_id", R.drawable.banner_coffee));
                break;
            case 1:
                products.add(new Product("Mocha", "mocha_F_id", R.drawable.banner_coffee));
                products.add(new Product("Brownie", "brownie_id", R.drawable.banner_coffee));
                products.add(new Product("Oreo", "oreo_id", R.drawable.banner_coffee));
                products.add(new Product("Mazapán", "mazapan_id", R.drawable.banner_coffee));
                products.add(new Product("Chai", "chai_F_id", R.drawable.banner_coffee));
                products.add(new Product("Tisana", "tisana_F_id", R.drawable.banner_coffee));
                products.add(new Product("Matcha", "matcha_F_id", R.drawable.banner_coffee));
                products.add(new Product("Sabores", "sabores_id", R.drawable.banner_coffee));
                break;
            case 2:
                products.add(new Product("Americano", "americano_R_id", R.drawable.banner_coffee));
                products.add(new Product("Chai", "chai_R_id", R.drawable.banner_coffee));
                products.add(new Product("Tisana", "tisana_R_id", R.drawable.banner_coffee));
                products.add(new Product("Vietnamita", "vietnamita_R_id", R.drawable.banner_coffee));
                products.add(new Product("Mocha", "mocha_R_id", R.drawable.banner_coffee));
                products.add(new Product("Matcha", "matcha_R_id", R.drawable.banner_coffee));
                products.add(new Product("Latte", "latte_R_id", R.drawable.banner_coffee));
                break;
            case 3:
                products.add(new Product("Brownie", "brownie_D_id", R.drawable.banner_coffee));
                products.add(new Product("Galleta", "galleta_id", R.drawable.banner_coffee));
                products.add(new Product("Deli barras", "deli_id", R.drawable.banner_coffee));
                /*products.add(new Product("Muffin", "muffin_id", R.drawable.banner_coffee));
                products.add(new Product("Coyotas", "coyotas_id", R.drawable.banner_coffee));
                products.add(new Product("Empanadas", "empanadas_id", R.drawable.banner_coffee));
                products.add(new Product("Coricos", "coricos_id", R.drawable.banner_coffee));
                products.add(new Product("Cheescakes", "cheescakes_id", R.drawable.banner_coffee));*/
                break;
            /*case 4:
                products.add(new Product("Guayaba", "guayaba_id", R.drawable.banner_coffee));
                products.add(new Product("Sandía", "sandia_id", R.drawable.banner_coffee));
                products.add(new Product("Granada", "granada_id", R.drawable.banner_coffee));
                products.add(new Product("Toronja", "toronja_id", R.drawable.banner_coffee));
                break;*/
        }

        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Product selectedProduct = products.get(position);
                Intent intent = new Intent(ProductsSubMenu.this, ProductDetailActivity.class);
                intent.putExtra("productName", selectedProduct.getName());
                intent.putExtra("productId", selectedProduct.getProductId());
                intent.putExtra("productImage", selectedProduct.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}