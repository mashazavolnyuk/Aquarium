package com.mashazavolnyuk.aquarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

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
    private boolean newDirection = false;
    private int R;

    public Fish(Context context) {
        this.context = context;
    }

    protected void setDefaultX(int defaultX) {
        this.defaultX = defaultX;
    }

    protected void setDefaultY(int defaultY) {
        this.defaultY = defaultY;
    }

    public int getStepX() {
        return stepX;
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
        this.R = R;
        bmp = BitmapFactory.decodeResource(context.getResources(), R);
    }

    private void setImageFish(Bitmap reflection) {

        bmp = reflection;
    }

    public void reset() {

        if (newDirection == false) {
            newDirection = true;
            setImageFish(getReflectionImage());

        } else {
            newDirection = false;
            setImageFish(R);
        }

        setX(defaultX);
        setY(defaultY);
    }

    private Bitmap getReflectionImage() {
        Matrix matrix = new Matrix();
        matrix.setRotate(180);
        matrix.preScale(1.0f, -1.0f);
        Bitmap resizedBitmap = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
        return resizedBitmap;
    }

    public Bitmap getImageFish() {
        return bmp;
    }

    ;

}
