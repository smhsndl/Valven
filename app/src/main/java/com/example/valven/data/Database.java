package com.example.valven.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import com.example.valven.model.Kisi;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "Kisiler";
    final static int DATABASE_VERSION = 1;

    public Database(@Nullable Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_KISI = "CREATE TABLE Kisiler (" + "id INTEGER , " +
                "isim VARCHAR , "+
                "soyisim VARCHAR , "+
                "dogum_tarihi VARCHAR , "+
                "kimlik_no VARCHAR PRIMARY KEY , "+
                "sifre VARCHAR , "+
                "telefon VARCHAR , "+
                "e_posta VARCHAR , "+
                "grup VARCHAR , "+
                "randevu_tarihi VARCHAR , "+
                "randevu_saati VARCHAR , "+
                "doktor VARCHAR)";

        db.execSQL(CREATE_KISI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF exists Kisiler");
    }


    public List <String>getDoktorlar(){
        List <String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kisiler WHERE grup ='doktor' ", null);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1) +" "+cursor.getString(2));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }

    /*public List <String>getRandevuSaatleri(String isimSoyisim){
        List <String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kisiler WHERE doktor= ? ", new String[]{isimSoyisim});

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(10));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }*/

    public Kisi getDoktorProfil(String isim, String soyisim){
        Kisi kisi = new Kisi();
        PreparedStatement smt = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kisiler WHERE isim= ? AND soyisim= ?", new String[]{isim,soyisim});

        if (cursor.moveToLast()) {
            kisi.setIsim(cursor.getString(1));
            kisi.setSoyisim(cursor.getString(2));
            kisi.setDogum_tarihi(cursor.getString(3));
            kisi.setTelefon(cursor.getString(6));
            kisi.setE_posta(cursor.getString(7));
            return kisi;

        }else {
            Log.e("error not found", "user can't be found or database empty");
            return kisi;
        }
    }


    public Boolean insertData(String isim, String soyisim, String dogum_tarihi, String kimlik_no, String sifre, String telefon, String e_posta, String grup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isim",isim);
        contentValues.put("soyisim",soyisim);
        contentValues.put("dogum_tarihi",dogum_tarihi);
        contentValues.put("kimlik_no",kimlik_no);
        contentValues.put("sifre",sifre);
        contentValues.put("telefon",telefon);
        contentValues.put("e_posta",e_posta);
        contentValues.put("grup",grup);
        long result = db.insert("Kisiler",null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean updateRandevu(String doktor, String randevuSaat,String kimlik_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("doktor",doktor);
        contentValues.put("randevu_saati",randevuSaat);
        long result = db.update("Kisiler",contentValues,"kimlik_no=?",new String[]{kimlik_no});
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean randevuKontrol(String doktor, String saat){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kisiler WHERE doktor = ? AND randevu_saati= ?", new String[] {doktor,saat});
        if (cursor.getCount() >0)
            return true;
        else
            return false;

    }

    public Boolean kimlik_noKontrol(String kimlik_no){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kisiler WHERE kimlik_no = ?", new String[] {kimlik_no});
        if (cursor.getCount() >0)
            return true;
        else
            return false;

    }

    public Boolean girisKontrol(String kimlik_no, String sifre){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Kisiler WHERE kimlik_no= ? AND sifre= ?", new String[]{kimlik_no,sifre});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

}
