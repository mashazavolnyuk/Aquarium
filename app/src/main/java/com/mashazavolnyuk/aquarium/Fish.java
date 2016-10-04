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

    protected float x = 0;
    protected float y = 0;


    private float velocityY = 0;
    private float velocityX = 0;
    private Bitmap bmp;
    private boolean newDirection = false;

    public Fish() {
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    protected void setStart(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     *
     * @param velocityX - velocity by width in pixels/second
     * @param velocityY - velocity by height in pixels/second
     */
    protected void setVelocity(float velocityX, float velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    protected void setImageFish(Context context, int R) {
        bmp = BitmapFactory.decodeResource(context.getResources(), R);
    }

    private void setImageFish(Bitmap reflection) {
        bmp = reflection;
    }

    public void reset() {

        if (newDirection == false) {
            newDirection = true;
            bmp = getReflectionImage();
        } else {
            newDirection = false;
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
            if (velocityX < 0)
                setVelocity(velocityX * -1, velocityY);
            else
                setVelocity(velocityX, velocityY);

        } else {
            //todo setrandom
            setX(0);
            setY(result);
            if (velocityX > 0)
                setVelocity(velocityX * -1, velocityY);
        }
    }

    private void turnStepDirection() {
        if (velocityX < 0)
            setVelocity(velocityX * -1, velocityY);
        else
            setVelocity(velocityX, velocityY);
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

    public void nextStep(int timeMillis){
        float distanceX = (float)timeMillis / 1000 * velocityX;
        float distanceY = (float)timeMillis / 1000 * velocityY;
        if (x > bmp.getWidth() && x < LiveWallpaperService.backgroundWidth
                && y > bmp.getHeight() && y < LiveWallpaperService.backgroundHeight) {
            x += distanceX;
            y += distanceY;
        } else {
            reset();
        }
    }

}
