package com.niscalindo.simantan.database.dao;

import android.content.Context;

import com.niscalindo.simantan.database.model.Gardu;

import java.util.List;

/**
 * Created by USER on 2/1/2018.
 */
public interface GarduDao{

    public boolean saveGardu(Gardu gardu, Context context);
    public String[] getAllStringData(Context context);
    public List<Gardu> getAllData(Context context);
    public boolean updateGardu(Gardu gardu, Context context);
}
