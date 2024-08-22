package com.baidu.searchbox.paywall.search;

import com.baidu.searchbox.paywall.net.PaywallWebApi;
import com.baidu.searchbox.paywall.privatemodel.PaywallItem;
import com.baidu.searchbox.paywall.search.PaywallSearcher;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u00020\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/paywall/search/PaywallBasicSearcher$search$1", "Lcom/baidu/searchbox/paywall/net/PaywallWebApi$Callback;", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/paywall/privatemodel/PaywallItem;", "Lkotlin/collections/ArrayList;", "onFail", "", "errorMsg", "", "onSuccess", "result", "lib-paywall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaywallBasicSearcher.kt */
public final class PaywallBasicSearcher$search$1 implements PaywallWebApi.Callback<ArrayList<PaywallItem>> {
    final /* synthetic */ PaywallSearcher.Callback $callback;
    final /* synthetic */ String $keyWord;

    PaywallBasicSearcher$search$1(PaywallSearcher.Callback $callback2, String $keyWord2) {
        this.$callback = $callback2;
        this.$keyWord = $keyWord2;
    }

    public void onSuccess(ArrayList<PaywallItem> result) {
        this.$callback.onSearchSuccess(this.$keyWord, result);
    }

    public void onFail(String errorMsg) {
        this.$callback.onSearchFail(this.$keyWord);
    }
}
