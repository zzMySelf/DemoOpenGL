package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import java.util.Calendar;
import java.util.TimeZone;

public class c extends a {
    public static final String c = "c";
    public int d;

    public c(String str, int i2, long j, int i3) {
        super(str, 0, i3);
        this.d = i2;
    }

    public int a() {
        return this.d;
    }

    public int c() {
        return 1;
    }

    public String a(Context context) {
        super.b(((Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis() / 1000) - OtpTokenUtils.getmSyncWithServerTime(context)) / ((long) this.d));
        return super.a(context);
    }
}
