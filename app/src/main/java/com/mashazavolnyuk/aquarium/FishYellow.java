package com.mashazavolnyuk.aquarium;

import android.content.Context;

/**
 * Created by Dark Maleficent on 27.09.2016.
 */

public class FishYellow extends Fish {

    int x = 0;
    int y = 0;

    public FishYellow(Context context) {
        super(context);
        setImageFish(com.aquarium.mashazavolnyuk.mashazavolnyuk.R.mipmap.yellowtang);
        defaultX = LiveWallpaperService.backgroundWidth / 9;
        defaultY = LiveWallpaperService.backgroundHeight / 2;
        setDefaultX(defaultX);
        setDefaultY(defaultY);
        setY(defaultY);
        setX(defaultX);
        setStep(-9,0);
    }

    public FishYellow(Context context, int x, int y, int step) {
        super(context);
        setImageFish(com.aquarium.mashazavolnyuk.mashazavolnyuk.R.mipmap.yellowtang);
        this.x = x;
        this.y = y;
        setDefaultX(x);
        setDefaultX(y);
        setStep(step, 0);
    }
}
