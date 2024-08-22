package fe.th.ad.fe;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.duxiaoman.imageloader.listener.IImageLoaderListener;
import com.duxiaoman.imageloader.strategy.IImageLoader;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class qw implements IImageLoader {

    public class ad implements IImageLoaderListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ IImageLoaderListener f5106ad;
        public final /* synthetic */ fe.th.ad.qw qw;

        public ad(qw qwVar, fe.th.ad.qw qwVar2, IImageLoaderListener iImageLoaderListener) {
            this.qw = qwVar2;
            this.f5106ad = iImageLoaderListener;
        }

        public final void onCompleted(Bitmap bitmap) {
            fe.th.ad.rg.qw.qw("ImageLoader", "Fresco showImage success::" + this.qw.rg());
            this.qw.ad().setImageBitmap(bitmap);
            IImageLoaderListener iImageLoaderListener = this.f5106ad;
            if (iImageLoaderListener != null) {
                iImageLoaderListener.onCompleted((Bitmap) null);
            }
        }

        public final void onFailure(Exception exc) {
            fe.th.ad.rg.qw.qw("ImageLoader", "Fresco showImage fail::" + this.qw.rg());
            if (this.qw.fe() != -1) {
                this.qw.ad().setImageResource(this.qw.fe());
            }
            IImageLoaderListener iImageLoaderListener = this.f5106ad;
            if (iImageLoaderListener != null) {
                iImageLoaderListener.onFailure(exc);
            }
            String str = "showImage ";
            if (exc != null) {
                str = str + exc.getMessage();
            }
            fe.th.ad.de.qw.qw(this.qw.rg(), str);
        }
    }

    /* renamed from: fe.th.ad.fe.qw$qw  reason: collision with other inner class name */
    public class C0220qw extends BaseBitmapReferenceDataSubscriber {
        public C0220qw(qw qwVar, String str, IImageLoaderListener iImageLoaderListener) {
        }
    }

    public qw() {
        Class.forName("com.facebook.drawee.backends.pipeline.Fresco");
    }

    public void ad(@NonNull Context context, @NonNull String str, IImageLoaderListener iImageLoaderListener) {
        if (str == null || context == null) {
            if (iImageLoaderListener != null) {
                iImageLoaderListener.onFailure(new Exception("url and context can't be null"));
            }
            fe.th.ad.de.qw.qw(str, "downloadImage url and context can't be null");
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), context).subscribe(new C0220qw(this, str, iImageLoaderListener), UiThreadImmediateExecutorService.getInstance());
    }

    public void init(Context context) {
        if (!Fresco.hasBeenInitialized()) {
            Fresco.initialize(context, ImagePipelineConfig.newBuilder(context.getApplicationContext()).setBitmapsConfig(Bitmap.Config.RGB_565).setDownsampleEnabled(true).setResizeAndRotateEnabledForNetwork(true).setProgressiveJpegConfig(new SimpleProgressiveJpegConfig()).build());
        }
    }

    public void qw(fe.th.ad.qw qwVar) {
        if (qwVar != null) {
            if (qwVar.rg() == null || qwVar.ad() == null || qwVar.qw() == null) {
                if (qwVar.de() != null) {
                    qwVar.de().onFailure(new Exception("invalid params:url and context and iamgeview canot be null"));
                }
                fe.th.ad.de.qw.qw(qwVar.rg(), "showImage invalid params:url and context and iamgeview canot be null");
                return;
            }
            ad(qwVar.qw(), qwVar.rg(), new ad(this, qwVar, qwVar.de()));
        }
    }
}
