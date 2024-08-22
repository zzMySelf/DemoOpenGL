package com.baidu.searchbox.feed.widget.operationfloat.taskfloat;

import android.text.TextUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.log.OnLineLogs;
import com.baidu.searchbox.feed.widget.operationfloat.BaseOperationFloatContainer;
import com.baidu.searchbox.feed.widget.operationfloat.HomeOperationModel;
import com.baidu.searchbox.feed.widget.operationfloat.IHomeOperationCache;
import com.baidu.searchbox.feed.widget.operationfloat.taskfloat.ITaskOperationContract;
import com.baidu.searchbox.feed.widget.operationfloat.taskfloat.listener.ViewAnimationListener;
import com.baidu.searchbox.feed.widget.operationfloat.taskfloat.listener.ViewLoadListener;
import com.baidu.searchbox.feed.widget.operationfloat.taskfloat.model.OperationTaskRepo;
import java.io.File;
import java.util.concurrent.TimeUnit;

class BaseOperationPresenter implements ITaskOperationContract.Presenter {
    private HomeOperationModel.Banner banner = new HomeOperationModel.Banner();
    IHomeOperationCache cache;
    private volatile boolean isInit;
    HomeOperationModel model;
    OperationTaskRepo repo = new OperationTaskRepo();
    /* access modifiers changed from: private */
    public final ResourcesAnimRunnable resourcesAnimRunnable = new ResourcesAnimRunnable();
    private final ResourcesLoadRunnable resourcesLoadRunnable = new ResourcesLoadRunnable();

    /* renamed from: view  reason: collision with root package name */
    ITaskOperationContract.View f18660view;

    private interface Anim {
        public static final int HIDE_ANIM = 4;
        public static final int HIDE_ANIMATING = 3;
        public static final int SHOW_ANIM = 2;
        public static final int SHOW_ANIMATING = 1;
    }

    public BaseOperationPresenter(ITaskOperationContract.View view2, HomeOperationModel model2, IHomeOperationCache cache2) {
        this.f18660view = view2;
        this.model = model2;
        this.cache = cache2;
    }

    public HomeOperationModel.Banner buildBanner() {
        return null;
    }

    public boolean isLogin() {
        BoxAccountManager loginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        return loginManager != null && loginManager.isLogin();
    }

    private void updateBanner(boolean force) {
        if (force) {
            this.banner.copy(buildBanner());
        } else if (!this.isInit) {
            this.isInit = true;
            this.banner.copy(buildBanner());
        }
    }

    public final String getImgUrl() {
        updateBanner(false);
        String url = this.banner.imgUrl;
        return TextUtils.isEmpty(url) ? "" : url;
    }

    /* access modifiers changed from: private */
    public long getDisplayMillis() {
        updateBanner(false);
        long time = (long) this.banner.displayTime;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long j2 = 0;
        if (time > 0) {
            j2 = time;
        }
        return timeUnit.toMillis(j2);
    }

    public final File getAfx() {
        updateBanner(false);
        return this.banner.afxFile;
    }

    /* access modifiers changed from: private */
    public int getWidth() {
        updateBanner(false);
        return this.banner.width;
    }

    /* access modifiers changed from: package-private */
    public boolean isResourcesLoad() {
        return this.resourcesLoadRunnable.isLoad();
    }

    public void initFloatView(boolean needAutoGuide) {
    }

    public void updateFloatView(String source) {
    }

    public void updateFloatViewOperationParam(int phase, OperationParam param) {
    }

    public void updateHomeOperationModel(HomeOperationModel model2) {
        this.model = model2;
        updateBanner(true);
    }

    public OperationParam getFloatViewOperationParam() {
        return null;
    }

    public void loadResourcesAfterTaskSignRequest(OperationParam param) {
    }

    public void loadResourcesWithDelay(int policy, OperationParam param) {
        loadResourcesWithDelay(policy, param, 0);
    }

    public void loadResourcesWithDelay(int policy, OperationParam param, long delayMillis) {
        this.resourcesLoadRunnable.reInit(policy, param);
        UiThreadUtils.getMainHandler().removeCallbacks(this.resourcesLoadRunnable);
        UiThreadUtils.getMainHandler().postDelayed(this.resourcesLoadRunnable, delayMillis);
    }

    public void onClick(OperationParam param) {
    }

    /* access modifiers changed from: package-private */
    public boolean loadResourceWithVerifyFeeding() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean tryLoadResource(int policy) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void loadImgResource(String url, int width, OperationParam param, ViewLoadListener listener) {
    }

    /* access modifiers changed from: package-private */
    public void loadAfxResource(File file, int width, OperationParam param, ViewLoadListener listener) {
    }

    /* access modifiers changed from: package-private */
    public void loadFinalResource(OperationParam param) {
        this.f18660view.setPlayingAnim(false);
    }

    /* access modifiers changed from: package-private */
    public void startViewAnimation(OperationParam param) {
        startViewAnimation(param, 0);
    }

    /* access modifiers changed from: package-private */
    public void startViewAnimation(OperationParam param, long displayMillis) {
        this.resourcesAnimRunnable.setState(4);
        this.resourcesAnimRunnable.reInit(param, displayMillis);
        UiThreadUtils.getMainHandler().removeCallbacks(this.resourcesAnimRunnable);
        UiThreadUtils.getMainHandler().postDelayed(this.resourcesAnimRunnable, 10);
    }

    /* access modifiers changed from: package-private */
    public boolean tryRemoveViewAnimation() {
        int state = this.resourcesAnimRunnable.state();
        if (state != 4 && state != 2) {
            return false;
        }
        UiThreadUtils.getMainHandler().removeCallbacks(this.resourcesAnimRunnable);
        this.resourcesAnimRunnable.setState(4);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void showViewAnimating(OperationParam param, ViewAnimationListener listener) {
    }

    /* access modifiers changed from: package-private */
    public void showViewAnimation(OperationParam param) {
    }

    /* access modifiers changed from: package-private */
    public void hideViewAnimating(OperationParam param, ViewAnimationListener listener) {
    }

    /* access modifiers changed from: package-private */
    public void hideViewAnimation(OperationParam param) {
    }

    private static class Verify {
        private Verify() {
        }

        static boolean assertLegalArgumentWidth(int width) {
            if (width == -1) {
                return true;
            }
            int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(FeedRuntime.getAppContext());
            if (width <= 0 || width > screenWidth - (BaseOperationFloatContainer.BOTTOM_MARGIN_NO_TTS * 2)) {
                return false;
            }
            return true;
        }

        static boolean assertLegalArgumentImgUrl(String url) {
            return !TextUtils.isEmpty(url);
        }

        static boolean assertLegalArgumentAfxFile(File file) {
            return file != null && file.exists();
        }
    }

    private class ResourcesLoadRunnable extends ViewLoadListener implements Runnable {
        private static final int DELAY_TIME = 1000;
        private volatile boolean isLoad;
        private volatile boolean isLoadedAFX;
        private OperationParam param;
        private int policy;

        private ResourcesLoadRunnable() {
            this.isLoadedAFX = false;
            this.isLoad = false;
        }

        private synchronized void setLoad(boolean b2) {
            this.isLoad = b2;
        }

        public synchronized boolean isLoad() {
            return this.isLoad;
        }

        public void onLoadSuccess() {
            setLoad(false);
        }

        public void onLoadFailure(String error, Throwable thr) {
            setLoad(false);
        }

        /* access modifiers changed from: private */
        public void reInit(int policy2, OperationParam param2) {
            this.policy = policy2;
            this.param = param2;
        }

        private boolean tryLoadAfxResource(int policy2) {
            String clazzName = BaseOperationPresenter.this.getClass().getSimpleName();
            if ((this.policy & policy2) == 0) {
                OnLineLogs.getOperationFloat().e(clazzName + " not hit afx policy");
                return false;
            } else if (!BaseOperationPresenter.this.tryLoadResource(policy2)) {
                OnLineLogs.getOperationFloat().e(clazzName + " ignore afx");
                return false;
            } else if (this.isLoadedAFX) {
                OnLineLogs.getOperationFloat().e(clazzName + " has loaded afx");
                return false;
            } else {
                int width = -1;
                File afx = BaseOperationPresenter.this.getAfx();
                File file = afx;
                if (Verify.assertLegalArgumentAfxFile(afx)) {
                    int access$600 = BaseOperationPresenter.this.getWidth();
                    width = access$600;
                    if (Verify.assertLegalArgumentWidth(access$600)) {
                        this.isLoadedAFX = true;
                        setLoad(true);
                        BaseOperationPresenter.this.loadAfxResource(file, width, this.param, this);
                        return true;
                    }
                }
                OnLineLogs.getOperationFloat().e(clazzName + " afx resource fail file:" + file + ", width:" + width);
                return false;
            }
        }

        private boolean tryLoadImgResource(int policy2) {
            String clazzName = BaseOperationPresenter.this.getClass().getSimpleName();
            if ((this.policy & policy2) == 0) {
                OnLineLogs.getOperationFloat().e(clazzName + " not hit img policy");
                return false;
            } else if (!BaseOperationPresenter.this.tryLoadResource(policy2)) {
                OnLineLogs.getOperationFloat().e(clazzName + " ignore img");
                return false;
            } else {
                int width = -1;
                String imgUrl = BaseOperationPresenter.this.getImgUrl();
                String url = imgUrl;
                if (Verify.assertLegalArgumentImgUrl(imgUrl)) {
                    int access$600 = BaseOperationPresenter.this.getWidth();
                    width = access$600;
                    if (Verify.assertLegalArgumentWidth(access$600)) {
                        setLoad(true);
                        BaseOperationPresenter.this.loadImgResource(url, width, this.param, this);
                        return true;
                    }
                }
                OnLineLogs.getOperationFloat().e(clazzName + " img resource fail url:" + url + ", width:" + width);
                return false;
            }
        }

        public final void run() {
            if (!BaseOperationPresenter.this.loadResourceWithVerifyFeeding() || !BaseOperationPresenter.this.f18660view.isFeeding()) {
                String clazzName = BaseOperationPresenter.this.getClass().getSimpleName();
                if (this.isLoad) {
                    OnLineLogs.getOperationFloat().e(clazzName + " resource is loading...");
                    return;
                }
                int state = BaseOperationPresenter.this.resourcesAnimRunnable.state();
                if (state != 4) {
                    OnLineLogs.getOperationFloat().e(clazzName + " resource is animating state:" + state);
                } else if (!tryLoadAfxResource(2) && !tryLoadImgResource(1)) {
                    BaseOperationPresenter.this.loadFinalResource(this.param);
                }
            } else {
                UiThreadUtils.getMainHandler().postDelayed(this, 1000);
            }
        }
    }

    private class ResourcesAnimRunnable extends ViewAnimationListener implements Runnable {
        private long displayMillis;
        private final OperationParam param;
        private volatile int state;

        private ResourcesAnimRunnable() {
            this.state = 4;
            this.param = OperationParam.newInstance();
            this.displayMillis = 0;
        }

        /* access modifiers changed from: private */
        public void reInit(OperationParam param2, long displayMillis2) {
            this.param.copy(param2);
            this.displayMillis = displayMillis2;
        }

        /* access modifiers changed from: private */
        public synchronized int state() {
            return this.state;
        }

        /* access modifiers changed from: private */
        public synchronized void setState(int state2) {
            this.state = state2;
        }

        /* Debug info: failed to restart local var, previous not found, register: 5 */
        public final void run() {
            try {
                if (state() == 4) {
                    setState(1);
                    BaseOperationPresenter.this.showViewAnimating(this.param, this);
                } else if (state() == 1) {
                    setState(2);
                    long j2 = this.displayMillis;
                    if (j2 == 0) {
                        j2 = BaseOperationPresenter.this.getDisplayMillis();
                    }
                    this.displayMillis = j2;
                    UiThreadUtils.getMainHandler().postDelayed(this, this.displayMillis);
                    BaseOperationPresenter.this.showViewAnimation(this.param);
                } else if (state() == 2) {
                    setState(3);
                    BaseOperationPresenter.this.hideViewAnimating(this.param, this);
                } else if (state() == 3) {
                    setState(4);
                    BaseOperationPresenter.this.hideViewAnimation(this.param);
                } else {
                    throw new IllegalStateException("动画阶段：" + state());
                }
            } catch (Exception e2) {
                OnLineLogs.getOperationFloat().e(BaseOperationPresenter.this.getClass().getSimpleName() + " anim fail");
            }
        }

        public final void onAnimationFinally() {
            run();
        }
    }
}
