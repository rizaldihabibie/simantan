package com.niscalindo.simantan.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
public class ContentGardu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private GarduDao garduDao;
    private List<Gardu> data;
    private GarduAdapter garduAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardu);
        garduDao = new GarduDaoImpl();
        data = garduDao.getAllData(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        context = this;
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new Devider(this, LinearLayoutManager.VERTICAL,16));
        garduAdapter = new GarduAdapter(data, new GarduAdapter.OnItemClickListener(){

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
                            case 3 :
                                new AlertDialog.Builder(context)
                                        .setTitle("Confirmation")
                                        .setMessage("Do you really want to delete this data ?")
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                garduDao.deleteData(gardu.getId(), context);
                                                Intent intent = new Intent("com.niscalindo.simantan.controller.ContentGardu");
                                                startActivity(intent);
                                            }})
                                        .setNegativeButton(android.R.string.no, null).show();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        recyclerView.setAdapter(garduAdapter);
//        garduAdapter.notifyDataSetChanged();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.niscalindo.simantan.controller.AddGardu");
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent("com.niscalindo.simantan.controller.MainMenu");
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            Intent intent = new Intent("com.niscalindo.simantan.controller.ContentGardu");
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent("com.niscalindo.simantan.controller.ContentPentanahan");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                garduAdapter.setContext(context);
                garduAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}
