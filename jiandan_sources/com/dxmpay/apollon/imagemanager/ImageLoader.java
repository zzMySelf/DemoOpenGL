package com.dxmpay.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.ChannelUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import fe.i.qw.fe.qw;
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

    /* renamed from: th  reason: collision with root package name */
    public static final boolean f3988th = ApollonConstants.DEBUG;

    /* renamed from: uk  reason: collision with root package name */
    public static ImageLoader f3989uk = null;

    /* renamed from: yj  reason: collision with root package name */
    public static final String f3990yj = ImageLoader.class.getSimpleName();

    /* renamed from: ad  reason: collision with root package name */
    public b f3991ad;

    /* renamed from: de  reason: collision with root package name */
    public fe.i.qw.fe.qw f3992de;

    /* renamed from: fe  reason: collision with root package name */
    public ImageProcessor f3993fe;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public ThreadPoolExecutor f3994rg = null;

    public interface OnGetBitmapListener {
        boolean needCancel(String str, Object obj);

        void onError(String str, Object obj);

        void onGetBitmap(String str, Object obj, Bitmap bitmap);
    }

    public class ad implements ThreadFactory {
        public ad(ImageLoader imageLoader) {
        }

        public Thread newThread(Runnable runnable) {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            return new Thread(runnable, "DxmImageLoader #" + atomicInteger.getAndIncrement());
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f3995ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ OnGetBitmapListener f3997th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f3998uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Object f3999yj;

        public de(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
            this.f3995ad = str;
            this.f3997th = onGetBitmapListener;
            this.f3999yj = obj;
            this.f3998uk = i2;
        }

        public void run() {
            if (!ImageLoader.this.rg(this.f3995ad, this.f3997th, this.f3999yj, this.f3998uk)) {
                ImageLoader.this.yj(this.f3995ad, this.f3997th, this.f3999yj, this.f3998uk);
            }
        }
    }

    public class qw implements qw.C0196qw {
        public qw(ImageLoader imageLoader) {
        }

        public List<File> a(File file) {
            if (!file.exists() || !file.isDirectory()) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            File[] listFiles = file.listFiles();
            long currentTimeMillis = System.currentTimeMillis() - com.baidu.apollon.imagemanager.ImageLoader.d;
            for (File file2 : listFiles) {
                if (file2.lastModified() < currentTimeMillis) {
                    linkedList.add(file2);
                }
            }
            return linkedList;
        }
    }

    public ImageLoader(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.qw = applicationContext;
        this.f3993fe = new ImageProcessor(applicationContext);
        this.f3991ad = new b();
        this.f3992de = new fe.i.qw.fe.qw(this.qw, "dxmpay/wallet/image_cache", new qw(this));
    }

    public static ImageLoader getInstance(Context context) {
        boolean z = f3988th;
        if (f3989uk == null) {
            synchronized (ImageLoader.class) {
                if (f3989uk == null) {
                    f3989uk = new ImageLoader(context.getApplicationContext());
                }
            }
        }
        return f3989uk;
    }

    public final void ad(Runnable runnable) {
        if (this.f3994rg == null) {
            this.f3994rg = new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ad(this), new ThreadPoolExecutor.DiscardOldestPolicy());
            if (ChannelUtils.isSpecailPackage()) {
                this.f3994rg.allowCoreThreadTimeOut(true);
            }
        }
        this.f3994rg.execute(runnable);
    }

    public final boolean fe(String str) {
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

    public void getBitmap(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        if (fe(str)) {
            Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
            if (bitmapFromMemCache != null) {
                boolean z = f3988th;
                onGetBitmapListener.onGetBitmap(str, obj, bitmapFromMemCache);
                return;
            }
            getBitmapFromDiskOrNet(str, onGetBitmapListener, obj, i2);
        }
    }

    public void getBitmapFromDiskOrNet(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        ad(new de(str, onGetBitmapListener, obj, i2));
    }

    public Bitmap getBitmapFromMemCache(String str) {
        boolean z = f3988th;
        if (!fe(str)) {
            return null;
        }
        return this.f3991ad.qw(str);
    }

    public Bitmap getBitmapFromMemCacheOrDeskSynch(String str, Object obj, int i2) {
        if (!fe(str)) {
            return null;
        }
        Bitmap bitmapFromMemCache = getBitmapFromMemCache(str);
        if (bitmapFromMemCache != null) {
            boolean z = f3988th;
            return bitmapFromMemCache;
        }
        Bitmap qw2 = qw(str, obj, i2);
        if (qw2 != null) {
            boolean z2 = f3988th;
        }
        return qw2;
    }

    public final Bitmap qw(String str, Object obj, int i2) {
        boolean z = f3988th;
        File qw2 = this.f3992de.qw(str);
        Bitmap bitmap = null;
        if (qw2 != null && qw2.exists()) {
            boolean z2 = f3988th;
            try {
                bitmap = this.f3993fe.decode(qw2, i2);
            } catch (FileNotFoundException unused) {
            }
            if (bitmap != null) {
                boolean z3 = f3988th;
                this.f3991ad.rg(str, bitmap);
                this.f3991ad.fe();
            }
        }
        return bitmap;
    }

    public final boolean rg(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        Bitmap bitmap;
        if (onGetBitmapListener != null && onGetBitmapListener.needCancel(str, obj)) {
            return true;
        }
        boolean z = f3988th;
        File qw2 = this.f3992de.qw(str);
        if (qw2 == null || !qw2.exists()) {
            return false;
        }
        boolean z2 = f3988th;
        try {
            bitmap = this.f3993fe.decode(qw2, i2);
        } catch (FileNotFoundException unused) {
            bitmap = null;
        }
        if (bitmap == null) {
            return false;
        }
        boolean z3 = f3988th;
        this.f3991ad.rg(str, bitmap);
        this.f3991ad.fe();
        if (onGetBitmapListener != null) {
            onGetBitmapListener.onGetBitmap(str, obj, bitmap);
        }
        return true;
    }

    public final void yj(String str, OnGetBitmapListener onGetBitmapListener, Object obj, int i2) {
        byte[] bArr;
        if (onGetBitmapListener == null || !onGetBitmapListener.needCancel(str, obj)) {
            boolean z = f3988th;
            Context context = this.qw;
            RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), ApollonConstants.HTTP_REQUEST_TYPE_IMAGE_LOAD);
            restTemplate.setMessageConverter(new fe.i.qw.th.qw.qw());
            Bitmap bitmap = null;
            try {
                bArr = (byte[]) restTemplate.getForObject(str, (List<RestNameValuePair>) null, a.h, byte[].class);
            } catch (RestRuntimeException e) {
                LogUtil.e(f3990yj, e.getMessage(), e);
                bArr = null;
            }
            if (bArr != null) {
                this.f3992de.fe(str, bArr);
                File qw2 = this.f3992de.qw(str);
                if (qw2 != null && qw2.exists()) {
                    try {
                        bitmap = this.f3993fe.decode(qw2, i2);
                    } catch (FileNotFoundException unused) {
                    }
                    if (bitmap != null) {
                        boolean z2 = f3988th;
                        this.f3991ad.rg(str, bitmap);
                        this.f3991ad.fe();
                        if (onGetBitmapListener != null) {
                            onGetBitmapListener.onGetBitmap(str, obj, bitmap);
                        }
                    }
                }
            }
        }
    }
}
