package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class PackageManagerWrapper {
    public final Context zzil;

    public PackageManagerWrapper(Context context) {
        this.zzil = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.zzil.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int checkPermission(String str, String str2) {
        return this.zzil.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.zzil.getPackageManager().getApplicationInfo(str, i2);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) throws PackageManager.NameNotFoundException {
        return this.zzil.getPackageManager().getApplicationLabel(this.zzil.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.zzil.getPackageManager().getPackageInfo(str, i2);
    }

    public final String[] getPackagesForUid(int i2) {
        return this.zzil.getPackageManager().getPackagesForUid(i2);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zzil);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = this.zzil.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.zzil.getPackageManager().isInstantApp(nameForUid);
    }

    public final PackageInfo zza(String str, int i2, int i3) throws PackageManager.NameNotFoundException {
        return this.zzil.getPackageManager().getPackageInfo(str, 64);
    }

    @TargetApi(19)
    public final boolean zzb(int i2, String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                ((AppOpsManager) this.zzil.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.zzil.getPackageManager().getPackagesForUid(i2);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
