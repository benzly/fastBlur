package com.benz.fastblur;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public native void fast2Blur(Bitmap bitmap, int blurLevel);
}
