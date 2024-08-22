package com.baidu.chatsearch.model.debug;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/chatsearch/model/debug/ChatSearchDebugConfig;", "", "()V", "AGENT_SWITCH_KEY", "", "BOTTOM_BEAR_SWITCH_KEY", "BOTTOM_MENU_SWITCH_KEY", "CONFIG_CLOSE", "", "CONFIG_DEFAULT", "CONFIG_OPEN", "getAgentSwitchDebug", "getBottomBearSwitchDebug", "getBottomMenuMoreSwitchDebug", "getIntConfig", "key", "defVal", "setIntConfig", "", "value", "lib-chatsearch-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchDebugConfig.kt */
public final class ChatSearchDebugConfig {
    public static final String AGENT_SWITCH_KEY = "chatsearch_agent_switch_debug";
    public static final String BOTTOM_BEAR_SWITCH_KEY = "chatsearch_bottom_bear_switch_debug";
    public static final String BOTTOM_MENU_SWITCH_KEY = "chatsearch_bottom_more_menu_switch_debug";
    public static final int CONFIG_CLOSE = -1;
    public static final int CONFIG_DEFAULT = 0;
    public static final int CONFIG_OPEN = 1;
    public static final ChatSearchDebugConfig INSTANCE = new ChatSearchDebugConfig();

    private ChatSearchDebugConfig() {
    }

    public final int getAgentSwitchDebug() {
        return getIntConfig(AGENT_SWITCH_KEY, 0);
    }

    public final int getBottomBearSwitchDebug() {
        return getIntConfig(BOTTOM_BEAR_SWITCH_KEY, 0);
    }

    public final int getBottomMenuMoreSwitchDebug() {
        return getIntConfig(BOTTOM_MENU_SWITCH_KEY, 0);
    }

    public final int getIntConfig(String key, int defVal) {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt(key, defVal);
    }

    public final void setIntConfig(String key, int value) {
        SharedPreferences.Editor e2 = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit();
        e2.putInt(key, value);
        e2.apply();
    }
}
