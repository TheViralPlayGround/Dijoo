package com.example.diplomat.dijoo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Diplomat on 1/23/2016.
 */
public class AddDijooFragment extends FragmentActivity {

    EditText editTitle;
    EditText editCategory;
    Spinner editUnits;
    Button addDijooButton;

    String newTitle;
    String newCategory;
    String newUnits;
    Context context;

    String userID;



    public AddDijooFragment(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_dijoo_layout);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        buildToolBar(toolbar);

        editTitle = (EditText) findViewById(R.id.addTitleEditText);
        editCategory = (EditText) findViewById(R.id.addCategoryEditText);
        addDijooButton = (Button) findViewById(R.id.add_submit_button);

        Intent intent = getIntent();
        userID = intent.getStringExtra("ID");

        addDijooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newTitle = String.valueOf(editTitle.getText());
                newCategory = String.valueOf(editCategory.getText());

                Intent in = new Intent(AddDijooFragment.this, HomeActivity.class);

                HomeActivity.fbHandler.addNewDijoo(BaseActivity.dijooFireBase, userID, newTitle, newCategory, newUnits);
                startActivity(in);

            }
        });




    }


    private void buildToolBar(android.support.v7.widget.Toolbar toolbar) {

        Resources resources = this.getResources();
        int white = resources.getColor(R.color.white);
        int black = resources.getColor(R.color.black);
        toolbar.setSubtitleTextColor(white);
        toolbar.setTitleTextColor(white);
        toolbar.setBackgroundColor(black);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        toolbar.setTitle("Add new Dijoo");

    }
}
