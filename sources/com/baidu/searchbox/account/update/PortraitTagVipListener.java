package com.baidu.searchbox.account.update;

import android.content.Context;
import com.baidu.android.app.account.utils.AccountSharedpreferencesUtils;
import com.baidu.searchbox.account.userinfo.activity.PortraitSettingActivityKt;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/account/update/PortraitTagVipListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "p0", "p1", "p2", "lib-account-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitTagVipListener.kt */
public final class PortraitTagVipListener extends JSONObjectCommandListener {
    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(PortraitTagVipListenerKt.PORTRAIT_TAG_VIP, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if ((value != null ? (JSONObject) value.data : null) != null) {
            CharSequence charSequence = value.version;
            if (!(charSequence == null || charSequence.length() == 0)) {
                AccountSharedpreferencesUtils.getInstance().setStringPreference(PortraitTagVipListenerKt.PORTRAIT_TAG_VIP_VERSION, value.version);
                try {
                    boolean isEnable = Intrinsics.areEqual((Object) ((JSONObject) value.data).getString(PortraitTagVipListenerKt.VIP_PORTRAIT_TAG_ENABLE), (Object) "1");
                    DefaultSharedPrefsWrapper instance = DefaultSharedPrefsWrapper.getInstance();
                    if (instance != null) {
                        instance.putBoolean(PortraitSettingActivityKt.PORTRAIT_VIP_TAG_ENABLE, isEnable);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    public String getLocalVersion(Context p0, String p1, String p2) {
        DefaultSharedPrefsWrapper instance = DefaultSharedPrefsWrapper.getInstance();
        String string = instance != null ? instance.getString(PortraitTagVipListenerKt.PORTRAIT_TAG_VIP_VERSION, "0") : null;
        return string == null ? "0" : string;
    }
}
