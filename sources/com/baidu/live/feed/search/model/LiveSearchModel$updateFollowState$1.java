package com.baidu.live.feed.search.model;

import com.baidu.live.feed.search.model.LiveSearchModel;
import com.baidu.live.framework.net.LiveNetCallback;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001JE\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"com/baidu/live/feed/search/model/LiveSearchModel$updateFollowState$1", "Lcom/baidu/live/framework/net/LiveNetCallback;", "", "onNetResponse", "", "res", "Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", "resData", "params", "", "", "grFeedList", "", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/List;)V", "onParseResponseInBackground", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;)Ljava/lang/Integer;", "lib-live-feed-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveSearchModel.kt */
public final class LiveSearchModel$updateFollowState$1 implements LiveNetCallback<Integer> {
    final /* synthetic */ LiveSearchModel.OnDataLoadCallback<Boolean> $callback;
    final /* synthetic */ boolean $isFollow;

    LiveSearchModel$updateFollowState$1(LiveSearchModel.OnDataLoadCallback<Boolean> $callback2, boolean $isFollow2) {
        this.$callback = $callback2;
        this.$isFollow = $isFollow2;
    }

    public Integer onParseResponseInBackground(NetResponse res) {
        boolean z = false;
        if (res != null) {
            try {
                if (res.isSuccessful()) {
                    z = true;
                }
            } catch (Exception e2) {
                return null;
            }
        }
        if (z) {
            String str = res.decodedResponseStr;
            Intrinsics.checkNotNullExpressionValue(str, "res.decodedResponseStr");
            if (!StringsKt.isBlank(str)) {
                int error = new JSONObject(res.decodedResponseStr).optInt("errno");
                if (res != null) {
                    int i2 = res.netErrorCode;
                }
                return Integer.valueOf(error);
            }
        }
        return null;
    }

    public void onNetResponse(NetResponse res, Integer resData, Map<String, String> params, List<String> grFeedList) {
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z = false;
        if (res != null && !res.isSuccessful()) {
            z = true;
        }
        if (z) {
            this.$callback.onFail(res.responseCode, res.exception);
        } else if (resData != null && resData.intValue() == 0) {
            this.$callback.onSuccess(Boolean.valueOf(this.$isFollow));
        } else if (res == null) {
            this.$callback.onFail(-111, "网络不给力，请稍后重试");
        } else {
            this.$callback.onFail(res.responseCode, res.exception);
        }
    }
}
