package fe.mmm.qw.ddd;

import com.tera.scan.model.ImagePredictor;
import com.tera.scan.model.ImagePredictorCallback;
import java.util.ArrayList;

/* compiled from: lambda */
public final /* synthetic */ class rg implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ImagePredictor f7726ad;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7727i;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ArrayList f7728o;

    /* renamed from: pf  reason: collision with root package name */
    public final /* synthetic */ ImagePredictorCallback f7729pf;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f7730th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ int f7731uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ int f7732yj;

    public /* synthetic */ rg(ImagePredictor imagePredictor, String str, int i2, int i3, int i4, ArrayList arrayList, ImagePredictorCallback imagePredictorCallback) {
        this.f7726ad = imagePredictor;
        this.f7730th = str;
        this.f7732yj = i2;
        this.f7731uk = i3;
        this.f7727i = i4;
        this.f7728o = arrayList;
        this.f7729pf = imagePredictorCallback;
    }

    public final void run() {
        ImagePredictor.aaa(this.f7726ad, this.f7730th, this.f7732yj, this.f7731uk, this.f7727i, this.f7728o, this.f7729pf);
    }
}
