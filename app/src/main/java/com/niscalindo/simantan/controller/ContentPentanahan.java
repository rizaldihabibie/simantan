package com.niscalindo.simantan.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.dao.PentanahanDao;
import com.niscalindo.simantan.database.dao.dao.impl.PentanahanDaoImpl;
import com.niscalindo.simantan.database.model.Pentanahan;
import com.niscalindo.simantan.util.Devider;

import java.io.Serializable;
import java.util.List;

/**
 * Created by USER on 3/26/2018.
 */
public class ContentPentanahan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

private PentanahanDao pentanahanDao;
private List<Pentanahan> data;
private GarduAdapter garduAdapter;
private RecyclerView recyclerView;
private FloatingActionButton fab;

@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pentanahan);
        pentanahanDao = new PentanahanDaoImpl();
        data = pentanahanDao.getAllData(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new Devider(this, LinearLayoutManager.VERTICAL,16));

        recyclerView.setAdapter(new PentanahanAdapter(data, new PentanahanAdapter.OnItemClickListener(){

@Override
public void onItemClick(Pentanahan item) {
        final CharSequence[] dialogitem = {"Lihat Data", "Update Data", "Hapus"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ContentPentanahan.this);
        final Pentanahan pentanahan = (Pentanahan) item;
        builder.setTitle("PILIHAN : ");
        builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int item) {
        Intent intent;
        switch(item){
        case 0 :
        intent = new Intent("com.niscalindo.simantan.controller.ViewPentanahan");
        intent.putExtra("PENTANAHAN_SESSION", (Serializable) pentanahan);
        startActivity(intent);
        break;
        case 1 :
        intent = new Intent("com.niscalindo.simantan.controller.EditPentanahan");
        intent.putExtra("PENTANAHAN_SESSION", (Serializable) pentanahan);
        startActivity(intent);
        break;
        }
        }
        });
        builder.create().show();
        }
        }));
//        garduAdapter.notifyDataSetChanged();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent intent = new Intent("com.niscalindo.simantan.controller.AddPentanahan");
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
                searchView.setOnQueryTextListener(this);
                return true;
        }
}
