package com.example.ball;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Point screenSize;
    Random rand;
    BallView ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        screenSize = new Point();
        display.getRealSize(screenSize);
        rand = new Random();

        ball = new BallView(this, getX(), getY());

        setContentView(ball);
        moveBall();
    }

    private void moveBall() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                ball.updateBallPosition();
                handler.postDelayed(this, 16);
            }
        });
    }

    private float getX() {
        float randX = rand.nextFloat();
        float x = screenSize.x * randX;
        if(x > screenSize.x - 100) {
            x = x - 100;
        }
        if(x < 100) {
            x = x + 100;
        }
        return x;
    }
    private float getY() {
        float randY = rand.nextFloat();
        float y = screenSize.y * randY;
        if(y > screenSize.y - 100) {
            y = y - 100;
        }
        if(y < 100) {
            y = y + 100;
        }
        return y;
    }
}