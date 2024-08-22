package com.baidu.searchbox.dynamicpublisher.prepublish;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.ugc.model.PrePublishResponseModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/dynamicpublisher/prepublish/PrePublishRequestPlugin$requestData$2$1", "Lcom/baidu/searchbox/http/callback/StringResponseCallback;", "onFail", "", "p0", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "response", "", "statusCode", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrePublishRequestPlugin.kt */
public final class PrePublishRequestPlugin$requestData$2$1 extends StringResponseCallback {
    final /* synthetic */ Continuation<PrePublishResponseModel> $continuation;
    final /* synthetic */ PrePublishRequestPlugin this$0;

    PrePublishRequestPlugin$requestData$2$1(PrePublishRequestPlugin $receiver, Continuation<? super PrePublishResponseModel> $continuation2) {
        this.this$0 = $receiver;
        this.$continuation = $continuation2;
    }

    public void onSuccess(String response, int statusCode) {
        if (statusCode == this.this$0.httpSuccessStatusCode) {
            CharSequence charSequence = response;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (!Intrinsics.areEqual((Object) jsonObject.optString("errno"), (Object) this.this$0.httpErrorStatusCode)) {
                        Continuation<PrePublishResponseModel> continuation = this.$continuation;
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.m8971constructorimpl((Object) null));
                        return;
                    }
                    String dataStr = jsonObject.optString("data");
                    CharSequence charSequence2 = dataStr;
                    if (charSequence2 == null || charSequence2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        PrePublishResponseModel result = PrePublishResponseModel.Companion.parsePrePublishResponse(dataStr);
                        Continuation<PrePublishResponseModel> continuation2 = this.$continuation;
                        Result.Companion companion2 = Result.Companion;
                        continuation2.resumeWith(Result.m8971constructorimpl(result));
                        return;
                    }
                    Continuation<PrePublishResponseModel> continuation3 = this.$continuation;
                    Result.Companion companion3 = Result.Companion;
                    continuation3.resumeWith(Result.m8971constructorimpl((Object) null));
                    return;
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        Continuation<PrePublishResponseModel> continuation4 = this.$continuation;
        Result.Companion companion4 = Result.Companion;
        continuation4.resumeWith(Result.m8971constructorimpl((Object) null));
    }

    public void onFail(Exception p0) {
        Continuation<PrePublishResponseModel> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m8971constructorimpl((Object) null));
    }
}
