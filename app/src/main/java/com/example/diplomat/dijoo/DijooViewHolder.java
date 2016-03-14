package com.example.diplomat.dijoo;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.firebase.client.core.view.View;

/**
 * Created by Diplomat on 3/13/2016.
 */
public class DijooViewHolder extends RecyclerView.ViewHolder {

    TextView dijooTitle;
    TextView dijooCategory;

    public DijooViewHolder (android.view.View itemView){
        super(itemView);

        dijooTitle = (TextView) itemView.findViewById(R.id.dijooItemTitle);
        dijooCategory = (TextView) itemView.findViewById(R.id.dijooItemCategory);
    }






}
