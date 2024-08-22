package com.baidu.searchbox.video.feedflow.di;

import android.net.Uri;
import com.baidu.searchbox.feed.ioc.IFeedFlowVideo;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.video.feedflow.common.FlowVideoSessionProvider;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/di/FeedFlowVideoImpl;", "Lcom/baidu/searchbox/feed/ioc/IFeedFlowVideo;", "()V", "createVideoSession", "", "getVideoInfoParseSwitch", "", "isInvokeFlowDetailScheme", "scheme", "isInvokeFlowDetailSchemeAndPreRenderOpened", "preRequestVideoFlowData", "", "params", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedFlowVideoImpl.kt */
public final class FeedFlowVideoImpl implements IFeedFlowVideo {
    public boolean isInvokeFlowDetailSchemeAndPreRenderOpened(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        String action = UnitedSchemeUtility.getAction(Uri.parse(scheme));
        HashMap<String, String> params = UnitedSchemeUtility.getParams(scheme);
        String paramsStr = params != null ? params.get("params") : null;
        CharSequence charSequence = paramsStr;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                return Intrinsics.areEqual((Object) action, (Object) "invokeVideoDetail") && Intrinsics.areEqual((Object) new JSONObject(paramsStr).optString("tpl"), (Object) "flowfeed") && DIFactory.INSTANCE.getConfig().isPlayerPreRender();
            } catch (JSONException e2) {
            }
        }
    }

    public boolean isInvokeFlowDetailScheme(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return Intrinsics.areEqual((Object) UnitedSchemeUtility.getAction(Uri.parse(scheme)), (Object) "invokeVideoDetail");
    }

    public boolean getVideoInfoParseSwitch() {
        return false;
    }

    public void preRequestVideoFlowData(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public String createVideoSession() {
        return new FlowVideoSessionProvider().provideSession();
    }
}
