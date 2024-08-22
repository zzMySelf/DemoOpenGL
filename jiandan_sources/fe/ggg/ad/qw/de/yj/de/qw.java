package fe.ggg.ad.qw.de.yj.de;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.Logger;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.united.core.debug.DevelopException;
import com.mars.united.core.os.pagedata.loader.DataLoader;
import fe.ggg.ad.qw.ad.ad;
import fe.ggg.ad.qw.de.yj.qw.qw;
import java.lang.ref.WeakReference;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

public final class qw<T, V extends fe.ggg.ad.qw.de.yj.qw.qw> extends Handler {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final WeakReference<DataLoader<T, V>> f7593ad;
    public final long qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qw(long j, @NotNull WeakReference<DataLoader<T, V>> weakReference, @NotNull Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(weakReference, "dataLoaderRef");
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.qw = j;
        this.f7593ad = weakReference;
    }

    public final void ad() {
        if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw("updateDataVersion"), (Object) null, 1, (Object) null);
        }
        removeMessages(3);
        sendMessageDelayed(obtainMessage(3), this.qw);
    }

    public void dispatchMessage(@NotNull Message message) {
        DevelopException developException;
        Intrinsics.checkNotNullParameter(message, "msg");
        super.dispatchMessage(message);
        DataLoader dataLoader = (DataLoader) this.f7593ad.get();
        if (dataLoader != null) {
            int i2 = message.what;
            if (i2 == 2) {
                Bundle data = message.getData();
                int i3 = -1;
                int i4 = data == null ? -1 : data.getInt("PARAM_TRIGGER_POSITION");
                Bundle data2 = message.getData();
                int i5 = data2 == null ? -1 : data2.getInt("PARAM_DATA_LOAD_START_POSITION");
                Bundle data3 = message.getData();
                if (data3 != null) {
                    i3 = data3.getInt("PARAM_DATA_LOAD_END_POSITION");
                }
                if (qw(i4, i5, i3)) {
                    dataLoader.loadDataRange$core_release(i4, new IntRange(i5, i3));
                } else if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
                    String str = " data inValid triggerPosition" + i4 + " startPosition" + i5 + " endPosition" + i3;
                    if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
                        if (str instanceof Throwable) {
                            developException = new DevelopException((Throwable) str);
                        } else {
                            developException = new DevelopException(String.valueOf(str));
                        }
                        throw developException;
                    }
                }
            } else if (i2 == 3) {
                dataLoader.upgradeDataVersion$core_release();
            } else if (Logger.INSTANCE.getEnable() && fe.ggg.ad.qw.ad.qw.qw.ad()) {
                if (!(message.getCallback() != null)) {
                    String str2 = "can not handle " + Integer.valueOf(message.what) + Ascii.CASE_MASK + message;
                    if (str2.length() == 0) {
                        StackTraceElement[] stackTrace = new Exception().getStackTrace();
                        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                        str2 = "开发异常\n" + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 0)) + 10 + ((StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTrace, 1));
                    }
                    throw new DevelopException(str2);
                }
            }
        } else if (Logger.INSTANCE.getEnable()) {
            LoggerKt.d$default(ad.qw(Intrinsics.stringPlus("loader is null, real=", dataLoader)), (Object) null, 1, (Object) null);
        }
    }

    public final boolean qw(int i2, int i3, int i4) {
        return i2 >= 0 && i3 >= 0 && i4 >= 0 && i4 >= i3;
    }
}
