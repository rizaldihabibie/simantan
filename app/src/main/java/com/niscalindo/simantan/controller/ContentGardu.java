package com.niscalindo.simantan.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;
import com.niscalindo.simantan.util.Devider;

import java.io.Serializable;
import java.util.List;

/**
 * Created by USER on 2/19/2018.
 */
public class ContentGardu extends AppCompatActivity{

    private GarduDao garduDao;
    private List<Gardu> data;
    private GarduAdapter garduAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_gardu);
        garduDao = new GarduDaoImpl();
        data = garduDao.getAllData(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new Devider(this, LinearLayoutManager.VERTICAL,16));

        recyclerView.setAdapter(new GarduAdapter(data, new GarduAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(Gardu item) {
                final CharSequence[] dialogitem = {"Lihat Data", "Open Map", "Update Data", "Hapus"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ContentGardu.this);
                final Gardu gardu = (Gardu) item;
                builder.setTitle("PILIHAN : ");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Intent intent;
                        switch(item){
                            case 0 :
                                intent = new Intent("com.niscalindo.simantan.controller.ViewDataGardu");
                                intent.putExtra("GARDU_DATA_SESSION", (Serializable) gardu);
                                startActivity(intent);
                                break;
                            case 1 :
                                intent = new Intent("com.niscalindo.simantan.controller.ViewMapController");
                                intent.putExtra("GARDU_DATA_SESSION", (Serializable) gardu);
                                startActivity(intent);
                                break;
                            case 2 :
                                intent = new Intent("com.niscalindo.simantan.controller.EditGardu");
                                intent.putExtra("GARDU_DATA_SESSION", (Serializable) gardu);
                                startActivity(intent);
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        }));
//        garduAdapter.notifyDataSetChanged();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.niscalindo.simantan.controller.AddGardu");
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent("com.niscalindo.simantan.controller.MainMenu");
        startActivity(intent);
    }
}
