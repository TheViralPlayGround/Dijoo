package com.example.diplomat.dijoo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.diplomat.dijoo.db.DBContract;

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

        editTitle = (EditText) findViewById(R.id.addTitleEditText);
        editCategory = (EditText) findViewById(R.id.addCategoryEditText);
        editUnits = (Spinner) findViewById(R.id.addUnitsSpinner);
        addDijooButton = (Button) findViewById(R.id.add_submit_button);

        Intent intent = getIntent();
        userID = intent.getStringExtra("ID");

        addDijooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newTitle = String.valueOf(editTitle.getText());
                newCategory = String.valueOf(editCategory.getText());
                newUnits = String.valueOf(editUnits.getSelectedItem());

                Intent in = new Intent(AddDijooFragment.this, HomeActivity.class);
                BaseActivity.database = BaseActivity.dbHandler.getReadableDatabase();


                ContentValues values = new ContentValues();

                values.clear();
                values.put(DBContract.Columns.DIJOO_TITLE,newTitle);
                values.put(DBContract.Columns.DIJOO_CATEGORY,newCategory);
                values.put(DBContract.Columns.DIJOO_UNITS,newUnits);


                Uri uri = DBContract.CONTENT_URI;
                getApplicationContext().getContentResolver().insert(uri,values);

                HomeActivity.fbHandler.addNewDijoo(BaseActivity.dijooFireBase, userID, newTitle, newCategory, newUnits);
                startActivity(in);

            }
        });




    }
}
