package com.example.valven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AnaSayfa extends AppCompatActivity {

    ImageButton cikis;
    Button randevu_al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        Intent intent = getIntent();
        String data = intent.getStringExtra("Kimlik");

        cikis = findViewById(R.id.cikis);
        randevu_al = findViewById(R.id.randevu_Al);

        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        randevu_al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaSayfa.this,RandevuAl.class);
                intent.putExtra("Kimlik",data);
                startActivity(intent);
            }
        });


    }
}