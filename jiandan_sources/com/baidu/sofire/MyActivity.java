package com.baidu.sofire;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.sofire.a.a;

public class MyActivity extends Activity {
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
        finish();
    }
}
