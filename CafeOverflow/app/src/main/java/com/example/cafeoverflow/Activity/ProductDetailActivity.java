package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cafeoverflow.R;

public class ProductDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView title, description, price, amount, totalTxt;
private ImageView plusB, minB, imageFood;
int priceV = 80, cant = 1, total = priceV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        initView();
        String productName = getIntent().getStringExtra("productName");

        loadProductDetails(productName);
    }

    private void loadProductDetails(String productName) {
        title.setText(productName);
        description.setText("Descripción del " + productName);
        price.setText("$" + String.valueOf(priceV));
        totalTxt.setText("$" + String.valueOf(total));
        amount.setText(String.valueOf(cant));
        plusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cant = cant + 1;
                total = priceV * cant;
                amount.setText(String.valueOf(cant));
                totalTxt.setText("$" + String.valueOf(total));
            }
        });

        minB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cant > 1){
                    cant = cant - 1;
                }
                total = priceV * cant;
                amount.setText(String.valueOf(cant));
                totalTxt.setText("$" + String.valueOf(total));
            }
        });
    }
    private void initView(){
        addToCartBtn = findViewById(R.id.cartBtn);
        title = findViewById(R.id.title);
        description = findViewById(R.id.descrip);
        price = findViewById(R.id.price);
        amount = findViewById(R.id.amount);
        totalTxt = findViewById(R.id.total);
        plusB = findViewById(R.id.max);
        minB = findViewById(R.id.min);
        imageFood = findViewById(R.id.image);
    }
}