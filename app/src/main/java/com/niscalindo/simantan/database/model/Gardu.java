package com.niscalindo.simantan.database.model;

import java.util.Date;

/**
 * Created by USER on 1/30/2018.
 */
public class Gardu {
    private String nomorGardu;
    private String alamat;
    private String kapasitasTrafo;
    private String merkTrafo;
    private String tapTrafo;
    private String jumlahJurusan;
    private String konstruksi;
    private Date tanggalUkur;
    private String jamUkur;
    private String Petugas;
    private String koordinat;

    public String getNomorGardu() {
        return nomorGardu;
    }

    public void setNomorGardu(String nomorGardu) {
        this.nomorGardu = nomorGardu;
    }
}
