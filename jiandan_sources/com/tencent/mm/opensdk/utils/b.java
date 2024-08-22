package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {
    public static Context a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static ThreadPoolExecutor e = new ThreadPoolExecutor(c, d, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        c = availableProcessors + 1;
        d = (availableProcessors * 2) + 1;
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            inputStream = contentResolver.openInputStream(uri);
            if (inputStream == null) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return 0;
            }
            int available = inputStream.available();
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            return available;
        } catch (Exception e2) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            return 0;
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (a != null && str.startsWith("content")) {
            try {
                return a(a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int a(String str, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return str.length() <= 0 ? i2 : Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static boolean a(int i2) {
        return i2 == 36 || i2 == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }
}
