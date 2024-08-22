package com.baidu.searchbox.video.feedflow.flow.hotbutton;

import com.baidu.searchbox.feed.detail.arch.SlotComponentUnit;
import com.baidu.searchbox.feed.detail.arch.UiComponent;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/hotbutton/HotButtonUnit;", "Lcom/baidu/searchbox/feed/detail/arch/SlotComponentUnit;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createComponent", "Lcom/baidu/searchbox/feed/detail/arch/UiComponent;", "createMiddlewares", "", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "createReducer", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotButtonUnit.kt */
public final class HotButtonUnit implements SlotComponentUnit<CommonState> {
    public static final HotButtonUnit INSTANCE = new HotButtonUnit();

    private HotButtonUnit() {
    }

    public UiComponent createComponent() {
        return new HotButtonComponent();
    }

    public List<Middleware<CommonState>> createMiddlewares() {
        return CollectionsKt.listOf(new HotButtonStatisticMiddleware());
    }

    public Reducer<CommonState> createReducer() {
        return new HotButtonReducer();
    }
}
