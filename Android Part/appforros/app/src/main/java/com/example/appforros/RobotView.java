package com.example.appforros;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Base64;
import android.view.View;

public class RobotView extends View {
    private float bitmapX;
    private float bitmapY;

    public RobotView(Context context) {
        super(context);
        bitmapX = 160;
        bitmapY = 160;
    }

    public void setBitmapX(int x) {
        bitmapX = (float) x;
    }

    public void setBitmapY(int y) {
        bitmapY = (float) y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = Bitmap.createBitmap(20,20,Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#ff0000"));
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);
        System.out.println("bitmap" + bitmap.toString());
        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
