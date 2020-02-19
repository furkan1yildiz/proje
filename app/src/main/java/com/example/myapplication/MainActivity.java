package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
  private Button btnKayit;
  private EditText kad;
  private EditText sif;
  private Button giris;
  private FirebaseAuth mAuth;

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

        kad=(EditText) findViewById(R.id.kad);
        sif=(EditText) findViewById(R.id.sif);
        giris=(Button)findViewById(R.id.giris);
        mAuth=FirebaseAuth.getInstance();
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ad=kad.getText().toString();
                String s_sif=sif.getText().toString();
                if (!TextUtils.isEmpty(s_ad)||!TextUtils.isEmpty(s_sif)){
                    girisyap(s_ad,s_sif);
                }
            }
        });

    }

    private void girisyap(String s_ad, String s_sif) {
mAuth.signInWithEmailAndPassword(s_ad,s_sif).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){
            Intent intent =new Intent(MainActivity.this,anasayfa.class);
            startActivity(intent);
        }
    }
});
    }
}
