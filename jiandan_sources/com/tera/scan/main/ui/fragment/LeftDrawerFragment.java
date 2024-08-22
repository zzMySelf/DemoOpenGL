package com.tera.scan.main.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.aiscan.R;
import com.baidu.netdisk.trade.privilege.MemberProduct;
import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import com.tera.scan.main.ui.AboutActivity;
import com.tera.scan.main.ui.view.LeftDrawerItemView;
import com.tera.scan.main.view.UserCenterCardScene;
import com.tera.scan.ui.view.widget.UIImageView;
import fe.mmm.qw.j.when;
import fe.mmm.qw.k.fe.ad;
import fe.mmm.qw.xxx.p032if.de.de;
import fe.mmm.qw.xxx.p032if.de.i;
import fe.mmm.qw.xxx.p032if.de.o;
import fe.mmm.qw.xxx.p032if.de.pf;
import fe.mmm.qw.xxx.p032if.de.rg;
import fe.mmm.qw.xxx.p032if.de.uk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/main/ui/fragment/LeftDrawerFragment;", "Lcom/tera/scan/framework/kernel/architecture/ui/BaseFragment;", "()V", "loginCallback", "Lcom/tera/scan/account/OnLoginCallBack;", "ensureLogin", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "initScanVipContent", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "showUserCenterCard", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("LeftDrawerFragment")
public final class LeftDrawerFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public OnLoginCallBack loginCallback;

    public static final class qw implements OnLoginCallBack {
        public final /* synthetic */ LeftDrawerFragment qw;

        public qw(LeftDrawerFragment leftDrawerFragment) {
            this.qw = leftDrawerFragment;
        }

        public void ad() {
        }

        public void qw() {
            TradeAccount.f913rg.m34if();
            FrameLayout frameLayout = (FrameLayout) this.qw._$_findCachedViewById(R.id.svip_contaner);
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = (FrameLayout) this.qw._$_findCachedViewById(R.id.svip_contaner);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
    }

    private final void ensureLogin(Function1<? super Boolean, Unit> function1) {
        if (fe.mmm.qw.qw.qw.qw.pf()) {
            function1.invoke(Boolean.TRUE);
            return;
        }
        fe.mmm.qw.qw.qw.xxx(fe.mmm.qw.qw.qw.qw, this, (String) null, false, new LeftDrawerFragment$ensureLogin$1(function1), 6, (Object) null);
    }

    private final void initScanVipContent() {
        Resources resources;
        Resources resources2;
        if (fe.mmm.qw.p030switch.rg.qw.qw().isLogin()) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_subtitle);
            Intrinsics.checkNotNullExpressionValue(textView, "tv_subtitle");
            textView.setVisibility(0);
            CharSequence charSequence = null;
            if (ad.qw.qw()) {
                ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_svip);
                Intrinsics.checkNotNullExpressionValue(imageView, "iv_svip");
                imageView.setVisibility(0);
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_subtitle);
                if (textView2 != null) {
                    FragmentActivity activity = getActivity();
                    if (!(activity == null || (resources2 = activity.getResources()) == null)) {
                        charSequence = resources2.getString(R.string.left_drawer_scan_vip_title, new Object[]{when.ad(TradeAccount.f913rg.th(MemberProduct.SCAN_VIP.getCluster()), "yyyy-MM-dd")});
                    }
                    textView2.setText(charSequence);
                    return;
                }
                return;
            }
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.iv_svip);
            Intrinsics.checkNotNullExpressionValue(imageView2, "iv_svip");
            imageView2.setVisibility(8);
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_subtitle);
            if (textView3 != null) {
                FragmentActivity activity2 = getActivity();
                if (!(activity2 == null || (resources = activity2.getResources()) == null)) {
                    charSequence = resources.getText(R.string.left_drawer_scan_title);
                }
                textView3.setText(charSequence);
            }
        }
    }

    private final void initView() {
        fe.mmm.qw.qw.qw.qw.ad().observe(getViewLifecycleOwner(), new i(this));
        qw qwVar = new qw(this);
        this.loginCallback = qwVar;
        if (qwVar != null) {
            fe.mmm.qw.qw.qw.qw.de(qwVar);
        }
        ((LeftDrawerItemView) _$_findCachedViewById(R.id.item_setting)).setOnClickListener(new uk(this));
        ((LeftDrawerItemView) _$_findCachedViewById(R.id.item_help)).setOnClickListener(new de(this));
        ((LeftDrawerItemView) _$_findCachedViewById(R.id.item_about)).setOnClickListener(new rg(this));
        ((UIImageView) _$_findCachedViewById(R.id.iv_header)).setOnClickListener(new fe.mmm.qw.xxx.p032if.de.qw(this));
        ((ConstraintLayout) _$_findCachedViewById(R.id.user_info_container)).setOnClickListener(new pf(this));
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m822initView$lambda1(LeftDrawerFragment leftDrawerFragment, fe.mmm.qw.qw.rg.qw qwVar) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        if (qwVar == null) {
            ((UIImageView) leftDrawerFragment._$_findCachedViewById(R.id.iv_header)).setImageDrawable(fe.mmm.qw.d.de.de.when().m965switch(R.drawable.ic_user_header_default));
            ((TextView) leftDrawerFragment._$_findCachedViewById(R.id.tv_name)).setText(leftDrawerFragment.getResources().getString(R.string.left_drawer_name_default));
            ImageView imageView = (ImageView) leftDrawerFragment._$_findCachedViewById(R.id.iv_svip);
            Intrinsics.checkNotNullExpressionValue(imageView, "iv_svip");
            imageView.setVisibility(8);
            TextView textView = (TextView) leftDrawerFragment._$_findCachedViewById(R.id.tv_subtitle);
            Intrinsics.checkNotNullExpressionValue(textView, "tv_subtitle");
            textView.setVisibility(8);
            return;
        }
        Context context = leftDrawerFragment.getContext();
        if (context != null) {
            fe.rg.qw.when.ad B = new fe.rg.qw.when.ad().w(R.drawable.ic_user_header_default).o(R.drawable.ic_user_header_default).pf(R.drawable.ic_user_header_default).B(new fe.rg.qw.ppp.de(Long.valueOf(System.currentTimeMillis())));
            Intrinsics.checkNotNullExpressionValue(B, "RequestOptions()\n       …tem.currentTimeMillis()))");
            fe.rg.qw.rg<Bitmap> i2 = fe.rg.qw.ad.mmm(context).i();
            i2.nn(qwVar.fe());
            i2.de(B);
            i2.m317switch((UIImageView) leftDrawerFragment._$_findCachedViewById(R.id.iv_header));
        }
        ((TextView) leftDrawerFragment._$_findCachedViewById(R.id.tv_name)).setText(qwVar.de());
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m823initView$lambda3(LeftDrawerFragment leftDrawerFragment, View view) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        fe.mmm.qw.xxx.pf.de.ad("PCntrSet_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
        leftDrawerFragment.ensureLogin(new LeftDrawerFragment$initView$4$1(leftDrawerFragment));
    }

    /* renamed from: initView$lambda-4  reason: not valid java name */
    public static final void m824initView$lambda4(LeftDrawerFragment leftDrawerFragment, View view) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        fe.mmm.qw.xxx.pf.de.ad("PCntrHp_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
        leftDrawerFragment.ensureLogin(new LeftDrawerFragment$initView$5$1(leftDrawerFragment));
    }

    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m825initView$lambda5(LeftDrawerFragment leftDrawerFragment, View view) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        leftDrawerFragment.startActivity(new Intent(leftDrawerFragment.getActivity(), AboutActivity.class));
    }

    /* renamed from: initView$lambda-6  reason: not valid java name */
    public static final void m826initView$lambda6(LeftDrawerFragment leftDrawerFragment, View view) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        if (!fe.mmm.qw.qw.qw.qw.pf()) {
            fe.mmm.qw.qw.qw.xxx(fe.mmm.qw.qw.qw.qw, leftDrawerFragment, (String) null, false, (Function1) null, 14, (Object) null);
            fe.mmm.qw.xxx.pf.de.ad("PCntrLg_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
        }
    }

    /* renamed from: initView$lambda-7  reason: not valid java name */
    public static final void m827initView$lambda7(LeftDrawerFragment leftDrawerFragment, View view) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        if (!fe.mmm.qw.qw.qw.qw.pf()) {
            fe.mmm.qw.qw.qw.xxx(fe.mmm.qw.qw.qw.qw, leftDrawerFragment, (String) null, false, (Function1) null, 14, (Object) null);
            fe.mmm.qw.xxx.pf.de.ad("PCntrLg_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
        }
    }

    /* renamed from: onResume$lambda-8  reason: not valid java name */
    public static final void m828onResume$lambda8(LeftDrawerFragment leftDrawerFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(leftDrawerFragment, "this$0");
        leftDrawerFragment.showUserCenterCard();
        leftDrawerFragment.initScanVipContent();
    }

    private final void showUserCenterCard() {
        FragmentActivity activity;
        if (fe.mmm.qw.p030switch.rg.qw.qw().isLogin() && (activity = getActivity()) != null) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.svip_contaner);
            Intrinsics.checkNotNullExpressionValue(frameLayout, "svip_contaner");
            new UserCenterCardScene(activity, frameLayout).i();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_left_drawer, viewGroup, false);
        this.mLayoutView = inflate;
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        OnLoginCallBack onLoginCallBack = this.loginCallback;
        if (onLoginCallBack != null) {
            fe.mmm.qw.qw.qw.qw.ggg(onLoginCallBack);
        }
        this.loginCallback = null;
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        if (fe.mmm.qw.p030switch.rg.qw.qw().isLogin()) {
            TradeAccount.f913rg.uk(new o(this));
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        LoggerKt.d$default("onViewCreated", (Object) null, 1, (Object) null);
    }
}
