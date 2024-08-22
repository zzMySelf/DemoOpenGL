package com.baidu.searchbox.account.userinfo.net;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/account/userinfo/net/PersonalPageRequest$notifyPublishConfigBubbleShow$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNetRequest.kt */
public final class PersonalPageRequest$notifyPublishConfigBubbleShow$responseCallback$1 extends ResponseCallback<String> {
    PersonalPageRequest$notifyPublishConfigBubbleShow$responseCallback$1() {
    }

    public String parseResponse(Response response, int statusCode) {
        boolean z = true;
        if (response == null || !response.isSuccessful()) {
            z = false;
        }
        if (!z) {
            return "";
        }
        ResponseBody body = response.body();
        if (body != null) {
            return body.string();
        }
        return null;
    }

    public void onSuccess(String result, int statusCode) {
    }

    public void onFail(Exception e2) {
    }
}
