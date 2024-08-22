package com.tera.scan.file.selector.data.cursorloader;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.loader.content.CursorLoader;
import fe.mmm.qw.i.qw;

public class LocalImageSelectLoader extends CursorLoader {
    public String qw;

    public LocalImageSelectLoader(Context context, String str) {
        super(context);
        this.qw = str;
    }

    public Cursor loadInBackground() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] strArr = {"_id", "_data"};
        try {
            if (TextUtils.isEmpty(this.qw)) {
                return contentResolver.query(uri, strArr, (String) null, (String[]) null, "date_modified DESC");
            }
            return contentResolver.query(uri, strArr, "bucket_id =? ", new String[]{this.qw}, "date_modified DESC");
        } catch (SQLiteException e) {
            qw.ggg("LocalImageSelectLoader", "onLoadInBackground", e);
            return null;
        }
    }
}
