package com.baidu.searchbox.feed.widget.interestselect;

import android.os.Build;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.feed.refreshex.RefreshRevolutionary;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.widget.interestselectv2.InterestSelectViewV2;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import org.json.JSONObject;

public class FeedLaunchInterestGuideManager {
    public static final String HAS_SHOWN_INTEREST_GUIDE_VERSION = "has_shown_interest_guide_version";
    public static final String INTEREST_GUIDE_SHOW_TIMESTAMP_SP_KEY = "interest_guide_show_timestamp_sp_key";
    public static String sUserType = "";

    public interface LaunchInterestGuideCallback {
        void needFinish();

        void show();
    }

    public void showInterestGuide(BaseActivity activity, LaunchInterestGuideCallback callback) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            callback.needFinish();
        } else if (!InterestSelectDataSrc.INSTANCE.dataHasReady()) {
            callback.needFinish();
        } else {
            InterestSelectViewV2 selectViewV2 = new InterestSelectViewV2(activity);
            selectViewV2.setInterestGuideCallBack(new GuideCallback(activity, callback));
            final FrameLayout selectView = selectViewV2;
            final ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            final LaunchInterestGuideCallback launchInterestGuideCallback = callback;
            final BaseActivity baseActivity = activity;
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (viewGroup == null) {
                        launchInterestGuideCallback.needFinish();
                        return;
                    }
                    FeedLaunchInterestGuideManager.setFullScreenImmersion(baseActivity, true);
                    viewGroup.addView(selectView, new ViewGroup.LayoutParams(-1, -1));
                    QuickPersistConfig.getInstance().putString(FeedLaunchInterestGuideManager.HAS_SHOWN_INTEREST_GUIDE_VERSION, InterestSelectDataSrc.INSTANCE.getVersion());
                    QuickPersistConfig.getInstance().putLong(FeedLaunchInterestGuideManager.INTEREST_GUIDE_SHOW_TIMESTAMP_SP_KEY, System.currentTimeMillis());
                    FeedStatisticCenter.ubcInterestSelect("display", (JSONObject) null);
                }
            });
        }
    }

    public static void setFullScreenImmersion(BaseActivity activity, boolean fullScreen) {
        if (activity != null) {
            try {
                activity.setEnableImmersion(false);
                if (fullScreen) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(1028);
                    activity.getWindow().addFlags(1024);
                    WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                    if (Build.VERSION.SDK_INT >= 28) {
                        lp.layoutInDisplayCutoutMode = 1;
                        activity.getWindow().setAttributes(lp);
                    }
                    return;
                }
                activity.getWindow().clearFlags(1024);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class GuideCallback implements LaunchInterestGuideCallback {
        private final WeakReference<BaseActivity> activity;
        private final LaunchInterestGuideCallback callback;

        public GuideCallback(@Nullable BaseActivity activity2, @Nullable LaunchInterestGuideCallback callback2) {
            this.activity = new WeakReference<>(activity2);
            this.callback = callback2;
        }

        public void needFinish() {
            RefreshRevolutionary.updateInterestViewState(false);
            FeedLaunchInterestGuideManager.setFullScreenImmersion((BaseActivity) this.activity.get(), false);
            LaunchInterestGuideCallback launchInterestGuideCallback = this.callback;
            if (launchInterestGuideCallback != null) {
                launchInterestGuideCallback.needFinish();
            }
        }

        public void show() {
            RefreshRevolutionary.updateInterestViewState(true);
            FeedLaunchInterestGuideManager.setFullScreenImmersion((BaseActivity) this.activity.get(), true);
        }
    }
}
