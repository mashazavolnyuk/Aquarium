package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishDragon extends Fish {

    public FishDragon(Context context) {
        super(context, R.mipmap.rotfeuerfisch);
        speedMulti = 0.5f;
    }
}
