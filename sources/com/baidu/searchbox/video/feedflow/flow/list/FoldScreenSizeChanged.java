package com.baidu.searchbox.video.feedflow.flow.list;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/list/FoldScreenSizeChanged;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "old", "Lkotlin/Pair;", "", "new", "(Lkotlin/Pair;Lkotlin/Pair;)V", "getNew", "()Lkotlin/Pair;", "getOld", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: FlowActionManifest.kt */
public final class FoldScreenSizeChanged implements Action {

    /* renamed from: new  reason: not valid java name */
    private final Pair<Integer, Integer> f24new;
    private final Pair<Integer, Integer> old;

    public FoldScreenSizeChanged(Pair<Integer, Integer> old2, Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(old2, "old");
        Intrinsics.checkNotNullParameter(pair, "new");
        this.old = old2;
        this.f24new = pair;
    }

    public final Pair<Integer, Integer> getNew() {
        return this.f24new;
    }

    public final Pair<Integer, Integer> getOld() {
        return this.old;
    }
}
