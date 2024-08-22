package fe.mmm.qw.ddd;

import com.tera.scan.model.ImageCropPredictor;
import com.tera.scan.model.callback.IImageCropResult;

/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ IImageCropResult f7705ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f7706th;

    public /* synthetic */ de(IImageCropResult iImageCropResult, String str) {
        this.f7705ad = iImageCropResult;
        this.f7706th = str;
    }

    public final void run() {
        ImageCropPredictor.when(this.f7705ad, this.f7706th);
    }
}
