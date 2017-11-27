package com.m68476521.mike.myapplication;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isDefaultText = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String text = "simple text";
        final String text2 = "simple text with description";



        final TextView example = findViewById(R.id.text_view_example);
        example.setText(text);
        example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup layout = (ViewGroup) findViewById(R.id.activity_main_);
                TransitionManager.beginDelayedTransition(layout);


                int finalRadius = Math.max(v.getWidth(), v.getHeight()) / 2;
                Animator anim = ViewAnimationUtils.createCircularReveal(v,
                        (int) v.getWidth()/2,
                        (int) v.getHeight()/2,
                        0,
                        finalRadius);
                if (isDefaultText) {
                    example.setText(text2);
                    example.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                } else {

                    example.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    example.setText(text);

                }
                anim.start();
                isDefaultText = !isDefaultText;
            }
        });
    }
}
