package com.example.diplomat.dijoo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Diplomat on 2/21/2016.
 */
public class DijooRecAdapter extends RecyclerView.Adapter<DijooRecAdapter.DijooViewHolder> {



    public static class DijooViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView dijooTitle;
            TextView dijooCount;
            ImageView dijooPic;

            DijooViewHolder(View itemView) {
                super(itemView);
                cv = (CardView)itemView.findViewById(R.id.dijooCardView);
                dijooTitle = (TextView)itemView.findViewById(R.id.dijooItemTitle);
                dijooCount = (TextView)itemView.findViewById(R.id.dijooItemSubtitle);
                dijooPic = (ImageView)itemView.findViewById(R.id.dijooItemPicture);
            }
        }

    List<Dijoo> dijoos;

    DijooRecAdapter(List<Dijoo> dijoos){
        this.dijoos = dijoos;
    }

    @Override
    public DijooViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dijoo_item_layout, viewGroup, false);
        DijooViewHolder dijooViewHolder = new DijooViewHolder(v);
        return dijooViewHolder;
    }


    @Override
    public int getItemCount() {
        return dijoos.size();
    }

    @Override
    public void onBindViewHolder(DijooViewHolder dijooViewHolder, int i) {
        dijooViewHolder.dijooTitle.setText(dijoos.get(i).dijooTitle);
        dijooViewHolder.dijooCount.setText(dijoos.get(i).dijooCategory);
        dijooViewHolder.dijooPic.setImageResource(dijoos.get(i).dijooPic);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
