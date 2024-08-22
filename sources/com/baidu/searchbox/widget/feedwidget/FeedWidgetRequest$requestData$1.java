package com.baidu.searchbox.widget.feedwidget;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.widget.listener.FeedWidgetListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/widget/feedwidget/FeedWidgetRequest$requestData$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "code", "", "parseResponse", "response", "Lokhttp3/Response;", "i", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedWidgetRequest.kt */
public final class FeedWidgetRequest$requestData$1 extends ResponseCallback<String> {
    FeedWidgetRequest$requestData$1() {
    }

    public String parseResponse(Response response, int i2) throws Exception {
        ResponseBody body;
        if (response == null || (body = response.body()) == null) {
            return null;
        }
        return body.string();
    }

    public void onSuccess(String result, int code) {
        JSONObject data;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (result != null) {
            try {
                JSONObject optJSONObject3 = new JSONObject(result).optJSONObject("data");
                if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("3004")) == null || (optJSONObject2 = optJSONObject.optJSONObject(FeedWidgetListener.ACTION)) == null) {
                    data = null;
                } else {
                    data = optJSONObject2.optJSONObject("data");
                }
                FeedWidgetDataManager.INSTANCE.parseData(data);
                if (AppConfig.isDebug()) {
                    Log.i("FeedWidgetRequest", "onSuccess: " + data);
                }
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        if (AppConfig.isDebug()) {
            Log.i("FeedWidgetRequest", "onFail: " + e2);
        }
    }
}
