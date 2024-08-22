package fe.fe.mmm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class j {
    public static final boolean qw = tt.vvv();

    public static String ad() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String de(Context context) {
        return context.getFilesDir() + File.separator + when.f2229ad;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean fe(Context context) {
        ConnectivityManager connectivityManager;
        if (context.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            if (qw) {
                "get network info error! " + Log.getStackTraceString(e);
            }
        }
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String qw(android.content.Context r2) {
        /*
            if (r2 == 0) goto L_0x0016
            android.content.pm.PackageManager r0 = r2.getPackageManager()
            java.lang.String r2 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x0012 }
            r1 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r1)     // Catch:{ NameNotFoundException -> 0x0012 }
            java.lang.String r2 = r2.versionName     // Catch:{ NameNotFoundException -> 0x0012 }
            goto L_0x0017
        L_0x0012:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0016:
            r2 = 0
        L_0x0017:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x001f
            java.lang.String r2 = "unknown"
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.j.qw(android.content.Context):java.lang.String");
    }

    public static String rg(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String th(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return rg(instance.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
