package fe.th.qw.qw.qw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.baidu.apollon.heartbeat.a;
import com.duxiaoman.dxmpay.statistics.StatApi;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class qw {
    public static String ad(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            byte[] bArr = m364if(context, str);
            if (bArr != null) {
                return new String(bArr, a.h);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String de(boolean z, Context context, String str) {
        if (context == null) {
            return null;
        }
        if (z) {
            return when(context, str);
        }
        return ad(context, str);
    }

    public static String fe(byte[] bArr, String str, boolean z) {
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

    public static boolean i(Context context, boolean z, String str) {
        if (context == null) {
            return false;
        }
        if (!z) {
            return context.getFileStreamPath(str).exists();
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState) && !"mounted_ro".equals(externalStorageState)) {
            return false;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!new File(externalStorageDirectory + File.separator + "c82c403505338808201aad86f8194734" + File.separator + context.getPackageName() + File.separator + str).exists()) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0027, code lost:
        if (r0 != 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002b, code lost:
        if (r0 == 0) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002d, code lost:
        r1 = r0;
        r0 = r2;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022 A[SYNTHETIC, Splitter:B:15:0x0022] */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m364if(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x002a, IOException -> 0x0026, all -> 0x001f }
            if (r2 == 0) goto L_0x001c
            int r3 = r2.available()     // Catch:{ FileNotFoundException -> 0x0018, IOException -> 0x0014, all -> 0x0011 }
            byte[] r0 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x0018, IOException -> 0x0014, all -> 0x0011 }
            r2.read(r0)     // Catch:{ FileNotFoundException -> 0x0018, IOException -> 0x0014, all -> 0x0011 }
            goto L_0x001c
        L_0x0011:
            r3 = move-exception
            r0 = r2
            goto L_0x0020
        L_0x0014:
            r1 = r0
            r0 = r2
            r2 = r1
            goto L_0x0027
        L_0x0018:
            r1 = r0
            r0 = r2
            r2 = r1
            goto L_0x002b
        L_0x001c:
            if (r2 == 0) goto L_0x0035
            goto L_0x0030
        L_0x001f:
            r3 = move-exception
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            r0.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            throw r3
        L_0x0026:
            r2 = r0
        L_0x0027:
            if (r0 == 0) goto L_0x0034
            goto L_0x002d
        L_0x002a:
            r2 = r0
        L_0x002b:
            if (r0 == 0) goto L_0x0034
        L_0x002d:
            r1 = r0
            r0 = r2
            r2 = r1
        L_0x0030:
            r2.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0035
        L_0x0034:
            r0 = r2
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.qw.qw.qw.qw.m364if(android.content.Context, java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088 A[SYNTHETIC, Splitter:B:29:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void o(android.content.Context r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            r0 = 0
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r2.append(r1)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r2.append(r1)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r1 = "c82c403505338808201aad86f8194734"
            r2.append(r1)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r2.append(r1)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r3 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r1.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            if (r2 != 0) goto L_0x004a
            r1.mkdirs()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            r3 = move-exception
            goto L_0x0086
        L_0x004a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r1.append(r3)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r3 = r1.toString()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            boolean r3 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            if (r3 != 0) goto L_0x0067
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
        L_0x0067:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            r3.<init>(r4, r6)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x008c, all -> 0x0048 }
            java.lang.String r4 = "utf-8"
            byte[] r4 = r5.getBytes(r4)     // Catch:{ FileNotFoundException -> 0x0084, IOException -> 0x0082, all -> 0x007e }
            r5 = 2
            byte[] r4 = android.util.Base64.encode(r4, r5)     // Catch:{ FileNotFoundException -> 0x0084, IOException -> 0x0082, all -> 0x007e }
            r3.write(r4)     // Catch:{ FileNotFoundException -> 0x0084, IOException -> 0x0082, all -> 0x007e }
            r3.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x0096
        L_0x007e:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x0086
        L_0x0082:
            r0 = r3
            goto L_0x008d
        L_0x0084:
            r0 = r3
            goto L_0x0091
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{ IOException -> 0x008b }
        L_0x008b:
            throw r3
        L_0x008c:
        L_0x008d:
            if (r0 == 0) goto L_0x0096
            goto L_0x0093
        L_0x0090:
        L_0x0091:
            if (r0 == 0) goto L_0x0096
        L_0x0093:
            r0.close()     // Catch:{ IOException -> 0x0096 }
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.qw.qw.qw.qw.o(android.content.Context, java.lang.String, java.lang.String, boolean):void");
    }

    public static boolean pf(Context context) {
        NetworkInfo networkInfo = m365switch(context);
        if (networkInfo == null || !networkInfo.isConnected() || 1 != networkInfo.getType()) {
            return false;
        }
        return true;
    }

    public static String qw() {
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) StatApi.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            str = activeNetworkInfo.getTypeName();
            return (str.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) ? str : activeNetworkInfo.getSubtypeName();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String rg(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return fe(instance.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static NetworkInfo m365switch(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            StatApi.getInstance();
            StatApi.onEvent("Exception_On_getActiveNetworkInfo" + e.toString());
            return null;
        }
    }

    public static void th(Context context, String str, String str2, boolean z) {
        if (context != null) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
                if (fileOutputStream != null) {
                    fileOutputStream.write(str2.getBytes(a.h));
                }
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Exception unused) {
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th2;
            }
            try {
                fileOutputStream.close();
            } catch (Exception unused3) {
            }
        }
    }

    public static boolean uk(Context context) {
        NetworkInfo networkInfo = m365switch(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f A[SYNTHETIC, Splitter:B:30:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String when(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r1 = r1.equals(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0017
            java.lang.String r1 = "mounted_ro"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0017
            return r2
        L_0x0017:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = java.io.File.separator
            r3.append(r0)
            java.lang.String r0 = "c82c403505338808201aad86f8194734"
            r3.append(r0)
            java.lang.String r0 = java.io.File.separator
            r3.append(r0)
            java.lang.String r5 = r5.getPackageName()
            r3.append(r5)
            java.lang.String r5 = java.io.File.separator
            r3.append(r5)
            r3.append(r6)
            java.lang.String r5 = r3.toString()
            r1.<init>(r5)
            boolean r5 = r1.exists()
            if (r5 != 0) goto L_0x0051
            return r2
        L_0x0051:
            r5 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0087, IllegalArgumentException -> 0x0083, all -> 0x007c }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0087, IllegalArgumentException -> 0x0083, all -> 0x007c }
            int r5 = r6.available()     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0078, IllegalArgumentException -> 0x0076, all -> 0x0071 }
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0078, IllegalArgumentException -> 0x0076, all -> 0x0071 }
            r6.read(r5)     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0078, IllegalArgumentException -> 0x0076, all -> 0x0071 }
            java.lang.String r0 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0078, IllegalArgumentException -> 0x0076, all -> 0x0071 }
            r1 = 2
            byte[] r5 = android.util.Base64.decode(r5, r1)     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0078, IllegalArgumentException -> 0x0076, all -> 0x0071 }
            java.lang.String r1 = "utf-8"
            r0.<init>(r5, r1)     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0078, IllegalArgumentException -> 0x0076, all -> 0x0071 }
            r6.close()     // Catch:{ IOException -> 0x006f }
        L_0x006f:
            r2 = r0
            goto L_0x0091
        L_0x0071:
            r5 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L_0x007d
        L_0x0076:
            r5 = r6
            goto L_0x0084
        L_0x0078:
            r5 = r6
            goto L_0x0088
        L_0x007a:
            r5 = r6
            goto L_0x008c
        L_0x007c:
            r6 = move-exception
        L_0x007d:
            if (r5 == 0) goto L_0x0082
            r5.close()     // Catch:{ IOException -> 0x0082 }
        L_0x0082:
            throw r6
        L_0x0083:
        L_0x0084:
            if (r5 == 0) goto L_0x0091
            goto L_0x008e
        L_0x0087:
        L_0x0088:
            if (r5 == 0) goto L_0x0091
            goto L_0x008e
        L_0x008b:
        L_0x008c:
            if (r5 == 0) goto L_0x0091
        L_0x008e:
            r5.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0091:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.th.qw.qw.qw.qw.when(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void yj(boolean z, Context context, String str, String str2, boolean z2) {
        if (context != null) {
            if (z) {
                o(context, str, str2, z2);
            } else {
                th(context, str, str2, z2);
            }
        }
    }
}
