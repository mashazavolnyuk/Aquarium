package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    public FishBlue(Context context) {
        super(context);
        setImageFish(R.mipmap.fish);
        x = LiveWallpaperService.backgroundWidth / 9;
        y = LiveWallpaperService.backgroundHeight / 5;
        setStep(-20, 0);
    }

    public FishBlue(Context context, int x, int y, int step) {
        super(context);
        setImageFish(R.mipmap.fish);
        this.x = x;
        this.y = y;
        setStep(step, 0);
        if (step > 0)
            reset();
    }

}
