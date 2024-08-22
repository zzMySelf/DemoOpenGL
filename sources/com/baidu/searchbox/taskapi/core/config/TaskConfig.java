package com.baidu.searchbox.taskapi.core.config;

import android.app.Activity;
import android.view.ViewGroup;
import com.baidu.searchbox.rewardsystem.newtimer.utils.NewTimerViewEdgeConfig;
import com.baidu.searchbox.taskapi.business.common.TaskSdkData;
import com.baidu.searchbox.taskapi.core.ITaskStatusCallback;
import com.baidu.searchbox.taskapi.core.intput.BubbleType;
import com.baidu.searchbox.taskapi.core.intput.BusinessType;
import com.baidu.searchbox.taskapi.core.intput.SubBusinessType;
import java.lang.ref.WeakReference;
import java.util.Map;

public class TaskConfig {
    public static final String[] ACTION_FEED_IDS = {"166", "69"};
    public static final String LOGIN_TOAST_TEXT_DEFAULT = "登录成功，看资讯赚钱";
    public static final String SOURCE_DEFAULT = "default";
    public static final String TIMER_TYPE_ACTION_ID = "166";
    public static final String TIMES_TYPE_ACTION_ID = "69";
    public static final String TIMES_TYPE_NEW_ACTION_ID = "638";
    private String actTaskId;
    private String actionId;
    /* access modifiers changed from: private */
    public boolean autoDismiss;
    /* access modifiers changed from: private */
    public boolean isAutoNext;
    private boolean isMutexComponent;
    /* access modifiers changed from: private */
    public boolean isTimeoutPause;
    /* access modifiers changed from: private */
    public String loginToastText;
    /* access modifiers changed from: private */
    public IInterceptor mAutoNextInterceptor;
    /* access modifiers changed from: private */
    public IBubble mBubble;
    /* access modifiers changed from: private */
    public BusinessType mBusinessType;
    /* access modifiers changed from: private */
    public IDynSource mDynSource;
    /* access modifiers changed from: private */
    public IExpUserListener mExpUserListener;
    /* access modifiers changed from: private */
    public IGetParentViewListener mGetParentViewListener;
    /* access modifiers changed from: private */
    public IGetVideoIsPlay mGetVideoIsPlay;
    /* access modifiers changed from: private */
    public IGetViewConfigListener mGetViewConfigListener;
    /* access modifiers changed from: private */
    public IIsSingleTaskTimerListener mIsSingleTaskTimerListener;
    /* access modifiers changed from: private */
    public ViewGroup.LayoutParams mLayoutParams;
    /* access modifiers changed from: private */
    public IOnSignListener mOnSignListener;
    private WeakReference<Activity> mReference;
    /* access modifiers changed from: private */
    public ITaskStatusCallback mTaskStatusCallback;
    /* access modifiers changed from: private */
    public IInterceptor mTimeoutInterceptor;
    /* access modifiers changed from: private */
    public ITimerClosedListener mTimerClosedListener;
    /* access modifiers changed from: private */
    public ITimerDynUBCExt mTimerDynUBCExt;
    /* access modifiers changed from: private */
    public ITimerShowWindowCallback mTimerShowWindowCallback;
    /* access modifiers changed from: private */
    public ITimerSubBusinessTypeListener mTimerSubBusinessTypeListener;
    /* access modifiers changed from: private */
    public IVisibilityChangedListener mVisibilityChangedListener;
    /* access modifiers changed from: private */
    public String source;
    /* access modifiers changed from: private */
    public int timeoutTime;

    public interface IBubble {
        BubbleType bubbleShow(int i2);
    }

    public interface IDynSource {
        String getDynSource();
    }

    public interface IExpUserListener {
        void onIsExpUser(boolean z);
    }

    public interface IGetParentViewListener {
        ViewGroup getParentView();
    }

    public interface IGetVideoIsPlay {
        boolean videoIsPlay();
    }

    public interface IGetViewConfigListener {
        NewTimerViewEdgeConfig getViewConfig();
    }

    public interface IInterceptor {
        boolean shouldInterceptor();
    }

    public interface IIsSingleTaskTimerListener {
        Boolean isSingleTaskTimer();
    }

    public interface IOnSignListener {
        void onSignComplete(boolean z, TaskSdkData taskSdkData);
    }

    public interface ITimerClosedListener {
        void onTimerClosed();
    }

    public interface ITimerDynUBCExt {
        Map<String, String> getDynUBCExt();
    }

    public interface ITimerShowWindowCallback {
        void onDismiss(String str, Map<String, String> map);

        void onShowWindow(String str, boolean z, Map<String, String> map);
    }

    public interface ITimerSubBusinessTypeListener {
        SubBusinessType getSubBusinessType();
    }

    public interface IVisibilityChangedListener {
        void onVisibilityChanged(int i2);
    }

    private TaskConfig() {
        this.mBusinessType = BusinessType.TYPE_DEFAULT;
        this.actionId = "";
        this.timeoutTime = -1;
        this.isAutoNext = true;
        this.autoDismiss = false;
        this.isTimeoutPause = true;
        this.source = "default";
        this.loginToastText = LOGIN_TOAST_TEXT_DEFAULT;
        this.isMutexComponent = true;
    }

    public Activity getContext() {
        WeakReference<Activity> weakReference = this.mReference;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public BusinessType getPageType() {
        return this.mBusinessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.mBusinessType = businessType;
    }

    public IGetViewConfigListener getGetViewConfigListener() {
        return this.mGetViewConfigListener;
    }

    public int getTimeoutTime() {
        return this.timeoutTime;
    }

    public IInterceptor getAutoNextInterceptor() {
        return this.mAutoNextInterceptor;
    }

    public IBubble getBubble() {
        return this.mBubble;
    }

    public IDynSource getDynSource() {
        return this.mDynSource;
    }

    public IInterceptor getTimeoutInterceptor() {
        return this.mTimeoutInterceptor;
    }

    public IGetVideoIsPlay getGetVideoIsPlay() {
        return this.mGetVideoIsPlay;
    }

    public boolean isAutoNext() {
        return this.isAutoNext;
    }

    public String getSource() {
        return this.source;
    }

    public String getLoginToastText() {
        return this.loginToastText;
    }

    public boolean isAutoDismiss() {
        return this.autoDismiss;
    }

    public boolean isTimeoutPause() {
        return this.isTimeoutPause;
    }

    public IGetParentViewListener getGetParentView() {
        return this.mGetParentViewListener;
    }

    public IIsSingleTaskTimerListener getIsSingleTaskTimerListener() {
        return this.mIsSingleTaskTimerListener;
    }

    public IOnSignListener getOnSignListener() {
        return this.mOnSignListener;
    }

    public IExpUserListener getExpUserListener() {
        return this.mExpUserListener;
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    public boolean isMutexComponent() {
        return this.isMutexComponent;
    }

    public void setMutexComponent(boolean mutexComponent) {
        this.isMutexComponent = mutexComponent;
    }

    public void setActionId(String actionId2) {
        this.actionId = actionId2;
    }

    public String getActionId() {
        return this.actionId;
    }

    public ITaskStatusCallback getTaskStatusCallback() {
        return this.mTaskStatusCallback;
    }

    public IVisibilityChangedListener getVisibilityChangedListener() {
        return this.mVisibilityChangedListener;
    }

    public ITimerClosedListener getTimerClosedListener() {
        return this.mTimerClosedListener;
    }

    public ITimerSubBusinessTypeListener getTimerSubBusinessTypeListener() {
        return this.mTimerSubBusinessTypeListener;
    }

    public ITimerShowWindowCallback getTimerShowWindowCallback() {
        return this.mTimerShowWindowCallback;
    }

    public ITimerDynUBCExt getTimerDynUBCExt() {
        return this.mTimerDynUBCExt;
    }

    public void release() {
        WeakReference<Activity> weakReference = this.mReference;
        if (weakReference != null) {
            weakReference.clear();
            this.mReference = null;
        }
        this.mBusinessType = null;
        this.mGetViewConfigListener = null;
        this.mGetParentViewListener = null;
        this.mIsSingleTaskTimerListener = null;
        this.mTimeoutInterceptor = null;
        this.mLayoutParams = null;
        this.mGetVideoIsPlay = null;
        this.mOnSignListener = null;
        this.mExpUserListener = null;
        this.mTaskStatusCallback = null;
        this.mVisibilityChangedListener = null;
        this.mTimerClosedListener = null;
        this.mTimerSubBusinessTypeListener = null;
        this.mTimerShowWindowCallback = null;
        this.mTimerDynUBCExt = null;
    }

    public static TaskConfig clone(TaskConfig config, Activity activity, BusinessType businessType) {
        if (config == null) {
            config = new TaskConfig();
        }
        config.mBusinessType = businessType;
        config.mReference = new WeakReference<>(activity);
        return config;
    }

    public String getActTaskId() {
        return this.actTaskId;
    }

    public void setActTaskId(String actTaskId2) {
        this.actTaskId = actTaskId2;
    }

    public static class Builder {
        private TaskConfig mConfig = new TaskConfig();

        public Builder setGetViewConfig(IGetViewConfigListener viewEdgeConfig) {
            IGetViewConfigListener unused = this.mConfig.mGetViewConfigListener = viewEdgeConfig;
            return this;
        }

        public Builder setGetParentViewListener(IGetParentViewListener mGetParentViewListener) {
            IGetParentViewListener unused = this.mConfig.mGetParentViewListener = mGetParentViewListener;
            return this;
        }

        public Builder setSingleTaskListener(IIsSingleTaskTimerListener mIsSingleTaskTimer) {
            IIsSingleTaskTimerListener unused = this.mConfig.mIsSingleTaskTimerListener = mIsSingleTaskTimer;
            return this;
        }

        public Builder setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            ViewGroup.LayoutParams unused = this.mConfig.mLayoutParams = layoutParams;
            return this;
        }

        public Builder setTimeoutTime(int timeoutTime) {
            int unused = this.mConfig.timeoutTime = timeoutTime;
            return this;
        }

        public Builder setAutoNext(boolean autoNext) {
            boolean unused = this.mConfig.isAutoNext = autoNext;
            return this;
        }

        public Builder setAutoNextInterceptor(IInterceptor autoNextInterceptor) {
            IInterceptor unused = this.mConfig.mAutoNextInterceptor = autoNextInterceptor;
            return this;
        }

        public Builder setTimeoutInterceptor(IInterceptor timeoutInterceptor) {
            IInterceptor unused = this.mConfig.mTimeoutInterceptor = timeoutInterceptor;
            return this;
        }

        public Builder setGetVideoIsPlay(IGetVideoIsPlay getVideoIsPlay) {
            IGetVideoIsPlay unused = this.mConfig.mGetVideoIsPlay = getVideoIsPlay;
            return this;
        }

        public Builder setBubble(IBubble bubble) {
            IBubble unused = this.mConfig.mBubble = bubble;
            return this;
        }

        public Builder setDynSource(IDynSource dynSource) {
            IDynSource unused = this.mConfig.mDynSource = dynSource;
            return this;
        }

        public Builder setAutoDismiss(boolean autoDismiss) {
            boolean unused = this.mConfig.autoDismiss = autoDismiss;
            return this;
        }

        public Builder setTimeoutPause(boolean timeoutPause) {
            boolean unused = this.mConfig.isTimeoutPause = timeoutPause;
            return this;
        }

        public Builder setSource(String source) {
            String unused = this.mConfig.source = source;
            return this;
        }

        public Builder setLoginToastText(String text) {
            String unused = this.mConfig.loginToastText = text;
            return this;
        }

        public Builder setTaskStatusCallback(ITaskStatusCallback taskStatusCallback) {
            ITaskStatusCallback unused = this.mConfig.mTaskStatusCallback = taskStatusCallback;
            return this;
        }

        public Builder setOnSignListener(IOnSignListener onSignListener) {
            IOnSignListener unused = this.mConfig.mOnSignListener = onSignListener;
            return this;
        }

        public Builder setExpUserListener(IExpUserListener expUserListener) {
            IExpUserListener unused = this.mConfig.mExpUserListener = expUserListener;
            return this;
        }

        public Builder setVisibilityChangedListener(IVisibilityChangedListener visibilityChangedListener) {
            IVisibilityChangedListener unused = this.mConfig.mVisibilityChangedListener = visibilityChangedListener;
            return this;
        }

        public Builder setTimerClosedListener(ITimerClosedListener timerClosedListener) {
            ITimerClosedListener unused = this.mConfig.mTimerClosedListener = timerClosedListener;
            return this;
        }

        public Builder setTimerSubBusinessTypeListener(ITimerSubBusinessTypeListener timerSubBusinessTypeListener) {
            ITimerSubBusinessTypeListener unused = this.mConfig.mTimerSubBusinessTypeListener = timerSubBusinessTypeListener;
            return this;
        }

        public Builder setTimerShowWindowCallback(ITimerShowWindowCallback timerShowWindowCallback) {
            ITimerShowWindowCallback unused = this.mConfig.mTimerShowWindowCallback = timerShowWindowCallback;
            return this;
        }

        public Builder setTimerDynUBCExt(ITimerDynUBCExt timerDynUbcExt) {
            ITimerDynUBCExt unused = this.mConfig.mTimerDynUBCExt = timerDynUbcExt;
            return this;
        }

        public Builder setPageTag(String tag) {
            this.mConfig.mBusinessType.setPageTag(tag);
            return this;
        }

        public TaskConfig builder() {
            return this.mConfig;
        }
    }
}
