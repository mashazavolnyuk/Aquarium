package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    public FishBlue(Context context) {
        setImageFish(context, R.mipmap.fish);
        x = LiveWallpaperService.backgroundWidth / 9;
        y = LiveWallpaperService.backgroundHeight / 5;
        setVelocity(-20, 0);
    }

    public FishBlue(Context context, int x, int y, int step) {
        setImageFish(context, R.mipmap.fish);
        this.x = x;
        this.y = y;
        setVelocity(step, 0);
        if (step > 0)
            reset();
    }

}
