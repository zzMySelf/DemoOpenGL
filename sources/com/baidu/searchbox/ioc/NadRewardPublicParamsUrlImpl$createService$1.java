package com.baidu.searchbox.ioc;

import com.baidu.nadcore.lp.reward.ioc.INadRewardPublicParamsUrl;
import com.baidu.searchbox.feed.ad.INadDevInfoProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/ioc/NadRewardPublicParamsUrlImpl$createService$1", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardPublicParamsUrl;", "getPublicParamsUrl", "", "url", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardPublicParamsUrlImpl.kt */
public final class NadRewardPublicParamsUrlImpl$createService$1 implements INadRewardPublicParamsUrl {
    NadRewardPublicParamsUrlImpl$createService$1() {
    }

    public String getPublicParamsUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String commonUrl = INadDevInfoProvider.Impl.get().getCommonUrl(url);
        Intrinsics.checkNotNullExpressionValue(commonUrl, "get().getCommonUrl(url)");
        return commonUrl;
    }
}
