package com.baidu.searchbox.feed.payment.payui.payPanel;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.payment.QuickPayHelper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.feed.log.IFeedLogger;
import com.baidu.searchbox.feed.log.OnLineLog;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.PayCallback;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.core.manager.payPanel.PayPanelManager;
import com.baidu.searchbox.feed.payment.core.model.FeedPaymentConfig;
import com.baidu.searchbox.feed.payment.core.model.PayInfo;
import com.baidu.searchbox.feed.payment.model.PayChannelInfoItemData;
import com.baidu.searchbox.feed.payment.model.PayPanelData;
import com.baidu.searchbox.feed.payment.model.SplitPayRadioButton;
import com.baidu.searchbox.feed.payment.payui.payPanel.dialog.ShortVideoChargedDialog;
import com.baidu.searchbox.feed.payment.utils.AnimationUtilsKt;
import com.baidu.searchbox.feed.payment.utils.SimpleUiHelperKt;
import com.baidu.searchbox.feed.util.FeedLoginUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020EH\u0002J\b\u0010[\u001a\u00020YH\u0016J\b\u0010\\\u001a\u00020YH\u0002J\b\u0010]\u001a\u00020\u0010H\u0017J\b\u0010^\u001a\u00020YH\u0016J\u0012\u0010_\u001a\u00020Y2\b\u0010`\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010a\u001a\u00020Y2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0018\u0010d\u001a\u00020Y2\u0006\u0010e\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020\u001dH\u0016J\u0012\u0010g\u001a\u00020Y2\b\u0010h\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010i\u001a\u00020YH\u0016J\u0010\u0010j\u001a\u00020Y2\u0006\u0010k\u001a\u00020#H\u0002J\b\u0010l\u001a\u00020YH\u0003J\b\u0010m\u001a\u00020YH\u0002J\u0010\u0010n\u001a\u00020Y2\u0006\u0010Z\u001a\u00020EH\u0002R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001c0\u001b8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001b8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010 R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b2\u00103R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010\u0014\u001a\u0004\b9\u0010:R\u001b\u0010<\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b>\u0010\u0014\u001a\u0004\b=\u0010\u0012R\u001b\u0010?\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\u0014\u001a\u0004\bA\u0010BR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R!\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u001b8BX\u0002¢\u0006\f\n\u0004\bG\u0010\u0014\u001a\u0004\bF\u0010 R\u001b\u0010H\u001a\u00020I8BX\u0002¢\u0006\f\n\u0004\bL\u0010\u0014\u001a\u0004\bJ\u0010KR\u0016\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020O8BX\u0002¢\u0006\f\n\u0004\bR\u0010\u0014\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020T8BX\u0002¢\u0006\f\n\u0004\bW\u0010\u0014\u001a\u0004\bU\u0010V¨\u0006o"}, d2 = {"Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelViewDialog;", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayBaseDialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "ctx", "Landroid/content/Context;", "payInfo", "Lcom/baidu/searchbox/feed/payment/core/model/PayInfo;", "payConfig", "Lcom/baidu/searchbox/feed/payment/core/model/FeedPaymentConfig;", "payPanelManager", "Lcom/baidu/searchbox/feed/payment/core/manager/payPanel/PayPanelManager;", "cb", "Lcom/baidu/searchbox/feed/payment/PayCallback;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/core/model/PayInfo;Lcom/baidu/searchbox/feed/payment/core/model/FeedPaymentConfig;Lcom/baidu/searchbox/feed/payment/core/manager/payPanel/PayPanelManager;Lcom/baidu/searchbox/feed/payment/PayCallback;)V", "bottomView", "Landroid/view/View;", "getBottomView", "()Landroid/view/View;", "bottomView$delegate", "Lkotlin/Lazy;", "channelView", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelChannelView;", "getChannelView", "()Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelChannelView;", "channelView$delegate", "chargedDialogObserver", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "", "", "getChargedDialogObserver", "()Landroidx/lifecycle/Observer;", "chargedDialogObserver$delegate", "closePanelObserver", "", "getClosePanelObserver", "closePanelObserver$delegate", "closeView", "Landroid/widget/ImageView;", "getCloseView", "()Landroid/widget/ImageView;", "closeView$delegate", "contentLayout", "Landroid/widget/LinearLayout;", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "contentScroll", "Landroidx/core/widget/NestedScrollView;", "getContentScroll", "()Landroidx/core/widget/NestedScrollView;", "contentScroll$delegate", "hasSetScrollWrapStyle", "isLogin", "mainView", "Landroid/widget/RelativeLayout;", "getMainView", "()Landroid/widget/RelativeLayout;", "mainView$delegate", "mask", "getMask", "mask$delegate", "payButton", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelBuyView;", "getPayButton", "()Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelBuyView;", "payButton$delegate", "payPanelObserver", "Lcom/baidu/searchbox/feed/payment/model/PayPanelData;", "getPayPanelObserver", "payPanelObserver$delegate", "priceView", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelPriceView;", "getPriceView", "()Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelPriceView;", "priceView$delegate", "titleBalanceObserver", "titleView", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelTitleView;", "getTitleView", "()Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelTitleView;", "titleView$delegate", "viewModel", "Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelViewModel;", "getViewModel", "()Lcom/baidu/searchbox/feed/payment/payui/payPanel/PayPanelViewModel;", "viewModel$delegate", "checkoutBalance", "", "panelData", "dismissView", "doBuy", "getContentView", "initView", "onClick", "v", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onLoginStatusChanged", "oldStatus", "newStatus", "openChargedDialog", "balance", "registerObserver", "setContentLayoutMargin", "margin", "setPanelStyle", "updateScrollWrapStyle", "updateView", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayPanelViewDialog.kt */
public final class PayPanelViewDialog extends PayBaseDialog implements View.OnClickListener, DialogInterface.OnDismissListener {
    private final Lazy bottomView$delegate = LazyKt.lazy(new PayPanelViewDialog$bottomView$2(this));
    private final PayCallback cb;
    private final Lazy channelView$delegate = LazyKt.lazy(new PayPanelViewDialog$channelView$2(this));
    private final Lazy chargedDialogObserver$delegate = LazyKt.lazy(new PayPanelViewDialog$chargedDialogObserver$2(this));
    private final Lazy closePanelObserver$delegate = LazyKt.lazy(new PayPanelViewDialog$closePanelObserver$2(this));
    private final Lazy closeView$delegate = LazyKt.lazy(new PayPanelViewDialog$closeView$2(this));
    private final Lazy contentLayout$delegate = LazyKt.lazy(new PayPanelViewDialog$contentLayout$2(this));
    private final Lazy contentScroll$delegate = LazyKt.lazy(new PayPanelViewDialog$contentScroll$2(this));
    /* access modifiers changed from: private */
    public final Context ctx;
    private boolean hasSetScrollWrapStyle;
    private boolean isLogin = FeedLoginUtils.isLogin();
    private final Lazy mainView$delegate = LazyKt.lazy(new PayPanelViewDialog$mainView$2(this));
    private final Lazy mask$delegate = LazyKt.lazy(new PayPanelViewDialog$mask$2(this));
    private final Lazy payButton$delegate = LazyKt.lazy(new PayPanelViewDialog$payButton$2(this));
    /* access modifiers changed from: private */
    public final FeedPaymentConfig payConfig;
    /* access modifiers changed from: private */
    public final PayInfo payInfo;
    /* access modifiers changed from: private */
    public final PayPanelManager payPanelManager;
    private final Lazy payPanelObserver$delegate = LazyKt.lazy(new PayPanelViewDialog$payPanelObserver$2(this));
    private final Lazy priceView$delegate = LazyKt.lazy(new PayPanelViewDialog$priceView$2(this));
    private Observer<String> titleBalanceObserver = new PayPanelViewDialog$$ExternalSyntheticLambda3(this);
    private final Lazy titleView$delegate = LazyKt.lazy(new PayPanelViewDialog$titleView$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new PayPanelViewDialog$viewModel$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayPanelViewDialog(Context ctx2, PayInfo payInfo2, FeedPaymentConfig payConfig2, PayPanelManager payPanelManager2, PayCallback cb2) {
        super(ctx2);
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        Intrinsics.checkNotNullParameter(payInfo2, QuickPayHelper.KEY_PARAMS_PAY_INFO);
        Intrinsics.checkNotNullParameter(payConfig2, "payConfig");
        Intrinsics.checkNotNullParameter(payPanelManager2, "payPanelManager");
        this.ctx = ctx2;
        this.payInfo = payInfo2;
        this.payConfig = payConfig2;
        this.payPanelManager = payPanelManager2;
        this.cb = cb2;
    }

    private final View getMask() {
        Object value = this.mask$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mask>(...)");
        return (View) value;
    }

    private final ImageView getCloseView() {
        Object value = this.closeView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-closeView>(...)");
        return (ImageView) value;
    }

    private final LinearLayout getContentLayout() {
        Object value = this.contentLayout$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentLayout>(...)");
        return (LinearLayout) value;
    }

    private final PayPanelTitleView getTitleView() {
        Object value = this.titleView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-titleView>(...)");
        return (PayPanelTitleView) value;
    }

    private final NestedScrollView getContentScroll() {
        Object value = this.contentScroll$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentScroll>(...)");
        return (NestedScrollView) value;
    }

    private final PayPanelPriceView getPriceView() {
        Object value = this.priceView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-priceView>(...)");
        return (PayPanelPriceView) value;
    }

    private final PayPanelChannelView getChannelView() {
        Object value = this.channelView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-channelView>(...)");
        return (PayPanelChannelView) value;
    }

    /* access modifiers changed from: private */
    public final PayPanelBuyView getPayButton() {
        Object value = this.payButton$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-payButton>(...)");
        return (PayPanelBuyView) value;
    }

    private final RelativeLayout getMainView() {
        Object value = this.mainView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mainView>(...)");
        return (RelativeLayout) value;
    }

    private final View getBottomView() {
        Object value = this.bottomView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomView>(...)");
        return (View) value;
    }

    /* access modifiers changed from: private */
    public final PayPanelViewModel getViewModel() {
        return (PayPanelViewModel) this.viewModel$delegate.getValue();
    }

    private final Observer<PayPanelData> getPayPanelObserver() {
        return (Observer) this.payPanelObserver$delegate.getValue();
    }

    private final Observer<Integer> getClosePanelObserver() {
        return (Observer) this.closePanelObserver$delegate.getValue();
    }

    private final Observer<Pair<Boolean, String>> getChargedDialogObserver() {
        return (Observer) this.chargedDialogObserver$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: titleBalanceObserver$lambda-1  reason: not valid java name */
    public static final void m19220titleBalanceObserver$lambda1(PayPanelViewDialog this$0, String balance) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (balance != null) {
            this$0.getTitleView().updateBalance(balance);
        }
    }

    public View getContentView() {
        View inflate = LayoutInflater.from(this.ctx).inflate(R.layout.feed_pay_panel_dialog_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(ctx).inflate(R.layo…_panel_dialog_view, null)");
        return inflate;
    }

    public void initView() {
        getMask().setOnClickListener(this);
        ExpandTouchAreaHelper.expandTouchArea(getContentLayout(), getCloseView(), 1, 10, 10, 10, 10);
        setPanelStyle();
        getContentLayout().setOnClickListener(this);
        getCloseView().setOnClickListener(this);
        getPayButton().setOnBuyClickListener(new PayPanelViewDialog$initView$1(this));
        setOnShowListener(new PayPanelViewDialog$$ExternalSyntheticLambda1(this));
        setOnDismissListener(this);
        AnimationUtilsKt.onPanelAnimatorStart$default(getMask(), getContentLayout(), (AnimatorListenerAdapter) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m19218initView$lambda2(PayPanelViewDialog this$0, DialogInterface it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().recordRechargePanelShow();
    }

    private final void setPanelStyle() {
        Drawable drawable;
        RelativeLayout mainView = getMainView();
        PayPanelData payPanel = getViewModel().getPayPanel();
        FrameLayout.LayoutParams fp = null;
        CharSequence charSequence = payPanel != null ? payPanel.videoPanelStyle : null;
        if (charSequence == null || charSequence.length() == 0) {
            setContentLayoutMargin(FeedpayKt.appContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X121));
            getCloseView().setImageDrawable(SimpleUiHelperKt.drawable(R.drawable.feed_subscription_panel_close));
            if (NightModeHelper.isNightMode()) {
                drawable = SimpleUiHelperKt.drawable(R.drawable.pay_main_new_background);
            } else {
                drawable = SimpleUiHelperKt.drawable(R.drawable.feed_short_video_panel_bg);
            }
        } else {
            setContentLayoutMargin(FeedpayKt.appContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X505));
            getCloseView().setImageDrawable(SimpleUiHelperKt.drawable(R.drawable.feed_pay_pro_panel_close));
            ViewGroup.LayoutParams vp = getContentLayout().getLayoutParams();
            if (vp != null) {
                int margin = FeedpayKt.appContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X001);
                if (vp instanceof FrameLayout.LayoutParams) {
                    fp = (FrameLayout.LayoutParams) vp;
                }
                if (fp != null) {
                    fp.leftMargin = margin;
                    fp.rightMargin = margin;
                    Unit unit = Unit.INSTANCE;
                }
            }
            if (this.payInfo.payPanelBottomOffset > 0) {
                getBottomView().setVisibility(0);
                ViewGroup.LayoutParams it = getBottomView().getLayoutParams();
                if (it != null) {
                    it.height = this.payInfo.payPanelBottomOffset;
                }
                getBottomView().setOnTouchListener(new PayPanelViewDialog$$ExternalSyntheticLambda0(this));
            }
            drawable = SimpleUiHelperKt.drawable(R.drawable.feed_pay_panel_corner_bg);
        }
        mainView.setBackground(drawable);
    }

    /* access modifiers changed from: private */
    /* renamed from: setPanelStyle$lambda-6  reason: not valid java name */
    public static final boolean m19219setPanelStyle$lambda6(PayPanelViewDialog this$0, View view2, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissView();
        return this$0.onBottomViewClick(event.getRawX(), event.getRawY(), this$0.cb);
    }

    private final void setContentLayoutMargin(int margin) {
        getTitleView().setLayoutMargin(margin);
        getPriceView().setLayoutMargin(margin);
        getChannelView().setLayoutMargin(margin);
        getPayButton().setPayButtonMargin(margin);
    }

    public void registerObserver() {
        getViewModel().getPanelLiveData().observeForever(getPayPanelObserver());
        getViewModel().getCloseLiveData().observeForever(getClosePanelObserver());
        getViewModel().getOpenChargedDialogData().observeForever(getChargedDialogObserver());
        getViewModel().getPanelTitleBalanceData().observeForever(this.titleBalanceObserver);
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).addLoginStatusChangedListener(this);
    }

    /* access modifiers changed from: private */
    public final void updateView(PayPanelData panelData) {
        CharSequence charSequence = panelData.videoPanelStyle;
        boolean isNewStyle = !(charSequence == null || charSequence.length() == 0);
        if (isNewStyle) {
            getTitleView().updateIconTitle(panelData.getTitle(), panelData.subHead + panelData.balance + panelData.getPriceUnit(), NightModeHelper.isNightMode() ? panelData.productIconNight : panelData.productIcon);
            getTitleView().updateSubTitle(panelData.subHead, panelData.balance, panelData.getPriceUnit());
        } else {
            getTitleView().updateView(panelData);
        }
        getPriceView().updateView(panelData, this.payInfo);
        getPriceView().setItemClickListener(new PayPanelViewDialog$updateView$1(this));
        getChannelView().updateMoreView(panelData.channels, 1);
        getChannelView().setOnSelectedListener(new PayPanelViewDialog$updateView$2(this));
        getPayButton().updateView(panelData.bottomTips, this.isLogin);
        if (isNewStyle) {
            getPayButton().setBackgroundView();
            getPriceView().setOnItemSelectedListener(new PayPanelViewDialog$updateView$3(this));
        }
        updateScrollWrapStyle();
        checkoutBalance(panelData);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = kotlin.text.StringsKt.toIntOrNull(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkoutBalance(com.baidu.searchbox.feed.payment.model.PayPanelData r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.balance
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x0010
            int r0 = r0.intValue()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            java.lang.String r2 = r4.getPrice()
            if (r2 == 0) goto L_0x0021
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x0021
            int r1 = r2.intValue()
        L_0x0021:
            if (r0 < r1) goto L_0x002b
            boolean r2 = r3.isLogin
            if (r2 == 0) goto L_0x002b
            r2 = 0
            r3.openChargedDialog(r2)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.payui.payPanel.PayPanelViewDialog.checkoutBalance(com.baidu.searchbox.feed.payment.model.PayPanelData):void");
    }

    private final void updateScrollWrapStyle() {
        if (!this.hasSetScrollWrapStyle) {
            getPriceView().post(new PayPanelViewDialog$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateScrollWrapStyle$lambda-8  reason: not valid java name */
    public static final void m19221updateScrollWrapStyle$lambda8(PayPanelViewDialog this$0) {
        int scrollWapHeight;
        LinearLayout.LayoutParams params;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChannelView().getItemCount() > 1) {
            scrollWapHeight = this$0.getPriceView().getHeight() + DeviceUtils.ScreenInfo.dp2px(this$0.ctx, 100.0f);
        } else {
            scrollWapHeight = this$0.getContentScroll().getHeight();
        }
        if (scrollWapHeight > 0) {
            ViewGroup.LayoutParams layoutParams = this$0.getContentScroll().getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                params = (LinearLayout.LayoutParams) layoutParams;
            } else {
                params = null;
                LinearLayout.LayoutParams layoutParams2 = null;
            }
            if (params != null) {
                LinearLayout.LayoutParams it = params;
                it.height = scrollWapHeight;
                this$0.getContentScroll().setLayoutParams(it);
                this$0.hasSetScrollWrapStyle = true;
            }
        }
    }

    public void onClick(View v) {
        if (v != null) {
            int id = v.getId();
            boolean z = true;
            if (!(id == R.id.pay_panel_mask || id == R.id.pay_panel_close)) {
                z = false;
            }
            if (z && !isFastClick()) {
                dismissView();
            }
        }
    }

    public void dismissView() {
        if (isShowing()) {
            AnimationUtilsKt.onPanelAnimatorEnd((View) null, getContentLayout(), new PayPanelViewDialog$dismissView$1(this));
            PayCallback payCallback = this.cb;
            if (payCallback != null) {
                payCallback.payStateCallback(21);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void openChargedDialog(String balance) {
        ShortVideoChargedDialog chargedDialog = new ShortVideoChargedDialog(this.ctx, this.payInfo, this.payConfig, this.payPanelManager, this.cb, balance);
        chargedDialog.setOnCloseListener(new PayPanelViewDialog$openChargedDialog$chargedDialog$1$1(this));
        chargedDialog.show();
    }

    /* access modifiers changed from: private */
    public final void doBuy() {
        if (!isFastClick() && getViewModel().getPayButtonEnable()) {
            if (this.isLogin) {
                SplitPayRadioButton product = getPriceView().findSelectedProduct();
                PayChannelInfoItemData payChannel = getChannelView().findSelectedPayChannel();
                if (payChannel == null || product == null) {
                    UniversalToast.makeText(FeedpayKt.appContext(), (CharSequence) FeedpayKt.appContext().getString(R.string.feed_payment_fail_check_fail)).show();
                    IFeedLogger iFeedLogger = OnLineLog.get("PayPanelViewDialog");
                    boolean z = true;
                    StringBuilder append = new StringBuilder().append("performPayAction occurs error,product select-> ").append(product != null).append(",payChannel select->");
                    if (payChannel == null) {
                        z = false;
                    }
                    iFeedLogger.e(append.append(z).toString());
                    return;
                }
                getViewModel().recharged(this.ctx, this.cb, product.price);
                return;
            }
            getViewModel().login(this.cb);
        }
    }

    public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
        if (!this.isLogin) {
            boolean isLoginNotGuest = FeedLoginUtils.isLoginNotGuest();
            this.isLogin = isLoginNotGuest;
            if (isLoginNotGuest) {
                getViewModel().refreshPanel(this.cb);
            }
        }
    }

    public void onDismiss(DialogInterface dialog) {
        getViewModel().recordRechargePanelDismiss();
        getViewModel().getPanelLiveData().removeObserver(getPayPanelObserver());
        getViewModel().getCloseLiveData().removeObserver(getClosePanelObserver());
        getViewModel().getOpenChargedDialogData().removeObserver(getChargedDialogObserver());
        getViewModel().getPanelTitleBalanceData().removeObserver(this.titleBalanceObserver);
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).removeLoginStatusChangedListener(this);
    }
}
