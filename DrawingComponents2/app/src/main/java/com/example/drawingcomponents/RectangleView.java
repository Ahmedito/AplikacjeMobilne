package com.example.drawingcomponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RectangleView extends View {
    private Paint paint;

    public RectangleView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(0xFFFFFF00);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = 300;
        int height = 150;
        canvas.drawRect(100, 100, 100 + width, 100 + height, paint);
    }
}