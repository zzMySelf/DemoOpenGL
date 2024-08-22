package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;

@ShowFirstParty
@KeepForSdk
public class GoogleSignatureVerifier {
    public static GoogleSignatureVerifier zzat;
    public final Context mContext;
    public volatile String zzau;

    public GoogleSignatureVerifier(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zzat == null) {
                zzc.zza(context);
                zzat = new GoogleSignatureVerifier(context);
            }
        }
        return zzat;
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        zzd zzd;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzd = zza(packageInfo, zzi.zzaj);
            } else {
                zzd = zza(packageInfo, zzi.zzaj[0]);
            }
            if (zzd != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1 = r1.applicationInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.zzl zzc(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "null pkg"
            if (r8 != 0) goto L_0x0009
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zzb(r0)
            return r8
        L_0x0009:
            java.lang.String r1 = r7.zzau
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zze()
            return r8
        L_0x0016:
            android.content.Context r1 = r7.mContext     // Catch:{ NameNotFoundException -> 0x0078 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch:{ NameNotFoundException -> 0x0078 }
            r2 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r8, r2)     // Catch:{ NameNotFoundException -> 0x0078 }
            android.content.Context r2 = r7.mContext
            boolean r2 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r2)
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzl.zzb(r0)
            goto L_0x0071
        L_0x002f:
            android.content.pm.Signature[] r0 = r1.signatures
            if (r0 == 0) goto L_0x006b
            int r0 = r0.length
            r3 = 1
            if (r0 == r3) goto L_0x0038
            goto L_0x006b
        L_0x0038:
            com.google.android.gms.common.zzg r0 = new com.google.android.gms.common.zzg
            android.content.pm.Signature[] r4 = r1.signatures
            r5 = 0
            r4 = r4[r5]
            byte[] r4 = r4.toByteArray()
            r0.<init>(r4)
            java.lang.String r4 = r1.packageName
            com.google.android.gms.common.zzl r2 = com.google.android.gms.common.zzc.zza(r4, r0, r2, r5)
            boolean r6 = r2.zzap
            if (r6 == 0) goto L_0x0069
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo
            if (r1 == 0) goto L_0x0069
            int r1 = r1.flags
            r1 = r1 & 2
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzc.zza(r4, r0, r5, r3)
            boolean r0 = r0.zzap
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = "debuggable release cert app rejected"
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzl.zzb(r0)
            goto L_0x0071
        L_0x0069:
            r0 = r2
            goto L_0x0071
        L_0x006b:
            java.lang.String r0 = "single cert required"
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzl.zzb(r0)
        L_0x0071:
            boolean r1 = r0.zzap
            if (r1 == 0) goto L_0x0077
            r7.zzau = r8
        L_0x0077:
            return r0
        L_0x0078:
            java.lang.String r0 = "no pkg "
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r1 = r8.length()
            if (r1 == 0) goto L_0x008a
            java.lang.String r8 = r0.concat(r8)
            goto L_0x008f
        L_0x008a:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r0)
        L_0x008f:
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zzb(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzc(java.lang.String):com.google.android.gms.common.zzl");
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        return zza(packageInfo, true) && GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        zzl zzc = zzc(str);
        zzc.zzf();
        return zzc.zzap;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i2) {
        zzl zzl;
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i2);
        if (packagesForUid != null && packagesForUid.length != 0) {
            zzl = null;
            for (String zza : packagesForUid) {
                zzl = zza(zza, i2);
                if (zzl.zzap) {
                    break;
                }
            }
        } else {
            zzl = zzl.zzb("no pkgs");
        }
        zzl.zzf();
        return zzl.zzap;
    }

    private final zzl zza(String str, int i2) {
        try {
            PackageInfo zza = Wrappers.packageManager(this.mContext).zza(str, 64, i2);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
            if (zza == null) {
                return zzl.zzb("null pkg");
            }
            if (zza.signatures != null) {
                if (zza.signatures.length == 1) {
                    zzg zzg = new zzg(zza.signatures[0].toByteArray());
                    String str2 = zza.packageName;
                    zzl zza2 = zzc.zza(str2, zzg, honorsDebugCertificates, false);
                    return (!zza2.zzap || zza.applicationInfo == null || (zza.applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzg, false, true).zzap) ? zza2 : zzl.zzb("debuggable release cert app rejected");
                }
            }
            return zzl.zzb("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzl.zzb(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static zzd zza(PackageInfo packageInfo, zzd... zzdArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < zzdArr.length; i2++) {
            if (zzdArr[i2].equals(zzg)) {
                return zzdArr[i2];
            }
        }
        return null;
    }
}
