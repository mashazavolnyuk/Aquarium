package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    public FishBlue(Context context) {
        super(context, R.mipmap.fish);
        speedMulti = 1.5f;
    }
}
