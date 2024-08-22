package com.baidu.searchbox.account.userinfo.net;

import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001f\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/account/userinfo/net/PersonalPageRequest$reqSubscribeData$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;I)Ljava/lang/Boolean;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNetRequest.kt */
public final class PersonalPageRequest$reqSubscribeData$responseCallback$1 extends ResponseCallback<Boolean> {
    final /* synthetic */ Function2<Boolean, String, Unit> $callBack;
    final /* synthetic */ Ref.ObjectRef<String> $errno;

    PersonalPageRequest$reqSubscribeData$responseCallback$1(Ref.ObjectRef<String> $errno2, Function2<? super Boolean, ? super String, Unit> $callBack2) {
        this.$errno = $errno2;
        this.$callBack = $callBack2;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object response, int statusCode) {
        onSuccess(((Boolean) response).booleanValue(), statusCode);
    }

    public Boolean parseResponse(Response response, int statusCode) {
        boolean z = false;
        if (response != null && response.isSuccessful()) {
            ResponseBody body = response.body();
            String body2 = body != null ? body.string() : null;
            if (body2 != null) {
                if (body2.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                Ref.ObjectRef<String> objectRef = this.$errno;
                try {
                    Result.Companion companion = Result.Companion;
                    PersonalPageRequest$reqSubscribeData$responseCallback$1 personalPageRequest$reqSubscribeData$responseCallback$1 = this;
                    T optString = new JSONObject(body2).optString("errno");
                    if (optString == null) {
                        optString = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(optString, "JSONObject(body).optString(\"errno\") ?: \"\"");
                    }
                    objectRef.element = optString;
                    if (TextUtils.equals((CharSequence) objectRef.element, "0")) {
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
            }
        }
        return false;
    }

    public void onSuccess(boolean result, int statusCode) {
        this.$callBack.invoke(Boolean.valueOf(result), this.$errno.element);
    }

    public void onFail(Exception e2) {
        this.$callBack.invoke(false, this.$errno.element);
    }
}
