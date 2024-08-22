package fe.fe.th.i;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadState;
import fe.fe.aaa.ad;
import fe.fe.o.de.th;
import fe.fe.th.ad.de;
import fe.fe.th.th.qw;
import fe.fe.th.uk.i;
import fe.fe.th.uk.o;
import fe.fe.th.uk.yj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class uk {
    public static uk ddd;

    /* renamed from: ad  reason: collision with root package name */
    public Context f3109ad;

    /* renamed from: de  reason: collision with root package name */
    public Hashtable f3110de = new Hashtable();

    /* renamed from: fe  reason: collision with root package name */
    public Handler f3111fe = new Handler(Looper.getMainLooper());
    public qw ggg;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f3112i;

    /* renamed from: if  reason: not valid java name */
    public File f94if;

    /* renamed from: o  reason: collision with root package name */
    public Boolean f3113o;

    /* renamed from: pf  reason: collision with root package name */
    public File f3114pf;
    public String ppp;
    public fe.fe.o.rg.de.qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public HashMap f3115rg;

    /* renamed from: switch  reason: not valid java name */
    public Download f95switch;

    /* renamed from: th  reason: collision with root package name */
    public i f3116th;

    /* renamed from: uk  reason: collision with root package name */
    public Thread f3117uk;
    public de vvv;
    public boolean when;
    public th xxx;

    /* renamed from: yj  reason: collision with root package name */
    public ExecutorService f3118yj = Executors.newFixedThreadPool(1, new i("DownloadManagerAsync"));

    public uk(Context context) {
        Boolean bool = Boolean.TRUE;
        this.f3112i = bool;
        this.f3113o = bool;
        this.when = false;
        this.xxx = new ad(this);
        this.f3109ad = context;
        this.f3116th = i.yj(context);
        this.vvv = de.ad(this.f3109ad);
        this.ggg = qw.qw(context);
        fe.fe.o.rg.de.qw qw2 = fe.fe.o.rg.de.i.ad(this.f3109ad).qw();
        this.qw = qw2;
        qw2.yj(this.xxx);
        HashMap hashMap = new HashMap();
        this.f3115rg = hashMap;
        hashMap.put("referer", "https://update.baidu.com");
        try {
            eee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ddd(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        byte[] bArr = new byte[4];
        try {
            new FileInputStream(file).read(bArr);
            return "1F8B0800".equalsIgnoreCase(m217switch(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String ggg(String str, String str2, String str3) {
        String decode;
        int lastIndexOf;
        if (str2 == null || str2.endsWith("/")) {
            str2 = null;
        } else {
            int lastIndexOf2 = str2.lastIndexOf(47) + 1;
            if (lastIndexOf2 > 0) {
                str2 = str2.substring(lastIndexOf2);
            }
        }
        if (str2 == null && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
            str2 = decode.substring(lastIndexOf);
        }
        if (str2 == null) {
            str2 = "downloadfile";
        } else {
            int lastIndexOf3 = str2.lastIndexOf(46);
            if (lastIndexOf3 > 0) {
                str2 = str2.substring(0, lastIndexOf3);
            }
        }
        return str2.replaceAll("[()（）.,：:\\-|^$#_，。：=、/+《》<>*?？‘“”''\"\"]", "_");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ppp(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 46
            java.lang.String r1 = "/"
            if (r7 == 0) goto L_0x0011
            boolean r2 = r7.endsWith(r1)
            if (r2 != 0) goto L_0x0011
            int r2 = r7.lastIndexOf(r0)
            goto L_0x0012
        L_0x0011:
            r2 = -1
        L_0x0012:
            r3 = 0
            java.lang.String r4 = "."
            if (r2 < 0) goto L_0x0043
            int r5 = r7.length()
            int r5 = r5 + -1
            if (r2 >= r5) goto L_0x0043
            int r2 = r2 + 1
            java.lang.String r7 = r7.substring(r2)
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r2 = r2.getMimeTypeFromExtension(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0043
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            goto L_0x0044
        L_0x0043:
            r7 = r3
        L_0x0044:
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r5 = ".bin"
            if (r2 != 0) goto L_0x00a5
            android.webkit.MimeTypeMap r6 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r7 = r6.getExtensionFromMimeType(r8)
            if (r7 == 0) goto L_0x0067
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
        L_0x005e:
            r6.append(r7)
            java.lang.String r7 = r6.toString()
            goto L_0x00d3
        L_0x0067:
            java.lang.String r6 = r8.toLowerCase()
            java.lang.String r0 = "text/"
            boolean r6 = r6.startsWith(r0)
            if (r6 == 0) goto L_0x008b
            java.lang.String r6 = "text/html"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x007e
            java.lang.String r7 = ".html"
            goto L_0x00d3
        L_0x007e:
            java.lang.String r6 = "text/bin"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0088
            r7 = r5
            goto L_0x00d3
        L_0x0088:
            java.lang.String r7 = ".txt"
            goto L_0x00d3
        L_0x008b:
            java.lang.String r6 = r8.toLowerCase()
            java.lang.String r0 = "audio/"
            boolean r6 = r6.startsWith(r0)
            if (r6 == 0) goto L_0x00d3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r7 = 6
            java.lang.String r7 = r8.substring(r7)
            goto L_0x005e
        L_0x00a5:
            java.lang.String r6 = android.net.Uri.decode(r6)
            if (r6 == 0) goto L_0x00c7
            boolean r8 = r6.endsWith(r1)
            if (r8 != 0) goto L_0x00c7
            r8 = 63
            int r8 = r6.indexOf(r8)
            if (r8 >= 0) goto L_0x00c7
            r8 = 47
            int r8 = r6.lastIndexOf(r8)
            int r8 = r8 + 1
            if (r8 <= 0) goto L_0x00c7
            java.lang.String r3 = r6.substring(r8)
        L_0x00c7:
            if (r3 == 0) goto L_0x00d3
            int r6 = r3.lastIndexOf(r0)
            if (r6 <= 0) goto L_0x00d3
            java.lang.String r7 = r3.substring(r6)
        L_0x00d3:
            if (r7 != 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r5 = r7
        L_0x00d7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.i.uk.ppp(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void qqq(Context context, String str) {
        if (str.startsWith(context.getFilesDir().getAbsolutePath())) {
            try {
                context.openFileOutput(new File(str).getName(), 0).close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m217switch(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static synchronized uk xxx(Context context) {
        uk ukVar;
        synchronized (uk.class) {
            if (ddd == null) {
                ddd = new uk(context);
            }
            ukVar = ddd;
        }
        return ukVar;
    }

    public final void a(String str) {
        File file = this.f3114pf;
        if (file != null) {
            file.delete();
        }
        File file2 = this.f94if;
        if (file2 != null) {
            file2.delete();
        }
        Intent intent = new Intent("com.baidu.clientupdate.RSA.STATUS_FAIL");
        intent.putExtra("download", this.f95switch);
        this.f3109ad.sendBroadcast(intent);
        de deVar = this.vvv;
        String i2 = this.ggg.i();
        String rg2 = this.ggg.rg();
        deVar.th(i2, "0", rg2, "a8", "1", (System.currentTimeMillis() / 1000) + "", "", "RSA", str);
    }

    public final void aaa(long j, Download download) {
        fe.fe.aaa.qw.qw("DownloadManager", "notifyStateChange downloadId " + j + " state " + download.getState());
        this.f3111fe.post(new th(this, j, download));
    }

    public void b(boolean z) {
        this.f3112i = Boolean.valueOf(z);
    }

    public void c(boolean z) {
        this.f3113o = Boolean.valueOf(z);
    }

    public long d(Download download, boolean z) {
        this.when = z;
        long fe2 = this.f3116th.fe(download);
        if (fe2 == -1) {
            return fe2;
        }
        download.mId = fe2;
        this.f3110de.put(Long.valueOf(fe2), download);
        tt(new yj(this, download));
        return fe2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long e(com.baidu.clientupdate.download.Download r30) {
        /*
            r29 = this;
            r1 = r29
            r2 = r30
            java.lang.String r0 = ""
            r2.mFailReason = r0
            java.lang.String r3 = r2.mSavedPath
            long r13 = r2.mFileLength
            long r11 = r2.mCurrentLength
            java.lang.String r0 = r2.mFileName
            r4 = 0
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = android.net.Uri.encode(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001e
        L_0x0018:
            r0 = move-exception
            r5 = r0
            r5.printStackTrace()
        L_0x001d:
            r0 = r4
        L_0x001e:
            java.lang.String r5 = r2.mSavedPath
            if (r5 == 0) goto L_0x002e
            java.lang.String r5 = r2.mFileName
            if (r5 == 0) goto L_0x002e
            java.io.File r5 = new java.io.File
            java.lang.String r6 = r2.mSavedPath
            r5.<init>(r6, r0)
            goto L_0x002f
        L_0x002e:
            r5 = r4
        L_0x002f:
            r6 = 0
            if (r5 == 0) goto L_0x003b
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r5 = r4
            goto L_0x004f
        L_0x003b:
            android.content.Context r5 = r1.f3109ad
            long r7 = r2.mFileLength
            long r9 = r2.mCurrentLength
            long r7 = r7 - r9
            r9 = 20971520(0x1400000, double:1.03613076E-316)
            long r7 = r7 + r9
            java.lang.String r9 = r2.mSavedPath
            java.io.File r5 = fe.fe.th.uk.ad.ad(r5, r7, r9)
            if (r5 != 0) goto L_0x004f
            r6 = 1
        L_0x004f:
            if (r5 == 0) goto L_0x0195
            r7 = 0
            int r9 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0195
            java.lang.String r3 = r5.getPath()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r8 = java.io.File.separator
            r7.append(r8)
            java.lang.String r8 = r2.mUrl
            java.lang.String r9 = r2.mMimeType
            java.lang.String r8 = ggg(r8, r0, r9)
            r7.append(r8)
            java.lang.String r8 = r2.mUrl
            java.lang.String r9 = r2.mMimeType
            java.lang.String r8 = ppp(r8, r0, r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r2.mUrl
            java.lang.String r10 = r2.mMimeType
            java.lang.String r9 = ggg(r9, r0, r10)
            r8.append(r9)
            java.lang.String r9 = r2.mUrl
            java.lang.String r10 = r2.mMimeType
            java.lang.String r0 = ppp(r9, r0, r10)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.io.File r8 = new java.io.File
            r8.<init>(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "file path is >>>>>>"
            r7.append(r9)
            java.lang.String r9 = r8.getAbsolutePath()
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.lang.String r9 = "DownloadManager"
            fe.fe.aaa.qw.ad(r9, r7)
            boolean r7 = r8.exists()
            if (r7 == 0) goto L_0x0192
            java.lang.String r7 = r2.mMimeType     // Catch:{ IOException -> 0x0189 }
            java.lang.String r10 = "patch"
            boolean r7 = r7.equals(r10)     // Catch:{ IOException -> 0x0189 }
            r10 = 100
            if (r7 == 0) goto L_0x0107
            long r15 = r8.length()     // Catch:{ IOException -> 0x0189 }
            java.lang.String r0 = java.lang.String.valueOf(r15)     // Catch:{ IOException -> 0x0189 }
            java.lang.String r4 = r8.getParent()     // Catch:{ IOException -> 0x0189 }
            r2.mSavedPath = r4     // Catch:{ IOException -> 0x0189 }
            android.content.Context r4 = r1.f3109ad     // Catch:{ IOException -> 0x0189 }
            fe.fe.th.uk.qw r4 = fe.fe.th.uk.qw.ad(r4)     // Catch:{ IOException -> 0x0189 }
            com.baidu.clientupdate.appinfo.ClientUpdateInfo r4 = r4.qw()     // Catch:{ IOException -> 0x0189 }
            java.lang.String r4 = r4.mPatchSize     // Catch:{ IOException -> 0x0189 }
            boolean r0 = r0.equals(r4)     // Catch:{ IOException -> 0x0189 }
            r7 = r3
            if (r0 == 0) goto L_0x0102
            long r3 = r2.mId     // Catch:{ IOException -> 0x0187 }
            r1.mmm(r3, r10)     // Catch:{ IOException -> 0x0187 }
            com.baidu.clientupdate.download.DownloadState r0 = com.baidu.clientupdate.download.DownloadState.FINISH     // Catch:{ IOException -> 0x0187 }
            long r3 = r2.mId     // Catch:{ IOException -> 0x0187 }
            r1.when(r0, r3)     // Catch:{ IOException -> 0x0187 }
            long r2 = r2.mId     // Catch:{ IOException -> 0x0187 }
            return r2
        L_0x0102:
            r8.delete()     // Catch:{ IOException -> 0x0187 }
            goto L_0x0193
        L_0x0107:
            r7 = r3
            java.lang.String r3 = fe.fe.th.uk.yj.qw(r8)     // Catch:{ IOException -> 0x0187 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0187 }
            r15.<init>()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r10 = "apkMd5 is >>> "
            r15.append(r10)     // Catch:{ IOException -> 0x0187 }
            r15.append(r3)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r10 = ", server_mApkMd5 is >>>"
            r15.append(r10)     // Catch:{ IOException -> 0x0187 }
            android.content.Context r10 = r1.f3109ad     // Catch:{ IOException -> 0x0187 }
            fe.fe.th.uk.qw r10 = fe.fe.th.uk.qw.ad(r10)     // Catch:{ IOException -> 0x0187 }
            com.baidu.clientupdate.appinfo.ClientUpdateInfo r10 = r10.qw()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r10 = r10.mApkMd5     // Catch:{ IOException -> 0x0187 }
            r15.append(r10)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r10 = r15.toString()     // Catch:{ IOException -> 0x0187 }
            fe.fe.aaa.qw.ad(r9, r10)     // Catch:{ IOException -> 0x0187 }
            android.content.Context r10 = r1.f3109ad     // Catch:{ IOException -> 0x0187 }
            fe.fe.th.uk.qw r10 = fe.fe.th.uk.qw.ad(r10)     // Catch:{ IOException -> 0x0187 }
            com.baidu.clientupdate.appinfo.ClientUpdateInfo r10 = r10.qw()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r10 = r10.mApkMd5     // Catch:{ IOException -> 0x0187 }
            boolean r3 = r3.equals(r10)     // Catch:{ IOException -> 0x0187 }
            if (r3 == 0) goto L_0x0183
            java.lang.String r3 = r8.getParent()     // Catch:{ IOException -> 0x0187 }
            r2.mSavedPath = r3     // Catch:{ IOException -> 0x0187 }
            if (r0 == 0) goto L_0x0155
            java.lang.String r0 = android.net.Uri.decode(r0)     // Catch:{ IOException -> 0x0187 }
            r2.mFileName = r0     // Catch:{ IOException -> 0x0187 }
            goto L_0x0157
        L_0x0155:
            r2.mFileName = r4     // Catch:{ IOException -> 0x0187 }
        L_0x0157:
            java.util.Hashtable r0 = r1.f3110de     // Catch:{ IOException -> 0x0187 }
            long r3 = r2.mId     // Catch:{ IOException -> 0x0187 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x0187 }
            r0.put(r3, r2)     // Catch:{ IOException -> 0x0187 }
            long r3 = r2.mId     // Catch:{ IOException -> 0x0187 }
            r0 = 100
            r1.mmm(r3, r0)     // Catch:{ IOException -> 0x0187 }
            com.baidu.clientupdate.download.DownloadState r0 = com.baidu.clientupdate.download.DownloadState.FINISH     // Catch:{ IOException -> 0x0187 }
            long r3 = r2.mId     // Catch:{ IOException -> 0x0187 }
            r1.when(r0, r3)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r0 = "startDownload   launchSystemInstalller"
            fe.fe.aaa.qw.ad(r9, r0)     // Catch:{ IOException -> 0x0187 }
            boolean r0 = r1.when     // Catch:{ IOException -> 0x0187 }
            if (r0 != 0) goto L_0x0180
            java.lang.String r0 = r8.getAbsolutePath()     // Catch:{ IOException -> 0x0187 }
            r1.nn(r0, r2)     // Catch:{ IOException -> 0x0187 }
        L_0x0180:
            long r2 = r2.mId     // Catch:{ IOException -> 0x0187 }
            return r2
        L_0x0183:
            r8.delete()     // Catch:{ IOException -> 0x0187 }
            goto L_0x0193
        L_0x0187:
            r0 = move-exception
            goto L_0x018b
        L_0x0189:
            r0 = move-exception
            r7 = r3
        L_0x018b:
            r8.delete()
            r0.printStackTrace()
            goto L_0x0193
        L_0x0192:
            r7 = r3
        L_0x0193:
            r8 = r7
            goto L_0x0196
        L_0x0195:
            r8 = r3
        L_0x0196:
            if (r5 == 0) goto L_0x01e1
            java.lang.String r0 = r5.getPath()
            java.lang.String r3 = r2.mSavedPath
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 != 0) goto L_0x01e1
            java.lang.String r0 = r5.getPath()
            android.content.Context r3 = r1.f3109ad
            fe.fe.aaa.ad r3 = fe.fe.aaa.ad.ad(r3)
            java.lang.String r4 = "lcsdk_xml"
            java.lang.String r5 = "path"
            r3.rg(r4, r5, r0)
            r26 = 0
            r24 = 0
            fe.fe.o.de.ad r3 = new fe.fe.o.de.ad
            java.lang.String r4 = r2.mUrl
            long r5 = r2.mId
            java.lang.String r7 = r2.mFileName
            java.lang.String r8 = r2.mMimeType
            java.lang.Boolean r22 = java.lang.Boolean.TRUE
            java.util.HashMap r9 = r1.f3115rg
            java.lang.String r10 = r2.mETag
            r15 = r3
            r16 = r4
            r17 = r5
            r19 = r0
            r20 = r7
            r21 = r8
            r23 = r9
            r28 = r10
            r15.<init>(r16, r17, r19, r20, r21, r22, r23, r24, r26, r28)
            fe.fe.o.rg.de.qw r0 = r1.qw
            r0.e(r3)
            goto L_0x0227
        L_0x01e1:
            if (r6 == 0) goto L_0x0205
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r0 = "msgId"
            java.lang.String r4 = "5"
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x01f7 }
            java.lang.String r0 = "messageDetail"
            java.lang.String r4 = "not enough free space"
            r3.put(r0, r4)     // Catch:{ JSONException -> 0x01f7 }
            goto L_0x01fb
        L_0x01f7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01fb:
            android.content.Context r0 = r1.f3109ad
            fe.fe.th.qw r0 = fe.fe.th.qw.ddd(r0)
            r0.b(r3)
            goto L_0x0227
        L_0x0205:
            fe.fe.o.de.ad r0 = new fe.fe.o.de.ad
            java.lang.String r5 = r2.mUrl
            long r6 = r2.mId
            java.lang.String r9 = r2.mFileName
            java.lang.String r10 = r2.mMimeType
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            java.util.HashMap r15 = r1.f3115rg
            java.lang.String r4 = r2.mETag
            r17 = r4
            r4 = r0
            r18 = r11
            r11 = r3
            r12 = r15
            r15 = r13
            r13 = r18
            r4.<init>(r5, r6, r8, r9, r10, r11, r12, r13, r15, r17)
            fe.fe.o.rg.de.qw r3 = r1.qw
            r3.e(r0)
        L_0x0227:
            long r2 = r2.mId
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.i.uk.e(com.baidu.clientupdate.download.Download):long");
    }

    public final void eee() {
        Cursor rg2;
        Hashtable hashtable = this.f3110de;
        if ((hashtable == null || hashtable.size() == 0) && (rg2 = this.f3116th.rg()) != null) {
            rg2.moveToFirst();
            while (!rg2.isAfterLast()) {
                Download rrr = rrr(rg2);
                this.f3110de.put(Long.valueOf(rrr.mId), rrr);
                rg2.moveToNext();
            }
            rg2.close();
        }
    }

    public final void mmm(long j, int i2) {
        fe.fe.aaa.qw.qw("DownloadManager", "notifyStateChange downloadId " + j + " progress " + i2);
        this.f3111fe.post(new fe(this, j, i2));
    }

    public void nn(String str, Download download) {
        this.f95switch = download;
        String str2 = this.f3109ad.getApplicationContext().getFilesDir().getAbsolutePath() + "/" + download.mFileName;
        fe.fe.aaa.qw.qw("DownloadManager", "安装包路径：" + str + "   " + download.mFileName);
        StringBuilder sb = new StringBuilder();
        sb.append("复制apk到data/data路径：");
        sb.append(str2);
        fe.fe.aaa.qw.ad("DownloadManager", sb.toString());
        ad.ad(this.f3109ad).rg("lcsdk_xml", "apkName", download.mFileName);
        try {
            FileOutputStream openFileOutput = this.f3109ad.openFileOutput(download.mFileName, 0);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[2048];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                openFileOutput.write(bArr, 0, read);
            }
            openFileOutput.close();
            fileInputStream.close();
            this.f3114pf = new File(str);
            this.f94if = new File(str2);
            new ProcessBuilder(new String[]{"chmod", "755", str2}).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f3113o.booleanValue()) {
            try {
                ClientUpdateInfo qw2 = fe.fe.th.uk.qw.ad(this.f3109ad).qw();
                this.ppp = qw2.mSign;
                ad.ad(this.f3109ad).rg("lcsdk_xml", "apkMD5", qw2.mApkMd5);
                String str3 = qw.qw(this.f3109ad).ad() + "/lcmanage/index.php?r=InterfaceAction&method=pub_key&prodline=" + qw2.mProdline;
                fe.fe.aaa.qw.ad("DownloadManager", "下载公钥url==" + str3);
                String qw3 = yj.qw(this.f94if);
                if (TextUtils.isEmpty(this.ppp) || TextUtils.isEmpty(qw3)) {
                    a("sign=null");
                    return;
                }
                try {
                    fe.fe.aaa.qw.ad("DownloadManager", "RSA验证");
                    fe.fe.aaa.qw.ad("DownloadManager", "返回接口的sign值：" + this.ppp);
                    String str4 = new String(fe.fe.th.fe.ad.ad(fe.fe.th.fe.ad.qw(fe.fe.rg.qw.qw.qw()), fe.fe.th.fe.qw.de(this.ppp)));
                    fe.fe.aaa.qw.ad("DownloadManager", "公钥解密：" + str4);
                    fe.fe.aaa.qw.ad("DownloadManager", "apk的md5值：" + qw3);
                    if (str4.equals(qw3)) {
                        fe.fe.aaa.qw.ad("DownloadManager", "第一次RSA验证通过");
                        this.vvv.th(this.ggg.i(), "0", this.ggg.rg(), "a8", "0", (System.currentTimeMillis() / 1000) + "", "", "RSA", "");
                        o.fe(this.f3109ad, this.f94if);
                    } else if (this.f3112i.booleanValue()) {
                        fe.fe.aaa.qw.ad("DownloadManager", "RSA验证失败，下载公钥重新验证");
                        vvv(str3, qw3);
                    } else {
                        a("");
                    }
                } catch (Exception e2) {
                    fe.fe.aaa.qw.ad("DownloadManager", "RSA异常，下载公钥重新验证");
                    vvv(str3, qw3);
                    fe.fe.aaa.qw.ad("DownloadManager", e2.toString());
                    fe.fe.aaa.qw.ad("DownloadManager", e2.getMessage());
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                a(e3.toString());
            }
        } else {
            try {
                if (yj.qw(this.f94if).equals(fe.fe.th.uk.qw.ad(this.f3109ad).qw().mApkMd5)) {
                    o.fe(this.f3109ad, this.f94if);
                } else {
                    a("");
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final Download rrr(Cursor cursor) {
        Download download = new Download();
        download.mId = cursor.getLong(cursor.getColumnIndex("_id"));
        download.mUrl = cursor.getString(cursor.getColumnIndex("uri"));
        download.mFileName = cursor.getString(cursor.getColumnIndex("_data"));
        download.mSavedPath = cursor.getString(cursor.getColumnIndex("saved_path_for_user"));
        download.mFileLength = cursor.getLong(cursor.getColumnIndex("total_bytes"));
        download.mCurrentLength = cursor.getLong(cursor.getColumnIndex("current_bytes"));
        String encode = Uri.encode(download.mFileName);
        File file = new File(download.mSavedPath + File.separator + encode);
        download.mCurrentLength = file.exists() ? file.length() : 0;
        download.mState = DownloadState.getState(cursor.getInt(cursor.getColumnIndex("status")));
        download.mFailReason = cursor.getString(cursor.getColumnIndex("failreason"));
        download.mMimeType = cursor.getString(cursor.getColumnIndex("mimetype"));
        download.mETag = cursor.getString(cursor.getColumnIndex("etag"));
        download.mSourceKey = cursor.getString(cursor.getColumnIndex("saved_source_key_user"));
        boolean z = false;
        download.mNeedNotification = cursor.getInt(cursor.getColumnIndex("notificationneeded")) == 1;
        if (cursor.getInt(cursor.getColumnIndex("notificationshowed")) == 1) {
            z = true;
        }
        download.mNotificationShowed = z;
        return download;
    }

    public void tt(Runnable runnable) {
        this.f3118yj.submit(runnable);
    }

    public final void vvv(String str, String str2) {
        de deVar = new de(this, str, str2);
        this.f3117uk = deVar;
        deVar.start();
    }

    public final void when(DownloadState downloadState, long j) {
        Download download = (Download) this.f3110de.get(Long.valueOf(j));
        if (download != null) {
            if (downloadState == DownloadState.CANCEL) {
                if (download.d) {
                    try {
                        new File(download.mSavedPath, Uri.encode(download.mFileName)).delete();
                    } catch (Exception e) {
                        fe.fe.aaa.qw.ad("DownloadManager", "delete download file error!!");
                        e.printStackTrace();
                    }
                }
                this.f3110de.remove(Long.valueOf(j));
                fe.fe.aaa.qw.de("DownloadManager", "mDownloadMap remove downloadId: " + j + "  mDownloadMap size: " + this.f3110de.size());
                this.f3116th.qw(j);
            } else if (download.getState() != DownloadState.FINISH) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f3116th.ggg(download);
                long currentTimeMillis2 = System.currentTimeMillis();
                fe.fe.aaa.qw.ad("DownloadManager", "2新的更新数据库用时time:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb = new StringBuilder();
                sb.append("downloadmanger notification :");
                sb.append(download);
                fe.fe.aaa.qw.qw("DownloadManager", sb.toString());
            } else {
                return;
            }
            download.mState = downloadState;
            aaa(j, download);
        }
    }
}
