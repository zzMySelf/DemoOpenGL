package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.common.base.Ascii;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;

public class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    public static class C0262a {
        public String a;
        public String b;
        public String c;
        public long d;
        public Bundle e;
    }

    public static int a(Bundle bundle, String str, int i2) {
        if (bundle == null) {
            return i2;
        }
        try {
            return bundle.getInt(str, i2);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i2;
        }
    }

    public static Object a(int i2, String str) {
        switch (i2) {
            case 1:
                return Integer.valueOf(str);
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                try {
                    return Double.valueOf(str);
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                    return null;
                }
            default:
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0262a aVar) {
        String str;
        if (context == null || aVar == null) {
            str = "send fail, invalid argument";
        } else if (b.b(aVar.b)) {
            str = "send fail, action is null";
        } else {
            String str2 = null;
            if (!b.b(aVar.a)) {
                str2 = aVar.a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.b);
            Bundle bundle = aVar.e;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.c);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.d);
            intent.putExtra(ConstantsAPI.CHECK_SUM, a(aVar.c, (int) Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str2);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:40|41|(2:42|(1:44)(1:153))|45|46|47|48|49|(2:50|51)|52) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0119 A[SYNTHETIC, Splitter:B:105:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0120 A[SYNTHETIC, Splitter:B:109:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0127 A[SYNTHETIC, Splitter:B:113:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0148 A[SYNTHETIC, Splitter:B:123:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x014f A[SYNTHETIC, Splitter:B:127:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0156 A[SYNTHETIC, Splitter:B:131:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0160 A[SYNTHETIC, Splitter:B:139:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0167 A[SYNTHETIC, Splitter:B:143:0x0167] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x016e A[SYNTHETIC, Splitter:B:147:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ea A[SYNTHETIC, Splitter:B:87:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f1 A[SYNTHETIC, Splitter:B:91:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00f8 A[SYNTHETIC, Splitter:B:95:0x00f8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:120:0x0130=Splitter:B:120:0x0130, B:102:0x0101=Splitter:B:102:0x0101, B:84:0x00d2=Splitter:B:84:0x00d2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r8, int r9) {
        /*
            java.lang.String r0 = "httpGet ex:"
            java.lang.String r1 = "MicroMsg.SDK.NetUtil"
            r2 = 0
            if (r8 == 0) goto L_0x0172
            int r3 = r8.length()
            if (r3 != 0) goto L_0x000f
            goto L_0x0172
        L_0x000f:
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x012b, IOException -> 0x00fc, Exception -> 0x00cd, all -> 0x00c4 }
            r3.<init>(r8)     // Catch:{ MalformedURLException -> 0x012b, IOException -> 0x00fc, Exception -> 0x00cd, all -> 0x00c4 }
            java.net.URLConnection r8 = r3.openConnection()     // Catch:{ MalformedURLException -> 0x012b, IOException -> 0x00fc, Exception -> 0x00cd, all -> 0x00c4 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ MalformedURLException -> 0x012b, IOException -> 0x00fc, Exception -> 0x00cd, all -> 0x00c4 }
            if (r8 != 0) goto L_0x002f
            java.lang.String r9 = "open connection failed."
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ MalformedURLException -> 0x002d, IOException -> 0x002b, Exception -> 0x0029, all -> 0x0027 }
            if (r8 == 0) goto L_0x0026
            r8.disconnect()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            return r2
        L_0x0027:
            r9 = move-exception
            goto L_0x004b
        L_0x0029:
            r9 = move-exception
            goto L_0x004e
        L_0x002b:
            r9 = move-exception
            goto L_0x0052
        L_0x002d:
            r9 = move-exception
            goto L_0x0056
        L_0x002f:
            java.lang.String r3 = "GET"
            r8.setRequestMethod(r3)     // Catch:{ MalformedURLException -> 0x00c0, IOException -> 0x00bd, Exception -> 0x00ba, all -> 0x00b7 }
            r8.setConnectTimeout(r9)     // Catch:{ MalformedURLException -> 0x00c0, IOException -> 0x00bd, Exception -> 0x00ba, all -> 0x00b7 }
            r8.setReadTimeout(r9)     // Catch:{ MalformedURLException -> 0x00c0, IOException -> 0x00bd, Exception -> 0x00ba, all -> 0x00b7 }
            int r9 = r8.getResponseCode()     // Catch:{ MalformedURLException -> 0x00c0, IOException -> 0x00bd, Exception -> 0x00ba, all -> 0x00b7 }
            r3 = 300(0x12c, float:4.2E-43)
            if (r9 < r3) goto L_0x005a
            java.lang.String r9 = "httpURLConnectionGet 300"
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ MalformedURLException -> 0x002d, IOException -> 0x002b, Exception -> 0x0029, all -> 0x0027 }
            r8.disconnect()     // Catch:{ all -> 0x004a }
        L_0x004a:
            return r2
        L_0x004b:
            r0 = r2
            goto L_0x015e
        L_0x004e:
            r3 = r2
            r4 = r3
            goto L_0x00d2
        L_0x0052:
            r3 = r2
            r4 = r3
            goto L_0x0101
        L_0x0056:
            r3 = r2
            r4 = r3
            goto L_0x0130
        L_0x005a:
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ MalformedURLException -> 0x00c0, IOException -> 0x00bd, Exception -> 0x00ba, all -> 0x00b7 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00b1, IOException -> 0x00ab, Exception -> 0x00a6, all -> 0x00a1 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x00b1, IOException -> 0x00ab, Exception -> 0x00a6, all -> 0x00a1 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0093, Exception -> 0x008c, all -> 0x0086 }
        L_0x0067:
            int r5 = r9.read(r4)     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0093, Exception -> 0x008c, all -> 0x0086 }
            r6 = -1
            if (r5 == r6) goto L_0x0073
            r6 = 0
            r3.write(r4, r6, r5)     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0093, Exception -> 0x008c, all -> 0x0086 }
            goto L_0x0067
        L_0x0073:
            byte[] r4 = r3.toByteArray()     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0093, Exception -> 0x008c, all -> 0x0086 }
            java.lang.String r5 = "httpGet end"
            com.tencent.mm.opensdk.utils.Log.d(r1, r5)     // Catch:{ MalformedURLException -> 0x009a, IOException -> 0x0093, Exception -> 0x008c, all -> 0x0086 }
            r8.disconnect()     // Catch:{ all -> 0x007f }
        L_0x007f:
            r9.close()     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r3.close()     // Catch:{ all -> 0x0085 }
        L_0x0085:
            return r4
        L_0x0086:
            r0 = move-exception
            r2 = r3
            r3 = r9
            r9 = r0
            goto L_0x015c
        L_0x008c:
            r4 = move-exception
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r7
            goto L_0x00d2
        L_0x0093:
            r4 = move-exception
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r7
            goto L_0x0101
        L_0x009a:
            r4 = move-exception
            r7 = r3
            r3 = r9
            r9 = r4
            r4 = r7
            goto L_0x0130
        L_0x00a1:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x00c8
        L_0x00a6:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x00d1
        L_0x00ab:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x0100
        L_0x00b1:
            r3 = move-exception
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x012f
        L_0x00b7:
            r9 = move-exception
            r0 = r2
            goto L_0x00c8
        L_0x00ba:
            r9 = move-exception
            r3 = r2
            goto L_0x00d1
        L_0x00bd:
            r9 = move-exception
            r3 = r2
            goto L_0x0100
        L_0x00c0:
            r9 = move-exception
            r3 = r2
            goto L_0x012f
        L_0x00c4:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r0 = r8
        L_0x00c8:
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x015e
        L_0x00cd:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r3 = r8
        L_0x00d1:
            r4 = r2
        L_0x00d2:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r5.<init>()     // Catch:{ all -> 0x015a }
            r5.append(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x015a }
            r5.append(r9)     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x015a }
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x00ef
            r8.disconnect()     // Catch:{ all -> 0x00ee }
            goto L_0x00ef
        L_0x00ee:
        L_0x00ef:
            if (r3 == 0) goto L_0x00f6
            r3.close()     // Catch:{ all -> 0x00f5 }
            goto L_0x00f6
        L_0x00f5:
        L_0x00f6:
            if (r4 == 0) goto L_0x00fb
            r4.close()     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            return r2
        L_0x00fc:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r3 = r8
        L_0x0100:
            r4 = r2
        L_0x0101:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r5.<init>()     // Catch:{ all -> 0x015a }
            r5.append(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x015a }
            r5.append(r9)     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x015a }
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x011e
            r8.disconnect()     // Catch:{ all -> 0x011d }
            goto L_0x011e
        L_0x011d:
        L_0x011e:
            if (r3 == 0) goto L_0x0125
            r3.close()     // Catch:{ all -> 0x0124 }
            goto L_0x0125
        L_0x0124:
        L_0x0125:
            if (r4 == 0) goto L_0x012a
            r4.close()     // Catch:{ all -> 0x012a }
        L_0x012a:
            return r2
        L_0x012b:
            r8 = move-exception
            r9 = r8
            r8 = r2
            r3 = r8
        L_0x012f:
            r4 = r2
        L_0x0130:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015a }
            r5.<init>()     // Catch:{ all -> 0x015a }
            r5.append(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x015a }
            r5.append(r9)     // Catch:{ all -> 0x015a }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x015a }
            com.tencent.mm.opensdk.utils.Log.e(r1, r9)     // Catch:{ all -> 0x015a }
            if (r8 == 0) goto L_0x014d
            r8.disconnect()     // Catch:{ all -> 0x014c }
            goto L_0x014d
        L_0x014c:
        L_0x014d:
            if (r3 == 0) goto L_0x0154
            r3.close()     // Catch:{ all -> 0x0153 }
            goto L_0x0154
        L_0x0153:
        L_0x0154:
            if (r4 == 0) goto L_0x0159
            r4.close()     // Catch:{ all -> 0x0159 }
        L_0x0159:
            return r2
        L_0x015a:
            r9 = move-exception
            r2 = r4
        L_0x015c:
            r0 = r2
            r2 = r3
        L_0x015e:
            if (r8 == 0) goto L_0x0165
            r8.disconnect()     // Catch:{ all -> 0x0164 }
            goto L_0x0165
        L_0x0164:
        L_0x0165:
            if (r2 == 0) goto L_0x016c
            r2.close()     // Catch:{ all -> 0x016b }
            goto L_0x016c
        L_0x016b:
        L_0x016c:
            if (r0 == 0) goto L_0x0171
            r0.close()     // Catch:{ all -> 0x0171 }
        L_0x0171:
            throw r9
        L_0x0172:
            java.lang.String r8 = "httpGet, url is null"
            com.tencent.mm.opensdk.utils.Log.e(r1, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.channel.a.a.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(String str, int i2, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            char[] cArr2 = new char[(r8 * 2)];
            int i3 = 0;
            for (byte b : instance.digest()) {
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b >>> 4) & 15];
                i3 = i4 + 1;
                cArr2[i4] = cArr[b & Ascii.SI];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
