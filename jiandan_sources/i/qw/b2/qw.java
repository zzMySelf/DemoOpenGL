package i.qw.b2;

import com.baidu.android.common.others.lang.StringUtil;
import i.qw.when;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw extends when {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final fe f6113ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f6114th;

    public qw(@NotNull fe feVar, int i2) {
        this.f6113ad = feVar;
        this.f6114th = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        qw((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void qw(@Nullable Throwable th2) {
        this.f6113ad.vvv(this.f6114th);
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.f6113ad + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f6114th + ']';
    }
}
