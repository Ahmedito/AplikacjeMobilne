package com.example.ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class BallView extends View {
    private Random random;
    private Paint paint;
    private float x, y;
    private float radius;
    private double angle;
    private float speed;

    public BallView(Context context, float x, float y) {
        super(context);
        random = new Random();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        this.x = x;
        this.y = y;
        radius = 50;
        angle = Math.random() * Math.PI * 2;
        speed = 10;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, radius, paint);
    }

    public void updateBallPosition() {

        float newX = (float) (x + speed * Math.cos(angle));
        float newY = (float) (y + speed * Math.sin(angle));

        if (newX - radius < 0 || newX + radius > getWidth()) {
            angle = Math.PI - angle;
            newX = Math.max(radius, Math.min(getWidth() - radius, newX));
            paint.setColor(changeColor(paint.getColor()));
        }
        if (newY - radius < 0 || newY + radius > getHeight()) {
            angle = -angle;
            newY = Math.max(radius, Math.min(getHeight() - radius, newY));
            paint.setColor(changeColor(paint.getColor()));
        }

        x = newX;
        y = newY;
        invalidate();
    }

    private int changeColor(int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);

        int delta = 50;
        r = (r + random.nextInt(2 * delta + 1) - delta) % 256;
        g = (g + random.nextInt(2 * delta + 1) - delta) % 256;
        b = (b + random.nextInt(2 * delta + 1) - delta) % 256;

        r = Math.max(0, Math.min(255, r));
        g = Math.max(0, Math.min(255, g));
        b = Math.max(0, Math.min(255, b));

        return Color.rgb(r, g, b);
    }
}
