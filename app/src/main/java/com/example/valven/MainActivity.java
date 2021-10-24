package com.example.valven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.valven.data.Database;

public class MainActivity extends AppCompatActivity {

    EditText kimlik_no, sifre;
    Button giris_yap, kayit_ol;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kimlik_no = findViewById(R.id.kimlikno);
        sifre = findViewById(R.id.sifre);
        giris_yap = findViewById(R.id.girisYap);
        kayit_ol = findViewById(R.id.kayitOl);
        db = new Database(this);

        kayit_ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,KayitOl.class);
                startActivity(intent);
            }
        });

        giris_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kimlik_no1 = kimlik_no.getText().toString();
                String sifre1 = sifre.getText().toString();

                if (kimlik_no1.equals("") || sifre1.equals("")){
                    Toast.makeText(MainActivity.this,"Lütfen boş alanları doldurunuz",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean konrolgiris = db.girisKontrol(kimlik_no1,sifre1);
                    if (konrolgiris == true){
                        Toast.makeText(MainActivity.this,"Giriş başarılı",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,AnaSayfa.class);
                        intent.putExtra("Kimlik",kimlik_no1);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Giriş başarısız",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}