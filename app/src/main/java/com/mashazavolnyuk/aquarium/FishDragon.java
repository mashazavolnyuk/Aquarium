package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishDragon extends Fish {

    public FishDragon(Context context) {
        setImageFish(context, R.mipmap.rotfeuerfisch);
        reset();
        setVelocity(-5,0);
        x = LiveWallpaperService.backgroundWidth - LiveWallpaperService.backgroundWidth / 3;
        y = LiveWallpaperService.backgroundHeight - LiveWallpaperService.backgroundHeight / 2;
    }
}
