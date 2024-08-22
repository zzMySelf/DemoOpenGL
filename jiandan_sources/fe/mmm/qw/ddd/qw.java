package fe.mmm.qw.ddd;

import com.tera.scan.model.ImageEnhance;
import com.tera.scan.model.callback.IImageEnhanceResult;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f7723ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ IImageEnhanceResult f7724th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ byte[] f7725yj;

    public /* synthetic */ qw(String str, IImageEnhanceResult iImageEnhanceResult, byte[] bArr) {
        this.f7723ad = str;
        this.f7724th = iImageEnhanceResult;
        this.f7725yj = bArr;
    }

    public final void run() {
        ImageEnhance.yj(this.f7723ad, this.f7724th, this.f7725yj);
    }
}
