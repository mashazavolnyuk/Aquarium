package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishClown extends Fish {


    public FishClown(Context context){
        setImageFish(context, R.mipmap.clownfish);
        x = LiveWallpaperService.backgroundWidth / 9;
        y = LiveWallpaperService.backgroundHeight / 8;
        setVelocity(13,0);
    }

}
