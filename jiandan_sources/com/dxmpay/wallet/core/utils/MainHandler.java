package com.dxmpay.wallet.core.utils;

import android.os.Handler;
import android.os.Looper;

public class MainHandler extends Handler {
    public static volatile MainHandler qw;

    public MainHandler() {
        super(Looper.getMainLooper());
    }

    public static MainHandler getInstance() {
        if (qw == null) {
            synchronized (MainHandler.class) {
                if (qw == null) {
                    qw = new MainHandler();
                }
            }
        }
        return qw;
    }
}
