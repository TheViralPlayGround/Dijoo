package com.example.diplomat.dijoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Diplomat on 1/23/2016.
 */
public class AddDijooActivity extends HomeActivity {

    EditText editTitle;
    EditText editCategory;
    Spinner editUnits;
    Button addDijooButton;

    String newTitle;
    String newCategory;
    String newUnits;

    public AddDijooActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dijoo_layout);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTitle = (EditText) findViewById(R.id.addTitleEditText);
        editCategory = (EditText) findViewById(R.id.addCategoryEditText);
        editUnits = (Spinner) findViewById(R.id.addUnitsSpinner);
        addDijooButton = (Button) findViewById(R.id.add_submit_button);

        addDijooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newTitle = String.valueOf(editTitle.getText());
                newCategory = String.valueOf(editCategory.getText());
                newUnits = String.valueOf(editUnits.getSelectedItem());

                Intent in = new Intent(AddDijooActivity.this, HomeActivity.class);
                in.putExtra("Added title", newTitle);
                in.putExtra("Added category", newCategory);
                in.putExtra("Added units", newUnits);

                startActivity(in);

            }
        });




    }

}
