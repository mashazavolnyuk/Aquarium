package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    public FishBlue(Context context,int width,int height) {
        super(context);
        setImageFish(R.mipmap.fish);
        int x=width/9;
        int y=height/5;
        setDefaultX(x);
        setDefaultX(y);
        setStep(-20,0);
        setX(x);
        setY(y);
    }

}
