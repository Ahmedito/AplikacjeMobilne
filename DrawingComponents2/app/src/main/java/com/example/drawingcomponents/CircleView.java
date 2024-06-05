package com.example.drawingcomponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class CircleView extends View {
    private Paint paint;

    public CircleView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(0xFF00FF00);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = 100;
        canvas.drawCircle(200, 200, radius, paint);
    }
}