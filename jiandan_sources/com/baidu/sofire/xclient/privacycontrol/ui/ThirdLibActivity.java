package com.baidu.sofire.xclient.privacycontrol.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.baidu.aiscan.R;
import com.baidu.sofire.ac.F;

public class ThirdLibActivity extends Activity {
    public static final /* synthetic */ int c = 0;
    public WebView a;
    public LinearLayout b;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ThirdLibActivity.this.a.reload();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ThirdLibActivity thirdLibActivity = ThirdLibActivity.this;
            if (thirdLibActivity.a.canGoBack()) {
                thirdLibActivity.a.goBack();
            } else {
                thirdLibActivity.finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.privacy_lib_third_lib_list);
        this.a = (WebView) findViewById(R.id.privacy_web_view);
        this.b = (LinearLayout) findViewById(R.id.layout_retry);
        com.baidu.sofire.xclient.privacycontrol.e.b.c().b(2);
        if (Build.VERSION.SDK_INT < 17) {
            this.a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.a.removeJavascriptInterface("accessibility");
            this.a.removeJavascriptInterface("accessibilityTraversal");
        }
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.getSettings().setDomStorageEnabled(true);
        this.a.getSettings().setUseWideViewPort(true);
        this.a.getSettings().setLoadWithOverviewMode(true);
        this.a.getSettings().setBuiltInZoomControls(true);
        this.a.getSettings().setDisplayZoomControls(false);
        this.a.getSettings().setSupportZoom(true);
        this.a.setWebViewClient(new com.baidu.sofire.xclient.privacycontrol.g.b(this));
        this.a.loadUrl("https://sofire.baidu.com/pr/ui/third.html?zid=" + F.getInstance().gzd(getApplicationContext()) + "&platform=android&appkey=" + com.baidu.sofire.xclient.privacycontrol.f.a.a(getApplicationContext()));
        findViewById(R.id.btn_retry).setOnClickListener(new a());
        findViewById(R.id.image_back).setOnClickListener(new b());
    }

    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.a;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.a);
            }
            this.a.stopLoading();
            this.a.clearCache(true);
            this.a.clearHistory();
            this.a.removeAllViewsInLayout();
            this.a.removeAllViews();
            this.a.destroy();
            this.a = null;
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.a.canGoBack()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.a.goBack();
        return true;
    }
}
