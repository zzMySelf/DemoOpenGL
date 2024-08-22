package com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel;

import com.baidu.android.ext.widget.toast.ToastLocation;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/shortplay/shortplaypaypanel/ShortPlayPayPanelPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "invokePayPanel", "", "model", "Lcom/baidu/searchbox/video/feedflow/detail/payment/shortplay/shortplaypaypanel/ShowShortPlayPayPanel;", "onAttachToManager", "showPayToast", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPayPanelPlugin.kt */
public final class ShortPlayPayPanelPlugin extends LiveDataPlugin {
    public void onAttachToManager() {
        ShortPlayPayPanelState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d2 = (ShortPlayPayPanelState) $this$subscribe$iv.subscribe(ShortPlayPayPanelState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d2.getShowShortPlayPayPanel().observe(this, new ShortPlayPayPanelPlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d2.getShowPayToast().observe(this, new ShortPlayPayPanelPlugin$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-0  reason: not valid java name */
    public static final void m12084onAttachToManager$lambda2$lambda0(ShortPlayPayPanelPlugin this$0, ShowShortPlayPayPanel payModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(payModel, "payModel");
        this$0.invokePayPanel(payModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m12085onAttachToManager$lambda2$lambda1(ShortPlayPayPanelPlugin this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPayToast();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void invokePayPanel(com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShowShortPlayPayPanel r22) {
        /*
            r21 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r21.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            boolean r0 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r0)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0084
            com.baidu.searchbox.feed.detail.frame.Store r0 = r21.getStore()
            if (r0 == 0) goto L_0x0040
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0029
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x002a
        L_0x0029:
            r5 = r1
        L_0x002a:
            if (r5 == 0) goto L_0x0033
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r6 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0034
        L_0x0033:
            r5 = r1
        L_0x0034:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r5
            if (r5 == 0) goto L_0x0040
            boolean r0 = r5.getShowing()
            if (r0 != r2) goto L_0x0040
            r0 = r2
            goto L_0x0041
        L_0x0040:
            r0 = r3
        L_0x0041:
            if (r0 == 0) goto L_0x0072
            com.baidu.searchbox.feed.detail.frame.Store r0 = r21.getStore()
            if (r0 == 0) goto L_0x0069
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0055
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0056
        L_0x0055:
            r5 = r1
        L_0x0056:
            if (r5 == 0) goto L_0x005f
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r6 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0060
        L_0x005f:
            r5 = r1
        L_0x0060:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r5
            if (r5 == 0) goto L_0x0069
            androidx.lifecycle.MutableLiveData r0 = r5.getDismissPanel()
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            if (r0 != 0) goto L_0x006d
            goto L_0x0072
        L_0x006d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r0.setValue(r4)
        L_0x0072:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r21.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r4 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r4)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r0 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r0
            if (r0 == 0) goto L_0x0084
            r4 = -1
            r0.switchToHalf(r4)
        L_0x0084:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r21.getManager()
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService> r4 = com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r4)
            com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService r0 = (com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService) r0
            if (r0 == 0) goto L_0x0095
            r0.setPlayerOrientationEnable(r3)
        L_0x0095:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r21.getStore()
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r21.getManager()
            java.lang.String r5 = r22.getCollId()
            com.baidu.searchbox.feed.detail.frame.Store r6 = r21.getStore()
            if (r6 == 0) goto L_0x00c7
            r7 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r6.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x00b3
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x00b4
        L_0x00b3:
            r8 = r1
        L_0x00b4:
            if (r8 == 0) goto L_0x00bd
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayPanelState> r9 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayPanelState.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x00be
        L_0x00bd:
            r8 = r1
        L_0x00be:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayPanelState r8 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayPanelState) r8
            if (r8 == 0) goto L_0x00c7
            java.lang.String r6 = r8.getExt()
            goto L_0x00c8
        L_0x00c7:
            r6 = r1
        L_0x00c8:
            if (r6 != 0) goto L_0x00cc
            java.lang.String r6 = ""
        L_0x00cc:
            java.lang.String r7 = r22.getCollType()
            java.lang.String r0 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPayPanelHelperKt.wrapShortPayExtInfo(r0, r4, r5, r6, r7)
            java.lang.String r4 = r22.getCollId()
            r5 = 2
            java.lang.String r6 = "sv_"
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r4, r6, r3, r5, r1)
            if (r3 == 0) goto L_0x00e7
            java.lang.String r3 = r22.getCollId()
            goto L_0x00fc
        L_0x00e7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r4 = r22.getCollId()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x00fc:
            r9 = r3
            com.baidu.searchbox.feed.detail.frame.Store r3 = r21.getStore()
            if (r3 == 0) goto L_0x012f
            com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayClickAction r4 = new com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction$PayClickAction
            com.baidu.searchbox.feed.detail.frame.Store r5 = r21.getStore()
            if (r5 == 0) goto L_0x0112
            com.baidu.searchbox.feed.detail.frame.State r5 = r5.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r5 = (com.baidu.searchbox.feed.detail.frame.AbsState) r5
            goto L_0x0113
        L_0x0112:
            r5 = r1
        L_0x0113:
            java.lang.String r11 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(r5)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 0
            r18 = 1
            r19 = 120(0x78, float:1.68E-43)
            r20 = 0
            r8 = r4
            r10 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            com.baidu.searchbox.feed.detail.frame.Action r4 = (com.baidu.searchbox.feed.detail.frame.Action) r4
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r3, r4)
        L_0x012f:
            com.baidu.searchbox.feed.detail.frame.Store r3 = r21.getStore()
            if (r3 == 0) goto L_0x014c
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0141
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0142
        L_0x0141:
            r5 = r1
        L_0x0142:
            if (r5 == 0) goto L_0x014a
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState> r1 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState.class
            java.lang.Object r1 = r5.select(r1)
        L_0x014a:
            com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState r1 = (com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideState) r1
        L_0x014c:
            if (r1 != 0) goto L_0x014f
            goto L_0x0152
        L_0x014f:
            r1.setFromAutoUnlockAd(r2)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShortPlayPayPanelPlugin.invokePayPanel(com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.ShowShortPlayPayPanel):void");
    }

    private final void showPayToast() {
        String successToastText;
        Store<AbsState> store;
        Store $this$select$iv = getStore();
        Integer num = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            ShortPlayPaymentGuideState shortPlayPaymentGuideState = (ShortPlayPaymentGuideState) (commonState != null ? commonState.select(ShortPlayPaymentGuideState.class) : null);
            if (shortPlayPaymentGuideState != null) {
                num = Integer.valueOf(shortPlayPaymentGuideState.getPayResult());
            }
        }
        if (num != null && num.intValue() == 0) {
            successToastText = getContext().getString(R.string.video_flow_short_play_pay_cancel);
        } else if (num != null && num.intValue() == 3) {
            successToastText = getContext().getString(R.string.video_flow_short_play_unlock_success);
        } else {
            successToastText = "";
        }
        Intrinsics.checkNotNullExpressionValue(successToastText, "when (store?.select<Shor…   else -> {\"\"}\n        }");
        if ((successToastText.length() > 0) && (store = getStore()) != null) {
            StoreExtKt.post(store, new ToastAction.SolidShow(0, successToastText, 0, (ToastAction) null, (ToastLocation) null, (ToastTemplate) null, 0, 0, (CharSequence) null, (ToastRightAreaStyle) null, (Action) null, 2045, (DefaultConstructorMarker) null));
        }
    }
}
