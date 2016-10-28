package com.mashazavolnyuk.aquarium.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;
import com.mashazavolnyuk.aquarium.Fish;

import java.util.List;

/**
 * Created by Dark Maleficent on 29.10.2016.
 */

public class AdapterFishList extends RecyclerView.Adapter<HoldersListFish> {

    Context context;
    List<Fish> data;
    public AdapterFishList(Context context) {
        this.context = context;
    }

    @Override
    public HoldersListFish onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(context).inflate(R.layout.item_fish_list, null);
        HoldersListFish rcv = new HoldersListFish(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(HoldersListFish holder, int position) {
        holder.imgFish.setImageBitmap(data.get(position).getImageFish());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
