package com.baidu.searchbox.video.utils;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/utils/VideoLoginUtils;", "", "()V", "isLogin", "", "login", "", "context", "Landroid/content/Context;", "source", "", "supportGuest", "title", "listener", "Lcom/baidu/searchbox/account/ILoginResultListener;", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoLoginUtils.kt */
public final class VideoLoginUtils {
    public static final VideoLoginUtils INSTANCE = new VideoLoginUtils();

    private VideoLoginUtils() {
    }

    @JvmStatic
    public static final boolean isLogin() {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        return mLoginManager != null && mLoginManager.isLogin();
    }

    public static /* synthetic */ void login$default(Context context, String str, boolean z, String str2, ILoginResultListener iLoginResultListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        login(context, str, z, str2, iLoginResultListener);
    }

    @JvmStatic
    public static final void login(Context context, String source, boolean supportGuest, String title, ILoginResultListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).showLoginComponentDialog(context, AccountComponentConfig.getDefaulgParamsBuilder().setMainTitleText(title).setLoginSrc(source).setSupportGuest(supportGuest).build(), listener);
    }
}
