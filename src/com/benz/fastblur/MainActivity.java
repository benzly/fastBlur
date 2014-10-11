package com.benz.fastblur;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    static {
        Log.d("ImageUtils", "load  JNI_ImageBlur.so  start");
        System.loadLibrary("JNI_ImageBlur");
        Log.d("ImageUtils", "load  JNI_ImageBlur.so  end");
    }

    boolean isBlur = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView iv = (ImageView) findViewById(R.id.blur);
        iv.setImageResource(R.drawable.test);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        float start = System.currentTimeMillis();
        fast2Blur(bitmap, 1);
        System.out.println("fast 2 blur : " + (System.currentTimeMillis() - start));

        final Bitmap blur = bitmap;

        Button bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBlur) {
                    iv.setImageResource(R.drawable.test);
                } else {
                    iv.setImageBitmap(blur);
                }
            }
        });
    }

    public native void fast2Blur(Bitmap bitmap, int blurLevel);
}
