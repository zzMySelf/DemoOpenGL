package com.baidu.searchbox.video.feedflow.update;

import android.content.Context;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J&\u0010\u0019\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/update/PaymentPanelConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "<set-?>", "", "versionData", "getVersionData", "()Ljava/lang/String;", "setVersionData", "(Ljava/lang/String;)V", "versionData$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "addPostData", "", "context", "Landroid/content/Context;", "module", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "saveInteractMessageConfig", "data", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentPanelConfigListener.kt */
public final class PaymentPanelConfigListener extends JSONObjectCommandListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PaymentPanelConfigListener.class, "versionData", "getVersionData()Ljava/lang/String;", 0))};
    private final VideoSPData versionData$delegate = new VideoSPData("flowvideo_payment_panel_version", "0", false, (String) null, 12, (DefaultConstructorMarker) null);

    private final String getVersionData() {
        return (String) this.versionData$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void setVersionData(String str) {
        this.versionData$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put("flowvideo_payment_panel_config", getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        JSONObject jSONObject = null;
        CharSequence charSequence = value != null ? value.version : null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            if (value != null) {
                jSONObject = (JSONObject) value.data;
            }
            if (jSONObject == null || !Intrinsics.areEqual((Object) action, (Object) "flowvideo_payment_panel_config") || Intrinsics.areEqual((Object) getLocalVersion(context, module, action), (Object) value.version)) {
                return false;
            }
            String str = value.version;
            Intrinsics.checkNotNullExpressionValue(str, "value.version");
            setVersionData(str);
            T t = value.data;
            Intrinsics.checkNotNullExpressionValue(t, "value.data");
            saveInteractMessageConfig((JSONObject) t);
            return true;
        }
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return getVersionData();
    }

    private final void saveInteractMessageConfig(JSONObject data) {
        PaymentPanelConfigListenerKt.setPaymentPanelSwitcher(data.optBoolean("flowvideo_payment_panel_switch_android", true));
    }
}
