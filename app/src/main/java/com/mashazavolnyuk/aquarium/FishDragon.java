package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishDragon extends Fish {

    public FishDragon(Context context,int width,int height) {
        super(context);
        setImageFish(R.mipmap.rotfeuerfisch);
        defaultX=width-width/3;
        defaultY =height-height/2;
        setDefaultX(defaultX);
        setDefaultX(defaultY);
        setStep(-20,0);
        setX(defaultX);
        setY(defaultY);
    }
}
