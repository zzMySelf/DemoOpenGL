package com.baidu.ubc.bussiness.debug;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.CustomItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.ViewFetcher;
import com.baidu.ubc.IUBCForwardCallback;
import com.baidu.ubc.IUbcForwardStore;
import com.baidu.ubc.UBCHelper;
import com.baidu.ubc.UBCManager;
import com.baidu.ubc.bussiness.DeleteUbcFileManager;
import com.baidu.ubc.bussiness.debug.UbcDebugForwardView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UbcConfigProvider extends DebugDataGroupProvider {
    public static final boolean DEBUG = UBCHelper.isDebug();
    private static final String GROUP_NAME = "UBC2.0";
    private static final String ITEM_UBC_DEBUG = "是否启动Debug环境";
    private static final String ITEM_UBC_DELETE = "是否冷启动删除ubc文件";
    private static final String ITEM_UBC_SAMPLE = "是否启动抽样";
    private static final String ITEM_UBC_URL_OFFLINE = "是否切换为线下地址上报";
    private static final String KEY_UBC_ALLOW_DELETEP_FILE = "KEY_UBC_ALLOW_DELETEP_FILE";
    public static final String SP_FILE_NAME = "com.baidu.searchbox_ubcdebug2.0";
    private final CompoundButton.OnCheckedChangeListener mOfflineUrlListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (manager != null) {
                manager.setUseOfflineUrl(isChecked);
            }
        }
    };
    private final CompoundButton.OnCheckedChangeListener mUBCDebugListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (manager != null) {
                manager.setUBCDebug(isChecked);
            }
        }
    };
    private final CompoundButton.OnCheckedChangeListener mUBCDeleteFileListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            SharedPreferences.Editor e2 = KVStorageFactory.getSharedPreferences("com.baidu.searchbox_ubcdebug2.0").edit();
            e2.putBoolean(UbcConfigProvider.KEY_UBC_ALLOW_DELETEP_FILE, isChecked);
            e2.apply();
        }
    };
    private final CompoundButton.OnCheckedChangeListener mUBCSampleListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (manager != null) {
                manager.setUBCSample(isChecked);
            }
        }
    };

    public List<DebugItemInfo> getChildItemList() {
        return getUbcConfigItemList();
    }

    public String getGroupName() {
        return GROUP_NAME;
    }

    private List<DebugItemInfo> getUbcConfigItemList() {
        List<DebugItemInfo> itemList = new ArrayList<>();
        UBCManager manager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (manager == null) {
            return itemList;
        }
        itemList.add(new CheckItemInfo(ITEM_UBC_DEBUG, this.mUBCDebugListener, Boolean.valueOf(manager.isUBCDebug())));
        itemList.add(new CheckItemInfo(ITEM_UBC_URL_OFFLINE, this.mOfflineUrlListener, Boolean.valueOf(manager.isUseOfflineUrl())));
        itemList.add(new CheckItemInfo(ITEM_UBC_SAMPLE, this.mUBCSampleListener, Boolean.valueOf(manager.isUBCSample())));
        itemList.add(new CheckItemInfo(ITEM_UBC_DELETE, this.mUBCDeleteFileListener, DeleteUbcFileManager.isAllowDelete()));
        itemList.add(new CustomItemInfo(new ViewFetcher() {
            public View fetchView(final Context context) {
                return new UbcDebugForwardView(context, new UbcDebugForwardView.OnForwardClick() {
                    public void onClick(final String ids) {
                        final Handler handler = new Handler(Looper.getMainLooper());
                        if (!TextUtils.isEmpty(ids)) {
                            ((IUbcForwardStore) ServiceManager.getService(IUbcForwardStore.SERVICE_REFERENCE)).addForwardCallback(new HashSet<>(Arrays.asList(ids.split(","))), new IUBCForwardCallback() {
                                public void onEvent(final String id, final String value) {
                                    handler.post(new Runnable() {
                                        public void run() {
                                            Toast.makeText(context, "id : " + id + " ; value :" + value, 1).show();
                                        }
                                    });
                                }
                            });
                            handler.post(new Runnable() {
                                public void run() {
                                    Toast.makeText(context, "添加监听点位：" + ids, 1).show();
                                }
                            });
                        }
                    }
                });
            }
        }));
        return itemList;
    }
}
