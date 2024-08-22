package fe.mmm.qw.m;

import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.IStateCallback;
import com.tera.scan.webview.IUrlLoadable1;
import com.tera.scan.webview.TeraScanWebView;

/* renamed from: fe.mmm.qw.m.if  reason: invalid class name */
public class Cif {

    /* renamed from: ad  reason: collision with root package name */
    public IStateCallback f8048ad;

    /* renamed from: de  reason: collision with root package name */
    public rg f8049de;

    /* renamed from: fe  reason: collision with root package name */
    public WebChromeClient f8050fe;
    public IUrlLoadable1 qw;

    /* renamed from: rg  reason: collision with root package name */
    public DownloadListener f8051rg;

    /* renamed from: th  reason: collision with root package name */
    public Cswitch f8052th;

    /* renamed from: yj  reason: collision with root package name */
    public TeraScanWebView f8053yj;

    public DownloadListener ad() {
        return this.f8051rg;
    }

    public Cswitch de() {
        return this.f8052th;
    }

    public IStateCallback fe() {
        return this.f8048ad;
    }

    public Cif i(IStateCallback iStateCallback) {
        this.f8048ad = iStateCallback;
        return this;
    }

    /* renamed from: if  reason: not valid java name */
    public Cif m982if(rg rgVar) {
        this.f8049de = rgVar;
        return this;
    }

    public Cif o(IUrlLoadable1 iUrlLoadable1) {
        this.qw = iUrlLoadable1;
        return this;
    }

    public Cif pf(WebChromeClient webChromeClient) {
        this.f8050fe = webChromeClient;
        return this;
    }

    public BaseWebViewFragment qw() {
        BaseWebViewFragment baseWebViewFragment = new BaseWebViewFragment();
        baseWebViewFragment.init(this);
        return baseWebViewFragment;
    }

    public IUrlLoadable1 rg() {
        return this.qw;
    }

    public WebChromeClient th() {
        return this.f8050fe;
    }

    public WebViewClient uk() {
        return this.f8049de;
    }

    public TeraScanWebView yj() {
        return this.f8053yj;
    }
}
