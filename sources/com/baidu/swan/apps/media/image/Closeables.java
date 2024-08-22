package com.baidu.swan.apps.media.image;

import android.database.Cursor;

public final class Closeables {
    public static void closeSafely(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e2) {
            }
        }
    }
}
