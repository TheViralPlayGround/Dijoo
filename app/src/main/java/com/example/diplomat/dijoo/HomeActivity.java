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
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.diplomat.dijoo.Stling.RoundedImageView;
import com.example.diplomat.dijoo.db.FirebaseHandler;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends BaseActivity {

    RecyclerView recyclerView;
    BaseActivity mBaseActivity;
    SharedPreferences settings;
    ImageButton addNewIcon;
    RoundedImageView dijooPic;
    FirebaseRecyclerAdapter mAdapter;
    Firebase dijooRecBase;

    FragmentManager fm;

    LinearLayoutManager linearLayoutManager;

    String currentDate;
    String userID = "NEW GGG";
    int mStackLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_home);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.dijooToolbar);
        setSupportActionBar(toolbar);
        final String PREFS_NAME = "MyPrefsFile";

        context = this.getApplicationContext();
        settings = getSharedPreferences(PREFS_NAME, 0);
        mBaseActivity = new BaseActivity();
        context = getApplicationContext();
        dijooFireBase.setAndroidContext(context);
        dijooFireBase = new Firebase("https://luminous-inferno-8047.firebaseio.com/");
        fbHandler = new FirebaseHandler(userID);
        linearLayoutManager = new LinearLayoutManager(context);

        dijooRecBase = dijooFireBase.child("dijooUsers").child(userID);

        dijooPic = new RoundedImageView(context);
        dijooPic = (RoundedImageView) findViewById(R.id.dijooPic);
        buildToolBar(toolbar);
        setFirebaseAdapter();
        setDate();

//        if (settings.getBoolean("my_first_time", true)) {
//            settings.edit().putBoolean("my_first_time", false).commit();
//        }
    }

    private void setFirebaseAdapter() {

        recyclerView = (RecyclerView) findViewById(R.id.dijoo_list_view);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new FirebaseRecyclerAdapter<Dijoo, DijooViewHolder>(Dijoo.class, R.layout.dijoo_item_layout, DijooViewHolder.class, dijooRecBase) {
            @Override
            protected void populateViewHolder(DijooViewHolder viewHolder, Dijoo dijoo, int position) {

                viewHolder.dijooTitle.setText(dijoo.getDijooTitle());
                viewHolder.dijooCategory.setText(dijoo.getDijooCategory());

            }
        };

        recyclerView.setAdapter(mAdapter);
    }

    private void setDate() {

        currentDate = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(new Date());
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
        int red = resources.getColor(R.color.material_light_blue_200);
        toolbar.setTitle("List");
        toolbar.setSubtitleTextColor(white);
        toolbar.setTitleTextColor(white);
        toolbar.setBackgroundColor(red);
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        mAdapter.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.add_new_dijoo_icon:   //this item has your app icon
                Intent intent = new Intent(HomeActivity.this, AddDijooFragment.class);
                intent.putExtra("ID", userID);
                startActivity(intent);
                return true;

//            case R.id.menu_item2:  //other menu items if you have any
//                //add any action here
//                return true;
//
//            case ... //do for all other menu items

            default: return super.onOptionsItemSelected(item);
        }
    }


}
