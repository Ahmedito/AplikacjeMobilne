package com.example.drawingcomponents;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                400 
        );
        params.setMargins(0, 20, 0, 20);

        SquareView squareView = new SquareView(this);
        squareView.setLayoutParams(params);
        layout.addView(squareView);

        CircleView circleView = new CircleView(this);
        circleView.setLayoutParams(params);
        layout.addView(circleView);

        LineView lineView = new LineView(this);
        lineView.setLayoutParams(params);
        layout.addView(lineView);

        RectangleView rectangleView = new RectangleView(this);
        rectangleView.setLayoutParams(params);
        layout.addView(rectangleView);
    }
}
