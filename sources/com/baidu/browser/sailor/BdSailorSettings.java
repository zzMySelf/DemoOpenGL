package com.baidu.browser.sailor;

import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;

public final class BdSailorSettings {
    private boolean mAdBlockEnable = false;
    private boolean mDebugEnable;
    private String mEmulatedUA;
    private boolean mImageViewer = true;
    private boolean mIsAllowTransCode = false;
    private boolean mIsAllowTransLang = true;
    private boolean mIsGifFirstFrameOnly;
    private boolean mNightMode;
    private boolean mOpenEyeShieldMode;
    private boolean mOpenOverSeasProxy;
    private boolean mOpenSpdy;
    private String mSafeCheck;
    private boolean mSailorMonitorEnable = true;
    private boolean mSaveFlow = true;
    private boolean mUaEmulate;
    private boolean mUrlSecureCheck = true;

    protected BdSailorSettings() {
    }

    public final void setJavaScriptEnabledOnFileScheme(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA, z);
    }

    public final boolean isJavaScriptEnabledOnFileScheme() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA);
    }

    @Deprecated
    public final void setFixWebViewSecurityHoles(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES, z);
    }

    public final void setNightTheme(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_NIGHT_THEME, z);
        this.mNightMode = z;
        BdSailorPlatform.getInstance().setNightMode(z);
    }

    public final void setOpenEyeShieldMode(boolean z) {
        this.mOpenEyeShieldMode = z;
        setStaticWebSeting(WebViewFactoryProvider.SETTING_EYE_SHIELD_MODE, z);
    }

    public final boolean getOpenEyeShieldMode() {
        return this.mOpenEyeShieldMode;
    }

    public final boolean isNightTheme() {
        return this.mNightMode;
    }

    public final boolean isAdBlockEnable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_AD_BLOCK);
    }

    public final boolean isPageFreezeDisable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_PAGE_FREEZE);
    }

    public final boolean isUaEmulateOn() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE);
    }

    public final String getEmulatedUA() {
        try {
            if (WebViewFactory.hasProvider()) {
                return (String) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE);
            }
            return "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th2) {
            Log.e(Log.LOG_TAG, "getStaticWebSeting error:".concat(String.valueOf(th2)));
            return "";
        }
    }

    public final boolean isDebugEnable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_DEBUG);
    }

    public final boolean isSaveFlow() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW);
    }

    public final void setAdBlockEnable(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_AD_BLOCK, z);
    }

    public final void setUaEmulateOn(boolean z) {
        this.mUaEmulate = z;
    }

    public final void setEmulatedUA(String str) {
        this.mEmulatedUA = str;
    }

    public final void setDebugEnable(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_DEBUG, z);
    }

    public final void setSaveFlow(boolean z) {
        int networkType = BdSailorPlatform.getInstance().getNetworkType();
        if (networkType == 1 || -1 == networkType) {
            this.mSaveFlow = false;
            setStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW, false);
            return;
        }
        this.mSaveFlow = z;
        setStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW, z);
    }

    public final void setSailorMonitorEnable(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_MONITOR, z);
    }

    public final boolean getSailorMonitorEnable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_MONITOR);
    }

    public final void setUrlSecureCheck(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK, z);
    }

    public final boolean isUrlSecureCheck() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK);
    }

    public final boolean isOpenSpdy() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY);
    }

    public final void setOpenSpdy(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY, z);
    }

    public final void setNoPicMode(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_NO_IMAGE_MODE, z);
    }

    public final boolean isOpenOverSeasProxy() {
        return this.mOpenOverSeasProxy;
    }

    public final void setOpenOverSeasProxy(boolean z) {
        this.mOpenOverSeasProxy = z;
    }

    public final void setProxyType() {
        WebSettings.ProxyType proxyType;
        WebSettings.ProxyType proxyType2 = WebSettings.ProxyType.NO_PROXY;
        if (this.mOpenSpdy) {
            if (this.mOpenOverSeasProxy) {
                proxyType = WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY;
            } else {
                proxyType = WebSettings.ProxyType.SPDY_PROXY;
            }
        } else if (this.mOpenOverSeasProxy) {
            proxyType = WebSettings.ProxyType.OVERSEAS_PROXY;
        } else {
            proxyType = WebSettings.ProxyType.NO_PROXY;
        }
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_PROXY_TYPE, new Integer(proxyType.ordinal()));
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th2)));
        }
    }

    public final String getSafeCheck() {
        return this.mSafeCheck;
    }

    public final void setSafeCheck(String str) {
        this.mSafeCheck = str;
    }

    public final boolean isGifFirstFrameOnly() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME);
    }

    public final void setGifFirstFrameOnly(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME, z);
    }

    public final void setAllowTransCode(boolean z) {
        this.mIsAllowTransCode = z;
    }

    public final void setAllowTransLang(boolean z) {
        this.mIsAllowTransLang = z;
    }

    public final boolean isAllowTransCode() {
        return this.mIsAllowTransCode;
    }

    public final boolean isAllowTransLang() {
        return this.mIsAllowTransLang;
    }

    private boolean getStaticWebSeting(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(str)).booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th2) {
            Log.e(Log.LOG_TAG, "getStaticWebSeting error:".concat(String.valueOf(th2)));
            return false;
        }
    }

    private void setStaticWebSeting(String str, boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(str, Boolean.valueOf(z));
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:".concat(String.valueOf(th2)));
        }
    }
}
