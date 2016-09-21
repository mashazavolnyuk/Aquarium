package com.aquarium.mashazavolnyuk.aquarium;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    private Bitmap src;

    public FishBlue(){

        src= BitmapFactory.decodeResource(Resources.getSystem(),R.mipmap.fish);
        setStart(90,60);
        setStep(10,1);
    }

    @Override
    protected void setStart(int x, int y) {
        super.setStart(x, y);
    }

    @Override
    protected void setStep(int xPlus, int yPlus) {
        super.setStep(xPlus, yPlus);
    }

    @Override
    Bitmap getImageFish() {
        return src;
    }

}
