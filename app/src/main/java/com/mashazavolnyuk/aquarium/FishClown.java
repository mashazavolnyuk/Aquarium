package com.mashazavolnyuk.aquarium;

import android.content.Context;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 23.09.2016.
 */

public class FishClown extends Fish {


    public FishClown(Context c,int width,int height){
        super(c);
        setImageFish(R.mipmap.clownfish);
        defaultX=width/9;
        defaultY=height/8;
        setDefaultX(defaultX);
        setDefaultY(defaultY);
        setY(defaultY);
        setX(defaultX);
        setStep(13,3);

    }

}
