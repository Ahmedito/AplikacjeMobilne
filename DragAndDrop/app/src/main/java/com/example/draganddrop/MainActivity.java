package com.example.draganddrop;

import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int currentColor = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button buttonRed = findViewById(R.id.buttonRed);
        Button buttonGreen = findViewById(R.id.buttonGreen);
        Button buttonBlue = findViewById(R.id.buttonBlue);

        buttonRed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDragAndDrop(null, shadowBuilder, v, 0);
                    return true;
                }
                return false;
            }
        });

        buttonGreen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDragAndDrop(null, shadowBuilder, v, 0);
                    return true;
                }
                return false;
            }
        });

        buttonBlue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDragAndDrop(null, shadowBuilder, v, 0);
                    return true;
                }
                return false;
            }
        });

        textView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:

                        return true;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        
                        v.setBackgroundColor(currentColor);
                        return true;
                    case DragEvent.ACTION_DRAG_EXITED:

                        v.setBackgroundColor(currentColor);
                        return true;
                    case DragEvent.ACTION_DROP:

                        TextView target = (TextView) v;
                        Button draggedButton = (Button) event.getLocalState();
                        currentColor = getColorForButton(draggedButton);
                        v.setBackgroundColor(currentColor);
                        String buttonText = draggedButton.getText().toString();
                        target.setText(buttonText);
                        return true;
                    case DragEvent.ACTION_DRAG_ENDED:

                        v.setBackgroundColor(currentColor);
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private int getColorForButton(Button button) {
        int color = Color.WHITE;
        if (button.getId() == R.id.buttonRed) {
            color = Color.RED;
        } else if (button.getId() == R.id.buttonGreen) {
            color = Color.GREEN;
        } else if (button.getId() == R.id.buttonBlue) {
            color = Color.BLUE;
        }
        return color;
    }
}
