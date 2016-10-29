package com.mashazavolnyuk.aquarium.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Dark Maleficent on 29.10.2016.
 */
public class HoldersListFish extends RecyclerView.ViewHolder {

    ImageView imgFish;
    TextView textViewFish;
    Switch isShow;

    public HoldersListFish(View itemView) {
        super(itemView);
    }
}
