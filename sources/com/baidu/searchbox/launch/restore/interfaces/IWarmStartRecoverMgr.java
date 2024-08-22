package com.baidu.searchbox.launch.restore.interfaces;

import android.app.Activity;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/launch/restore/interfaces/IWarmStartRecoverMgr;", "", "onBackgroundToForeground", "", "activity", "Landroid/app/Activity;", "onForegroundToBackground", "lib-app-launch-restore-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWarmStartRecoverMgr.kt */
public interface IWarmStartRecoverMgr {
    void onBackgroundToForeground(Activity activity);

    void onForegroundToBackground(Activity activity);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IWarmStartRecoverMgr.kt */
    public static final class DefaultImpls {
        public static void onForegroundToBackground(IWarmStartRecoverMgr iWarmStartRecoverMgr, Activity activity) {
        }

        public static void onBackgroundToForeground(IWarmStartRecoverMgr iWarmStartRecoverMgr, Activity activity) {
        }
    }
}
