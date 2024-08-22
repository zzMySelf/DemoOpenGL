package com.baidu.android.util.io;

import android.database.Cursor;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;

public final class Closeables {
    public static final String TAG = "Closeables";

    public static void close(@Nullable Closeable closeable, boolean z) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                if (!z) {
                    throw e;
                }
            }
        }
    }

    public static void closeSafely(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
