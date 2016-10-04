package com.mashazavolnyuk.aquarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.util.Random;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class Fish {

    protected int x = 0;
    protected int y = 0;
    private int stepY = 0;
    private int stepX = 0;
    private Bitmap bmp;
    private Context context;
    private boolean newDirection = false;
    private int R;


    private double speedWithDirection;

    public Fish(Context context) {
        this.context = context;
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
        turnDirection();

    }

    private void turnDirection() {

        turnDefaultDirection();
        // turnStepDirection();
    }

    private void turnDefaultDirection() {

        Random r = new Random();
        int result = r.nextInt(LiveWallpaperService.backgroundHeight)+1;

        if (x < 0) {
            setX(1);
            setY(result);
            if (stepX < 0)
                setStep(stepX * -1, stepY);
            else
                setStep(stepX, stepY);

        } else {
            //todo setrandom
            setX(0);
            setY(result);
            if (stepX > 0)
                setStep(stepX * -1, stepY);
        }
    }

    private void turnStepDirection() {
        if (stepX < 0)
            setStep(stepX * -1, stepY);
        else
            setStep(stepX, stepY);


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

    public void nextStep(){

    }

}
