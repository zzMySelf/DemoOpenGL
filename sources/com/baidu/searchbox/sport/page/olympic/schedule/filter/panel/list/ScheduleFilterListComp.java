package com.baidu.searchbox.sport.page.olympic.schedule.filter.panel.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.nacomp.extension.base.BaseExtRVComponent;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.RecyclerViewHelper;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.recycler.delegate.DelegatorAdapter;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.page.olympic.schedule.filter.panel.list.item.ScheduleFilterItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u001f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/list/ScheduleFilterListComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtRVComponent;", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/list/ScheduleFilterListVM;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "compKey", "", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Ljava/lang/String;)V", "divider", "kotlin.jvm.PlatformType", "bindAnchorFilter", "", "viewModel", "bindBackgroundColor", "bindShowDivider", "onBindViewModel", "onCreate", "onCreateLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onCreateViewModel", "onFindRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rootView", "onNightModeChange", "isNightMode", "", "onRegisterDelegates", "delegator", "Lcom/baidu/searchbox/nacomp/recycler/delegate/DelegatorAdapter;", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScheduleFilterListComp.kt */
public final class ScheduleFilterListComp extends BaseExtRVComponent<ScheduleFilterListVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String compKey;
    private final View divider;

    public /* synthetic */ ScheduleFilterListComp(LifecycleOwner lifecycleOwner, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, view2, str);
    }

    private ScheduleFilterListComp(LifecycleOwner owner, View view2, String compKey2) {
        super(owner, view2, true);
        this.compKey = compKey2;
        this.divider = view2.findViewById(R.id.filterDivider);
    }

    public void onCreate() {
        super.onCreate();
        onNightModeChange(NightModeHelper.isNightMode());
    }

    public ScheduleFilterListVM onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(this.compKey, ScheduleFilterListVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(compKey, Sc…FilterListVM::class.java)");
        return (ScheduleFilterListVM) viewModel;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    /* access modifiers changed from: protected */
    public RecyclerView onFindRecyclerView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        RecyclerView $this$onFindRecyclerView_u24lambda_u2d0 = (RecyclerView) getView().findViewById(R.id.rvScheduleFilter);
        $this$onFindRecyclerView_u24lambda_u2d0.setItemAnimator((RecyclerView.ItemAnimator) null);
        Intrinsics.checkNotNullExpressionValue($this$onFindRecyclerView_u24lambda_u2d0, "view.rvScheduleFilter.ap…Animator = null\n        }");
        return $this$onFindRecyclerView_u24lambda_u2d0;
    }

    /* access modifiers changed from: protected */
    public void onRegisterDelegates(DelegatorAdapter delegator) {
        Intrinsics.checkNotNullParameter(delegator, "delegator");
        super.onRegisterDelegates(delegator);
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        delegator.put(new ScheduleFilterItemAdapter(lifecycleOwner));
    }

    public void onBindViewModel(ScheduleFilterListVM viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindBackgroundColor(viewModel, owner);
        bindShowDivider(viewModel, owner);
        bindAnchorFilter(viewModel, owner);
    }

    private final void bindBackgroundColor(ScheduleFilterListVM viewModel, LifecycleOwner owner) {
        viewModel.getBackgroundColorRes().observe(owner, new ScheduleFilterListComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindBackgroundColor$lambda-2  reason: not valid java name */
    public static final void m3992bindBackgroundColor$lambda2(ScheduleFilterListComp this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            int $this$bindBackgroundColor_u24lambda_u2d2_u24lambda_u2d1 = it.intValue();
            View view2 = this$0.getView();
            if ($this$bindBackgroundColor_u24lambda_u2d2_u24lambda_u2d1 != 0) {
                ResWrapper.setBackgroundColor(view2, it.intValue());
            } else {
                view2.setBackground((Drawable) null);
            }
        }
    }

    private final void bindShowDivider(ScheduleFilterListVM viewModel, LifecycleOwner owner) {
        viewModel.getShowDivider().observe(owner, new ScheduleFilterListComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindShowDivider$lambda-3  reason: not valid java name */
    public static final void m3993bindShowDivider$lambda3(ScheduleFilterListComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.divider.setVisibility(Intrinsics.areEqual((Object) it, (Object) true) ? 0 : 8);
    }

    private final void bindAnchorFilter(ScheduleFilterListVM viewModel, LifecycleOwner owner) {
        viewModel.getAnchorFilter().observe(owner, new ScheduleFilterListComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindAnchorFilter$lambda-5  reason: not valid java name */
    public static final void m3991bindAnchorFilter$lambda5(ScheduleFilterListComp this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            RecyclerViewHelper.scrollToPosition(this$0.getRecyclerView(), it.intValue());
        }
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        ResWrapper.setBackgroundColor(this.divider, R.color.GC37);
        ((ScheduleFilterListVM) getViewModel()).updateBackground();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/list/ScheduleFilterListComp$Companion;", "", "()V", "create", "Lcom/baidu/searchbox/sport/page/olympic/schedule/filter/panel/list/ScheduleFilterListComp;", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "compKey", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ScheduleFilterListComp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScheduleFilterListComp create(Context context, LifecycleOwner owner, String compKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(compKey, "compKey");
            View inflate = LayoutInflater.from(context).inflate(R.layout.olymp_sch_filter_layout, (ViewGroup) null, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…lter_layout, null, false)");
            return new ScheduleFilterListComp(owner, inflate, compKey, (DefaultConstructorMarker) null);
        }
    }
}
