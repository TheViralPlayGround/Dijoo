package com.example.diplomat.dijoo;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.diplomat.dijoo.db.DBHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends BaseActivity {

    private Bundle extras;
    DijooAdapter adapter;

    ListView listView;

    ArrayList<Dijoo> dijooArrayList;

    BaseActivity mBaseActivity;
    SharedPreferences settings;
    Button datePickerButton;

    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final String PREFS_NAME = "MyPrefsFile";

        context = this.getApplicationContext();
        settings = getSharedPreferences(PREFS_NAME, 0);
        mBaseActivity = new BaseActivity();
        context = getApplicationContext();
        dbHandler = new DBHandler(HomeActivity.this);

        buildToolBar(toolbar);


//        if (settings.getBoolean("my_first_time", true)) {
//            settings.edit().putBoolean("my_first_time", false).commit();
//        }

        BaseActivity.database = BaseActivity.dbHandler.getReadableDatabase();
        loadDijooList();
        datePickerClicked();
        setCurrentDate();




    }

    private void setCurrentDate() {

        currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        datePickerButton.setText(currentDate);

    }

    public void loadDijooList() {
        database = BaseActivity.dbHandler.getReadableDatabase();

        dijooArrayList = dbHandler.getDBDijoos(database);

        adapter = new DijooAdapter(this, dijooArrayList);
        listView = (ListView) findViewById(R.id.dijoo_list_view);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                //Creatte dialog to delete

                return false;
            }
        });

    }

    public void datePickerClicked(){

        fm = this.getFragmentManager();

        datePickerButton = (Button) findViewById(R.id.datePickerButton);

        datePickerButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DialogFragment newFragment = new DatePickerFragment();
               newFragment.show(fm, "datePicker");
           }
                                            }
        )
        ;
    }


    private void buildToolBar(android.support.v7.widget.Toolbar toolbar) {

        Resources resources = this.getResources();
        int white = resources.getColor(R.color.white);
        int red = resources.getColor(R.color.material_light_blue_A400);


        toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        toolbar.setTitle("List");
        toolbar.setSubtitle("DijooOOoooooOO");
        toolbar.setSubtitleTextColor(white);
        toolbar.setTitleTextColor(white);
        toolbar.setLogo(R.mipmap.ic_smoke_free_black_24dp);
        toolbar.setBackgroundColor(red);
    }


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


        switch (id) {
            case R.id.add_new_dijoo_icon:
                Intent intent = new Intent(HomeActivity.this, AddDijooFragment.class);
                startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        dbHandler.close();
//    }


}
