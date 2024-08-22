package com.baidu.searchbox.feed.biserial.processors;

import com.baidu.searchbox.feed.biserial.processors.specviews.DataOptInsertProcess;
import com.baidu.searchbox.http.callback.ResponseCallback;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/feed/biserial/processors/BiSerialOperationProcessor$requestRewardData$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "s", "p1", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialOperationProcessor.kt */
public final class BiSerialOperationProcessor$requestRewardData$1 extends ResponseCallback<String> {
    final /* synthetic */ BiSerialOperationProcessor this$0;

    BiSerialOperationProcessor$requestRewardData$1(BiSerialOperationProcessor $receiver) {
        this.this$0 = $receiver;
    }

    public String parseResponse(Response response, int p1) {
        String responseString;
        ResponseBody body = response != null ? response.body() : null;
        if (body == null) {
            responseString = "";
        } else {
            try {
                responseString = body.string();
                Intrinsics.checkNotNullExpressionValue(responseString, "body.string()");
            } catch (IOException e2) {
                return "";
            }
        }
        return responseString;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if ((r5.length() > 0) == true) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(java.lang.String r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0013
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x000f
            r2 = r0
            goto L_0x0010
        L_0x000f:
            r2 = r1
        L_0x0010:
            if (r2 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x003e
            com.baidu.searchbox.feed.biserial.biserialoperation.DiscoveryOptDataManager r0 = com.baidu.searchbox.feed.biserial.biserialoperation.DiscoveryOptDataManager.INSTANCE
            r0.saveRewardResponse(r5)
            com.baidu.searchbox.feed.biserial.processors.BiSerialOperationProcessor r0 = r4.this$0
            com.baidu.texas.context.ExtensionPoint<com.baidu.searchbox.feed.biserial.processors.specviews.DataOptInsertProcess> r1 = com.baidu.searchbox.feed.biserial.processors.specviews.DataOptInsertProcess.EP
            java.util.List r0 = r0.getExtensions(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r0.next()
            com.baidu.searchbox.feed.biserial.processors.specviews.DataOptInsertProcess r1 = (com.baidu.searchbox.feed.biserial.processors.specviews.DataOptInsertProcess) r1
            com.baidu.searchbox.feed.biserial.processors.BiSerialOperationProcessor r2 = r4.this$0
            com.baidu.searchbox.feed.biserial.processors.BiSerialOperationProcessor$requestRewardData$1$$ExternalSyntheticLambda0 r3 = new com.baidu.searchbox.feed.biserial.processors.BiSerialOperationProcessor$requestRewardData$1$$ExternalSyntheticLambda0
            r3.<init>(r1, r2)
            com.baidu.android.util.concurrent.UiThreadUtils.runOnUiThread(r3)
            goto L_0x0027
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.biserial.processors.BiSerialOperationProcessor$requestRewardData$1.onSuccess(java.lang.String, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m18442onSuccess$lambda0(DataOptInsertProcess $extension, BiSerialOperationProcessor this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        $extension.afterOptDataRefresh(this$02.getDataManager().getChannel().getDisplayList().getCachedFeeds());
        this$02.getPage().notifyDataSetChanged();
    }

    public void onFail(Exception exception) {
    }
}
