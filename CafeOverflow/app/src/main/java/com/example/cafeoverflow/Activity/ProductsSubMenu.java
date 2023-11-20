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
                products.add(new Product("Mocha", "mocha_id", R.drawable.banner_coffee));
                products.add(new Product("Espresso","espresso_id", R.drawable.banner_coffee));
                products.add(new Product("Americano", "americano_id", R.drawable.banner_coffee));
                products.add(new Product("Latte", "latte_id", R.drawable.banner_coffee));
                products.add(new Product("Cappuccino", "cappuccino_id", R.drawable.banner_coffee));
                products.add(new Product("Macchiato", "macchiato_id", R.drawable.banner_coffee));
                products.add(new Product("Cortado", "americano_id", R.drawable.banner_coffee));
                products.add(new Product("Affogato", "americano_id", R.drawable.banner_coffee));
                products.add(new Product("Cold Brew","americano_id", R.drawable.banner_coffee));
                break;
/*            case 1:
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
*/
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