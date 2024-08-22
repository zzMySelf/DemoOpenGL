package com.baidu.searchbox.openwidget.pin.utils;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import androidx.core.content.pm.PackageInfoCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.openwidget.pin.LauncherInfo;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0003\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0003\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0003\u001a\b\u0010\f\u001a\u00020\rH\u0007\u001a \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0001H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DEBUG", "", "TAG", "", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "packageName", "getSignatureHash", "packageInfo", "getSignatureString", "signature", "Landroid/content/pm/Signature;", "resolveLauncherInfo", "Lcom/baidu/searchbox/openwidget/pin/LauncherInfo;", "toHexString", "bytes", "", "separator", "upperCase", "lib-openwidget-ability-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Launchers.kt */
public final class LaunchersKt {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "Launchers";

    public static final LauncherInfo resolveLauncherInfo() {
        LauncherInfo launcherInfo;
        String str;
        LauncherInfo launcherInfo2;
        String str2;
        String str3;
        try {
            Result.Companion companion = Result.Companion;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            boolean z = false;
            ResolveInfo resolved = AppRuntime.getAppContext().getPackageManager().resolveActivity(intent, 0);
            ActivityInfo activityInfo = resolved != null ? resolved.activityInfo : null;
            if (activityInfo == null) {
                launcherInfo = Result.m8971constructorimpl(LauncherInfo.Companion.getEmpty());
                Throwable it = Result.m8974exceptionOrNullimpl(launcherInfo);
                if (it != null && DEBUG) {
                    Log.w(TAG, "get launcher info fail, error=" + it);
                }
                LauncherInfo empty = LauncherInfo.Companion.getEmpty();
                if (Result.m8977isFailureimpl(launcherInfo)) {
                    launcherInfo = empty;
                }
                return (LauncherInfo) launcherInfo;
            }
            Intrinsics.checkNotNullExpressionValue(activityInfo, "resolved?.activityInfo ?…tching LauncherInfo.Empty");
            String packageName = Intrinsics.areEqual((Object) "android", (Object) activityInfo.packageName) ? "" : activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            if (packageName.length() > 0) {
                z = true;
            }
            if (z) {
                PackageInfo packageInfo = getPackageInfo(packageName);
                if (packageInfo != null) {
                    String str4 = activityInfo.targetActivity;
                    if (str4 == null) {
                        str3 = "";
                    } else {
                        str3 = str4;
                    }
                    String str5 = packageInfo.versionName;
                    Intrinsics.checkNotNullExpressionValue(str5, "packageInfo.versionName");
                    launcherInfo2 = new LauncherInfo(packageName, str3, str5, PackageInfoCompat.getLongVersionCode(packageInfo), getSignatureHash(packageInfo));
                } else {
                    String str6 = activityInfo.targetActivity;
                    if (str6 == null) {
                        str2 = "";
                    } else {
                        str2 = str6;
                    }
                    launcherInfo2 = new LauncherInfo(packageName, str2, "", -1, "");
                }
                return launcherInfo2;
            }
            String str7 = activityInfo.targetActivity;
            if (str7 == null) {
                str = "";
            } else {
                str = str7;
            }
            return new LauncherInfo(packageName, str, "", -1, "");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            launcherInfo = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    private static final PackageInfo getPackageInfo(String packageName) {
        PackageManager pm;
        int i2;
        Object obj;
        PackageInfo packageInfo = null;
        if ((packageName.length() == 0) || (pm = AppRuntime.getAppContext().getPackageManager()) == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            i2 = 134217728 | 16448;
        } else {
            i2 = 16448;
        }
        int flags = i2;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(pm.getPackageInfo(packageName, flags));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && DEBUG) {
            Log.w(TAG, "getPackageInfo fail, pkg=" + packageName + ", error=" + it);
        }
        if (!Result.m8977isFailureimpl(obj)) {
            packageInfo = obj;
        }
        return packageInfo;
    }

    private static final String getSignatureHash(PackageInfo packageInfo) {
        Signature[] signatureArr;
        Signature $this$getSignatureHash_u24lambda_u2d6;
        String signatureString;
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo = packageInfo.signingInfo;
            signatureArr = signingInfo != null ? signingInfo.getApkContentsSigners() : null;
        } else {
            signatureArr = packageInfo.signatures;
        }
        return (signatureArr == null || ($this$getSignatureHash_u24lambda_u2d6 = (Signature) ArraysKt.getOrNull((T[]) signatureArr, 0)) == null || (signatureString = getSignatureString($this$getSignatureHash_u24lambda_u2d6)) == null) ? "" : signatureString;
    }

    private static final String getSignatureString(Signature signature) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            digest.reset();
            digest.update(signature.toByteArray());
            byte[] digest2 = digest.digest();
            Intrinsics.checkNotNullExpressionValue(digest2, "digest.digest()");
            obj = Result.m8971constructorimpl(toHexString(digest2, ":", true));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && DEBUG) {
            Log.w(TAG, "get signature string fail, error=" + it);
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    private static final String toHexString(byte[] bytes, String separator, boolean upperCase) {
        StringBuilder hexString = new StringBuilder();
        for (byte b2 : bytes) {
            String str = Integer.toHexString(b2 & UByte.MAX_VALUE);
            if (upperCase) {
                Intrinsics.checkNotNullExpressionValue(str, "str");
                String upperCase2 = str.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                str = upperCase2;
            }
            if (str.length() == 1) {
                hexString.append("0");
            }
            hexString.append(str).append(separator);
        }
        String sb = hexString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "hexString.toString()");
        return sb;
    }
}
