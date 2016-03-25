package com.example.diplomat.dijoo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Diplomat on 2/20/2016.
 */
public class CheckInDialogFragment extends DialogFragment{

    private static Firebase firebase;
    private static String key;

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static CheckInDialogFragment newInstance(String key, Firebase fb) {
        CheckInDialogFragment f = new CheckInDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("key", key);
        f.setArguments(args);

        firebase = fb;


        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Light);

        key = getArguments().getString("key");




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.check_in_dialog_fragment, container, false);
        // Watch for button clicks.
        Button updateButton = (Button)v.findViewById(R.id.update_button);
        Button cancelButton = (Button)v.findViewById(R.id.cancel_button);
        final EditText updateTxtField = (EditText)v.findViewById(R.id.update_count_edit_Text) ;



        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.

                int updateCount = Integer.parseInt(updateTxtField.getText().toString());

                Firebase ref = firebase.child(key).child("currentDate").push();

                SimpleDateFormat date = new SimpleDateFormat("ddMMyyyy");
                String currentDate = date.format(new Date());

                SimpleDateFormat time = new SimpleDateFormat("HHmmss");
                String currentTime = time.format(new Date());

                AnotherOne anotherOne = new AnotherOne(updateCount, currentTime, currentDate);

                ref.setValue(anotherOne);


                dismiss();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                dismiss();

            }
        });

        return v;
    }
}