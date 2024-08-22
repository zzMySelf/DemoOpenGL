package com.baidu.searchbox.utils;

import com.baidu.searchbox.ad.exp.AdPolicyFeed;
import com.baidu.searchbox.ad.position.placehelper.IAdRequestCallback;
import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/utils/NadFeedHelper$requestAd$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/feed/model/FeedFlowModel;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "feedFlowModel", "i", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-ad-feed_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadFeedHelper.kt */
public final class NadFeedHelper$requestAd$responseCallback$1 extends ResponseCallback<FeedFlowModel> {
    final /* synthetic */ IAdRequestCallback<NadAsyncFeedBaseModel> $callback;
    final /* synthetic */ NadFeedHelper this$0;

    NadFeedHelper$requestAd$responseCallback$1(NadFeedHelper $receiver, IAdRequestCallback<NadAsyncFeedBaseModel> $callback2) {
        this.this$0 = $receiver;
        this.$callback = $callback2;
    }

    public FeedFlowModel parseResponse(Response response, int i2) {
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody body = response.body();
        String body2 = body != null ? body.string() : null;
        if (body2 == null) {
            body2 = "";
        }
        return (FeedFlowModel) FeedApi.DataParsers.defaultFlowModelConfig().cmd(this.this$0.getCmd()).isRestful(this.this$0.isRestful()).channelId(this.this$0.getAdListState().getChannelId()).build().parse(body2);
    }

    public void onSuccess(FeedFlowModel feedFlowModel, int i2) {
        ArrayList it;
        FeedPolicyModel feedPolicyModel;
        AdPolicyFeed adPolicyFeed;
        String placeId;
        FeedPolicyModel feedPolicyModel2;
        AdPolicyFeed adPolicyFeed2;
        String placeId2;
        NadFeedHelper nadFeedHelper = this.this$0;
        String str = "";
        if (StringsKt.startsWith$default(nadFeedHelper.getAdListState().getChannelId(), "dynamic_immersive", false, 2, (Object) null)) {
            if (!(feedFlowModel == null || (feedPolicyModel2 = feedFlowModel.feedPolicyModel) == null || (adPolicyFeed2 = feedPolicyModel2.adPolicyDynamic) == null || (placeId2 = adPolicyFeed2.getPlaceId()) == null)) {
                str = placeId2;
            }
        } else if (!(feedFlowModel == null || (feedPolicyModel = feedFlowModel.feedPolicyModel) == null || (adPolicyFeed = feedPolicyModel.adPolicyFeed) == null || (placeId = adPolicyFeed.getPlaceId()) == null)) {
            str = placeId;
        }
        nadFeedHelper.setPid(str);
        this.this$0.replaceCmdExts(feedFlowModel);
        List list = new ArrayList();
        if (!(feedFlowModel == null || (it = feedFlowModel.feedBaseModelList) == null)) {
            NadFeedHelper nadFeedHelper2 = this.this$0;
            Iterator<FeedBaseModel> it2 = it.iterator();
            while (it2.hasNext()) {
                FeedBaseModel model = it2.next();
                model.runtimeStatus.channelId = nadFeedHelper2.getAdListState().getChannelId();
                Intrinsics.checkNotNullExpressionValue(model, "model");
                list.add(new NadAsyncFeedBaseModel(model));
            }
        }
        this.$callback.onSuccess(list);
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.$callback.onFail();
    }
}
