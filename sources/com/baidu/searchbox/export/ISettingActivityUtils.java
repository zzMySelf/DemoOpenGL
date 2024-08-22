package com.baidu.searchbox.export;

import android.app.Activity;
import com.baidu.searchbox.setting.SettingActivityUtilsImpl_Factory;

public interface ISettingActivityUtils {
    Boolean isWifi4GDualEnable();

    void startPlaySettingActivity(Activity activity);

    public static class Impl {
        public static ISettingActivityUtils get() {
            return SettingActivityUtilsImpl_Factory.get();
        }
    }
}
