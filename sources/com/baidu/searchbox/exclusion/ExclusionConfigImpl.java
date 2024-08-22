package com.baidu.searchbox.exclusion;

import android.util.Log;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.exclusion.ioc.IExclusionConfig;
import com.baidu.searchbox.performance.speed.SpeedStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/exclusion/ExclusionConfigImpl;", "Lcom/baidu/searchbox/exclusion/ioc/IExclusionConfig;", "()V", "enableNewUserShieldAB", "", "enablePopupRuleCheck", "getConfigData", "Lorg/json/JSONObject;", "name", "", "getPopDelayMs", "", "isDebug", "matchDelayAB", "lib-home-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExclusionConfigImpl.kt */
public final class ExclusionConfigImpl implements IExclusionConfig {
    public JSONObject getConfigData(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return ExclusionConfigUtilsKt.getExclusionConfig(name);
    }

    public long getPopDelayMs() {
        return ExclusionConfigUtilsKt.getDelayMs();
    }

    public boolean matchDelayAB() {
        return AbTestManager.getInstance().getSwitch("foundation_mutex_queue_delay_start_switch", 0) == 1;
    }

    public boolean isDebug() {
        return AppConfig.isDebug();
    }

    public boolean enablePopupRuleCheck() {
        return ExclusionConfigUtilsKt.getFrequencySwitch() == 1;
    }

    public boolean enableNewUserShieldAB() {
        if (isDebug()) {
            Log.d("ExclusionConfigImpl", "isNewUser: " + SpeedStats.getInstance().getLaunchType());
        }
        if (SpeedStats.getInstance().getLaunchType() == 2) {
            ExclusionConfigUtilsKt.setNewUserState(2);
            return true;
        } else if (SpeedStats.getInstance().getLaunchType() != 1) {
            return ExclusionConfigUtilsKt.getNewUserState() == 2;
        } else {
            ExclusionConfigUtilsKt.setNewUserState(1);
            return false;
        }
    }
}
