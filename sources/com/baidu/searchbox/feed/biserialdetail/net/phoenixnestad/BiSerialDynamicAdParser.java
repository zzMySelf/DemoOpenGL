package com.baidu.searchbox.feed.biserialdetail.net.phoenixnestad;

import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.biserialdetail.content.ad.DynamicDetailBannerAdManagerKt;
import com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.BiSerialDynamicAdModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedRuntimeStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/net/phoenixnestad/BiSerialDynamicAdParser;", "", "()V", "parse", "Lcom/baidu/searchbox/feed/biserialdetail/model/phoenixnestad/BiSerialDynamicAdModel;", "responseString", "", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialDynamicAdParser.kt */
public final class BiSerialDynamicAdParser {
    public static final BiSerialDynamicAdParser INSTANCE = new BiSerialDynamicAdParser();

    private BiSerialDynamicAdParser() {
    }

    public final BiSerialDynamicAdModel parse(String responseString) {
        Intrinsics.checkNotNullParameter(responseString, "responseString");
        Object parse = FeedApi.DataParsers.defaultFlowModelConfig().channelId(AdUtil.FEED_DYNAMIC_DETAIL_BANNER).business(FeedRuntimeStatus.BUSINESS_DYNAMIC_DETAIL_BANNER).cmd(DynamicDetailBannerAdManagerKt.DYNAMIC_DETAIL_BANNER_AD_CMD).build().parse(responseString);
        return new BiSerialDynamicAdModel(parse instanceof FeedFlowModel ? (FeedFlowModel) parse : null, PNAdModelParser.INSTANCE.parse(responseString));
    }
}
