package i;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.web.WebActivity;
import g.e;
import h.d;
import j.b;
import java.net.MalformedURLException;
import java.net.URL;

public final class a extends b {
    public a(Activity activity, d dVar, b bVar) {
        super(activity, dVar, bVar);
    }

    public final boolean a() {
        b();
        return true;
    }

    public final void b() {
        WbAuthListener wbAuthListener;
        String str = this.f7776d.f7779b.f5628d;
        if (!TextUtils.isEmpty(str)) {
            b.b bVar = this.f7773a;
            synchronized (bVar) {
                if (TextUtils.isEmpty(str)) {
                    wbAuthListener = null;
                } else {
                    wbAuthListener = (WbAuthListener) bVar.f1440a.get(str);
                }
            }
            this.f7777e = wbAuthListener;
            if (wbAuthListener != null) {
                wbAuthListener.onCancel();
            }
            b.b bVar2 = this.f7773a;
            synchronized (bVar2) {
                if (!TextUtils.isEmpty(str)) {
                    bVar2.f1440a.remove(str);
                }
            }
        }
        d dVar = this.f7775c;
        if (dVar != null) {
            ((WebActivity) dVar).finish();
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        Bundle bundle;
        WbAuthListener wbAuthListener;
        super.onPageFinished(webView, str);
        AuthInfo authInfo = this.f7776d.f7779b.f5625a;
        if (authInfo != null && str.startsWith(authInfo.getRedirectUrl())) {
            String str2 = this.f7776d.f7779b.f5628d;
            if (!TextUtils.isEmpty(str2)) {
                b.b bVar = this.f7773a;
                synchronized (bVar) {
                    bundle = null;
                    if (TextUtils.isEmpty(str2)) {
                        wbAuthListener = null;
                    } else {
                        wbAuthListener = (WbAuthListener) bVar.f1440a.get(str2);
                    }
                }
                this.f7777e = wbAuthListener;
                if (wbAuthListener != null) {
                    char[] cArr = e.f7768a;
                    try {
                        bundle = e.a(new URL(str).getQuery());
                    } catch (MalformedURLException e2) {
                        e2.printStackTrace();
                    }
                    if (bundle != null) {
                        String string = bundle.getString("error");
                        String string2 = bundle.getString("error_code");
                        String string3 = bundle.getString("error_description");
                        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                            this.f7777e.onError(new UiError(-1, string2, string3));
                        } else {
                            Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
                            AccessTokenHelper.writeAccessToken(this.f7774b, parseAccessToken);
                            this.f7777e.onComplete(parseAccessToken);
                        }
                    } else {
                        this.f7777e.onError(new UiError(-1, "bundle is null", "parse url error"));
                    }
                    b.b bVar2 = this.f7773a;
                    synchronized (bVar2) {
                        if (!TextUtils.isEmpty(str2)) {
                            bVar2.f1440a.remove(str2);
                        }
                    }
                }
            }
            d dVar = this.f7775c;
            if (dVar != null) {
                ((WebActivity) dVar).finish();
            }
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        String uri = webResourceRequest.getUrl().toString();
        AuthInfo authInfo = this.f7776d.f7779b.f5625a;
        if (authInfo == null || !uri.startsWith(authInfo.getRedirectUrl())) {
            return false;
        }
        char[] cArr = e.f7768a;
        try {
            bundle = e.a(new URL(uri).getQuery());
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            bundle = null;
        }
        if (bundle != null) {
            return !TextUtils.isEmpty(bundle.getString("access_token"));
        }
        return false;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Bundle bundle;
        AuthInfo authInfo = this.f7776d.f7779b.f5625a;
        if (authInfo != null && str.startsWith(authInfo.getRedirectUrl())) {
            char[] cArr = e.f7768a;
            try {
                bundle = e.a(new URL(str).getQuery());
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                bundle = null;
            }
            if (bundle != null) {
                return !TextUtils.isEmpty(bundle.getString("access_token"));
            }
        }
        return false;
    }
}
