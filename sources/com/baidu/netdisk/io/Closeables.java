package com.baidu.netdisk.io;

import android.database.Cursor;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

public class Closeables {
    private static final String TAG = "Closeables";

    private Closeables() {
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void close(Closeable closeable, boolean swallowIOException) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                if (swallowIOException) {
                    Log.d(TAG, "IOException thrown while closing Closeable.", e2);
                    return;
                }
                throw e2;
            }
        }
    }

    public static void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
