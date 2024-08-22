package com.baidu.searchbox.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ad.feed.R;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.prefetch.AdLandingPrefetchUtils;
import com.baidu.searchbox.feed.event.AdFormPopupWindowEvent;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.lightbrowser.view.LightBrowserWebViewClient;
import com.baidu.searchbox.lightbrowser.view.PageStateChangeCallback;
import com.baidu.searchbox.ng.errorview.view.BdMultiStateView;
import com.baidu.searchbox.ng.errorview.view.NetworkErrorView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AdFormBasePopupView extends PopupWindow implements NightModeChangeListener {
    public static final String ACTION = "action";
    public static final String ACTION_VAL_DISMISS = "dismiss";
    public static final String ACTION_VAL_UPDATE_FRAME = "updateFrame";
    protected static final float BACK_ALPHA = 0.34f;
    public static final String HEIGHT_WIDTH_RATIO = "height_width_ratio";
    public static final String MARGIN = "margin";
    protected static final int NO_ALPHA = 255;
    public static final String POPOVER_AD_SCHEME = "popoverad://";
    public static final String TOAST_TIP = "toast_tip";
    public static final String URL = "url";
    protected static final int WEBVIEW_MARGIN = DeviceUtil.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 7.0f);
    protected ImageView mCloseIcon;
    protected WeakReference<Context> mContextRef;
    protected int mDismissType = 0;
    protected String mExt;
    protected RelativeLayout.LayoutParams mLayoutParams;
    protected LightBrowserView mLightBrowserView;
    protected ViewGroup mMaskView = null;
    protected Object mNightModeObj = new Object();
    protected HashMap<String, String> mParams;
    protected long mPopStartShowTime;
    protected String mReferUrl;
    RelativeLayout mRootLayout;
    protected boolean mScrollEnabled;
    protected String mUrl;

    /* access modifiers changed from: package-private */
    public abstract void onActionDismiss();

    /* access modifiers changed from: package-private */
    public abstract boolean shouldUpdateFrame(String str);

    /* access modifiers changed from: package-private */
    public abstract void updateFrame(String str, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public View onCreateContentView(Context context) {
        this.mContextRef = new WeakReference<>(context);
        View contentView = LayoutInflater.from(context).inflate(R.layout.ad_form_pop_view, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) contentView.findViewById(R.id.root_layout);
        this.mRootLayout = relativeLayout;
        relativeLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.ad_form_pop_shape));
        this.mCloseIcon = (ImageView) contentView.findViewById(R.id.icon_close);
        this.mLightBrowserView = new LightBrowserView(context, 2);
        this.mCloseIcon.setImageResource(com.baidu.searchbox.feed.ad.runtimeAll.R.drawable.ad_pop_icon_close);
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AdFormBasePopupView.this.onCloseIconClick();
            }
        });
        this.mLightBrowserView.resetFontSize();
        this.mLightBrowserView.setWebViewClientProxy(new AdPopupWebViewClient());
        this.mLightBrowserView.setStateChangeCallback(new PageStateChangeCallback() {
            public void onLoadSuccess() {
                AdFormBasePopupView.this.mLightBrowserView.setWebViewVisibility(0);
            }

            public void onLoadFailure() {
            }

            public void onHideLoading() {
            }
        });
        setExternalWebChromeClient();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.mLayoutParams = layoutParams;
        int i2 = WEBVIEW_MARGIN;
        layoutParams.setMargins(i2, i2, i2, i2);
        AdUtil.removeChildViewFromParent(this.mLightBrowserView);
        this.mRootLayout.addView(this.mLightBrowserView, 0, this.mLayoutParams);
        View networkErrorView = this.mLightBrowserView.getStateView().getView(BdMultiStateView.ViewState.ERROR);
        if (networkErrorView instanceof NetworkErrorView) {
            NetworkErrorView errorView = (NetworkErrorView) networkErrorView;
            errorView.mIcon.setImageDrawable(context.getResources().getDrawable(com.baidu.searchbox.feed.ad.runtimeAll.R.drawable.ad_pop_icon_network_error));
            errorView.mBottomLayout.setVisibility(8);
        }
        return contentView;
    }

    public void setDismissOnTouchOutside(boolean shouldDismiss) {
        if (shouldDismiss) {
            setTouchInterceptor((View.OnTouchListener) null);
        } else {
            setTouchInterceptor(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    if ((event.getAction() == 0 && (x < 0 || x >= AdFormBasePopupView.this.getWidth() || y < 0 || y >= AdFormBasePopupView.this.getHeight())) || event.getAction() == 4) {
                        return true;
                    }
                    AdFormBasePopupView.this.onTouchInsideView();
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeNightModeChangedEvent() {
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeObj, this);
    }

    /* access modifiers changed from: protected */
    public void unsubscribeNightModeChangedEvent() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this.mNightModeObj);
    }

    /* access modifiers changed from: protected */
    public void setExternalWebChromeClient() {
    }

    /* access modifiers changed from: protected */
    public void onTouchInsideView() {
    }

    /* access modifiers changed from: protected */
    public void onCloseIconClick() {
        dismiss();
    }

    public void dismiss() {
        toggleWindow(false);
        super.dismiss();
        sendPopWindowCloseALS();
        resetParams();
        BdEventBus.Companion.getDefault().post(new AdFormPopupWindowEvent(3));
    }

    /* access modifiers changed from: protected */
    public void resetParams() {
        this.mDismissType = 0;
        this.mPopStartShowTime = 0;
    }

    /* access modifiers changed from: protected */
    public void toggleWindow(boolean dark) {
        Context context = (Context) this.mContextRef.get();
        if (context instanceof Activity) {
            if (this.mMaskView == null) {
                FrameLayout frameLayout = new FrameLayout(context);
                this.mMaskView = frameLayout;
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mMaskView.setBackground(getBgDrawable());
            }
            ViewGroup rootView = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            if (dark) {
                AdUtil.removeChildViewFromParent(this.mMaskView);
                rootView.addView(this.mMaskView);
                return;
            }
            rootView.removeView(this.mMaskView);
        }
    }

    /* access modifiers changed from: protected */
    public ColorDrawable getBgDrawable() {
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setAlpha(86);
        return colorDrawable;
    }

    public void loadUrl(String url) {
        LightBrowserView lightBrowserView = this.mLightBrowserView;
        if (lightBrowserView != null) {
            lightBrowserView.setWebViewVisibility(4);
            this.mLightBrowserView.setWebViewVerticalScrollBarEnabled(this.mScrollEnabled);
            handleUrlLoading(this.mLightBrowserView, url, this.mReferUrl);
        }
    }

    /* access modifiers changed from: protected */
    public void handleUrlLoading(LightBrowserView browserView, String url) {
        if (!TextUtils.isEmpty(url)) {
            browserView.loadUrl(url);
        }
    }

    /* access modifiers changed from: protected */
    public void handleUrlLoading(LightBrowserView browserView, String url, String referUrl) {
        if (!TextUtils.isEmpty(url)) {
            if (TextUtils.isEmpty(referUrl)) {
                handleUrlLoading(browserView, url);
                return;
            }
            HashMap<String, String> header = new HashMap<>();
            header.put("referer", referUrl);
            browserView.loadUrl(url, header);
        }
    }

    public HashMap<String, String> getParams() {
        return this.mParams;
    }

    public void setParams(HashMap<String, String> params) {
        this.mParams = params;
    }

    public String getExt() {
        HashMap<String, String> hashMap;
        if (TextUtils.isEmpty(this.mExt) && (hashMap = this.mParams) != null && !TextUtils.isEmpty(hashMap.get("adFlag"))) {
            try {
                this.mExt = new JSONObject(this.mParams.get("adFlag")).optString("ext");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.mExt;
    }

    /* access modifiers changed from: protected */
    public void sendPopWindowCloseALS() {
        if (!TextUtils.isEmpty(getExt())) {
            Als.Builder builder = new Als.Builder();
            builder.setType("8");
            builder.setExt2(String.valueOf(System.currentTimeMillis() - this.mPopStartShowTime));
            builder.setExtraParam(getExt());
            setAlsParams(builder);
            Als.postADRealTimeLog(builder);
        }
    }

    /* access modifiers changed from: protected */
    public void setAlsParams(Als.Builder builder) {
    }

    /* access modifiers changed from: protected */
    public void setScrollEnabled(int isEnabled) {
        boolean z = true;
        if (isEnabled != 1) {
            z = false;
        }
        this.mScrollEnabled = z;
    }

    public void onNightModeChanged(boolean b2) {
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackground(relativeLayout.getResources().getDrawable(R.drawable.ad_form_pop_shape));
        }
    }

    public class AdPopupWebViewClient extends LightBrowserWebViewClient {
        public AdPopupWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(BdSailorWebView view2, String url) {
            if (!url.startsWith(AdFormBasePopupView.POPOVER_AD_SCHEME)) {
                return super.shouldOverrideUrlLoading(view2, url);
            }
            Context context = view2.getContext();
            HashMap<String, String> params = new UnitedSchemeEntity(Uri.parse(url)).getParams();
            if (params == null || params.isEmpty()) {
                return true;
            }
            String action = params.get("action");
            if (AdFormBasePopupView.this.shouldUpdateFrame(action)) {
                String strMargin = params.get("margin");
                String strHeightWidthRatio = params.get(AdFormBasePopupView.HEIGHT_WIDTH_RATIO);
                if (TextUtils.isEmpty(strMargin) || TextUtils.isEmpty(strHeightWidthRatio)) {
                    return true;
                }
                int margin = 0;
                int width = 0;
                int height = 0;
                try {
                    margin = DeviceUtil.ScreenInfo.dp2px(context, (float) Integer.parseInt(strMargin));
                    float heightWidthRatio = Float.parseFloat(strHeightWidthRatio);
                    width = DeviceUtil.ScreenInfo.getDisplayWidth(context) - (margin * 2);
                    height = (int) (((float) width) * heightWidthRatio);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                AdFormBasePopupView.this.updateFrame(action, margin, width, height);
            } else if (TextUtils.equals("dismiss", action)) {
                AdFormBasePopupView.this.onActionDismiss();
                String toastTip = params.get(AdFormBasePopupView.TOAST_TIP);
                AdFormBasePopupView.this.dismiss();
                if (!TextUtils.isEmpty(toastTip)) {
                    UniversalToast.makeText(context, (CharSequence) toastTip).showHighlightToast();
                }
            }
            return true;
        }

        public WebResourceResponse shouldInterceptRequest(BdSailorWebView view2, String url) {
            InputStream inputStream = AdLandingPrefetchUtils.getAdHtmlCache(url);
            if (inputStream != null) {
                return new WebResourceResponse("text/html", "UTF-8", inputStream);
            }
            return super.shouldInterceptRequest(view2, url);
        }

        public void onReceivedHttpError(BdSailorWebView view2, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view2, request, errorResponse);
            int statusCode = errorResponse.getStatusCode();
            if (statusCode >= 400) {
                view2.setTag(com.baidu.searchbox.ng.browser.R.id.webcontent_error_code, Integer.valueOf(statusCode));
            }
        }
    }
}
