package com.baidu.searchbox.video.feedflow.common;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.assemble.provider.FeedVideoItemUnitProvider;
import com.baidu.searchbox.video.feedflow.detail.VideoItemStoreKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "reducers", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReducerPreCreator.kt */
final class ItemReducerPreCreator$preCreate$1 extends Lambda implements Function1<List<Reducer<CommonState>>, Unit> {
    public static final ItemReducerPreCreator$preCreate$1 INSTANCE = new ItemReducerPreCreator$preCreate$1();

    ItemReducerPreCreator$preCreate$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((List<Reducer<CommonState>>) (List) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(List<Reducer<CommonState>> reducers) {
        Intrinsics.checkNotNullParameter(reducers, "reducers");
        reducers.addAll(VideoItemStoreKt.collectItemReducer(new FeedVideoItemUnitProvider()));
    }
}
