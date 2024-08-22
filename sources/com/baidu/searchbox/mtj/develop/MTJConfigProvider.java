package com.baidu.searchbox.mtj.develop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.baidu.disasterrecovery.MtjAdapter;
import com.baidu.mobstat.StatService;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import java.util.ArrayList;
import java.util.List;

public class MTJConfigProvider extends DebugDataGroupProvider {
    private static final String GROUP_NAME = "MTJ-Config";
    private static final String ITEM_MTJ_LOG_SAMPLE = "输出mtj采样率,请看Log";
    private static final String ITEM_MTJ_LOG_SWITCH = "mtj日志开关";
    private static final String KEY_ARCH_MTJ_LOG_SWITCH = "mtj_log_switch";
    private static final String TAG = "MTJConfigProvider";
    private View.OnClickListener mMtjSampleListener = new View.OnClickListener() {
        public void onClick(View v) {
            Log.e(MTJConfigProvider.TAG, "MtjAdapter.shouldUpload:" + MtjAdapter.shouldUpload());
            Log.e(MTJConfigProvider.TAG, "MtjAdapter.shouldUploadOther:" + MtjAdapter.shouldUploadOther());
        }
    };
    private CompoundButton.OnCheckedChangeListener mOnMtjLogCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
            final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext().getApplicationContext());
            if (isChecked != sp.getBoolean("mtj_log_switch", false)) {
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {
                        switch (which) {
                            case -2:
                                buttonView.setChecked(false);
                                Log.d("BaiduMobStat", "设备ID Test DeviceId : " + StatService.getTestDeviceId(AppRuntime.getAppContext()));
                                return;
                            case -1:
                                SharedPreferences.Editor e2 = sp.edit();
                                e2.putBoolean("mtj_log_switch", isChecked);
                                e2.commit();
                                Toast.makeText(AppRuntime.getAppContext(), "重启后才生效", 0).show();
                                return;
                            default:
                                return;
                        }
                    }
                };
                if (isChecked) {
                    new AlertDialog.Builder(BdBoxActivityManager.getTopActivity()).setTitle("确认开启mtj日志？").setMessage("警告：\n1、为了避免污染线上数据，请在开启前先将设备添加为mtj平台的测试设备\n2、开启后需要重启app才能生效").setNegativeButton("在Log里输出设备ID(tag=BaiduMobStat)", listener).setPositiveButton("确定开启", listener).setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            buttonView.setChecked(false);
                        }
                    }).show();
                } else {
                    listener.onClick((DialogInterface) null, -1);
                }
            }
        }
    };

    public List<DebugItemInfo> getChildItemList() {
        return getMTJConfigItemList();
    }

    public String getGroupName() {
        return GROUP_NAME;
    }

    private List<DebugItemInfo> getMTJConfigItemList() {
        List<DebugItemInfo> itemList = new ArrayList<>();
        itemList.add(new CheckItemInfo(ITEM_MTJ_LOG_SWITCH, this.mOnMtjLogCheckedChangeListener, Boolean.valueOf(isMtjLogSwitch())));
        itemList.add(new TextItemInfo((String) null, ITEM_MTJ_LOG_SAMPLE, this.mMtjSampleListener));
        return itemList;
    }

    private boolean isMtjLogSwitch() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("mtj_log_switch", false);
    }
}
