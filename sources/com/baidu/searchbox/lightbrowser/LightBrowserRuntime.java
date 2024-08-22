package com.baidu.searchbox.lightbrowser;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.dependency.iocimpl.FeedDetailSpeedLoggerImpl_Factory;
import com.baidu.searchbox.feed.news.pinchsummary.FeedNewsPinchSummaryImpl_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserActionToolBar_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserAtlas_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserComment_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserComponent_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserDownload_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserFavorHis_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserFeed_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserFeedback_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserJsBridge_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserMenu_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserNoTraceInvoke_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserSchemeParse_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserSuspensionBall_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserTeenMode_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserUBC_Factory;
import com.baidu.searchbox.lightbrowser.dependency.LightBrowserVideo_Factory;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserActionToolBar;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserAtlas;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserComment;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserComponent;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserDownload;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserFavorHis;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserFeed;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserFeedback;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserJsBridge;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserMenu;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserNoTraceInvoke;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserPinchSummary;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserSchemeParse;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserSuspensionBall;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserTeenMode;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserUBC;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserVideo;
import com.baidu.searchbox.lightbrowser.nad.INadBrowserCreator;
import com.baidu.searchbox.lightbrowser.timelogger.ILightBrowserSpeedLogger;
import com.baidu.searchbox.nadbrowser.NadBrowserCreator_Factory;

public class LightBrowserRuntime {
    public static boolean GLOBAL_DEBUG = AppConfig.isDebug();

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static ILightBrowserSpeedLogger getLightBrowserSpeedLogger() {
        return FeedDetailSpeedLoggerImpl_Factory.get();
    }

    public static ILightBrowserFavorHis getLightBrowserFavorHis() {
        return LightBrowserFavorHis_Factory.get();
    }

    public static ILightBrowserSuspensionBall getLightBrowserSuspensionBall() {
        return LightBrowserSuspensionBall_Factory.get();
    }

    public static ILightBrowserFeedback getLightBrowserFeedback() {
        return LightBrowserFeedback_Factory.get();
    }

    public static ILightBrowserJsBridge getLightBrowserJsBridge() {
        return LightBrowserJsBridge_Factory.get();
    }

    public static ILightBrowserSchemeParse getLightBrowserSchemeParse() {
        return LightBrowserSchemeParse_Factory.get();
    }

    public static ILightBrowserAtlas getLightBrowserAtlas() {
        return LightBrowserAtlas_Factory.get();
    }

    public static ILightBrowserComment getLightBrowserComment() {
        return LightBrowserComment_Factory.get();
    }

    public static ILightBrowserNoTraceInvoke getLightBrowserNoTraceInvoke() {
        return LightBrowserNoTraceInvoke_Factory.get();
    }

    public static ILightBrowserVideo getLightBrowserVideo() {
        return LightBrowserVideo_Factory.get();
    }

    public static ILightBrowserMenu getLightBrowserMenu() {
        return LightBrowserMenu_Factory.get();
    }

    public static ILightBrowserActionToolBar getLightBrowserActionToolBar() {
        return LightBrowserActionToolBar_Factory.get();
    }

    public static ILightBrowserUBC getLightBrowserUBC() {
        return LightBrowserUBC_Factory.get();
    }

    public static ILightBrowserFeed getLightBrowserFeed() {
        return LightBrowserFeed_Factory.get();
    }

    public static ILightBrowserDownload getLightBrowserDownload() {
        return LightBrowserDownload_Factory.get();
    }

    public static ILightBrowserContext getLightBrowserContext() {
        return LightBrowserContext_Factory.get();
    }

    public static ILightBrowserTeenMode getLightBrowserTeenMode() {
        return LightBrowserTeenMode_Factory.get();
    }

    public static INadBrowserCreator getAdBrowserCreator() {
        return NadBrowserCreator_Factory.get();
    }

    public static ILightBrowserComponent getLightBrowserComponent() {
        return LightBrowserComponent_Factory.get();
    }

    public static ILightBrowserPinchSummary getLightPinchSummary() {
        return FeedNewsPinchSummaryImpl_Factory.get();
    }
}
