package com.baidu.map.poipage.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;

public class PictureUtils {
    public static boolean savePic2Gallery(Context context, String file, String displayName, String description, String mimeType, String relativePath) {
        if (Build.VERSION.SDK_INT < 29) {
            return savePic2GalleryUnderQ(context, new File(file), displayName, relativePath);
        }
        return savePic2GalleryQ(context, new File(file), displayName, description, mimeType, relativePath);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9 A[ExcHandler: all (th java.lang.Throwable), PHI: r8 r9 
      PHI: (r8v1 'fileOutputStream' java.io.FileOutputStream) = (r8v2 'fileOutputStream' java.io.FileOutputStream), (r8v2 'fileOutputStream' java.io.FileOutputStream), (r8v6 'fileOutputStream' java.io.FileOutputStream), (r8v6 'fileOutputStream' java.io.FileOutputStream), (r8v6 'fileOutputStream' java.io.FileOutputStream) binds: [B:36:0x00a5, B:37:?, B:17:0x0077, B:25:0x0093, B:26:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v1 'inputStream' java.io.InputStream) = (r9v2 'inputStream' java.io.InputStream), (r9v2 'inputStream' java.io.InputStream), (r9v0 'inputStream' java.io.InputStream), (r9v5 'inputStream' java.io.InputStream), (r9v5 'inputStream' java.io.InputStream) binds: [B:36:0x00a5, B:37:?, B:17:0x0077, B:25:0x0093, B:26:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:17:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad A[SYNTHETIC, Splitter:B:40:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b5 A[Catch:{ Exception -> 0x00b1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean savePic2GalleryQ(android.content.Context r16, java.io.File r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            r1 = r0
            java.lang.String r0 = "_display_name"
            r2 = r18
            r1.put(r0, r2)
            java.lang.String r0 = "description"
            r3 = r19
            r1.put(r0, r3)
            java.lang.String r0 = "mime_type"
            r4 = r20
            r1.put(r0, r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = android.os.Environment.DIRECTORY_PICTURES
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r5 = java.io.File.separator
            java.lang.StringBuilder r0 = r0.append(r5)
            r5 = r21
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "relative_path"
            r1.put(r6, r0)
            r6 = 0
            android.content.ContentResolver r7 = r16.getContentResolver()
            r8 = 0
            r9 = 0
            r10 = 0
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r11 = r0
            android.net.Uri r0 = r7.insert(r11, r1)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r6 = r0
            if (r6 != 0) goto L_0x005e
            if (r8 == 0) goto L_0x0057
            r8.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            r0 = move-exception
            goto L_0x005d
        L_0x0057:
            if (r9 == 0) goto L_0x005c
            r9.close()     // Catch:{ Exception -> 0x0055 }
        L_0x005c:
        L_0x005d:
            return r10
        L_0x005e:
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            java.lang.String r12 = "w"
            android.os.ParcelFileDescriptor r12 = r7.openFileDescriptor(r6, r12)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            java.io.FileDescriptor r14 = r12.getFileDescriptor()     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r13.<init>(r14)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r8 = r13
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r14 = r17
            r13.<init>(r14)     // Catch:{ Exception -> 0x0097, all -> 0x00a9 }
            r9 = r13
        L_0x007b:
            int r13 = r9.read(r0)     // Catch:{ Exception -> 0x0097, all -> 0x00a9 }
            r15 = -1
            if (r13 != r15) goto L_0x0093
            r8.flush()     // Catch:{ Exception -> 0x0097, all -> 0x00a9 }
            r8.close()     // Catch:{ Exception -> 0x008f }
            r9.close()     // Catch:{ Exception -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r0 = move-exception
        L_0x0091:
            r0 = 1
            return r0
        L_0x0093:
            r8.write(r0, r10, r13)     // Catch:{ Exception -> 0x0097, all -> 0x00a9 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
            goto L_0x00a1
        L_0x0099:
            r0 = move-exception
            r14 = r17
        L_0x009c:
            r10 = r0
            goto L_0x00ab
        L_0x009e:
            r0 = move-exception
            r14 = r17
        L_0x00a1:
            r11 = r0
            if (r6 == 0) goto L_0x00bc
            r0 = 0
            r7.delete(r6, r0, r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00a9 }
            goto L_0x00bc
        L_0x00a9:
            r0 = move-exception
            goto L_0x009c
        L_0x00ab:
            if (r8 == 0) goto L_0x00b3
            r8.close()     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b3
        L_0x00b1:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b3:
            if (r9 == 0) goto L_0x00b8
            r9.close()     // Catch:{ Exception -> 0x00b1 }
        L_0x00b8:
        L_0x00b9:
            throw r10
        L_0x00ba:
            r0 = move-exception
            goto L_0x00bd
        L_0x00bc:
        L_0x00bd:
            if (r8 == 0) goto L_0x00c6
            r8.close()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c6
        L_0x00c4:
            r0 = move-exception
            goto L_0x00cc
        L_0x00c6:
            if (r9 == 0) goto L_0x00cb
            r9.close()     // Catch:{ Exception -> 0x00c4 }
        L_0x00cb:
        L_0x00cc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.map.poipage.utils.PictureUtils.savePic2GalleryQ(android.content.Context, java.io.File, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private static boolean savePic2GalleryUnderQ(Context context, File fromFile, String displayName, String relativePath) {
        Context context2 = context;
        String fileName = displayName + ".jpg";
        File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), relativePath);
        try {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (!dir.isDirectory()) {
                return false;
            }
            File file = new File(dir, fileName);
            Bitmap bitmap = BitmapFactory.decodeFile(fromFile.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            if (Build.VERSION.SDK_INT >= 19) {
                MediaScannerConnection.scanFile(context2, new String[]{file.getAbsolutePath()}, (String[]) null, new PictureUtils$$ExternalSyntheticLambda0(context2));
            } else {
                context2.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.fromFile(new File(file.getParent()).getAbsoluteFile())));
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ void lambda$savePic2GalleryUnderQ$0(Context context, String path, Uri uri) {
        Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        mediaScanIntent.setData(uri);
        context.sendBroadcast(mediaScanIntent);
    }

    public static void saveBitmap(Bitmap bm, File file) {
        try {
            FileOutputStream saveImgOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, saveImgOut);
            saveImgOut.flush();
            saveImgOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
