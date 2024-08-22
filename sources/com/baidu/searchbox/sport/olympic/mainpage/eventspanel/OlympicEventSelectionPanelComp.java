package com.baidu.searchbox.sport.olympic.mainpage.eventspanel;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.floating.BdFloatingContainer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nacomp.extension.base.BaseExtRVComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.recycler.delegate.DelegatorAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.olympic.mainpage.eventspanel.item.EventSelectionItemAdapter;
import com.baidu.searchbox.sport.olympic.mainpage.eventspanel.item.EventSelectionTitleAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0014J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0014J\u0006\u0010&\u001a\u00020\u0018J\b\u0010'\u001a\u00020\u0018H\u0002R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/mainpage/eventspanel/OlympicEventSelectionPanelComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtRVComponent;", "Lcom/baidu/searchbox/sport/olympic/mainpage/eventspanel/OlympicEventSelectionPanelViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "anchor", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getAnchor", "()Landroid/view/View;", "pop", "Lcom/baidu/android/ext/widget/floating/BdFloatingContainer;", "getPop", "()Lcom/baidu/android/ext/widget/floating/BdFloatingContainer;", "pop$delegate", "Lkotlin/Lazy;", "popDelegate", "Lkotlin/Lazy;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "dismiss", "", "onCreateLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onCreateView", "onCreateViewModel", "onFindRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rootView", "onNightModeChange", "isNightMode", "", "onRegisterDelegates", "delegator", "Lcom/baidu/searchbox/nacomp/recycler/delegate/DelegatorAdapter;", "show", "updateUI", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicEventSelectionPanelComp.kt */
public final class OlympicEventSelectionPanelComp extends BaseExtRVComponent<OlympicEventSelectionPanelViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final View anchor;
    private final Lazy pop$delegate;
    private final Lazy<BdFloatingContainer> popDelegate;
    private final UniqueId token;

    public final View getAnchor() {
        return this.anchor;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OlympicEventSelectionPanelComp(LifecycleOwner owner, View view2, View anchor2, UniqueId token2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(anchor2, "anchor");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.anchor = anchor2;
        this.token = token2;
        Lazy<BdFloatingContainer> lazy = LazyKt.lazy(OlympicEventSelectionPanelComp$popDelegate$1.INSTANCE);
        this.popDelegate = lazy;
        this.pop$delegate = lazy;
    }

    private final BdFloatingContainer getPop() {
        return (BdFloatingContainer) this.pop$delegate.getValue();
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onCreateView(view2);
        ((ImageView) view2.findViewById(R.id.imgPanelClose)).setOnClickListener(new OlympicEventSelectionPanelComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m3413onCreateView$lambda0(OlympicEventSelectionPanelComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public OlympicEventSelectionPanelViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(OlympicEventSelectionPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(OlympicEven…nelViewModel::class.java)");
        ((OlympicEventSelectionPanelViewModel) viewModel).setToken(this.token);
        return (OlympicEventSelectionPanelViewModel) viewModel;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        GridLayoutManager $this$onCreateLayoutManager_u24lambda_u2d2 = new GridLayoutManager(getContext(), 4, 1, false);
        $this$onCreateLayoutManager_u24lambda_u2d2.setSpanSizeLookup(new OlympicEventSelectionPanelComp$onCreateLayoutManager$1$1(this));
        return $this$onCreateLayoutManager_u24lambda_u2d2;
    }

    /* access modifiers changed from: protected */
    public RecyclerView onFindRecyclerView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.eventSelectionRcy);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "view.eventSelectionRcy");
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public void onRegisterDelegates(DelegatorAdapter delegator) {
        Intrinsics.checkNotNullParameter(delegator, "delegator");
        super.onRegisterDelegates(delegator);
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        delegator.put(new EventSelectionItemAdapter(lifecycleOwner));
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "lifecycleOwner");
        delegator.put(new EventSelectionTitleAdapter(lifecycleOwner2));
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        updateUI();
    }

    private final void updateUI() {
        ResWrapper.setBackground((ConstraintLayout) getView().findViewById(R.id.panelContainer), R.drawable.olymp_sports_panel_bg);
        ResWrapper.setTextColor((TextView) getView().findViewById(R.id.tvPanelTitle), R.color.GC1);
        ResWrapper.setImageDrawable((ImageView) getView().findViewById(R.id.imgPanelClose), R.drawable.olympic_sports_panel_close);
    }

    public final void show() {
        updateUI();
        getPop().setPhraseTop(((OlympicEventSelectionPanelViewModel) getViewModel()).calculateHeight());
        getPop().setShowMask(true);
        getPop().getTitleContainer().setVisibility(8);
        getPop().addContentView(getView());
        View baseLine = getPop().getBaseLine();
        if (baseLine != null) {
            baseLine.setVisibility(4);
        }
        ResWrapper.setBackground(getPop().getContentContainer(), R.drawable.olymp_sports_panel_bg);
        getPop().setTouchInterceptor(new OlympicEventSelectionPanelComp$$ExternalSyntheticLambda0());
        getPop().show(this.anchor);
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-3  reason: not valid java name */
    public static final boolean m3414show$lambda3(MotionEvent it) {
        return false;
    }

    public final void dismiss() {
        if (this.popDelegate.isInitialized()) {
            getPop().dismiss();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/mainpage/eventspanel/OlympicEventSelectionPanelComp$Companion;", "", "()V", "create", "Lcom/baidu/searchbox/sport/olympic/mainpage/eventspanel/OlympicEventSelectionPanelComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "anchor", "Landroid/view/View;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OlympicEventSelectionPanelComp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OlympicEventSelectionPanelComp create(LifecycleOwner owner, UniqueId token, View anchor) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.olymp_event_selection_panel, (ViewGroup) null, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(AppRuntime.getAppCo…ction_panel, null, false)");
            return new OlympicEventSelectionPanelComp(owner, inflate, anchor, token);
        }
    }
}
