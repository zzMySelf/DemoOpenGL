package com.baidu.netdisk.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.loader.content.CursorLoader;
import com.baidu.netdisk.db.cursor.IThumbUrlCacheable;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;

public class SafeCursorLoader extends CursorLoader {
    private static final String TAG = "SafeCursorLoader";
    private IThumbUrlCacheable mCacher;
    private Uri mUri;

    public SafeCursorLoader(Context context) {
        super(context);
    }

    public SafeCursorLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
        this.mUri = uri;
    }

    /* access modifiers changed from: protected */
    public final Cursor onLoadInBackground() {
        Cursor cursor = null;
        try {
            cursor = (Cursor) super.onLoadInBackground();
        } catch (SQLiteException e2) {
            NetDiskLog.w(TAG, "onLoadInBackground", e2);
        } catch (SecurityException e3) {
            NetDiskLog.w(TAG, "onLoadInBackground", e3);
        } catch (IllegalArgumentException e4) {
            NetDiskLog.w(TAG, "onLoadInBackground", e4);
        }
        IThumbUrlCacheable iThumbUrlCacheable = this.mCacher;
        if (!(iThumbUrlCacheable == null || cursor == null)) {
            iThumbUrlCacheable.cache(cursor);
        }
        return cursor;
    }

    public void setICacheable(IThumbUrlCacheable cacheable) {
        if (this.mUri != null) {
            this.mCacher = cacheable;
        }
    }
}
