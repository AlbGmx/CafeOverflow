package com.example.cafeoverflow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cafeoverflow.Activity.HomeScreen;
import com.example.cafeoverflow.Activity.activity_login;
import com.example.cafeoverflow.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View view){
        Intent intent = new Intent(this, activity_login.class);
        startActivity(intent);
    }
    public void onInvitado(View view){
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

}