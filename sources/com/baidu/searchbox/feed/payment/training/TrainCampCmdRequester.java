package com.baidu.searchbox.feed.payment.training;

import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.payment.PayResponseCallback;
import com.baidu.searchbox.feed.payment.core.service.BaseRequester;
import com.baidu.searchbox.http.Cancelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/feed/payment/training/TrainCampCmdRequester;", "Lcom/baidu/searchbox/feed/payment/core/service/BaseRequester;", "()V", "getTrainCampSchemeAsync", "Lcom/baidu/searchbox/http/Cancelable;", "path", "", "postParams", "Lcom/baidu/searchbox/feed/payment/training/TrainCmdRequestData;", "cb", "Lcom/baidu/searchbox/feed/payment/PayResponseCallback;", "Lcom/baidu/searchbox/feed/payment/training/TrainCmdResponse;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrainCampCmdRequester.kt */
public final class TrainCampCmdRequester extends BaseRequester {
    public final Cancelable getTrainCampSchemeAsync(TrainCmdRequestData trainCmdRequestData, PayResponseCallback<TrainCmdResponse> payResponseCallback) {
        Intrinsics.checkNotNullParameter(trainCmdRequestData, "postParams");
        Intrinsics.checkNotNullParameter(payResponseCallback, "cb");
        return getTrainCampSchemeAsync$default(this, (String) null, trainCmdRequestData, payResponseCallback, 1, (Object) null);
    }

    public TrainCampCmdRequester() {
        super("284");
    }

    public static /* synthetic */ Cancelable getTrainCampSchemeAsync$default(TrainCampCmdRequester trainCampCmdRequester, String str, TrainCmdRequestData trainCmdRequestData, PayResponseCallback payResponseCallback, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = trainCampCmdRequester.getCmd();
        }
        return trainCampCmdRequester.getTrainCampSchemeAsync(str, trainCmdRequestData, payResponseCallback);
    }

    public final Cancelable getTrainCampSchemeAsync(String path, TrainCmdRequestData postParams, PayResponseCallback<TrainCmdResponse> cb) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(postParams, "postParams");
        Intrinsics.checkNotNullParameter(cb, "cb");
        OnLineLog.get("FeedPay").i("TrainCampSchemeRequester " + getBaseUrl() + " === == " + postParams);
        return executeAsyncOnUIBack(path, postParams, TrainCmdResponse.class, cb);
    }
}
