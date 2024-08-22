package com.tera.scan.web;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.utils.SizeUtils;
import com.tera.scan.web.hybrid.ablity.IActionTitleBar;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.ContainerWebViewActivity;
import com.tera.scan.webview.IPageFinishListener;
import com.tera.scan.webview.IPageStartListener;
import com.tera.scan.webview.hybrid.action.IActionManager;
import com.tera.scan.webview.hybrid.action.IWebView;
import com.tera.scan.webview.hybrid.action.IWebViewCallback;
import com.tera.scan.webview.hybrid.factory.IHybridSupport;
import fe.mmm.qw.d.fe.uk;
import fe.mmm.qw.l.fe.ad.ad;
import fe.mmm.qw.l.fe.qw.de;
import fe.mmm.qw.l.fe.qw.fe;
import fe.mmm.qw.l.fe.qw.th;
import fe.mmm.qw.m.Cif;
import fe.mmm.qw.m.o;
import fe.mmm.qw.m.rg;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0014J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0013H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tera/scan/web/WebPreviewActivity;", "Lcom/tera/scan/webview/ContainerWebViewActivity;", "Lcom/tera/scan/web/hybrid/ablity/IActionTitleBar;", "Lcom/tera/scan/webview/hybrid/action/IWebView;", "Lcom/tera/scan/webview/IPageFinishListener;", "Lcom/tera/scan/webview/IPageStartListener;", "()V", "hybridManager", "Lcom/tera/scan/webview/hybrid/action/IActionManager;", "rightBtnClickUrl", "", "webClient", "Lcom/tera/scan/webview/BaseClient;", "controlRightBtn", "", "theme", "Lcom/tera/scan/web/hybrid/bean/TitleBarTheme;", "getActionManager", "getLayoutId", "", "gone", "immerseStatusBar", "initFragment", "initParams", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPageFinished", "url", "onPageStarted", "onResume", "onRightButtonClicked", "view", "Landroid/view/View;", "setBarColorAndGetHeight", "colorType", "setCallback", "callback", "Lcom/tera/scan/webview/hybrid/action/IWebViewCallback;", "setHeight", "height", "setWidth", "width", "preview-web_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("WebPreviewActivity")
public final class WebPreviewActivity extends ContainerWebViewActivity implements IActionTitleBar, IWebView, IPageFinishListener, IPageStartListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public IActionManager hybridManager;
    @Nullable
    public String rightBtnClickUrl;
    @Nullable
    public rg webClient;

    public static final class qw implements IHybridSupport {
        public final /* synthetic */ WebPreviewActivity qw;

        public qw(WebPreviewActivity webPreviewActivity) {
            this.qw = webPreviewActivity;
        }

        @NotNull
        public IBaseView qw() {
            return this.qw;
        }
    }

    private final void immerseStatusBar() {
        Object obj;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            try {
                Result.Companion companion = Result.Companion;
                if (isInterceptTopBarImmerse()) {
                    setBarColorAndGetHeight(this.curStatusBarType);
                    return;
                }
                if (this.mTitleBar != null) {
                    ViewGroup fe2 = this.mTitleBar.fe();
                    Intrinsics.checkNotNullExpressionValue(fe2, "mTitleBar.rootView");
                    if (fe2.getVisibility() == 0) {
                        this.mTitleBar.fe().setPadding(this.mTitleBar.fe().getPaddingLeft(), uk.qw(activity), this.mTitleBar.fe().getPaddingRight(), this.mTitleBar.fe().getPaddingBottom());
                    }
                }
                uk.ad(activity, true, (ViewGroup) null);
                obj = Result.m1155constructorimpl(Unit.INSTANCE);
                Result.m1154boximpl(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void controlRightBtn(@NotNull ad adVar) {
        char c;
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(adVar, "theme");
        if (this.mTitleBar != null) {
            boolean z = false;
            if (adVar.de() == 1) {
                this.mTitleBar.vvv(adVar.fe());
                this.mTitleBar.ggg(adVar.ad() == 1);
                this.mTitleBar.xxx(true);
                String rg2 = adVar.rg();
                if (!(rg2 == null || rg2.length() == 0)) {
                    String str = "time=" + System.currentTimeMillis();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(rg2);
                    if (StringsKt__StringsKt.contains$default((CharSequence) rg2, (CharSequence) "?", false, 2, (Object) null)) {
                        sb = new StringBuilder();
                        c = Typography.amp;
                    } else {
                        sb = new StringBuilder();
                        c = '?';
                    }
                    sb.append(c);
                    sb.append(str);
                    sb2.append(sb.toString());
                    rg2 = sb2.toString();
                }
                this.rightBtnClickUrl = rg2;
                String qw2 = adVar.qw();
                if (qw2 == null || qw2.length() == 0) {
                    z = true;
                }
                if (!z) {
                    this.mTitleBar.ddd(adVar.qw());
                    return;
                }
                return;
            }
            this.mTitleBar.xxx(false);
            this.mTitleBar.ggg(false);
        }
    }

    @NotNull
    public IActionManager getActionManager() {
        fe.mmm.qw.m.ggg.de.qw qwVar = new fe.mmm.qw.m.ggg.de.qw(new qw(this), false, 2, (DefaultConstructorMarker) null);
        if (!isInterceptTopBarImmerse()) {
            qwVar.rg("WPJS_header_hidden", new fe(this, this.mTitleBar.fe()));
        }
        qwVar.rg("WPJS_page_close", new fe.mmm.qw.l.fe.qw.ad(this));
        qwVar.rg("WPJS_page_forward", new de(this));
        qwVar.rg("WPJS_ui_title", new fe.mmm.qw.l.fe.qw.rg(this, this));
        qwVar.rg("WPJS_system_webview", new th(this, this));
        return qwVar;
    }

    public int getLayoutId() {
        return R.layout.web_preview_activity;
    }

    public void gone() {
    }

    public void initFragment() {
        Object obj;
        this.hybridManager = getActionManager();
        Cif ifVar = new Cif();
        fe.mmm.qw.l.ad adVar = new fe.mmm.qw.l.ad(this, this, this.hybridManager);
        this.webClient = adVar;
        Unit unit = Unit.INSTANCE;
        ifVar.m982if(adVar);
        ifVar.pf(new fe.mmm.qw.m.th());
        ifVar.o(new o(new fe.mmm.qw.m.uk(getApplicationContext())));
        BaseWebViewFragment qw2 = ifVar.qw();
        this.mFragment = qw2;
        if (qw2 != null) {
            try {
                Result.Companion companion = Result.Companion;
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                qw2.setArguments(extras);
                obj = Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            Result.m1154boximpl(obj);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.content_webview, this.mFragment);
        beginTransaction.commitAllowingStateLoss();
        rg rgVar = this.webClient;
        if (rgVar != null) {
            rgVar.ad(this);
        }
        rg rgVar2 = this.webClient;
        if (rgVar2 != null) {
            rgVar2.qw(this);
        }
    }

    public void initParams() {
        super.initParams();
        WebView.setWebContentsDebuggingEnabled(fe.mmm.qw.yj.de.ppp().fe("fe_web_view_debug_switch", false));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        fe.mmm.qw.m.fe.f8022yj.qw(this);
    }

    public void onPageFinished(@Nullable String str) {
        IActionManager iActionManager = this.hybridManager;
        fe.mmm.qw.m.ggg.qw.qw ad2 = iActionManager != null ? iActionManager.ad("WPJS_header_hidden") : null;
        if (ad2 != null && (ad2 instanceof fe)) {
            ((fe) ad2).ad(str);
        }
    }

    public void onPageStarted(@Nullable String str) {
        IActionManager iActionManager = this.hybridManager;
        fe.mmm.qw.m.ggg.qw.qw ad2 = iActionManager != null ? iActionManager.ad("WPJS_header_hidden") : null;
        if (ad2 != null && (ad2 instanceof fe)) {
            ((fe) ad2).de(str);
        }
    }

    public void onResume() {
        super.onResume();
        immerseStatusBar();
    }

    public void onRightButtonClicked(@Nullable View view) {
        super.onRightButtonClicked(view);
        String str = this.rightBtnClickUrl;
        if (!(str == null || str.length() == 0)) {
            fe.mmm.qw.l.de.ad(this, this.rightBtnClickUrl);
        }
    }

    public int setBarColorAndGetHeight(int i2) {
        Integer num;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return 0;
        }
        try {
            Result.Companion companion = Result.Companion;
            this.curStatusBarType = i2;
            fe.mmm.qw.m.xxx.qw.yj(activity, 0);
            boolean z = true;
            if (this.curStatusBarType < 0) {
                z = fe.mmm.qw.d.qw.rg(activity);
            } else if (this.curStatusBarType != 1) {
                z = false;
            }
            uk.ad(activity, z, (ViewGroup) null);
            if (z) {
                fe.mmm.qw.m.xxx.qw.i(activity);
            } else {
                fe.mmm.qw.m.xxx.qw.o(activity);
            }
            num = Result.m1155constructorimpl(Integer.valueOf(SizeUtils.ad((float) uk.qw(activity))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(num)) {
            num = 0;
        }
        return ((Number) num).intValue();
    }

    public void setCallback(@NotNull IWebViewCallback iWebViewCallback) {
        Intrinsics.checkNotNullParameter(iWebViewCallback, "callback");
    }

    public void setHeight(int i2) {
    }

    public void setWidth(int i2) {
    }
}
