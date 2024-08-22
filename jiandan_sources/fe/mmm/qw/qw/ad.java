package fe.mmm.qw.qw;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tera.scan.account.OnLoginCallBack;
import fe.mmm.qw.qw.rg.qw;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ad {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<qw> f8247ad = new MutableLiveData<>();
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Set<OnLoginCallBack> f8248de = new LinkedHashSet();
    @Nullable
    public qw qw;

    public static /* synthetic */ void yj(ad adVar, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                function1 = null;
            }
            adVar.th(function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logout");
    }

    @NotNull
    public final LiveData<qw> ad() {
        return this.f8247ad;
    }

    public final void de(@NotNull OnLoginCallBack onLoginCallBack) {
        Intrinsics.checkNotNullParameter(onLoginCallBack, "callBack");
        if (rg()) {
            onLoginCallBack.ad();
        }
        this.f8248de.add(onLoginCallBack);
    }

    @Nullable
    public final qw fe() {
        return this.qw;
    }

    public final void i() {
        for (OnLoginCallBack qw2 : this.f8248de) {
            qw2.qw();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m998if(@NotNull OnLoginCallBack onLoginCallBack) {
        Intrinsics.checkNotNullParameter(onLoginCallBack, "callBack");
        this.f8248de.remove(onLoginCallBack);
    }

    public final void o(@NotNull qw qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, "accountInfo");
        m999switch(qwVar);
        uk();
    }

    public void pf(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Nullable
    public final qw qw() {
        return this.qw;
    }

    public abstract boolean rg();

    /* renamed from: switch  reason: not valid java name */
    public void m999switch(@Nullable qw qwVar) {
        this.qw = qwVar;
        fe.mmm.qw.th.qw.th.p031switch.ad.de(this.f8247ad, qwVar);
    }

    public abstract void th(@Nullable Function1<? super Boolean, Unit> function1);

    public final void uk() {
        for (OnLoginCallBack ad2 : this.f8248de) {
            ad2.ad();
        }
    }

    public final void when(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        qw qwVar = this.qw;
        m999switch(qwVar != null ? qw.ad(qwVar, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, str, 2047, (Object) null) : null);
    }
}
