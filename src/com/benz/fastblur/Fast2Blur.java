package com.benz.fastblur;

import android.graphics.Bitmap;
import android.util.Log;

public class Fast2Blur {

    static {
        Log.d("ImageUtils", "load  JNI_ImageBlur.so  start");
        System.loadLibrary("JNI_ImageBlur");
        Log.d("ImageUtils", "load  JNI_ImageBlur.so  end");
    }

    public static void build(Bitmap bitmap, int blurLevel) throws Exception {
        if (blurLevel <=0 || blurLevel >=100) {
            throw new Exception("blurLevel must be ( >0 && <100 )");
        } else {
            buildBlur(bitmap, blurLevel);
        }
    }
    
    private static native void buildBlur(Bitmap bitmap, int blurLevel);
}
