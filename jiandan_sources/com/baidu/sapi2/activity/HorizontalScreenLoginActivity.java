package com.baidu.sapi2.activity;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.views.RoundWebview;
import com.baidu.sapi2.views.ViewUtility;

public class HorizontalScreenLoginActivity extends LoginActivity {
    public static int L;

    public static class AndroidBug5497Workaround {
        public final int a;
        public View b;
        public WebView c = a((ViewGroup) this.b);
        public int d;
        public FrameLayout.LayoutParams e = ((FrameLayout.LayoutParams) this.b.getLayoutParams());

        public AndroidBug5497Workaround(Activity activity) {
            View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
            this.b = childAt;
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    AndroidBug5497Workaround.this.b();
                }
            });
            this.a = activity.getWindowManager().getDefaultDisplay().getWidth();
        }

        public static void assistActivity(Activity activity) {
            new AndroidBug5497Workaround(activity);
        }

        private WebView a(ViewGroup viewGroup) {
            WebView a2;
            if (viewGroup == null) {
                return null;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof WebView) {
                    return (WebView) childAt;
                }
                if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                    return a2;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void b() {
            int a2 = a();
            if (a2 != this.d) {
                int i2 = this.a;
                int i3 = i2 - a2;
                int i4 = i2 / 4;
                if (i3 > i4) {
                    this.e.height = i2 - i3;
                } else {
                    this.e.height = i2;
                }
                this.b.requestLayout();
                if (i3 <= i4) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            try {
                                AndroidBug5497Workaround.this.c.scrollTo(0, 0);
                            } catch (Exception unused) {
                            }
                        }
                    }, 200);
                } else if (this.c.getUrl() != null && (this.c.getUrl().endsWith("/sms_login_new") || this.c.getUrl().contains("sms_login") || this.c.getUrl().contains("act=bind_mobile"))) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            try {
                                AndroidBug5497Workaround.this.c.scrollTo(0, HorizontalScreenLoginActivity.L);
                            } catch (Exception unused) {
                            }
                        }
                    }, 200);
                }
                this.d = a2;
            }
        }

        private int a() {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            return rect.bottom - rect.top;
        }
    }

    public void lockScreenOrientation() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28 || i2 <= 25) {
            setRequestedOrientation(0);
        }
    }

    public void onCreate(Bundle bundle) {
        ViewUtility.setOrientationToUndefined(this);
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_horizontal_screen_webview_with_title_bar);
            AndroidBug5497Workaround.assistActivity(this);
            init();
            setupViews();
            this.sapiWebView.setVerticalScrollBarEnabled(false);
            this.sapiWebView.setVerticalFadingEdgeEnabled(false);
            this.sapiWebView.setFocusEdittextCoordinateYCallBack(new SapiJsCallBacks.FocusEdittextCoordinateYCallBack() {
                public void onCallback(int i2) {
                    int unused = HorizontalScreenLoginActivity.L = (int) (((float) i2) * HorizontalScreenLoginActivity.this.getResources().getDisplayMetrics().density);
                }
            });
            this.sapiWebView.setOverScrollMode(2);
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView instanceof RoundWebview) {
                RoundWebview roundWebview = (RoundWebview) sapiWebView;
                roundWebview.a(getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius), getResources().getDimension(R.dimen.sapi_sdk_webview_radius));
                roundWebview.setLayerType(1, (Paint) null);
            }
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            loginFail(this.webAuthResult);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
