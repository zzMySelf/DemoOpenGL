package fe.mmm.qw.e.th;

import android.os.Looper;
import android.util.Printer;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.e.th.switch  reason: invalid class name */
public final class Cswitch implements ILooperNeedContext {
    public void qw(@Nullable Printer printer) {
        if (printer != null) {
            Looper.getMainLooper().setMessageLogging(printer);
        }
    }
}
