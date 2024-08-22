package fe.fe.nn.ppp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public final class pf {
    public static String qw;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ad(android.content.pm.PackageInfo r2, java.lang.String r3) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0019
            android.content.pm.Signature[] r2 = r2.signatures
            if (r2 == 0) goto L_0x0019
            int r1 = r2.length
            if (r1 <= 0) goto L_0x0019
            r1 = r2[r0]
            if (r1 == 0) goto L_0x0019
            r2 = r2[r0]     // Catch:{ all -> 0x0015 }
            java.security.PublicKey r2 = de(r2)     // Catch:{ all -> 0x0015 }
            goto L_0x001a
        L_0x0015:
            r2 = move-exception
            fe.fe.nn.ppp.de.fe(r2)
        L_0x0019:
            r2 = 0
        L_0x001a:
            if (r2 != 0) goto L_0x0020
            java.security.PublicKey r2 = fe(r3)
        L_0x0020:
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x003e
            byte[] r2 = r2.getEncoded()
            if (r2 == 0) goto L_0x003e
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r0)
            java.lang.String r0 = "\n"
            java.lang.String r2 = r2.replace(r0, r3)
            java.lang.String r0 = "\r"
            java.lang.String r2 = r2.replace(r0, r3)
            java.lang.String r3 = fe.fe.nn.ppp.uk.ad(r2)
        L_0x003e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.ppp.pf.ad(android.content.pm.PackageInfo, java.lang.String):java.lang.String");
    }

    public static PublicKey de(Signature signature) {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = instance.generateCertificate(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
        } catch (Throwable th2) {
            de.fe(th2);
        }
        return generateCertificate.getPublicKey();
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x009e A[SYNTHETIC, Splitter:B:73:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.PublicKey fe(java.lang.String r10) {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0008
            return r0
        L_0x0008:
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x00a7 }
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ all -> 0x009a }
            r2.<init>(r10)     // Catch:{ all -> 0x009a }
            java.util.Enumeration r10 = r2.entries()     // Catch:{ all -> 0x0098 }
            r3 = r0
        L_0x0016:
            boolean r4 = r10.hasMoreElements()     // Catch:{ all -> 0x0098 }
            r5 = 0
            if (r4 == 0) goto L_0x0083
            java.lang.Object r4 = r10.nextElement()     // Catch:{ all -> 0x0098 }
            java.util.jar.JarEntry r4 = (java.util.jar.JarEntry) r4     // Catch:{ all -> 0x0098 }
            boolean r6 = r4.isDirectory()     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x002a
            goto L_0x0016
        L_0x002a:
            java.lang.String r6 = r4.getName()     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = "META-INF/"
            boolean r6 = r6.startsWith(r7)     // Catch:{ all -> 0x0098 }
            if (r6 == 0) goto L_0x0037
            goto L_0x0016
        L_0x0037:
            java.security.cert.Certificate[] r4 = rg(r2, r4, r1)     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x0077
            int r6 = r4.length     // Catch:{ all -> 0x0098 }
            if (r6 > 0) goto L_0x0041
            goto L_0x0077
        L_0x0041:
            if (r3 != 0) goto L_0x0045
            r3 = r4
            goto L_0x0016
        L_0x0045:
            r6 = 0
        L_0x0046:
            int r7 = r3.length     // Catch:{ all -> 0x0098 }
            if (r6 >= r7) goto L_0x0016
            r7 = 0
        L_0x004a:
            int r8 = r4.length     // Catch:{ all -> 0x0098 }
            if (r7 >= r8) goto L_0x0060
            r8 = r3[r6]     // Catch:{ all -> 0x0098 }
            if (r8 == 0) goto L_0x005d
            r8 = r3[r6]     // Catch:{ all -> 0x0098 }
            r9 = r4[r7]     // Catch:{ all -> 0x0098 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0098 }
            if (r8 == 0) goto L_0x005d
            r7 = 1
            goto L_0x0061
        L_0x005d:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0060:
            r7 = 0
        L_0x0061:
            if (r7 == 0) goto L_0x006b
            int r7 = r3.length     // Catch:{ all -> 0x0098 }
            int r8 = r4.length     // Catch:{ all -> 0x0098 }
            if (r7 == r8) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            int r6 = r6 + 1
            goto L_0x0046
        L_0x006b:
            r2.close()     // Catch:{ all -> 0x0098 }
            r2.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r10 = move-exception
            fe.fe.nn.ppp.de.fe(r10)     // Catch:{ all -> 0x00a7 }
        L_0x0076:
            return r0
        L_0x0077:
            r2.close()     // Catch:{ all -> 0x0098 }
            r2.close()     // Catch:{ all -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r10 = move-exception
            fe.fe.nn.ppp.de.fe(r10)     // Catch:{ all -> 0x00a7 }
        L_0x0082:
            return r0
        L_0x0083:
            r2.close()     // Catch:{ all -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r10 = move-exception
            fe.fe.nn.ppp.de.fe(r10)     // Catch:{ all -> 0x00a7 }
        L_0x008b:
            if (r3 == 0) goto L_0x0097
            int r10 = r3.length     // Catch:{ all -> 0x00a7 }
            if (r10 <= 0) goto L_0x0097
            r10 = r3[r5]     // Catch:{ all -> 0x00a7 }
            java.security.PublicKey r10 = r10.getPublicKey()     // Catch:{ all -> 0x00a7 }
            return r10
        L_0x0097:
            return r0
        L_0x0098:
            r10 = move-exception
            goto L_0x009c
        L_0x009a:
            r10 = move-exception
            r2 = r0
        L_0x009c:
            if (r2 == 0) goto L_0x00a6
            r2.close()     // Catch:{ all -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r1 = move-exception
            fe.fe.nn.ppp.de.fe(r1)     // Catch:{ all -> 0x00a7 }
        L_0x00a6:
            throw r10     // Catch:{ all -> 0x00a7 }
        L_0x00a7:
            r10 = move-exception
            fe.fe.nn.ppp.de.fe(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.ppp.pf.fe(java.lang.String):java.security.PublicKey");
    }

    public static String qw(Context context) {
        try {
            if (!TextUtils.isEmpty(qw)) {
                return qw;
            }
            PackageInfo packageInfo = null;
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            qw = ad(packageInfo, packageInfo.applicationInfo.sourceDir);
            return qw;
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e A[SYNTHETIC, Splitter:B:21:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.Certificate[] rg(java.util.jar.JarFile r3, java.util.jar.JarEntry r4, byte[] r5) {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0027 }
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch:{ all -> 0x0027 }
            r1.<init>(r3)     // Catch:{ all -> 0x0027 }
        L_0x000a:
            int r3 = r5.length     // Catch:{ all -> 0x0025 }
            int r3 = r1.read(r5, r0, r3)     // Catch:{ all -> 0x0025 }
            r2 = -1
            if (r3 == r2) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            if (r4 == 0) goto L_0x001a
            java.security.cert.Certificate[] r3 = r4.getCertificates()     // Catch:{ all -> 0x0025 }
            goto L_0x001c
        L_0x001a:
            java.security.cert.Certificate[] r3 = new java.security.cert.Certificate[r0]     // Catch:{ all -> 0x0025 }
        L_0x001c:
            r1.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r4 = move-exception
            fe.fe.nn.ppp.de.fe(r4)
        L_0x0024:
            return r3
        L_0x0025:
            r3 = move-exception
            goto L_0x0029
        L_0x0027:
            r3 = move-exception
            r1 = 0
        L_0x0029:
            fe.fe.nn.ppp.de.fe(r3)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0036
            r1.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r3 = move-exception
            fe.fe.nn.ppp.de.fe(r3)
        L_0x0036:
            java.security.cert.Certificate[] r3 = new java.security.cert.Certificate[r0]
            return r3
        L_0x0039:
            r3 = move-exception
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r4 = move-exception
            fe.fe.nn.ppp.de.fe(r4)
        L_0x0044:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.ppp.pf.rg(java.util.jar.JarFile, java.util.jar.JarEntry, byte[]):java.security.cert.Certificate[]");
    }
}
