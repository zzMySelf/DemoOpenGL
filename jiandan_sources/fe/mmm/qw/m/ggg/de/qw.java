package fe.mmm.qw.m.ggg.de;

import com.baidu.pyramid.annotation.component.Holder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.webview.hybrid.action.IActionManager;
import com.tera.scan.webview.hybrid.factory.HybridDomainCheck;
import com.tera.scan.webview.hybrid.factory.IHybridSupport;
import fe.fe.vvv.qw.qw.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("AutoInjectActionManager")
public final class qw implements IActionManager {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f8040ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public ListHolder<ad> f8041de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public Holder<HybridDomainCheck> f8042fe;
    @NotNull
    public final IHybridSupport qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final HashMap<String, fe.mmm.qw.m.ggg.qw.qw> f8043rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final List<String> f8044th;

    public qw(@NotNull IHybridSupport iHybridSupport, boolean z) {
        Intrinsics.checkNotNullParameter(iHybridSupport, "hybridSupport");
        fe();
        de();
        this.qw = iHybridSupport;
        this.f8040ad = z;
        this.f8043rg = new HashMap<>();
        this.f8044th = new ArrayList();
    }

    @Nullable
    public fe.mmm.qw.m.ggg.qw.qw ad(@Nullable String str) {
        T t;
        List<ad> qw2;
        T t2;
        fe.mmm.qw.m.ggg.qw.qw ad2;
        boolean z;
        LoggerKt.d$default("chooseHybridAction:" + str, (Object) null, 1, (Object) null);
        Iterator<T> it = this.f8044th.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) (String) t, (Object) str)) {
                break;
            }
        }
        if (((String) t) != null) {
            LoggerKt.d$default("disable action:" + str, (Object) null, 1, (Object) null);
            return null;
        }
        fe.mmm.qw.m.ggg.qw.qw qwVar = this.f8043rg.get(str);
        if (qwVar != null) {
            return qwVar;
        }
        LoggerKt.d$default("don't find,start create", (Object) null, 1, (Object) null);
        ListHolder<ad> listHolder = this.f8041de;
        if (listHolder == null || (qw2 = listHolder.qw()) == null) {
            return null;
        }
        Iterator<T> it2 = qw2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (!Intrinsics.areEqual((Object) ((ad) t2).qw(), (Object) str) || !this.f8040ad) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        ad adVar = (ad) t2;
        if (adVar == null || (ad2 = adVar.ad(this.qw)) == null) {
            return null;
        }
        LoggerKt.d$default("create suc:" + ad2, (Object) null, 1, (Object) null);
        if (str != null) {
            this.f8043rg.put(str, ad2);
        }
        return ad2;
    }

    public void de() {
        ad de2 = ad.de();
        this.f8041de = de2;
        de2.ad(new de());
    }

    public void fe() {
        fe.fe.vvv.qw.qw.qw ad2 = fe.fe.vvv.qw.qw.qw.ad();
        this.f8042fe = ad2;
        ad2.qw(new fe());
    }

    public boolean qw(@Nullable String str) {
        HybridDomainCheck hybridDomainCheck;
        Holder<HybridDomainCheck> holder = this.f8042fe;
        if (holder == null || (hybridDomainCheck = holder.get()) == null) {
            return true;
        }
        return hybridDomainCheck.check(str);
    }

    @NotNull
    public final qw rg(@NotNull String str, @NotNull fe.mmm.qw.m.ggg.qw.qw qwVar) {
        Intrinsics.checkNotNullParameter(str, "actionName");
        Intrinsics.checkNotNullParameter(qwVar, "action");
        this.f8043rg.put(str, qwVar);
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qw(IHybridSupport iHybridSupport, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iHybridSupport, (i2 & 2) != 0 ? true : z);
        fe();
        de();
    }
}
