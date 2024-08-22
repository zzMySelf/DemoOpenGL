package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseActivity extends Activity {
    public final boolean a() {
        boolean z;
        Exception e2;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[]{TypedArray.class});
            method.setAccessible(true);
            z = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            Exception exc = e4;
            z = false;
            e2 = exc;
            e2.printStackTrace();
            return z;
        }
        return z;
    }

    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && a()) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
                declaredField.setAccessible(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        super.onCreate(bundle);
    }

    public final void setRequestedOrientation(int i2) {
        if (Build.VERSION.SDK_INT != 26 || !a()) {
            super.setRequestedOrientation(i2);
        }
    }
}
