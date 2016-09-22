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
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.aquarium.mashazavolnyuk.mashazavolnyuk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class LiveWallpaperService extends WallpaperService {


    int x, y;
    int xBubble, yBubble;
    int xWater,yWater;

    @Override
    public Engine onCreateEngine() {
        return new MyWallpaperEngine();
    }

    class MyWallpaperEngine extends Engine {
        Context c=getApplicationContext();
        private final List<Fish> fishes = new ArrayList<>();
        private final Handler handler = new Handler();
        private final Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                draw();
            }
        };
        private boolean visible = true;
        public Bitmap fishBlue,fishDragon, backgroundImage, bubbles, water;
        FishBlue fishBluez=new FishBlue(c);
        private Paint paint;
        public Context getContext(){
            return  c;
        }
        MyWallpaperEngine() {
            // get the fish and background image references
            paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            fishBlue = BitmapFactory.decodeResource(getResources(), R.mipmap.fish);
            fishDragon=BitmapFactory.decodeResource(getResources(), R.mipmap.rotfeuerfisch);
            water=BitmapFactory.decodeResource(getResources(),R.mipmap.water);
            backgroundImage = BitmapFactory.decodeResource(getResources(), R.mipmap.background);
            bubbles = BitmapFactory.decodeResource(getResources(), R.mipmap.bubbles);
            x = 0; // initialize x position
            y = 0;  // initialize y position
            xBubble = 0;
            yBubble = 0;
            xWater=0;
            yWater=0;
            fillDataFishes();


        }

        private void fillDataFishes() {
            fishes.clear();
            fishes.add(new FishBlue(c));
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
                // clear the canvas
                c.drawColor(Color.BLACK);
                if (c != null) {
                    // draw the background image
                    c.drawBitmap(backgroundImage, 0, 0, null);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                    c.drawBitmap(water,xWater,yWater,paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    c.drawBitmap(fishBlue, x , y + 100, paint);
                    c.drawBitmap(fishBluez.getImageFish(),x,y,paint);

                    c.drawBitmap(fishBlue, x + 300, y + 700, paint);
                    c.drawBitmap(bubbles, xBubble+90, yBubble+70, null);
                    c.drawBitmap(bubbles, xBubble+240, yBubble-2, null);
                    c.drawBitmap(bubbles, xBubble, yBubble, null);
                    c.drawBitmap(fishDragon,x+500,y+900,null);

                    // get the width of canvas
                }
                int width = c.getWidth();
                int height = c.getHeight();
                xWater=width/2;
                yWater=height/2;
                // if x crosses the width means  x has reached to right edge

                if (x > width) {
                    x = x-5;
                    y = y-10;
                    xBubble = 0;
                    yBubble = 1300;

                }

                if (yBubble < 0) {
                    c.drawBitmap(bubbles, xBubble, yBubble, null);
                    xBubble = xWater;
                    yBubble = yWater;
                }
                // change the x position/value by 1 pixel
                x = x +3;
                y = y + 3;
                yBubble = yBubble - 10;


            }//try+
            finally {
                if (c != null)
                    holder.unlockCanvasAndPost(c);
            }
            handler.removeCallbacks(drawRunner);
            if (visible) {
                handler.postDelayed(drawRunner, 5); // delay 10 mileseconds
            }

        }

        @Override
        public void onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    x=0;
                    y=0;
            }
        }
    }
}
