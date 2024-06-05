package com.example.drawingcomponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class LineView extends View {
    private Paint paint;

    public LineView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(0xFF0000FF);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50, 50, 250, 250, paint);
    }
}