package com.baidu.idl.util;

import android.os.Looper;

public class UIThread {
    public static boolean isUITread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
