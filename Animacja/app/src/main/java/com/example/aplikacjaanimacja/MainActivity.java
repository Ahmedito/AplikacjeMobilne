package com.example.aplikacjaanimacja;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView triangle;
    private AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        triangle = findViewById(R.id.triangle);
        animation = new AnimationDrawable();

// Dodawanie klatek do animacji
        animation.addFrame(getResources().getDrawable(R.drawable.trojkat1), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.trojkat2), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.trojkat3), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.trojkat4), 100);

// Ustawienie animacji w ImageView
        triangle.setImageDrawable(animation);
    }

    public void startAnimation(View view) {
        if (animation != null) {
            animation.start();
        }
    }

    public void stopAnimation(View view) {
        if (animation != null) {
            animation.stop();
        }
    }

    public void stepAnimation(View view) {
        if (animation != null) {
            int numOfFrames = animation.getNumberOfFrames();
            int currentFrame = 0;
            for (int i = 0; i < numOfFrames; i++) {
                if (animation.getFrame(i) == animation.getCurrent()) {
                    currentFrame = i;
                    break;
                }
            }
            currentFrame = (currentFrame + 1) % numOfFrames;
            animation.selectDrawable(currentFrame);
            animation.invalidateSelf();
        }
    }

    public void displayAuthor(View view) {
        Toast.makeText(this, "Bartosz Wojciechowski", Toast.LENGTH_SHORT).show();
    }
}
