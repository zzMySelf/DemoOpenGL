package com.baidu.wallet.core;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.sapi2.activity.ImageClipActivity;
import com.baidu.sapi2.result.GetCertStatusResult;
import com.google.common.net.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileFetchManager implements NoProguard {
    public static final int FILE_FETCH_REQUEST = 7;
    public static final int MAX_LENGTH = 10485760;
    public Context context;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0032 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0032 }
            if (r8 == 0) goto L_0x002c
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x002c
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            r7 = r8
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0031
            r8.close()
        L_0x0031:
            return r7
        L_0x0032:
            r9 = move-exception
        L_0x0033:
            if (r7 == 0) goto L_0x0038
            r7.close()
        L_0x0038:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.FileFetchManager.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String getFileAbsolutePath(Context context2, Uri uri) {
        Uri uri2 = null;
        if (!(context2 == null || uri == null)) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 19) {
                return getRealFilePath(context2, uri);
            }
            if (i2 < 19 || i2 >= 29 || !DocumentsContract.isDocumentUri(context2, uri)) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return uriToFileApiQ(context2, uri);
                }
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    if (isGooglePhotosUri(uri)) {
                        return uri.getLastPathSegment();
                    }
                    return getDataColumn(context2, uri, (String) null, (String[]) null);
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            } else if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if (GetCertStatusResult.VALUE_PRIMARY_REAL_NAME.equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                return getDataColumn(context2, ContentUris.withAppendedId(Uri.parse(ImageClipActivity.n), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
            } else if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if (MediaType.IMAGE_TYPE.equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if (MediaType.VIDEO_TYPE.equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (MediaType.AUDIO_TYPE.equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context2, uri2, "_id=?", new String[]{split2[1]});
            }
        }
        return null;
    }

    public static String getRealFilePath(Context context2, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || (query = context2.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
            str = query.getString(columnIndex);
        }
        query.close();
        return str;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return ImageClipActivity.l.equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return ImageClipActivity.m.equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return ImageClipActivity.k.equals(uri.getAuthority());
    }

    public static boolean isValidFileLength(double d, long j) {
        return ((double) j) <= (d * 1024.0d) * 1024.0d;
    }

    public static void pickFile(@NonNull Activity activity, int i2, String str) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        if (TextUtils.equals(str, "pdf")) {
            intent.setType(DocumentOpenUtil.PDF_TYPE);
        } else {
            intent.setType("*/*");
        }
        intent.addCategory("android.intent.category.OPENABLE");
        activity.startActivityForResult(intent, i2);
    }

    @RequiresApi(api = 29)
    public static String uriToFileApiQ(Context context2, Uri uri) {
        if (uri.getScheme().equals("file")) {
            return new File(uri.getPath()).getAbsolutePath();
        }
        if (!uri.getScheme().equals("content")) {
            return null;
        }
        ContentResolver contentResolver = context2.getContentResolver();
        Cursor query = contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (!query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndex("_display_name"));
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            File file = new File(context2.getExternalCacheDir().getAbsolutePath(), string);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileUtils.copy(openInputStream, fileOutputStream);
            fileOutputStream.close();
            openInputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
