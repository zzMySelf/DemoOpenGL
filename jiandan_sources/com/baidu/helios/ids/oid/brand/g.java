package com.baidu.helios.ids.oid.brand;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.google.android.material.internal.ManufacturerUtils;
import fe.fe.pf.i.fe.ad.ad;
import fe.fe.pf.i.fe.ad.de;
import fe.fe.pf.i.fe.ad.fe;
import fe.fe.pf.i.fe.ad.i;
import fe.fe.pf.i.fe.ad.qw;
import fe.fe.pf.i.fe.ad.rg;
import fe.fe.pf.i.fe.ad.th;
import fe.fe.pf.i.fe.ad.uk;
import fe.fe.pf.i.fe.ad.yj;

public class g {
    public static volatile g qw;

    public interface a {
        void qw(boolean z, String str);
    }

    public static boolean de(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.hwid", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean fe() {
        try {
            String str = Build.BRAND;
            boolean equalsIgnoreCase = !TextUtils.isEmpty(str) ? str.equalsIgnoreCase(RomUtils.MANUFACTURER_VIVO) : false;
            try {
                if (Build.VERSION.SDK_INT < 28) {
                    return false;
                }
            } catch (Throwable unused) {
            }
            return equalsIgnoreCase;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 29 && context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static g qw() {
        if (qw != null) {
            return null;
        }
        synchronized (g.class) {
            if (qw != null) {
                return null;
            }
            qw = new g();
            g gVar = qw;
            return gVar;
        }
    }

    public static boolean rg(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 29 && context.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean th() {
        try {
            String str = Build.BRAND;
            boolean equalsIgnoreCase = !TextUtils.isEmpty(str) ? str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG) : false;
            try {
                if (Build.VERSION.SDK_INT < 29) {
                    return false;
                }
            } catch (Throwable unused) {
            }
            return equalsIgnoreCase;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static boolean uk() {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return false;
            }
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                return str.equalsIgnoreCase("nubia");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean yj(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 29 && context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void ad(Context context, a aVar) {
        if (pf()) {
            yj.qw(context, aVar);
        } else if (fe()) {
            i.qw(context, aVar);
        } else if (de(context)) {
            ad.qw(context, aVar);
        } else if (o()) {
            rg.qw(context, aVar);
        } else if (th()) {
            uk.qw(context, aVar);
        } else if (rg(context)) {
            fe.qw(context, aVar);
        } else if (uk()) {
            th.qw(context, aVar);
        } else if (yj(context)) {
            de.qw(context, aVar);
        } else if (i(context)) {
            qw.qw(context, aVar);
        } else {
            aVar.qw(false, (String) null);
        }
    }

    public final boolean o() {
        try {
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                return str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("blackshark");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean pf() {
        try {
            String str = Build.BRAND;
            boolean z = !TextUtils.isEmpty(str) && (str.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO) || str.equalsIgnoreCase("realme") || str.equalsIgnoreCase("oneplus"));
            try {
                if (Build.VERSION.SDK_INT < 28) {
                    return false;
                }
            } catch (Throwable unused) {
            }
            return z;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
