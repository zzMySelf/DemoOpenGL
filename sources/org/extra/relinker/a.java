package org.extra.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.extra.relinker.c;

public class a implements c.a {

    /* renamed from: org.extra.relinker.a$a  reason: collision with other inner class name */
    private static class C0033a {

        /* renamed from: a  reason: collision with root package name */
        public ZipFile f2873a;

        /* renamed from: b  reason: collision with root package name */
        public ZipEntry f2874b;

        public C0033a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f2873a = zipFile;
            this.f2874b = zipEntry;
        }
    }

    private String[] a(Context context) {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    private C0033a a(Context context, String[] strArr, String str, d dVar) {
        int i2;
        String[] strArr2 = strArr;
        String[] a2 = a(context);
        int length = a2.length;
        int i3 = 0;
        ZipFile zipFile = null;
        int i4 = 0;
        while (i4 < length) {
            String str2 = a2[i4];
            int i5 = i3;
            while (true) {
                int i6 = i5 + 1;
                i2 = 5;
                if (i5 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException e2) {
                    i5 = i6;
                }
            }
            if (zipFile == null) {
                String str3 = str;
                d dVar2 = dVar;
            } else {
                int i7 = i3;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 < i2) {
                        int length2 = strArr2.length;
                        int i9 = i3;
                        while (i9 < length2) {
                            String str4 = "lib" + File.separatorChar + strArr2[i9] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[i3] = str4;
                            objArr[1] = str2;
                            dVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str4);
                            if (entry != null) {
                                return new C0033a(zipFile, entry);
                            }
                            i9++;
                            i3 = 0;
                        }
                        String str5 = str;
                        d dVar3 = dVar;
                        i7 = i8;
                        i3 = 0;
                        i2 = 5;
                    } else {
                        String str6 = str;
                        d dVar4 = dVar;
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException e3) {
                        }
                    }
                }
            }
            i4++;
            i3 = 0;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: org.extra.relinker.a$a} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ac A[SYNTHETIC, Splitter:B:67:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, java.lang.String[] r11, java.lang.String r12, java.io.File r13, org.extra.relinker.d r14) {
        /*
            r9 = this;
            r0 = 0
            org.extra.relinker.a$a r10 = r9.a(r10, r11, r12, r14)     // Catch:{ all -> 0x00a9 }
            if (r10 == 0) goto L_0x00a0
            r11 = 0
            r1 = r11
        L_0x0009:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x0091
            java.lang.String r1 = "Found %s! Extracting..."
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00a6 }
            r4[r11] = r12     // Catch:{ all -> 0x00a6 }
            r14.a((java.lang.String) r1, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00a6 }
            boolean r1 = r13.exists()     // Catch:{ IOException -> 0x008d }
            if (r1 != 0) goto L_0x0026
            boolean r1 = r13.createNewFile()     // Catch:{ IOException -> 0x008d }
            if (r1 != 0) goto L_0x0026
            goto L_0x008e
        L_0x0026:
            java.util.zip.ZipFile r1 = r10.f2873a     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007c, all -> 0x0073 }
            java.util.zip.ZipEntry r4 = r10.f2874b     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007c, all -> 0x0073 }
            java.io.InputStream r1 = r1.getInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007c, all -> 0x0073 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006f, all -> 0x006d }
            r4.<init>(r13)     // Catch:{ FileNotFoundException -> 0x0071, IOException -> 0x006f, all -> 0x006d }
            long r5 = r9.a(r1, r4)     // Catch:{ FileNotFoundException -> 0x006b, IOException -> 0x0069, all -> 0x0066 }
            java.io.FileDescriptor r7 = r4.getFD()     // Catch:{ FileNotFoundException -> 0x006b, IOException -> 0x0069, all -> 0x0066 }
            r7.sync()     // Catch:{ FileNotFoundException -> 0x006b, IOException -> 0x0069, all -> 0x0066 }
            long r7 = r13.length()     // Catch:{ FileNotFoundException -> 0x006b, IOException -> 0x0069, all -> 0x0066 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x004d
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00a6 }
            goto L_0x008e
        L_0x004d:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00a6 }
            r13.setReadable(r3, r11)     // Catch:{ all -> 0x00a6 }
            r13.setExecutable(r3, r11)     // Catch:{ all -> 0x00a6 }
            r13.setWritable(r3)     // Catch:{ all -> 0x00a6 }
            java.util.zip.ZipFile r10 = r10.f2873a     // Catch:{ IOException -> 0x0064 }
            if (r10 == 0) goto L_0x0065
            r10.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0065
        L_0x0064:
            r10 = move-exception
        L_0x0065:
            return
        L_0x0066:
            r11 = move-exception
            r0 = r4
            goto L_0x0075
        L_0x0069:
            r3 = move-exception
            goto L_0x007f
        L_0x006b:
            r3 = move-exception
            goto L_0x0086
        L_0x006d:
            r11 = move-exception
            goto L_0x0075
        L_0x006f:
            r3 = move-exception
            goto L_0x007e
        L_0x0071:
            r3 = move-exception
            goto L_0x0085
        L_0x0073:
            r11 = move-exception
            r1 = r0
        L_0x0075:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
            r9.a((java.io.Closeable) r0)     // Catch:{ all -> 0x00a6 }
            throw r11     // Catch:{ all -> 0x00a6 }
        L_0x007c:
            r1 = move-exception
            r1 = r0
        L_0x007e:
            r4 = r0
        L_0x007f:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
            goto L_0x0089
        L_0x0083:
            r1 = move-exception
            r1 = r0
        L_0x0085:
            r4 = r0
        L_0x0086:
            r9.a((java.io.Closeable) r1)     // Catch:{ all -> 0x00a6 }
        L_0x0089:
            r9.a((java.io.Closeable) r4)     // Catch:{ all -> 0x00a6 }
            goto L_0x008e
        L_0x008d:
            r1 = move-exception
        L_0x008e:
            r1 = r2
            goto L_0x0009
        L_0x0091:
            java.lang.String r11 = "FATAL! Couldn't extract the library from the APK!"
            r14.a((java.lang.String) r11)     // Catch:{ all -> 0x00a6 }
            java.util.zip.ZipFile r10 = r10.f2873a     // Catch:{ IOException -> 0x009e }
            if (r10 == 0) goto L_0x009f
            r10.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x009f
        L_0x009e:
            r10 = move-exception
        L_0x009f:
            return
        L_0x00a0:
            org.extra.relinker.b r11 = new org.extra.relinker.b     // Catch:{ all -> 0x00a6 }
            r11.<init>(r12)     // Catch:{ all -> 0x00a6 }
            throw r11     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r11 = move-exception
            r0 = r10
            goto L_0x00aa
        L_0x00a9:
            r11 = move-exception
        L_0x00aa:
            if (r0 == 0) goto L_0x00b5
            java.util.zip.ZipFile r10 = r0.f2873a     // Catch:{ IOException -> 0x00b4 }
            if (r10 == 0) goto L_0x00b5
            r10.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00b5
        L_0x00b4:
            r10 = move-exception
        L_0x00b5:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.extra.relinker.a.a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, org.extra.relinker.d):void");
    }

    private long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }
}
