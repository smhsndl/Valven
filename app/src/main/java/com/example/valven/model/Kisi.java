package com.example.valven.model;

public class Kisi {
    int id;
    String isim;
    String soyisim;
    String dogum_tarihi;
    String kimlik_no;
    String sifre;
    String telefon;
    String e_posta;
    String grup;
    String randevu_tarihi;
    String randevu_saati;
    String doktor;

    public Kisi(){

    }

    public Kisi(String isim, String soyisim, String dogum_tarihi, String kimlik_no, String sifre, String telefon, String e_posta, String grup, String randevu_tarihi, String randevu_saati, String doktor){
        this.isim = isim;
        this.soyisim = soyisim;
        this.dogum_tarihi = dogum_tarihi;
        this.kimlik_no = kimlik_no;
        this.sifre = sifre;
        this.e_posta = e_posta;
        this.grup = grup;
        this.randevu_tarihi = randevu_tarihi;
        this.randevu_saati = randevu_saati;
        this.doktor = doktor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(String dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getKimlik_no() {
        return kimlik_no;
    }

    public void setKimlik_no(String kimlik_no) {
        this.kimlik_no = kimlik_no;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getE_posta() {
        return e_posta;
    }

    public void setE_posta(String e_posta) {
        this.e_posta = e_posta;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getRandevu_tarihi() {
        return randevu_tarihi;
    }

    public void setRandevu_tarihi(String randevu_tarihi) {
        this.randevu_tarihi = randevu_tarihi;
    }

    public String getRandevu_saati() {
        return randevu_saati;
    }

    public void setRandevu_saati(String randevu_saati) {
        this.randevu_saati = randevu_saati;
    }

    public String getDoktor() {
        return doktor;
    }

    public void setDoktor(String doktor) {
        this.doktor = doktor;
    }
}