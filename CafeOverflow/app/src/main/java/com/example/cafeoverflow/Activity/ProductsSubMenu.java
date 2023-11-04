package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.cafeoverflow.R;

import java.util.ArrayList;

public class ProductsSubMenu extends AppCompatActivity {
    private ArrayList<String> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_sub_menu);

        products = new ArrayList<String>();
        ListView listAnimals = findViewById(R.id.products_list);
        int pos = (Integer) getIntent().getExtras().get("position");

        switch (pos){
            case 0:
                products.add("Mocha");
                products.add("Expresso");
                break;
            case 1:
                products.add("Sandwich");
                products.add("Bagel");
                break;
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, products);

        listAnimals.setAdapter(arrayAdapter);
    }
}