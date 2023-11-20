package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cafeoverflow.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTextView, descriptionTextView, priceTextView, amountTextView, totalTextView;
    private ImageView plusB, minB, imageFood;
    int priceV = 0, cant = 1, total = 0;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        String productName = getIntent().getStringExtra("productName");
        String productId = getIntent().getStringExtra("productId");
        int productImage = getIntent().getIntExtra("productImage", 0);

        initView();
        loadProductDetails(productName, productId, productImage);

    }

    private void loadProductDetails(String productName, String productId, int productImage) {
        db.collection("product").document(productId).get().addOnSuccessListener(documentSnapshot -> {
            descriptionTextView.setText((String) documentSnapshot.get("description"));
            priceV = documentSnapshot.getLong("unitaryPrice").intValue();
            priceTextView.setText(String.valueOf("Precio: $"+ priceV));
            totalTextView.setText("Total: $" + String.valueOf(priceV));
        });

        titleTextView.setText(productName);
        amountTextView.setText(String.valueOf(cant));
        imageFood.setImageResource(productImage);
        plusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cant = cant + 1;
                total = priceV * cant;
                amountTextView.setText(String.valueOf(cant));
                totalTextView.setText("Total: $" + String.valueOf(total));
            }
        });

        minB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cant > 1){
                    cant = cant - 1;
                }
                total = priceV * cant;
                amountTextView.setText(String.valueOf(cant));
                totalTextView.setText("Total: $" + String.valueOf(total));
            }
        });
    }
    private void initView(){
        addToCartBtn = findViewById(R.id.cartBtn);
        titleTextView = findViewById(R.id.title);
        descriptionTextView = findViewById(R.id.descrip);
        priceTextView = findViewById(R.id.price);
        amountTextView = findViewById(R.id.amount);
        totalTextView = findViewById(R.id.total);
        plusB = findViewById(R.id.max);
        minB = findViewById(R.id.min);
        imageFood = findViewById(R.id.image);
    }
}