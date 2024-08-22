package fe.pf.qw;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.baidu.android.util.soloader.SoUtils;
import com.getkeepsafe.relinker.ReLinker;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class qw implements ReLinker.LibraryInstaller {

    /* renamed from: fe.pf.qw.qw$qw  reason: collision with other inner class name */
    public static class C0202qw {

        /* renamed from: ad  reason: collision with root package name */
        public ZipEntry f4641ad;
        public ZipFile qw;

        public C0202qw(ZipFile zipFile, ZipEntry zipEntry) {
            this.qw = zipFile;
            this.f4641ad = zipEntry;
        }
    }

    public final void ad(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final long de(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public final C0202qw fe(Context context, String[] strArr, String str, ad adVar) {
        int i2;
        String[] strArr2 = strArr;
        String[] rg2 = rg(context);
        int length = rg2.length;
        char c = 0;
        ZipFile zipFile = null;
        int i3 = 0;
        while (i3 < length) {
            String str2 = rg2[i3];
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                i2 = 5;
                if (i4 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i4 = i5;
                }
            }
            if (zipFile == null) {
                String str3 = str;
                ad adVar2 = adVar;
            } else {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    if (i6 < i2) {
                        int length2 = strArr2.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            String str4 = SoUtils.PRE + File.separatorChar + strArr2[i8] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c] = str4;
                            objArr[1] = str2;
                            adVar.i("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str4);
                            if (entry != null) {
                                return new C0202qw(zipFile, entry);
                            }
                            i8++;
                            c = 0;
                        }
                        String str5 = str;
                        ad adVar3 = adVar;
                        i6 = i7;
                        i2 = 5;
                    } else {
                        String str6 = str;
                        ad adVar4 = adVar;
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i3++;
            c = 0;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: fe.pf.qw.qw$qw} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a6 A[SYNTHETIC, Splitter:B:70:0x00a6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void qw(android.content.Context r11, java.lang.String[] r12, java.lang.String r13, java.io.File r14, fe.pf.qw.ad r15) {
        /*
            r10 = this;
            r0 = 0
            fe.pf.qw.qw$qw r11 = r10.fe(r11, r12, r13, r15)     // Catch:{ all -> 0x00a3 }
            if (r11 == 0) goto L_0x009a
            r12 = 0
            r1 = 0
        L_0x0009:
            int r2 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x0089
            java.lang.String r1 = "Found %s! Extracting..."
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00a0 }
            r4[r12] = r13     // Catch:{ all -> 0x00a0 }
            r15.i(r1, r4)     // Catch:{ all -> 0x00a0 }
            boolean r1 = r14.exists()     // Catch:{ IOException -> 0x0087 }
            if (r1 != 0) goto L_0x0026
            boolean r1 = r14.createNewFile()     // Catch:{ IOException -> 0x0087 }
            if (r1 != 0) goto L_0x0026
            goto L_0x0087
        L_0x0026:
            java.util.zip.ZipFile r1 = r11.qw     // Catch:{ FileNotFoundException -> 0x0081, IOException -> 0x007b, all -> 0x0072 }
            java.util.zip.ZipEntry r4 = r11.f4641ad     // Catch:{ FileNotFoundException -> 0x0081, IOException -> 0x007b, all -> 0x0072 }
            java.io.InputStream r1 = r1.getInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0081, IOException -> 0x007b, all -> 0x0072 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006e, all -> 0x006a }
            r4.<init>(r14)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006e, all -> 0x006a }
            long r5 = r10.de(r1, r4)     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            java.io.FileDescriptor r7 = r4.getFD()     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            r7.sync()     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            long r7 = r14.length()     // Catch:{ FileNotFoundException -> 0x0083, IOException -> 0x007d, all -> 0x0068 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x004d
            r10.ad(r1)     // Catch:{ all -> 0x00a0 }
        L_0x0049:
            r10.ad(r4)     // Catch:{ all -> 0x00a0 }
            goto L_0x0087
        L_0x004d:
            r10.ad(r1)     // Catch:{ all -> 0x00a0 }
            r10.ad(r4)     // Catch:{ all -> 0x00a0 }
            r14.setReadable(r3, r12)     // Catch:{ all -> 0x00a0 }
            r14.setExecutable(r3, r12)     // Catch:{ all -> 0x00a0 }
            r14.setWritable(r3)     // Catch:{ all -> 0x00a0 }
            if (r11 == 0) goto L_0x0067
            java.util.zip.ZipFile r12 = r11.qw     // Catch:{ IOException -> 0x0067 }
            if (r12 == 0) goto L_0x0067
            java.util.zip.ZipFile r11 = r11.qw     // Catch:{ IOException -> 0x0067 }
            r11.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            return
        L_0x0068:
            r12 = move-exception
            goto L_0x006c
        L_0x006a:
            r12 = move-exception
            r4 = r0
        L_0x006c:
            r0 = r1
            goto L_0x0074
        L_0x006e:
            r4 = r0
            goto L_0x007d
        L_0x0070:
            r4 = r0
            goto L_0x0083
        L_0x0072:
            r12 = move-exception
            r4 = r0
        L_0x0074:
            r10.ad(r0)     // Catch:{ all -> 0x00a0 }
            r10.ad(r4)     // Catch:{ all -> 0x00a0 }
            throw r12     // Catch:{ all -> 0x00a0 }
        L_0x007b:
            r1 = r0
            r4 = r1
        L_0x007d:
            r10.ad(r1)     // Catch:{ all -> 0x00a0 }
            goto L_0x0049
        L_0x0081:
            r1 = r0
            r4 = r1
        L_0x0083:
            r10.ad(r1)     // Catch:{ all -> 0x00a0 }
            goto L_0x0049
        L_0x0087:
            r1 = r2
            goto L_0x0009
        L_0x0089:
            java.lang.String r12 = "FATAL! Couldn't extract the library from the APK!"
            r15.uk(r12)     // Catch:{ all -> 0x00a0 }
            if (r11 == 0) goto L_0x0099
            java.util.zip.ZipFile r12 = r11.qw     // Catch:{ IOException -> 0x0099 }
            if (r12 == 0) goto L_0x0099
            java.util.zip.ZipFile r11 = r11.qw     // Catch:{ IOException -> 0x0099 }
            r11.close()     // Catch:{ IOException -> 0x0099 }
        L_0x0099:
            return
        L_0x009a:
            com.getkeepsafe.relinker.MissingLibraryException r12 = new com.getkeepsafe.relinker.MissingLibraryException     // Catch:{ all -> 0x00a0 }
            r12.<init>(r13)     // Catch:{ all -> 0x00a0 }
            throw r12     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r12 = move-exception
            r0 = r11
            goto L_0x00a4
        L_0x00a3:
            r12 = move-exception
        L_0x00a4:
            if (r0 == 0) goto L_0x00af
            java.util.zip.ZipFile r11 = r0.qw     // Catch:{ IOException -> 0x00af }
            if (r11 == 0) goto L_0x00af
            java.util.zip.ZipFile r11 = r0.qw     // Catch:{ IOException -> 0x00af }
            r11.close()     // Catch:{ IOException -> 0x00af }
        L_0x00af:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.pf.qw.qw.qw(android.content.Context, java.lang.String[], java.lang.String, java.io.File, fe.pf.qw.ad):void");
    }

    public final String[] rg(Context context) {
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
}
