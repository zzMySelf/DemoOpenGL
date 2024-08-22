package fe.mmm.qw.m;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.s.a;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.tera.scan.network.network.request.RequestCommonParams;
import com.tera.scan.ui.widget.EmptyView;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.ICookiesSyncable;
import com.tera.scan.webview.IUrlLoadable1;
import com.tera.scan.webview.TeraScanWebView;
import fe.mmm.qw.a.uk.rg;
import fe.mmm.qw.rg.ad.ad;
import fe.mmm.qw.yj.yj;

public class o implements IUrlLoadable1 {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f8054ad;
    public final ICookiesSyncable qw;

    public class qw extends rg {
        public final /* synthetic */ BaseWebViewFragment ddd;
        public final /* synthetic */ String xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(String str, String str2, BaseWebViewFragment baseWebViewFragment) {
            super(str);
            this.xxx = str2;
            this.ddd = baseWebViewFragment;
        }

        public void when() {
            o.this.qw.qw(this.xxx);
            if (fe.mmm.qw.m.vvv.qw.qw()) {
                fe.mmm.qw.m.vvv.qw.rg(this.xxx);
                o.this.o(this.ddd, fe.mmm.qw.m.vvv.qw.de(this.xxx));
                return;
            }
            o.this.o(this.ddd, this.xxx);
        }
    }

    public o(@NonNull ICookiesSyncable iCookiesSyncable) {
        this(iCookiesSyncable, false);
    }

    public static /* synthetic */ void yj(BaseWebViewFragment baseWebViewFragment, String str) {
        if (baseWebViewFragment.getWebView() != null) {
            baseWebViewFragment.getWebView().loadUrl(str);
        }
    }

    public final String fe(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        fe.mmm.qw.m.when.qw.qw.qw qwVar = new fe.mmm.qw.m.when.qw.qw.qw(yj.ppp().yj("private_web_view"));
        if (!str.contains(ad.de()) && !str.contains(qwVar.qw) && !fe.mmm.qw.j.qw.qw(str)) {
            return str;
        }
        String th2 = th();
        if (TextUtils.isEmpty(th2)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf(Bank.HOT_BANK_LETTER);
        if (indexOf > 0) {
            int i2 = indexOf + 1;
            String substring = str.substring(0, i2);
            String substring2 = str.substring(i2);
            return substring + th2 + a.n + substring2;
        } else if (indexOf2 > 0) {
            String substring3 = str.substring(0, indexOf2);
            String substring4 = str.substring(indexOf2);
            return substring3 + "?" + th2 + substring4;
        } else {
            return str + "?" + th2;
        }
    }

    public void i(BaseWebViewFragment baseWebViewFragment, String str) {
        EmptyView emptyView = baseWebViewFragment.getEmptyView();
        TeraScanWebView webView = baseWebViewFragment.getWebView();
        TextView textLoading = baseWebViewFragment.getTextLoading();
        if (webView == null) {
            if (emptyView != null) {
                emptyView.setVisibility(0);
            }
            if (textLoading != null) {
                textLoading.setVisibility(8);
            }
        } else if (TextUtils.isEmpty(str)) {
            if (emptyView != null) {
                emptyView.setVisibility(0);
            }
            webView.setVisibility(4);
            if (textLoading != null) {
                textLoading.setVisibility(8);
            }
        } else {
            if (emptyView != null) {
                emptyView.setVisibility(8);
                emptyView.setRefreshVisibility(8);
            }
            baseWebViewFragment.setError(false);
            webView.setVisibility(0);
            uk(baseWebViewFragment, str);
        }
    }

    public final void o(BaseWebViewFragment baseWebViewFragment, String str) {
        new Handler(Looper.getMainLooper()).post(new qw(baseWebViewFragment, str));
    }

    public void qw(@NonNull BaseWebViewFragment baseWebViewFragment, @Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            str = fe(str);
        }
        String performanceLogID = baseWebViewFragment.getPerformanceLogID();
        if (!TextUtils.isEmpty(performanceLogID)) {
            str = Uri.parse(str).buildUpon().appendQueryParameter("hybrid_log_id", performanceLogID).build().toString();
        }
        i(baseWebViewFragment, str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void rg(BaseWebViewFragment baseWebViewFragment, String str) {
        WebSettings settings = baseWebViewFragment.getWebView().getSettings();
        settings.setUseWideViewPort(true);
        String o2 = RequestCommonParams.o();
        if (!TextUtils.isEmpty(o2) && fe.mmm.qw.de.qw.qw.qw.qw(str)) {
            String userAgentString = settings.getUserAgentString();
            if (TextUtils.isEmpty(userAgentString) || !userAgentString.endsWith(o2)) {
                String str2 = userAgentString + " " + o2;
                fe.mmm.qw.i.qw.ad("ImmediatelyUrlLoader", "configWebViewByUrl ua: " + str2 + " url " + str + "  originUserAgent:" + userAgentString + "  netdiskUserAgent:" + o2);
                settings.setUserAgentString(str2);
            }
        }
    }

    public String th() {
        return pf.qw.qw();
    }

    public final void uk(BaseWebViewFragment baseWebViewFragment, String str) {
        rg(baseWebViewFragment, str);
        if (str.contains(ad.de()) || this.f8054ad || (fe.mmm.qw.m.vvv.qw.qw() && fe.mmm.qw.m.vvv.qw.ad(str))) {
            new qw("ImmediatelyUrlLoaderonActivityResult", str, baseWebViewFragment).mmm();
        } else {
            baseWebViewFragment.getWebView().loadUrl(str);
        }
        fe.mmm.qw.i.qw.ad("ImmediatelyUrlLoader", "configWebViewByUrl url:" + str);
    }

    public o(@NonNull ICookiesSyncable iCookiesSyncable, boolean z) {
        this.qw = iCookiesSyncable;
        this.f8054ad = z;
    }
}
