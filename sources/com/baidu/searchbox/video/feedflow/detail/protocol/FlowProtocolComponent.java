package com.baidu.searchbox.video.feedflow.detail.protocol;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.searchflow.detail.api.ProtocolModel;
import com.baidu.searchbox.video.detail.utils.ReClickUtilKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlService;
import com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolComponent$groupControlListener$2;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.utils.OnAlphaAnimateListener;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import com.baidu.searchbox.video.feedflow.utils.ShowOrHideAndHeightChangeAnimKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u001b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0005¢\u0006\u0002\u0010\u0003J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010\nH\u0016J\b\u00105\u001a\u000202H\u0016J\b\u00106\u001a\u000202H\u0002J\b\u00107\u001a\u000202H\u0002J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R)\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b'\u0010$R\u001b\u0010)\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b*\u0010$R\u0010\u0010,\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b.\u0010$¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/protocol/FlowProtocolComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "Landroid/view/View$OnClickListener;", "()V", "avatarHideAnimator", "Landroid/animation/Animator;", "avatarShowAnimator", "contentTotalHeight", "", "contentView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContentView$annotations", "getContentView", "()Landroid/view/View;", "contentView$delegate", "Lkotlin/Lazy;", "dividerView", "getDividerView", "dividerView$delegate", "groupControlAreas", "", "Lcom/baidu/searchbox/video/feedflow/detail/controlvisible/GroupControlArea;", "getGroupControlAreas", "()Ljava/util/List;", "groupControlAreas$delegate", "groupControlListener", "com/baidu/searchbox/video/feedflow/detail/protocol/FlowProtocolComponent$groupControlListener$2$1", "getGroupControlListener", "()Lcom/baidu/searchbox/video/feedflow/detail/protocol/FlowProtocolComponent$groupControlListener$2$1;", "groupControlListener$delegate", "hideAnimatorSet", "Landroid/animation/AnimatorSet;", "publishAreaView", "Landroid/widget/TextView;", "getPublishAreaView", "()Landroid/widget/TextView;", "publishAreaView$delegate", "publishTimeView", "getPublishTimeView", "publishTimeView$delegate", "serviceExplainView", "getServiceExplainView", "serviceExplainView$delegate", "showAnimatorSet", "webPageView", "getWebPageView", "webPageView$delegate", "createView", "onAttachToManager", "", "onClick", "view", "onDestroy", "resetPublishAreaView", "resetPublishTimeView", "resetServiceView", "updateInnerViewSize", "Companion", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowProtocolComponent.kt */
public final class FlowProtocolComponent extends LiveDataComponent implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Float[] PROTOCOL_CUSTOM_RATIO_LIST;
    /* access modifiers changed from: private */
    public static final int PROTOCOL_SCALE_TYPE;
    private Animator avatarHideAnimator;
    private Animator avatarShowAnimator;
    private int contentTotalHeight;
    private final Lazy contentView$delegate = LazyKt.lazy(new FlowProtocolComponent$contentView$2(this));
    private final Lazy dividerView$delegate = LazyKt.lazy(new FlowProtocolComponent$dividerView$2(this));
    private final Lazy groupControlAreas$delegate = BdPlayerUtils.lazyNone(FlowProtocolComponent$groupControlAreas$2.INSTANCE);
    private final Lazy groupControlListener$delegate = BdPlayerUtils.lazyNone(new FlowProtocolComponent$groupControlListener$2(this));
    private AnimatorSet hideAnimatorSet;
    private final Lazy publishAreaView$delegate = LazyKt.lazy(new FlowProtocolComponent$publishAreaView$2(this));
    private final Lazy publishTimeView$delegate = LazyKt.lazy(new FlowProtocolComponent$publishTimeView$2(this));
    private final Lazy serviceExplainView$delegate = LazyKt.lazy(new FlowProtocolComponent$serviceExplainView$2(this));
    private AnimatorSet showAnimatorSet;
    private final Lazy webPageView$delegate = LazyKt.lazy(new FlowProtocolComponent$webPageView$2(this));

    private static /* synthetic */ void getContentView$annotations() {
    }

    private final TextView getPublishTimeView() {
        Object value = this.publishTimeView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-publishTimeView>(...)");
        return (TextView) value;
    }

    private final TextView getPublishAreaView() {
        Object value = this.publishAreaView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-publishAreaView>(...)");
        return (TextView) value;
    }

    private final TextView getServiceExplainView() {
        Object value = this.serviceExplainView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-serviceExplainView>(...)");
        return (TextView) value;
    }

    private final TextView getWebPageView() {
        Object value = this.webPageView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-webPageView>(...)");
        return (TextView) value;
    }

    private final View getDividerView() {
        Object value = this.dividerView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dividerView>(...)");
        return (View) value;
    }

    /* access modifiers changed from: private */
    public final View getContentView() {
        return (View) this.contentView$delegate.getValue();
    }

    private final List<GroupControlArea> getGroupControlAreas() {
        return (List) this.groupControlAreas$delegate.getValue();
    }

    private final FlowProtocolComponent$groupControlListener$2.AnonymousClass1 getGroupControlListener() {
        return (FlowProtocolComponent$groupControlListener$2.AnonymousClass1) this.groupControlListener$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/protocol/FlowProtocolComponent$Companion;", "", "()V", "PROTOCOL_CUSTOM_RATIO_LIST", "", "", "[Ljava/lang/Float;", "PROTOCOL_SCALE_TYPE", "", "getPROTOCOL_SCALE_TYPE", "()I", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowProtocolComponent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getPROTOCOL_SCALE_TYPE() {
            return FlowProtocolComponent.PROTOCOL_SCALE_TYPE;
        }
    }

    static {
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(1.16f);
        Float[] fArr = {valueOf, valueOf, valueOf2, valueOf2, valueOf2};
        PROTOCOL_CUSTOM_RATIO_LIST = fArr;
        PROTOCOL_SCALE_TYPE = FontSizeHelper.addCustomerRatio(fArr);
    }

    public View createView() {
        getServiceExplainView().setOnClickListener(this);
        getWebPageView().setOnClickListener(this);
        View contentView = getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        this.avatarShowAnimator = ShowAndHideAnimHelperKt.createAlphaAnim$default(contentView, true, 0, false, 0.0f, 0.0f, (OnAlphaAnimateListener) null, 124, (Object) null);
        View contentView2 = getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView2, "contentView");
        this.avatarHideAnimator = ShowAndHideAnimHelperKt.createAlphaAnim$default(contentView2, false, 0, false, 0.0f, 0.0f, (OnAlphaAnimateListener) null, 124, (Object) null);
        updateInnerViewSize();
        View contentView3 = getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView3, "contentView");
        return contentView3;
    }

    public void onAttachToManager() {
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        FlowProtocolState $this$onAttachToManager_u24lambda_u2d9;
        super.onAttachToManager();
        IGroupControlService iGroupControlService = (IGroupControlService) getManager().getService(IGroupControlService.class);
        if (iGroupControlService != null) {
            iGroupControlService.registerGroupsAndListener(getGroupControlAreas(), getGroupControlListener());
        }
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d9 = (FlowProtocolState) $this$subscribe$iv.subscribe(FlowProtocolState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d9.getSetInitStyle().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d9.getTime().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d9.getArea().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d9.getData().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d9.isVisible().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda4(this));
            $this$onAttachToManager_u24lambda_u2d9.isShowOrHideAnim().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda5(this));
            $this$onAttachToManager_u24lambda_u2d9.getAlphaAndHeightAnim().observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda6(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && (fontSizeState = (FontSizeState) $this$subscribe$iv2.subscribe(FontSizeState.class)) != null && (action = fontSizeState.getAction()) != null) {
            action.observe(this, new FlowProtocolComponent$$ExternalSyntheticLambda7(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9$lambda-0  reason: not valid java name */
    public static final void m12370onAttachToManager$lambda9$lambda0(FlowProtocolComponent this$0, Integer style) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (style != null && style.intValue() == 0) {
            this$0.resetPublishTimeView();
            this$0.resetPublishAreaView();
            this$0.resetServiceView();
            this$0.getContentView().setVisibility(8);
        } else if (style != null && style.intValue() == 1) {
            this$0.getPublishTimeView().setText(this$0.getContext().getString(R.string.video_flow_protocol_publish_time_init_holder));
            this$0.getPublishTimeView().setVisibility(4);
            this$0.getContentView().setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9$lambda-2  reason: not valid java name */
    public static final void m12371onAttachToManager$lambda9$lambda2(FlowProtocolComponent this$0, String time) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView $this$onAttachToManager_u24lambda_u2d9_u24lambda_u2d2_u24lambda_u2d1 = this$0.getPublishTimeView();
        CharSequence charSequence = time;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Store<AbsState> store = this$0.getStore();
            if (!UBCManifestKt.isPageFromSearchFlow(store != null ? store.getState() : null)) {
                $this$onAttachToManager_u24lambda_u2d9_u24lambda_u2d2_u24lambda_u2d1.setText(time);
                $this$onAttachToManager_u24lambda_u2d9_u24lambda_u2d2_u24lambda_u2d1.setVisibility(0);
                return;
            }
        }
        this$0.resetPublishTimeView();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9$lambda-4  reason: not valid java name */
    public static final void m12372onAttachToManager$lambda9$lambda4(FlowProtocolComponent this$0, String area) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView $this$onAttachToManager_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3 = this$0.getPublishAreaView();
        CharSequence charSequence = area;
        if (!(charSequence == null || charSequence.length() == 0)) {
            $this$onAttachToManager_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.setText(area);
            $this$onAttachToManager_u24lambda_u2d9_u24lambda_u2d4_u24lambda_u2d3.setVisibility(0);
            return;
        }
        this$0.resetPublishAreaView();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9$lambda-5  reason: not valid java name */
    public static final void m12373onAttachToManager$lambda9$lambda5(FlowProtocolComponent this$0, ProtocolModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (model == null) {
            this$0.resetServiceView();
            return;
        }
        if (!(!StringsKt.isBlank(model.getServiceMessage())) || !(!StringsKt.isBlank(model.getServiceCmd()))) {
            this$0.getServiceExplainView().setVisibility(8);
        } else {
            this$0.getServiceExplainView().setText(model.getServiceMessage());
            this$0.getServiceExplainView().setVisibility(0);
        }
        if (!(!StringsKt.isBlank(model.getWebPageMessage())) || !(!StringsKt.isBlank(model.getWebPageCmd()))) {
            this$0.getWebPageView().setVisibility(8);
        } else {
            this$0.getWebPageView().setText(model.getWebPageMessage());
            this$0.getWebPageView().setVisibility(0);
        }
        if (this$0.getWebPageView().getVisibility() == 0 && this$0.getServiceExplainView().getVisibility() == 0) {
            this$0.getDividerView().setVisibility(0);
        } else {
            this$0.getDividerView().setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* renamed from: onAttachToManager$lambda-9$lambda-6  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m12374onAttachToManager$lambda9$lambda6(com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolComponent r6, java.lang.Boolean r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.animation.Animator r0 = r6.avatarShowAnimator
            android.animation.Animator r1 = r6.avatarHideAnimator
            com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt.cancelAlphaAnim(r0, r1)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r6.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0034
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0020
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            if (r3 == 0) goto L_0x002a
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState> r4 = com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x002b
        L_0x002a:
            r3 = r1
        L_0x002b:
            com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState r3 = (com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState) r3
            if (r3 == 0) goto L_0x0034
            boolean r0 = r3.isLeftAreaShow()
            goto L_0x0035
        L_0x0034:
            r0 = 1
        L_0x0035:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r6.getStore()
            if (r2 == 0) goto L_0x005e
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r2.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0047
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0048
        L_0x0047:
            r4 = r1
        L_0x0048:
            if (r4 == 0) goto L_0x0051
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState> r5 = com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0052
        L_0x0051:
            r4 = r1
        L_0x0052:
            com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState r4 = (com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState) r4
            if (r4 == 0) goto L_0x005e
            boolean r1 = r4.isLongPressing()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x005e:
            boolean r1 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r1)
            android.view.View r2 = r6.getContentView()
            java.lang.String r3 = "isVisible"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            boolean r3 = r7.booleanValue()
            if (r3 == 0) goto L_0x0078
            if (r0 == 0) goto L_0x0078
            if (r1 != 0) goto L_0x0078
            r3 = 0
            goto L_0x007a
        L_0x0078:
            r3 = 8
        L_0x007a:
            r2.setVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolComponent.m12374onAttachToManager$lambda9$lambda6(com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolComponent, java.lang.Boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9$lambda-7  reason: not valid java name */
    public static final void m12375onAttachToManager$lambda9$lambda7(FlowProtocolComponent this$0, Boolean isShowOrHideAnim) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animator animator = this$0.avatarShowAnimator;
        Animator animator2 = this$0.avatarHideAnimator;
        Intrinsics.checkNotNullExpressionValue(isShowOrHideAnim, "isShowOrHideAnim");
        boolean booleanValue = isShowOrHideAnim.booleanValue();
        View contentView = this$0.getContentView();
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        ShowAndHideAnimHelperKt.switchAlphaAnim$default(animator, animator2, booleanValue, contentView, 0.0f, 0.0f, 48, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-9$lambda-8  reason: not valid java name */
    public static final void m12376onAttachToManager$lambda9$lambda8(FlowProtocolComponent this$0, Boolean isShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.contentTotalHeight == 0) {
            this$0.contentTotalHeight = this$0.getContentView().getHeight();
        }
        boolean z = true;
        if (Intrinsics.areEqual((Object) isShow, (Object) true)) {
            AnimatorSet animatorSet = this$0.showAnimatorSet;
            if (!(animatorSet != null && animatorSet.isRunning())) {
                if (this$0.showAnimatorSet == null) {
                    int i2 = this$0.contentTotalHeight;
                    View contentView = this$0.getContentView();
                    Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
                    this$0.showAnimatorSet = ShowOrHideAndHeightChangeAnimKt.createShowAnimSet(i2, contentView);
                }
                AnimatorSet animatorSet2 = this$0.showAnimatorSet;
                if (animatorSet2 != null) {
                    animatorSet2.start();
                    return;
                }
                return;
            }
        }
        if (Intrinsics.areEqual((Object) isShow, (Object) false)) {
            AnimatorSet animatorSet3 = this$0.showAnimatorSet;
            if (animatorSet3 == null || !animatorSet3.isRunning()) {
                z = false;
            }
            if (!z) {
                if (this$0.hideAnimatorSet == null) {
                    int i3 = this$0.contentTotalHeight;
                    View contentView2 = this$0.getContentView();
                    Intrinsics.checkNotNullExpressionValue(contentView2, "contentView");
                    this$0.hideAnimatorSet = ShowOrHideAndHeightChangeAnimKt.createHideAnimSet(i3, contentView2, (Function0<Unit>) null);
                }
                AnimatorSet animatorSet4 = this$0.hideAnimatorSet;
                if (animatorSet4 != null) {
                    animatorSet4.start();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-10  reason: not valid java name */
    public static final void m12369onAttachToManager$lambda10(FlowProtocolComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateInnerViewSize();
    }

    private final void resetPublishAreaView() {
        TextView $this$resetPublishAreaView_u24lambda_u2d11 = getPublishAreaView();
        $this$resetPublishAreaView_u24lambda_u2d11.setText("");
        $this$resetPublishAreaView_u24lambda_u2d11.setVisibility(8);
    }

    private final void resetPublishTimeView() {
        TextView $this$resetPublishTimeView_u24lambda_u2d12 = getPublishTimeView();
        $this$resetPublishTimeView_u24lambda_u2d12.setText("");
        $this$resetPublishTimeView_u24lambda_u2d12.setVisibility(8);
    }

    private final void resetServiceView() {
        getServiceExplainView().setVisibility(8);
        getWebPageView().setVisibility(8);
        getDividerView().setVisibility(8);
    }

    private final void updateInnerViewSize() {
        TextView publishTimeView = getPublishTimeView();
        int i2 = PROTOCOL_SCALE_TYPE;
        FontSizeTextViewExtKt.setScaledSizeRes$default(publishTimeView, i2, R.dimen.video_flow_dimens_11dp, 0, 4, (Object) null);
        int i3 = i2;
        FontSizeTextViewExtKt.setScaledSizeRes$default(getPublishAreaView(), i3, R.dimen.video_flow_dimens_11dp, 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledSizeRes$default(getDividerView(), i3, R.dimen.video_flow_dimens_1dp, com.baidu.searchbox.feed.styles.R.dimen.F_M_T_X06, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSizeRes$default(getServiceExplainView(), i3, R.dimen.video_flow_dimens_11dp, 0, 4, (Object) null);
        FontSizeTextViewExtKt.setScaledSizeRes$default(getWebPageView(), i3, R.dimen.video_flow_dimens_11dp, 0, 4, (Object) null);
    }

    public void onClick(View view2) {
        Store<AbsState> store;
        Integer num = null;
        boolean z = false;
        if (view2 != null && ReClickUtilKt.enableReClick$default(view2, 0, 1, (Object) null)) {
            z = true;
        }
        if (z) {
            if (view2 != null) {
                num = Integer.valueOf(view2.getId());
            }
            int i2 = R.id.service_explain;
            if (num != null && num.intValue() == i2) {
                Store<AbsState> store2 = getStore();
                if (store2 != null) {
                    store2.dispatch(new FlowServiceExplainClickAction());
                    return;
                }
                return;
            }
            int i3 = R.id.view_webpage;
            if (num != null && num.intValue() == i3 && (store = getStore()) != null) {
                store.dispatch(new FlowWebPageClickAction());
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        IGroupControlService iGroupControlService = (IGroupControlService) getManager().getService(IGroupControlService.class);
        if (iGroupControlService != null) {
            iGroupControlService.unregisterGroupsAndListener(getGroupControlAreas(), getGroupControlListener());
        }
        ShowAndHideAnimHelperKt.releaseAlphaAnim(this.avatarShowAnimator, this.avatarHideAnimator);
        AnimatorSet $this$onDestroy_u24lambda_u2d13 = this.showAnimatorSet;
        if ($this$onDestroy_u24lambda_u2d13 != null) {
            $this$onDestroy_u24lambda_u2d13.removeAllListeners();
            if ($this$onDestroy_u24lambda_u2d13.isRunning()) {
                $this$onDestroy_u24lambda_u2d13.cancel();
            }
        }
        AnimatorSet $this$onDestroy_u24lambda_u2d14 = this.hideAnimatorSet;
        if ($this$onDestroy_u24lambda_u2d14 != null) {
            $this$onDestroy_u24lambda_u2d14.removeAllListeners();
            if ($this$onDestroy_u24lambda_u2d14.isRunning()) {
                $this$onDestroy_u24lambda_u2d14.cancel();
            }
        }
    }
}
