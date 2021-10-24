package com.example.valven;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.valven.data.Database;
import com.example.valven.model.Kisi;

import java.util.ArrayList;
import java.util.List;

public class RandevuAl extends AppCompatActivity {

    Spinner spdoktor;
    Button saat_sec, randevu_kaydet;
    ImageButton doktor_profil;
    Database db;
    String ad,soyad;
    String randevu_saati;
    Dialog mydialog,mydialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_al);
        Intent intent = getIntent();
        String data = intent.getStringExtra("Kimlik");

        spdoktor = findViewById(R.id.spdoktor);
        saat_sec = findViewById(R.id.saatsec);
        randevu_kaydet = findViewById(R.id.randevu_kaydet);
        doktor_profil = findViewById(R.id.doktor_profil);
        db = new Database(this);
        mydialog = new Dialog(this);

        loadSpinnerData();
        spdoktor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String tutorialsName = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,Toast.LENGTH_LONG).show();



                String item = (String) spdoktor.getAdapter().getItem(position);
                int uzunluk = item.length();
                ad = item.substring(0,item.indexOf(" "));
                soyad = item.substring(item.indexOf(" ")+1, uzunluk);
                Toast.makeText(RandevuAl.this,ad,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saat_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView kapat1;
                Button b8, b9, b10, b11, b12, b13, b14, b15, b16;
                mydialog.setContentView(R.layout.custompopup2);
                kapat1 = mydialog.findViewById(R.id.kapat2);
                b8 = mydialog.findViewById(R.id.b8);
                b9 = mydialog.findViewById(R.id.b9);
                b10 = mydialog.findViewById(R.id.b10);
                b11 = mydialog.findViewById(R.id.b11);
                b12 = mydialog.findViewById(R.id.b12);
                b13 = mydialog.findViewById(R.id.b13);
                b14 = mydialog.findViewById(R.id.b14);
                b15 = mydialog.findViewById(R.id.b15);
                b16 = mydialog.findViewById(R.id.b16);

                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b8.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b8.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b9.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b9.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b10.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b10.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b11.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b11.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b12.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b12.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b13.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b13.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b14.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b14.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b15.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b15.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                b16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean kontrolsaat = db.randevuKontrol(ad+" "+soyad,b16.getText().toString());
                        if (kontrolsaat == true){
                            Toast.makeText(RandevuAl.this,"Saat dolu",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            randevu_saati = b16.getText().toString();
                            Toast.makeText(RandevuAl.this,"Saat başarıyla alındı",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                kapat1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mydialog.dismiss();
                    }
                });

                mydialog.show();
            }
        });

        doktor_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kisi kisi = new Kisi();
                TextView isim1,soyisim1,dogumtarihi1,telefon1,mail1,kapat;
                mydialog.setContentView(R.layout.custompopup);
                isim1 = mydialog.findViewById(R.id.popAd);
                soyisim1 = mydialog.findViewById(R.id.popSoyad);
                dogumtarihi1 = mydialog.findViewById(R.id.popDogum_Tarihi);
                telefon1 = mydialog.findViewById(R.id.popTelefon);
                mail1 = mydialog.findViewById(R.id.popMail);
                kapat = mydialog.findViewById(R.id.kapat);

                kisi = db.getDoktorProfil(ad,soyad);
                isim1.setText(kisi.getIsim());
                soyisim1.setText(kisi.getSoyisim());
                dogumtarihi1.setText(kisi.getDogum_tarihi());
                telefon1.setText(kisi.getTelefon());
                mail1.setText(kisi.getE_posta());

                kapat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mydialog.dismiss();
                    }
                });
                mydialog.show();
            }
        });

        randevu_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean konrolgiris = db.updateRandevu(ad+" "+soyad,randevu_saati,data);
                if (konrolgiris == true){
                    Toast.makeText(RandevuAl.this,"Randevu talebiniz alınmıştır",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(RandevuAl.this,"Randevu talebiniz başarısız",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadSpinnerData() {
        Database db = new Database(getApplicationContext());
        List<String> labels = db.getDoktorlar();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdoktor.setAdapter(dataAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();

    }



}