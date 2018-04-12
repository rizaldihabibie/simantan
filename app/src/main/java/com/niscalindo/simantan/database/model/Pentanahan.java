package com.niscalindo.simantan.database.model;

import java.io.Serializable;

/**
 * Created by USER on 3/30/2018.
 */
public class Pentanahan implements Serializable {

    private int id;
    private Gardu gardu;
    private String nilaiNetral;
    private String nilaiArrester;
    private String nilaiBodyTrafo;
    private String nilaiTrUjung;
    private String kondisiNetral;
    private String kondisiArrester;
    private String kondisiBodyTrafo;
    private String kondisiTrUjung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gardu getGardu() {
        return gardu;
    }

    public void setGardu(Gardu gardu) {
        this.gardu = gardu;
    }

    public String getNilaiNetral() {
        return nilaiNetral;
    }

    public void setNilaiNetral(String nilaiNetral) {
        this.nilaiNetral = nilaiNetral;
    }

    public String getNilaiArrester() {
        return nilaiArrester;
    }

    public void setNilaiArrester(String nilaiArrester) {
        this.nilaiArrester = nilaiArrester;
    }

    public String getNilaiBodyTrafo() {
        return nilaiBodyTrafo;
    }

    public void setNilaiBodyTrafo(String nilaiBodyTrafo) {
        this.nilaiBodyTrafo = nilaiBodyTrafo;
    }

    public String getNilaiTrUjung() {
        return nilaiTrUjung;
    }

    public void setNilaiTrUjung(String nilaiTrUjung) {
        this.nilaiTrUjung = nilaiTrUjung;
    }

    public String getKondisiNetral() {
        return kondisiNetral;
    }

    public void setKondisiNetral(String kondisiNetral) {
        this.kondisiNetral = kondisiNetral;
    }

    public String getKondisiTrUjung() {
        return kondisiTrUjung;
    }

    public void setKondisiTrUjung(String kondisiTrUjung) {
        this.kondisiTrUjung = kondisiTrUjung;
    }

    public String getKondisiBodyTrafo() {
        return kondisiBodyTrafo;
    }

    public void setKondisiBodyTrafo(String kondisiBodyTrafo) {
        this.kondisiBodyTrafo = kondisiBodyTrafo;
    }

    public String getKondisiArrester() {
        return kondisiArrester;
    }

    public void setKondisiArrester(String kondisiArrester) {
        this.kondisiArrester = kondisiArrester;
    }
}
