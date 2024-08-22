package com.sdk.f;

import android.content.Context;
import com.sdk.base.framework.bean.AInfo;
import com.sdk.base.framework.bean.PInfo;
import com.sdk.base.framework.bean.SInfo;
import com.sdk.base.module.config.BaseConfig;
import java.util.ArrayList;

public class a {
    public static boolean a = false;
    public static String b = "";
    public static String c = "";

    public static AInfo a(Context context) {
        String str;
        AInfo aInfo = new AInfo();
        aInfo.setN(com.sdk.j.a.a(context));
        aInfo.setC(com.sdk.j.a.d(context));
        aInfo.setV(com.sdk.j.a.e(context));
        if (a) {
            aInfo.setPk(c);
            str = b;
        } else {
            aInfo.setPk(com.sdk.j.a.c(context));
            str = com.sdk.j.a.b(context);
        }
        aInfo.setMd5(str);
        return aInfo;
    }

    public static ArrayList a() {
        return new ArrayList();
    }

    public static PInfo b() {
        PInfo pInfo = new PInfo();
        pInfo.setOs("Android");
        return pInfo;
    }

    public static SInfo c() {
        SInfo sInfo = new SInfo();
        sInfo.setN(BaseConfig.n);
        sInfo.setC(BaseConfig.c);
        sInfo.setV(BaseConfig.v);
        sInfo.setCm(BaseConfig.cm);
        return sInfo;
    }
}
