package com.example.drawingcomponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class SquareView extends View {
    private Paint paint;

    public SquareView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(0xFFFF0000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = 200;
        canvas.drawRect(50, 50, 50 + size, 50 + size, paint);
    }
}