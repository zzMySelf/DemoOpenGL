package com.baidu.apollon.utils;

import android.content.Context;
import com.baidu.apollon.NoProguard;
import fe.yj.qw.qw.qw;

public class DxmApplicationContextImpl implements NoProguard {
    public static Context getApplicationContext(Context context) {
        return qw.qw(context);
    }
}
