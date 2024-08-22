package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.multipage.h;
import java.util.Arrays;

public class LangbridgeFeatureSwitch implements NoProguard, h.b {
    public boolean a;

    public static class a {
        public static LangbridgeFeatureSwitch a = new LangbridgeFeatureSwitch();
    }

    public static LangbridgeFeatureSwitch getInstance() {
        return a.a;
    }

    public LangbridgeSettings convertSetting(Context context, LangbridgeSettings langbridgeSettings) {
        if (this.a) {
            return langbridgeSettings;
        }
        LangbridgeSettings clone = langbridgeSettings.clone();
        clone.MW_ON = false;
        clone.MW_USE_OLD = true;
        LogUtil.d("LangbridgeSettings", "");
        return clone;
    }

    public boolean getMwSwitch() {
        return this.a;
    }

    public void setMwSwitch(Context context, boolean z) {
        this.a = z;
        LogUtil.d("LangbridgeFeatureSwitch", "setMwSwitch " + z);
        DXMSdkSAUtils.onEventWithValues("#MW_BHM_Close_MW_By_User", z ? Arrays.asList(new String[]{"1"}) : Arrays.asList(new String[]{"0"}));
        h.a().c(context);
    }

    public LangbridgeFeatureSwitch() {
        this.a = true;
    }
}
