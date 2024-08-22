package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;

public class zzl {
    public static final zzl zzao = new zzl(true, (String) null, (Throwable) null);
    public final Throwable cause;
    public final boolean zzap;
    public final String zzaq;

    public zzl(boolean z, String str, Throwable th2) {
        this.zzap = z;
        this.zzaq = str;
        this.cause = th2;
    }

    public static zzl zza(Callable<String> callable) {
        return new zzn(callable);
    }

    public static zzl zzb(@NonNull String str) {
        return new zzl(false, str, (Throwable) null);
    }

    public static String zzc(String str, zzd zzd, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2 ? "debug cert rejected" : "not whitelisted", str, Hex.bytesToStringLowercase(AndroidUtilsLight.zzj("SHA-1").digest(zzd.getBytes())), Boolean.valueOf(z), "12451009.false"});
    }

    public static zzl zze() {
        return zzao;
    }

    public String getErrorMessage() {
        return this.zzaq;
    }

    public final void zzf() {
        if (!this.zzap && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.cause != null) {
                getErrorMessage();
            } else {
                getErrorMessage();
            }
        }
    }

    public static zzl zza(@NonNull String str, @NonNull Throwable th2) {
        return new zzl(false, str, th2);
    }
}
