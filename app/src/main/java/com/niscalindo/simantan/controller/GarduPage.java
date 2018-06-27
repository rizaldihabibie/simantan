package com.niscalindo.simantan.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.GarduDao;
import com.niscalindo.simantan.database.dao.dao.impl.GarduDaoImpl;
import com.niscalindo.simantan.database.model.Gardu;

import java.io.Serializable;
import java.util.List;

/**
 * Created by USER on 2/1/2018.
 */
public class GarduPage extends AppCompatActivity{
    private ListView listView;
    private GarduDao garduDao;
    private List<Gardu> data;
    private FloatingActionButton fab;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_gardu);
        context = this;
        garduDao = new GarduDaoImpl();
        data = garduDao.getAllData(this);
        listView = (ListView)findViewById(R.id.listGardu);
        ArrayAdapter<Gardu> adapter = new ArrayAdapter<Gardu>(this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setSelected(true);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        init();
    }
    public void init(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.niscalindo.simantan.controller.AddGardu");
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, final int arg2, long arg3) {
//                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Data", "Open Map", "Update Data", "Hapus"};
                AlertDialog.Builder builder = new AlertDialog.Builder(GarduPage.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Intent intent;
                        switch(item){
                            case 0 :
                                intent = new Intent("com.niscalindo.simantan.controller.ViewDataGardu");
                                intent.putExtra("GARDU_DATA_SESSION", (Serializable) listView.getItemAtPosition(arg2));
                                startActivity(intent);
                                break;
                            case 1 :
                                intent = new Intent("com.niscalindo.simantan.controller.ViewMapController");
                                intent.putExtra("GARDU_DATA_SESSION", (Serializable) listView.getItemAtPosition(arg2));
                                startActivity(intent);
                                break;
                            case 2 :
                               intent = new Intent("com.niscalindo.simantan.controller.EditGardu");
                               intent.putExtra("GARDU_DATA_SESSION", (Serializable) listView.getItemAtPosition(arg2));
                               startActivity(intent);
                               break;
                            case 3 :
//                                Toast.makeText(context, "ahahhaha",Toast.LENGTH_SHORT).show();
                                new AlertDialog.Builder(context)
                                        .setTitle("Confirmation")
                                        .setMessage("Do you really want to delete this data ?")
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                garduDao.deleteData(((Gardu)listView.getItemAtPosition(arg2)).getId(), context);
                                            }})
                                        .setNegativeButton(android.R.string.no, null).show();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetInvalidated();
    }

}
