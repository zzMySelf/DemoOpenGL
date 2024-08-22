package com.baidu.apollon.imagemanager;

import android.content.Context;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.FileCopyUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class a {
    public static final long a = 52428800;
    public final C0027a b;
    public final String c;
    public File d;
    public long e;

    /* renamed from: com.baidu.apollon.imagemanager.a$a  reason: collision with other inner class name */
    public interface C0027a {
        List<File> a(File file);
    }

    public a(Context context, String str, C0027a aVar) {
        this(context, str, "", aVar);
    }

    public static synchronized void a(File file) {
        synchronized (a.class) {
            if (file != null) {
                if (!file.isDirectory()) {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.mkdirs();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                return;
            }
        }
        return;
    }

    private void b() {
        if (this.e < 0) {
            this.e = a - c();
        }
    }

    private long c() {
        File[] listFiles = this.d.listFiles();
        long j = 0;
        if (listFiles != null && listFiles.length > 0) {
            for (File length : listFiles) {
                j += length.length();
            }
        }
        return j;
    }

    public a(Context context, String str, String str2, C0027a aVar) {
        this.e = Long.MIN_VALUE;
        this.c = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                this.d = new File(externalFilesDir, str);
            } else {
                this.d = new File(context.getCacheDir(), str);
            }
        } else {
            this.d = new File(context.getCacheDir(), str);
        }
        if (!this.d.exists()) {
            this.d.mkdirs();
        }
        this.b = aVar;
    }

    private String b(String str) {
        return String.valueOf(str.hashCode()) + this.c;
    }

    public static void a(byte[] bArr, File file) {
        try {
            FileCopyUtils.copy(bArr, file);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, byte[] bArr) {
        C0027a aVar;
        List<File> a2;
        File a3 = a(str);
        a(a3.getParentFile());
        a(bArr, a3);
        b();
        long length = this.e - a(str).length();
        if (!(length >= 0 || (aVar = this.b) == null || (a2 = aVar.a(this.d)) == null)) {
            for (File next : a2) {
                length += next.length();
                next.delete();
            }
        }
        this.e = length;
    }

    public File a(String str) {
        File file = new File(this.d, b(str));
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
        return file;
    }

    public void a() {
        File[] listFiles = this.d.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }
}
