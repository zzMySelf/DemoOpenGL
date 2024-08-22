package fe.fe.ggg.qw.qw;

import com.baidu.android.util.soloader.SoLoader;
import com.baidu.perf.signal.register.NativeSignalCapture;
import com.baidu.perf.signal.register.OnNativeANRListener;

public class qw {
    static {
        SoLoader.load(fe.fe.ddd.i.qw.qw.qw(), "signal-register");
    }

    public static void ad(int i2) {
        synchronized (NativeSignalCapture.sANRMutex) {
            NativeSignalCapture.registerANR(i2);
        }
    }

    public static void qw(OnNativeANRListener onNativeANRListener) {
        NativeSignalCapture.addANRListener(onNativeANRListener);
    }
}
