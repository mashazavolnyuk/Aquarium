package com.aquarium.mashazavolnyuk.aquarium;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dark Maleficent on 20.09.2016.
 */

public class LiveWallpaperService extends WallpaperService {


    int x, y;
    int xBubble,yBubble;

    @Override
    public Engine onCreateEngine() {
        return new MyWallpaperEngine();
    }
    class MyWallpaperEngine extends Engine {

        private final List<Fish> fishes = new ArrayList<>();
        private final Handler handler = new Handler();
        private final Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                draw();
            }
        };
        private boolean visible = true;
        public Bitmap image1, backgroundImage,bubbles;
        private Paint paint;

        MyWallpaperEngine() {
            // get the fish and background image references
           paint =new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
           image1 = BitmapFactory.decodeResource(getResources(),R.mipmap.fish);
            backgroundImage = BitmapFactory.decodeResource(getResources(), R.mipmap.background);
            bubbles=BitmapFactory.decodeResource(getResources(),R.drawable.bubbles);
            x = 0; // initialize x position
            y = 0;  // initialize y position
           xBubble=0;
            yBubble=0;
            fillDataFishes();


        }

        private void fillDataFishes() {
            fishes.clear();
            fishes.add(new FishBlue());
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
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    c.drawBitmap(image1, x+24,y+100, paint);
                    c.drawBitmap(image1, x+300,y+700, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                        c.drawBitmap(bubbles,xBubble,yBubble,null);




                    // get the width of canvas
                }
                int width = c.getWidth();
                int heght=c.getHeight();

                // if x crosses the width means  x has reached to right edge

                if (x > width) {
                        x = width/3;
                        y = 20;
                        xBubble=0;
                        yBubble=1300;

                }
                if(yBubble<0){
                    c.drawBitmap(bubbles,xBubble,yBubble,null);
                xBubble=0;
                yBubble=1300;}
                // change the x position/value by 1 pixel
                x = x + 3;
                y=y-3;
                 yBubble=yBubble-10;



            }//try
            finally {
                if (c != null)
                    holder.unlockCanvasAndPost(c);
            }
            handler.removeCallbacks(drawRunner);
            if (visible) {
                handler.postDelayed(drawRunner, 1); // delay 10 mileseconds
            }

        }
    }
}
