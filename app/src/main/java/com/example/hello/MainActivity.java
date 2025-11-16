package com.example.hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.view.Gravity;
import android.view.ViewGroup;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("Hello!");
        tv.setTextSize(24f);
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        FrameLayout root = new FrameLayout(this);
        root.addView(tv);
        setContentView(root);
    }
}

