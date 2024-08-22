package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.SweepLightLoadingView;

public class c {

    public class a implements View.OnClickListener {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ View b;

        /* renamed from: com.baidu.sapi2.utils.c$a$a  reason: collision with other inner class name */
        public class C0040a implements Runnable {
            public C0040a() {
            }

            public void run() {
                a.this.b.setVisibility(4);
                a.this.a.reload();
            }
        }

        public a(WebView webView, View view) {
            this.a = webView;
            this.b = view;
        }

        public void onClick(View view) {
            this.a.post(new C0040a());
        }
    }

    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        if (sapiWebView != null) {
            a(context, sapiWebView);
            d(context, sapiWebView);
            if (z) {
                c(context, sapiWebView);
            } else {
                b(context, sapiWebView);
            }
        }
    }

    public static void b(Context context, SapiWebView sapiWebView, View view) {
        sapiWebView.setWebviewLoadingView(view);
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        sapiWebView.setWebviewLoadingView(new SweepLightLoadingView(context));
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        sapiWebView.setTimeoutView(a(context, (WebView) sapiWebView));
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        try {
            ProgressBar progressBar = new ProgressBar(context, (AttributeSet) null, 16842872);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
            progressBar.setBackgroundColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_color));
            sapiWebView.setProgressBar(progressBar);
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    public static void a(Context context, SapiWebView sapiWebView, View view) {
        if (sapiWebView != null) {
            a(context, sapiWebView);
            d(context, sapiWebView);
            if (view != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
                b(context, sapiWebView, view);
            }
        }
    }

    public static void a(Context context, SapiWebView sapiWebView) {
        sapiWebView.setNoNetworkView(a(context, (WebView) sapiWebView));
    }

    public static View a(Context context, WebView webView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(R.id.btn_retry);
        if (DarkModeUtil.isDarkMode(context) && inflate != null) {
            ((LinearLayout) inflate.findViewById(R.id.sapi_sdk_loading_timeout_bg_layout)).setBackgroundColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_color));
            ((TextView) inflate.findViewById(R.id.sapi_sdk_loading_timeout_tv)).setTextColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_no_network_tv_color));
            ((ImageView) inflate.findViewById(R.id.sapi_sdk_loading_timeout_iv)).setImageResource(R.drawable.sapi_sdk_icon_connection_failed_dark);
            button.setBackgroundResource(R.drawable.sapi_sdk_btn_gray);
            Resources resources = context.getResources();
            if (resources != null) {
                button.setTextColor(resources.getColorStateList(R.color.sapi_sdk_text_white));
            }
        }
        button.setOnClickListener(new a(webView, inflate));
        return inflate;
    }
}
