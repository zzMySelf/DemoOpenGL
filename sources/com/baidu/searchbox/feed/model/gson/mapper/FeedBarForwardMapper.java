package com.baidu.searchbox.feed.model.gson.mapper;

import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.gson.bean.ForwardBean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/mapper/FeedBarForwardMapper;", "", "()V", "map", "", "input", "Lcom/baidu/searchbox/feed/model/gson/bean/ForwardBean;", "forward", "Lcom/baidu/searchbox/feed/model/FeedBar$Forward;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBarMapper.kt */
public final class FeedBarForwardMapper {
    public static final FeedBarForwardMapper INSTANCE = new FeedBarForwardMapper();

    private FeedBarForwardMapper() {
    }

    @JvmStatic
    public static final void map(ForwardBean input, FeedBar.Forward forward) {
        Intrinsics.checkNotNullParameter(forward, "forward");
        if (input != null) {
            forward.count = input.getCount();
            forward.schema = input.getSchema();
            forward.text = input.getText();
        }
    }
}
