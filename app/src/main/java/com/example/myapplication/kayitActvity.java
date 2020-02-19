package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class kayitActvity extends AppCompatActivity {
 private EditText kayitAd;
 private EditText kayitSoyad;
 private EditText kayitTel;
 private EditText kayitYakin;
 private EditText kayitYakinTel;
 private EditText kayitCinsiyet;
 private EditText kayitYas;
 private EditText kayitEposta;
 private EditText kayitSifre;
 private EditText kayitSifreTekrar;
 private Button kayitButon;
 private ProgressDialog progressDialog1;
 private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_actvity);
        kayitButon=(Button)findViewById(R.id.kayitButon);
        kayitAd=(EditText) findViewById(R.id.kayitAd);
        kayitSoyad=(EditText) findViewById(R.id.kayitSoyad);
        kayitTel=(EditText) findViewById(R.id.kayitTel);
        kayitYakin=(EditText) findViewById(R.id.kayitYakin);
        kayitYakinTel=(EditText) findViewById(R.id.kayitYakinTel);
        kayitCinsiyet=(EditText) findViewById(R.id.kayitCinsiyet);
        kayitYas=(EditText) findViewById(R.id.kayitYas);
        kayitEposta=(EditText) findViewById(R.id.kayitEposta);
        kayitSifre=(EditText) findViewById(R.id.kayitSifre);
        kayitSifreTekrar=(EditText) findViewById(R.id.kayitSifreTekrar);
        progressDialog1= new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();

        kayitButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad=kayitAd.getText().toString();
                String sad=kayitSoyad.getText().toString();
                String tel=kayitTel.getText().toString();
                String yakin=kayitYakin.getText().toString();
                String yakintel=kayitYakinTel.getText().toString();
                String cin=kayitCinsiyet.getText().toString();
                String yas=kayitYas.getText().toString();
                String eposta=kayitEposta.getText().toString();
                String sifre=kayitSifre.getText().toString();
                String stekrar=kayitSifreTekrar.getText().toString();
                if (!TextUtils.isEmpty(ad) || !TextUtils.isEmpty(sad)|| !TextUtils.isEmpty(tel)|| !TextUtils.isEmpty(yakin)
                   ||!TextUtils.isEmpty(yakintel)|| !TextUtils.isEmpty(cin)||!TextUtils.isEmpty(yas)||!TextUtils.isEmpty(eposta)
                   ||!TextUtils.isEmpty(sifre)||!TextUtils.isEmpty(stekrar)){
                        if (TextUtils.equals(sifre,stekrar)){
                            progressDialog1.setTitle("Kaydediliyor");
                            progressDialog1.setMessage("bekleyiniz");
                            progressDialog1.setCanceledOnTouchOutside(false);
                            progressDialog1.show();
                            register_user(ad,sad,tel,yakin,yakintel,cin,yas,eposta,sifre);

                        }
                }

            }
        });
    }

    private void register_user(String ad, String sad, String tel, String yakin, String yakintel, String cin, String yas, String eposta, String sifre) {
        mAuth.createUserWithEmailAndPassword(eposta,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog1.dismiss();
                    Intent intent =new Intent(kayitActvity.this,anasayfa.class);
                    startActivity(intent);
                }
                else
                {
                    progressDialog1.dismiss();
                    Toast.makeText(getApplicationContext(),"hata"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
