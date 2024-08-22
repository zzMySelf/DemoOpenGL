package com.baidu.searchbox.newhome.content.fragment.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.kmm.home.lv1tab.HomeLv1TabModel;
import com.baidu.searchbox.newhome.callback.HomeV1TabPageEventCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/newhome/content/fragment/inter/HomeTalosContentFragment$createScrollYReceiver$3", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeTalosContentFragment.kt */
public final class HomeTalosContentFragment$createScrollYReceiver$3 extends BroadcastReceiver {
    final /* synthetic */ HomeTalosContentFragment this$0;

    HomeTalosContentFragment$createScrollYReceiver$3(HomeTalosContentFragment $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(Context context, Intent intent) {
        float f2;
        String tabId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String res = intent.getStringExtra("result");
        if (res != null) {
            try {
                String propertyValue = new JSONObject(res).optString("propertyValue");
                HomeTalosContentFragment homeTalosContentFragment = this.this$0;
                try {
                    Intrinsics.checkNotNullExpressionValue(propertyValue, "propertyValue");
                    f2 = Float.parseFloat(propertyValue);
                } catch (Exception e2) {
                    f2 = 0.0f;
                }
                homeTalosContentFragment.mScrollOffsetY1 = f2;
                HomeLv1TabModel v1TabModel = this.this$0.getV1TabModel();
                if (v1TabModel != null && (tabId = v1TabModel.getTabId()) != null) {
                    HomeTalosContentFragment homeTalosContentFragment2 = this.this$0;
                    if (AppConfig.isDebug()) {
                        Log.d("HomeTalosContent", "Y1回调" + (homeTalosContentFragment2.mScrollOffsetY + homeTalosContentFragment2.mScrollOffsetY1) + 'Y' + homeTalosContentFragment2.mScrollOffsetY + "Y1" + homeTalosContentFragment2.mScrollOffsetY1);
                    }
                    HomeV1TabPageEventCallback access$getItemCallback = homeTalosContentFragment2.getItemCallback();
                    if (access$getItemCallback != null) {
                        access$getItemCallback.onContentScrollChange(tabId, homeTalosContentFragment2.mScrollOffsetY + homeTalosContentFragment2.mScrollOffsetY1, "");
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }
}
