package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.a;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ImageLoader {
    public static final boolean a = ApollonConstants.DEBUG;
    public static final String b = ImageLoader.class.getSimpleName();
    public static final String c = "baidu/wallet/image_cache";
    public static final long d = 864000000;
    public static final int e = 3;
    public static final int f = 6;
    public static final int g = 10;
    public static ImageLoader h = null;

    /* renamed from: i  reason: collision with root package name */
    public Context f700i;
    public b j;
    public a k;
    public ImageProcessor l;
    public ThreadPoolExecutor m = null;

    public interface OnGetBitmapListener {
        boolean needCancel(String str, Object obj);

        void onError(String str, Object obj);

        void onGetBitmap(String str, Object obj, Bitmap bitmap);
    }

    public ImageLoader(Context context) {
        this.f700i = DxmApplicationContextImpl.getApplicationContext(context);
        this.l = new ImageProcessor(this.f700i);
        this.j = new b();
        this.k = new a(this.f700i, c, new a.C0027a() {
            public List<File> a(File file) {
                if (!file.exists() || !file.isDirectory()) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                File[] listFiles = file.listFiles();
                long currentTimeMillis = System.currentTimeMillis() - ImageLoader.d;
                for (File file2 : listFiles) {
                    if (file2.lastModified() < currentTimeMillis) {
                        linkedList.add(file2);
                    }
                }
                return linkedList;
            }
        });
    }

    public static ImageLoader getInstance(Context context) {
        boolean z = a;
        if (h == null) {
            synchronized (ImageLoader.class) {
                if (h == null) {
                    h = new ImageLoader(DxmApplicationContextImpl.getApplicationContext(context));
                }
            }
        }
        return h;
    }

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        if (a(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                boolean z = a;
                onGetBitmapListener.onGetBitmap(str, obj, bitmapFromMemCache);
                return;
            }
            getBitmapFromDiskOrNet(str, onGetBitmapListener, obj, i2);
        }
    }

    public void getBitmapFromDiskOrNet(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        final String str2 = str;
        final OnGetBitmapListener onGetBitmapListener2 = onGetBitmapListener;
        final Object obj2 = obj;
        final int i3 = i2;
        a((Runnable) new Runnable() {
            public void run() {
                if (!ImageLoader.this.a(str2, onGetBitmapListener2, obj2, i3)) {
                    ImageLoader.this.b(str2, onGetBitmapListener2, obj2, i3);
                }
            }
        });
    }

    public Bitmap getBitmapFromMemCache(String str) {
        boolean z = a;
        if (!a(str)) {
            return null;
        }
        return this.j.a(str);
    }

    public Bitmap getBitmapFromMemCacheOrDeskSynch(String str, Object obj, int i2) {
        if (!a(str)) {
            return null;
        }
        Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
        if (bitmapFromMemCache != null) {
            boolean z = a;
            return bitmapFromMemCache;
        }
        Bitmap a2 = a(str, obj, i2);
        if (a2 != null) {
            boolean z2 = a;
        }
        return a2;
    }

    private void a(Runnable runnable) {
        if (this.m == null) {
            this.m = new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    AtomicInteger atomicInteger = new AtomicInteger(1);
                    return new Thread(runnable, "ImageLoader #" + atomicInteger.getAndIncrement());
                }
            }, new ThreadPoolExecutor.DiscardOldestPolicy());
            if (ChannelUtils.isSpecailPackage()) {
                this.m.allowCoreThreadTimeOut(true);
            }
        }
        this.m.execute(runnable);
    }

    /* access modifiers changed from: private */
    public void b(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        byte[] bArr;
        if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
            boolean z = a;
            Context context = this.f700i;
            RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), ApollonConstants.HTTP_REQUEST_TYPE_IMAGE_LOAD);
            restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.a());
            Bitmap bitmap = null;
            try {
                bArr = (byte[]) restTemplate.a(str, (List<RestNameValuePair>) null, com.baidu.apollon.heartbeat.a.h, byte[].class);
            } catch (RestRuntimeException e2) {
                e2.printStackTrace();
                bArr = null;
            }
            if (bArr != null) {
                this.k.a(str, bArr);
                File a2 = this.k.a(str);
                if (a2 != null && a2.exists()) {
                    try {
                        bitmap = this.l.decode(a2, i2);
                    } catch (FileNotFoundException unused) {
                    }
                    if (bitmap != null) {
                        boolean z2 = a;
                        this.j.a(str, bitmap);
                        this.j.a();
                        if (onGetBitmapListener != null) {
                            onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                        }
                    } else if (onGetBitmapListener != null) {
                        onGetBitmapListener.onError(str, obj);
                    }
                } else if (onGetBitmapListener != null) {
                    onGetBitmapListener.onError(str, obj);
                }
            } else if (onGetBitmapListener != null) {
                onGetBitmapListener.onError(str, obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Bitmap bitmap;
        if (onGetBitmapListener != null && onGetBitmapListener.needCancel(str, obj)) {
            return true;
        }
        boolean z = a;
        File a2 = this.k.a(str);
        if (a2 == null || !a2.exists()) {
            return false;
        }
        boolean z2 = a;
        try {
            bitmap = this.l.decode(a2, i2);
        } catch (FileNotFoundException unused) {
            bitmap = null;
        }
        if (bitmap == null) {
            return false;
        }
        boolean z3 = a;
        this.j.a(str, bitmap);
        this.j.a();
        if (onGetBitmapListener != null) {
            onGetBitmapListener.onGetBitmap(str, obj, bitmap);
        }
        return true;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private Bitmap a(String str, Object obj, int i2) {
        boolean z = a;
        File a2 = this.k.a(str);
        Bitmap bitmap = null;
        if (a2 != null && a2.exists()) {
            boolean z2 = a;
            try {
                bitmap = this.l.decode(a2, i2);
            } catch (FileNotFoundException unused) {
            }
            if (bitmap != null) {
                boolean z3 = a;
                this.j.a(str, bitmap);
                this.j.a();
            }
        }
        return bitmap;
    }
}
