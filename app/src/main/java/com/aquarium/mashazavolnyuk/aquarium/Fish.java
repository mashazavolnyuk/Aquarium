package com.aquarium.mashazavolnyuk.aquarium;

import android.graphics.Bitmap;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public abstract class Fish {


    private int x=0;
    private int y=0;
    private int stepY=0;
    private int stepX=0;
    private Bitmap src;

    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    protected void setStart(int x, int y) {
        setX(x);
        setY(y);
    }

    protected void setStep(int xPlus, int yPlus) {
        stepX=xPlus;
        stepY=yPlus;
    }

    abstract Bitmap getImageFish();

}
