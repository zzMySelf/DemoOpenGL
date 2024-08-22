package com.baidu.wallet.core.utils;

import android.os.Handler;
import android.os.Looper;

public class MainHandler extends Handler {
    public static volatile MainHandler a;

    public MainHandler() {
        super(Looper.getMainLooper());
    }

    public static MainHandler getInstance() {
        if (a == null) {
            synchronized (MainHandler.class) {
                if (a == null) {
                    a = new MainHandler();
                }
            }
        }
        return a;
    }
}
