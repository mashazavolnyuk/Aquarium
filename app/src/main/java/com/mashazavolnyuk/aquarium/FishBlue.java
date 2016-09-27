package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    int x = 0;
    int y = 0;

    public FishBlue(Context context, int width, int height) {
        super(context, width, height);
        setImageFish(R.mipmap.fish);
        x = width / 9;
        y = height / 5;
        setDefaultX(x);
        setDefaultX(y);
        setStep(-20, 0);
        setX(x);
        setY(y);
    }

    public FishBlue(Context context, int width, int height, int x, int y, int step) {
        super(context, width, height);
        setImageFish(R.mipmap.fish);
        this.x = x;
        this.y = y;
        setDefaultX(x);
        setDefaultX(y);
        setStep(step, 0);
        if (step > 0)
            reset();
        setX(x);
        setY(y);
    }

}
