package com.baidu.searchbox.plugins.center.list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.aps.center.callback.UICallback;
import com.baidu.searchbox.aps.center.init.manager.PluginInitManager;
import com.baidu.searchbox.aps.center.net.manager.PluginNetManager;
import com.baidu.searchbox.plugins.R;
import com.baidu.searchbox.plugins.center.base.BasePluginCenterActivity;
import com.baidu.searchbox.plugins.center.base.ResUtils;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;

public class PluginCenterActivity extends BasePluginCenterActivity {
    private static final String TAG = "PluginCenterActivity";
    private PluginInitManager.InitCallback mInitCallback;
    /* access modifiers changed from: private */
    public PluginCenterList mPluginCenterList;
    private PluginNetManager.UpdateListener mUpdateListener = new PluginNetManager.UpdateListener() {
        public void onUpdated() {
            PluginCenterActivity.this.mPluginCenterList.refreshPluginListAsync();
        }
    };

    public UICallback.PageType getPageType() {
        return new UICallback.PageType(1, (String) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aps_center_plugin_center_main);
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        if (bdActionBar != null) {
            bdActionBar.setTitle(R.string.aps_center_plugin_center_title);
            bdActionBar.setLeftFirstViewVisibility(false);
        }
        initView();
        initHandler();
        initListener();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mPluginCenterList.refreshPluginListAsync();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            finish();
        }
    }

    private void initView() {
        LinearLayout container = (LinearLayout) findViewById(R.id.aps_center_item_zone);
        ResUtils.setBackgroundColor(container, R.color.aps_center_actionbar_activity_layout_bg);
        this.mPluginCenterList = new PluginCenterList(this, container, (ScrollView) findViewById(R.id.aps_center_srollview));
    }

    private void initHandler() {
        PluginCenterDataManager.getInstance(this).setRefreshPluginListHandler(new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    PluginCenterActivity.this.mPluginCenterList.refreshPluginListAsync();
                }
            }
        });
        if (this.mInitCallback == null) {
            this.mInitCallback = new PluginInitManager.InitCallback() {
                public void onInited(String packageName) {
                    PluginCenterDataManager.getInstance(PluginCenterActivity.this).sendMsgToPluginCenter();
                }

                public void onFinish() {
                }
            };
            PluginInitManager.getInstance(this).addCallback(this.mInitCallback);
        }
        PluginCenterDataManager.getInstance(this).setRefreshPluginListItemHandler(new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                if (msg.what == 2) {
                    String packageName = (String) msg.obj;
                    if (!TextUtils.isEmpty(packageName)) {
                        PluginCenterActivity.this.mPluginCenterList.refreshDownloadState(packageName, msg.arg1, msg.arg2);
                    }
                }
            }
        });
    }

    private void initListener() {
        PluginNetManager.getInstance(this).addUpdateListener(this.mUpdateListener);
    }

    private void clearListener() {
        PluginNetManager.getInstance(this).removeUpdateListener(this.mUpdateListener);
    }

    private void clearHandler() {
        PluginCenterDataManager.getInstance(this).setRefreshPluginListHandler((Handler) null);
        PluginCenterDataManager.getInstance(this).setRefreshPluginListItemHandler((Handler) null);
        PluginInitManager.getInstance(this).removeCallback(this.mInitCallback);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        clearListener();
        clearHandler();
        this.mPluginCenterList.clearView();
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        BottomBarOptionFloatingBack barOption = new BottomBarOptionFloatingBack();
        barOption.setHideBackWithTopBackExperiment(true);
        return barOption;
    }
}
