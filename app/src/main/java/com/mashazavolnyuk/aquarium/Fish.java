package com.mashazavolnyuk.aquarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class Fish {


    private int x = 0;
    private int y = 0;
    private int stepY = 0;
    private int stepX = 0;
    protected int defaultX;
    protected int defaultY;
    private Bitmap bmp;
    private Context context;

    public Fish(Context context) {
        this.context = context;
    }

    private Context getContext() {

        return context;
    }

    private Bitmap src;


    protected void setDefaultX(int defaultX) {
        this.defaultX = defaultX;
    }

    protected void setDefaultY(int defaultY) {
        this.defaultY = defaultY;
    }

    public int getStepX() {
        return stepX;
    }

    public void plusX(int step){

        x=x+step;
    }

    public void plusY(int step){
        y=y+step;
    }

    public int getStepY() {
        return stepY;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    protected void setStart(int x, int y) {
        setX(x);
        setY(y);
    }

    protected void setStep(int xPlus, int yPlus) {
        stepX = xPlus;
        stepY = yPlus;
    }

    protected void setImageFish(int R) {
        bmp = BitmapFactory.decodeResource(context.getResources(), R);
    }

    public void reset() {
        setX(defaultX);
        setY(defaultY);
    }

    public Bitmap getImageFish() {
        return bmp;
    }

    ;

}
