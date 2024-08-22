package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.lightapp.multipage.LangbridgePreloadCellCenter;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class LightappWebViewCenter implements NoProguard, h.a {
    public static final String TAG = "LightappWebViewCenter";
    public int a;
    public Handler b;
    public LightappBrowserWebView c;
    public LinkedBlockingQueue<LightappBrowserWebView> d;
    public MutableContextWrapper e;
    public boolean f;
    public Context g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f3561i;

    public static class a {
        public static LightappWebViewCenter a = new LightappWebViewCenter();
    }

    public static /* synthetic */ int b(LightappWebViewCenter lightappWebViewCenter) {
        int i2 = lightappWebViewCenter.h;
        lightappWebViewCenter.h = i2 - 1;
        return i2;
    }

    public static LightappWebViewCenter getInstance() {
        return a.a;
    }

    public static boolean isLightappWebViewCenterOn(Context context) {
        return SdkInitResponse.getInstance().isLangbridgeSpeedUpEnable(DxmApplicationContextImpl.getApplicationContext(context));
    }

    public LightappBrowserWebView getLightappWebView(Context context) {
        if (!isLightappWebViewCenterOn(context) || this.f) {
            return new LightappBrowserWebView(context);
        }
        this.f = true;
        return initLightappWebView(context);
    }

    public LightappBrowserWebView getLightappWebViewFromPool() {
        LightappBrowserWebView lightappBrowserWebView;
        InterruptedException e2;
        if (this.d == null || this.g == null) {
            DXMSdkSAUtils.onEvent("#webviewPoolNotInit");
            return null;
        } else if (!h.a().a(this.g).MW_ON || this.d.size() <= 0) {
            return null;
        } else {
            try {
                lightappBrowserWebView = this.d.take();
                try {
                    lightappBrowserWebView.onResume();
                    lightappBrowserWebView.clearHistory();
                } catch (InterruptedException e3) {
                    e2 = e3;
                }
            } catch (InterruptedException e4) {
                e2 = e4;
                lightappBrowserWebView = null;
                e2.printStackTrace();
                return lightappBrowserWebView;
            }
            return lightappBrowserWebView;
        }
    }

    public LightappBrowserWebView initLightappWebView(Context context) {
        if (this.c == null) {
            this.e = new MutableContextWrapper(context);
            this.c = new LightappBrowserWebView(this.e);
        } else {
            MutableContextWrapper mutableContextWrapper = this.e;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(context);
                this.c.clearHistory();
            }
        }
        return this.c;
    }

    public void initLightappWebViewPool(@NonNull Activity activity) {
        if (activity != null && this.d == null) {
            h.a().a((h.a) this);
            if (h.a().a((Context) activity).MW_ON) {
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = h.a().a((Context) activity).MW_WEBVIEW_POOL_SIZE;
                if (i2 > 0) {
                    this.d = new LinkedBlockingQueue<>(i2);
                    this.g = activity.getApplication();
                    while (this.d.remainingCapacity() > 0) {
                        LightappBrowserWebView lightappBrowserWebView = new LightappBrowserWebView(activity);
                        try {
                            lightappBrowserWebView.loadUrl("about:blank");
                            lightappBrowserWebView.setBaseContext(this.g);
                            lightappBrowserWebView.onPause();
                            this.d.put(lightappBrowserWebView);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    LogUtil.i(TAG, "init webview pool cost: " + currentTimeMillis2);
                    DXMSdkSAUtils.onEventWithValues("#eventInitWebviewPool", Arrays.asList(new String[]{currentTimeMillis2 + ""}));
                }
            }
        }
    }

    public void initWebViewCore(Context context) {
        String userAgentString = new LightappBrowserWebView(DxmApplicationContextImpl.getApplicationContext(context)).getSettings().getUserAgentString();
        if (userAgentString != null && !userAgentString.contains(BaiduWallet.TAG)) {
            userAgentString = userAgentString + " " + BussinessUtils.getUA(DxmApplicationContextImpl.getApplicationContext(context));
        }
        if (!TextUtils.isEmpty(userAgentString)) {
            LangbridgeCacheManager.getInstance().setLangbridgeUA(userAgentString);
        }
    }

    public void onSettingUpdated(LangbridgeSettings langbridgeSettings) {
        if ((!h.a().a(this.g).MW_ON || h.a().a(this.g).MW_USE_OLD) && this.d != null) {
            this.b.removeCallbacks(this.f3561i);
            LightappBrowserWebView lightappBrowserWebView = null;
            while (this.d.size() > 0) {
                try {
                    lightappBrowserWebView = this.d.take();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (lightappBrowserWebView != null) {
                    lightappBrowserWebView.destroy();
                }
            }
        }
    }

    public boolean releaseLightappWebView(@NonNull Context context, LightappBrowserWebView lightappBrowserWebView) {
        if (this.c != lightappBrowserWebView) {
            return false;
        }
        lightappBrowserWebView.removeAllViews();
        ViewGroup viewGroup = (ViewGroup) lightappBrowserWebView.getParent();
        if (viewGroup != null) {
            try {
                viewGroup.removeView(lightappBrowserWebView);
            } catch (Throwable th2) {
                LogUtil.e(TAG, "release Exception", th2);
            }
        }
        lightappBrowserWebView.loadUrl("about:blank");
        lightappBrowserWebView.clearHistory();
        lightappBrowserWebView.setWebViewClient((WebViewClient) null);
        lightappBrowserWebView.setWebChromeClient((WebChromeClient) null);
        lightappBrowserWebView.setDownloadListener((DownloadListener) null);
        lightappBrowserWebView.setOnTouchListener((View.OnTouchListener) null);
        lightappBrowserWebView.setOnMyScrollChangeListener((LightappWebView.a) null);
        lightappBrowserWebView.removeJavascriptInterface(LightappJsClient.LIGHTAPP_JS_NAME);
        lightappBrowserWebView.setVisibility(0);
        MutableContextWrapper mutableContextWrapper = this.e;
        if (mutableContextWrapper != null) {
            mutableContextWrapper.setBaseContext(DxmApplicationContextImpl.getApplicationContext(context));
        }
        this.f = false;
        return true;
    }

    public void releaseLightappWebView2Pool(Activity activity, LightappBrowserWebView lightappBrowserWebView) {
        if (lightappBrowserWebView != null) {
            lightappBrowserWebView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) lightappBrowserWebView.getParent();
            if (viewGroup != null) {
                try {
                    viewGroup.removeView(lightappBrowserWebView);
                } catch (Throwable th2) {
                    LogUtil.e(TAG, "release Exception", th2);
                }
            }
            lightappBrowserWebView.clearHistory();
            lightappBrowserWebView.destroy();
            this.a++;
        }
        LogUtil.i(TAG, "releaseLightappWebView2Pool1: " + lightappBrowserWebView.hashCode());
        if (!(this.d == null || activity == null || this.g == null || !h.a().a(this.g).MW_ON)) {
            while (this.a > 0 && this.d.remainingCapacity() > 0) {
                LightappBrowserWebView lightappBrowserWebView2 = new LightappBrowserWebView(activity);
                try {
                    lightappBrowserWebView2.loadUrl("about:blank");
                    lightappBrowserWebView2.setBaseContext(this.g);
                    lightappBrowserWebView2.onPause();
                    this.d.put(lightappBrowserWebView2);
                    this.a--;
                    LogUtil.i(TAG, "new inset" + lightappBrowserWebView2.hashCode() + " mLightappWebViewPool " + this.d.size());
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        LinkedBlockingQueue<LightappBrowserWebView> linkedBlockingQueue = this.d;
        if (linkedBlockingQueue == null || linkedBlockingQueue.remainingCapacity() == 0) {
            this.a = 0;
        }
    }

    public void startAutoChecker() {
        this.h = h.a().a(this.g).MW_PRELOAD_TEST_CHECK_MAX_TIMES;
        this.b.post(this.f3561i);
    }

    public LightappWebViewCenter() {
        this.a = 0;
        this.d = null;
        this.f = false;
        this.h = -1;
        this.f3561i = new Runnable() {
            public void run() {
                if (!h.a().a(LightappWebViewCenter.this.g).MW_USE_OLD && h.a().a(LightappWebViewCenter.this.g).MW_ON && h.a().a(LightappWebViewCenter.this.g).MW_START_PRELOAD_AUTO_TEST_NEW && LightappWebViewCenter.b(LightappWebViewCenter.this) > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("file:///android_asset/MWmonitorTest.html");
                    LangbridgePreloadCellCenter.getInstance(LightappWebViewCenter.this.g).preload(arrayList, 20, (String) null, (String) null);
                    LightappWebViewCenter.this.b.postDelayed(LightappWebViewCenter.this.f3561i, (long) (h.a().a(LightappWebViewCenter.this.g).MW_PRELOAD_AUTO_TEST_INTERVAL * 1000));
                }
            }
        };
        this.b = new Handler(Looper.getMainLooper());
    }

    public LightappBrowserWebView getLightappWebViewFromPool(@NonNull Activity activity, boolean z) {
        LightappBrowserWebView lightappBrowserWebView;
        LightappBrowserWebView lightappBrowserWebView2 = null;
        if (this.g == null || this.d == null) {
            if (activity != null) {
                DXMSdkSAUtils.onEvent("#webviewPoolNotInit");
                initLightappWebViewPool(activity);
            }
        } else if (h.a().a(this.g).MW_ON && this.d.size() > 0) {
            try {
                lightappBrowserWebView = this.d.take();
                if (lightappBrowserWebView != null) {
                    try {
                        lightappBrowserWebView.setBaseContext(activity);
                        lightappBrowserWebView.onResume();
                        lightappBrowserWebView.clearHistory();
                    } catch (InterruptedException e2) {
                        e = e2;
                        lightappBrowserWebView2 = lightappBrowserWebView;
                    }
                }
            } catch (InterruptedException e3) {
                e = e3;
                e.printStackTrace();
                lightappBrowserWebView = lightappBrowserWebView2;
                DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList(new String[]{"0"}));
                return lightappBrowserWebView;
            }
            DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList(new String[]{"0"}));
            return lightappBrowserWebView;
        }
        if (!z || activity == null) {
            return null;
        }
        DXMSdkSAUtils.onEventWithValues("#getWebviewPoolRetType", Arrays.asList(new String[]{"1"}));
        return new LightappBrowserWebView(activity);
    }
}
