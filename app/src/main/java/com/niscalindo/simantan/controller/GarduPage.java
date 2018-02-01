package com.niscalindo.simantan.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;

/**
 * Created by USER on 2/1/2018.
 */
public class GarduPage extends AppCompatActivity{
    private ListView listView;
    private GarduDao garduDao;
    private String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gardu);
        garduDao = new GarduDaoImpl();
        data = garduDao.getAllData(this);
        listView = (ListView)findViewById(R.id.listGardu);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,data));
        listView.setSelected(true);
    }
}
