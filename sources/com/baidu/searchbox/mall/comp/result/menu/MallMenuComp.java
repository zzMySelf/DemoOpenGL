package com.baidu.searchbox.mall.comp.result.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.ui.floatbar.BottomFloatToolBar;
import com.baidu.searchbox.ui.floatbar.IBottomFloatToolBarClickListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/mall/comp/result/menu/MallMenuComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "bottomFloatToolBar", "Lcom/baidu/searchbox/ui/floatbar/BottomFloatToolBar;", "menuPanel", "Lcom/baidu/searchbox/mall/comp/result/menu/MallMenuPanel;", "getMenuPanel", "()Lcom/baidu/searchbox/mall/comp/result/menu/MallMenuPanel;", "menuPanel$delegate", "Lkotlin/Lazy;", "doToolbarAnim", "", "alpha", "", "onBindViewModel", "viewModel", "onCreate", "onCreateViewModel", "onDestroy", "setToolbarVisibility", "visible", "", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MallMenuComp.kt */
public final class MallMenuComp extends BaseExtSlaveComponent<BaseViewModel> {
    /* access modifiers changed from: private */
    public final BottomFloatToolBar bottomFloatToolBar;
    private final Lazy menuPanel$delegate;
    /* access modifiers changed from: private */
    public final UniqueId token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MallMenuComp(LifecycleOwner owner, View view2, UniqueId token2) {
        super(owner, view2);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
        this.menuPanel$delegate = LazyKt.lazy(new MallMenuComp$menuPanel$2(this, view2));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BottomFloatToolBar bottomFloatToolBar2 = new BottomFloatToolBar(context);
        BottomFloatToolBar $this$bottomFloatToolBar_u24lambda_u2d0 = bottomFloatToolBar2;
        ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
        if (viewGroup != null) {
            viewGroup.addView($this$bottomFloatToolBar_u24lambda_u2d0, -1, -2);
        }
        this.bottomFloatToolBar = bottomFloatToolBar2;
    }

    /* access modifiers changed from: private */
    public final MallMenuPanel getMenuPanel() {
        return (MallMenuPanel) this.menuPanel$delegate.getValue();
    }

    public final void setToolbarVisibility(boolean visible) {
        if (!visible && this.bottomFloatToolBar.getVisibility() == 0) {
            doToolbarAnim(0.0f);
        } else if (visible && this.bottomFloatToolBar.getVisibility() != 0) {
            doToolbarAnim(1.0f);
        }
    }

    private final void doToolbarAnim(float alpha) {
        this.bottomFloatToolBar.animate().alpha(alpha).setDuration(160).setListener(new MallMenuComp$doToolbarAnim$1(alpha, this)).start();
    }

    public void onCreate() {
        super.onCreate();
        MenuStatUtilsKt.toolbarStatShow("return");
        MenuStatUtilsKt.toolbarStatShow("list");
        this.bottomFloatToolBar.setClickListener(new MallMenuComp$onCreate$1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.bottomFloatToolBar.setClickListener((IBottomFloatToolBarClickListener) null);
        this.bottomFloatToolBar.animate().cancel();
    }

    public BaseViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("SearchMallMenuComp", BaseViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"SearchMall…aseViewModel::class.java)");
        return (BaseViewModel) viewModel;
    }

    public void onBindViewModel(BaseViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
    }
}
