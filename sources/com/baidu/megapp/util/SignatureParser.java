package com.baidu.megapp.util;

import android.content.pm.Signature;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class SignatureParser {
    public static final boolean DEBUG = true;
    public static final String TAG = "SignatureParser";
    private static WeakReference<byte[]> mReadBuffer;
    private static Object mSync = new Object();

    private SignatureParser() {
    }

    public static Signature[] collectCertificates(String mArchiveSourcePath) {
        WeakReference<byte[]> readBufferRef;
        byte[] readBuffer = null;
        synchronized (mSync) {
            readBufferRef = mReadBuffer;
            if (readBufferRef != null) {
                mReadBuffer = null;
                readBuffer = (byte[]) readBufferRef.get();
            }
            if (readBuffer == null) {
                readBuffer = new byte[8192];
                readBufferRef = new WeakReference<>(readBuffer);
            }
        }
        JarFile jarFile = null;
        jarFile = new JarFile(mArchiveSourcePath);
        Certificate[] certs = null;
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry je = entries.nextElement();
            if (!je.isDirectory()) {
                if (!je.getName().startsWith("META-INF/")) {
                    Certificate[] localCerts = loadCertificates(jarFile, je, readBuffer);
                    if (localCerts == null) {
                        if (MegUtils.isDebug()) {
                            Log.e("SignatureParser", "Package " + mArchiveSourcePath + " has no certificates at entry " + je.getName() + "; ignoring!");
                        }
                        try {
                            jarFile.close();
                        } catch (IOException e2) {
                            if (MegUtils.isDebug()) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } else if (certs == null) {
                        certs = localCerts;
                    } else {
                        int i2 = 0;
                        while (i2 < certs.length) {
                            try {
                                boolean found = false;
                                int j2 = 0;
                                while (true) {
                                    if (j2 < localCerts.length) {
                                        if (certs[i2] != null && certs[i2].equals(localCerts[j2])) {
                                            found = true;
                                            break;
                                        }
                                        j2++;
                                    } else {
                                        break;
                                    }
                                }
                                if (!found || certs.length != localCerts.length) {
                                    try {
                                        jarFile.close();
                                    } catch (IOException e3) {
                                        if (MegUtils.isDebug()) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    return null;
                                }
                                i2++;
                            } catch (Exception e4) {
                                try {
                                    if (MegUtils.isDebug()) {
                                        Log.w("SignatureParser", "Exception reading " + mArchiveSourcePath, e4);
                                    }
                                    return null;
                                } finally {
                                    if (jarFile != null) {
                                        try {
                                            jarFile.close();
                                        } catch (IOException e5) {
                                            if (MegUtils.isDebug()) {
                                                e5.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        continue;
                    }
                }
            }
        }
        synchronized (mSync) {
            mReadBuffer = readBufferRef;
        }
        if (certs != null) {
            if (certs.length > 0) {
                int N = certs.length;
                Signature[] signatures = new Signature[certs.length];
                for (int i3 = 0; i3 < N; i3++) {
                    signatures[i3] = new Signature(certs[i3].getEncoded());
                }
                try {
                    jarFile.close();
                } catch (IOException e6) {
                    if (MegUtils.isDebug()) {
                        e6.printStackTrace();
                    }
                }
                return signatures;
            }
        }
        if (MegUtils.isDebug()) {
            Log.e("SignatureParser", "Package " + mArchiveSourcePath + " has no certificates; ignoring!");
        }
        try {
            jarFile.close();
        } catch (IOException e7) {
            if (MegUtils.isDebug()) {
                e7.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (com.baidu.megapp.util.MegUtils.isDebug() == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a7, code lost:
        if (com.baidu.megapp.util.MegUtils.isDebug() == false) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.Certificate[] loadCertificates(java.util.jar.JarFile r7, java.util.jar.JarEntry r8, byte[] r9) {
        /*
            java.lang.String r0 = " in "
            java.lang.String r1 = "Exception reading "
            java.lang.String r2 = "SignatureParser"
            r3 = 0
            r4 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0071, RuntimeException -> 0x0035 }
            java.io.InputStream r6 = r7.getInputStream(r8)     // Catch:{ IOException -> 0x0071, RuntimeException -> 0x0035 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0071, RuntimeException -> 0x0035 }
            r3 = r5
        L_0x0012:
            r5 = 0
            int r6 = r9.length     // Catch:{ IOException -> 0x0071, RuntimeException -> 0x0035 }
            int r5 = r3.read(r9, r5, r6)     // Catch:{ IOException -> 0x0071, RuntimeException -> 0x0035 }
            r6 = -1
            if (r5 == r6) goto L_0x001c
            goto L_0x0012
        L_0x001c:
            if (r8 == 0) goto L_0x0022
            java.security.cert.Certificate[] r4 = r8.getCertificates()     // Catch:{ IOException -> 0x0071, RuntimeException -> 0x0035 }
        L_0x0022:
            r3.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0031
        L_0x0027:
            r0 = move-exception
            boolean r1 = com.baidu.megapp.util.MegUtils.isDebug()
            if (r1 == 0) goto L_0x0031
            r0.printStackTrace()
        L_0x0031:
            return r4
        L_0x0032:
            r0 = move-exception
            goto L_0x00ab
        L_0x0035:
            r5 = move-exception
            boolean r6 = com.baidu.megapp.util.MegUtils.isDebug()     // Catch:{ all -> 0x0032 }
            if (r6 == 0) goto L_0x0060
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r6.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r6 = r8.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r7.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0032 }
            android.util.Log.w(r2, r0, r5)     // Catch:{ all -> 0x0032 }
        L_0x0060:
            if (r3 == 0) goto L_0x00aa
            r3.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0065:
            goto L_0x00aa
        L_0x0066:
            r0 = move-exception
            boolean r1 = com.baidu.megapp.util.MegUtils.isDebug()
            if (r1 == 0) goto L_0x0065
        L_0x006d:
            r0.printStackTrace()
            goto L_0x0065
        L_0x0071:
            r5 = move-exception
            boolean r6 = com.baidu.megapp.util.MegUtils.isDebug()     // Catch:{ all -> 0x0032 }
            if (r6 == 0) goto L_0x009c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r6.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r6 = r8.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r7.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0032 }
            android.util.Log.w(r2, r0, r5)     // Catch:{ all -> 0x0032 }
        L_0x009c:
            if (r3 == 0) goto L_0x00aa
            r3.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x0065
        L_0x00a2:
            r0 = move-exception
            boolean r1 = com.baidu.megapp.util.MegUtils.isDebug()
            if (r1 == 0) goto L_0x0065
            goto L_0x006d
        L_0x00aa:
            return r4
        L_0x00ab:
            if (r3 == 0) goto L_0x00bb
            r3.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00bb
        L_0x00b1:
            r1 = move-exception
            boolean r2 = com.baidu.megapp.util.MegUtils.isDebug()
            if (r2 == 0) goto L_0x00bb
            r1.printStackTrace()
        L_0x00bb:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.megapp.util.SignatureParser.loadCertificates(java.util.jar.JarFile, java.util.jar.JarEntry, byte[]):java.security.cert.Certificate[]");
    }
}
