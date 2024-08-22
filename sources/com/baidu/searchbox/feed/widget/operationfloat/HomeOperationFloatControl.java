package com.baidu.searchbox.feed.widget.operationfloat;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.event.TabStateChangeEvent;
import com.baidu.searchbox.feed.log.OnLineLogs;
import com.baidu.searchbox.feed.tab.interaction.tts.TTSPlayerEvent;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.texas.context.pipeline.Assignment;
import com.baidu.texas.context.pipeline.PipelineContext;
import com.baidu.texas.context.pipeline.Stage;
import com.baidu.texas.context.pipeline.base.DefaultPipelineContext;
import com.baidu.texas.context.pipeline.base.Pipelines;
import com.baidu.texas.context.pipeline.base.StageChain;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class HomeOperationFloatControl {
    private static final String TAG = "HomeOperationFloatControl";
    private Builder builder;
    private IOperationFloatControl currentControl;
    private IOperationFloatControl defaultOperationFloatControl;
    private IOperationFloatControl feedOperationFloatControl;
    /* access modifiers changed from: private */
    public volatile boolean isChecking;
    private volatile boolean mainThreadIdle;
    private IOperationFloatControl timeTaskOperationFloatControl;

    public @interface Source {
        public static final String EVENT_BUS = "event_bus";
        public static final String ON_RESUME = "on_resume";
    }

    private HomeOperationFloatControl(Builder builder2) {
        this.mainThreadIdle = false;
        this.isChecking = false;
        this.builder = builder2;
        this.timeTaskOperationFloatControl = OperationFloatFactory.createTimeTask(builder2);
        this.defaultOperationFloatControl = OperationFloatFactory.createFeed(builder2);
        this.feedOperationFloatControl = OperationFloatFactory.createFeedGuide(builder2);
        this.currentControl = null;
    }

    /* access modifiers changed from: package-private */
    public void updateBuilder(Builder builder2) {
        this.builder = builder2;
    }

    /* access modifiers changed from: package-private */
    public void playGuidAnim() {
        IOperationFloatControl iOperationFloatControl;
        this.mainThreadIdle = true;
        if (!this.isChecking && (iOperationFloatControl = this.currentControl) != null) {
            iOperationFloatControl.showFloatViewOnMainThreadIdle();
        }
    }

    /* access modifiers changed from: package-private */
    public void showOperationFloatView() {
        showOperationFloatView(TabController.INSTANCE.getCurrentChannelId());
    }

    private void showOperationFloatView(String tab) {
        if (!this.isChecking) {
            this.isChecking = true;
            final boolean coldStart = isColdStart();
            StageChain chain = (StageChain) Pipelines.chainOf((List<Stage>) Arrays.asList(new Stage[]{(Stage) this.feedOperationFloatControl, (Stage) this.timeTaskOperationFloatControl, (Stage) this.defaultOperationFloatControl}));
            chain.setEndingHandler(new Assignment() {
                public void run(PipelineContext pipelineContext) {
                    Object obj = pipelineContext.getResult();
                    HomeOperationFloatControl.this.replaceFloatControl(obj == DefaultPipelineContext.EMPTY ? null : (IOperationFloatControl) obj);
                    HomeOperationFloatControl.this.doShowFloatView(coldStart);
                    boolean unused = HomeOperationFloatControl.this.isChecking = false;
                }
            });
            PipelineContext pipelineContext = Pipelines.newPipelineContext(tab);
            pipelineContext.setResult(DefaultPipelineContext.EMPTY);
            chain.proceed(pipelineContext);
        }
    }

    private boolean isColdStart() {
        return !this.mainThreadIdle;
    }

    /* access modifiers changed from: private */
    public void replaceFloatControl(IOperationFloatControl newFloatControl) {
        IOperationFloatControl iOperationFloatControl = this.currentControl;
        if (iOperationFloatControl != newFloatControl) {
            if (iOperationFloatControl != null) {
                iOperationFloatControl.hideFloatView();
            }
            this.currentControl = newFloatControl;
        }
    }

    /* access modifiers changed from: private */
    public void doShowFloatView(boolean coldStart) {
        if (this.currentControl == null) {
            OnLineLogs.getOperationFloat().e("运营浮层类型为空");
        } else if (this.builder == null) {
            OnLineLogs.getOperationFloat().e("运营浮层参数为空");
        } else {
            OnLineLogs.getOperationFloat().d("运营浮层 doShowFloatView 类型: " + this.currentControl + ", coldStart:" + coldStart + ", mainThreadIdle:" + this.mainThreadIdle);
            this.currentControl.updateBuilder(this.builder);
            this.currentControl.showFloatView(coldStart, this.mainThreadIdle);
        }
    }

    /* access modifiers changed from: package-private */
    public void pauseOperationFloatView() {
        IOperationFloatControl iOperationFloatControl;
        if (!this.isChecking && (iOperationFloatControl = this.currentControl) != null) {
            iOperationFloatControl.pauseFloatView();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPageScrollStateChanged(int state) {
        IOperationFloatControl iOperationFloatControl;
        if (!this.isChecking && (iOperationFloatControl = this.currentControl) != null) {
            iOperationFloatControl.onPageScrollStateChanged(state);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTabStateChangeEvent(TabStateChangeEvent event) {
        if (event.pageScrollState == -1) {
            showOperationFloatView(event.tabID);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        IOperationFloatControl iOperationFloatControl = this.currentControl;
        if (iOperationFloatControl != null) {
            iOperationFloatControl.removeFloatView();
            this.currentControl = null;
        }
        this.builder = null;
        this.timeTaskOperationFloatControl = null;
        this.defaultOperationFloatControl = null;
        this.feedOperationFloatControl = null;
    }

    /* access modifiers changed from: package-private */
    public void onNightModeChanged(boolean isNightMode) {
        IOperationFloatControl iOperationFloatControl;
        if (!this.isChecking && (iOperationFloatControl = this.currentControl) != null) {
            iOperationFloatControl.onNightModeChanged(isNightMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTtsPlayerEvent(TTSPlayerEvent ttsPlayerEvent) {
        IOperationFloatControl iOperationFloatControl;
        if (!this.isChecking && (iOperationFloatControl = this.currentControl) != null) {
            iOperationFloatControl.onTtsPlayerEvent(ttsPlayerEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isShow() {
        IOperationFloatControl iOperationFloatControl = this.currentControl;
        return iOperationFloatControl != null && iOperationFloatControl.isShow();
    }

    /* access modifiers changed from: package-private */
    public void hideFloatView() {
        if (this.currentControl != null) {
            FeedUtil.newHomeLog(TAG, "隐藏运营浮层");
            this.currentControl.hideFloatView();
        }
    }

    /* access modifiers changed from: package-private */
    public void showFloatView() {
        doShowFloatView(isColdStart());
        if (this.currentControl != null && this.builder != null) {
            FeedUtil.newHomeLog(TAG, "显示运营浮层");
        }
    }

    public static class Builder {
        WeakReference<Context> contextRef;
        boolean isNewUser;
        boolean playAnim = true;
        WeakReference<ViewGroup> rootContainerRef;
        String source = Source.ON_RESUME;

        public Builder(WeakReference<Context> context) {
            this.contextRef = context;
        }

        public Builder setRootContainer(WeakReference<ViewGroup> rootContainer) {
            this.rootContainerRef = rootContainer;
            return this;
        }

        public Builder source(String source2) {
            this.source = source2;
            return this;
        }

        public Builder playAnimAfterShown(boolean playAnim2) {
            this.playAnim = playAnim2;
            return this;
        }

        public Builder isNewUser(boolean isNewUser2) {
            this.isNewUser = isNewUser2;
            return this;
        }

        public HomeOperationFloatControl build() {
            return new HomeOperationFloatControl(this);
        }
    }
}
