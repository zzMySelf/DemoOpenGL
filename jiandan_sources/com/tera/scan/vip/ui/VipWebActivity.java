package com.tera.scan.vip.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelStoreOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.aiscan.R;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.vip.ui.action.HybridActionPay;
import com.tera.scan.vip.ui.viewmodel.VipBuyViewModel;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.TeraScanWebView;
import com.tera.scan.webview.hybrid.action.IActionManager;
import com.tera.scan.webview.hybrid.action.IWebViewListener;
import com.tera.scan.webview.hybrid.factory.IHybridSupport;
import fe.mmm.qw.k.pf.de;
import fe.mmm.qw.k.pf.fe;
import fe.mmm.qw.k.pf.rg;
import fe.mmm.qw.k.pf.th;
import fe.mmm.qw.m.o;
import fe.mmm.qw.m.yj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020.H\u0002J2\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00072\u0010\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001022\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u000102H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020\u0010H\u0014J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020.H\u0002J\b\u0010@\u001a\u00020.H\u0002J\b\u0010A\u001a\u00020.H\u0014J\b\u0010B\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020\u0019H\u0002J\"\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\b\u0010I\u001a\u00020.H\u0016J\u0012\u0010J\u001a\u00020.2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u00020.H\u0014J\u0018\u0010N\u001a\u00020.2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0002J\u0016\u0010P\u001a\u00020.2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010RR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b(\u0010)¨\u0006T"}, d2 = {"Lcom/tera/scan/vip/ui/VipWebActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/framework/ui/view/IBaseView;", "Lcom/tera/scan/webview/hybrid/action/IWebViewListener;", "()V", "enableJSMethods", "", "", "fragment", "Lcom/tera/scan/webview/BaseWebViewFragment;", "kotlin.jvm.PlatformType", "getFragment", "()Lcom/tera/scan/webview/BaseWebViewFragment;", "fragment$delegate", "Lkotlin/Lazy;", "from", "", "getFrom", "()I", "from$delegate", "fromScene", "getFromScene", "()Ljava/lang/String;", "fromScene$delegate", "isBackPress", "", "needExtra", "getNeedExtra", "()Z", "needExtra$delegate", "paramUrl", "getParamUrl", "paramUrl$delegate", "urlLoader", "Lcom/tera/scan/webview/ImmediatelyUrlLoader;", "getUrlLoader", "()Lcom/tera/scan/webview/ImmediatelyUrlLoader;", "urlLoader$delegate", "vipBuyViewModel", "Lcom/tera/scan/vip/ui/viewmodel/VipBuyViewModel;", "getVipBuyViewModel", "()Lcom/tera/scan/vip/ui/viewmodel/VipBuyViewModel;", "vipBuyViewModel$delegate", "addUrlParams", "url", "backPress", "", "evaluateJavascript", "jsFuncName", "resultCallback", "Landroid/webkit/ValueCallback;", "exceptionCallback", "", "getActionManager", "Lcom/tera/scan/webview/hybrid/action/IActionManager;", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "getBaseUrl", "getLayoutId", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "getWebView", "Landroid/webkit/WebView;", "initFragment", "initTitle", "initView", "initWebView", "interceptBackPress", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onTitleChanged", "title", "setEnableJSMethods", "methods", "", "Companion", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Keep
public final class VipWebActivity extends BaseActivity implements IBaseView, IWebViewListener {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String FEED_BACK_FROM_TYPE = "from_page";
    @NotNull
    public static final String FEED_BACK_PAGE_FROM_VIP_CENTER = "vipCenter";
    @NotNull
    public static final String FROM_SCENE = "FROM_SCENE";
    @NotNull
    public static final String FROM_TYPE = "FROM_TYPE";
    @NotNull
    public static final String PARAM_NEED_EXTRA = "PARAM_NEED_EXTRA";
    @NotNull
    public static final String PARAM_URL = "PARAM_URL";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final List<String> enableJSMethods = new ArrayList();
    @NotNull
    public final Lazy fragment$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$fragment$2(this));
    @NotNull
    public final Lazy from$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$from$2(this));
    @NotNull
    public final Lazy fromScene$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$fromScene$2(this));
    public boolean isBackPress;
    @NotNull
    public final Lazy needExtra$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$needExtra$2(this));
    @NotNull
    public final Lazy paramUrl$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$paramUrl$2(this));
    @NotNull
    public final Lazy urlLoader$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$urlLoader$2(this));
    @NotNull
    public final Lazy vipBuyViewModel$delegate = LazyKt__LazyJVMKt.lazy(new VipWebActivity$vipBuyViewModel$2(this));

    public static final class ad implements IHybridSupport {
        public final /* synthetic */ VipWebActivity qw;

        public ad(VipWebActivity vipWebActivity) {
            this.qw = vipWebActivity;
        }

        @NotNull
        public IBaseView qw() {
            return this.qw;
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String addUrlParams(String str) {
        Locale qw2 = fe.mmm.qw.when.qw.qw();
        Intrinsics.checkNotNullExpressionValue(qw2, "getAppLocale()");
        if (getNeedExtra()) {
            return getBaseUrl() + str + "?lang=" + qw2.getLanguage();
        }
        return getBaseUrl() + str;
    }

    private final void backPress() {
        BaseWebViewFragment baseWebViewFragment = (BaseWebViewFragment) new WeakReference(getFragment()).get();
        if (baseWebViewFragment == null || !baseWebViewFragment.goBack()) {
            super.onBackPressed();
        }
    }

    private final void evaluateJavascript(String str, ValueCallback<String> valueCallback, ValueCallback<Throwable> valueCallback2) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            getFragment().getWebView().evaluateJavascript(str, valueCallback);
            obj = Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r2 = Result.m1158exceptionOrNullimpl(obj);
        if (r2 != null && valueCallback2 != null) {
            valueCallback2.onReceiveValue(r2);
        }
    }

    private final IActionManager getActionManager() {
        fe.mmm.qw.m.ggg.de.qw qwVar = new fe.mmm.qw.m.ggg.de.qw(new ad(this), false, 2, (DefaultConstructorMarker) null);
        qwVar.rg(QueryResponse.Options.PAY, new HybridActionPay(this, getBaseUrl(), getFromScene()));
        return qwVar;
    }

    private final String getBaseUrl() {
        return fe.mmm.qw.rg.ad.ad.yj();
    }

    private final BaseWebViewFragment getFragment() {
        return (BaseWebViewFragment) this.fragment$delegate.getValue();
    }

    private final int getFrom() {
        return ((Number) this.from$delegate.getValue()).intValue();
    }

    private final String getFromScene() {
        return (String) this.fromScene$delegate.getValue();
    }

    private final boolean getNeedExtra() {
        return ((Boolean) this.needExtra$delegate.getValue()).booleanValue();
    }

    private final String getParamUrl() {
        return (String) this.paramUrl$delegate.getValue();
    }

    private final o getUrlLoader() {
        return (o) this.urlLoader$delegate.getValue();
    }

    private final VipBuyViewModel getVipBuyViewModel() {
        return (VipBuyViewModel) this.vipBuyViewModel$delegate.getValue();
    }

    private final void initFragment() {
        Object obj;
        try {
            getFragment().setArguments(new Bundle());
        } catch (Exception e) {
            LoggerKt.e$default(e, (Object) null, 1, (Object) null);
        }
        try {
            Result.Companion companion = Result.Companion;
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
            beginTransaction.add((int) R.id.fl_container, (Fragment) getFragment(), BaseWebViewFragment.TAG);
            obj = Result.m1155constructorimpl(Integer.valueOf(beginTransaction.commitAllowingStateLoss()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r0 = Result.m1158exceptionOrNullimpl(obj);
        if (r0 != null) {
            r0.printStackTrace();
        }
    }

    private final void initTitle() {
        ((ImageView) _$_findCachedViewById(R.id.btn_back)).setOnClickListener(new th(this));
        ((ImageView) _$_findCachedViewById(R.id.btn_help_center)).setOnClickListener(new fe.mmm.qw.k.pf.ad(this));
        ((ImageView) _$_findCachedViewById(R.id.btn_pay_record)).setOnClickListener(new fe(this));
    }

    /* renamed from: initTitle$lambda-3  reason: not valid java name */
    public static final void m938initTitle$lambda3(VipWebActivity vipWebActivity, View view) {
        Intrinsics.checkNotNullParameter(vipWebActivity, "this$0");
        vipWebActivity.onBackPressed();
    }

    /* renamed from: initTitle$lambda-4  reason: not valid java name */
    public static final void m939initTitle$lambda4(VipWebActivity vipWebActivity, View view) {
        Intrinsics.checkNotNullParameter(vipWebActivity, "this$0");
        vipWebActivity.getUrlLoader().qw(vipWebActivity.getFragment(), vipWebActivity.addUrlParams("/wap/hyhelpcenter/commonquestions"));
    }

    /* renamed from: initTitle$lambda-5  reason: not valid java name */
    public static final void m940initTitle$lambda5(VipWebActivity vipWebActivity, View view) {
        Intrinsics.checkNotNullParameter(vipWebActivity, "this$0");
        vipWebActivity.getUrlLoader().qw(vipWebActivity.getFragment(), vipWebActivity.addUrlParams("/commercial/consumptions"));
    }

    /* access modifiers changed from: private */
    public final void initWebView() {
        yj yjVar = new yj(this, new VipWebActivity$initWebView$client$1(this), getActionManager());
        TeraScanWebView webView = getFragment().getWebView();
        if (webView != null) {
            webView.setWebViewClient(yjVar);
        }
        PackageManager packageManager = getContext().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
        PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
        TeraScanWebView webView2 = getFragment().getWebView();
        String str = null;
        WebSettings settings = webView2 != null ? webView2.getSettings() : null;
        if (settings != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[1];
            if (packageInfo != null) {
                str = packageInfo.versionName;
            }
            if (str == null) {
                str = "1.0.0";
            }
            objArr[0] = str;
            String format = String.format("aiscan;%s;", Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            settings.setUserAgentString(format);
        }
        getUrlLoader().qw(getFragment(), addUrlParams(getParamUrl()));
    }

    private final boolean interceptBackPress() {
        if (!this.enableJSMethods.contains("interceptBackFunc")) {
            return false;
        }
        evaluateJavascript("window.interceptBackFunc()", new de(this), new rg(this));
        return true;
    }

    /* renamed from: interceptBackPress$lambda-7  reason: not valid java name */
    public static final void m941interceptBackPress$lambda7(VipWebActivity vipWebActivity, String str) {
        Intrinsics.checkNotNullParameter(vipWebActivity, "this$0");
        if (TextUtils.equals(str, "false") || TextUtils.equals(str, StringUtil.NULL_STRING)) {
            vipWebActivity.backPress();
        }
    }

    /* renamed from: interceptBackPress$lambda-8  reason: not valid java name */
    public static final void m942interceptBackPress$lambda8(VipWebActivity vipWebActivity, Throwable th2) {
        Intrinsics.checkNotNullParameter(vipWebActivity, "this$0");
        vipWebActivity.backPress();
        th2.printStackTrace();
    }

    /* renamed from: onBackPressed$lambda-6  reason: not valid java name */
    public static final void m943onBackPressed$lambda6(VipWebActivity vipWebActivity) {
        Intrinsics.checkNotNullParameter(vipWebActivity, "this$0");
        vipWebActivity.isBackPress = false;
    }

    /* access modifiers changed from: private */
    public final void onTitleChanged(String str, String str2) {
        if (!StringsKt__StringsJVMKt.startsWith(str2, "http", true)) {
            ((TextView) _$_findCachedViewById(R.id.middle_title_text)).setText(str2);
        } else {
            ((TextView) _$_findCachedViewById(R.id.middle_title_text)).setText("");
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

    @NotNull
    public FragmentActivity getActivity() {
        return this;
    }

    public int getLayoutId() {
        return R.layout.vip_activity_web;
    }

    @NotNull
    public ViewModelStoreOwner getViewModelStoreOwner() {
        return this;
    }

    @NotNull
    public WebView getWebView() {
        TeraScanWebView webView = getFragment().getWebView();
        Intrinsics.checkNotNullExpressionValue(webView, "fragment.webView");
        return webView;
    }

    public void initView() {
        Intent intent = getIntent();
        intent.putExtra(FEED_BACK_FROM_TYPE, FEED_BACK_PAGE_FROM_VIP_CENTER + getFrom());
        initTitle();
        initFragment();
        boolean z = true;
        ((LottieAnimationView) _$_findCachedViewById(R.id.image_loading)).setSafeMode(true);
        String fromScene = getFromScene();
        if (!(fromScene == null || fromScene.length() == 0)) {
            z = false;
        }
        if (!z) {
            fe.mmm.qw.ggg.qw qwVar = fe.mmm.qw.ggg.qw.qw;
            String fromScene2 = getFromScene();
            if (fromScene2 == null) {
                fromScene2 = "";
            }
            qwVar.qw("scan_cashier_desk_show", CollectionsKt__CollectionsJVMKt.listOf(fromScene2));
        }
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_cashier_desk_return_click", (List) null, 2, (Object) null);
        if (!this.isBackPress) {
            this.isBackPress = true;
            fe.mmm.qw.th.qw.th.p031switch.fe.qw().postDelayed(new fe.mmm.qw.k.pf.qw(this), 300);
            if (!interceptBackPress()) {
                backPress();
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void setEnableJSMethods(@Nullable List<String> list) {
        this.enableJSMethods.clear();
        List<String> list2 = this.enableJSMethods;
        if (list != null) {
            list2.addAll(list);
        }
    }
}
