package com.baidu.payment.impl.ext.command;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.payment.impl.ext.storage.PolySharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import org.json.JSONException;

public class NuoMiBdtlsListener extends AbstractCommandListener<NuoMiCloudCommand> {
    protected static final String ACTION = "trade_bdtls_v4";
    public static final String NUO_MI_SP_KEY_BDTLS_V4_SWITCH_COMMAND = "NUO_MI_SP_KEY_BDTLS_V4_SWITCH_COMMAND";
    private static final String NUO_MI_SP_KEY_BDTLS_V4_SWITCH_VERSION_COMMAND = "NUO_MI_SP_KEY_BDTLS_V4_SWITCH_VERSION_COMMAND";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<NuoMiCloudCommand> value) {
        if (value == null || value.data == null || !TextUtils.equals(action, ACTION) || TextUtils.isEmpty(value.version) || TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        PolySharedPrefsWrapper.getInstance().putString(NUO_MI_SP_KEY_BDTLS_V4_SWITCH_VERSION_COMMAND, value.version);
        PolySharedPrefsWrapper.getInstance().putBoolean(NUO_MI_SP_KEY_BDTLS_V4_SWITCH_COMMAND, ((NuoMiCloudCommand) value.data).f16173android);
        return true;
    }

    public String getLocalVersion(Context context, String s, String s1) {
        return PolySharedPrefsWrapper.getInstance().getString(NUO_MI_SP_KEY_BDTLS_V4_SWITCH_VERSION_COMMAND, "0");
    }
}
