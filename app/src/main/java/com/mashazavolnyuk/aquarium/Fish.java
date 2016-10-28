package com.mashazavolnyuk.aquarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;

import java.util.Random;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class Fish {

    private static final String TAG = "Fish";
    protected float x = 0;
    protected float y = 0;

    private float velocityY = 0;
    private float velocityX = 0;
    private Bitmap bmp;
    private boolean isDead;

    protected float speedMulti = 1;
    private static final int DEF_SPEED = 100;
    private static final int DEVIATION = 30;

    public Fish(Context context, int R) {
        setImageFish(context, R);
        init();
    }

    public void init(){
        Random random =  new Random();
        int randDeviation = random.nextInt(DEVIATION);
        boolean isNegative = random.nextBoolean();
        if(isNegative)
            randDeviation = -randDeviation;

        velocityX = (DEF_SPEED + randDeviation) * speedMulti * LiveWallpaperService.density;
        boolean toLeft = random.nextBoolean();
        y = random.nextInt(LiveWallpaperService.backgroundHeight - bmp.getHeight());
        if(toLeft) {
            x = LiveWallpaperService.backgroundHeight;
            reflectImage();
            velocityX = -velocityX;
        } else {
            x = -bmp.getWidth();
        }
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
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

    public boolean isDead() {
        return isDead;
    }

    private void reflectImage() {
        Matrix matrix = new Matrix();
        matrix.setRotate(180);
        matrix.preScale(1.0f, -1.0f);
        bmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
    }

    public Bitmap getImageFish() {
        return bmp;
    }

    public void nextStep(int timeMillis){
//        if(isDead)
//            return;

        float distanceX = (float)timeMillis / 1000 * velocityX;
        float distanceY = (float)timeMillis / 1000 * velocityY;
        if (x >= -bmp.getWidth() && x <= LiveWallpaperService.backgroundWidth
                && y >= -bmp.getHeight() && y <= LiveWallpaperService.backgroundHeight) {
            x += distanceX;
            y += distanceY;
        } else {
            x += distanceX;
            y += distanceY;
            isDead = true;
        }
        Log.d(TAG, this.getClass().getSimpleName() + "x=" + x + ", y=" + y);
    }

}
