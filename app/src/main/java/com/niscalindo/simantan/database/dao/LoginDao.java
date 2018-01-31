package com.niscalindo.simantan.database.dao;

import android.content.Context;

import com.niscalindo.simantan.database.model.Credential;

/**
 * Created by USER on 1/31/2018.
 */
public interface LoginDao {
    public Credential login(String username, String password, Context context);
}
