package fe.mmm.qw.ddd;

import com.tera.scan.model.CropInfo;
import com.tera.scan.model.ImageCropPredictor;
import com.tera.scan.model.callback.IImageCropResult;

/* compiled from: lambda */
public final /* synthetic */ class fe implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ImageCropPredictor f7707ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ CropInfo f7708th;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ IImageCropResult f7709yj;

    public /* synthetic */ fe(ImageCropPredictor imageCropPredictor, CropInfo cropInfo, IImageCropResult iImageCropResult) {
        this.f7707ad = imageCropPredictor;
        this.f7708th = cropInfo;
        this.f7709yj = iImageCropResult;
    }

    public final void run() {
        ImageCropPredictor.ddd(this.f7707ad, this.f7708th, this.f7709yj);
    }
}
