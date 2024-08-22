package com.baidu.searchbox.download.util;

import android.app.Activity;
import android.app.RecoverableSecurityException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.android.support.appcompat.storage.MediaFileHelper;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.android.support.appcompat.storage.RequestCallback;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.permission.ApiUtils;
import com.baidu.searchbox.player.plugin.auth.constant.VideoOperationTypeKt;
import com.baidu.searchbox.video.search.tc.TCJSON;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class DownloadMediaHelper {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int REQUEST_DELETE_CODE = 1010;
    public static final String TAG = "DownloadMediaHelper";
    private static ArrayList<String> mAudioPath = new ArrayList<>();
    private static ArrayList<String> mDownloadPath = new ArrayList<>();
    private static ArrayList<String> mImagePath = new ArrayList<>();
    private static ArrayList<String> mVideoPath = new ArrayList<>();

    public interface CallBack<T> {
        void callback(T t);
    }

    static {
        mImagePath.add("Pictures");
        mImagePath.add("DCIM");
        mVideoPath.add("Movies");
        mVideoPath.add("DCIM");
        mAudioPath.add("Music");
        mAudioPath.add("Alarms");
        mAudioPath.add("Notifications");
        mAudioPath.add("Podcasts");
        mAudioPath.add("Ringtones");
        mDownloadPath.add(VideoOperationTypeKt.DOWNLOAD);
    }

    public static MediaFileProcessor.UriSource getMediaFileUriSource(int type) {
        switch (type) {
            case 0:
                return MediaFileProcessor.UriSource.VIDEO;
            case 1:
                return MediaFileProcessor.UriSource.AUDIO;
            case 2:
                return MediaFileProcessor.UriSource.IMAGE;
            default:
                return MediaFileProcessor.UriSource.DOWNLOAD;
        }
    }

    public static MediaFileProcessor.UriSource getMediaFileUriSource(String fileName, String mimeType) {
        return getMediaFileUriSource(FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(fileName), mimeType));
    }

    public static Uri getMediaFileUri(String fileName, String mimeType) {
        return MediaFileProcessor.getUri(getMediaFileUriSource(FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(fileName), mimeType)));
    }

    public static String getMediaFileDefaultPathFromFile(String fileName, String mimeType) {
        return getMediaFileDefaultPath(getMediaFileUriSource(FileClassifyHelper.getCategory(FileClassifyHelper.getFileSuffix(fileName), mimeType)));
    }

    public static String getMediaFileDefaultPath(MediaFileProcessor.UriSource source) {
        if (!DownloadHelper.isExternalMediaMounted() || Environment.getExternalStorageDirectory() == null) {
            return null;
        }
        String base = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        switch (AnonymousClass3.$SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource[source.ordinal()]) {
            case 1:
                return base + mImagePath.get(0);
            case 2:
                return base + mAudioPath.get(0);
            case 3:
                return base + mVideoPath.get(0);
            default:
                return base + mDownloadPath.get(0);
        }
    }

    /* renamed from: com.baidu.searchbox.download.util.DownloadMediaHelper$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource;

        static {
            int[] iArr = new int[MediaFileProcessor.UriSource.values().length];
            $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource = iArr;
            try {
                iArr[MediaFileProcessor.UriSource.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource[MediaFileProcessor.UriSource.AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$android$support$appcompat$storage$MediaFileProcessor$UriSource[MediaFileProcessor.UriSource.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static String getOpenScopedStorageDownloadFilePath() {
        return (Environment.getExternalStorageDirectory().getAbsolutePath() + "/") + mDownloadPath.get(0) + Constants.DEFAULT_DL_SUBDIR;
    }

    public static boolean isDownloadPathUncompliant(String path) {
        if (!isOpenScopedStorage()) {
            return DownloadHelper.isExternalStorageAndNoPermission(path);
        }
        boolean valid = checkDownloadSpecifiedDirectoryValid(path);
        if (!valid && DEBUG) {
            Log.e(TAG, "Download directory does not meet Android 10 partition storage specifications.");
        }
        return !valid;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r3 = r7.substring((r3.length() + r0) + 1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkDownloadSpecifiedDirectoryValid(java.lang.String r7) {
        /*
            boolean r0 = isOpenScopedStorage()
            r1 = 1
            if (r0 == 0) goto L_0x0082
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0082
            boolean r0 = com.baidu.searchbox.download.util.DownloadHelper.isStoragePrivatePath(r7)
            if (r0 == 0) goto L_0x0014
            goto L_0x0082
        L_0x0014:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = r0.getPath()
            boolean r0 = r7.contains(r0)
            r2 = 0
            if (r0 != 0) goto L_0x0024
            return r2
        L_0x0024:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r0 = r0.getPath()
            int r0 = r7.indexOf(r0)
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = r3.getPath()
            r4 = -1
            if (r0 == r4) goto L_0x005d
            int r5 = r3.length()
            int r5 = r5 + r0
            int r5 = r5 + r1
            int r6 = r7.length()
            if (r5 >= r6) goto L_0x005d
            int r5 = r3.length()
            int r5 = r5 + r0
            int r5 = r5 + r1
            java.lang.String r3 = r7.substring(r5)
            java.lang.String r5 = "/"
            int r5 = r3.indexOf(r5)
            if (r5 == r4) goto L_0x005d
            java.lang.String r3 = r3.substring(r2, r5)
        L_0x005d:
            java.util.ArrayList<java.lang.String> r4 = mImagePath
            boolean r4 = r4.contains(r3)
            if (r4 != 0) goto L_0x0080
            java.util.ArrayList<java.lang.String> r4 = mAudioPath
            boolean r4 = r4.contains(r3)
            if (r4 != 0) goto L_0x0080
            java.util.ArrayList<java.lang.String> r4 = mVideoPath
            boolean r4 = r4.contains(r3)
            if (r4 != 0) goto L_0x0080
            java.util.ArrayList<java.lang.String> r4 = mDownloadPath
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r1 = r2
            goto L_0x0081
        L_0x0080:
        L_0x0081:
            return r1
        L_0x0082:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.util.DownloadMediaHelper.checkDownloadSpecifiedDirectoryValid(java.lang.String):boolean");
    }

    public static String getPathDir(String path) {
        if (TextUtils.isEmpty(path) || !path.contains(Environment.getExternalStorageDirectory().getPath())) {
            return "";
        }
        int start = path.indexOf(Environment.getExternalStorageDirectory().getPath());
        int len = Environment.getExternalStorageDirectory().getPath().length();
        int end = path.lastIndexOf("/");
        if (start + len + 1 < end) {
            return path.substring(start + len + 1, end);
        }
        return "";
    }

    public static String getName(String path) {
        int end;
        if (!TextUtils.isEmpty(path) && (end = path.lastIndexOf("/")) != -1 && end + 1 < path.length()) {
            return path.substring(end + 1);
        }
        return "";
    }

    public static boolean isOpenScopedStorage() {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 29) {
            if (DEBUG) {
                Log.d(TAG, "isOpenScopedStorage android 10 以下设备，无分区存储");
            }
            return false;
        } else if (ApiUtils.hasTiramisu() && ApiUtils.hasTiramisuTargetVersion(AppRuntime.getAppContext())) {
            return true;
        } else {
            boolean legacy = false;
            try {
                if (!Environment.isExternalStorageLegacy()) {
                    z = true;
                }
                legacy = z;
                if (DEBUG) {
                    Log.d(TAG, "isOpenScopedStorage " + legacy);
                }
            } catch (Exception e2) {
            }
            return legacy;
        }
    }

    public static boolean isAndroid11Device() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public static boolean isNotSupportDeleteMoreItem() {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return !Environment.isExternalStorageLegacy();
    }

    public static boolean needMediaFileProcessor(String path) {
        return isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(path) && checkDownloadSpecifiedDirectoryValid(path);
    }

    public static boolean noNeedMediaFileProcessor(String path) {
        return !isOpenScopedStorage() || DownloadHelper.isStoragePrivatePath(path) || !checkDownloadSpecifiedDirectoryValid(path);
    }

    public static boolean deleteMediaFile(Context context, String fileName, String mimeType) {
        try {
            if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(fileName)) {
                if (DEBUG) {
                    Log.d(TAG, "deleteMediaFile: " + fileName);
                }
                Uri uri = queryMediaFileUri(context, fileName, mimeType);
                if (uri != null) {
                    if (MediaFileProcessor.delete(context, uri, (String) null, (String[]) null, fileName, (RequestCallback) new RequestCallback() {
                        public void onPermitted(Object res) {
                        }

                        public void onRefused() {
                        }

                        public void onFailed(int errorCode) {
                        }
                    }) > 0) {
                        return true;
                    }
                    return false;
                }
            }
            if (DownloadHelper.isExternalStorageAndNoPermission(fileName)) {
                return false;
            }
            File file = new File(fileName);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted && DEBUG) {
                    Log.w("DownloadManager", "deleteMediaFile delete file failed");
                }
                return deleted;
            }
            return false;
        } catch (Exception e2) {
            if (DEBUG) {
                throw new DebugException("deleteMediaFile" + e2);
            }
        }
    }

    public static boolean deleteMediaFile(Context context, String fileName, String mimeType, RequestCallback requestCallback) {
        try {
            if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(fileName)) {
                if (DEBUG) {
                    Log.d(TAG, "deleteMediaFile: " + fileName);
                }
                Uri uri = queryMediaFileUri(context, fileName, mimeType);
                if (uri != null) {
                    int num = MediaFileProcessor.delete(context, uri, (String) null, (String[]) null, fileName, requestCallback);
                    if (num > 0 && requestCallback != null) {
                        requestCallback.onPermitted(Integer.valueOf(num));
                    }
                    if (num > 0) {
                        return true;
                    }
                    return false;
                }
            }
            if (requestCallback != null) {
                requestCallback.onPermitted(true);
            }
            if (DownloadHelper.isExternalStorageAndNoPermission(fileName)) {
                return false;
            }
            File file = new File(fileName);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted && DEBUG) {
                    Log.w("DownloadManager", "deleteMediaFile delete file failed");
                }
                return deleted;
            }
            return false;
        } catch (Exception e2) {
            if (DEBUG) {
                throw new DebugException("deleteMediaFile" + e2);
            }
        }
    }

    public static boolean deleteMediaFile(Context context, long id, MediaFileProcessor.UriSource uriSource) {
        try {
            if (isOpenScopedStorage()) {
                if (DEBUG) {
                    Log.d(TAG, "deleteMediaFile: " + id);
                }
                if (MediaFileProcessor.delete(context, ContentUris.withAppendedId(MediaFileProcessor.getUri(uriSource), id), (String) null, (String[]) null, (RequestCallback) new RequestCallback() {
                    public void onPermitted(Object res) {
                    }

                    public void onRefused() {
                    }

                    public void onFailed(int errorCode) {
                    }
                }) > 0) {
                    return true;
                }
                return false;
            }
        } catch (Exception e2) {
            if (DEBUG) {
                throw new DebugException("deleteMediaFile" + e2);
            }
        }
        return false;
    }

    public static void deleteByUriList(Context context, List<Uri> list) {
        deleteByUriList(context, list, (CallBack<Uri>) null, (CallBack<ArrayList<Uri>>) null);
    }

    public static void deleteByUriList(Context context, List<Uri> list, CallBack<ArrayList<Uri>> deleteCallback) {
        deleteByUriList(context, list, (CallBack<Uri>) null, deleteCallback);
    }

    public static void deleteByUriList(Context context, List<Uri> list, CallBack<Uri> requestCallback, CallBack<ArrayList<Uri>> deleteCallback) {
        Activity activity;
        if (context == null || list == null || list.isEmpty()) {
            if (deleteCallback != null) {
                deleteCallback.callback(new ArrayList());
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            ArrayList<Uri> mNeedPermissionUriList = new ArrayList<>();
            for (Uri uri : list) {
                if (uri != null) {
                    try {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file " + uri);
                        }
                        context.getContentResolver().delete(uri, (String) null, (String[]) null);
                        if (requestCallback != null) {
                            requestCallback.callback(uri);
                        }
                    } catch (RecoverableSecurityException e2) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file failed， need permission ");
                        }
                        mNeedPermissionUriList.add(uri);
                    } catch (SecurityException e3) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file failed，uri error");
                        }
                    }
                }
            }
            if (deleteCallback != null) {
                deleteCallback.callback(mNeedPermissionUriList);
            }
            if (!mNeedPermissionUriList.isEmpty()) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = BdBoxActivityManager.getRealTopActivity();
                }
                try {
                    if (!ActivityUtils.isDestroyed(activity)) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file fail, start use android R api ");
                        }
                        activity.startIntentSenderForResult(MediaStore.createDeleteRequest(context.getContentResolver(), mNeedPermissionUriList).getIntentSender(), 1010, (Intent) null, 0, 0, 0);
                    }
                } catch (IntentSender.SendIntentException e4) {
                    if (DEBUG) {
                        Log.w("DownloadManager", "deleteByUriList delete buy android R api fail " + e4.getMessage());
                    }
                }
            }
        }
    }

    public static void deleteByUriListForUriListCallback(Context context, List<Uri> list, CallBack<ArrayList<Uri>> requestCallback, CallBack<ArrayList<Uri>> deleteCallback) {
        Activity activity;
        Context context2 = context;
        CallBack<ArrayList<Uri>> callBack = requestCallback;
        CallBack<ArrayList<Uri>> callBack2 = deleteCallback;
        if (context2 == null || list == null || list.isEmpty()) {
            if (callBack != null) {
                callBack.callback(new ArrayList());
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Uri uri : list) {
                if (uri != null) {
                    try {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file " + uri);
                        }
                        context.getContentResolver().delete(uri, (String) null, (String[]) null);
                        arrayList2.add(uri);
                    } catch (RecoverableSecurityException e2) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file failed， need permission ");
                        }
                        arrayList.add(uri);
                    } catch (SecurityException e3) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file failed， need permission ");
                        }
                    }
                }
            }
            if (callBack != null) {
                callBack.callback(arrayList2);
            }
            if (callBack2 != null) {
                callBack2.callback(arrayList);
            }
            if (!arrayList.isEmpty()) {
                if (context2 instanceof Activity) {
                    activity = (Activity) context2;
                } else {
                    activity = BdBoxActivityManager.getRealTopActivity();
                }
                try {
                    if (!ActivityUtils.isDestroyed(activity)) {
                        if (DEBUG) {
                            Log.w("DownloadManager", "deleteByUriList delete file fail, start use android R api ");
                        }
                        activity.startIntentSenderForResult(MediaStore.createDeleteRequest(context.getContentResolver(), arrayList).getIntentSender(), 1010, (Intent) null, 0, 0, 0);
                    }
                } catch (IntentSender.SendIntentException e4) {
                    if (DEBUG) {
                        Log.w("DownloadManager", "deleteByUriList delete buy android R api fail " + e4.getMessage());
                    }
                } catch (Exception e5) {
                    if (DEBUG) {
                        Log.w("DownloadManager", "deleteByUriList exception " + e5.getMessage());
                    }
                }
            }
        }
    }

    public static Uri pathFileUri(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }
        File file = new File(fileName);
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        return null;
    }

    public static Uri convertPathToMediaUri(Context context, String path) {
        if (!isOpenScopedStorage() || DownloadHelper.isStoragePrivatePath(path)) {
            return pathFileUri(path);
        }
        if (context == null) {
            return null;
        }
        String ext = FileClassifyHelper.getFileSuffix(path);
        if (TextUtils.isEmpty(ext)) {
            return null;
        }
        String mime = FileClassifyHelper.guessMimeTypeFromExtension(ext);
        if (TextUtils.isEmpty(mime)) {
            return null;
        }
        return queryMediaFileUri(context.getApplicationContext(), path, mime);
    }

    public static Uri queryMediaFileUri(Context context, String fileName, String mimeType) {
        String selection;
        String dir = getPathDir(fileName);
        String name = getName(fileName);
        if (TextUtils.isEmpty(dir) && TextUtils.isEmpty(fileName)) {
            return null;
        }
        String[] projection = {"_id"};
        if (Build.VERSION.SDK_INT >= 29) {
            selection = "_display_name= ? AND relative_path= ?";
        } else {
            selection = null;
        }
        Cursor cursor = null;
        Uri uri = null;
        try {
            cursor = MediaFileProcessor.query(context, getMediaFileUriSource(fileName, mimeType), projection, selection, new String[]{name, dir + "/"}, (String) null);
            if (cursor == null || !cursor.moveToNext()) {
                if (DEBUG) {
                    try {
                        Log.d(TAG, "queryMediaFileUri: 未查询到文件，" + fileName);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    String str = fileName;
                }
                Closeables.closeSafely(cursor);
                return uri;
            }
            uri = ContentUris.withAppendedId(getMediaFileUri(fileName, mimeType), cursor.getLong(cursor.getColumnIndex("_id")));
            String str2 = fileName;
            Closeables.closeSafely(cursor);
            return uri;
        } catch (Exception e3) {
            e = e3;
            String str3 = fileName;
            try {
                if (DEBUG) {
                    Log.d(TAG, "queryMediaFileUri: 错误，" + e.toString());
                }
                Closeables.closeSafely(cursor);
                return uri;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            String str4 = fileName;
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    public static FileInputStream getFileInputStream(String fileName, String mimeType, RequestCallback requestCallback) {
        try {
            if (isOpenScopedStorage() && !DownloadHelper.isStoragePrivatePath(fileName)) {
                ParcelFileDescriptor pfd = MediaFileHelper.openFileDescriptor(AppRuntime.getAppContext(), queryMediaFileUri(AppRuntime.getAppContext(), fileName, mimeType), TCJSON.KEY.R, requestCallback);
                if (pfd != null) {
                    return new FileInputStream(pfd.getFileDescriptor());
                }
                return null;
            } else if (TextUtils.isEmpty(fileName) || !new File(fileName).exists()) {
                return null;
            } else {
                return new FileInputStream(fileName);
            }
        } catch (Exception e2) {
            if (!DEBUG) {
                return null;
            }
            Log.e(TAG, "文件找不到 " + e2);
            return null;
        }
    }

    public static void deleteFromMediaProvider(Context context, Uri url, String where, String[] selectionArgs) {
        try {
            context.getContentResolver().delete(url, where, selectionArgs);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, int limitCount) {
        return query(uri, projection, selection, selectionArgs, sortOrder, limitCount, -1);
    }

    public static Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, int limitCount, int offset) {
        if (Build.VERSION.SDK_INT >= 30) {
            return AppRuntime.getAppContext().getContentResolver().query(uri, projection, createQueryArgsBundle(selection, selectionArgs, sortOrder, limitCount, offset), (CancellationSignal) null);
        }
        return AppRuntime.getAppContext().getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
    }

    private static Bundle createQueryArgsBundle(String selection, String[] selectionArgs, String sortOrder, int limitCount, int offset) {
        Bundle queryArgs = new Bundle();
        if (Build.VERSION.SDK_INT >= 30) {
            if (selection != null) {
                queryArgs.putString("android:query-arg-sql-selection", selection);
            }
            if (selectionArgs != null) {
                queryArgs.putStringArray("android:query-arg-sql-selection-args", selectionArgs);
            }
            if (sortOrder != null) {
                queryArgs.putString("android:query-arg-sql-sort-order", sortOrder);
            }
            if (limitCount > 0) {
                queryArgs.putInt("android:query-arg-limit", limitCount);
            }
            if (offset > 0) {
                queryArgs.putInt("android:query-arg-offset", offset);
            }
        }
        return queryArgs;
    }
}
