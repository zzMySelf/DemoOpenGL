package com.tera.scan.webview;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.aiscan.R;
import com.baidu.android.common.others.lang.StringUtil;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;
import com.tera.scan.webview.hybrid.action.IActionManager;
import com.tera.scan.webview.hybrid.action.IWebViewListener;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.m.xxx.ad;
import java.util.regex.Pattern;

public abstract class ContainerWebViewActivity extends BaseActivity implements ICommonTitleBarClickListener, ITitleChangeCallBack, IWebViewListener, IBaseView {
    public static final int ACTIVITY_TYPE_BASE = 0;
    public static final int ACTIVITY_TYPE_CLOUD_DISCOVERY_BANNER = 3;
    public static final int ACTIVITY_TYPE_CLOUD_HOME_BANNER = 11;
    public static final int ACTIVITY_TYPE_DSP_DISCOVERY_BANNER = 4;
    public static final int ACTIVITY_TYPE_FLASH_ADVERTISE = 2;
    public static final int ACTIVITY_TYPE_IMAGE_ICON = 7;
    public static final int ACTIVITY_TYPE_LIST_ICON = 5;
    public static final int ACTIVITY_TYPE_NOTIFY_COUPON_DETAIL = 9;
    public static final int ACTIVITY_TYPE_NOTIFY_COUPON_OVERDUE = 8;
    public static final int ACTIVITY_TYPE_VIDEO_ICON = 6;
    public static final int ACTIVITY_TYPE_VIDEO_PAUSE = 8;
    public static final int ACTIVITY_TYPE_VIP = 1;
    public static final String EXTRA_ACTIVITY_TYPE = "extra_activity_type";
    public static final String EXTRA_MSG_ID = "extra_msg_id";
    public static final String EXTRA_PAGE_TITLE = "extra_page_title";
    public static final String EXTRA_UK = "extra_uk";
    public static final int FINISH_DEFAULT = 0;
    public static final int FINISH_TO_ABOUT_ME = 3;
    public static final int FINISH_TO_BACK = 4;
    public static final int FINISH_TO_MAIN = 2;
    public static final String FINISH_TO_OTHER_PAGE = "com.tera.scan.webview.ContainerWebViewActivity.FINISH_TO_OTHER_PAGE";
    public static final int FINISH_TO_SHARE = 1;
    public static final String REGEX = "[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    public static final String TAG = "ContainerWebViewActivity";
    public int curStatusBarType = -1;
    public boolean isNoPreLoad = true;
    public int mActivityType = 0;
    public int mFinishToOtherPage = 0;
    public BaseWebViewFragment mFragment;
    public ad mTopBarColorControl;
    public String mUrl;

    public static int getFinishTab(@NonNull String str, int i2, String str2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                return Integer.valueOf(queryParameter).intValue();
            }
            return i2;
        } catch (NumberFormatException unused) {
            qw.uk(TAG, "url params:error");
            return i2;
        } catch (UnsupportedOperationException unused2) {
            qw.uk(TAG, "uri unsupportedoperation error , url = " + str);
            return i2;
        }
    }

    private void handleIntent(Intent intent) {
        Uri data = intent.getData();
        String str = null;
        try {
            str = intent.getStringExtra(BaseWebViewFragment.EXTRA_URL);
            if (!TextUtils.isEmpty(str)) {
                str = Uri.parse(str).getPath();
            }
        } catch (Exception e) {
            qw.ggg(TAG, "onCreate", e);
        }
        qw.ad(TAG, "handleIntent url path " + str);
        if (data != null) {
            makeMsgRead(getIntent(), data);
        }
    }

    public void backKeyStatistics() {
    }

    public fe.mmm.qw.f.fe.ad.ad createTitleBar() {
        return new fe.mmm.qw.f.fe.ad.ad(this);
    }

    public boolean customStatusBar() {
        if (isInterceptTopBarImmerse() || this.curStatusBarType >= 0) {
            this.mTopBarColorControl.qw(this, 0, 1);
            return true;
        } else if (!isInterceptTopBarChangeColor()) {
            return super.customStatusBar();
        } else {
            this.mTopBarColorControl.de(this, this.mTitleBar);
            return true;
        }
    }

    public void finishToOtherPage() {
        finish();
    }

    public IActionManager getActionManager() {
        return null;
    }

    public FragmentActivity getActivity() {
        return this;
    }

    public abstract int getLayoutId();

    public String getPageTitle() {
        Intent intent = getIntent();
        String string = getString(R.string.web_view_default_title);
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(EXTRA_PAGE_TITLE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    string = stringExtra;
                }
            } catch (Exception e) {
                qw.th(TAG, e.getMessage(), e);
            }
        }
        qw.uk(TAG, "页面标题：" + string);
        return string;
    }

    public ViewModelStoreOwner getViewModelStoreOwner() {
        return this;
    }

    public WebView getWebView() {
        return this.mFragment.getWebView();
    }

    public void goBackPage() {
        if (!this.mFragment.goBack()) {
            finishToOtherPage();
        }
    }

    public abstract void initFragment();

    public void initParams() {
        super.initParams();
        if (getIntent().getExtras() != null) {
            this.mUrl = getIntent().getExtras().getString(BaseWebViewFragment.EXTRA_URL);
        }
    }

    public void initView() {
        fe.mmm.qw.f.fe.ad.ad createTitleBar = createTitleBar();
        this.mTitleBar = createTitleBar;
        createTitleBar.when(getPageTitle());
        this.mTitleBar.aaa(this);
        if (this.mFinishToOtherPage == 4) {
            this.mTitleBar.ppp(R.drawable.common_titlebar_btn_close);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            this.mTopBarColorControl = new ad(this.mUrl);
            qw.ad(TAG, "isNeedChangeTopBarColor: " + this.mTopBarColorControl.pf() + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mUrl);
            if (this.mTopBarColorControl.pf()) {
                this.mTopBarColorControl.de(this, this.mTitleBar);
            }
            if (isInterceptTopBarImmerse()) {
                this.mTitleBar.nn(false);
            }
        }
    }

    public boolean isInterceptTopBarChangeColor() {
        ad adVar = this.mTopBarColorControl;
        return adVar != null && adVar.pf();
    }

    public boolean isInterceptTopBarImmerse() {
        ad adVar = this.mTopBarColorControl;
        return adVar != null && adVar.i();
    }

    public boolean isInterceptTopBarImmerseNormal() {
        ad adVar = this.mTopBarColorControl;
        return adVar != null && adVar.o();
    }

    public boolean jsWebViewOpenApp(String str, String str2, String str3) {
        return false;
    }

    public void jsWwebViewRichMediaShareCallBack(String str, String str2, String str3, String str4, String str5, String str6) {
    }

    public void makeMsgRead(Intent intent, Uri uri) {
    }

    public boolean matcherTitle(String str) {
        return Pattern.compile(REGEX).matcher(str).matches();
    }

    public void onBackButtonClicked() {
        backKeyStatistics();
        goBackPage();
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                this.mFinishToOtherPage = extras.getInt(FINISH_TO_OTHER_PAGE);
                this.mActivityType = extras.getInt(EXTRA_ACTIVITY_TYPE);
                qw.ad(TAG, "mActivityType: " + this.mActivityType);
            } catch (Exception e) {
                qw.ggg(TAG, "onCreate", e);
            }
        }
        super.onCreate(bundle);
        handleIntent(getIntent());
        initFragment();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return webViewBack();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            if (intent.getExtras() == null) {
                qw.rg(TAG, "onNewIntent Extras empty");
                return;
            }
            handleIntent(intent);
            String string = intent.getExtras().getString(BaseWebViewFragment.EXTRA_URL);
            qw.uk(TAG, "onNewIntent newUrl:" + string);
            this.mFragment.updateView(string);
        } catch (Exception e) {
            qw.th(TAG, e.getMessage(), e);
        }
    }

    public final void onRestoreInstanceState(Bundle bundle) {
    }

    public void onResume() {
        super.onResume();
        try {
            String string = getIntent().getExtras().getString(BaseWebViewFragment.EXTRA_URL);
            qw.uk(TAG, "onResume url:" + string);
        } catch (Exception e) {
            qw.th(TAG, e.getMessage(), e);
        }
    }

    public void onRightButtonClicked(View view) {
        if (this.mFinishToOtherPage == 4) {
            finish();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onTitleChange(String str, String str2) {
        qw.ad(TAG, "title:" + str2);
        if (TextUtils.isEmpty(str2)) {
            this.mTitleBar.when(getPageTitle());
        } else if (this.mTitleBar.yj() != null && !TextUtils.equals(this.mTitleBar.yj().getText().toString(), str2) && !matcherTitle(str2)) {
            this.mTitleBar.when(str2);
        }
    }

    @JavascriptInterface
    public void onWebViewButtonBuyVipClick(String str, int i2) {
    }

    @JavascriptInterface
    public int onWebViewGetAppVersionCode(String str) {
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(str, 1);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            qw.ggg(TAG, e.getMessage(), e);
            return -1;
        }
    }

    @JavascriptInterface
    public int onWebViewGetWidth() {
        return getWindowManager().getDefaultDisplay().getWidth();
    }

    @JavascriptInterface
    public boolean onWebViewOpenApp(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return jsWebViewOpenApp(this.mFragment.getOriginalUrl(), str, str2);
        }
        qw.ppp(TAG, "onWebViewOpenApp params error!");
        return false;
    }

    public boolean webViewBack() {
        backKeyStatistics();
        if (this.mFragment.goBack()) {
            return true;
        }
        finishToOtherPage();
        return true;
    }
}
