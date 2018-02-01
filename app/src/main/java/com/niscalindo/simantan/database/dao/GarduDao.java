package com.niscalindo.simantan.database.dao;

import android.content.Context;

import com.niscalindo.simantan.database.model.Gardu;

/**
 * Created by USER on 2/1/2018.
 */
public interface GarduDao{

    public boolean saveGardu(Gardu gardu, Context context);
    public String[] getAllData();
}
