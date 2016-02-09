package com.example.diplomat.dijoo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mainDrawerLayout;
    private ListView navDrawerListView;
    private Bundle extras;
    DijooAdapter adapter;

    private AnimatedExpandableListView listVieww;
    private ExpandableListViewActivity.ExampleAdapter adapterr;

    ListView listView;


    public String addedTitle;
    public String addedCategory;
    public String addedUnits;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildToolBar(toolbar);
        loadDijooList();
        loadNavDrawer();

        extras = getIntent().getExtras();
        if(extras!=null) {
            checkNewDijoo(extras);
        }

    }

    private void checkNewDijoo(Bundle bundle) {


        addedTitle = bundle.getString("Added title");
        addedCategory = bundle.getString("Added category");
        addedUnits = bundle.getString("Added units");
        Log.d("Added new dijoo", addedTitle + " " + addedCategory + " " + addedUnits);


        ArrayList<Dijoo> dijooArrayList = Dijoo.addDijoo(addedTitle, addedCategory,addedUnits, null);
        adapter = new DijooAdapter(this, dijooArrayList);
        listView = (ListView) findViewById(R.id.dijoo_list_view);
        listView.setAdapter(adapter);




    }

    private void loadDijooList() {

        ArrayList<Dijoo> dijooArrayList = Dijoo.getUsers(10);

         adapter = new DijooAdapter(this, dijooArrayList);


        listView = (ListView) findViewById(R.id.dijoo_list_view);
        listView.setAdapter(adapter);

    }

        private void loadNavDrawer(){

            mainDrawerLayout = (DrawerLayout) findViewById(R.id.navDrawerLayout);
            navDrawerListView = (ListView) findViewById(R.id.left_drawer);

    }

    private void buildToolBar(android.support.v7.widget.Toolbar toolbar){

        Resources resources = this.getResources();
        int white = resources.getColor(R.color.white);
        int red = resources.getColor(R.color.red);


        toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        toolbar.setTitle("List");
        toolbar.setSubtitle("DijooOOoooooOO");
        toolbar.setSubtitleTextColor(white);
        toolbar.setTitleTextColor(white);
        toolbar.setLogo(R.mipmap.ic_smoke_free_black_24dp);
        toolbar.setBackgroundColor(red);
    }





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = new Intent(HomeActivity.this, AddDijooActivity.class);

        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
