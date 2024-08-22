package com.google.android.gms.internal.play_billing;

import com.baidu.sapi2.share.ShareCallPacking;

public final class zzm {
    public static int zza(int i2, int i3, String str) {
        String str2;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            str2 = zzn.zza("%s (%s) must not be negative", ShareCallPacking.StatModel.KEY_INDEX, Integer.valueOf(i2));
        } else if (i3 < 0) {
            throw new IllegalArgumentException("negative size: " + i3);
        } else {
            str2 = zzn.zza("%s (%s) must be less than size (%s)", ShareCallPacking.StatModel.KEY_INDEX, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    public static int zzb(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(zze(i2, i3, ShareCallPacking.StatModel.KEY_INDEX));
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void zzd(int i2, int i3, int i4) {
        String str;
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            if (i2 < 0 || i2 > i4) {
                str = zze(i2, i4, "start index");
            } else if (i3 < 0 || i3 > i4) {
                str = zze(i3, i4, "end index");
            } else {
                str = zzn.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static String zze(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzn.zza("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return zzn.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }
}
