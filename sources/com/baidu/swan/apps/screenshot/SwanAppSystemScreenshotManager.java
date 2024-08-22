package com.baidu.swan.apps.screenshot;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.lifecycle.SwanAppLifecycle;
import com.baidu.swan.apps.statistic.StatRouter;
import com.baidu.swan.apps.util.SwanAppAPIUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.support.v4.conent.ContextCompat;
import com.baidu.swan.utils.SwanAppFileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwanAppSystemScreenshotManager {
    private static final long CHECK_INTERVAL_ANDROID_Q = 500;
    private static final long CHECK_INTERVAL_NORMAL = 100;
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final long DELAY_TIME = 2000;
    private static final String EXT = "ext";
    private static final String FROM = "from";
    private static final int MAX_CHECK_COUNT = 10;
    private static final String PAGE = "page";
    private static final String TAG = "SYSTEM_SCREENSHOT";
    private static final String UBC_SYSTEM_SCREENSHOT = "SystemScreenshot";
    /* access modifiers changed from: private */
    public static List<ISwanAppScreenshotCallback> mCallbacks = new ArrayList();
    private static ContentObserver mContentObserver;
    private static ContentResolver mContentResolver;
    /* access modifiers changed from: private */
    public static int mCount = 0;
    /* access modifiers changed from: private */
    public static Runnable mFileExistsRunnable;
    /* access modifiers changed from: private */
    public static Uri mImageUri;
    private static boolean mIsMatched;
    private static String mLastImagePath = null;
    private static String mLastImageUri = null;
    private static long mLastTime = (System.currentTimeMillis() - 10000);
    public static long mWhenAppInForeground;
    private static PackageManager pm;

    static /* synthetic */ int access$608() {
        int i2 = mCount;
        mCount = i2 + 1;
        return i2;
    }

    private static boolean tooShort() {
        return System.currentTimeMillis() - mLastTime <= 1000;
    }

    public static void registerScreenshotObserver(Context context) {
        pm = context.getPackageManager();
        final Handler handler = new Handler(Looper.getMainLooper());
        mContentResolver = context.getContentResolver();
        mContentObserver = new ContentObserver(handler) {
            public void onChange(boolean selfChange, final Uri uri) {
                super.onChange(selfChange, uri);
                if (SwanAppSystemScreenshotManager.DEBUG) {
                    Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
                }
                ExecutorUtilsExt.postOnElastic(new Runnable() {
                    public void run() {
                        SwanAppSystemScreenshotManager.processContentChange(handler, uri);
                    }
                }, "systemScreenShot", 1);
            }
        };
        if (isRuntimePermissionGranted(context)) {
            try {
                mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, mContentObserver);
            } catch (SecurityException e2) {
                if (DEBUG) {
                    SwanAppLog.i("SYSTEM_SCREENSHOT", "EXTERNAL_CONTENT_URI register failed");
                }
            }
        } else if (DEBUG && SwanAppUtils.isBaiduBoxApp()) {
            SwanAppLog.i("SYSTEM_SCREENSHOT", "WRITE_EXTERNAL_STORAGE permission denied");
        }
    }

    /* access modifiers changed from: private */
    public static void processContentChange(Handler handler, Uri uri) {
        List<ProviderInfo> pis;
        final Handler handler2 = handler;
        if (uri.toString().matches(ScreenshotDetector.EXTERNAL_CONTENT_URI_MATCHER + ".*")) {
            if (!tooShort() || !mIsMatched) {
                mCount = 0;
                mLastTime = System.currentTimeMillis();
                Cursor cursor = null;
                try {
                    cursor = mContentResolver.query(uri, ScreenshotDetector.PROJECTION, (String) null, (String[]) null, "date_added DESC");
                    if (cursor != null && cursor.moveToFirst()) {
                        final String imagePath = cursor.getString(cursor.getColumnIndex("_data"));
                        long dateAdded = cursor.getLong(cursor.getColumnIndex("date_added"));
                        long nowSecs = System.currentTimeMillis() / 1000;
                        mImageUri = uri;
                        if (SwanAppAPIUtils.hasAndroidQ()) {
                            mImageUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (long) cursor.getInt(cursor.getColumnIndex("_id")));
                        }
                        if (DEBUG != 0) {
                            Log.d("SYSTEM_SCREENSHOT", "imagepath: " + imagePath);
                            Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + dateAdded);
                            Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + nowSecs);
                            Log.d("SYSTEM_SCREENSHOT", "imageUri: " + mImageUri.toString());
                        }
                        if (interceptSystemScreenEvent(imagePath)) {
                            SwanAppFileUtils.closeSafely(cursor);
                            return;
                        }
                        mLastImageUri = mImageUri.toString();
                        mLastImagePath = imagePath;
                        if (!ScreenshotDetector.matchPath(imagePath) || !ScreenshotDetector.matchTime(nowSecs, dateAdded)) {
                            mIsMatched = false;
                        } else {
                            mIsMatched = true;
                            final ScreenshotEvent event = new ScreenshotEvent(imagePath, Long.valueOf(dateAdded), mImageUri);
                            AnonymousClass2 r12 = new Runnable() {
                                public void run() {
                                    long delayMillis;
                                    SwanAppSystemScreenshotManager.access$608();
                                    if (SwanAppSystemScreenshotManager.DEBUG) {
                                        Log.d("SYSTEM_SCREENSHOT", "mCount: " + SwanAppSystemScreenshotManager.mCount);
                                    }
                                    if (SwanAppAPIUtils.hasAndroidQ()) {
                                        delayMillis = 500;
                                    } else {
                                        delayMillis = 100;
                                    }
                                    if (!SwanAppSystemScreenshotManager.isImageExists(imagePath, SwanAppSystemScreenshotManager.mImageUri) && SwanAppSystemScreenshotManager.mCount <= 10) {
                                        handler2.postDelayed(SwanAppSystemScreenshotManager.mFileExistsRunnable, delayMillis);
                                    } else if (SwanAppSystemScreenshotManager.isImageExists(imagePath, SwanAppSystemScreenshotManager.mImageUri) && SwanAppSystemScreenshotManager.isAppInForegroundWithTime() && !SwanAppSystemScreenshotManager.isLongImage(imagePath, SwanAppSystemScreenshotManager.mImageUri)) {
                                        for (ISwanAppScreenshotCallback callback : SwanAppSystemScreenshotManager.mCallbacks) {
                                            if (callback != null) {
                                                callback.onScreenshot(event);
                                            }
                                        }
                                    }
                                }
                            };
                            mFileExistsRunnable = r12;
                            handler2.post(r12);
                        }
                    }
                } catch (RuntimeException e2) {
                    RuntimeException runtimeException = e2;
                    PackageManager packageManager = pm;
                    if (packageManager != null) {
                        try {
                            pis = packageManager.queryContentProviders((String) null, 0, 131072);
                        } catch (Exception e3) {
                            Exception exc = e3;
                            pis = new ArrayList<>();
                        }
                        HashMap<String, String> map = new HashMap<>();
                        map.put("from", "SystemScreenshot");
                        map.put("page", "SystemScreenshot");
                        map.put("ext", pis.toString());
                        StatRouter.onEvent("460", (Map<String, String>) map);
                    }
                } catch (Throwable th2) {
                    SwanAppFileUtils.closeSafely(cursor);
                    throw th2;
                }
                SwanAppFileUtils.closeSafely(cursor);
                return;
            }
            mLastTime = System.currentTimeMillis();
        }
    }

    public static boolean isAppInForegroundWithTime() {
        return SwanAppLifecycle.get().isForeground() && System.currentTimeMillis() - mWhenAppInForeground > 2000;
    }

    /* access modifiers changed from: private */
    public static boolean isLongImage(String imagePath, Uri imageUri) {
        Point point = new Point();
        WindowManager wm = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
        if (wm.getDefaultDisplay() != null) {
            wm.getDefaultDisplay().getSize(point);
        }
        int screenHeight = point.y + getNavigationBarHeight();
        int screenWidth = point.x;
        double screenScale = 0.0d;
        if (screenWidth != 0) {
            screenScale = ((double) screenHeight) / (((double) screenWidth) * 1.0d);
        }
        double screenScale2 = screenScale * 1.2d;
        double imageScale = 0.0d;
        if (SwanAppAPIUtils.hasAndroidQ()) {
            imageScale = getImageScaleInAndroid10(imageUri);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        if (imageWidth != 0) {
            Point point2 = point;
            WindowManager windowManager = wm;
            imageScale = ((double) imageHeight) / (((double) imageWidth) * 1.0d);
        } else {
            WindowManager windowManager2 = wm;
        }
        return imageScale > screenScale2;
    }

    private static int getNavigationBarHeight() {
        boolean hasMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(4);
        if (hasMenuKey || hasBackKey) {
            return 0;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", ResUtils.DIMEN, "android"));
    }

    /* access modifiers changed from: private */
    public static boolean isImageExists(String imagePath, Uri imageUri) {
        if (SwanAppAPIUtils.hasAndroidQ()) {
            return isImageExistsAndroid10(imageUri);
        }
        new BitmapFactory.Options().inJustDecodeBounds = true;
        if (BitmapFactory.decodeFile(imagePath) != null) {
            return true;
        }
        return false;
    }

    private static boolean interceptSystemScreenEvent(String currentImagePath) {
        if (SwanAppAPIUtils.hasAndroidQ()) {
            Uri uri = mImageUri;
            if (uri == null || TextUtils.equals(mLastImageUri, uri.toString())) {
                return true;
            }
            return false;
        } else if (TextUtils.isEmpty(currentImagePath) || TextUtils.equals(mLastImagePath, currentImagePath)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isImageExistsAndroid10(Uri imageUri) {
        boolean bitmap = false;
        if (imageUri == null) {
            return false;
        }
        try {
            Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(mContentResolver, imageUri);
            if (bitmap2 != null) {
            }
            if (bitmap2 != null) {
            }
            return bitmap;
        } catch (Exception e2) {
            return false;
        } finally {
        }
    }

    private static double getImageScaleInAndroid10(Uri imageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContentResolver, imageUri);
            if (bitmap == null) {
                return 0.0d;
            }
            int imageH = bitmap.getHeight();
            int imageW = bitmap.getWidth();
            if (imageW != 0) {
                return ((double) imageH) / (((double) imageW) * 1.0d);
            }
            return 0.0d;
        } catch (Exception e2) {
            return 0.0d;
        }
    }

    private static boolean isRuntimePermissionGranted(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean hasPermission = ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
        if (hasPermission || !SwanAppAPIUtils.hasAndroidT()) {
            return hasPermission;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_IMAGES") == 0) {
            return true;
        }
        return false;
    }

    public static void registerCallback(ISwanAppScreenshotCallback callback) {
        if (callback != null) {
            mCallbacks.add(callback);
        }
    }

    public static void unRegisterCallback(ISwanAppScreenshotCallback callback) {
        if (callback != null) {
            mCallbacks.remove(callback);
        }
    }

    public static class ScreenshotEvent {
        public long mDateAdded;
        public String mImagePath;
        public Uri mImageSourceUri;

        private ScreenshotEvent(String imagePath, Long mDateAdded2, Uri imageSourceUri) {
            this.mImagePath = imagePath;
            this.mDateAdded = mDateAdded2.longValue();
            this.mImageSourceUri = imageSourceUri;
        }
    }

    private static class ScreenshotDetector {
        /* access modifiers changed from: private */
        public static String EXTERNAL_CONTENT_URI_MATCHER;
        /* access modifiers changed from: private */
        public static String[] PROJECTION;

        private ScreenshotDetector() {
        }

        static {
            EXTERNAL_CONTENT_URI_MATCHER = null;
            PROJECTION = null;
            EXTERNAL_CONTENT_URI_MATCHER = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            PROJECTION = new String[]{"_display_name", "_data", "date_added", "_id"};
        }

        /* access modifiers changed from: private */
        public static boolean matchPath(String path) {
            if (path == null) {
                return false;
            }
            if (path.toLowerCase().contains("screenshot") || path.contains("截屏") || path.contains("截图")) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static boolean matchTime(long now, long dateAdded) {
            return Math.abs(now - dateAdded) <= 10;
        }
    }
}
