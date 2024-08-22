package com.baidu.searchbox.socialshare.provider;

import android.view.View;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.socialshare.R;
import com.baidu.searchbox.socialshare.SocialHelper;
import com.baidu.searchbox.socialshare.runtime.SocialShareRuntime;
import java.util.ArrayList;
import java.util.List;

public class ShareDebugConfigProvider extends DebugDataGroupProvider {
    private View.OnClickListener mFailToastInfoListener = new View.OnClickListener() {
        public void onClick(View v) {
            ShareDebugConfigProvider.execShowFailToast();
        }
    };

    public List<DebugItemInfo> getChildItemList() {
        return getShareOperationInfo();
    }

    public String getGroupName() {
        return SocialShareRuntime.getAppContext().getResources().getString(R.string.share_text);
    }

    public static void execShowFailToast() {
        if (SocialHelper.isDebugInfoVisible()) {
            SocialHelper.setDebugInfoVisibility(false);
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.socialshare_debug_config_fail_close_text).showToast();
            return;
        }
        SocialHelper.setDebugInfoVisibility(true);
        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.socialshare_debug_config_fail_open_text).showToast();
    }

    private List<DebugItemInfo> getShareOperationInfo() {
        List<DebugItemInfo> itemInfos = new ArrayList<>();
        itemInfos.add(new TextItemInfo((String) null, SocialShareRuntime.getAppContext().getString(R.string.socialshare_debug_config_fail_toast_text), this.mFailToastInfoListener));
        return itemInfos;
    }
}
