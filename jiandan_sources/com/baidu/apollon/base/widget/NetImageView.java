package com.baidu.apollon.base.widget;

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
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.idl.authority.AuthorityState;
import com.dlife.ctaccountapi.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NetImageView extends ImageView {
    public static final boolean a = (ApollonConstants.DEBUG & true);
    public static final String b = "NetImageView";
    public static String c = "ldpi";
    public static String d = "mdpi";
    public static String e = "hdpi";
    public static String f = "xhdpi";
    public static String g = "xxhdpi";
    public static String h = "xxxhdpi";

    /* renamed from: i  reason: collision with root package name */
    public static String f692i = "tvdpi";
    public static String j = "density";
    public static Handler k;
    public static HashMap<String, Integer> l;
    public String m;
    public Drawable n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f693o;
    public boolean p;
    public int q;
    public int r;
    public ImageView.ScaleType s;
    public boolean t = false;
    public int u;
    public ImageLoader.OnGetBitmapListener v = new a(this);

    public static class a implements ImageLoader.OnGetBitmapListener {
        public WeakReference<NetImageView> a;

        public a(NetImageView netImageView) {
            this.a = new WeakReference<>(netImageView);
        }

        public boolean needCancel(String str, Object obj) {
            WeakReference<NetImageView> weakReference = this.a;
            boolean z = false;
            if (weakReference != null) {
                NetImageView netImageView = (NetImageView) weakReference.get();
                if (netImageView == null) {
                    return false;
                }
                if (netImageView.f693o != null || !TextUtils.equals(str, netImageView.m)) {
                    z = true;
                }
                if (NetImageView.a && z) {
                    "Canceled   url: " + str;
                }
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
            r3 = (com.baidu.apollon.base.widget.NetImageView) r3.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(final java.lang.String r2, java.lang.Object r3) {
            /*
                r1 = this;
                boolean r3 = com.baidu.apollon.base.widget.NetImageView.a
                if (r3 == 0) goto L_0x002b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "getImage error: "
                r3.append(r0)
                r3.append(r2)
                r3.toString()
                java.lang.ref.WeakReference<com.baidu.apollon.base.widget.NetImageView> r3 = r1.a
                if (r3 == 0) goto L_0x002b
                java.lang.Object r3 = r3.get()
                com.baidu.apollon.base.widget.NetImageView r3 = (com.baidu.apollon.base.widget.NetImageView) r3
                if (r3 != 0) goto L_0x0023
                return
            L_0x0023:
                com.baidu.apollon.base.widget.NetImageView$a$2 r0 = new com.baidu.apollon.base.widget.NetImageView$a$2
                r0.<init>(r3, r2)
                r3.post(r0)
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.base.widget.NetImageView.a.onError(java.lang.String, java.lang.Object):void");
        }

        public void onGetBitmap(final String str, Object obj, final Bitmap bitmap) {
            WeakReference<NetImageView> weakReference = this.a;
            if (weakReference != null) {
                final NetImageView netImageView = (NetImageView) weakReference.get();
                if (NetImageView.k != null && netImageView != null) {
                    NetImageView.k.post(new Runnable() {
                        public void run() {
                            netImageView.setRemoteDrawable(str, bitmap);
                        }
                    });
                }
            }
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        l = hashMap;
        hashMap.put(c, 120);
        l.put(d, 160);
        l.put(f692i, 213);
        l.put(e, Integer.valueOf(AuthorityState.STATE_ERROR_NETWORK));
        l.put(f, Integer.valueOf(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP));
        l.put(g, 480);
        l.put(h, 640);
    }

    public NetImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setDensity(attributeSet);
        a(context);
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i2 = this.q;
            if (i2 != Integer.MIN_VALUE) {
                layoutParams.width = i2;
            }
            int i3 = this.r;
            if (i3 != Integer.MIN_VALUE) {
                layoutParams.height = i3;
            }
        }
    }

    private void setDensity(AttributeSet attributeSet) {
        Integer num;
        if (attributeSet != null) {
            String attributeValue = attributeSet.getAttributeValue((String) null, j);
            if (!TextUtils.isEmpty(attributeValue) && (num = l.get(attributeValue.trim().toLowerCase())) != null) {
                this.u = num.intValue();
            }
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        Drawable drawable2;
        if (!hasRemoteDrawableDone() || (drawable2 = this.f693o) == null) {
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
        return this.f693o != null;
    }

    public void onDetachedFromWindow() {
        if (this.t) {
            releaseRemoteDrawable();
        }
        this.v = null;
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        if (!this.p && !hasRemoteDrawableDone()) {
            requestLoadingRemoteImage();
        }
        super.onDraw(canvas);
    }

    public void onLoadUrlError(boolean z) {
    }

    public void releaseRemoteDrawable() {
        this.m = null;
        this.f693o = null;
        callRealSetImageDrawable(this.n, false);
    }

    public void requestLoadingRemoteImage() {
        if (hasRemoteDrawableDone()) {
            callRealSetImageDrawable(this.f693o, false);
        } else if (!this.p && !TextUtils.isEmpty(this.m)) {
            ImageLoader.getInstance(getContext()).getBitmapFromDiskOrNet(this.m, this.v, (Object) null, this.u);
            this.p = true;
        }
    }

    public void setDefaultSize(int i2, int i3) {
        this.q = i2;
        this.r = i3;
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        this.m = null;
    }

    public void setImageResource(int i2) {
        Drawable drawable = null;
        this.m = null;
        try {
            this.n = getResources().getDrawable(i2);
        } catch (Exception unused) {
            this.n = null;
        }
        Drawable drawable2 = this.n;
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
        this.t = z;
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        if (this.f693o == null && TextUtils.equals(str, this.m)) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.f693o = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
            if (a) {
                "getImage ok: " + this.f693o.getIntrinsicWidth() + x.a + this.f693o.getIntrinsicHeight() + " url: " + str;
            }
        }
    }

    public void setImageUrl(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.m = null;
        } else if (!TextUtils.equals(this.m, str)) {
            if (a) {
                "req: " + z + " img url: " + str;
            }
            this.m = str;
            this.f693o = null;
            this.p = false;
            Bitmap bitmapFromMemCache = ImageLoader.getInstance(getContext()).getBitmapFromMemCache(this.m);
            if (bitmapFromMemCache != null) {
                setRemoteDrawable(this.m, bitmapFromMemCache);
            } else {
                callRealSetImageDrawable(this.n, z);
            }
        }
    }

    private void a(Context context) {
        if (k == null) {
            synchronized (NetImageView.class) {
                if (k == null) {
                    k = new Handler(context.getMainLooper());
                }
            }
        }
        if (this.s == null) {
            this.s = ImageView.ScaleType.FIT_CENTER;
        }
        this.q = Integer.MIN_VALUE;
        this.r = Integer.MIN_VALUE;
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
