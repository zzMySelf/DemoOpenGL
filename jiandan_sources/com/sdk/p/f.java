package com.sdk.p;

import android.content.Context;
import java.util.ArrayList;

public class f extends com.sdk.i.a {

    public enum a {
        WIFI,
        NET,
        UNKNOW;

        public abstract int a();
    }

    public enum b {
        a,
        b,
        CTC;

        public abstract String a();
    }

    static {
        boolean z = com.sdk.f.f.a;
    }

    public static a a(Context context, ArrayList<String> arrayList) {
        a aVar = a.UNKNOW;
        return a.a(context);
    }
}
