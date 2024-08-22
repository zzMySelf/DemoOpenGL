package com.dxmpay.apollon.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.idl.authority.AuthorityState;
import com.dlife.ctaccountapi.x;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.imagemanager.ImageLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@SuppressLint({"AppCompatCustomView"})
public class NetImageView extends ImageView {
    public static final boolean a = (ApollonConstants.DEBUG & true);
    public static String b = "ldpi";
    public static String c = "mdpi";
    public static String d = "hdpi";
    public static String e = "xhdpi";
    public static String f = "xxhdpi";
    public static String g = "xxxhdpi";
    public static String h = "tvdpi";

    /* renamed from: i  reason: collision with root package name */
    public static String f3955i = "density";
    public static Handler j;
    public static HashMap<String, Integer> k;
    public String l;
    public Drawable m;
    public Drawable n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3956o;
    public int p;
    public int q;
    public ImageView.ScaleType r;
    public boolean s = false;
    public int t;
    public ImageLoader.OnGetBitmapListener u = new qw(this);

    public static class qw implements ImageLoader.OnGetBitmapListener {
        public WeakReference<NetImageView> qw;

        public class ad implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ NetImageView f3957ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ String f3958th;

            public ad(qw qwVar, NetImageView netImageView, String str) {
                this.f3957ad = netImageView;
                this.f3958th = str;
            }

            public void run() {
                if (TextUtils.equals(this.f3957ad.l, this.f3958th)) {
                    this.f3957ad.onLoadUrlError(true);
                }
            }
        }

        /* renamed from: com.dxmpay.apollon.base.widget.NetImageView$qw$qw  reason: collision with other inner class name */
        public class C0181qw implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final /* synthetic */ NetImageView f3959ad;

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ String f3960th;

            /* renamed from: yj  reason: collision with root package name */
            public final /* synthetic */ Bitmap f3961yj;

            public C0181qw(qw qwVar, NetImageView netImageView, String str, Bitmap bitmap) {
                this.f3959ad = netImageView;
                this.f3960th = str;
                this.f3961yj = bitmap;
            }

            public void run() {
                this.f3959ad.setRemoteDrawable(this.f3960th, this.f3961yj);
            }
        }

        public qw(NetImageView netImageView) {
            this.qw = new WeakReference<>(netImageView);
        }

        public boolean needCancel(String str, Object obj) {
            WeakReference<NetImageView> weakReference = this.qw;
            boolean z = false;
            if (weakReference != null) {
                NetImageView netImageView = (NetImageView) weakReference.get();
                if (netImageView == null) {
                    return false;
                }
                if (netImageView.n != null || !TextUtils.equals(str, netImageView.l)) {
                    z = true;
                }
                if (NetImageView.a && z) {
                    "Canceled   url: " + str;
                }
            }
            return z;
        }

        public void onError(String str, Object obj) {
            NetImageView netImageView;
            if (NetImageView.a) {
                "getImage error: " + str;
                WeakReference<NetImageView> weakReference = this.qw;
                if (weakReference != null && (netImageView = (NetImageView) weakReference.get()) != null) {
                    netImageView.post(new ad(this, netImageView, str));
                }
            }
        }

        public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
            WeakReference<NetImageView> weakReference = this.qw;
            if (weakReference != null) {
                NetImageView netImageView = (NetImageView) weakReference.get();
                if (NetImageView.j != null && netImageView != null) {
                    NetImageView.j.post(new C0181qw(this, netImageView, str, bitmap));
                }
            }
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        k = hashMap;
        hashMap.put(b, 120);
        k.put(c, 160);
        k.put(h, 213);
        k.put(d, Integer.valueOf(AuthorityState.STATE_ERROR_NETWORK));
        k.put(e, Integer.valueOf(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP));
        k.put(f, 480);
        k.put(g, 640);
    }

    public NetImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setDensity(attributeSet);
        a(context);
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i2 = this.p;
            if (i2 != Integer.MIN_VALUE) {
                layoutParams.width = i2;
            }
            int i3 = this.q;
            if (i3 != Integer.MIN_VALUE) {
                layoutParams.height = i3;
            }
        }
    }

    private void setDensity(AttributeSet attributeSet) {
        Integer num;
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue((String) null, f3955i);
            if (!TextUtils.isEmpty(attributeValue) && (num = k.get(attributeValue.trim().toLowerCase())) != null) {
                this.t = num.intValue();
            }
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        Drawable drawable2;
        if (!hasRemoteDrawableDone() || (drawable2 = this.n) == null) {
            c();
            if (drawable != null) {
                super.setImageDrawable(drawable);
            }
            if (z) {
                requestLoadingRemoteImage();
                return;
            }
            return;
        }
        super.setImageDrawable(drawable2);
    }

    public boolean hasRemoteDrawableDone() {
        return this.n != null;
    }

    public void onDetachedFromWindow() {
        if (this.s) {
            releaseRemoteDrawable();
        }
        this.u = null;
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        if (!this.f3956o && !hasRemoteDrawableDone()) {
            requestLoadingRemoteImage();
        }
        super.onDraw(canvas);
    }

    public void onLoadUrlError(boolean z) {
    }

    public void releaseRemoteDrawable() {
        this.l = null;
        this.n = null;
        callRealSetImageDrawable(this.m, false);
    }

    public void requestLoadingRemoteImage() {
        if (hasRemoteDrawableDone()) {
            callRealSetImageDrawable(this.n, false);
        } else if (!this.f3956o && !TextUtils.isEmpty(this.l)) {
            ImageLoader.getInstance(getContext()).getBitmapFromDiskOrNet(this.l, this.u, (Object) null, this.t);
            this.f3956o = true;
        }
    }

    public void setDefaultSize(int i2, int i3) {
        this.p = i2;
        this.q = i3;
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        this.l = null;
    }

    public void setImageResource(int i2) {
        Drawable drawable = null;
        this.l = null;
        try {
            this.m = getResources().getDrawable(i2);
        } catch (Exception unused) {
            this.m = null;
        }
        Drawable drawable2 = this.m;
        if (drawable2 != null) {
            drawable = drawable2;
        }
        setImageDrawable(drawable);
    }

    public void setImageUrl(String str) {
        setImageUrl(str, true);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        c();
    }

    public void setReleaseWhenDetachFlag(boolean z) {
        this.s = z;
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        if (this.n == null && TextUtils.equals(str, this.l)) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.n = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
            "getImage ok: " + this.n.getIntrinsicWidth() + x.a + this.n.getIntrinsicHeight() + " url: " + str;
        }
    }

    public void setImageUrl(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.l = null;
        } else if (!TextUtils.equals(this.l, str)) {
            "req: " + z + " img url: " + str;
            this.l = str;
            this.n = null;
            this.f3956o = false;
            Bitmap bitmapFromMemCache = ImageLoader.getInstance(getContext()).getBitmapFromMemCache(this.l);
            if (bitmapFromMemCache != null) {
                setRemoteDrawable(this.l, bitmapFromMemCache);
            } else {
                callRealSetImageDrawable(this.m, z);
            }
        }
    }

    private void a(Context context) {
        if (j == null) {
            synchronized (NetImageView.class) {
                if (j == null) {
                    j = new Handler(context.getMainLooper());
                }
            }
        }
        if (this.r == null) {
            this.r = ImageView.ScaleType.FIT_CENTER;
        }
        this.p = Integer.MIN_VALUE;
        this.q = Integer.MIN_VALUE;
    }

    public NetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDensity(attributeSet);
        a(context);
    }

    public NetImageView(Context context) {
        super(context);
        a(context);
    }
}
