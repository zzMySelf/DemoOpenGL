package com.baidu.searchbox.feed.model.gson.mapper;

import com.baidu.searchbox.feed.model.FeedBar;
import com.baidu.searchbox.feed.model.gson.bean.ForwardBean;
import com.baidu.searchbox.feed.model.gson.bean.ShareBean;
import com.baidu.searchbox.feed.model.gson.bean.TrinityBean;
import com.baidu.searchbox.feed.model.gson.bean.TrinityFastForwardBean;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/mapper/FeedBarTrinityMapper;", "", "()V", "map", "", "input", "Lcom/baidu/searchbox/feed/model/gson/bean/TrinityBean;", "output", "Lcom/baidu/searchbox/feed/model/FeedBar;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBarMapper.kt */
public final class FeedBarTrinityMapper {
    public static final FeedBarTrinityMapper INSTANCE = new FeedBarTrinityMapper();

    private FeedBarTrinityMapper() {
    }

    @JvmStatic
    public static final void map(TrinityBean input, FeedBar output) {
        Intrinsics.checkNotNullParameter(output, BindingXConstants.KEY_INTERPOLATER_OUTPUT);
        if (input != null) {
            if (output.trinity == null) {
                output.trinity = new FeedBar.Trinity();
            }
            FeedBar.Trinity trinity = output.trinity;
            trinity.totalCount = input.getTotalCount();
            trinity.text = input.getText();
            ShareBean share = input.getShare();
            FeedBar.Share share2 = trinity.share;
            Intrinsics.checkNotNullExpressionValue(share2, "trinity.share");
            FeedBarShareMapper.map(share, share2);
            ForwardBean forward = input.getForward();
            FeedBar.Forward forward2 = trinity.forward;
            Intrinsics.checkNotNullExpressionValue(forward2, "trinity.forward");
            FeedBarForwardMapper.map(forward, forward2);
            TrinityFastForwardBean fastForward = input.getFastForward();
            Intrinsics.checkNotNullExpressionValue(trinity, "trinity");
            FeedBarTrinityFastForwardtMapper.map(fastForward, trinity);
            FeedBarTrinityRecommendMapper.map(input.getRecommend(), trinity);
        }
    }
}
