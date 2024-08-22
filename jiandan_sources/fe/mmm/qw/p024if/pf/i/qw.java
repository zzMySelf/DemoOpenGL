package fe.mmm.qw.p024if.pf.i;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import com.baidu.sapi2.utils.SapiUtils;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.filetype.FileType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Locale;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* renamed from: fe.mmm.qw.if.pf.i.qw  reason: invalid package */
public final class qw {
    public static final String qw = Environment.DIRECTORY_PICTURES;

    public static final void ad(Uri uri, Context context, ContentResolver contentResolver, File file) {
        try {
            ContentValues contentValues = new ContentValues();
            if (Build.VERSION.SDK_INT < 29) {
                if (file != null) {
                    contentValues.put("_size", Long.valueOf(file.length()));
                }
                contentResolver.update(uri, contentValues, (String) null, (String[]) null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
                return;
            }
            contentValues.put("is_pending", 0);
            contentResolver.update(uri, contentValues, (String) null, (String[]) null);
        } catch (Throwable th2) {
            fe.mmm.qw.i.qw.th("ImageExt", SapiUtils.KEY_QR_LOGIN_ERROR, th2);
        }
    }

    public static final String de(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, BrowserServiceFileProvider.FILE_EXTENSION, false, 2, (Object) null)) {
            return "image/png";
        }
        if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".jpg", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".jpeg", false, 2, (Object) null)) {
            return "image/jpeg";
        }
        if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".webp", false, 2, (Object) null)) {
            return "image/webp";
        }
        if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, FileType.GIF_PATTERN_SUFFIX, false, 2, (Object) null)) {
            return "image/gif";
        }
        return null;
    }

    public static final Uri fe(ContentResolver contentResolver, String str, String str2, ad adVar) {
        Uri uri;
        String str3;
        ContentValues contentValues = new ContentValues();
        String de2 = de(str);
        if (de2 != null) {
            contentValues.put("mime_type", de2);
        }
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        int i2 = 1;
        if (Build.VERSION.SDK_INT >= 29) {
            if (str2 != null) {
                str3 = qw + '/' + str2;
            } else {
                str3 = qw;
            }
            contentValues.put("_display_name", str);
            contentValues.put("relative_path", str3);
            contentValues.put("is_pending", 1);
            uri = MediaStore.Images.Media.getContentUri("external_primary");
            Intrinsics.checkNotNullExpressionValue(uri, "getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)");
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(qw);
            if (str2 != null) {
                externalStoragePublicDirectory = new File(externalStoragePublicDirectory, str2);
            }
            if (externalStoragePublicDirectory.exists() || externalStoragePublicDirectory.mkdirs()) {
                File file = new File(externalStoragePublicDirectory, str);
                String nameWithoutExtension = FilesKt__UtilsKt.getNameWithoutExtension(file);
                String extension = FilesKt__UtilsKt.getExtension(file);
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "imageFile.absolutePath");
                Uri th2 = th(contentResolver, absolutePath);
                while (th2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nameWithoutExtension);
                    sb.append('(');
                    int i3 = i2 + 1;
                    sb.append(i2);
                    sb.append(").");
                    sb.append(extension);
                    File file2 = new File(externalStoragePublicDirectory, sb.toString());
                    String absolutePath2 = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "imageFile.absolutePath");
                    int i4 = i3;
                    th2 = th(contentResolver, absolutePath2);
                    file = file2;
                    i2 = i4;
                }
                contentValues.put("_display_name", file.getName());
                String absolutePath3 = file.getAbsolutePath();
                LoggerKt.d("save file: " + absolutePath3, "ImageExt");
                contentValues.put("_data", absolutePath3);
                if (adVar != null) {
                    adVar.ad(file);
                }
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Intrinsics.checkNotNullExpressionValue(uri, "EXTERNAL_CONTENT_URI");
            } else {
                LoggerKt.d("save: error: can't create Pictures directory", "ImageExt");
                return null;
            }
        }
        return contentResolver.insert(uri, contentValues);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r3;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri qw(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.NotNull android.content.Context r3, @org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r2.canRead()
            r1 = 0
            if (r0 == 0) goto L_0x0031
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x001d
            goto L_0x0031
        L_0x001d:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r2)
            android.net.Uri r2 = yj(r0, r3, r4, r5)     // Catch:{ all -> 0x002a }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x002a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002c }
        L_0x002c:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        L_0x0031:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check: read file error: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "ImageExt"
            com.mars.kotlin.extension.LoggerKt.d(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.pf.i.qw.qw(java.io.File, android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static final OutputStream rg(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openOutputStream(uri);
        } catch (FileNotFoundException e) {
            LoggerKt.d("save: open stream error: " + e, "ImageExt");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0092, code lost:
        kotlin.io.CloseableKt.closeFinally(r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri th(android.content.ContentResolver r11, java.lang.String r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 29
            if (r0 < r2) goto L_0x0008
            return r1
        L_0x0008:
            java.io.File r0 = new java.io.File
            r0.<init>(r12)
            boolean r2 = r0.canRead()
            java.lang.String r3 = "ImageExt"
            java.lang.String r4 = "query: path: "
            if (r2 == 0) goto L_0x0039
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x0039
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r4)
            r11.append(r12)
            java.lang.String r12 = " exists"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.mars.kotlin.extension.LoggerKt.d(r11, r3)
            android.net.Uri r11 = android.net.Uri.fromFile(r0)
            return r11
        L_0x0039:
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            java.lang.String r2 = "_id"
            java.lang.String r5 = "_data"
            java.lang.String[] r7 = new java.lang.String[]{r2, r5}
            r5 = 1
            java.lang.String[] r9 = new java.lang.String[r5]
            r5 = 0
            r9[r5] = r12
            r10 = 0
            java.lang.String r8 = "_data == ?"
            r5 = r11
            r6 = r0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)
            if (r11 == 0) goto L_0x0096
            boolean r5 = r11.moveToNext()     // Catch:{ all -> 0x008f }
            if (r5 == 0) goto L_0x0089
            int r2 = r11.getColumnIndexOrThrow(r2)     // Catch:{ all -> 0x008f }
            long r5 = r11.getLong(r2)     // Catch:{ all -> 0x008f }
            android.net.Uri r0 = android.content.ContentUris.withAppendedId(r0, r5)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "withAppendedId(collection, id)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r2.<init>()     // Catch:{ all -> 0x008f }
            r2.append(r4)     // Catch:{ all -> 0x008f }
            r2.append(r12)     // Catch:{ all -> 0x008f }
            java.lang.String r12 = " exists uri: "
            r2.append(r12)     // Catch:{ all -> 0x008f }
            r2.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x008f }
            com.mars.kotlin.extension.LoggerKt.d(r12, r3)     // Catch:{ all -> 0x008f }
            kotlin.io.CloseableKt.closeFinally(r11, r1)
            return r0
        L_0x0089:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008f }
            kotlin.io.CloseableKt.closeFinally(r11, r1)
            goto L_0x0096
        L_0x008f:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r11, r12)
            throw r0
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.pf.i.qw.th(android.content.ContentResolver, java.lang.String):android.net.Uri");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        throw r6;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri yj(@org.jetbrains.annotations.NotNull java.io.InputStream r5, @org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.content.ContentResolver r0 = r6.getContentResolver()
            fe.mmm.qw.if.pf.i.ad r1 = new fe.mmm.qw.if.pf.i.ad
            r2 = 0
            r3 = 1
            r1.<init>(r2, r3, r2)
            java.lang.String r3 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.net.Uri r7 = fe(r0, r7, r8, r1)
            if (r7 != 0) goto L_0x002d
            java.lang.String r5 = "insert: error: uri == null"
            java.lang.String r6 = "ImageExt"
            com.mars.kotlin.extension.LoggerKt.d(r5, r6)
            return r2
        L_0x002d:
            java.io.OutputStream r8 = rg(r7, r0)
            if (r8 != 0) goto L_0x0034
            return r2
        L_0x0034:
            r3 = 0
            r4 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r5, r8, r3, r4, r2)     // Catch:{ all -> 0x004b }
            java.io.File r1 = r1.qw()     // Catch:{ all -> 0x004b }
            ad(r7, r6, r0, r1)     // Catch:{ all -> 0x004b }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            kotlin.io.CloseableKt.closeFinally(r5, r2)     // Catch:{ all -> 0x0052 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0052 }
            kotlin.io.CloseableKt.closeFinally(r8, r2)
            return r7
        L_0x004b:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x004d }
        L_0x004d:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r6)     // Catch:{ all -> 0x0052 }
            throw r7     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.pf.i.qw.yj(java.io.InputStream, android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }
}
