package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import androidx.renderscript.ScriptIntrinsicBLAS;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class GmsClientSupervisor {
    public static final Object zzec = new Object();
    public static GmsClientSupervisor zzed;

    public static final class zza {
        public static final Uri zzem = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        public final ComponentName componentName;
        public final String packageName;
        public final String zzej;
        public final int zzek;
        public final boolean zzel;

        public zza(String str, int i2) {
            this(str, "com.google.android.gms", ScriptIntrinsicBLAS.RsBlas_ctrmm);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return Objects.equal(this.zzej, zza.zzej) && Objects.equal(this.packageName, zza.packageName) && Objects.equal(this.componentName, zza.componentName) && this.zzek == zza.zzek && this.zzel == zza.zzel;
        }

        public final ComponentName getComponentName() {
            return this.componentName;
        }

        public final String getPackage() {
            return this.packageName;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzej, this.packageName, this.componentName, Integer.valueOf(this.zzek), Boolean.valueOf(this.zzel));
        }

        public final String toString() {
            String str = this.zzej;
            return str == null ? this.componentName.flattenToString() : str;
        }

        public final Intent zzb(Context context) {
            if (this.zzej == null) {
                return new Intent().setComponent(this.componentName);
            }
            Intent intent = null;
            if (this.zzel) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", this.zzej);
                Bundle call = context.getContentResolver().call(zzem, "serviceIntentCall", (String) null, bundle);
                if (call != null) {
                    intent = (Intent) call.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf = String.valueOf(this.zzej);
                    if (valueOf.length() != 0) {
                        "Dynamic lookup for intent failed for action: ".concat(valueOf);
                    } else {
                        new String("Dynamic lookup for intent failed for action: ");
                    }
                }
            }
            if (intent == null) {
                return new Intent(this.zzej).setPackage(this.packageName);
            }
            return intent;
        }

        public final int zzq() {
            return this.zzek;
        }

        public zza(String str, String str2, int i2) {
            this(str, str2, ScriptIntrinsicBLAS.RsBlas_ctrmm, false);
        }

        public zza(String str, String str2, int i2, boolean z) {
            this.zzej = Preconditions.checkNotEmpty(str);
            this.packageName = Preconditions.checkNotEmpty(str2);
            this.componentName = null;
            this.zzek = i2;
            this.zzel = z;
        }

        public zza(ComponentName componentName2, int i2) {
            this.zzej = null;
            this.packageName = null;
            this.componentName = (ComponentName) Preconditions.checkNotNull(componentName2);
            this.zzek = ScriptIntrinsicBLAS.RsBlas_ctrmm;
            this.zzel = false;
        }
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzec) {
            if (zzed == null) {
                zzed = new zze(context.getApplicationContext());
            }
        }
        return zzed;
    }

    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str, (int) ScriptIntrinsicBLAS.RsBlas_ctrmm), serviceConnection, str2);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str, (int) ScriptIntrinsicBLAS.RsBlas_ctrmm), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i2, ServiceConnection serviceConnection, String str3, boolean z) {
        zzb(new zza(str, str2, i2, z), serviceConnection, str3);
    }

    public abstract boolean zza(zza zza2, ServiceConnection serviceConnection, String str);

    public abstract void zzb(zza zza2, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName, (int) ScriptIntrinsicBLAS.RsBlas_ctrmm), serviceConnection, str);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName, (int) ScriptIntrinsicBLAS.RsBlas_ctrmm), serviceConnection, str);
    }
}
