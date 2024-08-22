package fe.fe.ddd.ddd.de.de;

import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ad {
    public static final boolean qw = AppConfig.rg();

    public static void ad(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (file2.isDirectory()) {
                        ad(file2);
                    }
                }
            }
            file.delete();
        }
    }

    public static void de(File file, List<String> list) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    list.add(file2.getAbsolutePath());
                } else {
                    de(file2, list);
                }
            }
        }
    }

    public static boolean fe(File file, String str) {
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            de(file, arrayList);
            if (arrayList.size() == 0) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            for (String str2 : arrayList) {
                if (qw) {
                    "Zipping " + str2;
                }
                zipOutputStream.putNextEntry(new ZipEntry(str2.substring(file.getAbsolutePath().length() + 1, str2.length())));
                FileInputStream fileInputStream = new FileInputStream(str2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                fileInputStream.close();
            }
            zipOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            if (qw) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[Catch:{ IOException -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[Catch:{ IOException -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean qw(java.io.File r9, java.io.File r10) {
        /*
            java.io.File r0 = r10.getParentFile()     // Catch:{ IOException -> 0x0056 }
            boolean r0 = r0.exists()     // Catch:{ IOException -> 0x0056 }
            if (r0 != 0) goto L_0x0011
            java.io.File r0 = r10.getParentFile()     // Catch:{ IOException -> 0x0056 }
            r0.mkdirs()     // Catch:{ IOException -> 0x0056 }
        L_0x0011:
            boolean r0 = r10.exists()     // Catch:{ IOException -> 0x0056 }
            if (r0 != 0) goto L_0x001a
            r10.createNewFile()     // Catch:{ IOException -> 0x0056 }
        L_0x001a:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0049 }
            r1.<init>(r9)     // Catch:{ all -> 0x0049 }
            java.nio.channels.FileChannel r9 = r1.getChannel()     // Catch:{ all -> 0x0049 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0044 }
            r1.<init>(r10)     // Catch:{ all -> 0x0044 }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x0044 }
            r4 = 0
            long r6 = r9.size()     // Catch:{ all -> 0x0044 }
            r2 = r0
            r3 = r9
            r2.transferFrom(r3, r4, r6)     // Catch:{ all -> 0x0044 }
            if (r9 == 0) goto L_0x003d
            r9.close()     // Catch:{ IOException -> 0x0056 }
        L_0x003d:
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0042:
            r9 = 1
            return r9
        L_0x0044:
            r10 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x004b
        L_0x0049:
            r10 = move-exception
            r9 = r0
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0050:
            if (r9 == 0) goto L_0x0055
            r9.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0055:
            throw r10     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            r9 = move-exception
            boolean r10 = qw
            if (r10 == 0) goto L_0x005e
            r9.printStackTrace()
        L_0x005e:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.ddd.de.de.ad.qw(java.io.File, java.io.File):boolean");
    }
}
