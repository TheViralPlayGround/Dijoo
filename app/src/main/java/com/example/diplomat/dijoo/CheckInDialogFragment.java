package com.example.diplomat.dijoo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Diplomat on 2/20/2016.
 */
public class CheckInDialogFragment extends DialogFragment{
    int mNum;

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static CheckInDialogFragment newInstance(int num) {
        CheckInDialogFragment f = new CheckInDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Light);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.check_in_dialog_fragment, container, false);
        // Watch for button clicks.
        Button updateButton = (Button)v.findViewById(R.id.update_button);
        Button cancelButton = (Button)v.findViewById(R.id.cancel_button);



        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.

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