package com.baidu.searchbox.tools.develop.provider.feature;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import java.util.ArrayList;
import java.util.List;

public class RxBusConfigProvider extends DebugDataGroupProvider {
    private static final String KEY_RX_BUS_SWITCH = "KEY_RX_BUS_SWITCH";
    private CompoundButton.OnCheckedChangeListener mRxBusListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            SharedPreferences.Editor e2 = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit();
            e2.putBoolean(RxBusConfigProvider.KEY_RX_BUS_SWITCH, isChecked);
            e2.commit();
        }
    };

    public List<DebugItemInfo> getChildItemList() {
        return getReportBugByScreenshotItemList();
    }

    public String getGroupName() {
        return "RXBUS";
    }

    private List<DebugItemInfo> getReportBugByScreenshotItemList() {
        List<DebugItemInfo> itemList = new ArrayList<>();
        itemList.add(new CheckItemInfo("切换为RXBUS", this.mRxBusListener, Boolean.valueOf(isRxBus())));
        return itemList;
    }

    private boolean isRxBus() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(KEY_RX_BUS_SWITCH, true);
    }
}
