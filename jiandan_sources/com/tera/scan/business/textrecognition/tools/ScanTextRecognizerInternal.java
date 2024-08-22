package com.tera.scan.business.textrecognition.tools;

import android.content.Context;
import com.tera.scan.business.textrecognition.network.NetworkRepository;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0011J/\u0010\u0012\u001a\u00020\u000f2'\u0010\u0013\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tera/scan/business/textrecognition/tools/ScanTextRecognizerInternal;", "", "context", "Landroid/content/Context;", "lanType", "", "imageList", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "resultMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "dispose", "", "getResultMap", "", "start", "resultCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "textList", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanTextRecognizerInternal {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String> f6822ad = new ConcurrentHashMap<>();
    @NotNull
    public final List<String> qw;

    public ScanTextRecognizerInternal(@NotNull Context context, @NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "lanType");
        Intrinsics.checkNotNullParameter(list, "imageList");
        this.qw = list;
    }

    @NotNull
    public final Map<Integer, String> ad() {
        return this.f6822ad;
    }

    public final void de(@NotNull Function1<? super List<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "resultCallback");
        if (this.qw.isEmpty()) {
            function1.invoke(CollectionsKt__CollectionsKt.emptyList());
        } else {
            new NetworkRepository().qw(this.qw.get(0), new ScanTextRecognizerInternal$start$1(function1));
        }
    }

    public final void qw() {
        this.f6822ad.clear();
    }
}
