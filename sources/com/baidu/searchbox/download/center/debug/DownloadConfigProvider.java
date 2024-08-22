package com.baidu.searchbox.download.center.debug;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.appframework.GlobalActivityLifecycle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.download.center.utils.DownloadCenterAbTestMgrKt;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.List;

public class DownloadConfigProvider extends DebugDataGroupProvider {
    private static final String FILE_SEARCH_FORCE_OPEN = "isForceFileSearchTest";
    private static final String GROUP_NAME = "下载模块";
    private static final String ITEM_DOWNLOAD_ADD = "下载图片";
    private static final String ITEM_DOWNLOAD_CREATE = "创建下载任务";
    private static final String ITEM_DOWNLOAD_FORCE_OPEN = "强制打开文件搜索";
    private static final String ITEM_DOWNLOAD_QUERY = "查询下载图片的id";
    private static final String ITEM_DOWNLOAD_SHIELD_PAN_NEW_USER = "强制命中端新-网盘屏蔽实验";
    private View.OnClickListener mDownloadAddListener = new View.OnClickListener() {
        public void onClick(View v) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    DownloadManagerExt.getInstance().doDownload("http://hiphotos.baidu.com/image/pic/item/503d269759ee3d6dedd1c1924a166d224f4ade50.jpg");
                }
            }, "Add Download", 1);
        }
    };
    private View.OnClickListener mDownloadCreateListener = new View.OnClickListener() {
        public void onClick(View v) {
            GlobalActivityLifecycle.getInstance().getRealTopActivity().startActivity(new Intent(AppRuntime.getAppContext(), CreateDownloadActivity.class));
        }
    };
    private View.OnClickListener mDownloadQueryListener = new View.OnClickListener() {
        public void onClick(View v) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    DownloadManagerExt.getInstance().queryDownloadIdByUrl("http://hiphotos.baidu.com/image/pic/item/503d269759ee3d6dedd1c1924a166d224f4ade50.jpg");
                }
            }, "Query Download Id", 1);
        }
    };
    private final CompoundButton.OnCheckedChangeListener mForceFileSearchTestListener = new DownloadConfigProvider$$ExternalSyntheticLambda0();
    private final CompoundButton.OnCheckedChangeListener mShieldPanNewUserTestListener = new DownloadConfigProvider$$ExternalSyntheticLambda1();

    static /* synthetic */ void lambda$new$0(CompoundButton buttonView, boolean isChecked) {
        QuickPersistConfig.getInstance().putBoolean(FILE_SEARCH_FORCE_OPEN, isChecked);
        UniversalToast.makeText(AppRuntime.getAppContext().getApplicationContext(), (CharSequence) "重启百度后开关生效").setDuration(2).showToast();
    }

    static /* synthetic */ void lambda$new$1(CompoundButton buttonView, boolean isChecked) {
        DefaultSharedPrefsWrapper.getInstance().putString(DownloadCenterAbTestMgrKt.KEY_SP_IS_SHOW_NET_DISK_ABILITY_TARGET_USER, isChecked ? "1" : "0");
        UniversalToast.makeText(AppRuntime.getAppContext().getApplicationContext(), (CharSequence) "重启百度后开关生效").setDuration(2).showToast();
    }

    public List<DebugItemInfo> getChildItemList() {
        return getDownloadConfigItemList();
    }

    public String getGroupName() {
        return GROUP_NAME;
    }

    private List<DebugItemInfo> getDownloadConfigItemList() {
        List<DebugItemInfo> itemList = new ArrayList<>();
        itemList.add(new TextItemInfo((String) null, ITEM_DOWNLOAD_ADD, this.mDownloadAddListener));
        itemList.add(new TextItemInfo((String) null, ITEM_DOWNLOAD_QUERY, this.mDownloadQueryListener));
        itemList.add(new TextItemInfo((String) null, ITEM_DOWNLOAD_CREATE, this.mDownloadCreateListener));
        itemList.add(new CheckItemInfo(ITEM_DOWNLOAD_SHIELD_PAN_NEW_USER, this.mShieldPanNewUserTestListener, Boolean.valueOf(DefaultSharedPrefsWrapper.getInstance().getString(DownloadCenterAbTestMgrKt.KEY_SP_IS_SHOW_NET_DISK_ABILITY_TARGET_USER, "0").equals("1"))));
        itemList.add(new CheckItemInfo(ITEM_DOWNLOAD_FORCE_OPEN, this.mForceFileSearchTestListener, Boolean.valueOf(getForceFileSearchTestSwitch())));
        return itemList;
    }

    private static boolean getForceFileSearchTestSwitch() {
        return QuickPersistConfig.getInstance().getBoolean(FILE_SEARCH_FORCE_OPEN, false);
    }
}
