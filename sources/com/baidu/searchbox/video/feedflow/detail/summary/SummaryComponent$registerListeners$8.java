package com.baidu.searchbox.video.feedflow.detail.summary;

import android.text.TextUtils;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.view.FolderTextViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/summary/SummaryComponent$registerListeners$8", "Lcom/baidu/searchbox/video/feedflow/view/FolderTextViewContainer$IOnLinkShownListener;", "onLinkShown", "", "shownType", "", "uk", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SummaryComponent.kt */
public final class SummaryComponent$registerListeners$8 implements FolderTextViewContainer.IOnLinkShownListener {
    final /* synthetic */ SummaryComponent this$0;

    SummaryComponent$registerListeners$8(SummaryComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onLinkShown(String shownType, String uk) {
        if (Intrinsics.areEqual((Object) shownType, (Object) "ttv")) {
            String jsonUk = "";
            if (!TextUtils.isEmpty(uk)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("UserID", uk);
                String jSONObject = jsonObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
                jsonUk = jSONObject;
            }
            Store access$getStore = this.this$0.getStore();
            if (access$getStore != null) {
                access$getStore.dispatch(new SummaryTtvVideoAction(jsonUk, "show"));
            }
        }
    }
}
