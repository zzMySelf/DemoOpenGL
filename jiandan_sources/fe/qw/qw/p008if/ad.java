package fe.qw.qw.p008if;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.th;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fe.qw.qw.if.ad  reason: invalid package */
public class ad {

    /* renamed from: rg  reason: collision with root package name */
    public static final Object f3265rg = new Object();

    /* renamed from: ad  reason: collision with root package name */
    public String f3266ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public ImageAssetDelegate f3267de;

    /* renamed from: fe  reason: collision with root package name */
    public final Map<String, th> f3268fe;
    public final Context qw;

    public ad(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, th> map) {
        this.f3266ad = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f3266ad;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f3266ad += '/';
            }
        }
        if (!(callback instanceof View)) {
            fe.de("LottieDrawable must be inside of a view for images to work.");
            this.f3268fe = new HashMap();
            this.qw = null;
            return;
        }
        this.qw = ((View) callback).getContext();
        this.f3268fe = map;
        fe(imageAssetDelegate);
    }

    public boolean ad(Context context) {
        return (context == null && this.qw == null) || this.qw.equals(context);
    }

    public final Bitmap de(String str, @Nullable Bitmap bitmap) {
        synchronized (f3265rg) {
            this.f3268fe.get(str).th(bitmap);
        }
        return bitmap;
    }

    public void fe(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.f3267de = imageAssetDelegate;
    }

    @Nullable
    public Bitmap qw(String str) {
        th thVar = this.f3268fe.get(str);
        if (thVar == null) {
            return null;
        }
        Bitmap qw2 = thVar.qw();
        if (qw2 != null) {
            return qw2;
        }
        ImageAssetDelegate imageAssetDelegate = this.f3267de;
        if (imageAssetDelegate != null) {
            Bitmap qw3 = imageAssetDelegate.qw(thVar);
            if (qw3 != null) {
                de(str, qw3);
            }
            return qw3;
        }
        String ad2 = thVar.ad();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!ad2.startsWith("data:") || ad2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f3266ad)) {
                    AssetManager assets = this.qw.getAssets();
                    Bitmap bitmap = yj.m232if(BitmapFactory.decodeStream(assets.open(this.f3266ad + ad2), (Rect) null, options), thVar.rg(), thVar.de());
                    de(str, bitmap);
                    return bitmap;
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e) {
                fe.fe("Unable to open asset.", e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(ad2.substring(ad2.indexOf(44) + 1), 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                de(str, decodeByteArray);
                return decodeByteArray;
            } catch (IllegalArgumentException e2) {
                fe.fe("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
    }

    @Nullable
    public Bitmap rg(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            th thVar = this.f3268fe.get(str);
            Bitmap qw2 = thVar.qw();
            thVar.th((Bitmap) null);
            return qw2;
        }
        Bitmap qw3 = this.f3268fe.get(str).qw();
        de(str, bitmap);
        return qw3;
    }
}
