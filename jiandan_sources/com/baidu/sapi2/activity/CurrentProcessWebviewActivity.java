package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.c;
import com.baidu.sapi2.utils.enums.UIOrientation;
import com.baidu.sapi2.views.ViewUtility;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrentProcessWebviewActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_EXTERNAL_TITLE = "external_title";
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String EXTRA_IS_DARK_MODE = "is_dark_mode";
    public static final String EXTRA_IS_SHOW_BOTTOM_BACK_TEXT = "is_show_bottom_back_text";
    public static final String EXTRA_SHOW_BOTTOM_BACK = "show_bottom_back";
    public static final String EXTRA_TEXT_ZOOM = "text_zoom";
    public boolean a;
    public boolean b;
    public View bottomBackView;
    public View bottomBackViewSingleBtn;
    public String c;
    public String d;
    public View dividerLine;
    public WebView e;
    public ImageView mBottomBackBtnIv;
    public ImageView mBottomBackBtnIvSingleBtn;
    public TextView mBottomBackTvText;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public boolean mIsShowBottomBackText;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public int mTextZoom;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;
    public View noNetworkView;
    public ProgressBar progressBar;

    private void b() {
        this.a = getIntent().getBooleanExtra("is_dark_mode", false);
        this.b = getIntent().getBooleanExtra("show_bottom_back", false);
        this.c = getIntent().getStringExtra("external_title");
        this.d = getIntent().getStringExtra("external_url");
        this.mTextZoom = getIntent().getIntExtra("text_zoom", 100);
        this.mIsShowBottomBackText = getIntent().getBooleanExtra("is_show_bottom_back_text", false);
    }

    private void c() {
        ViewStub viewStub;
        ViewStub viewStub2;
        if (this.a) {
            setTheme(R.style.SDKDarkTheme);
        }
        this.e = (WebView) findViewById(R.id.webview);
        this.mTitle = (TextView) findViewById(R.id.title);
        ImageView imageView = (ImageView) findViewById(R.id.title_btn_left_iv);
        this.mLeftBtnIv = imageView;
        imageView.setOnClickListener(this);
        this.mLeftBtnLayout = (LinearLayout) findViewById(R.id.title_left_btn_layout);
        this.dividerLine = findViewById(R.id.title_divider_line);
        this.mTitleBgLayout = (RelativeLayout) findViewById(R.id.sapi_title_bg_layout);
        this.mTitle.setText(this.c);
        if (this.b) {
            if (this.mIsShowBottomBackText) {
                if (this.bottomBackView == null && (viewStub2 = (ViewStub) findViewById(R.id.stub_bottom_back)) != null) {
                    this.bottomBackView = viewStub2.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(R.id.sapi_bottom_back);
                    this.mBottomBackTvText = (TextView) findViewById(R.id.sapi_textview_back);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(R.id.sapi_layout_bottom_back);
                    this.mBottomDividerLine = (ImageView) findViewById(R.id.sapi_sdk_bottom_divider_line);
                    this.mBottomBackBtnIv.setOnClickListener(this);
                    this.mBottomBackTvText.setOnClickListener(this);
                    ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                    ViewUtility.setViewClickAlpha(this.mBottomBackTvText, 0.2f);
                    this.mBottomBackTvText.setVisibility(this.mIsShowBottomBackText ? 0 : 8);
                }
            } else if (this.bottomBackViewSingleBtn == null && (viewStub = (ViewStub) findViewById(R.id.stub_bottom_back_single_btn)) != null) {
                this.bottomBackViewSingleBtn = viewStub.inflate();
                ImageView imageView2 = (ImageView) findViewById(R.id.sapi_bottom_back_single_btn);
                this.mBottomBackBtnIvSingleBtn = imageView2;
                imageView2.setOnClickListener(this);
            }
            this.mLeftBtnIv.setVisibility(8);
        }
        ViewUtility.enlargedViews(this.mLeftBtnIv, this.mTextZoom);
        ViewUtility.enlargedViews(this.mTitle, this.mTextZoom);
        ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.mTextZoom);
        ViewUtility.enlargedViews(this.mBottomBackTvText, this.mTextZoom);
        if (this.a) {
            this.mTitleBgLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            this.mLeftBtnIv.setImageResource(R.drawable.sapi_sdk_btn_back_dark_mode);
            this.mTitle.setTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            this.dividerLine.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            ImageView imageView3 = this.mBottomBackBtnIv;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.sapi_sdk_btn_back_dark_mode);
            }
            ImageView imageView4 = this.mBottomBackBtnIvSingleBtn;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.sapi_sdk_icon_button_bar_back_dark);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            }
            TextView textView = this.mBottomBackTvText;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            }
            ImageView imageView5 = this.mBottomDividerLine;
            if (imageView5 != null) {
                imageView5.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            }
        }
        a();
        this.e.loadUrl(this.d);
    }

    public void finish() {
        super.finish();
        a(false);
    }

    public void lockScreenOrientation() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 || i2 <= 25) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null || confignation.getUIOrientation() == null) {
                setRequestedOrientation(1);
                return;
            }
            UIOrientation uIOrientation = confignation.getUIOrientation();
            if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(0);
            } else if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_USER) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public void onClick(View view) {
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lockScreenOrientation();
        setContentView(R.layout.layout_sapi_sdk_normal_webview_with_title_bar);
        a(true);
        b();
        c();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void a() {
        WebSettings settings = this.e.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception unused) {
        }
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        this.e.setScrollBarStyle(0);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        try {
            ProgressBar progressBar2 = new ProgressBar(this, (AttributeSet) null, 16842872);
            this.progressBar = progressBar2;
            progressBar2.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(this, 2.0f), 0, 0));
            this.progressBar.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_explain_camera_detail_color));
            this.e.addView(this.progressBar);
        } catch (Throwable th2) {
            Log.e(th2);
        }
        this.e.setWebChromeClient(new WebChromeClient() {
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", "0");
                } catch (JSONException unused) {
                }
                jsPromptResult.confirm(jSONObject.toString());
                return true;
            }

            public void onProgressChanged(WebView webView, int i2) {
                ProgressBar progressBar = CurrentProcessWebviewActivity.this.progressBar;
                if (progressBar != null) {
                    if (i2 == 100) {
                        progressBar.setVisibility(8);
                    } else {
                        if (progressBar.getVisibility() == 8) {
                            CurrentProcessWebviewActivity.this.progressBar.setVisibility(0);
                        }
                        CurrentProcessWebviewActivity.this.progressBar.setProgress(i2);
                    }
                }
                super.onProgressChanged(webView, i2);
            }
        });
        this.e.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (!SapiUtils.hasActiveNetwork(CurrentProcessWebviewActivity.this)) {
                    CurrentProcessWebviewActivity currentProcessWebviewActivity = CurrentProcessWebviewActivity.this;
                    if (currentProcessWebviewActivity.noNetworkView == null) {
                        currentProcessWebviewActivity.noNetworkView = c.a((Context) currentProcessWebviewActivity, currentProcessWebviewActivity.e);
                        CurrentProcessWebviewActivity.this.e.addView(CurrentProcessWebviewActivity.this.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
                    }
                    CurrentProcessWebviewActivity.this.noNetworkView.setVisibility(0);
                }
            }
        });
    }

    private void a(boolean z) {
        if (z) {
            overridePendingTransition(R.anim.sapi_sdk_slide_right_in, R.anim.sapi_sdk_slide_left_out);
        } else {
            overridePendingTransition(R.anim.sapi_sdk_slide_left_in, R.anim.sapi_sdk_slide_right_out);
        }
    }
}
