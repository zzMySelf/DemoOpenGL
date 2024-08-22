package fe.mmm.qw.p030switch.th.ad.qw;

import com.google.common.base.Ascii;
import i.qw.j;
import i.qw.j1;
import i.qw.u;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.switch.th.ad.qw.qw  reason: invalid package */
public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final CoroutineScope f8321ad = j.qw(j1.ad((Job) null, 1, (Object) null).plus(u.de()).plus(qw));
    @NotNull
    public static final CoroutineExceptionHandler qw = new C0292qw(CoroutineExceptionHandler.f6323de);

    /* renamed from: fe.mmm.qw.switch.th.ad.qw.qw$qw  reason: collision with other inner class name */
    public static final class C0292qw extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public C0292qw(CoroutineContext.Key key) {
            super(key);
        }

        public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2) {
            fe.mmm.qw.i.qw.ad("scan_coroutine", coroutineContext + Ascii.CASE_MASK + th2.getMessage());
        }
    }

    @NotNull
    public static final CoroutineScope qw() {
        return f8321ad;
    }
}
