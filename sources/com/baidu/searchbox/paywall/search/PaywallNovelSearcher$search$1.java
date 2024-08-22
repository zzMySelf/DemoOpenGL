package com.baidu.searchbox.paywall.search;

import com.baidu.searchbox.paywall.callback.IPayWallData;
import com.baidu.searchbox.paywall.privatemodel.PaywallItem;
import com.baidu.searchbox.paywall.search.PaywallSearcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/paywall/search/PaywallNovelSearcher$search$1", "Lcom/baidu/searchbox/paywall/callback/IPayWallData;", "onFetchDataAsync", "", "paywallItemList", "", "Lcom/baidu/searchbox/paywall/privatemodel/PaywallItem;", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallNovelSearcher.kt */
public final class PaywallNovelSearcher$search$1 implements IPayWallData {
    final /* synthetic */ PaywallSearcher.Callback $callback;
    final /* synthetic */ String $keyWord;

    PaywallNovelSearcher$search$1(String $keyWord2, PaywallSearcher.Callback $callback2) {
        this.$keyWord = $keyWord2;
        this.$callback = $callback2;
    }

    public void onFetchDataAsync(List<PaywallItem> paywallItemList) {
        ArrayList result = new ArrayList();
        if (paywallItemList != null) {
            for (PaywallItem item : paywallItemList) {
                String str = item.title;
                int i2 = -1;
                if ((str != null ? StringsKt.indexOf$default((CharSequence) str, this.$keyWord, 0, false, 6, (Object) null) : -1) < 0) {
                    String str2 = item.author;
                    if (str2 != null) {
                        i2 = StringsKt.indexOf$default((CharSequence) str2, this.$keyWord, 0, false, 6, (Object) null);
                    }
                    if (i2 < 0) {
                    }
                }
                result.add(item);
            }
        }
        this.$callback.onSearchSuccess(this.$keyWord, result);
    }
}
