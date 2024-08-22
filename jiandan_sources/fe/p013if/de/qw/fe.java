package fe.p013if.de.qw;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: fe.if.de.qw.fe  reason: invalid package */
public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static qw f4602ad = new qw("writer");
    public static qw qw = new qw("loop");

    /* renamed from: fe.if.de.qw.fe$qw */
    public static class qw {
        public Handler qw = null;

        public qw(String str) {
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.qw = new Handler(handlerThread.getLooper());
        }

        public Handler qw() {
            return this.qw;
        }
    }

    public static Handler ad() {
        return f4602ad.qw();
    }

    public static Handler qw() {
        return qw.qw();
    }
}
