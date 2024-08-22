package fe.mmm.qw.d.de;

import com.tera.scan.themeskin.loader.ISkinChange;
import com.tera.scan.themeskin.loader.ISkinChangeListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw implements ISkinChange {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final List<ISkinChangeListener> f7698ad = new ArrayList();
    @NotNull
    public static final qw qw = new qw();

    public synchronized void ad(@NotNull ISkinChangeListener iSkinChangeListener) {
        Intrinsics.checkNotNullParameter(iSkinChangeListener, "o");
        if (f7698ad.contains(iSkinChangeListener)) {
            f7698ad.remove(iSkinChangeListener);
        }
    }

    public synchronized void qw(@NotNull ISkinChangeListener iSkinChangeListener) {
        Intrinsics.checkNotNullParameter(iSkinChangeListener, "o");
        if (!f7698ad.contains(iSkinChangeListener)) {
            f7698ad.add(iSkinChangeListener);
        }
    }
}
