package fe.th.qw.qw.qw;

import android.os.HandlerThread;

public class de {
    public HandlerThread qw;

    public static class ad {
        public static de qw = new de();
    }

    public static de qw() {
        return ad.qw;
    }

    public HandlerThread ad() {
        return this.qw;
    }

    public de() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.qw = handlerThread;
        handlerThread.start();
        this.qw.setPriority(10);
    }
}
