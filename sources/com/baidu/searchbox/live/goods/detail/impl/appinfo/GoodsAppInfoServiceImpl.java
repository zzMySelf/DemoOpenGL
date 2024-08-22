package com.baidu.searchbox.live.goods.detail.impl.appinfo;

import android.app.Application;
import android.content.Context;
import com.baidu.browser.BrowserType;
import com.baidu.common.param.CommonParamRuntime;
import com.baidu.common.param.ICommonParamContext;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUrlConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.deviceinfo.IDevicePortraitManager;
import com.baidu.searchbox.live.goods.detail.interfaces.DI;
import com.baidu.searchbox.live.goods.detail.interfaces.appinfo.IAppInfoService;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.sofire.ac.FH;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/live/goods/detail/impl/appinfo/GoodsAppInfoServiceImpl;", "Lcom/baidu/searchbox/live/goods/detail/interfaces/appinfo/IAppInfoService;", "()V", "getActEnterAnim", "", "getActExitAnim", "getAppId", "", "getApplication", "Landroid/app/Application;", "getBdOz", "context", "Landroid/content/Context;", "getCloudControlUrl", "getCuid", "getImAppId", "getPackageName", "getProtocol", "getSid", "getStaticDeviceScore", "", "getUA", "getVersionCode", "getVersionName", "getZid", "isDebug", "", "isNightMode", "lib-goods-detail-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsAppInfoServiceImpl.kt */
public final class GoodsAppInfoServiceImpl implements IAppInfoService {
    public String getPackageName() {
        String packageName = AppConfig.AppInfo.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName()");
        return packageName;
    }

    public String getVersionCode() {
        String versionCode = AppConfig.AppInfo.getVersionCode();
        Intrinsics.checkNotNullExpressionValue(versionCode, "getVersionCode()");
        return versionCode;
    }

    public String getVersionName() {
        String versionName = AppConfig.AppInfo.getVersionName();
        Intrinsics.checkNotNullExpressionValue(versionName, "getVersionName()");
        return versionName;
    }

    public boolean isDebug() {
        return AppConfig.isDebug();
    }

    public String getImAppId() {
        return "405384";
    }

    public Application getApplication() {
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null) {
            return (Application) appContext;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public boolean isNightMode() {
        return NightModeHelper.getNightModeSwitcherState();
    }

    public String getSid() {
        ICommonParamContext commonParamContext = CommonParamRuntime.getCommonParamContext();
        String sid = commonParamContext != null ? commonParamContext.getSid() : null;
        return sid == null ? "" : sid;
    }

    public String getZid() {
        String zid = BaiduIdentityManager.getInstance().getZid();
        Intrinsics.checkNotNullExpressionValue(zid, "getInstance().zid");
        return zid;
    }

    public String getCuid() {
        String uid = BaiduIdentityManager.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        return uid;
    }

    public String getUA() {
        BaiduIdentityManager manager = BaiduIdentityManager.getInstance();
        String processUserAgent = manager.processUserAgent(manager.getOriginUserAgent(), BrowserType.MAIN);
        Intrinsics.checkNotNullExpressionValue(processUserAgent, "manager.processUserAgent…rAgent, BrowserType.MAIN)");
        return processUserAgent;
    }

    public String getAppId() {
        return "mobilebaidu";
    }

    public float getStaticDeviceScore(Context context) {
        IDevicePortraitManager devicePortraitManager = (IDevicePortraitManager) ServiceManager.getService(IDevicePortraitManager.SERVICE_REFERENCE);
        if (devicePortraitManager == null) {
            return -1.0f;
        }
        return devicePortraitManager.getStaticDeviceScore(context);
    }

    public String getCloudControlUrl() {
        String cloudControlUrl = CloudControlUrlConfig.getCloudControlUrl("");
        Intrinsics.checkNotNullExpressionValue(cloudControlUrl, "getCloudControlUrl(\"\")");
        return cloudControlUrl;
    }

    public String getProtocol() {
        return "baiduboxapp";
    }

    public int getActEnterAnim() {
        return DI.Res.INSTANCE.getACT_ENTER_ANIM();
    }

    public int getActExitAnim() {
        return DI.Res.INSTANCE.getACT_EXIT_ANIM();
    }

    public String getBdOz(Context context) {
        String got = FH.got(context);
        Intrinsics.checkNotNullExpressionValue(got, "got(context)");
        return got;
    }
}
