package com.baidu.sofire.xclient.privacycontrol;

import android.content.Context;
import com.baidu.sofire.xclient.privacycontrol.ui.IDoubleListCallBack;
import org.json.JSONObject;

public class PrvDataManager {
    public static void gotoDoubleListThirdPage(Context context) {
        PrvControlManager.gotoDoubleListThirdPage(context);
    }

    public static int gotoDoubleListUserPage(Context context, JSONObject jSONObject) {
        return PrvControlManager.gotoDoubleListUserPage(context, jSONObject);
    }

    public static void gotoDoubleListUserPage(Context context, IDoubleListCallBack iDoubleListCallBack) {
        PrvControlManager.gotoDoubleListUserPage(context, iDoubleListCallBack);
    }

    public static void setPrivacyControlConfig(PrivacyControlConfig privacyControlConfig) {
        PrvControlManager.getInstance().setPrivacyControlConfig(privacyControlConfig);
    }
}
