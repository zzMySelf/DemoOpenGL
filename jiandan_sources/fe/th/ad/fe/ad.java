package fe.th.ad.fe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.duxiaoman.imageloader.listener.IImageLoaderListener;
import com.duxiaoman.imageloader.strategy.IImageLoader;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.request.RequestListener;
import com.dxmbumptech.glide.request.target.Target;
import fe.uk.qw.pf.fe.yj;
import fe.uk.qw.th;

public class ad implements IImageLoader {

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.th.ad.qw f5105ad;

        /* renamed from: fe.th.ad.fe.ad$qw$qw  reason: collision with other inner class name */
        public class C0219qw implements RequestListener<Drawable> {
            public C0219qw() {
            }

            public final boolean ad(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                fe.th.ad.rg.qw.qw("ImageLoader", "Glide showImage fail::" + qw.this.f5105ad.rg());
                IImageLoaderListener de2 = qw.this.f5105ad.de();
                if (de2 != null) {
                    de2.onFailure(glideException);
                }
                String str = "showImage ";
                if (glideException != null) {
                    str = str + glideException.getMessage();
                }
                fe.th.ad.de.qw.ad(qw.this.f5105ad.rg(), str);
                return false;
            }

            public final /* synthetic */ boolean qw(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
                fe.th.ad.rg.qw.qw("ImageLoader", "Glide showImage success::" + qw.this.f5105ad.rg());
                IImageLoaderListener de2 = qw.this.f5105ad.de();
                if (de2 == null) {
                    return false;
                }
                de2.onCompleted((Bitmap) null);
                return false;
            }
        }

        public qw(ad adVar, fe.th.ad.qw qwVar) {
            this.f5105ad = qwVar;
        }

        public final void run() {
            ((th) ((th) Glide.nn(this.f5105ad.qw()).ppp(this.f5105ad.rg()).t(this.f5105ad.fe())).th(yj.f5891de)).U(new C0219qw()).S(this.f5105ad.ad());
        }
    }

    public ad() {
        Class.forName("com.dxmbumptech.glide.Glide");
    }

    public void init(Context context) {
    }

    public void qw(fe.th.ad.qw qwVar) {
        if (qwVar != null) {
            if (TextUtils.isEmpty(qwVar.rg()) || qwVar.ad() == null || qwVar.qw() == null) {
                if (qwVar.de() != null) {
                    qwVar.de().onFailure(new Exception("invalid params:uri and ImageView and cotextcanot be null"));
                }
                fe.th.ad.de.qw.ad(qwVar.rg(), "showImage invalid params:uri and ImageView and cotext canot be null");
                return;
            }
            qwVar.ad().post(new qw(this, qwVar));
        }
    }
}
