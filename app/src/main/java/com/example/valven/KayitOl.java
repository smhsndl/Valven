package com.example.valven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.valven.data.Database;

public class KayitOl extends AppCompatActivity {
    EditText isim, soyisim, dogum_tarih, kimlik_no, sifre, telefon, e_posta;
    Button kayit_ol1;
    String grup;
    RadioButton rbdoktor, rbhasta;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        isim = findViewById(R.id.isim);
        soyisim = findViewById(R.id.soyisim);
        dogum_tarih = findViewById(R.id.dogumtarihi);
        kimlik_no = findViewById(R.id.kimlikno_kayit);
        sifre = findViewById(R.id.sifre_kayit);
        telefon = findViewById(R.id.telefon);
        e_posta = findViewById(R.id.mail);
        rbdoktor = findViewById(R.id.rbDoktor);
        rbhasta = findViewById(R.id.rbHasta);
        db = new Database(this);
        kayit_ol1 = findViewById(R.id.kayitOl_kayit);


        isim.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    if (isim.getText().toString().length() == 0){
                        isim.setError("Lütfen isminizi giriniz!");
                    }
                }
            }
        });

        soyisim.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (soyisim.getText().toString().length()==0){
                        soyisim.setError("Lütfen soyisminizi giriniz!");
                    }
                }
            }
        });

        dogum_tarih.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (dogum_tarih.getText().toString().length()==0){
                        dogum_tarih.setError("Lütfen doğum tarihinizi giriniz!");
                    }
                }
            }
        });

        kimlik_no.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (kimlik_no.getText().toString().length() == 0){
                        kimlik_no.setError("Lütfen kimlik numaranızı giriniz!");
                    }
                }
            }
        });

        sifre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (sifre.getText().toString().length() == 0){
                        sifre.setError("Lütfen şifrenizi giriniz!");
                    }
                }
            }
        });

        telefon.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (telefon.getText().toString().length() == 0 ){
                        telefon.setError("Lütfen telefon numaranızı giriniz!");
                    }
                }
            }
        });

        e_posta.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    if (e_posta.getText().toString().length() == 0){
                        e_posta.setError("Lütfen e-posta adresinizi giriniz!");
                    }
                }
            }
        });



        kayit_ol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String isim1 = isim.getText().toString();
                String soyisim1 = soyisim.getText().toString();
                String dogum_tarihi1 = dogum_tarih.getText().toString();
                String kimlik_no1 = kimlik_no.getText().toString();
                String sifre1 = sifre.getText().toString();
                String telefon1 = telefon.getText().toString();
                String e_posta1 = e_posta.getText().toString();
                if (rbdoktor.isChecked())
                    grup = "doktor";
                else if (rbhasta.isChecked())
                    grup = "hasta";

                Boolean kontrolkimlik = db.kimlik_noKontrol(kimlik_no.getText().toString());
                if (kontrolkimlik == false){
                    Boolean insert = db.insertData(isim1,soyisim1,dogum_tarihi1,kimlik_no1,sifre1,telefon1,e_posta1,grup);
                    if (insert == true){
                        Toast.makeText(KayitOl.this,"Kayıt Baraşıyla tamamlandı",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}