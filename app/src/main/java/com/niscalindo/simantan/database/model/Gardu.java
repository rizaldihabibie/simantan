package com.niscalindo.simantan.database.model;

import java.io.Serializable;

/**
 * Created by USER on 1/30/2018.
 */
public class Gardu implements Serializable {
    private String nomorGardu;
    private String alamat;
    private String kapasitasTrafo;
    private String merkTrafo;
    private String tapTrafo;
    private String jumlahJurusan;
    private String konstruksi;
    private String tanggalUkur;
    private String jamUkur;
    private String Petugas;
    private Double latitude;
    private Double longitude;
    private float zoom;
    private String penyulang;

    @Override
    public String toString() {
        return this.nomorGardu;
    }

    public String getNomorGardu() {
        return nomorGardu;
    }

    public void setNomorGardu(String nomorGardu) {
        this.nomorGardu = nomorGardu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKapasitasTrafo() {
        return kapasitasTrafo;
    }

    public void setKapasitasTrafo(String kapasitasTrafo) {
        this.kapasitasTrafo = kapasitasTrafo;
    }

    public String getMerkTrafo() {
        return merkTrafo;
    }

    public void setMerkTrafo(String merkTrafo) {
        this.merkTrafo = merkTrafo;
    }

    public String getTapTrafo() {
        return tapTrafo;
    }

    public void setTapTrafo(String tapTrafo) {
        this.tapTrafo = tapTrafo;
    }

    public String getJumlahJurusan() {
        return jumlahJurusan;
    }

    public void setJumlahJurusan(String jumlahJurusan) {
        this.jumlahJurusan = jumlahJurusan;
    }

    public String getKonstruksi() {
        return konstruksi;
    }

    public void setKonstruksi(String konstruksi) {
        this.konstruksi = konstruksi;
    }

    public String getTanggalUkur() {
        return tanggalUkur;
    }

    public void setTanggalUkur(String tanggalUkur) {
        this.tanggalUkur = tanggalUkur;
    }

    public String getJamUkur() {
        return jamUkur;
    }

    public void setJamUkur(String jamUkur) {
        this.jamUkur = jamUkur;
    }

    public String getPetugas() {
        return Petugas;
    }

    public void setPetugas(String petugas) {
        Petugas = petugas;
    }

    public String getPenyulang() {
        return penyulang;
    }

    public void setPenyulang(String penyulang) {
        this.penyulang = penyulang;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }
}
