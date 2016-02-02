package com.example.diplomat.dijoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diplomat on 1/21/2016.
 */
public class DijooAdapter extends ArrayAdapter<Dijoo> {
    public DijooAdapter(Context context, ArrayList<Dijoo> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Dijoo dijoo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dijoo_item_layout, parent, false);
        }
        // Lookup view for data population
        TextView dijooTitle = (TextView) convertView.findViewById(R.id.dijooItemTitle);
        TextView dijooCategory = (TextView) convertView.findViewById(R.id.dijooItemSubtitle);
        TextView dijooUnits = (TextView) convertView.findViewById(R.id.unitsText) ;
        // Populate the data into the template view using the data object
        dijooTitle.setText(dijoo.dijooTitle);
        dijooCategory.setText(dijoo.dijooSubtitle);
        dijooUnits.setText(dijoo.dijooUnits);
        // Return the completed view to render on screen
        return convertView;
    }
}