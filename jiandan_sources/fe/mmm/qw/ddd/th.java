package fe.mmm.qw.ddd;

import com.tera.scan.model.ImageEnhance;
import com.tera.scan.model.callback.IImageEnhanceResult;

/* compiled from: lambda */
public final /* synthetic */ class th implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ImageEnhance f7733ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f7734th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ IImageEnhanceResult f7735uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ String f7736yj;

    public /* synthetic */ th(ImageEnhance imageEnhance, String str, String str2, IImageEnhanceResult iImageEnhanceResult) {
        this.f7733ad = imageEnhance;
        this.f7734th = str;
        this.f7736yj = str2;
        this.f7735uk = iImageEnhanceResult;
    }

    public final void run() {
        ImageEnhance.pf(this.f7733ad, this.f7734th, this.f7736yj, this.f7735uk);
    }
}
