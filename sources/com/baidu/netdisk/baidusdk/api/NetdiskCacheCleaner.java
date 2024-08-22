package com.baidu.netdisk.baidusdk.api;

import android.content.Context;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/netdisk/baidusdk/api/NetdiskCacheCleaner;", "", "()V", "PREVIEW_FILE_VALID_TIME", "", "TAG", "", "autoClearCache", "", "context", "Landroid/content/Context;", "clearNetdiskCache", "clearPreviewCache", "", "file", "Ljava/io/File;", "deleteFile", "getManualClearCacheSize", "getTotalSizeByPath", "path", "manualClearCache", "baidusdk_external_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaiduSdkInterface.kt */
public final class NetdiskCacheCleaner {
    public static final NetdiskCacheCleaner INSTANCE = new NetdiskCacheCleaner();
    private static final long PREVIEW_FILE_VALID_TIME = 86400000;
    private static final String TAG = "NetdiskCacheCleaner";

    private NetdiskCacheCleaner() {
    }

    public final long getManualClearCacheSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File filesDir = context.getFilesDir();
            return 0 + getTotalSizeByPath(filesDir.getAbsolutePath() + "/resend") + getTotalSizeByPath(filesDir.getAbsolutePath() + "/ad_video_caches");
        } catch (Exception e2) {
            return 0;
        }
    }

    public final boolean manualClearCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File filesDir = context.getFilesDir();
            deleteFile(new File(filesDir, "/resend"));
            deleteFile(new File(filesDir, "/ad_video_caches"));
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public final boolean autoClearCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            deleteFile(new File(context.getCacheDir().getAbsolutePath() + "/safety"));
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return true;
            }
            INSTANCE.clearPreviewCache(new File(externalCacheDir.getAbsolutePath() + "/preview/BaiduNetdisk"));
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public final boolean clearNetdiskCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File filesDir = context.getFilesDir();
            deleteFile(new File(filesDir, "/p2psdk"));
            deleteFile(new File(filesDir, "/p2psdk_so"));
            deleteFile(new File(filesDir, "/resend"));
            deleteFile(new File(filesDir, "/ad_video_caches"));
            File cacheDir = context.getCacheDir();
            deleteFile(new File(cacheDir.getAbsolutePath() + "/skin"));
            deleteFile(new File(cacheDir.getAbsolutePath() + "/safety"));
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                File it = externalCacheDir;
                NetdiskCacheCleaner netdiskCacheCleaner = INSTANCE;
                netdiskCacheCleaner.deleteFile(new File(it.getAbsolutePath() + "/skin"));
                netdiskCacheCleaner.deleteFile(new File(it.getAbsolutePath() + "/preview/BaiduNetdisk"));
                netdiskCacheCleaner.deleteFile(new File(it.getAbsolutePath() + "/dynamic_plugin_temp"));
            }
            return true;
        } catch (Exception e2) {
            return true;
        }
    }

    private final long getTotalSizeByPath(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            return file.length();
        }
        long totalSize = 0;
        List list = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        File[] fileArr = listFiles;
        int length = ((Object[]) fileArr).length;
        for (int i2 = 0; i2 < length; i2++) {
            File it = fileArr[i2];
            if (it != null) {
                if (it.isDirectory()) {
                    list.add(it);
                } else {
                    totalSize += it.length();
                }
            }
        }
        while (!list.isEmpty()) {
            Object tmp = ((LinkedList) list).removeFirst();
            if (((File) tmp) != null) {
                if (((File) tmp).isDirectory()) {
                    File[] it2 = ((File) tmp).listFiles();
                    if (it2 != null) {
                        Intrinsics.checkNotNullExpressionValue(it2, "listFiles()");
                        File[] fileArr2 = it2;
                        int length2 = ((Object[]) fileArr2).length;
                        for (int i3 = 0; i3 < length2; i3++) {
                            File it3 = fileArr2[i3];
                            if (it3 != null) {
                                Intrinsics.checkNotNullExpressionValue(it3, "files[i]");
                                if (it3.isDirectory()) {
                                    list.add(it3);
                                } else {
                                    totalSize += it3.length();
                                }
                            }
                        }
                    }
                } else {
                    totalSize += ((File) tmp).length();
                }
            }
        }
        return totalSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if ((r0.length == 0) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void deleteFile(java.io.File r8) {
        /*
            r7 = this;
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r8.isFile()
            if (r0 != 0) goto L_0x004f
            java.io.File[] r0 = r8.listFiles()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            int r0 = r0.length
            if (r0 != 0) goto L_0x001a
            r0 = r2
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            if (r0 == 0) goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            if (r1 == 0) goto L_0x0021
            goto L_0x004f
        L_0x0021:
            java.io.File[] r0 = r8.listFiles()
            if (r0 == 0) goto L_0x004b
            r1 = 0
            r2 = 0
            int r3 = r0.length
        L_0x002a:
            if (r2 >= r3) goto L_0x0049
            r4 = r0[r2]
            boolean r4 = r4.isFile()
            if (r4 == 0) goto L_0x003a
            r4 = r0[r2]
            r4.delete()
            goto L_0x0046
        L_0x003a:
            com.baidu.netdisk.baidusdk.api.NetdiskCacheCleaner r4 = INSTANCE
            r5 = r0[r2]
            java.lang.String r6 = "it[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r4.deleteFile(r5)
        L_0x0046:
            int r2 = r2 + 1
            goto L_0x002a
        L_0x0049:
        L_0x004b:
            r8.delete()
            return
        L_0x004f:
            r8.delete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.baidusdk.api.NetdiskCacheCleaner.deleteFile(java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if ((r0.length == 0) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void clearPreviewCache(java.io.File r9) {
        /*
            r8 = this;
            boolean r0 = r9.exists()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r9.isFile()
            if (r0 != 0) goto L_0x0049
            java.io.File[] r0 = r9.listFiles()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            int r0 = r0.length
            if (r0 != 0) goto L_0x001a
            r0 = r2
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            if (r0 == 0) goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            if (r1 == 0) goto L_0x0021
            goto L_0x0049
        L_0x0021:
            java.io.File[] r0 = r9.listFiles()
            if (r0 == 0) goto L_0x0048
            r1 = 0
            r2 = 0
            int r3 = r0.length
        L_0x002a:
            if (r2 >= r3) goto L_0x0046
            long r4 = java.lang.System.currentTimeMillis()
            r6 = r0[r2]
            long r6 = r6.lastModified()
            long r4 = r4 - r6
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0043
            r6 = r0[r2]
            r6.delete()
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x002a
        L_0x0046:
        L_0x0048:
            return
        L_0x0049:
            r9.delete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.baidusdk.api.NetdiskCacheCleaner.clearPreviewCache(java.io.File):void");
    }
}
