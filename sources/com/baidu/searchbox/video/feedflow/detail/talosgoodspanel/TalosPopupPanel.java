package com.baidu.searchbox.video.feedflow.detail.talosgoodspanel;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.C0297BdPopupWindow;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.common.PanelSizeConfig;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.listpanel.ListPopupPanelRootView;
import com.baidu.searchbox.video.inf.TalosPanelCallback;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00106\u001a\u00020(H\u0002J\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010;J\u0006\u0010<\u001a\u00020;J\b\u0010=\u001a\u000208H\u0002J\b\u0010>\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u000208H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u000208H\u0016J\b\u0010D\u001a\u000208H\u0016J\b\u0010E\u001a\u000208H\u0016J\u0018\u0010F\u001a\u0002082\u0006\u0010G\u001a\u0002022\u0006\u0010H\u001a\u000202H\u0016J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020\u0016H\u0016J\b\u0010K\u001a\u000208H\u0002J\u0006\u0010L\u001a\u000208J\u0016\u0010M\u001a\u0002082\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010OJ\u0010\u0010Q\u001a\u0002082\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010R\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010S\u001a\u00020\u0019J\b\u0010T\u001a\u000208H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0014R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u001d\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u0010\u001d\u001a\u0004\b3\u00104¨\u0006U"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/TalosPopupPanel;", "Lcom/baidu/android/ext/widget/BdPopupWindow;", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/ListPopupPanelRootView$DragCallback;", "Landroid/widget/PopupWindow$OnDismissListener;", "context", "Landroid/content/Context;", "isNeedMask", "", "(Landroid/content/Context;Z)V", "callback", "Lcom/baidu/searchbox/video/inf/TalosPanelCallback;", "getCallback", "()Lcom/baidu/searchbox/video/inf/TalosPanelCallback;", "setCallback", "(Lcom/baidu/searchbox/video/inf/TalosPanelCallback;)V", "getContext", "()Landroid/content/Context;", "()Z", "isSupportVideoUp", "setSupportVideoUp", "(Z)V", "lastY", "", "maskHideAnimStartAlpha", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "maskView$delegate", "Lkotlin/Lazy;", "playDismissAnim", "getPlayDismissAnim", "setPlayDismissAnim", "pullCallback", "Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/ITalosPopupPanelPullCallback;", "getPullCallback", "()Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/ITalosPopupPanelPullCallback;", "setPullCallback", "(Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/ITalosPopupPanelPullCallback;)V", "rootView", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/ListPopupPanelRootView;", "getRootView", "()Lcom/baidu/searchbox/video/feedflow/detail/listpanel/ListPopupPanelRootView;", "rootView$delegate", "talosContainer", "Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/TalosPanelContainer;", "getTalosContainer", "()Lcom/baidu/searchbox/video/feedflow/detail/talosgoodspanel/TalosPanelContainer;", "talosContainer$delegate", "touchSlop", "", "getTouchSlop", "()I", "touchSlop$delegate", "createRootView", "dismiss", "", "getSupportVideoUp", "data", "", "getTalosPageId", "hideMask", "initMaskView", "initPanel", "isNeedInterceptDrag", "ev", "Landroid/view/MotionEvent;", "onDismiss", "onDragCancel", "onDragComplete", "onDragHorizontal", "dragWidth", "width", "onDragProgressChanged", "progress", "pauseTalosPanel", "releaseTalosPanel", "sendEventStatistic", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "setupData", "show", "parent", "showMask", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPopupPanel.kt */
public final class TalosPopupPanel extends C0297BdPopupWindow implements ListPopupPanelRootView.DragCallback, PopupWindow.OnDismissListener {
    private TalosPanelCallback callback;
    private final Context context;
    private final boolean isNeedMask;
    private boolean isSupportVideoUp;
    private float lastY;
    private float maskHideAnimStartAlpha;
    private final Lazy maskView$delegate;
    private boolean playDismissAnim;
    private ITalosPopupPanelPullCallback pullCallback;
    private final Lazy rootView$delegate;
    private final Lazy talosContainer$delegate;
    private final Lazy touchSlop$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalosPopupPanel(Context context2, boolean isNeedMask2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.isNeedMask = isNeedMask2;
        this.rootView$delegate = BdPlayerUtils.lazyNone(new TalosPopupPanel$rootView$2(this));
        this.talosContainer$delegate = BdPlayerUtils.lazyNone(new TalosPopupPanel$talosContainer$2(this));
        this.maskView$delegate = BdPlayerUtils.lazyNone(new TalosPopupPanel$maskView$2(this));
        this.maskHideAnimStartAlpha = 1.0f;
        this.touchSlop$delegate = BdPlayerUtils.lazyNone(new TalosPopupPanel$touchSlop$2(this));
        this.playDismissAnim = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TalosPopupPanel(Context context2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i2 & 2) != 0 ? false : z);
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isNeedMask() {
        return this.isNeedMask;
    }

    private final ListPopupPanelRootView getRootView() {
        return (ListPopupPanelRootView) this.rootView$delegate.getValue();
    }

    private final TalosPanelContainer getTalosContainer() {
        return (TalosPanelContainer) this.talosContainer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final View getMaskView() {
        return (View) this.maskView$delegate.getValue();
    }

    public final boolean isSupportVideoUp() {
        return this.isSupportVideoUp;
    }

    public final void setSupportVideoUp(boolean z) {
        this.isSupportVideoUp = z;
    }

    private final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    public final TalosPanelCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(TalosPanelCallback talosPanelCallback) {
        this.callback = talosPanelCallback;
    }

    public final ITalosPopupPanelPullCallback getPullCallback() {
        return this.pullCallback;
    }

    public final void setPullCallback(ITalosPopupPanelPullCallback iTalosPopupPanelPullCallback) {
        this.pullCallback = iTalosPopupPanelPullCallback;
    }

    public final boolean getPlayDismissAnim() {
        return this.playDismissAnim;
    }

    public final void setPlayDismissAnim(boolean z) {
        this.playDismissAnim = z;
    }

    private final void setupData(String data) {
        getTalosContainer().createViewWithData(data, 1);
    }

    private final void pauseTalosPanel() {
        getTalosContainer().pause();
    }

    public final void releaseTalosPanel() {
        getTalosContainer().release();
    }

    public final void sendEventStatistic(Store<AbsState> store) {
        getTalosContainer().sendEventStatistic(store);
    }

    public final String getTalosPageId() {
        return String.valueOf(getTalosContainer().getTalosViewId());
    }

    public final boolean getSupportVideoUp(String data) {
        try {
            JSONObject optJSONObject = new JSONObject(data).optJSONObject("config");
            return Intrinsics.areEqual((Object) optJSONObject != null ? optJSONObject.optString("windowSqueeze") : null, (Object) "1");
        } catch (JSONException e2) {
            return false;
        }
    }

    public final void show(String data, View parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        if (!isShowing()) {
            CharSequence charSequence = data;
            if (!(charSequence == null || charSequence.length() == 0)) {
                setupData(data);
                boolean supportVideoUp = getSupportVideoUp(data);
                this.isSupportVideoUp = supportVideoUp;
                int realHeight = -2;
                if (supportVideoUp) {
                    PanelSizeConfig panelSizeConfig = PanelSizeConfig.INSTANCE;
                    Context context2 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                    int panelHeightVideoMoveUp = PanelSizeConfig.getPanelHeightVideoMoveUp$default(panelSizeConfig, context2, (Float) null, 2, (Object) null);
                    if (panelHeightVideoMoveUp > 0) {
                        realHeight = panelHeightVideoMoveUp;
                    } else {
                        getRootView().setMaxPanelHeight(PanelSizeConfig.INSTANCE.getPanelHeight(false));
                    }
                    ViewGroup.LayoutParams layoutParams = getRootView().getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = realHeight;
                    }
                    ViewGroup.LayoutParams layoutParams2 = getTalosContainer().getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = realHeight;
                    }
                    if (panelHeightVideoMoveUp > 0) {
                        getRootView().setMaxPanelHeight(panelHeightVideoMoveUp);
                    } else {
                        getRootView().setMaxPanelHeight(PanelSizeConfig.INSTANCE.getPanelHeight(false));
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams3 = getRootView().getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = -2;
                    }
                    ViewGroup.LayoutParams layoutParams4 = getTalosContainer().getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.height = -2;
                    }
                    getRootView().setMaxPanelHeight(PanelSizeConfig.INSTANCE.getPanelHeight(false));
                }
                getTalosContainer().resume();
                showMask();
                showAtLocation(parent, 81, 0, 0);
                TalosPanelCallback talosPanelCallback = this.callback;
                if (talosPanelCallback != null) {
                    talosPanelCallback.onPanelVisibleChange(true, this.isSupportVideoUp, this.playDismissAnim);
                }
            }
        }
    }

    private final void showMask() {
        if (this.isNeedMask) {
            Animation animation = AnimationUtils.loadAnimation(this.context, R.anim.video_flow_list_popup_panel_mask_enter_anim);
            this.maskHideAnimStartAlpha = 1.0f;
            getMaskView().setAlpha(this.maskHideAnimStartAlpha);
            getMaskView().setVisibility(0);
            getMaskView().startAnimation(animation);
        }
    }

    private final void hideMask() {
        if (this.isNeedMask) {
            AlphaAnimation animation = new AlphaAnimation(this.maskHideAnimStartAlpha, 0.0f);
            animation.setDuration((long) this.context.getResources().getInteger(R.integer.video_flow_list_popup_panel_exit_duration));
            animation.setInterpolator(new LinearInterpolator());
            animation.setAnimationListener(new TalosPopupPanel$hideMask$1(this));
            getMaskView().startAnimation(animation);
        }
    }

    private final void initPanel() {
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.video_flow_list_popup_panel_anim);
        setOnDismissListener(this);
    }

    /* access modifiers changed from: private */
    public final View initMaskView() {
        View view2 = new View(this.context);
        View $this$initMaskView_u24lambda_u2d0 = view2;
        $this$initMaskView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$initMaskView_u24lambda_u2d0.setBackgroundColor(ContextCompat.getColor($this$initMaskView_u24lambda_u2d0.getContext(), com.baidu.android.common.ui.style.R.color.GC11));
        $this$initMaskView_u24lambda_u2d0.setVisibility(8);
        if (this.isNeedMask) {
            Context context2 = $this$initMaskView_u24lambda_u2d0.getContext();
            ViewGroup viewGroup = null;
            Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
            ViewGroup viewGroup2 = activity != null ? (ViewGroup) activity.findViewById(16908290) : null;
            if (viewGroup2 instanceof ViewGroup) {
                viewGroup = viewGroup2;
            }
            if (viewGroup != null) {
                viewGroup.addView($this$initMaskView_u24lambda_u2d0);
            }
        }
        return view2;
    }

    /* access modifiers changed from: private */
    public final ListPopupPanelRootView createRootView() {
        ListPopupPanelRootView $this$createRootView_u24lambda_u2d2 = new ListPopupPanelRootView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createRootView_u24lambda_u2d2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TalosPanelContainer $this$createRootView_u24lambda_u2d2_u24lambda_u2d1 = getTalosContainer();
        $this$createRootView_u24lambda_u2d2_u24lambda_u2d1.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$createRootView_u24lambda_u2d2.addView($this$createRootView_u24lambda_u2d2_u24lambda_u2d1);
        $this$createRootView_u24lambda_u2d2.setDragCallback(this);
        $this$createRootView_u24lambda_u2d2.setDragInterceptor(new TalosPopupPanel$createRootView$1$2(this));
        initPanel();
        setContentView($this$createRootView_u24lambda_u2d2);
        return $this$createRootView_u24lambda_u2d2;
    }

    /* access modifiers changed from: private */
    public final boolean isNeedInterceptDrag(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.lastY = ev.getRawY();
                break;
            case 2:
                float curY = ev.getRawY();
                boolean isDownMove = curY - this.lastY > ((float) getTouchSlop());
                this.lastY = curY;
                if (!isDownMove || getTalosContainer().canScrollVertically(-1)) {
                    return false;
                }
                return true;
        }
        return false;
    }

    public void onDragProgressChanged(float progress) {
        if (this.isNeedMask) {
            this.maskHideAnimStartAlpha = ((float) 1) - progress;
            getMaskView().setAlpha(this.maskHideAnimStartAlpha);
        }
        ITalosPopupPanelPullCallback iTalosPopupPanelPullCallback = this.pullCallback;
        if (iTalosPopupPanelPullCallback != null) {
            iTalosPopupPanelPullCallback.onVerticalPullProgressChanged(progress);
        }
    }

    public void onDragHorizontal(int dragWidth, int width) {
    }

    public void onDragCancel() {
        if (this.isNeedMask) {
            this.maskHideAnimStartAlpha = 1.0f;
            getMaskView().setAlpha(this.maskHideAnimStartAlpha);
        }
    }

    public void onDragComplete() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void dismiss() {
        if (isShowing()) {
            hideMask();
            super.dismiss();
        }
    }

    public void onDismiss() {
        pauseTalosPanel();
        releaseTalosPanel();
        TalosPanelCallback talosPanelCallback = this.callback;
        if (talosPanelCallback != null) {
            talosPanelCallback.onPanelVisibleChange(false, this.isSupportVideoUp, this.playDismissAnim);
        }
    }
}
