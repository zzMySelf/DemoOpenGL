package fe.th.ad;

import android.content.Context;
import com.duxiaoman.imageloader.statistic.ImageSdkSAListener;
import com.duxiaoman.imageloader.strategy.IImageLoader;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f5103ad = false;

    /* renamed from: de  reason: collision with root package name */
    public ImageSdkSAListener f5104de;
    public IImageLoader qw = null;

    public static class qw {
        public static final ad qw = new ad();
    }

    public ad() {
        try {
            this.qw = new fe.th.ad.fe.ad();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                this.qw = new fe.th.ad.fe.qw();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static ad ad() {
        return qw.qw;
    }

    public void de(Context context) {
        if (!this.f5103ad) {
            this.qw.init(context);
            if (this.qw != null) {
                this.f5103ad = true;
            }
        }
    }

    public void fe(Context context, ImageSdkSAListener imageSdkSAListener) {
        de(context);
        if (imageSdkSAListener != null) {
            this.f5104de = imageSdkSAListener;
        }
    }

    public ImageSdkSAListener qw() {
        return this.f5104de;
    }

    public void rg(qw qwVar) {
        if (qwVar == null) {
            return;
        }
        if (this.f5103ad) {
            this.qw.qw(qwVar);
        } else if (qwVar.de() != null) {
            qwVar.de().onFailure(new Exception("not inited"));
        }
    }
}
