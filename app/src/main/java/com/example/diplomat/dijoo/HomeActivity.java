package com.example.diplomat.dijoo;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.diplomat.dijoo.db.DBHandler;
import com.example.diplomat.dijoo.db.FirebaseHandler;
import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends BaseActivity {

    private Bundle extras;
    DijooRecAdapter adapter;

    RecyclerView listView;

    List<Dijoo> dijooArrayList;

    BaseActivity mBaseActivity;
    SharedPreferences settings;
    Button datePickerButton;

    FragmentManager fm;

    LinearLayoutManager linearLayoutManager;

    String currentDate;
    String userID = "AKA GET FAMILIAR";
    int mStackLevel;


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
        dijooFireBase = new Firebase("https://luminous-inferno-8047.firebaseio.com/");
        fbHandler = new FirebaseHandler(userID);
        dbHandler = new DBHandler(HomeActivity.this);
        linearLayoutManager = new LinearLayoutManager(context);

        buildToolBar(toolbar);


//        if (settings.getBoolean("my_first_time", true)) {
//            settings.edit().putBoolean("my_first_time", false).commit();
//        }

        BaseActivity.database = BaseActivity.dbHandler.getReadableDatabase();
        loadDijooList();
        datePickerClicked();
        setDate();

//        updateDijooUser(userID, "Alfred Morris", 3932);



    }

    private void updateDijooUser(String userID, String name, int age) {


        Firebase user = dijooFireBase.child("dijooUsers").child(userID);

        DijooUser newUser = new DijooUser(name, age);

        user.setValue(newUser);
    }


    private void setDate() {

        currentDate = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());

        datePickerButton.setText(currentDate);

    }

    public void loadDijooList() {

        database = BaseActivity.dbHandler.getReadableDatabase();
        dijooArrayList = dbHandler.getDBDijoos(database);
        adapter = new DijooRecAdapter(dijooArrayList);




        listView = (RecyclerView) findViewById(R.id.dijoo_list_view);
        listView.setLayoutManager(linearLayoutManager);


        listView.setAdapter(adapter);
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

     private void checkInDialog () {
        mStackLevel++;

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = CheckInDialogFragment.newInstance(mStackLevel);
        newFragment.show(ft, "dialog");
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
                intent.putExtra("ID", userID);
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
