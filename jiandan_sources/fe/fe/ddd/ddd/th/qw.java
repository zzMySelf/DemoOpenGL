package fe.fe.ddd.ddd.th;

import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.upload.IBOSUploadListener;
import fe.fe.ddd.fe.qw.de;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile qw f1362ad;
    public ThreadPoolExecutor qw = new ThreadPoolExecutor(1, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: fe.fe.ddd.ddd.th.qw$qw  reason: collision with other inner class name */
    public class C0073qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1363ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ File f1364th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ IBOSUploadListener f1365yj;

        public C0073qw(qw qwVar, String str, File file, IBOSUploadListener iBOSUploadListener) {
            this.f1363ad = str;
            this.f1364th = file;
            this.f1365yj = iBOSUploadListener;
        }

        public void run() {
            fe.fe.ddd.fe.qw.qw fe2 = de.de().fe("fetchlog", this.f1363ad, this.f1364th);
            o oVar = new o(fe2.de(), fe2.ad());
            IBOSUploadListener iBOSUploadListener = this.f1365yj;
            if (iBOSUploadListener != null) {
                iBOSUploadListener.qw(oVar);
            }
        }
    }

    static {
        AppConfig.rg();
    }

    public static qw qw() {
        if (f1362ad == null) {
            synchronized (qw.class) {
                if (f1362ad == null) {
                    f1362ad = new qw();
                }
            }
        }
        return f1362ad;
    }

    public void ad(@NonNull String str, @NonNull File file, IBOSUploadListener iBOSUploadListener) {
        this.qw.execute(new C0073qw(this, str, file, iBOSUploadListener));
    }
}
