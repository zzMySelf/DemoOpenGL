package com.baidu.sapi2.shell.manager;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;

public class ScreenShotManager {
    public static final String[] KEYWORDS = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    public static final String[] MEDIA_PROJECTIONS = {"_data", "datetaken"};
    public static final String SCREEN_SHOT_OBSERVER = "screen_shot_observer";
    public ContentResolver mContentResolver;
    public MediaContentObserver mExternalObserver;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public MediaContentObserver mInternalObserver;
    public IScreenShotListener mScreenShotListener;

    public class MediaContentObserver extends ContentObserver {
        public final Uri mContentUri;

        public MediaContentObserver(Uri uri, Handler handler) {
            super(handler);
            this.mContentUri = uri;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            ScreenShotManager.this.handleMediaContentChange(this.mContentUri);
        }
    }

    /* access modifiers changed from: private */
    public void handleMediaContentChange(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = this.mContentResolver.query(uri, MEDIA_PROJECTIONS, (String) null, (String[]) null, "date_added desc limit 1");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    handleMediaRowData(cursor.getString(cursor.getColumnIndex("_data")), cursor.getLong(cursor.getColumnIndex("datetaken")));
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                    return;
                }
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(e);
            if (cursor == null || cursor.isClosed()) {
            }
        } catch (Throwable th2) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th2;
        }
    }

    private void handleMediaRowData(String str, long j) {
        IScreenShotListener iScreenShotListener;
        long j2 = 0;
        while (!isScreenShot(str) && j2 <= 500) {
            j2 += 100;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Log.e(e);
            }
        }
        if (isScreenShot(str) && (iScreenShotListener = this.mScreenShotListener) != null) {
            iScreenShotListener.onScreenShot();
        }
    }

    private boolean isScreenShot(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String contains : KEYWORDS) {
            if (lowerCase.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public void init(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.mContentResolver = contentResolver;
        this.mScreenShotListener = iScreenShotListener;
        HandlerThread handlerThread = new HandlerThread(SCREEN_SHOT_OBSERVER);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mInternalObserver = new MediaContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mHandler);
        this.mExternalObserver = new MediaContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mHandler);
    }

    public void register() {
        this.mContentResolver.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.mInternalObserver);
        this.mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.mExternalObserver);
    }

    public void unRegister() {
        this.mContentResolver.unregisterContentObserver(this.mInternalObserver);
        this.mContentResolver.unregisterContentObserver(this.mExternalObserver);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
