package com.baidu.searchbox.video.feedflow.detail.collectionpayment;

import android.animation.Animator;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.flowvideo.detail.repos.PaymentModel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionPayButtonComponent$groupControlListener$2;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlService;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import com.baidu.searchbox.video.feedflow.flow.list.CommonItemData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.utils.CountDownClock;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020\fH\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u000202H\u0002J\b\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u000202H\u0002J\b\u00107\u001a\u00020&H\u0016J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020&H\u0016J\b\u0010<\u001a\u00020&H\u0002J\b\u0010=\u001a\u00020&H\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020&H\u0002J\u0012\u0010@\u001a\u00020&2\b\b\u0002\u0010A\u001a\u000202H\u0002J\u0012\u0010B\u001a\u00020&2\b\b\u0002\u0010A\u001a\u000202H\u0002J\u0018\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u0002022\u0006\u0010A\u001a\u000202H\u0002J\b\u0010D\u001a\u00020&H\u0002J\b\u0010E\u001a\u00020&H\u0002J\u0010\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020-H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b!\u0010\u001eR\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButtonComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "collectionPayButton", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButton;", "getCollectionPayButton", "()Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButton;", "collectionPayButton$delegate", "Lkotlin/Lazy;", "colorChangedCountDownTime", "", "countDownClock", "Lcom/baidu/searchbox/video/feedflow/utils/CountDownClock;", "getCountDownClock", "()Lcom/baidu/searchbox/video/feedflow/utils/CountDownClock;", "countDownClock$delegate", "groupControlAreas", "", "Lcom/baidu/searchbox/video/feedflow/detail/controlvisible/GroupControlArea;", "getGroupControlAreas", "()Ljava/util/List;", "groupControlAreas$delegate", "groupControlListener", "com/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButtonComponent$groupControlListener$2$1", "getGroupControlListener", "()Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionPayButtonComponent$groupControlListener$2$1;", "groupControlListener$delegate", "hideAnimator", "Landroid/animation/Animator;", "getHideAnimator", "()Landroid/animation/Animator;", "hideAnimator$delegate", "showAnimator", "getShowAnimator", "showAnimator$delegate", "showCountDownDuration", "showCountDownTime", "bindData", "", "data", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayButtonModel;", "createView", "Landroid/view/View;", "doPay", "getPayOrderInfo", "", "getRecSrc", "hideCollectionEntrance", "initCountDownClock", "isColorAnimatorEnd", "", "isLandscape", "isShowAnimatorEnd", "isShowWithAnimator", "isSubscribeType", "onAttachToManager", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "onRelease", "onViewDetach", "pauseCountDown", "resetPayButtonState", "resumeCountDown", "setButtonGone", "needAnim", "setButtonVisible", "visible", "startCountDown", "stopCountDown", "wrapOrderInfo", "originalOrderInfo", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPayButtonComponent.kt */
public final class CollectionPayButtonComponent extends LiveDataComponent {
    private final Lazy collectionPayButton$delegate = BdPlayerUtils.lazyNone(new CollectionPayButtonComponent$collectionPayButton$2(this));
    /* access modifiers changed from: private */
    public int colorChangedCountDownTime;
    private final Lazy countDownClock$delegate = BdPlayerUtils.lazyNone(new CollectionPayButtonComponent$countDownClock$2(this));
    private final Lazy groupControlAreas$delegate = BdPlayerUtils.lazyNone(CollectionPayButtonComponent$groupControlAreas$2.INSTANCE);
    private final Lazy groupControlListener$delegate = BdPlayerUtils.lazyNone(new CollectionPayButtonComponent$groupControlListener$2(this));
    private final Lazy hideAnimator$delegate = BdPlayerUtils.lazyNone(new CollectionPayButtonComponent$hideAnimator$2(this));
    private final Lazy showAnimator$delegate = BdPlayerUtils.lazyNone(new CollectionPayButtonComponent$showAnimator$2(this));
    private int showCountDownDuration = 5;
    /* access modifiers changed from: private */
    public int showCountDownTime = 2;

    /* access modifiers changed from: private */
    public final CollectionPayButton getCollectionPayButton() {
        return (CollectionPayButton) this.collectionPayButton$delegate.getValue();
    }

    private final CountDownClock getCountDownClock() {
        return (CountDownClock) this.countDownClock$delegate.getValue();
    }

    private final List<GroupControlArea> getGroupControlAreas() {
        return (List) this.groupControlAreas$delegate.getValue();
    }

    private final Animator getShowAnimator() {
        return (Animator) this.showAnimator$delegate.getValue();
    }

    private final Animator getHideAnimator() {
        return (Animator) this.hideAnimator$delegate.getValue();
    }

    private final CollectionPayButtonComponent$groupControlListener$2.AnonymousClass1 getGroupControlListener() {
        return (CollectionPayButtonComponent$groupControlListener$2.AnonymousClass1) this.groupControlListener$delegate.getValue();
    }

    public void onAttachToManager() {
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        CollectionColumnPayState $this$onAttachToManager_u24lambda_u2d8;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        super.onAttachToManager();
        IGroupControlService iGroupControlService = (IGroupControlService) getManager().getService(IGroupControlService.class);
        if (iGroupControlService != null) {
            iGroupControlService.registerGroupsAndListener(getGroupControlAreas(), getGroupControlListener());
        }
        Store<AbsState> store = getStore();
        if (!(store == null || (coreState = (CoreState) store.subscribe((Class<T>) CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda0(this));
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || ($this$onAttachToManager_u24lambda_u2d8 = (CollectionColumnPayState) store2.subscribe((Class<T>) CollectionColumnPayState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d8.getCollectionColumnPayBtnModel().observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda1(this, $this$onAttachToManager_u24lambda_u2d8));
            $this$onAttachToManager_u24lambda_u2d8.getSetVisible().observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d8.isLandscape().observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d8.getResumeCountDown().observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda4(this));
            $this$onAttachToManager_u24lambda_u2d8.getPauseCountDown().observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda5(this));
        }
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && (fontSizeState = (FontSizeState) $this$subscribe$iv.subscribe(FontSizeState.class)) != null && (action = fontSizeState.getAction()) != null) {
            action.observe(this, new CollectionPayButtonComponent$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1  reason: not valid java name */
    public static final void m11016onAttachToManager$lambda1(CollectionPayButtonComponent this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            this$0.onNestedAction(nestedAction);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-3  reason: not valid java name */
    public static final void m11017onAttachToManager$lambda8$lambda3(CollectionPayButtonComponent this$0, CollectionColumnPayState $this_apply, CollectionColumnPayButtonModel buttonInfoModel) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        if (buttonInfoModel != null) {
            CollectionColumnPayButtonModel collectionColumnPayButtonModel = buttonInfoModel;
            this$0.bindData(buttonInfoModel);
            if (CommonStateExtKt.isActive(this$0.getStore()) && $this_apply.needShowButton()) {
                this$0.startCountDown();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.resetPayButtonState();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-4  reason: not valid java name */
    public static final void m11018onAttachToManager$lambda8$lambda4(CollectionPayButtonComponent this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        if (isVisible.booleanValue()) {
            this$0.setButtonVisible(true);
        } else {
            this$0.setButtonGone(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-5  reason: not valid java name */
    public static final void m11019onAttachToManager$lambda8$lambda5(CollectionPayButtonComponent this$0, Boolean isLandscape) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isLandscape, "isLandscape");
        if (isLandscape.booleanValue()) {
            this$0.hideCollectionEntrance();
            setButtonGone$default(this$0, false, 1, (Object) null);
            return;
        }
        setButtonVisible$default(this$0, false, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-6  reason: not valid java name */
    public static final void m11020onAttachToManager$lambda8$lambda6(CollectionPayButtonComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resumeCountDown();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-7  reason: not valid java name */
    public static final void m11021onAttachToManager$lambda8$lambda7(CollectionPayButtonComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pauseCountDown();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9  reason: not valid java name */
    public static final void m11022onAttachToManager$lambda9(CollectionPayButtonComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCollectionPayButton().setFontSize();
    }

    private final void bindData(CollectionColumnPayButtonModel data) {
        int secondTime = data.getSecondTime();
        this.showCountDownDuration = secondTime;
        this.showCountDownTime = secondTime - data.getFirstTime();
        this.colorChangedCountDownTime = 0;
        getCollectionPayButton().setText(data.getBtnText());
        hideCollectionEntrance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r4.isPaymentCollectionPanelColumn(r6) == true) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void hideCollectionEntrance() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0038
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0015
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0016
        L_0x0015:
            r4 = r6
        L_0x0016:
            if (r4 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState> r5 = com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0020
        L_0x001f:
            r4 = r6
        L_0x0020:
            com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState r4 = (com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState) r4
            if (r4 == 0) goto L_0x0038
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x0031
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            r6 = r0
            com.baidu.searchbox.feed.detail.frame.AbsState r6 = (com.baidu.searchbox.feed.detail.frame.AbsState) r6
        L_0x0031:
            boolean r0 = r4.isPaymentCollectionPanelColumn(r6)
            if (r0 != r1) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            if (r1 == 0) goto L_0x004e
            boolean r0 = r7.isLandscape()
            if (r0 == 0) goto L_0x004e
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x004e
            com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayAction$HideCollectionEntrance r1 = com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayAction.HideCollectionEntrance.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionPayButtonComponent.hideCollectionEntrance():void");
    }

    static /* synthetic */ void setButtonVisible$default(CollectionPayButtonComponent collectionPayButtonComponent, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        collectionPayButtonComponent.setButtonVisible(z);
    }

    private final void setButtonVisible(boolean needAnim) {
        Store $this$select$iv = getStore();
        boolean z = false;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionColumnPayState.class);
            }
            CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
            if (collectionColumnPayState != null && collectionColumnPayState.needShowButton()) {
                z = true;
            }
        }
        if (z) {
            if (isShowWithAnimator()) {
                if (isShowAnimatorEnd() && !isColorAnimatorEnd()) {
                    setButtonVisible(true, needAnim);
                }
                getCountDownClock().resume();
            } else if (!isShowAnimatorEnd() || !isColorAnimatorEnd()) {
                startCountDown();
            } else {
                setButtonVisible(true, needAnim);
            }
        }
    }

    static /* synthetic */ void setButtonGone$default(CollectionPayButtonComponent collectionPayButtonComponent, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        collectionPayButtonComponent.setButtonGone(z);
    }

    private final void setButtonGone(boolean needAnim) {
        if (getCountDownClock().getCurState() == CountDownClock.STATE.RUNNING) {
            getCountDownClock().pause();
        }
        setButtonVisible(false, needAnim);
    }

    private final void setButtonVisible(boolean visible, boolean needAnim) {
        if (needAnim) {
            ShowAndHideAnimHelperKt.switchAlphaAnim$default(getShowAnimator(), getHideAnimator(), visible, getCollectionPayButton(), 0.0f, 0.0f, 48, (Object) null);
            return;
        }
        ShowAndHideAnimHelperKt.cancelAlphaAnim(getShowAnimator(), getHideAnimator());
        getCollectionPayButton().setVisibility(visible ? 0 : 8);
    }

    private final boolean isShowWithAnimator() {
        return (!isShowAnimatorEnd() || !isColorAnimatorEnd()) && getCountDownClock().getCurState() == CountDownClock.STATE.PAUSE;
    }

    private final boolean isShowAnimatorEnd() {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionColumnPayState.class);
            }
            CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
            if (collectionColumnPayState != null && collectionColumnPayState.isShowAnimatorEnd()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isColorAnimatorEnd() {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionColumnPayState.class);
            }
            CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
            if (collectionColumnPayState != null && collectionColumnPayState.isColorAnimatorEnd()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isSubscribeType() {
        PaymentModel paymentModel;
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionColumnPayState.class);
            }
            CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
            if (!(collectionColumnPayState == null || (paymentModel = collectionColumnPayState.getPaymentModel()) == null || !paymentModel.isSubscribeType())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final CountDownClock initCountDownClock() {
        CountDownClock $this$initCountDownClock_u24lambda_u2d10 = new CountDownClock(this.showCountDownDuration);
        $this$initCountDownClock_u24lambda_u2d10.setCountDownCallback(new CollectionPayButtonComponent$initCountDownClock$1$1(this));
        return $this$initCountDownClock_u24lambda_u2d10;
    }

    public View createView() {
        getCollectionPayButton().setPayButtonStateListener(new CollectionPayButtonComponent$createView$1(this));
        return getCollectionPayButton();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r5.needShowButton() == true) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onNestedAction(com.baidu.searchbox.feed.detail.arch.ext.NestedAction r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            r1 = r0
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
        L_0x0013:
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isItemTriggerByTab(r1)
            if (r0 == 0) goto L_0x001d
            r7.pauseCountDown()
            goto L_0x006c
        L_0x001d:
            r7.onViewDetach()
            goto L_0x006c
        L_0x0021:
            boolean r0 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            if (r0 == 0) goto L_0x006c
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x004f
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0039
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x003a
        L_0x0039:
            r5 = r1
        L_0x003a:
            if (r5 == 0) goto L_0x0043
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState> r6 = com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0044
        L_0x0043:
            r5 = r1
        L_0x0044:
            com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState r5 = (com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState) r5
            if (r5 == 0) goto L_0x004f
            boolean r0 = r5.needShowButton()
            if (r0 != r2) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r2 = r3
        L_0x0050:
            if (r2 == 0) goto L_0x006c
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x005f
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            r1 = r0
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
        L_0x005f:
            boolean r0 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isItemTriggerByTab(r1)
            if (r0 == 0) goto L_0x0069
            r7.resumeCountDown()
            goto L_0x006c
        L_0x0069:
            r7.startCountDown()
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionPayButtonComponent.onNestedAction(com.baidu.searchbox.feed.detail.arch.ext.NestedAction):void");
    }

    private final void onViewDetach() {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionColumnPayState.class);
            }
            CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
            if (collectionColumnPayState != null) {
                CollectionColumnPayState $this$onViewDetach_u24lambda_u2d11 = collectionColumnPayState;
                $this$onViewDetach_u24lambda_u2d11.setShowAnimatorEnd(false);
                $this$onViewDetach_u24lambda_u2d11.setColorAnimatorEnd(false);
            }
        }
        resetPayButtonState();
    }

    private final void resetPayButtonState() {
        stopCountDown();
        getCollectionPayButton().resetView();
    }

    /* access modifiers changed from: private */
    public final boolean isLandscape() {
        Store<AbsState> store = getStore();
        return LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null);
    }

    private final void startCountDown() {
        if (getCollectionPayButton().getVisibility() != 0 && !isLandscape()) {
            getCountDownClock().start();
        }
    }

    private final void pauseCountDown() {
        if (getCountDownClock().getCurState() == CountDownClock.STATE.RUNNING) {
            getCountDownClock().pause();
        }
    }

    private final void resumeCountDown() {
        if (getCountDownClock().getCurState() == CountDownClock.STATE.PAUSE) {
            getCountDownClock().resume();
        }
    }

    /* access modifiers changed from: private */
    public final void stopCountDown() {
        getCountDownClock().stop();
    }

    public void onRelease() {
        super.onRelease();
        IGroupControlService iGroupControlService = (IGroupControlService) getManager().getService(IGroupControlService.class);
        if (iGroupControlService != null) {
            iGroupControlService.unregisterGroupsAndListener(getGroupControlAreas(), getGroupControlListener());
        }
        getCountDownClock().release();
        getCollectionPayButton().resetView();
        ShowAndHideAnimHelperKt.releaseAlphaAnim(getShowAnimator(), getHideAnimator());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void doPay() {
        /*
            r20 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r20.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0027
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState> r4 = com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState r3 = (com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayState) r3
            if (r3 == 0) goto L_0x0027
            com.baidu.searchbox.flowvideo.detail.repos.PaymentModel r0 = r3.getPaymentModel()
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x00ee
            r2 = r0
            r3 = 0
            boolean r4 = r2.isSubscribeType()
            if (r4 == 0) goto L_0x003e
            java.lang.String r4 = r20.getPayOrderInfo()
            r5 = r20
            java.lang.String r4 = r5.wrapOrderInfo(r4)
            r8 = r4
            goto L_0x0045
        L_0x003e:
            r5 = r20
            java.lang.String r4 = r20.getPayOrderInfo()
            r8 = r4
        L_0x0045:
            boolean r4 = r2.isSubscribeType()
            if (r4 == 0) goto L_0x0051
            java.lang.String r4 = "video_list_btn"
            r9 = r4
            goto L_0x008c
        L_0x0051:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.baidu.searchbox.feed.detail.frame.Store r6 = r20.getStore()
            if (r6 == 0) goto L_0x007a
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r6.getState()
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0068
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9
            goto L_0x0069
        L_0x0068:
            r9 = r1
        L_0x0069:
            if (r9 == 0) goto L_0x0072
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r9 = r9.select(r10)
            goto L_0x0073
        L_0x0072:
            r9 = r1
        L_0x0073:
            com.baidu.searchbox.video.detail.core.model.IntentData r9 = (com.baidu.searchbox.video.detail.core.model.IntentData) r9
            if (r9 == 0) goto L_0x007a
            java.lang.String r6 = r9.pd
            goto L_0x007b
        L_0x007a:
            r6 = r1
        L_0x007b:
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = r20.getRecSrc()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            r9 = r4
        L_0x008c:
            com.baidu.searchbox.feed.detail.frame.Store r4 = r20.getStore()
            if (r4 == 0) goto L_0x00bc
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayClickAction r19 = new com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayClickAction
            java.lang.String r7 = r2.getAlbumId()
            boolean r10 = r2.isLimitFree()
            boolean r11 = r2.isPaymentType()
            r12 = 0
            boolean r13 = r2.isTraining()
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 928(0x3a0, float:1.3E-42)
            r18 = 0
            r6 = r19
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r6 = r19
            com.baidu.searchbox.feed.detail.frame.Action r6 = (com.baidu.searchbox.feed.detail.frame.Action) r6
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r4, r6)
        L_0x00bc:
            com.baidu.searchbox.feed.detail.frame.Store r4 = r20.getStore()
            if (r4 == 0) goto L_0x00e1
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r4.getState()
            boolean r10 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x00ce
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x00cf
        L_0x00ce:
            r7 = r1
        L_0x00cf:
            if (r7 == 0) goto L_0x00d8
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState> r10 = com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState.class
            java.lang.Object r7 = r7.select(r10)
            goto L_0x00d9
        L_0x00d8:
            r7 = r1
        L_0x00d9:
            com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState r7 = (com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState) r7
            if (r7 == 0) goto L_0x00e1
            androidx.lifecycle.MutableLiveData r1 = r7.isEnableSensor()
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            goto L_0x00ec
        L_0x00e4:
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.setValue(r4)
        L_0x00ec:
            goto L_0x00f0
        L_0x00ee:
            r5 = r20
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionPayButtonComponent.doPay():void");
    }

    private final String wrapOrderInfo(String originalOrderInfo) {
        try {
            JSONObject orderInfo = new JSONObject(originalOrderInfo);
            Store $this$select$iv = getStore();
            String str = null;
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
                if (intentData != null) {
                    str = intentData.pd;
                }
            }
            if (str == null) {
                str = "";
            }
            orderInfo.put("pd", str);
            String jSONObject = orderInfo.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "orderInfo.toString()");
            return jSONObject;
        } catch (JSONException e2) {
            return originalOrderInfo;
        }
    }

    private final String getPayOrderInfo() {
        AbsState state;
        ItemModel itemModel;
        CommonItemData commonItemData;
        String ext;
        Store<AbsState> store = getStore();
        String str = null;
        AbsState state2 = store != null ? store.getState() : null;
        CommonState commonState = state2 instanceof CommonState ? (CommonState) state2 : null;
        boolean z = false;
        if (commonState != null && CommonStateExtKt.isFirstJump$default(commonState, (ItemModel) null, 1, (Object) null)) {
            z = true;
        }
        if (z) {
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state3 = $this$select$iv.getState();
                CommonState commonState2 = state3 instanceof CommonState ? (CommonState) state3 : null;
                IntentData intentData = (IntentData) (commonState2 != null ? commonState2.select(IntentData.class) : null);
                if (intentData != null) {
                    str = intentData.payOrderInfo;
                }
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        Store<AbsState> store2 = getStore();
        if (store2 == null || (state = store2.getState()) == null || (itemModel = (ItemModel) state.select(ItemModel.class)) == null || (commonItemData = itemModel.getCommonItemData()) == null || (ext = commonItemData.getExt()) == null) {
            return "";
        }
        try {
            String optString = new JSONObject(ext).optString("sExt");
            Intrinsics.checkNotNullExpressionValue(optString, "extObj.optString(\"sExt\")");
            return optString;
        } catch (JSONException e2) {
            return "";
        }
    }

    private final String getRecSrc() {
        AbsState state;
        ItemModel itemModel;
        CommonItemData commonItemData;
        String ext;
        Store<AbsState> store = getStore();
        String str = null;
        AbsState state2 = store != null ? store.getState() : null;
        CommonState commonState = state2 instanceof CommonState ? (CommonState) state2 : null;
        boolean z = false;
        if (commonState != null && CommonStateExtKt.isFirstJump$default(commonState, (ItemModel) null, 1, (Object) null)) {
            z = true;
        }
        if (z) {
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state3 = $this$select$iv.getState();
                CommonState commonState2 = state3 instanceof CommonState ? (CommonState) state3 : null;
                IntentData intentData = (IntentData) (commonState2 != null ? commonState2.select(IntentData.class) : null);
                if (intentData != null) {
                    str = intentData.recSrc;
                }
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        Store<AbsState> store2 = getStore();
        if (store2 == null || (state = store2.getState()) == null || (itemModel = (ItemModel) state.select(ItemModel.class)) == null || (commonItemData = itemModel.getCommonItemData()) == null || (ext = commonItemData.getExt()) == null) {
            return "";
        }
        try {
            String optString = new JSONObject(ext).optString("rec_src");
            Intrinsics.checkNotNullExpressionValue(optString, "extObj.optString(\"rec_src\")");
            return optString;
        } catch (JSONException e2) {
            return "";
        }
    }
}
