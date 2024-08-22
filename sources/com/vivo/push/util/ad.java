package com.vivo.push.util;

import android.content.Context;
import com.yy.transvod.player.core.NetStatManager;

/* compiled from: SharePreferenceManager */
public final class ad extends c {

    /* renamed from: b  reason: collision with root package name */
    private static ad f6529b;

    public static synchronized ad b() {
        ad adVar;
        synchronized (ad.class) {
            if (f6529b == null) {
                f6529b = new ad();
            }
            adVar = f6529b;
        }
        return adVar;
    }

    public final synchronized void a(Context context) {
        if (this.f6550a == null) {
            this.f6550a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] d2 = d(b("com.vivo.push.secure_cache_iv", ""));
        if (d2 == null || d2.length <= 0) {
            return new byte[]{34, NetStatManager.ISPType.MOB, 33, 37, 33, 34, NetStatManager.ISPType.MOB, 33, 33, 33, 34, 41, 35, NetStatManager.ISPType.MOB, NetStatManager.ISPType.MOB, NetStatManager.ISPType.MOB};
        }
        return d2;
    }

    public final byte[] d() {
        byte[] d2 = d(b("com.vivo.push.secure_cache_key", ""));
        if (d2 == null || d2.length <= 0) {
            return new byte[]{33, 34, 35, 36, 37, 38, 39, 40, 41, NetStatManager.ISPType.MOB, 38, 37, 36, 35, 34, 33};
        }
        return d2;
    }

    private static byte[] d(String str) {
        int i2;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i2 = split.length;
            } else {
                i2 = 0;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = Byte.parseByte(split[i3].trim());
            }
        } catch (Exception e2) {
            u.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
