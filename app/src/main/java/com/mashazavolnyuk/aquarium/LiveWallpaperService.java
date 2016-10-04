package com.mashazavolnyuk.aquarium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class LiveWallpaperService extends WallpaperService {

    public static int backgroundWidth = 0;
    public static int backgroundHeight = 0;

    int xBubble, yBubble;

    @Override
    public Engine onCreateEngine() {
        return new MyWallpaperEngine();
    }

    class MyWallpaperEngine extends Engine {
        Context c = getApplicationContext();
        private final List<Fish> fishes = new ArrayList<>();
        private final Handler handler = new Handler();
        private final Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 10);
                draw();
            }
        };
        private boolean visible = true;
        public Bitmap backgroundImage, bubbles, water;
        private Paint paint;


        public Context getContext() {
            return c;
        }

        MyWallpaperEngine() {
            // get the fish and background image references
            paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            bubbles=BitmapFactory.decodeResource(getResources(),R.mipmap.bubbles);
            backgroundImage = BitmapFactory.decodeResource(getResources(), R.mipmap.background);

            backgroundWidth = backgroundImage.getWidth();

            backgroundHeight = backgroundImage.getHeight();
            backgroundImage.getHeight();
            xBubble = 0;
            yBubble = 0;
            yBubble = backgroundHeight /6;
            xBubble = backgroundWidth /2;
            fillDataFishes();


        }

        private void fillDataFishes() {
            fishes.clear();
            fishes.add(new FishBlue(c));
            fishes.add(new FishBlue(c,backgroundWidth/3+backgroundWidth/4, backgroundHeight /2- backgroundHeight /7,-20));
            fishes.add(new FishClown(c));
            fishes.add(new FishDragon(c));
            fishes.add(new FishYellow(c));
           // fishes.add(new FishYellow(c, backgroundWidth, backgroundHeight, backgroundWidth / 4 + backgroundWidth / 2, backgroundHeight / 2 - backgroundHeight / 6, 10));

        }

        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            // if screen wallpaper is visible then draw the image otherwise do not draw
            if (visible) {
                handler.post(drawRunner);
            } else {
                handler.removeCallbacks(drawRunner);
            }
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this.visible = false;
            handler.removeCallbacks(drawRunner);
        }

        public void onOffsetsChanged(float xOffset, float yOffset, float xStep, float yStep, int xPixels, int yPixels) {
            draw();
        }

        void draw() {
            final SurfaceHolder holder = getSurfaceHolder();
            Canvas c = null;

            try {
                c = holder.lockCanvas();
                c.drawColor(Color.BLACK);
                if (c != null) {
                    c.drawBitmap(backgroundImage, 0, 0, null);
                    c.drawBitmap(bubbles, xBubble, yBubble, null);
                    for (Fish fish : fishes) {
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                        c.drawBitmap(fish.getImageFish(), fish.getX(), fish.getY(), paint);

                    }
                    c.drawBitmap(bubbles, xBubble, yBubble, paint);

                }
                int width = c.getWidth();
                Log.d("width", "w" + c.getWidth());
                int height = c.getHeight();
                Log.d("height", "w" + c.getHeight());

                for (Fish fish : fishes) {
                    if (fish.getX() > 0 & fish.getX() < width) {
                        fish.setX(fish.getX() + fish.getStepX());
                        fish.setY(fish.getY() + fish.getStepY());
                    } else {
                        fish.reset();
                    }
                }
                if (yBubble<=height&&yBubble>0) {
                    yBubble = yBubble - 20;
                    //c.drawBitmap(bubbles, xBubble, yBubble, null);
                    Log.d("yBubble", " " + yBubble);
                }
                else{

                    yBubble = backgroundHeight;
                    xBubble = backgroundWidth /2;
                    if(backgroundHeight >height)
                        yBubble=height;
                    Log.d("yBubble"," "+yBubble);
                }



            }//try+
            finally {
                if (c != null)
                    holder.unlockCanvasAndPost(c);
            }
            handler.removeCallbacks(drawRunner);
            if (visible) {
                handler.postDelayed(drawRunner, 60); // delay 10 mileseconds
            }

        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
            }
        }
    }
}
