package com.mashazavolnyuk.aquarium.set_fish;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;
import com.mashazavolnyuk.aquarium.Fish;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    public FishBlue(Context context) {
        super(context, R.mipmap.fish);
        speedMulti = 1.5f;
    }
}
