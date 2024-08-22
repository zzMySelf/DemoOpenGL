package com.tera.scan.vip.ui.dialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.aiscan.R;
import com.baidu.netdisk.trade.pay.order.IPayResult;
import com.baidu.wallet.api.Constants;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.framework.ui.view.IBaseView;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import com.tera.scan.webview.BaseWebViewFragment;
import com.tera.scan.webview.ContainerWebViewActivity;
import com.tera.scan.webview.hybrid.action.IActionManager;
import com.tera.scan.webview.hybrid.factory.IHybridSupport;
import fe.mmm.qw.k.ad;
import fe.mmm.qw.l.fe.qw.de;
import fe.mmm.qw.m.Cif;
import fe.mmm.qw.m.o;
import fe.mmm.qw.m.uk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\u0006\u0010\u000f\u001a\u00020\u0005J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0014J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0007H\u0014J\u001c\u0010#\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010$\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017H\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tera/scan/vip/ui/dialog/AdvancedWebActivity;", "Lcom/tera/scan/webview/ContainerWebViewActivity;", "Lcom/baidu/netdisk/trade/pay/order/IPayResult;", "()V", "pageHeight", "", "actionResult", "", "result", "Lcom/baidu/netdisk/trade/pay/finishpay/PayResult;", "finish", "finishToOtherPage", "getActionManager", "Lcom/tera/scan/webview/hybrid/action/IActionManager;", "getLayoutId", "getPageHeight", "getResultReceiver", "Landroid/os/ResultReceiver;", "initFragment", "initView", "isOpenAdvPage", "", "url", "", "makeMsgRead", "intent", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "needSetPortrait", "needSetStatusBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onTitleChange", "title", "openResultPage", "orderId", "setPageHeight", "layout", "Landroid/view/View;", "height", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("AdvancedWebActivity")
public final class AdvancedWebActivity extends ContainerWebViewActivity implements IPayResult {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public int pageHeight = fe.mmm.qw.p030switch.th.de.ad.qw.de(495);

    public static final class qw implements IHybridSupport {
        public final /* synthetic */ AdvancedWebActivity qw;

        public qw(AdvancedWebActivity advancedWebActivity) {
            this.qw = advancedWebActivity;
        }

        @NotNull
        public IBaseView qw() {
            return this.qw;
        }
    }

    private final ResultReceiver getResultReceiver() {
        Intent intent = getIntent();
        if (intent != null) {
            return (ResultReceiver) intent.getParcelableExtra("result_receiver_key");
        }
        return null;
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m945initView$lambda0(AdvancedWebActivity advancedWebActivity, View view) {
        Intrinsics.checkNotNullParameter(advancedWebActivity, "this$0");
        ad.qw();
        advancedWebActivity.finish();
    }

    private final boolean isOpenAdvPage(String str) {
        Either either;
        try {
            either = ExpectKt.success(Uri.parse(str).getQueryParameter("halfCashier"));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        String str2 = (String) ExpectKt.successOrNull(either);
        LoggerKt.d$default("advPage:" + str2, (Object) null, 1, (Object) null);
        return Intrinsics.areEqual((Object) str2, (Object) "1");
    }

    private final void setPageHeight(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
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

    public void actionResult(@NotNull fe.fe.when.qw.qw.yj.ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "result");
        int i2 = 1;
        LoggerKt.d$default("actionResult", (Object) null, 1, (Object) null);
        ResultReceiver resultReceiver = getResultReceiver();
        if (resultReceiver != null) {
            if (!adVar.fe()) {
                if (!adVar.ad() && adVar.qw()) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
            }
            resultReceiver.send(i2, Bundle.EMPTY);
        }
    }

    public void finish() {
        super.finish();
    }

    public void finishToOtherPage() {
        finish();
    }

    @NotNull
    public IActionManager getActionManager() {
        fe.mmm.qw.m.ggg.de.qw qwVar = new fe.mmm.qw.m.ggg.de.qw(new qw(this), false, 2, (DefaultConstructorMarker) null);
        qwVar.rg("WPJS_page_close", new fe.mmm.qw.l.fe.qw.ad(this));
        qwVar.rg("WPJS_page_forward", new de(this));
        return qwVar;
    }

    public int getLayoutId() {
        return R.layout.advanced_web_activity;
    }

    public final int getPageHeight() {
        Integer num;
        int i2;
        int de2 = fe.mmm.qw.p030switch.th.de.ad.qw.de(495);
        String stringExtra = getIntent().getStringExtra(BaseWebViewFragment.EXTRA_URL);
        try {
            Result.Companion companion = Result.Companion;
            String queryParameter = Uri.parse(stringExtra).getQueryParameter(Constants.HALF_LIGHTBRIDGE_HEIGHT);
            if (queryParameter != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter, "getQueryParameter(VIEW_HEIGHT)");
                i2 = Integer.parseInt(queryParameter);
            } else {
                i2 = de2;
            }
            num = Result.m1155constructorimpl(Integer.valueOf(i2));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Integer valueOf = Integer.valueOf(de2);
        if (Result.m1161isFailureimpl(num)) {
            num = valueOf;
        }
        int intValue = ((Number) num).intValue();
        return intValue > 0 ? intValue : de2;
    }

    public void initFragment() {
        BaseWebViewFragment baseWebViewFragment;
        Cif ifVar = new Cif();
        ifVar.m982if(new fe.mmm.qw.l.ad(this, this, getActionManager()));
        ifVar.pf(new fe.mmm.qw.l.qw());
        ifVar.o(new o(new uk(getApplicationContext())));
        BaseWebViewFragment qw2 = ifVar.qw();
        if (qw2 != null) {
            Bundle bundle = new Bundle();
            bundle.putString(BaseWebViewFragment.EXTRA_URL, getIntent().getStringExtra(BaseWebViewFragment.EXTRA_URL));
            qw2.setArguments(bundle);
            baseWebViewFragment = qw2;
        } else {
            baseWebViewFragment = null;
        }
        this.mFragment = baseWebViewFragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.web_content, qw2).commitAllowingStateLoss();
    }

    public void initView() {
        super.initView();
        ((ImageView) _$_findCachedViewById(R.id.image_exit)).setOnClickListener(new fe.mmm.qw.k.pf.uk.qw(this));
    }

    public void makeMsgRead(@Nullable Intent intent, @Nullable Uri uri) {
    }

    public boolean needSetPortrait() {
        return true;
    }

    public boolean needSetStatusBar() {
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        this.pageHeight = getPageHeight();
        UIFrameLayout uIFrameLayout = (UIFrameLayout) _$_findCachedViewById(R.id.web_content);
        Intrinsics.checkNotNullExpressionValue(uIFrameLayout, "web_content");
        setPageHeight(uIFrameLayout, this.pageHeight);
    }

    public void onResume() {
        super.onResume();
        getWindow().addFlags(134217728);
    }

    public void onTitleChange(@Nullable String str, @Nullable String str2) {
    }

    public void openResultPage(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "orderId");
        LoggerKt.d$default("openResultPage:" + str, (Object) null, 1, (Object) null);
        fe.mmm.qw.k.pf.uk.ad.de(this, fe.mmm.qw.k.th.qw.qw(str, str2), (ResultReceiver) null, 4, (Object) null);
        finish();
    }
}
