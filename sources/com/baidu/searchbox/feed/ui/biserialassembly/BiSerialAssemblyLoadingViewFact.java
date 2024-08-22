package com.baidu.searchbox.feed.ui.biserialassembly;

import android.content.Context;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.baidu.searchbox.feed.flow.ui.LoadingViewAbility;
import com.baidu.searchbox.feed.tab.interaction.IFeedNightModeChangeable;
import com.baidu.searchbox.feed.ui.biserialassembly.view.BiSerialHeaderNestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingViewFact;", "Lcom/baidu/searchbox/feed/flow/ui/LoadingViewAbility;", "Lcom/baidu/searchbox/feed/tab/interaction/IFeedNightModeChangeable;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerView", "Landroid/view/View;", "getHeaderView", "()Landroid/view/View;", "setHeaderView", "(Landroid/view/View;)V", "loadingView", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingView;", "getLoadingView", "()Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingView;", "setLoadingView", "(Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingView;)V", "loadingViewContainer", "Landroidx/core/widget/NestedScrollView;", "getLoadingViewContainer", "()Landroidx/core/widget/NestedScrollView;", "setLoadingViewContainer", "(Landroidx/core/widget/NestedScrollView;)V", "nestedScrollView", "Lcom/baidu/searchbox/feed/ui/biserialassembly/view/BiSerialHeaderNestedScrollView;", "hideLoadingView", "", "onFeedNightModeChange", "isNightMode", "", "showLoadingView", "Companion", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialAssemblyLoadingViewFact.kt */
public final class BiSerialAssemblyLoadingViewFact implements LoadingViewAbility, IFeedNightModeChangeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Context context;
    private View headerView;
    private BiSerialAssemblyLoadingView loadingView;
    private NestedScrollView loadingViewContainer;
    /* access modifiers changed from: private */
    public BiSerialHeaderNestedScrollView nestedScrollView;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingViewFact$Companion;", "", "()V", "create", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingViewFact;", "context", "Landroid/content/Context;", "loadingContainer", "Landroidx/core/widget/NestedScrollView;", "loadingView", "Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblyLoadingView;", "headerView", "Landroid/view/View;", "nestedScrollView", "Lcom/baidu/searchbox/feed/ui/biserialassembly/view/BiSerialHeaderNestedScrollView;", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialAssemblyLoadingViewFact.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ BiSerialAssemblyLoadingViewFact create$default(Companion companion, Context context, NestedScrollView nestedScrollView, BiSerialAssemblyLoadingView biSerialAssemblyLoadingView, View view2, BiSerialHeaderNestedScrollView biSerialHeaderNestedScrollView, int i2, Object obj) {
            View view3;
            if ((i2 & 8) != 0) {
                view3 = null;
            } else {
                view3 = view2;
            }
            return companion.create(context, nestedScrollView, biSerialAssemblyLoadingView, view3, biSerialHeaderNestedScrollView);
        }

        public final BiSerialAssemblyLoadingViewFact create(Context context, NestedScrollView loadingContainer, BiSerialAssemblyLoadingView loadingView, View headerView, BiSerialHeaderNestedScrollView nestedScrollView) {
            Intrinsics.checkNotNullParameter(context, "context");
            BiSerialAssemblyLoadingViewFact facet = new BiSerialAssemblyLoadingViewFact();
            facet.setContext(context);
            facet.setLoadingViewContainer(loadingContainer);
            facet.setLoadingView(loadingView);
            facet.setHeaderView(headerView);
            facet.nestedScrollView = nestedScrollView;
            return facet;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final NestedScrollView getLoadingViewContainer() {
        return this.loadingViewContainer;
    }

    public final void setLoadingViewContainer(NestedScrollView nestedScrollView2) {
        this.loadingViewContainer = nestedScrollView2;
    }

    public final BiSerialAssemblyLoadingView getLoadingView() {
        return this.loadingView;
    }

    public final void setLoadingView(BiSerialAssemblyLoadingView biSerialAssemblyLoadingView) {
        this.loadingView = biSerialAssemblyLoadingView;
    }

    public final View getHeaderView() {
        return this.headerView;
    }

    public final void setHeaderView(View view2) {
        this.headerView = view2;
    }

    public void showLoadingView() {
        NestedScrollView nestedScrollView2 = this.loadingViewContainer;
        if (nestedScrollView2 != null) {
            nestedScrollView2.setVisibility(0);
        }
        BiSerialAssemblyLoadingView biSerialAssemblyLoadingView = this.loadingView;
        if (biSerialAssemblyLoadingView != null) {
            biSerialAssemblyLoadingView.setVisibility(0);
        }
        View view2 = this.headerView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        NestedScrollView nestedScrollView2 = this.loadingViewContainer;
        if (nestedScrollView2 != null) {
            nestedScrollView2.setVisibility(8);
        }
        BiSerialAssemblyLoadingView biSerialAssemblyLoadingView = this.loadingView;
        if (biSerialAssemblyLoadingView != null) {
            biSerialAssemblyLoadingView.setVisibility(8);
        }
        View view2 = this.headerView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        BiSerialHeaderNestedScrollView biSerialHeaderNestedScrollView = this.nestedScrollView;
        if (biSerialHeaderNestedScrollView != null) {
            biSerialHeaderNestedScrollView.calculateHeaderView();
        }
    }

    public void onFeedNightModeChange(boolean isNightMode) {
        BiSerialAssemblyLoadingView biSerialAssemblyLoadingView = this.loadingView;
        if (biSerialAssemblyLoadingView != null) {
            biSerialAssemblyLoadingView.updateUi();
        }
    }
}
