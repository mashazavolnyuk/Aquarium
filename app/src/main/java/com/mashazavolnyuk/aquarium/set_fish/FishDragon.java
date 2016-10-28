package com.mashazavolnyuk.aquarium.set_fish;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;
import com.mashazavolnyuk.aquarium.Fish;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishDragon extends Fish {

    public FishDragon(Context context) {
        super(context, R.mipmap.rotfeuerfisch);
        speedMulti = 0.5f;
    }
}
