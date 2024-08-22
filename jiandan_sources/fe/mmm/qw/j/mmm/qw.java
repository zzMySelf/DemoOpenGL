package fe.mmm.qw.j.mmm;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import fe.mmm.qw.j.ad;
import java.io.File;
import java.util.List;

public class qw extends ad {

    /* renamed from: ad  reason: collision with root package name */
    public List<String> f7969ad;

    public qw(Context context) {
        this.f7969ad = i(context);
    }

    public File fe() {
        String o2 = o();
        if (TextUtils.isEmpty(o2)) {
            return null;
        }
        return new File(o2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c A[SYNTHETIC, Splitter:B:37:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d A[SYNTHETIC, Splitter:B:44:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ad A[SYNTHETIC, Splitter:B:51:0x00ad] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0083=Splitter:B:34:0x0083, B:41:0x0094=Splitter:B:41:0x0094} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> i(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "DeviceStorage"
            java.util.List r7 = r6.pf(r7)
            boolean r1 = fe.mmm.qw.j.ad.ad(r7)
            if (r1 == 0) goto L_0x000d
            return r7
        L_0x000d:
            r7 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x007f, all -> 0x007b }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x007f, all -> 0x007b }
            java.lang.String r4 = "/proc/mounts"
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x007f, all -> 0x007b }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0090, IOException -> 0x007f, all -> 0x007b }
        L_0x001f:
            java.lang.String r7 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r7 == 0) goto L_0x0073
            java.lang.String r3 = "vfat"
            boolean r3 = r7.contains(r3)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r3 != 0) goto L_0x0045
            java.lang.String r3 = "exfat"
            boolean r3 = r7.contains(r3)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r3 != 0) goto L_0x0045
            java.lang.String r3 = "/mnt"
            boolean r3 = r7.contains(r3)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r3 != 0) goto L_0x0045
            java.lang.String r3 = "/storage"
            boolean r3 = r7.contains(r3)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r3 == 0) goto L_0x001f
        L_0x0045:
            java.util.StringTokenizer r3 = new java.util.StringTokenizer     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            java.lang.String r4 = " "
            r3.<init>(r7, r4)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            r3.nextToken()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            java.lang.String r3 = r3.nextToken()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            java.lang.String r4 = r6.de()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            boolean r4 = r3.equals(r4)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r4 == 0) goto L_0x005e
            goto L_0x001f
        L_0x005e:
            boolean r7 = r6.m979switch(r7)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r7 == 0) goto L_0x001f
            java.lang.String r7 = r6.de()     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            boolean r7 = r3.equals(r7)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            if (r7 == 0) goto L_0x006f
            goto L_0x001f
        L_0x006f:
            r1.add(r3)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0077 }
            goto L_0x001f
        L_0x0073:
            r2.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a9
        L_0x0077:
            r7 = move-exception
            goto L_0x0083
        L_0x0079:
            r7 = move-exception
            goto L_0x0094
        L_0x007b:
            r1 = move-exception
            r2 = r7
            r7 = r1
            goto L_0x00ab
        L_0x007f:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
        L_0x0083:
            java.lang.String r3 = r7.getMessage()     // Catch:{ all -> 0x00aa }
            fe.mmm.qw.i.qw.th(r0, r3, r7)     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x00a9
            r2.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a9
        L_0x0090:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
        L_0x0094:
            java.lang.String r3 = r7.getMessage()     // Catch:{ all -> 0x00aa }
            fe.mmm.qw.i.qw.th(r0, r3, r7)     // Catch:{ all -> 0x00aa }
            if (r2 == 0) goto L_0x00a9
            r2.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a9
        L_0x00a1:
            r7 = move-exception
            java.lang.String r2 = r7.getMessage()
            fe.mmm.qw.i.qw.th(r0, r2, r7)
        L_0x00a9:
            return r1
        L_0x00aa:
            r7 = move-exception
        L_0x00ab:
            if (r2 == 0) goto L_0x00b9
            r2.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00b9
        L_0x00b1:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            fe.mmm.qw.i.qw.th(r0, r2, r1)
        L_0x00b9:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.j.mmm.qw.i(android.content.Context):java.util.List");
    }

    @TargetApi(19)
    /* renamed from: if  reason: not valid java name */
    public final boolean m978if(File file) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                str = Environment.getExternalStorageState(file);
            } else {
                str = Environment.getStorageState(file);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.equals("mounted") || str.equals("mounted_ro")) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String o() {
        if (!th()) {
            return null;
        }
        return this.f7969ad.get(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0088 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> pf(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "getVolumePaths "
            java.lang.String r1 = "DeviceStorage"
            java.lang.String r2 = "storage"
            java.lang.Object r8 = r8.getSystemService(r2)
            android.os.storage.StorageManager r8 = (android.os.storage.StorageManager) r8
            r2 = 0
            if (r8 != 0) goto L_0x0010
            return r2
        L_0x0010:
            r3 = 0
            java.lang.Class r4 = r8.getClass()     // Catch:{ IllegalArgumentException -> 0x006e, IllegalAccessException -> 0x0056, InvocationTargetException -> 0x003e, NoSuchMethodException -> 0x0026 }
            java.lang.String r5 = "getVolumePaths"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ IllegalArgumentException -> 0x006e, IllegalAccessException -> 0x0056, InvocationTargetException -> 0x003e, NoSuchMethodException -> 0x0026 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ IllegalArgumentException -> 0x006e, IllegalAccessException -> 0x0056, InvocationTargetException -> 0x003e, NoSuchMethodException -> 0x0026 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ IllegalArgumentException -> 0x006e, IllegalAccessException -> 0x0056, InvocationTargetException -> 0x003e, NoSuchMethodException -> 0x0026 }
            java.lang.Object r8 = r4.invoke(r8, r5)     // Catch:{ IllegalArgumentException -> 0x006e, IllegalAccessException -> 0x0056, InvocationTargetException -> 0x003e, NoSuchMethodException -> 0x0026 }
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ IllegalArgumentException -> 0x006e, IllegalAccessException -> 0x0056, InvocationTargetException -> 0x003e, NoSuchMethodException -> 0x0026 }
            goto L_0x0086
        L_0x0026:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r8.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            fe.mmm.qw.i.qw.th(r1, r0, r8)
            goto L_0x0085
        L_0x003e:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r8.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            fe.mmm.qw.i.qw.th(r1, r0, r8)
            goto L_0x0085
        L_0x0056:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r8.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            fe.mmm.qw.i.qw.th(r1, r0, r8)
            goto L_0x0085
        L_0x006e:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r8.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            fe.mmm.qw.i.qw.th(r1, r0, r8)
        L_0x0085:
            r8 = r2
        L_0x0086:
            if (r8 != 0) goto L_0x0089
            return r2
        L_0x0089:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r8.length
        L_0x008f:
            if (r3 >= r1) goto L_0x00a4
            r2 = r8[r3]
            java.lang.String r4 = r7.de()
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x009e
            goto L_0x00a1
        L_0x009e:
            r0.add(r2)
        L_0x00a1:
            int r3 = r3 + 1
            goto L_0x008f
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.j.mmm.qw.pf(android.content.Context):java.util.List");
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m979switch(String str) {
        return str.contains("/dev/block/vold") && !str.contains("/mnt/secure") && !str.contains("/mnt/asec") && !str.contains("/mnt/obb") && !str.contains("/dev/mapper") && !str.contains("tmpfs");
    }

    public boolean th() {
        StringBuilder sb = new StringBuilder();
        sb.append("hasSecondaryStorage  ");
        sb.append(!ad.qw(this.f7969ad));
        fe.mmm.qw.i.qw.ad("DeviceStorage", sb.toString());
        return !ad.qw(this.f7969ad);
    }

    public boolean uk() {
        File fe2 = fe();
        if (fe2 == null) {
            fe.mmm.qw.i.qw.ad("DeviceStorage", "isSecondaryStorageAvailable::file == null return false");
            return false;
        } else if (!fe2.exists()) {
            fe.mmm.qw.i.qw.ad("DeviceStorage", "isSecondaryStorageAvailable::!file.exists() return false");
            return false;
        } else if (fe.mmm.qw.j.ggg.qw.ad()) {
            return m978if(fe2);
        } else {
            return fe.mmm.qw.j.xxx.ad.ggg(fe2);
        }
    }
}
