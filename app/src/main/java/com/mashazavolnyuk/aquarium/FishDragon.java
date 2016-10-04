package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishDragon extends Fish {

    public FishDragon(Context context) {
        super(context);
        setImageFish(R.mipmap.rotfeuerfisch);
        reset();
        defaultX = LiveWallpaperService.backgroundWidth - LiveWallpaperService.backgroundWidth / 3;
        defaultY = LiveWallpaperService.backgroundHeight - LiveWallpaperService.backgroundHeight / 2;
        setDefaultX(defaultX);
        setDefaultY(defaultY);
        setStep(-5,0);
        setX(defaultX);
        setY(defaultY);
    }
}
