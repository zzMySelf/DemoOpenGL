package com.tera.scan.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import com.tera.scan.ui.widget.EmptyView;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.m.Cif;
import fe.mmm.qw.m.Cswitch;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseWebViewFragment extends BaseFragment implements View.OnClickListener, IBaseWebView {
    public static final String BACKGROUND_COLOR = "background_color";
    public static final String DEFAULT_CHECKER_SCAN = "https://pan.baidu.com/api/checker/scan";
    public static final String EXTRA_URL = "extra_url";
    public static final String LOAD_FAILED = "0";
    public static final String LOAD_NOT_FINISHED = "2";
    public static final String LOAD_SUCCESS = "1";
    public static final String TAG = "BaseWebViewFragment";
    public DownloadListener mDownloadListener;
    public EmptyView mEmptyView;
    public int mErrorCode = 0;
    public String mErrorDescription = "";
    public boolean mIsError;
    public boolean mIsLoadFinished = false;
    public LottieAnimationView mLottieAnimationView;
    public Cswitch mPerformanceStatic;
    public WebProgressBar mProgressBar;
    public IStateCallback mStateCallback;
    public TextView mTextLoading;
    public long mUrlLoadEndTime = 0;
    public long mUrlLoadStartTime = 0;
    public IUrlLoadable1 mUrlLoadable;
    public WebChromeClient mWebChromeClient;
    public TeraScanWebView mWebView;
    public WebViewClient mWebViewClient;
    public FrameLayout mWebViewContainer;
    public long mWebViewCreateTime = 0;

    private JSONObject buildExitPageExt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", getString(EXTRA_URL));
            jSONObject.put("exit_state", getExitState());
            jSONObject.put(WXLoginActivity.y, this.mErrorCode + this.mErrorDescription);
            jSONObject.put("create_time", this.mWebViewCreateTime);
            jSONObject.put("stay_time", System.currentTimeMillis() - this.mUrlLoadStartTime);
            if (this.mIsLoadFinished) {
                jSONObject.put("load_time", this.mUrlLoadEndTime - this.mUrlLoadStartTime);
            }
        } catch (JSONException e) {
            qw.th(TAG, e.getMessage(), e);
        }
        return jSONObject;
    }

    private JSONObject buildLoadFinishExt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", getString(EXTRA_URL));
            jSONObject.put("finish_state", getFinishState());
            jSONObject.put(WXLoginActivity.y, this.mErrorCode);
        } catch (JSONException e) {
            qw.th(TAG, e.getMessage(), e);
        }
        return jSONObject;
    }

    private JSONObject buildUrlExt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", getString(EXTRA_URL));
        } catch (JSONException e) {
            qw.th(TAG, e.getMessage(), e);
        }
        return jSONObject;
    }

    private void disableAccessibility(Context context) {
        if (Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, new Object[]{0});
                }
            } catch (Exception e) {
                qw.de(TAG, e.getMessage(), e);
            }
        }
    }

    private String getExitState() {
        if (!this.mIsLoadFinished) {
            return "2";
        }
        return this.mErrorCode != 0 ? "0" : "1";
    }

    private String getFinishState() {
        return this.mErrorCode != 0 ? "0" : "1";
    }

    private String getString(String str, String str2) {
        return getArguments() != null ? getArguments().getString(str) : str2;
    }

    private void initBackground(View view) {
        int i2;
        Bundle arguments = getArguments();
        if (arguments != null && (i2 = arguments.getInt(BACKGROUND_COLOR, 0)) > 0) {
            this.mWebView.setBackgroundColor(0);
            view.setBackgroundColor(getResources().getColor(i2));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(16)
    private void initBaseWebSettings() {
        TeraScanWebView teraScanWebView = this.mWebView;
        if (teraScanWebView != null) {
            WebSettings settings = teraScanWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(false);
            settings.setBuiltInZoomControls(false);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setTextZoom(100);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(2);
            }
            WebViewClient webViewClient = this.mWebViewClient;
            if (webViewClient != null) {
                this.mWebView.setWebViewClient(webViewClient);
            }
            WebChromeClient webChromeClient = this.mWebChromeClient;
            if (webChromeClient != null) {
                this.mWebView.setWebChromeClient(webChromeClient);
            }
            DownloadListener downloadListener = this.mDownloadListener;
            if (downloadListener != null) {
                this.mWebView.setDownloadListener(downloadListener);
            }
            this.mWebView.addJavascriptInterface(getActivity(), "netdisk");
        }
    }

    public String appendCheckerUrl(String str) {
        return str;
    }

    public boolean canGoback() {
        return this.mWebView.canGoBack();
    }

    public void destroyWebView() {
        TeraScanWebView teraScanWebView = this.mWebView;
        if (teraScanWebView != null) {
            teraScanWebView.setVisibility(8);
            this.mWebViewContainer.removeAllViews();
            this.mWebView.stopLoading();
            this.mWebView.setWebViewClient((WebViewClient) null);
            this.mWebView.setDownloadListener((DownloadListener) null);
            this.mWebView.clearCache(false);
            this.mWebView.destroyDrawingCache();
            this.mWebView.clearFormData();
            this.mWebView.clearHistory();
            this.mWebView.clearMatches();
            this.mWebView.clearSslPreferences();
            this.mWebView.removeAllViews();
            this.mWebView.setWebViewFragment((BaseWebViewFragment) null);
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    public WebView getBaseWebView() {
        return this.mWebView;
    }

    public EmptyView getEmptyView() {
        return this.mEmptyView;
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.mLottieAnimationView;
    }

    public String getOriginalUrl() {
        return this.mWebView.getOriginalUrl();
    }

    public String getPerformanceLogID() {
        Cswitch switchR = this.mPerformanceStatic;
        if (switchR == null) {
            return null;
        }
        switchR.qw();
        throw null;
    }

    public WebProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public TextView getTextLoading() {
        return this.mTextLoading;
    }

    public TeraScanWebView getWebView() {
        return this.mWebView;
    }

    public boolean goBack() {
        TeraScanWebView teraScanWebView = this.mWebView;
        if (teraScanWebView == null) {
            return false;
        }
        boolean canGoBack = teraScanWebView.canGoBack();
        if (canGoBack) {
            this.mWebView.goBack();
        }
        return canGoBack;
    }

    public void init(@NonNull Cif ifVar) {
        this.mUrlLoadable = ifVar.rg();
        this.mStateCallback = ifVar.fe();
        this.mWebViewClient = ifVar.uk();
        this.mWebChromeClient = ifVar.th();
        this.mDownloadListener = ifVar.ad();
        this.mWebView = ifVar.yj();
        this.mPerformanceStatic = ifVar.de();
    }

    @SuppressLint({"InlinedApi"})
    public void initView(View view) {
        Cswitch switchR = this.mPerformanceStatic;
        if (switchR == null) {
            try {
                if (this.mWebView == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mWebView = new TeraScanWebView(getActivity());
                    this.mWebViewCreateTime = System.currentTimeMillis() - currentTimeMillis;
                }
                this.mWebView.requestFocus();
                this.mWebView.setWebViewFragment(this);
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_webview);
                this.mWebViewContainer = frameLayout;
                frameLayout.addView(this.mWebView);
                this.mWebView.setOverScrollMode(2);
                this.mTextLoading = (TextView) view.findViewById(R.id.tv_loading);
                EmptyView emptyView = (EmptyView) view.findViewById(R.id.empty_view);
                this.mEmptyView = emptyView;
                emptyView.setRefreshListener(this);
                this.mProgressBar = (WebProgressBar) view.findViewById(R.id.progress_bar);
                this.mLottieAnimationView = (LottieAnimationView) view.findViewById(R.id.loading_lottie);
            } catch (Exception e) {
                qw.th(TAG, "webview ", e);
            }
        } else {
            switchR.ad(System.currentTimeMillis());
            throw null;
        }
    }

    public boolean isError() {
        return this.mIsError;
    }

    public void loadUrl() {
        if (this.mWebView != null) {
            getEmptyView().setVisibility(8);
            getEmptyView().setRefreshVisibility(8);
            setError(false);
            this.mWebView.setVisibility(0);
            this.mWebView.loadUrl(appendCheckerUrl(getString(EXTRA_URL)));
        }
    }

    public void onClick(View view) {
        refresh();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        qw.ad(TAG, "onCreateView");
        View inflate = layoutInflater.inflate(R.layout.webview_base_fragment, viewGroup, false);
        disableAccessibility(getContext());
        initView(inflate);
        initBaseWebSettings();
        initBackground(inflate);
        return inflate;
    }

    public void onDestroyView() {
        IStateCallback iStateCallback = this.mStateCallback;
        if (iStateCallback != null) {
            iStateCallback.onDestroyView();
        }
        destroyWebView();
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        IStateCallback iStateCallback = this.mStateCallback;
        if (iStateCallback != null) {
            iStateCallback.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        IStateCallback iStateCallback = this.mStateCallback;
        if (iStateCallback != null) {
            iStateCallback.onResume();
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setWebView();
    }

    public void refresh() {
        if (this.mEmptyView.getVisibility() != 8) {
            this.mEmptyView.setVisibility(8);
            this.mEmptyView.setRefreshVisibility(8);
        }
        this.mIsError = false;
        this.mWebView.reload();
    }

    public void setError(boolean z) {
        this.mIsError = z;
    }

    public void setErrorInfo(int i2, String str) {
        this.mErrorCode = i2;
        this.mErrorDescription = str;
    }

    public void setFragmentArguments(@Nullable Bundle bundle) {
        setArguments(bundle);
    }

    public void setUrlLoadEndTime() {
        this.mUrlLoadEndTime = System.currentTimeMillis();
        this.mIsLoadFinished = true;
    }

    public void setUrlLoadStartTime() {
        this.mUrlLoadStartTime = System.currentTimeMillis();
    }

    public void setUserVisibleHint(boolean z) {
        qw.ad(TAG, "setUserVisibleHint = " + z);
        super.setUserVisibleHint(z);
        IStateCallback iStateCallback = this.mStateCallback;
        if (iStateCallback != null) {
            iStateCallback.ad(this, z);
        }
    }

    public void setWebView() {
        IUrlLoadable1 iUrlLoadable1 = this.mUrlLoadable;
        if (iUrlLoadable1 != null) {
            iUrlLoadable1.qw(this, appendCheckerUrl(getString(EXTRA_URL)));
        } else if (!TextUtils.isEmpty(appendCheckerUrl(getString(EXTRA_URL)))) {
            loadUrl();
        }
        IStateCallback iStateCallback = this.mStateCallback;
        if (iStateCallback != null) {
            iStateCallback.qw(getActivity());
        }
    }

    public void updateView(String str) {
        IUrlLoadable1 iUrlLoadable1 = this.mUrlLoadable;
        if (iUrlLoadable1 != null) {
            iUrlLoadable1.qw(this, str);
        }
    }

    private String getString(String str) {
        return getString(str, (String) null);
    }
}
