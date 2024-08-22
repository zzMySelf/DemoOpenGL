package com.baidu.searchbox.video.detail.container;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.suspensionball.SuspensionBallAnimFinishListener;
import com.baidu.searchbox.suspensionball.SuspensionBallBaseActivityExtKt;
import com.baidu.searchbox.video.R;
import com.baidu.searchbox.video.detail.core.ComponentManager;
import com.baidu.searchbox.video.detail.export.IVideoFeedUtils;
import com.baidu.searchbox.video.detail.export.IVideoRestoreFeature;
import com.baidu.searchbox.video.detail.export.IVideoServiceManager;
import com.baidu.searchbox.video.detail.export.IVideoToolBarUtils;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.searchbox.video.detail.message.MessageUtils;
import com.baidu.searchbox.video.detail.plugin.component.player.servcie.local.ILocalPlayerService;
import com.baidu.searchbox.video.detail.plugin.service.IToolBarService;
import com.baidu.searchbox.video.detail.utils.VideoDetailExtUtils;
import com.baidu.searchbox.video.detail.utils.VideoDetailUbcExtUtils;
import com.baidu.searchbox.video.utils.ConfigurationChangedHelper;
import java.util.HashMap;
import java.util.Map;

public abstract class VideoDetailBaseActivity extends BaseActivity {
    public static final String RESTORE_UBC_SOURCE = "feed_video1";
    protected ComponentManager mComponentManager;
    private boolean mFullScreen;
    private View mRootView;

    public abstract void initComponentManager();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        initComponentManager();
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        if (this.mComponentManager.currentModel.intentData == null) {
            this.mComponentManager.notify(MessageUtils.obtainUbcMessage(MessageManifest.UBC.UBC_302));
            this.mComponentManager.detachLifecycle(getLifecycle());
            VideoDetailExtUtils.showErrorTip(getApplicationContext());
            finish();
            return;
        }
        VideoDetailUbcExtUtils.savePd(this.mComponentManager.currentModel.intentData.pd);
        VideoDetailUbcExtUtils.setFromOutside(true);
        this.mComponentManager.notify(MessageUtils.obtainUbcMessage(MessageManifest.UBC.UBC_71));
        setContentView(R.layout.video_detail_activity);
        View findViewById = findViewById(R.id.rootview);
        this.mRootView = findViewById;
        findViewById.setBackgroundColor(getResources().getColor(R.color.video_feed_video_detail_bg));
        View rootContainer = findViewById(com.baidu.android.common.ui.R.id.root_container);
        if (rootContainer != null) {
            rootContainer.setBackground((Drawable) null);
        }
        setEnableSliding(true);
        IVideoFeedUtils.Impl.get().fixTarget26Crash(this);
        setEnableImmersion(false);
        boolean z = this.mComponentManager.currentModel.intentData.isFullScreen;
        this.mFullScreen = z;
        ConfigurationChangedHelper.configFullScreen(this, z);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (IVideoRestoreFeature.Impl.get().meetAllConditions(true)) {
            IVideoRestoreFeature.Impl.get().saveIntent(getRestoreUbcSource(), getIntent());
            savePlayerProgress();
        }
    }

    /* access modifiers changed from: protected */
    public String getRestoreUbcSource() {
        return RESTORE_UBC_SOURCE;
    }

    private void savePlayerProgress() {
        ILocalPlayerService service = (ILocalPlayerService) this.mComponentManager.getService(ILocalPlayerService.class);
        if (service != null && service.getPlayer() != null) {
            service.getPlayer().saveProgressToDb();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SuspensionBallBaseActivityExtKt.initSuspensionBall(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SuspensionBallBaseActivityExtKt.startEnterAnim(this);
    }

    public void finish() {
        SuspensionBallBaseActivityExtKt.startExitAnim(this, new SuspensionBallAnimFinishListener() {
            public void onFinish() {
                VideoDetailBaseActivity.super.finish();
            }
        });
    }

    public void setContentView(int layoutResID) {
        setContentView(LayoutInflater.from(this).inflate(layoutResID, (ViewGroup) null));
    }

    public void setContentView(View view2) {
        super.setContentView(view2);
        this.mComponentManager.layout((RelativeLayout) view2);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mComponentManager.onNewIntent(intent);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mComponentManager.onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mComponentManager.onConfigurationChanged(newConfig);
        if (newConfig.orientation == 2) {
            ConfigurationChangedHelper.configLandscapeWindow(this);
        } else {
            ConfigurationChangedHelper.configPortraitWindow(this, this.mFullScreen);
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        this.mComponentManager.onNightModeChanged(isNightMode);
        this.mRootView.setBackgroundColor(getResources().getColor(R.color.video_feed_video_detail_bg));
    }

    public Intent getIntent() {
        IToolBarService toolBarService = (IToolBarService) this.mComponentManager.getService(IToolBarService.class);
        Intent intent = super.getIntent();
        if (toolBarService != null) {
            return toolBarService.updateIntent(intent);
        }
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IVideoRestoreFeature.Impl.get().deleteBundleFile();
    }

    /* access modifiers changed from: protected */
    public void doBackStatistic() {
        HashMap<String, String> values = new HashMap<>();
        values.put("from", getFrom());
        values.put("page", getPage());
        values.put("source", getSource());
        values.put("value", "device_btn");
        values.put("type", "key");
        values.put(IVideoToolBarUtils.SESSION_ID, IVideoToolBarUtils.Impl.get().getSessionId());
        values.put(IVideoToolBarUtils.CLICK_ID, IVideoToolBarUtils.Impl.get().getClickId());
        IVideoServiceManager.Impl.get().getUBCService().onEvent("206", (Map<String, String>) values);
    }

    /* access modifiers changed from: protected */
    public void slideBackStatistic() {
        HashMap<String, String> values = new HashMap<>();
        values.put("from", getFrom());
        values.put("page", getPage());
        values.put("source", getSource());
        values.put("value", "gesture");
        values.put("type", "key");
        values.put(IVideoToolBarUtils.SESSION_ID, IVideoToolBarUtils.Impl.get().getSessionId());
        values.put(IVideoToolBarUtils.CLICK_ID, IVideoToolBarUtils.Impl.get().getClickId());
        IVideoServiceManager.Impl.get().getUBCService().onEvent("206", (Map<String, String>) values);
    }
}
