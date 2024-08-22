package com.baidu.searchbox.video.feedflow.clearscreen;

import com.baidu.searchbox.video.feedflow.clearscreen.statistic.ClearScreenFrom;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/ClearScreenChangeModel;", "", "isClearScreen", "", "from", "Lcom/baidu/searchbox/video/feedflow/clearscreen/statistic/ClearScreenFrom;", "(ZLcom/baidu/searchbox/video/feedflow/clearscreen/statistic/ClearScreenFrom;)V", "getFrom", "()Lcom/baidu/searchbox/video/feedflow/clearscreen/statistic/ClearScreenFrom;", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenNewState.kt */
public final class ClearScreenChangeModel {
    private final ClearScreenFrom from;
    private final boolean isClearScreen;

    public ClearScreenChangeModel(boolean isClearScreen2, ClearScreenFrom from2) {
        Intrinsics.checkNotNullParameter(from2, "from");
        this.isClearScreen = isClearScreen2;
        this.from = from2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearScreenChangeModel(boolean z, ClearScreenFrom clearScreenFrom, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? ClearScreenFrom.OTHER : clearScreenFrom);
    }

    public final boolean isClearScreen() {
        return this.isClearScreen;
    }

    public final ClearScreenFrom getFrom() {
        return this.from;
    }
}
