package fe.mmm.qw.ddd;

import com.tera.scan.model.ImagePredictor;
import com.tera.scan.model.ImagePredictorCallback;

/* compiled from: lambda */
public final /* synthetic */ class yj implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ImagePredictorCallback f7743ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ ImagePredictor f7744th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ String f7745yj;

    public /* synthetic */ yj(ImagePredictorCallback imagePredictorCallback, ImagePredictor imagePredictor, String str) {
        this.f7743ad = imagePredictorCallback;
        this.f7744th = imagePredictor;
        this.f7745yj = str;
    }

    public final void run() {
        ImagePredictor.when(this.f7743ad, this.f7744th, this.f7745yj);
    }
}
