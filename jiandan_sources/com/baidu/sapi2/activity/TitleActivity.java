package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.sdk.m.p.e;
import com.baidu.aiscan.R;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.UIOrientation;
import com.baidu.sapi2.views.ViewUtility;
import java.util.HashMap;

public abstract class TitleActivity extends Activity implements View.OnClickListener {
    public View bottomBackView;
    public View bottomBackViewSingleBtn;
    public SapiConfiguration configuration;
    public View dividerLine;
    public boolean executeSubClassMethod = true;
    public ImageView mBottomBackBtnIv;
    public ImageView mBottomBackBtnIvSingleBtn;
    public TextView mBottomBackTvText;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public TextView mLeftBtnTv;
    public Button mRightBtn;
    public ImageView mRightBtnClose;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;
    public RelativeLayout mTitleLayout;
    public boolean realShowBottomBack;
    public TitleBtnCallback titleBtnCallback;
    public boolean useTitle = true;
    public PassportViewManager viewManager;

    public TitleActivity() {
        PassportViewManager instance = PassportViewManager.getInstance();
        this.viewManager = instance;
        this.titleBtnCallback = instance.getTitleBtnCallback();
        this.configuration = SapiAccountManager.getInstance().getConfignation();
    }

    private void a() {
        PassportViewManager.TitleViewModule titleViewModule = this.viewManager.getTitleViewModule();
        if (titleViewModule != null) {
            setTitleLayoutBg(titleViewModule.bgColor);
            setTitleLayoutHeight(titleViewModule.bgHeight);
            setLeftBtnImage(titleViewModule.leftBtnImgResId);
            setLeftBtnImgVisible(titleViewModule.leftBtnImgVisible);
            setLeftBtnTextVisible(titleViewModule.leftBtnTextVisible);
            setLeftBtnTextColor(titleViewModule.leftBtnTextColor);
            setLeftBtnText(titleViewModule.leftBtnText);
            setLeftBtnTextSize((float) SapiUtils.px2sp(this, titleViewModule.leftBtnTextSize));
            setLeftBtnDrawable(titleViewModule.leftBtnDrawableLeft, titleViewModule.leftBtnDrawableTop, titleViewModule.leftBtnDrawableRight, titleViewModule.leftBtnDrawableBottom);
            setTitleVisible(titleViewModule.titleVisible);
            setTitleText(titleViewModule.titleText);
            setTitleTextColor(titleViewModule.titleTextColor);
            setTitleTextSize((float) SapiUtils.px2sp(this, titleViewModule.titleTextSize));
            setTitleDrawable(titleViewModule.titleDrawableLeft, titleViewModule.titleDrawableTop, titleViewModule.titleDrawableRight, titleViewModule.titleDrawableBottom);
            setTitleTextBold(titleViewModule.titleTextBold);
            setRightBtnVisible(titleViewModule.rightBtnVisible);
            setRightBtnText(titleViewModule.rightBtnText);
            setRightBtnTextSize((float) SapiUtils.px2sp(this, titleViewModule.rightBtnTextSize));
            setRightBtnColor(titleViewModule.rightBtnTextColor);
            View view = this.dividerLine;
            if (view != null) {
                view.setVisibility(titleViewModule.dividerLineVisible);
            }
        } else {
            setBtnVisibility(4, 0, 4);
            setTitleDrawable((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            setLeftBtnDrawable(getResources().getDrawable(R.drawable.sapi_sdk_btn_back), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.configuration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    public void configTitle() {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null || !sapiConfiguration.customActionBarEnabled) {
            setTitleLayoutVisible(8);
        } else {
            a();
        }
    }

    public void finish() {
        super.finish();
        setPageAnim(false);
    }

    public SapiWebDTO getWebDTO() {
        return null;
    }

    public void init() {
        setPageAnim(true);
    }

    public void lockScreenOrientation() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 || i2 <= 25) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            this.configuration = confignation;
            if (confignation == null || confignation.getUIOrientation() == null) {
                setRequestedOrientation(1);
                return;
            }
            UIOrientation uIOrientation = this.configuration.getUIOrientation();
            if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(0);
            } else if (uIOrientation == UIOrientation.SCREEN_ORIENTATION_USER) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public void onBottomBackBtnClick() {
    }

    public void onClick(View view) {
        if (view == this.mLeftBtnIv || view == this.mLeftBtnTv) {
            onLeftBtnClick();
        } else if (view == this.mRightBtn) {
            onRightBtnClick();
        } else if (view == this.mBottomBackBtnIv || view == this.mBottomBackTvText || view == this.mBottomBackBtnIvSingleBtn) {
            onBottomBackBtnClick();
        } else if (view == this.mRightBtnClose) {
            onTitleRightBtnClick();
        }
    }

    public void onClose() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lockScreenOrientation();
        if (this.configuration == null) {
            this.configuration = SapiAccountManager.getInstance().getConfignation();
        }
        if (DarkModeUtil.isDarkMode(this)) {
            setTheme(R.style.SDKDarkTheme);
        } else {
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.isNightMode) {
                setTheme(R.style.SDKNightTheme);
            }
        }
        SapiConfiguration sapiConfiguration2 = this.configuration;
        if (sapiConfiguration2 != null) {
            this.realShowBottomBack = sapiConfiguration2.showBottomBack;
        }
    }

    public void onLeftBtnClick() {
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onRightBtnClick() {
        TitleBtnCallback titleBtnCallback2 = this.titleBtnCallback;
        if (titleBtnCallback2 != null) {
            titleBtnCallback2.onRightClick();
        }
    }

    public void onTitleRightBtnClick() {
        onClose();
    }

    public void reportWebviewError(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Log.getStackTraceString(th2));
        hashMap.put(e.p, SapiDeviceInfo.OS_TYPE);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        StatService.onEvent("webview_init_error", hashMap);
    }

    public void setBtnVisibility(int i2, int i3, int i4) {
        Button button;
        ImageView imageView;
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setVisibility(i2);
        }
        if (this.useTitle && (imageView = this.mLeftBtnIv) != null) {
            imageView.setVisibility(i3);
        }
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setVisibility(i4);
        }
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setLeftBtnImage(int i2) {
        ImageView imageView;
        if (this.useTitle && (imageView = this.mLeftBtnIv) != null && i2 != Integer.MAX_VALUE) {
            imageView.setImageResource(i2);
        }
    }

    public void setLeftBtnImgVisible(int i2) {
        ImageView imageView;
        if (this.useTitle && (imageView = this.mLeftBtnIv) != null) {
            imageView.setVisibility(i2);
        }
    }

    public void setLeftBtnLayoutVisible(int i2) {
        LinearLayout linearLayout;
        if (this.useTitle && (linearLayout = this.mLeftBtnLayout) != null) {
            linearLayout.setVisibility(i2);
        }
    }

    public void setLeftBtnText(String str) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setText(str);
        }
    }

    public void setLeftBtnTextColor(int i2) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextColor(i2);
        }
    }

    public void setLeftBtnTextSize(float f) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextSize(f);
        }
    }

    public void setLeftBtnTextVisible(int i2) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setVisibility(i2);
        }
    }

    public void setPageAnim(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        SapiConfiguration sapiConfiguration = this.configuration;
        int i6 = 0;
        int i7 = sapiConfiguration == null ? 0 : sapiConfiguration.activityOpenAnimId;
        SapiConfiguration sapiConfiguration2 = this.configuration;
        if (sapiConfiguration2 != null) {
            i6 = sapiConfiguration2.activityExitAnimId;
        }
        SapiWebDTO webDTO = getWebDTO();
        if (!(webDTO == null || (i5 = webDTO.openEnterAnimId) == 0)) {
            i7 = i5;
        }
        if (!(webDTO == null || (i4 = webDTO.closeExitAnimId) == 0)) {
            i6 = i4;
        }
        if (i7 == 0) {
            i7 = R.anim.sapi_sdk_slide_right_in;
        }
        if (i6 == 0) {
            i6 = R.anim.sapi_sdk_slide_right_out;
        }
        if (z) {
            int i8 = R.anim.sapi_sdk_slide_left_out;
            if (!(webDTO == null || (i3 = webDTO.openExitAnimId) == 0)) {
                i8 = i3;
            }
            overridePendingTransition(i7, i8);
            return;
        }
        int i9 = R.anim.sapi_sdk_slide_left_in;
        if (!(webDTO == null || (i2 = webDTO.closeEnterAnimId) == 0)) {
            i9 = i2;
        }
        overridePendingTransition(i9, i6);
    }

    public void setRightBtnColor(int i2) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextColor(i2);
        }
    }

    public void setRightBtnText(String str) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setText(str);
        }
    }

    public void setRightBtnTextSize(float f) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextSize(f);
        }
    }

    public void setRightBtnVisible(int i2) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setVisibility(i2);
        }
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setTitleLayoutBg(int i2) {
        RelativeLayout relativeLayout;
        if (this.useTitle && (relativeLayout = this.mTitleBgLayout) != null && i2 != Integer.MAX_VALUE && relativeLayout != null) {
            relativeLayout.setBackgroundColor(i2);
        }
    }

    public void setTitleLayoutHeight(int i2) {
        RelativeLayout relativeLayout;
        if (this.useTitle && (relativeLayout = this.mTitleLayout) != null && i2 != Integer.MAX_VALUE) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = i2;
            this.mTitleLayout.setLayoutParams(layoutParams);
        }
    }

    public void setTitleLayoutVisible(int i2) {
        RelativeLayout relativeLayout;
        if (this.useTitle && (relativeLayout = this.mTitleLayout) != null) {
            relativeLayout.setVisibility(i2);
        }
    }

    public void setTitleText(String str) {
        if (this.useTitle && this.mTitle != null) {
            PassportViewManager.TitleViewModule titleViewModule = this.viewManager.getTitleViewModule();
            if (titleViewModule != null) {
                if (!titleViewModule.useWebviewTitle) {
                    this.mTitle.setText(titleViewModule.titleText);
                } else if (!TextUtils.isEmpty(str)) {
                    this.mTitle.setText(str);
                }
            } else if (!TextUtils.isEmpty(str)) {
                this.mTitle.setText(str);
            }
        }
    }

    public void setTitleTextBold(boolean z) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        }
    }

    public void setTitleTextColor(int i2) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTitleTextSize(float f) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextSize(f);
        }
    }

    public void setTitleVisible(int i2) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setVisibility(i2);
        }
    }

    public void setupViews() {
        ViewStub viewStub;
        ViewStub viewStub2;
        View childAt;
        ViewUtility.enableStatusBarTint(this, -1);
        if (Build.VERSION.SDK_INT >= 14 && (childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0)) != null) {
            childAt.setFitsSystemWindows(true);
        }
        if (this.useTitle) {
            this.mTitle = (TextView) findViewById(R.id.title);
            this.mLeftBtnLayout = (LinearLayout) findViewById(R.id.title_left_btn_layout);
            this.mLeftBtnTv = (TextView) findViewById(R.id.title_btn_left_tv);
            this.mLeftBtnIv = (ImageView) findViewById(R.id.title_btn_left_iv);
            this.mRightBtn = (Button) findViewById(R.id.title_btn_right);
            this.mTitleLayout = (RelativeLayout) findViewById(R.id.sapi_title_layout);
            this.mTitleBgLayout = (RelativeLayout) findViewById(R.id.sapi_title_bg_layout);
            this.dividerLine = findViewById(R.id.title_divider_line);
            this.mRightBtnClose = (ImageView) findViewById(R.id.title_right_close);
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.showBottomBack) {
                if (sapiConfiguration.isShowBottomBackText) {
                    if (this.bottomBackView == null && (viewStub2 = (ViewStub) findViewById(R.id.stub_bottom_back)) != null) {
                        this.bottomBackView = viewStub2.inflate();
                        this.mBottomBackBtnIv = (ImageView) findViewById(R.id.sapi_bottom_back);
                        this.mBottomBackTvText = (TextView) findViewById(R.id.sapi_textview_back);
                        this.mBottomBgLayout = (RelativeLayout) findViewById(R.id.sapi_layout_bottom_back);
                        this.mBottomDividerLine = (ImageView) findViewById(R.id.sapi_sdk_bottom_divider_line);
                        ViewUtility.setOnClickListener(this.mBottomBackBtnIv, this);
                        ViewUtility.setOnClickListener(this.mBottomBackTvText, this);
                        ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                        this.mBottomBackTvText.setVisibility(this.configuration.isShowBottomBackText ? 0 : 8);
                    }
                } else if (this.bottomBackViewSingleBtn == null && (viewStub = (ViewStub) findViewById(R.id.stub_bottom_back_single_btn)) != null) {
                    this.bottomBackViewSingleBtn = viewStub.inflate();
                    ImageView imageView = (ImageView) findViewById(R.id.sapi_bottom_back_single_btn);
                    this.mBottomBackBtnIvSingleBtn = imageView;
                    ViewUtility.setOnClickListener(imageView, this);
                }
            }
            ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            ViewUtility.setViewClickAlpha(this.mLeftBtnIv, 0.2f);
            ViewUtility.setViewClickAlpha(this.mLeftBtnTv, 0.2f);
            ViewUtility.setViewClickAlpha(this.mRightBtn, 0.2f);
            ViewUtility.setOnClickListener(this.mRightBtnClose, this);
            ViewUtility.setOnClickListener(this.mLeftBtnIv, this);
            ViewUtility.setOnClickListener(this.mLeftBtnTv, this);
            ViewUtility.setOnClickListener(this.mRightBtn, this);
            SapiConfiguration sapiConfiguration2 = this.configuration;
            if (sapiConfiguration2 != null) {
                ViewUtility.enlargedViews(this.mLeftBtnIv, sapiConfiguration2.getTextZoom());
                ViewUtility.enlargedViews(this.mLeftBtnTv, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mTitle, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mRightBtn, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mRightBtnClose, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mBottomBackTvText, this.configuration.getTextZoom());
            }
        }
        if (this.configuration != null && !DarkModeUtil.isDarkMode(this) && this.configuration.isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
        if (!(this.bottomBackView == null && this.bottomBackViewSingleBtn == null)) {
            SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
                public void keyBoardHide(int i2) {
                    TitleActivity titleActivity = TitleActivity.this;
                    if (titleActivity.realShowBottomBack) {
                        SapiConfiguration sapiConfiguration = titleActivity.configuration;
                        if (sapiConfiguration == null || !sapiConfiguration.isShowBottomBackText) {
                            View view = TitleActivity.this.bottomBackViewSingleBtn;
                            if (view != null) {
                                view.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        View view2 = titleActivity.bottomBackView;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                    }
                }

                public void keyBoardShow(int i2) {
                    View view = TitleActivity.this.bottomBackView;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    View view2 = TitleActivity.this.bottomBackViewSingleBtn;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                }
            });
        }
        configTitle();
    }

    public void switchTitleAndBottomDarkMode(boolean z) {
        boolean z2 = this.useTitle;
        int i2 = R.drawable.sapi_sdk_btn_back_dark_mode;
        int i3 = R.color.sapi_sdk_dark_mode_edit_text_color;
        int i4 = -1;
        if (z2) {
            setTitleLayoutBg(z ? getResources().getColor(R.color.sapi_sdk_dark_mode_title_color) : -1);
            setLeftBtnImage(z ? R.drawable.sapi_sdk_btn_back_dark_mode : R.drawable.sapi_sdk_btn_back);
            setLeftBtnTextColor(getResources().getColor(z ? R.color.sapi_sdk_dark_mode_edit_text_color : R.color.sapi_sdk_edit_text_color));
            setTitleTextColor(getResources().getColor(z ? R.color.sapi_sdk_dark_mode_edit_text_color : R.color.sapi_sdk_edit_text_color));
            setRightBtnColor(getResources().getColor(z ? R.color.sapi_sdk_dark_mode_edit_text_color : R.color.sapi_sdk_edit_text_color));
            LinearLayout linearLayout = this.mLeftBtnLayout;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(z ? getResources().getColor(R.color.sapi_sdk_dark_mode_title_color) : -1);
            }
            ImageView imageView = this.mRightBtnClose;
            if (imageView != null) {
                imageView.setImageResource(z ? R.drawable.sapi_sdk_title_close_dark_mode : R.drawable.sapi_sdk_title_close);
            }
            View view = this.dividerLine;
            if (view != null) {
                view.setBackgroundColor(z ? getResources().getColor(R.color.sapi_sdk_dark_mode_title_color) : -1);
            }
        }
        ImageView imageView2 = this.mBottomBackBtnIv;
        if (imageView2 != null) {
            if (!z) {
                i2 = R.drawable.sapi_sdk_btn_back;
            }
            imageView2.setImageResource(i2);
        }
        ImageView imageView3 = this.mBottomBackBtnIvSingleBtn;
        if (imageView3 != null) {
            imageView3.setImageResource(z ? R.drawable.sapi_sdk_icon_button_bar_back_dark : R.drawable.sapi_sdk_icon_button_bar_back_light);
        }
        RelativeLayout relativeLayout = this.mBottomBgLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(z ? getResources().getColor(R.color.sapi_sdk_dark_mode_title_color) : -1);
        }
        TextView textView = this.mBottomBackTvText;
        if (textView != null) {
            Resources resources = getResources();
            if (!z) {
                i3 = R.color.sapi_sdk_edit_text_color;
            }
            textView.setTextColor(resources.getColor(i3));
        }
        ImageView imageView4 = this.mBottomDividerLine;
        if (imageView4 != null) {
            if (z) {
                i4 = getResources().getColor(R.color.sapi_sdk_dark_mode_title_color);
            }
            imageView4.setBackgroundColor(i4);
        }
    }

    public void updateBottomBack(int i2) {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null) {
            int i3 = 8;
            if (sapiConfiguration.showBottomBack) {
                this.realShowBottomBack = i2 != 1;
                this.mRightBtnClose.setVisibility(i2 == 1 ? 0 : 8);
                if (this.configuration.isShowBottomBackText) {
                    View view = this.bottomBackView;
                    if (view != null) {
                        if (i2 != 1) {
                            i3 = 0;
                        }
                        view.setVisibility(i3);
                        return;
                    }
                    return;
                }
                View view2 = this.bottomBackViewSingleBtn;
                if (view2 != null) {
                    if (i2 != 1) {
                        i3 = 0;
                    }
                    view2.setVisibility(i3);
                }
            } else if (!sapiConfiguration.showCloseBtn) {
            } else {
                if (i2 == 1) {
                    this.mRightBtnClose.setVisibility(0);
                    this.mLeftBtnLayout.setVisibility(8);
                    return;
                }
                this.mRightBtnClose.setVisibility(8);
                this.mLeftBtnLayout.setVisibility(0);
            }
        }
    }

    public void setTitleText(int i2) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setText(getResources().getText(i2));
        }
    }

    public void a(boolean z) {
        Window window;
        int i2;
        if (!(Build.VERSION.SDK_INT < 21 || (window = getWindow()) == null || this.configuration == null)) {
            if (z) {
                i2 = Color.parseColor("#FF000000");
            } else {
                i2 = Color.parseColor("#FFFFFFFF");
            }
            window.setNavigationBarColor(i2);
        }
        ViewUtility.enableStatusBarTint(this, z ? getResources().getColor(R.color.sapi_sdk_account_center_titlebar_bg_darkmode) : -1);
        switchTitleAndBottomDarkMode(z);
    }
}
