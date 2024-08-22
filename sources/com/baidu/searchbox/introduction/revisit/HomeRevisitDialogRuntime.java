package com.baidu.searchbox.introduction.revisit;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/introduction/revisit/HomeRevisitDialogRuntime;", "", "()V", "EMPTY", "com/baidu/searchbox/introduction/revisit/HomeRevisitDialogRuntime$EMPTY$1", "Lcom/baidu/searchbox/introduction/revisit/HomeRevisitDialogRuntime$EMPTY$1;", "getHomeRevisitDialogContext", "Lcom/baidu/searchbox/introduction/revisit/IHomeRevisitDialog;", "lib-home-introduction-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeRevisitDialogRuntime.kt */
public final class HomeRevisitDialogRuntime {
    private static final HomeRevisitDialogRuntime$EMPTY$1 EMPTY = new HomeRevisitDialogRuntime$EMPTY$1();
    public static final HomeRevisitDialogRuntime INSTANCE = new HomeRevisitDialogRuntime();

    private HomeRevisitDialogRuntime() {
    }

    public final IHomeRevisitDialog getHomeRevisitDialogContext() {
        return new HomeRevisitDialog();
    }
}
