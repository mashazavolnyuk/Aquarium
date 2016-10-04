package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishClown extends Fish {


    public FishClown(Context c){
        super(c);
        setImageFish(R.mipmap.clownfish);
        defaultX = LiveWallpaperService.backgroundWidth / 9;
        defaultY = LiveWallpaperService.backgroundHeight / 8;
        setDefaultX(defaultX);
        setDefaultY(defaultY);
        setY(defaultY);
        setX(defaultX);
        setStep(13,0);

    }

}
