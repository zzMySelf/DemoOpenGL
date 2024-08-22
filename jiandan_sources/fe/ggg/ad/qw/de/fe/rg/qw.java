package fe.ggg.ad.qw.de.fe.rg;

import androidx.lifecycle.LifecycleOwner;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<List<BluetoothInfo>, Unit> f7577ad;
    @NotNull
    public final LifecycleOwner qw;

    public qw(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function1<? super List<BluetoothInfo>, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "life");
        Intrinsics.checkNotNullParameter(function1, "observer");
        this.qw = lifecycleOwner;
        this.f7577ad = function1;
    }

    @NotNull
    public final Function1<List<BluetoothInfo>, Unit> ad() {
        return this.f7577ad;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && Intrinsics.areEqual((Object) this.f7577ad, (Object) qwVar.f7577ad);
    }

    public int hashCode() {
        return (this.qw.hashCode() * 31) + this.f7577ad.hashCode();
    }

    @NotNull
    public final LifecycleOwner qw() {
        return this.qw;
    }

    @NotNull
    public String toString() {
        return "LifeObserver(life=" + this.qw + ", observer=" + this.f7577ad + ')';
    }
}
