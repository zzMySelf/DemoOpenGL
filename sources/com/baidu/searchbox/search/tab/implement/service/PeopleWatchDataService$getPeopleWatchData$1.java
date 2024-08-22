package com.baidu.searchbox.search.tab.implement.service;

import android.text.TextUtils;
import com.baidu.searchbox.feed.payment.payui.PayUiFacadeKt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.search.tab.implement.service.PeopleWatchDataService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/search/tab/implement/service/PeopleWatchDataService$getPeopleWatchData$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "responseString", "i", "", "parseResponse", "response", "Lokhttp3/Response;", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PeopleWatchDataService.kt */
public final class PeopleWatchDataService$getPeopleWatchData$1 extends ResponseCallback<String> {
    final /* synthetic */ PeopleWatchDataService.SearchVideoPeopleWatchCall $callback;
    final /* synthetic */ int $requestType;

    PeopleWatchDataService$getPeopleWatchData$1(PeopleWatchDataService.SearchVideoPeopleWatchCall $callback2, int $requestType2) {
        this.$callback = $callback2;
        this.$requestType = $requestType2;
    }

    public String parseResponse(Response response, int i2) throws Exception {
        Intrinsics.checkNotNullParameter(response, "response");
        boolean unused = PeopleWatchDataServiceKt.DEBUG;
        byte[] bArr = new byte[0];
        ResponseBody $this$parseResponse_u24lambda_u2d0 = response.body();
        if ($this$parseResponse_u24lambda_u2d0 != null) {
            byte[] bytes = $this$parseResponse_u24lambda_u2d0.bytes();
            Intrinsics.checkNotNullExpressionValue(bytes, "bytes()");
            bArr = bytes;
            if (!response.isSuccessful()) {
                return null;
            }
        }
        return new String(bArr, Charsets.UTF_8);
    }

    public void onSuccess(String responseString, int i2) {
        boolean unused = PeopleWatchDataServiceKt.DEBUG;
        if (!TextUtils.isEmpty(responseString)) {
            PeopleWatchDataService.SearchVideoPeopleWatchCall searchVideoPeopleWatchCall = this.$callback;
            int i3 = this.$requestType;
            Intrinsics.checkNotNull(responseString);
            searchVideoPeopleWatchCall.response(i3, responseString);
        }
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        String message = e2.getMessage();
        boolean z = true;
        if (message == null || !StringsKt.contains$default((CharSequence) message, (CharSequence) PayUiFacadeKt.SOCKET_CLOSE, false, 2, (Object) null)) {
            z = false;
        }
        if (!z && PeopleWatchDataServiceKt.DEBUG) {
            e2.printStackTrace();
        }
    }
}
