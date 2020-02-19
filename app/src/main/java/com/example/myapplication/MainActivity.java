package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
  private Button btnKayit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnKayit = findViewById(R.id.kayit);
        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent =new Intent(MainActivity.this, kayitActvity.class);
              startActivity(intent);
            }
        });


    }
}
