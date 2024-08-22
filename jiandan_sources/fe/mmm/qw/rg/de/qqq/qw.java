package fe.mmm.qw.rg.de.qqq;

import android.content.Context;
import com.tera.scan.business.textrecognition.tools.ScanTextRecognizerInternal;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ScanTextRecognizerInternal f8287ad;
    @NotNull
    public final Context qw;

    public qw(@NotNull Context context, @NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "lanType");
        Intrinsics.checkNotNullParameter(list, "imageList");
        this.qw = context;
        this.f8287ad = new ScanTextRecognizerInternal(context, str, list);
    }

    @NotNull
    public final Map<Integer, String> ad() {
        return this.f8287ad.ad();
    }

    public final void de(@NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "resultCallback");
        this.f8287ad.de(function1);
    }

    public final void qw() {
        this.f8287ad.qw();
    }
}
