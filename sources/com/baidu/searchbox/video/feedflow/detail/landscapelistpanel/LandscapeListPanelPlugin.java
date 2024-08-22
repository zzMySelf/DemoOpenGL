package com.baidu.searchbox.video.feedflow.detail.landscapelistpanel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.video.component.autoplay.AutoPlayInterceptPriority;
import com.baidu.searchbox.video.component.autoplay.OnAutoPlayInterceptCallback;
import com.baidu.searchbox.video.component.autoplay.service.IAutoPlayInterceptorService;
import com.baidu.searchbox.video.feedflow.common.LazyInitAssistByDegradeAb;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.inf.ListPanelModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078DX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "Lcom/baidu/searchbox/video/component/autoplay/OnAutoPlayInterceptCallback;", "()V", "isItemClick", "", "listPanelPopup", "Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelPopup;", "getListPanelPopup", "()Lcom/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelPopup;", "listPanelPopup$delegate", "Lkotlin/Lazy;", "panelLazyAssist", "Lcom/baidu/searchbox/video/feedflow/common/LazyInitAssistByDegradeAb;", "playerService", "Lcom/baidu/searchbox/video/feedflow/detail/player/service/IPlayerComponentService;", "getPlayerService", "()Lcom/baidu/searchbox/video/feedflow/detail/player/service/IPlayerComponentService;", "playerService$delegate", "routerRunnable", "Lkotlin/Function0;", "", "consumeIntercept", "fetchPriority", "Lcom/baidu/searchbox/video/component/autoplay/AutoPlayInterceptPriority;", "initPopupWindow", "needIntercept", "onAttachToManager", "onDestroy", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeListPanelPlugin.kt */
public final class LandscapeListPanelPlugin extends LiveDataPlugin implements OnAutoPlayInterceptCallback {
    /* access modifiers changed from: private */
    public boolean isItemClick;
    private final Lazy listPanelPopup$delegate = LazyKt.lazy(new LandscapeListPanelPlugin$listPanelPopup$2(this));
    private final LazyInitAssistByDegradeAb panelLazyAssist = new LazyInitAssistByDegradeAb();
    private final Lazy playerService$delegate = LazyKt.lazy(new LandscapeListPanelPlugin$playerService$2(this));
    /* access modifiers changed from: private */
    public Function0<Unit> routerRunnable = LandscapeListPanelPlugin$routerRunnable$1.INSTANCE;

    /* access modifiers changed from: protected */
    public final LandscapeListPanelPopup getListPanelPopup() {
        return (LandscapeListPanelPopup) this.listPanelPopup$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final IPlayerComponentService getPlayerService() {
        return (IPlayerComponentService) this.playerService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LandscapeListPanelPopup initPopupWindow() {
        this.panelLazyAssist.onInit();
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        LandscapeListPanelPopup landscapeListPanelPopup = new LandscapeListPanelPopup(activity);
        LandscapeListPanelPopup $this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0 = landscapeListPanelPopup;
        $this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0.registerHeaderCloseClickListener(new LandscapeListPanelPlugin$initPopupWindow$1$1$1($this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0));
        $this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0.registerDragCallbackListener(new LandscapeListPanelPlugin$initPopupWindow$1$1$2($this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0, this));
        $this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0.registerVisibilityListener(new LandscapeListPanelPlugin$initPopupWindow$1$1$3(this));
        $this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0.registerHeaderLeftClickListener(new LandscapeListPanelPlugin$initPopupWindow$1$1$4(this));
        $this$initPopupWindow_u24lambda_u2d1_u24lambda_u2d0.registerItemClickListener(new LandscapeListPanelPlugin$initPopupWindow$1$1$5(this));
        return landscapeListPanelPopup;
    }

    public void onDestroy() {
        super.onDestroy();
        this.panelLazyAssist.excIfHasInit(new LandscapeListPanelPlugin$onDestroy$1(this));
        DIFactory.INSTANCE.removeCallbacks(this.routerRunnable);
    }

    public void onAttachToManager() {
        LandscapeListPanelState $this$onAttachToManager_u24lambda_u2d5;
        super.onAttachToManager();
        IAutoPlayInterceptorService iAutoPlayInterceptorService = (IAutoPlayInterceptorService) getManager().getService(IAutoPlayInterceptorService.class);
        if (iAutoPlayInterceptorService != null) {
            iAutoPlayInterceptorService.addInterceptor(this);
        }
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d5 = (LandscapeListPanelState) $this$subscribe$iv.subscribe(LandscapeListPanelState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d5.getListPanelShowData().observe(this, new LandscapeListPanelPlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d5.getDismiss().observe(this, new LandscapeListPanelPlugin$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-3  reason: not valid java name */
    public static final void m11545onAttachToManager$lambda5$lambda3(LandscapeListPanelPlugin this$0, ListPanelModel listPanelShowData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LandscapeListPanelPopup listPanelPopup = this$0.getListPanelPopup();
        if (listPanelPopup != null) {
            listPanelPopup.setupData(listPanelShowData);
        }
        LandscapeListPanelPopup listPanelPopup2 = this$0.getListPanelPopup();
        boolean z = true;
        if (listPanelPopup2 == null || !listPanelPopup2.isShowing()) {
            z = false;
        }
        if (!z) {
            Context context = this$0.getContext();
            View view2 = null;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            ViewGroup viewGroup = activity != null ? (ViewGroup) activity.findViewById(16908290) : null;
            if (!(viewGroup instanceof ViewGroup)) {
                viewGroup = null;
            }
            if (viewGroup != null) {
                view2 = viewGroup.getChildAt(0);
            }
            View rootView = view2;
            if (rootView != null) {
                View view3 = rootView;
                LandscapeListPanelPopup listPanelPopup3 = this$0.getListPanelPopup();
                if (listPanelPopup3 != null) {
                    listPanelPopup3.show(rootView);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    public static final void m11546onAttachToManager$lambda5$lambda4(LandscapeListPanelPlugin this$0, Unit it) {
        LandscapeListPanelPopup listPanelPopup;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LandscapeListPanelPopup listPanelPopup2 = this$0.getListPanelPopup();
        boolean z = true;
        if (listPanelPopup2 == null || !listPanelPopup2.isShowing()) {
            z = false;
        }
        if (z && (listPanelPopup = this$0.getListPanelPopup()) != null) {
            listPanelPopup.dismiss();
        }
    }

    public AutoPlayInterceptPriority fetchPriority() {
        return AutoPlayInterceptPriority.Flow.LandscapeListPanel.INSTANCE;
    }

    public boolean needIntercept() {
        LandscapeListPanelPopup listPanelPopup = getListPanelPopup();
        return listPanelPopup != null && listPanelPopup.isShowing();
    }

    public boolean consumeIntercept() {
        return false;
    }
}
