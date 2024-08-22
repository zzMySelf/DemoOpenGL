package com.baidu.mobstat.dxmpay;

import android.os.Build;

public class Config {

    /* renamed from: ad  reason: collision with root package name */
    public static String f882ad;

    /* renamed from: de  reason: collision with root package name */
    public static String f883de;

    /* renamed from: fe  reason: collision with root package name */
    public static final String f884fe = "__local_";
    public static final String qw = (Build.VERSION.SDK_INT < 9 ? "http://hmma.baidu.com/app.gif" : "https://hmma.baidu.com/app.gif");

    /* renamed from: rg  reason: collision with root package name */
    public static final String f885rg = (f884fe + "last_session.json");

    /* renamed from: th  reason: collision with root package name */
    public static final String f886th = (f884fe + "ap_info_cache.json");

    /* renamed from: yj  reason: collision with root package name */
    public static final String f887yj = (f884fe + "stat_cache.json");

    public enum EventViewType {
        EDIT(0),
        BUTTON(1);
        
        public int a;

        /* access modifiers changed from: public */
        EventViewType(int i2) {
            this.a = i2;
        }

        public int getValue() {
            return this.a;
        }

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    static {
        f882ad = "";
        f883de = "";
        f883de = "__send_data_";
        f882ad = "__track_send_data_";
        f884fe + "except_cache.json";
        f884fe + "stat_full_cache.json";
    }
}
