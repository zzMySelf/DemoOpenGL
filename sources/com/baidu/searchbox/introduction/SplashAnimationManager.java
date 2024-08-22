package com.baidu.searchbox.introduction;

import android.util.Log;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.ad.ISplashAnimation;
import com.baidu.searchbox.feed.ad.SplashAnimationRuntime;
import java.util.HashMap;
import java.util.List;

public class SplashAnimationManager {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "SplashAnimationManager";
    private final HashMap<String, ISplashAnimation> map;

    private SplashAnimationManager() {
        this.map = new HashMap<>();
        init();
    }

    public static SplashAnimationManager getInstance() {
        return Holder.singleton;
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static SplashAnimationManager singleton = new SplashAnimationManager();

        private Holder() {
        }
    }

    private void init() {
        ListHolder<ISplashAnimation> splashAnimationHolder = new SplashAnimationRuntime().splashAnimationHolder;
        if (splashAnimationHolder != null) {
            List<ISplashAnimation> list = splashAnimationHolder.getList();
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ISplashAnimation splashAnimation = list.get(i2);
                    if (splashAnimation != null) {
                        this.map.put(splashAnimation.getTag(), splashAnimation);
                    }
                }
            }
        } else if (DEBUG) {
            Log.w(TAG, "splashAnimationHolder注入失败");
        }
    }

    public ISplashAnimation queryByTag(String tag) {
        ISplashAnimation iSplashAnimation = this.map.get(tag);
        if (DEBUG && iSplashAnimation == null) {
            Log.w(TAG, "未找到对应的实现类 ： " + tag);
        }
        return iSplashAnimation;
    }
}
