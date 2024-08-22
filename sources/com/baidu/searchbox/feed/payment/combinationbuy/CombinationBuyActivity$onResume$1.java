package com.baidu.searchbox.feed.payment.combinationbuy;

import android.text.TextUtils;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.feed.payment.DataChannelConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/feed/payment/combinationbuy/CombinationBuyActivity$onResume$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "params", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CombinationBuyActivity.kt */
public final class CombinationBuyActivity$onResume$1 extends NAReceiverCallback {
    final /* synthetic */ CombinationBuyActivity this$0;

    CombinationBuyActivity$onResume$1(CombinationBuyActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String params) {
        String str = params;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(str, "params");
        try {
            JSONObject jsonObject = new JSONObject(str);
            Iterator iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                JSONArray array = jsonObject.getJSONArray(iterator.next());
                int index = 0;
                int length = array.length();
                while (index < length) {
                    JSONObject itemObject = array.getJSONObject(index);
                    String type = itemObject.optString("type");
                    String status = itemObject.optString("status");
                    String nid = itemObject.optString("nid");
                    boolean isContainCamp = TextUtils.equals(itemObject.optString(DataChannelConstants.KEY_IS_CONTAIN_TRAIN), "1");
                    String payExt = itemObject.optString("pay_ext");
                    JSONObject jsonObject2 = jsonObject;
                    if (TextUtils.equals(DataChannelConstants.TYPE_PAY_RESULT, type) && TextUtils.equals(status, "1") && !TextUtils.isEmpty(nid)) {
                        CbToolBarFacet access$getToolBarFacet$p = this.this$0.toolBarFacet;
                        if (access$getToolBarFacet$p != null) {
                            access$getToolBarFacet$p.processPaySuccess(isContainCamp, payExt);
                        }
                        CbProToolBarFacet access$getToolProBarFacet$p = this.this$0.toolProBarFacet;
                        if (access$getToolProBarFacet$p != null) {
                            access$getToolProBarFacet$p.processPaySuccess(isContainCamp, payExt);
                        }
                    }
                    index++;
                    String str2 = params;
                    jsonObject = jsonObject2;
                }
                String str3 = params;
            }
        } catch (Exception e2) {
        }
    }
}
