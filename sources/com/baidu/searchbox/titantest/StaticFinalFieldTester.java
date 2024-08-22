package com.baidu.searchbox.titantest;

import android.util.Log;

public class StaticFinalFieldTester {
    public static final String TAG = "TitanTest";
    private static final long curTime = System.currentTimeMillis();

    public static void testStaticFinalField() {
        Log.d("TitanTest", "class init time = " + curTime + " ms");
    }
}
