package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.cafeoverflow.R;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;

public class ProductsSubMenu extends AppCompatActivity {

    private ArrayList<String> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_sub_menu);

        products = new ArrayList<String>();
        ListView listProducts = findViewById(R.id.products_list);
        int pos = (Integer) getIntent().getExtras().get("position");

        switch (pos){
            case 0:
                products.add("Mocha");
                products.add("Espresso");
                products.add("Americano");
                products.add("Latte");
                products.add("Cappuccino");
                products.add("Macchiato");
                products.add("Flat White");
                products.add("Cortado");
                products.add("Affogato");
                products.add("Cold Brew");
                break;
            case 1:
                products.add("Sandwich");
                products.add("Bagels with Cream Chesse");
                products.add("Croissants");
                products.add("Breakfast Burritos");
                products.add("Quiche");
                products.add("Avocado Toast");
                products.add("Oatmeal");
                products.add("Pastries");
                products.add("Pancakes");
                products.add("Yogurt Parfait");
                break;
            case 2:
                products.add("Brownies");
                products.add("Cookies");
                products.add("Cake Slices");
                products.add("Cheesecake");
                products.add("Tiramisu");
                products.add("Cannoli");
                products.add("Fruit Tarts");
                products.add("Cupcakes");
                products.add("Macarons");
                products.add("Pies");
                break;
            case 3:
                products.add("Iced Tea");
                products.add("Lemonade");
                products.add("Fruit Smoothies");
                products.add("Hot Chocolate");
                products.add("Chai Latte");
                products.add("Herbal Tea");
                products.add("Italian Soda");
                products.add("Fruit Juices");
                products.add("Sparkling Water");
                products.add("Milkshakes");
                break;
            case 4:
                products.add("Glazed Donut");
                products.add("Chocolate Frosted Donut");
                products.add("Sprinkle Donut");
                products.add("Jelly-Filled Donut");
                products.add("Boston Cream Donut");
                products.add("Old-Fashioned Donut");
                products.add("Maple Bar");
                products.add("Apple Fritter");
                products.add("Cinnamon Sugar Donut");
                products.add("Coconut Cream Donut");
                break;
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, products);
        listProducts.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listProducts, View itemView, int position, long id) {
                String selectedProduct = products.get(position);
                Intent intent = new Intent(ProductsSubMenu.this, ProductDetailActivity.class);
                intent.putExtra("productName", selectedProduct);
                startActivity(intent);
            }
        };

        listProducts.setOnItemClickListener(itemClickListener);
    }
}