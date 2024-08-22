package com.baidu.searchbox.servicecenter.talos;

import android.util.Log;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/servicecenter/talos/ServiceCenterDataChannelHelperKt$registerDataChannelObserver$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "s", "", "result", "lib-service-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ServiceCenterDataChannelHelper.kt */
public final class ServiceCenterDataChannelHelperKt$registerDataChannelObserver$1 extends NAReceiverCallback {
    ServiceCenterDataChannelHelperKt$registerDataChannelObserver$1() {
    }

    public void onReceive(String s, String result) {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            ServiceCenterDataChannelHelperKt.parseData(new JSONObject(result));
        } catch (JSONException e2) {
            if (ServiceCenterDataChannelHelperKt.DEBUG) {
                e2.printStackTrace();
            }
        }
        if (ServiceCenterDataChannelHelperKt.DEBUG) {
            Log.i("ServiceCenterDCH", "onReceive: " + result);
        }
    }
}
