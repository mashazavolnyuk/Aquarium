package com.mashazavolnyuk.aquarium;

import android.content.Context;

/**
 * Created by Dark Maleficent on 27.09.2016.
 */

public class FishYellow extends Fish {

    public FishYellow(Context context) {
        setImageFish(context, com.aquarium.mashazavolnyuk.mashazavolnyuk.R.mipmap.yellowtang);
        x = LiveWallpaperService.backgroundWidth / 9;
        y = LiveWallpaperService.backgroundHeight / 2;
        setVelocity(-9,0);
    }

    public FishYellow(Context context, int x, int y, int step) {
        setImageFish(context, com.aquarium.mashazavolnyuk.mashazavolnyuk.R.mipmap.yellowtang);
        this.x = x;
        this.y = y;
        setVelocity(step, 0);
    }
}
