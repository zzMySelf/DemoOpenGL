package fe.mmm.qw.rrr.qw;

import android.content.Context;
import com.tera.scan.record.database.DocScanProviderHelper;
import fe.mmm.qw.p030switch.rg.qw;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static volatile DocScanProviderHelper f8306ad;
    @NotNull
    public static final ad qw = new ad();

    public final void ad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocScanProviderHelper docScanProviderHelper = f8306ad;
        if (docScanProviderHelper != null) {
            docScanProviderHelper.fe(context);
        }
        f8306ad = null;
    }

    @NotNull
    public final DocScanProviderHelper qw() {
        if (f8306ad == null) {
            synchronized (this) {
                if (f8306ad == null) {
                    f8306ad = new DocScanProviderHelper(qw.qw().getBduss());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        DocScanProviderHelper docScanProviderHelper = f8306ad;
        Intrinsics.checkNotNull(docScanProviderHelper);
        return docScanProviderHelper;
    }
}
