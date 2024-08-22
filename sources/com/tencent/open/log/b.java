package com.tencent.open.log;

import android.text.TextUtils;
import com.baidu.voyager.impl.constant.VoyagerConstant;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: ProGuard */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f5959a = d.C0104d.a("yy.MM.dd.HH");

    /* renamed from: b  reason: collision with root package name */
    private String f5960b = "Tracer.File";

    /* renamed from: c  reason: collision with root package name */
    private int f5961c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f5962d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f5963e = 4096;

    /* renamed from: f  reason: collision with root package name */
    private long f5964f = 10000;

    /* renamed from: g  reason: collision with root package name */
    private File f5965g;

    /* renamed from: h  reason: collision with root package name */
    private int f5966h = 10;

    /* renamed from: i  reason: collision with root package name */
    private String f5967i = VoyagerConstant.VOYAGER_FILE_META_SUFFIX;

    /* renamed from: j  reason: collision with root package name */
    private long f5968j = Long.MAX_VALUE;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        a(j2);
        d(i5);
        b(str2);
        b(j3);
    }

    public File[] a() {
        return c(System.currentTimeMillis());
    }

    private File[] c(long j2) {
        File b2 = b();
        String c2 = c(d(j2));
        try {
            b2 = new File(b2, c2);
        } catch (Throwable th2) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th2);
        }
        String b3 = l.b();
        File file = null;
        if (!TextUtils.isEmpty(b3) || b3 != null) {
            try {
                File file2 = new File(b3, c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, c2);
            } catch (Exception e2) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e2);
            }
        }
        return new File[]{b2, file};
    }

    private String d(long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(instance.getTime());
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + VoyagerConstant.VOYAGER_FILE_META_SUFFIX;
    }

    public File b() {
        File e2 = e();
        if (e2 != null) {
            e2.mkdirs();
        }
        return e2;
    }

    public String c() {
        return this.f5960b;
    }

    public void a(String str) {
        this.f5960b = str;
    }

    public void a(int i2) {
        this.f5961c = i2;
    }

    public void b(int i2) {
        this.f5962d = i2;
    }

    public int d() {
        return this.f5963e;
    }

    public void c(int i2) {
        this.f5963e = i2;
    }

    public void a(long j2) {
        this.f5964f = j2;
    }

    public File e() {
        return this.f5965g;
    }

    public void a(File file) {
        this.f5965g = file;
    }

    public int f() {
        return this.f5966h;
    }

    public void d(int i2) {
        this.f5966h = i2;
    }

    public void b(String str) {
        this.f5967i = str;
    }

    public void b(long j2) {
        this.f5968j = j2;
    }
}
