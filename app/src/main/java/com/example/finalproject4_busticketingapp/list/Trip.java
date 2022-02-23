package com.example.finalproject4_busticketingapp.list;

public class Trip {
    String idTrip;
    String tujuan;
    String asal;
    String harga;
    String namaBus;
    public Trip(String idTrip, String tujuan, String asal, String harga, String namaBus) {
        this.idTrip = idTrip;
        this.tujuan = tujuan;
        this.asal = asal;
        this.harga = harga;
        this.namaBus = namaBus;
    }



    public String getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(String idTrip) {
        this.idTrip = idTrip;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNamaBus() {
        return namaBus;
    }

    public void setNamaBus(String namaBus) {
        this.namaBus = namaBus;
    }



}
