package com.tera.scan.utils.listdiff.updatecallback;

import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.j.nn.de.ad;
import fe.mmm.qw.j.nn.de.de;
import fe.mmm.qw.j.nn.de.qw;
import fe.mmm.qw.j.nn.de.rg;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0011\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R;\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEventDispatcher;", "E", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateCallback;", "()V", "oldListEventQueue", "Ljava/util/LinkedList;", "Lcom/tera/scan/utils/listdiff/updatecallback/ListUpdateEvent;", "onDispatchEvent", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "getOnDispatchEvent", "()Lkotlin/jvm/functions/Function2;", "setOnDispatchEvent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "dispatchEvent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onChanged", "position", "", "count", "payload", "onInserted", "oldPosition", "newPosition", "onMoved", "fromPosition", "toPosition", "onRemoved", "x-util_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("ListUpdateEventDispatcher")
public final class ListUpdateEventDispatcher<E> implements ListUpdateCallback<E> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public Function2<? super de, ? super Continuation<? super Unit>, ? extends Object> f7453ad = new ListUpdateEventDispatcher$onDispatchEvent$1((Continuation<? super ListUpdateEventDispatcher$onDispatchEvent$1>) null);
    @NotNull
    public final LinkedList<de> qw = new LinkedList<>();

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object ad(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher$dispatchEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher$dispatchEvent$1 r0 = (com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher$dispatchEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher$dispatchEvent$1 r0 = new com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher$dispatchEvent$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r2 = r0.L$0
            com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher r2 = (com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0039
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
        L_0x0039:
            java.util.LinkedList<fe.mmm.qw.j.nn.de.de> r6 = r2.qw
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0059
            java.util.LinkedList<fe.mmm.qw.j.nn.de.de> r6 = r2.qw
            java.lang.Object r6 = r6.poll()
            fe.mmm.qw.j.nn.de.de r6 = (fe.mmm.qw.j.nn.de.de) r6
            if (r6 == 0) goto L_0x0039
            kotlin.jvm.functions.Function2<? super fe.mmm.qw.j.nn.de.de, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r4 = r2.f7453ad
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r4.invoke(r6, r0)
            if (r6 != r1) goto L_0x0039
            return r1
        L_0x0059:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.utils.listdiff.updatecallback.ListUpdateEventDispatcher.ad(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void onChanged(int i2, int i3, @Nullable Object obj) {
        this.qw.offer(new qw(i2, i3, (Object) null, 4, (DefaultConstructorMarker) null));
    }

    public void onRemoved(int i2, int i3) {
        this.qw.offer(new rg(i2, i3));
    }

    public void qw(int i2, int i3, int i4) {
        this.qw.offer(new ad(i2, i3, i4));
    }
}
