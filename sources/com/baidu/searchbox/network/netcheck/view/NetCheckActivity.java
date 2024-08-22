package com.baidu.searchbox.network.netcheck.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.appframework.ToolBarActivity;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.network.R;
import com.baidu.searchbox.network.netcheck.NetCheckManager;
import com.baidu.searchbox.network.netcheck.NetCheckTask;
import com.baidu.searchbox.network.netcheck.NetCheckTaskRecord;
import com.baidu.searchbox.network.netcheck.view.NetCheckCircleView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFuncButtonsOne;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.widget.SlideInterceptor;

public class NetCheckActivity extends ToolBarActivity implements INetCheckInterface, SlideInterceptor {
    private static final String FINISH_FRAGMENT_KEY = "finishFragment";
    private static final String WORK_FRAGMENT_KEY = "workFragment";
    private NetCheckManager.CheckCallBack checkCallBack;
    private String from;
    /* access modifiers changed from: private */
    public NetCheckFinishFragment mFinishFragment;
    /* access modifiers changed from: private */
    public Handler mMainHandler = new Handler();
    private TextView mTitleText;
    /* access modifiers changed from: private */
    public NetCheckWorkFragment mWorkFragment;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            this.from = intent.getStringExtra("from");
        }
        if (TextUtils.isEmpty(this.from)) {
            this.from = "default";
        }
        initCheckCallback();
        if (savedInstanceState != null) {
            this.mWorkFragment = (NetCheckWorkFragment) getSupportFragmentManager().findFragmentByTag(WORK_FRAGMENT_KEY);
            this.mFinishFragment = (NetCheckFinishFragment) getSupportFragmentManager().findFragmentByTag(FINISH_FRAGMENT_KEY);
        }
        setContentView(R.layout.network_check);
        initView();
        setPendingTransition(com.baidu.android.common.ui.style.R.anim.slide_in_from_right, com.baidu.android.common.ui.style.R.anim.slide_out_to_left, com.baidu.android.common.ui.style.R.anim.slide_in_from_left, com.baidu.android.common.ui.style.R.anim.slide_out_to_right);
        setEnableSliding(true, this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        updateTaskLayout();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (NetCheckManager.getInstance().hasWorkingTask() || this.mWorkFragment.getNetcheckStatus() == 1) {
            NetCheckManager.getInstance().enterBackground();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mMainHandler.removeCallbacksAndMessages((Object) null);
        if (!NetCheckManager.getInstance().hasWorkingTask() && this.mWorkFragment.getNetcheckStatus() != 1) {
            NetCheckManager.getInstance().resetCheck();
        }
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.network_diagnose_label_text);
        this.mTitleText = textView;
        textView.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.black));
        if (this.mWorkFragment == null) {
            this.mWorkFragment = new NetCheckWorkFragment();
        }
        if (this.mFinishFragment == null) {
            this.mFinishFragment = new NetCheckFinishFragment();
        }
        this.mWorkFragment.setCheckCallBack(this.checkCallBack);
        this.mWorkFragment.setFrom(this.from);
        this.mWorkFragment.setICheckButtonShow(new ICheckButtonShow() {
            public void show(boolean show) {
                UnifiedBottomBar unifiedBottomBar = UnifiedBottomBarExtKt.getBottomBar(NetCheckActivity.this);
                if (unifiedBottomBar != null) {
                    unifiedBottomBar.setFuncButtonVisible(BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1, show);
                }
            }
        });
        this.mFinishFragment.setCheckCallBack(this.checkCallBack);
        this.mFinishFragment.setFrom(this.from);
        showWaitLayout();
        UnifiedBottomBar unifiedBottomBar = UnifiedBottomBarExtKt.getBottomBar(this);
        if (unifiedBottomBar != null) {
            unifiedBottomBar.setFuncButtonTitle(BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1, getResources().getString(R.string.netcheck_begin_btn_text));
        }
        if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
            findViewById(com.baidu.searchbox.common.unifiedtoolbar.R.id.unified_top_back).setVisibility(0);
        }
    }

    private void updateTaskLayout() {
        NetCheckTask lastTask;
        NetCheckTaskRecord taskRecord;
        if (NetCheckManager.getInstance().hasWorkingTask()) {
            showWorkLayout();
            NetCheckManager.getInstance().enterForegroud(this.checkCallBack);
        } else if (NetCheckManager.getInstance().lastUnhandleTask() != null && (lastTask = NetCheckManager.getInstance().lastUnhandleTask()) != null && (taskRecord = lastTask.getTaskRecord()) != null) {
            showFinishLayout();
            this.mFinishFragment.updateResult(taskRecord);
        }
    }

    private void initCheckCallback() {
        this.checkCallBack = new NetCheckManager.CheckCallBack() {
            public void progressUpdate(NetCheckTaskRecord record) {
                if (NetCheckActivity.this.mWorkFragment != null) {
                    NetCheckActivity.this.mWorkFragment.updateProgress((int) record.getProgress(), String.format(NetCheckActivity.this.getResources().getString(R.string.netcheck_main_tip_working), new Object[]{Integer.valueOf(record.getDoneItemCount()), Integer.valueOf(record.getAllItemCount()), record.getEstimatedDuration()}));
                }
            }

            public void doneCheck(NetCheckTaskRecord taskRecord) {
                NetCheckActivity.this.mWorkFragment.done(new NetCheckCircleView.AnimationEndCallBack() {
                    public void end() {
                        if (NetCheckActivity.this.mWorkFragment != null) {
                            NetCheckActivity.this.mWorkFragment.updateTip(NetCheckActivity.this.getResources().getString(R.string.netcheck_main_tip_done));
                            NetCheckActivity.this.mWorkFragment.updateStatus(2);
                        }
                        if (NetCheckActivity.this.mMainHandler != null) {
                            NetCheckActivity.this.mMainHandler.postDelayed(new Runnable() {
                                public void run() {
                                    NetCheckActivity.this.showFinishLayout();
                                }
                            }, 700);
                        }
                    }
                });
                if (NetCheckActivity.this.mFinishFragment != null) {
                    NetCheckActivity.this.mFinishFragment.updateResult(taskRecord);
                }
            }
        };
    }

    public void showWaitLayout() {
        if (!isFinishing()) {
            if (getSupportFragmentManager().getFragments().contains(this.mFinishFragment)) {
                getSupportFragmentManager().beginTransaction().setTransition(4099).remove(this.mFinishFragment).commit();
            }
            if (!getSupportFragmentManager().getFragments().contains(this.mWorkFragment)) {
                getSupportFragmentManager().beginTransaction().setTransition(4099).add(R.id.network_check_main_layout, (Fragment) this.mWorkFragment, WORK_FRAGMENT_KEY).commit();
            } else {
                getSupportFragmentManager().beginTransaction().show(this.mWorkFragment).commit();
            }
        }
    }

    public void showWorkLayout() {
        if (!isFinishing()) {
            if (getSupportFragmentManager().getFragments().contains(this.mFinishFragment)) {
                getSupportFragmentManager().beginTransaction().setTransition(4099).remove(this.mFinishFragment).commit();
            }
            if (getSupportFragmentManager().getFragments().contains(this.mWorkFragment)) {
                getSupportFragmentManager().beginTransaction().setTransition(4099).show(this.mWorkFragment).commit();
            }
            NetCheckWorkFragment netCheckWorkFragment = this.mWorkFragment;
            if (netCheckWorkFragment != null && netCheckWorkFragment.getNetcheckStatus() != 1) {
                this.mWorkFragment.resetProgress();
                this.mWorkFragment.updateStatus(1);
                this.mWorkFragment.updateTip(getResources().getString(R.string.netcheck_main_tip_working_prefix));
            }
        }
    }

    public void showFinishLayout() {
        if (!isFinishing() && !getSupportFragmentManager().isStateSaved()) {
            if (!getSupportFragmentManager().getFragments().contains(this.mFinishFragment)) {
                getSupportFragmentManager().beginTransaction().setTransition(4099).add(R.id.network_check_main_layout, (Fragment) this.mFinishFragment, FINISH_FRAGMENT_KEY).commit();
            }
            getSupportFragmentManager().beginTransaction().setTransition(4099).hide(this.mWorkFragment).commit();
        }
    }

    public void onToolBarBackPressed() {
        finish();
    }

    public boolean isSlidable(MotionEvent ev) {
        return true;
    }

    public boolean isNightMode() {
        return NightModeHelper.getNightModeSwitcherState();
    }

    public void showToast(Context context, int textId) {
        UniversalToast.makeText(context, textId).showToast();
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        BottomBarOptionFuncButtonsOne barOption = new BottomBarOptionFuncButtonsOne();
        barOption.setHideBackWithTopBackExperiment(true);
        return barOption;
    }

    public boolean onBottomBarElementClickEvent(BarElementClickContext context) {
        if (context.getElementId() != BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1) {
            return super.onBottomBarElementClickEvent(context);
        }
        this.mWorkFragment.startNewCheck();
        return true;
    }
}
