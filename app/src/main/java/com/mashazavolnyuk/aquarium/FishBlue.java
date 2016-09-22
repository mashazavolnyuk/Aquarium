package com.mashazavolnyuk.aquarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class FishBlue extends Fish {

    private Bitmap src;
    Context context;

    public FishBlue(Context c){
        context=c;
        src= BitmapFactory.decodeResource(context.getResources(), R.mipmap.fish);
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
