package com.baidu.browser.talosbee;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.browser.searchtalos.impl.TLSSearchPageView;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/browser/talosbee/SearchTalosContainer$registerDataChannel$callback$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "data", "lib-search-talosbee_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTalosContainer.kt */
public final class SearchTalosContainer$registerDataChannel$callback$1 extends NAReceiverCallback {
    final /* synthetic */ SearchTalosContainer this$0;

    SearchTalosContainer$registerDataChannel$callback$1(SearchTalosContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String data) {
        if (!TextUtils.isEmpty(data) && Intrinsics.areEqual((Object) this.this$0.SEARCH_TALOS_BEE_ACTION, (Object) action)) {
            TLSSearchPageView access$getRnPageView$p = this.this$0.rnPageView;
            Integer pageId = access$getRnPageView$p != null ? Integer.valueOf(access$getRnPageView$p.getPageId()) : null;
            if (this.this$0.DEBUG) {
                Log.i(this.this$0.TAG, "onReceive data=" + data);
                Log.i(this.this$0.TAG, "rnPageView pageId=" + pageId);
            }
            try {
                JSONObject dataObj = new JSONObject(data);
                String string = dataObj.getString("pageid");
                Intrinsics.checkNotNullExpressionValue(string, "dataObj.getString(\"pageid\")");
                int currentPageId = Integer.parseInt(string);
                if (!TextUtils.equals(dataObj.getString("type"), this.this$0.CLICK_TALOS_GO_BACK)) {
                    return;
                }
                if (pageId != null) {
                    if (currentPageId == pageId.intValue()) {
                        this.this$0.goBack();
                    }
                }
            } catch (Exception e2) {
                if (this.this$0.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
