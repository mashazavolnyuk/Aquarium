package com.mashazavolnyuk.aquarium;

import android.content.Context;

/**
 * Created by Dark Maleficent on 27.09.2016.
 */

public class FishYellow extends Fish {

    int x = 0;
    int y = 0;

    public FishYellow(Context context, int width, int height) {
        super(context, width, height);
        setImageFish(com.aquarium.mashazavolnyuk.mashazavolnyuk.R.mipmap.yellowtang);
        defaultX = width / 9;
        defaultY = height / 2;
        setDefaultX(defaultX);
        setDefaultY(defaultY);
        setY(defaultY);
        setX(defaultX);
        setStep(-9,0);
    }

    public FishYellow(Context context, int width, int height, int x, int y, int step) {
        super(context, width, height);
        setImageFish(com.aquarium.mashazavolnyuk.mashazavolnyuk.R.mipmap.yellowtang);
        x = x;
        y = y;
        setDefaultX(x);
        setDefaultX(y);
        setStep(step, 0);
    }
}
