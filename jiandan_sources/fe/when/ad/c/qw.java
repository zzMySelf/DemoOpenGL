package fe.when.ad.c;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static HashMap<String, String> f9315ad;
    public static HashMap<String, String> qw;

    static {
        qw = new HashMap<>();
        try {
            qw = de("en", (String) null);
        } catch (Exception unused) {
        }
        if (qw == null) {
            qw = new HashMap<>();
        }
    }

    public static String ad(String str, Object... objArr) {
        String fe2 = fe(str);
        if (objArr != null) {
            int i2 = 1;
            for (Object obj : objArr) {
                if (obj != null) {
                    fe2 = fe2.replace(StringUtil.ARRAY_START + i2 + "}", obj.toString());
                }
                i2++;
            }
        }
        return fe2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00af A[SYNTHETIC, Splitter:B:43:0x00af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> de(java.lang.String r5, java.lang.String r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "com/itextpdf/text/l10n/error/"
            if (r5 == 0) goto L_0x00b3
            java.lang.String r1 = ".lng"
            r2 = 0
            if (r6 == 0) goto L_0x0021
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r3.<init>()     // Catch:{ all -> 0x00ac }
            r3.append(r5)     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ all -> 0x00ac }
            r3.append(r6)     // Catch:{ all -> 0x00ac }
            r3.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ac }
            goto L_0x0030
        L_0x0021:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r3.<init>()     // Catch:{ all -> 0x00ac }
            r3.append(r5)     // Catch:{ all -> 0x00ac }
            r3.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ac }
        L_0x0030:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r4.<init>()     // Catch:{ all -> 0x00ac }
            r4.append(r0)     // Catch:{ all -> 0x00ac }
            r4.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x00ac }
            fe.when.ad.c.qw r4 = new fe.when.ad.c.qw     // Catch:{ all -> 0x00ac }
            r4.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x00ac }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x00ac }
            java.io.InputStream r3 = fe.when.ad.d.pf.ad(r3, r4)     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x005f
            java.util.HashMap r5 = th(r3)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x005b
            r3.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            return r5
        L_0x005c:
            r5 = move-exception
            r2 = r3
            goto L_0x00ad
        L_0x005f:
            if (r6 != 0) goto L_0x0067
            if (r3 == 0) goto L_0x0066
            r3.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            return r2
        L_0x0067:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r6.<init>()     // Catch:{ all -> 0x005c }
            r6.append(r5)     // Catch:{ all -> 0x005c }
            r6.append(r1)     // Catch:{ all -> 0x005c }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x005c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r6.<init>()     // Catch:{ all -> 0x005c }
            r6.append(r0)     // Catch:{ all -> 0x005c }
            r6.append(r5)     // Catch:{ all -> 0x005c }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x005c }
            fe.when.ad.c.qw r6 = new fe.when.ad.c.qw     // Catch:{ all -> 0x005c }
            r6.<init>()     // Catch:{ all -> 0x005c }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x005c }
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ all -> 0x005c }
            java.io.InputStream r5 = fe.when.ad.d.pf.ad(r5, r6)     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x00a6
            java.util.HashMap r6 = th(r5)     // Catch:{ all -> 0x00a2 }
            if (r5 == 0) goto L_0x00a1
            r5.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            return r6
        L_0x00a2:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L_0x00ad
        L_0x00a6:
            if (r5 == 0) goto L_0x00ab
            r5.close()     // Catch:{ Exception -> 0x00ab }
        L_0x00ab:
            return r2
        L_0x00ac:
            r5 = move-exception
        L_0x00ad:
            if (r2 == 0) goto L_0x00b2
            r2.close()     // Catch:{ Exception -> 0x00b2 }
        L_0x00b2:
            throw r5
        L_0x00b3:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "The language cannot be null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.c.qw.de(java.lang.String, java.lang.String):java.util.HashMap");
    }

    public static String fe(String str) {
        return rg(str, true);
    }

    public static String qw(String str, int i2) {
        return ad(str, String.valueOf(i2), null, null, null);
    }

    public static String rg(String str, boolean z) {
        String str2;
        String str3;
        HashMap<String, String> hashMap = f9315ad;
        if (hashMap != null && (str3 = hashMap.get(str)) != null) {
            return str3;
        }
        if (z && (str2 = qw.get(str)) != null) {
            return str2;
        }
        return "No message found for " + str;
    }

    public static HashMap<String, String> th(InputStream inputStream) throws IOException {
        return yj(new InputStreamReader(inputStream, "UTF-8"));
    }

    public static HashMap<String, String> yj(Reader reader) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashMap;
            }
            int indexOf = readLine.indexOf(61);
            if (indexOf >= 0) {
                String trim = readLine.substring(0, indexOf).trim();
                if (!trim.startsWith(Bank.HOT_BANK_LETTER)) {
                    hashMap.put(trim, readLine.substring(indexOf + 1));
                }
            }
        }
    }
}
