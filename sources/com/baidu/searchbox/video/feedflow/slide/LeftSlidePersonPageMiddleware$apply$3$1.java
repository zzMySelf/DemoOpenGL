package com.baidu.searchbox.video.feedflow.slide;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.router.RouterAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlidePersonPageMiddleware.kt */
final class LeftSlidePersonPageMiddleware$apply$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $cmd;
    final /* synthetic */ Store<CommonState> $store;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LeftSlidePersonPageMiddleware$apply$3$1(Store<CommonState> store, String str) {
        super(0);
        this.$store = store;
        this.$cmd = str;
    }

    public final void invoke() {
        this.$store.dispatch(new RouterAction(this.$cmd));
    }
}
