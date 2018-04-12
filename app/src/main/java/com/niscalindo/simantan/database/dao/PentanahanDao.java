package com.niscalindo.simantan.database.dao;

import android.content.Context;

import com.niscalindo.simantan.database.model.Pentanahan;

import java.util.List;

/**
 * Created by USER on 3/30/2018.
 */
public interface PentanahanDao {
    public boolean save(Pentanahan pentanahan,Context context);
    public boolean update(Pentanahan pentanahan,Context context);
    public List<Pentanahan> getAllData(Context context);
}
