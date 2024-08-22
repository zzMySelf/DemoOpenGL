package com.tera.scan.network.network.request;

import android.os.Build;
import android.text.TextUtils;
import fe.mmm.qw.j.ggg.qw;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RequestCommonParams {

    /* renamed from: ad  reason: collision with root package name */
    public static String f7052ad;

    /* renamed from: de  reason: collision with root package name */
    public static String f7053de;

    /* renamed from: fe  reason: collision with root package name */
    public static RequestCommonParamsCreator f7054fe;
    public static String qw;

    public interface RequestCommonParamsCreator {
        String ad();

        String de();

        String fe();

        String qw();

        String rg();

        String th();
    }

    public static String ad() {
        if (TextUtils.isEmpty(qw)) {
            try {
                qw = URLEncoder.encode(Build.MODEL, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                qw = qw(Build.MODEL);
            }
        }
        return qw;
    }

    public static String de() {
        try {
            return URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return qw(Build.VERSION.RELEASE);
        }
    }

    public static String fe() {
        return f7054fe.rg();
    }

    public static String i() {
        if (TextUtils.isEmpty(f7053de)) {
            f7053de = qw.qw();
        }
        return System.currentTimeMillis() + "," + f7053de + "," + ((int) (Math.random() * 999999.0d));
    }

    /* renamed from: if  reason: not valid java name */
    public static void m848if(RequestCommonParamsCreator requestCommonParamsCreator) {
        if (f7054fe == null) {
            f7054fe = requestCommonParamsCreator;
        }
    }

    public static String o() {
        RequestCommonParamsCreator requestCommonParamsCreator;
        if (TextUtils.isEmpty(f7052ad) && (requestCommonParamsCreator = f7054fe) != null) {
            f7052ad = requestCommonParamsCreator.ad();
        }
        return f7052ad;
    }

    public static String pf() {
        return f7054fe.fe();
    }

    public static String qw(String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (!TextUtils.isEmpty(str)) {
            stringBuffer = new StringBuffer(str.length());
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt >= ' ' && charAt != 127) {
                    stringBuffer.append(charAt);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String rg() {
        return f7054fe.th();
    }

    public static String th() {
        return fe.mmm.qw.j.vvv.qw.fe(i());
    }

    public static String uk() {
        RequestCommonParamsCreator requestCommonParamsCreator = f7054fe;
        if (requestCommonParamsCreator == null) {
            return th();
        }
        return requestCommonParamsCreator.qw();
    }

    public static String yj() {
        return f7054fe.de();
    }
}
