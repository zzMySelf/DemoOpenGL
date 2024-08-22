package com.baidu.searchbox.download.center.debug;

import android.view.View;
import com.baidu.android.ext.widget.DownloadPopupWindowUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadPopupConfigProvider extends DebugDataGroupProvider {
    private static final String GROUP_NAME = "下载弹窗样式";
    private static final String ITEM_DOWNLOAD_DECRAUS = "德雷克下载弹窗";
    private static final String ITEM_NORMAL_APK_DOWNLOAD = "普通Apk下载弹窗";
    private static final String ITEM_NORMAL_POPUP_WINDOW = "普通下载弹窗";
    private View.OnClickListener mDecraisListener = new View.OnClickListener() {
        public void onClick(View v) {
            DownloadPopupWindowUtils.buildDecraisWindow(BdBoxActivityManager.getTopActivity());
        }
    };
    private View.OnClickListener mNormalApkPopupWindowListener = new View.OnClickListener() {
        public void onClick(View v) {
            DownloadPopupWindowUtils.buildNormalApkDownloadWindow(BdBoxActivityManager.getTopActivity());
        }
    };
    private View.OnClickListener mNormalPopupWindowListener = new View.OnClickListener() {
        public void onClick(View v) {
            DownloadPopupWindowUtils.buildCommonWindow(BdBoxActivityManager.getTopActivity());
        }
    };

    public List<DebugItemInfo> getChildItemList() {
        return getDownloadPopupConfigItemList();
    }

    public String getGroupName() {
        return GROUP_NAME;
    }

    private List<DebugItemInfo> getDownloadPopupConfigItemList() {
        List<DebugItemInfo> itemList = new ArrayList<>();
        itemList.add(new TextItemInfo((String) null, ITEM_NORMAL_POPUP_WINDOW, this.mNormalPopupWindowListener));
        itemList.add(new TextItemInfo((String) null, ITEM_DOWNLOAD_DECRAUS, this.mDecraisListener));
        itemList.add(new TextItemInfo((String) null, ITEM_NORMAL_APK_DOWNLOAD, this.mNormalApkPopupWindowListener));
        return itemList;
    }
}
