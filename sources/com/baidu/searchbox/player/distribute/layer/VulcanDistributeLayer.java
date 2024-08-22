package com.baidu.searchbox.player.distribute.layer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.callback.BaseVulcanVideoPlayerCallbackManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.distribute.element.ExtServiceEnterElement;
import com.baidu.searchbox.player.distribute.element.RightBottomShowingElement;
import com.baidu.searchbox.player.distribute.element.RightEnterElement;
import com.baidu.searchbox.player.element.AbsElement;
import com.baidu.searchbox.player.layer.ElementLayer;
import com.baidu.searchbox.player.slot.DistributeSlotManifest;
import com.baidu.searchbox.player.slot.ISlot;
import com.baidu.searchbox.player.slot.ISlotView;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.player.widget.VulcanDistributePanelPopupWindow;
import com.baidu.searchbox.player.widget.VulcanLandDragFrameLayout;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001c\u0010#\u001a\u00020\u001e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%H\u0004J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u001e2\b\b\u0002\u00100\u001a\u000201H\u0004J\b\u00102\u001a\u00020\u001eH\u0014J\b\u00103\u001a\u000201H\u0002J\u0006\u00104\u001a\u000201J\u0006\u00105\u001a\u000201J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u001eH\u0016J\u001c\u0010:\u001a\u00020\u001e2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J\u0018\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020'H\u0016J\u000e\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u00020\u001eH\u0014J\u0010\u0010E\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020 H\u0002J\u0010\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u001cH\u0002J\u0006\u0010H\u001a\u00020\u001eJ\u000e\u0010I\u001a\u000201*\u0004\u0018\u00010 H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/baidu/searchbox/player/distribute/layer/VulcanDistributeLayer;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/player/element/AbsElement;", "()V", "distributePanel", "Lcom/baidu/searchbox/player/widget/VulcanDistributePanelPopupWindow;", "getDistributePanel", "()Lcom/baidu/searchbox/player/widget/VulcanDistributePanelPopupWindow;", "distributePanel$delegate", "Lkotlin/Lazy;", "distributePanelSlotManager", "Lcom/baidu/searchbox/player/distribute/layer/DistributeSlotManager;", "getDistributePanelSlotManager", "()Lcom/baidu/searchbox/player/distribute/layer/DistributeSlotManager;", "distributePanelSlotManager$delegate", "dragFrameLayout", "Lcom/baidu/searchbox/player/widget/VulcanLandDragFrameLayout;", "getDragFrameLayout", "()Lcom/baidu/searchbox/player/widget/VulcanLandDragFrameLayout;", "dragFrameLayout$delegate", "extServiceEnterElement", "Lcom/baidu/searchbox/player/distribute/element/ExtServiceEnterElement;", "rightBottomShowingElement", "Lcom/baidu/searchbox/player/distribute/element/RightBottomShowingElement;", "rightEnterElement", "Lcom/baidu/searchbox/player/distribute/element/RightEnterElement;", "scaleAnimShrinkRatio", "", "addExtServiceEnterElement", "", "view", "Landroid/view/View;", "addRightBottomShowingElement", "addRightEnterView", "addSlot", "slots", "", "Lcom/baidu/searchbox/player/slot/ISlot;", "Lcom/baidu/searchbox/player/slot/ISlotView;", "attachPanelContentToContainer", "contentView", "detachPanelContentFromContainer", "getBindPlayer", "Lcom/baidu/searchbox/player/BaseVulcanVideoPlayer;", "getSubscribeEvent", "", "hideDistributePanel", "withAnimation", "", "initContainer", "isExtServiceEnterContainsValidView", "isRightBottomSlotContainsValidView", "isRightEnterViewVisible", "onLayerEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "onLayerRelease", "onPlayerStatusChanged", "status", "Lcom/baidu/searchbox/player/constants/PlayerStatus;", "old", "registerSlot", "slot", "slotView", "setRightEnterViewVisibility", "visibility", "", "setupElement", "showDistributePanel", "updatePlayerScale", "changeRatio", "updateSlotViewLayoutParams", "slotContainsValidView", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanDistributeLayer.kt */
public class VulcanDistributeLayer extends ElementLayer<FrameLayout, AbsElement> {
    private final Lazy distributePanel$delegate = BdPlayerUtils.lazyNone(new VulcanDistributeLayer$distributePanel$2(this));
    private final Lazy distributePanelSlotManager$delegate = BdPlayerUtils.lazyNone(VulcanDistributeLayer$distributePanelSlotManager$2.INSTANCE);
    private final Lazy dragFrameLayout$delegate = BdPlayerUtils.lazyNone(new VulcanDistributeLayer$dragFrameLayout$2(this));
    private ExtServiceEnterElement extServiceEnterElement;
    private RightBottomShowingElement rightBottomShowingElement;
    private RightEnterElement rightEnterElement;
    /* access modifiers changed from: private */
    public float scaleAnimShrinkRatio;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VulcanDistributeLayer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerStatus.values().length];
            iArr[PlayerStatus.STOP.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final DistributeSlotManager getDistributePanelSlotManager() {
        return (DistributeSlotManager) this.distributePanelSlotManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final VulcanLandDragFrameLayout getDragFrameLayout() {
        return (VulcanLandDragFrameLayout) this.dragFrameLayout$delegate.getValue();
    }

    private final VulcanDistributePanelPopupWindow getDistributePanel() {
        return (VulcanDistributePanelPopupWindow) this.distributePanel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void initContainer() {
        FrameLayout $this$initContainer_u24lambda_u2d0 = new FrameLayout(this.mContext);
        $this$initContainer_u24lambda_u2d0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mContainer = $this$initContainer_u24lambda_u2d0;
    }

    /* access modifiers changed from: protected */
    public void setupElement() {
        ExtServiceEnterElement extServiceEnterElement2 = new ExtServiceEnterElement();
        this.extServiceEnterElement = extServiceEnterElement2;
        addElement(extServiceEnterElement2);
        RightBottomShowingElement rightBottomShowingElement2 = new RightBottomShowingElement();
        this.rightBottomShowingElement = rightBottomShowingElement2;
        addElement(rightBottomShowingElement2);
        RightEnterElement rightEnterElement2 = new RightEnterElement();
        this.rightEnterElement = rightEnterElement2;
        addElement(rightEnterElement2);
    }

    public BaseVulcanVideoPlayer getBindPlayer() {
        BDVideoPlayer bindPlayer = super.getBindPlayer();
        if (bindPlayer instanceof BaseVulcanVideoPlayer) {
            return (BaseVulcanVideoPlayer) bindPlayer;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: android.view.ViewGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v27, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent r13) {
        /*
            r12 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            super.onLayerEventNotify(r13)
            java.lang.String r0 = r13.getAction()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = 0
            r4 = 0
            switch(r1) {
                case -2010923869: goto L_0x00fe;
                case -552580917: goto L_0x00d8;
                case -493373755: goto L_0x0080;
                case 280209477: goto L_0x0071;
                case 1836596335: goto L_0x005e;
                case 1836923434: goto L_0x003e;
                case 1992392616: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0122
        L_0x0018:
            java.lang.String r1 = "distribute_remove_right_center_slot"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0021
            goto L_0x0016
        L_0x0021:
            com.baidu.searchbox.player.distribute.element.RightEnterElement r0 = r12.rightEnterElement
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = "rightEnterElement"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r4
        L_0x002c:
            android.view.View r0 = r0.getContentView()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0037
            r4 = r0
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
        L_0x0037:
            if (r4 == 0) goto L_0x0122
            r4.removeAllViews()
            goto L_0x0122
        L_0x003e:
            java.lang.String r1 = "distribute_layer_content_panel_show"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0047
            goto L_0x0016
        L_0x0047:
            int r0 = r13.getIntExtra(r2)
            com.baidu.searchbox.player.distribute.layer.DistributeSlotManager r1 = r12.getDistributePanelSlotManager()
            android.view.View r1 = r1.getSlotView(r0)
            if (r1 == 0) goto L_0x005c
            r2 = 0
            r12.showDistributePanel(r1)
            goto L_0x0122
        L_0x005c:
            goto L_0x0122
        L_0x005e:
            java.lang.String r1 = "distribute_layer_content_panel_hide"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0067
            goto L_0x0016
        L_0x0067:
            r0 = 2
            boolean r0 = r13.getBooleanExtra(r0)
            r12.hideDistributePanel(r0)
            goto L_0x0122
        L_0x0071:
            java.lang.String r1 = "vulcan_airplay_start"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x007b
            goto L_0x0016
        L_0x007b:
            hideDistributePanel$default(r12, r3, r2, r4)
            goto L_0x0122
        L_0x0080:
            java.lang.String r1 = "action_add_slot"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0089
            goto L_0x0016
        L_0x0089:
            r0 = 1
            r1 = r13
            r2 = 0
            java.lang.Object r3 = r1.getExtra(r0)
            boolean r5 = r3 instanceof java.util.Map
            if (r5 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r4 = r3
        L_0x0096:
            java.util.Map r4 = (java.util.Map) r4
            if (r4 == 0) goto L_0x0122
            r0 = r4
            r1 = 0
            r2 = r0
            r3 = 0
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Map r4 = (java.util.Map) r4
            r5 = r2
            r6 = 0
            java.util.Set r7 = r5.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x00af:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00d1
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r9 = r8
            r10 = 0
            java.lang.Object r11 = r9.getKey()
            boolean r9 = r11 instanceof com.baidu.searchbox.player.slot.DistributeSlotManifest
            if (r9 == 0) goto L_0x00af
            java.lang.Object r9 = r8.getKey()
            java.lang.Object r10 = r8.getValue()
            r4.put(r9, r10)
            goto L_0x00af
        L_0x00d1:
            r12.addSlot(r4)
            goto L_0x0122
        L_0x00d8:
            java.lang.String r1 = "layer_event_switch_half"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e2
            goto L_0x0016
        L_0x00e2:
            android.view.ViewGroup r0 = r12.mContainer
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r0.setOnClickListener(r4)
            android.view.ViewGroup r0 = r12.mContainer
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r0.setClickable(r3)
            com.baidu.searchbox.player.widget.VulcanDistributePanelPopupWindow r0 = r12.getDistributePanel()
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x0122
            hideDistributePanel$default(r12, r3, r2, r4)
            goto L_0x0122
        L_0x00fe:
            java.lang.String r1 = "distribute_remove_ext_service_slot"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0108
            goto L_0x0016
        L_0x0108:
            com.baidu.searchbox.player.distribute.element.ExtServiceEnterElement r0 = r12.extServiceEnterElement
            if (r0 != 0) goto L_0x0112
            java.lang.String r0 = "extServiceEnterElement"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r4
        L_0x0112:
            android.view.View r0 = r0.getContentView()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x011d
            r4 = r0
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
        L_0x011d:
            if (r4 == 0) goto L_0x0122
            r4.removeAllViews()
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.distribute.layer.VulcanDistributeLayer.onLayerEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void onPlayerStatusChanged(PlayerStatus status, PlayerStatus old) {
        super.onPlayerStatusChanged(status, old);
        if ((status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) == 1) {
            BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
            if (bindPlayer != null && bindPlayer.isFullMode()) {
                hideDistributePanel$default(this, false, 1, (Object) null);
            }
        }
    }

    public void registerSlot(ISlot slot, ISlotView slotView) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(slotView, "slotView");
        if (slot instanceof DistributeSlotManifest.ExtServiceSlot) {
            addExtServiceEnterElement(slotView.getView());
        } else if (slot instanceof DistributeSlotManifest.RightBottomShowingSlot) {
            addRightBottomShowingElement(slotView.getView());
        } else if (slot instanceof DistributeSlotManifest.RightCenterSlot) {
            addRightEnterView(slotView.getView());
        } else if (slot instanceof DistributeSlotManifest.DistributePanelSlot) {
            getDistributePanelSlotManager().bindPanelSlot(((DistributeSlotManifest.DistributePanelSlot) slot).getId(), slotView);
        }
    }

    /* access modifiers changed from: protected */
    public final void addSlot(Map<ISlot, ? extends ISlotView> slots) {
        Intrinsics.checkNotNullParameter(slots, "slots");
        for (Map.Entry action : slots.entrySet()) {
            registerSlot((ISlot) action.getKey(), (ISlotView) action.getValue());
        }
    }

    private final void addExtServiceEnterElement(View view2) {
        ExtServiceEnterElement extServiceEnterElement2 = this.extServiceEnterElement;
        if (extServiceEnterElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extServiceEnterElement");
            extServiceEnterElement2 = null;
        }
        extServiceEnterElement2.addView(view2);
    }

    private final void addRightBottomShowingElement(View view2) {
        RightBottomShowingElement rightBottomShowingElement2 = this.rightBottomShowingElement;
        if (rightBottomShowingElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightBottomShowingElement");
            rightBottomShowingElement2 = null;
        }
        rightBottomShowingElement2.addView(view2);
    }

    private final void addRightEnterView(View view2) {
        RightEnterElement rightEnterElement2 = this.rightEnterElement;
        if (rightEnterElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterElement");
            rightEnterElement2 = null;
        }
        rightEnterElement2.addView(view2);
    }

    public final void updateSlotViewLayoutParams() {
        ExtServiceEnterElement extServiceEnterElement2 = this.extServiceEnterElement;
        if (extServiceEnterElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extServiceEnterElement");
            extServiceEnterElement2 = null;
        }
        ExtServiceEnterElement.updateSlotViewLayoutParams$default(extServiceEnterElement2, false, 1, (Object) null);
    }

    public final void setRightEnterViewVisibility(int visibility) {
        RightEnterElement rightEnterElement2 = this.rightEnterElement;
        if (rightEnterElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterElement");
            rightEnterElement2 = null;
        }
        rightEnterElement2.getContentView().setVisibility(visibility);
    }

    public final boolean isRightEnterViewVisible() {
        RightEnterElement rightEnterElement2 = this.rightEnterElement;
        Integer num = null;
        if (rightEnterElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightEnterElement");
            rightEnterElement2 = null;
        }
        if (rightEnterElement2.getContentView().getVisibility() == 0) {
            RightEnterElement rightEnterElement3 = this.rightEnterElement;
            if (rightEnterElement3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightEnterElement");
                rightEnterElement3 = null;
            }
            View contentView = rightEnterElement3.getContentView();
            ViewGroup viewGroup = contentView instanceof ViewGroup ? (ViewGroup) contentView : null;
            if (viewGroup != null) {
                num = Integer.valueOf(viewGroup.getChildCount());
            }
            if (BdPlayerUtils.orZero(num) > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (slotContainsValidView(r1.getContentView()) == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isRightBottomSlotContainsValidView() {
        /*
            r3 = this;
            com.baidu.searchbox.player.distribute.element.RightBottomShowingElement r0 = r3.rightBottomShowingElement
            r1 = 0
            java.lang.String r2 = "rightBottomShowingElement"
            if (r0 != 0) goto L_0x000c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x000c:
            android.view.View r0 = r0.getContentView()
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0029
            com.baidu.searchbox.player.distribute.element.RightBottomShowingElement r0 = r3.rightBottomShowingElement
            if (r0 != 0) goto L_0x001e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x001f
        L_0x001e:
            r1 = r0
        L_0x001f:
            android.view.View r0 = r1.getContentView()
            boolean r0 = r3.slotContainsValidView(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0029:
            boolean r0 = r3.isExtServiceEnterContainsValidView()
            if (r0 == 0) goto L_0x0031
        L_0x002f:
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.distribute.layer.VulcanDistributeLayer.isRightBottomSlotContainsValidView():boolean");
    }

    private final boolean isExtServiceEnterContainsValidView() {
        ExtServiceEnterElement extServiceEnterElement2 = this.extServiceEnterElement;
        ExtServiceEnterElement extServiceEnterElement3 = null;
        if (extServiceEnterElement2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extServiceEnterElement");
            extServiceEnterElement2 = null;
        }
        if (extServiceEnterElement2.getContentView().getVisibility() == 0) {
            ExtServiceEnterElement extServiceEnterElement4 = this.extServiceEnterElement;
            if (extServiceEnterElement4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("extServiceEnterElement");
            } else {
                extServiceEnterElement3 = extServiceEnterElement4;
            }
            if (slotContainsValidView(extServiceEnterElement3.getContentView())) {
                return true;
            }
        }
        return false;
    }

    private final boolean slotContainsValidView(View $this$slotContainsValidView) {
        Integer num = null;
        ViewGroup viewGroup = $this$slotContainsValidView instanceof ViewGroup ? (ViewGroup) $this$slotContainsValidView : null;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup2 != null) {
            num = Integer.valueOf(viewGroup2.getHeight());
        }
        return BdPlayerUtils.orZero(num) > 0;
    }

    private final void showDistributePanel(View contentView) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        attachPanelContentToContainer(contentView);
        getDragFrameLayout().setVisibility(0);
        BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
        if (bindPlayer != null) {
            LayerUtil.updatePlayerScaleWithAnim(bindPlayer, true, new VulcanDistributeLayer$showDistributePanel$1(this));
        }
        VulcanDistributePanelPopupWindow.show$default(getDistributePanel(), this.mContainer, 0, 0, 0, 14, (Object) null);
        BaseVulcanVideoPlayer bindPlayer2 = getBindPlayer();
        if (bindPlayer2 != null && (playerCallbackManager = bindPlayer2.getPlayerCallbackManager()) != null) {
            playerCallbackManager.onDistributePanelVisibleChanged(true);
        }
    }

    public static /* synthetic */ void hideDistributePanel$default(VulcanDistributeLayer vulcanDistributeLayer, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            vulcanDistributeLayer.hideDistributePanel(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideDistributePanel");
    }

    /* access modifiers changed from: protected */
    public final void hideDistributePanel(boolean withAnimation) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        getDistributePanel().dismiss();
        if (!withAnimation) {
            getDragFrameLayout().setVisibility(8);
            detachPanelContentFromContainer();
        } else {
            BaseVulcanVideoPlayer bindPlayer = getBindPlayer();
            if (bindPlayer != null) {
                LayerUtil.updatePlayerScaleWithAnim(bindPlayer, false, new VulcanDistributeLayer$hideDistributePanel$1(this));
            }
        }
        BaseVulcanVideoPlayer bindPlayer2 = getBindPlayer();
        if (bindPlayer2 != null && (playerCallbackManager = bindPlayer2.getPlayerCallbackManager()) != null) {
            playerCallbackManager.onDistributePanelVisibleChanged(false);
        }
    }

    private final void attachPanelContentToContainer(View contentView) {
        detachPanelContentFromContainer();
        ViewParent parent = contentView.getParent();
        ViewGroup $this$attachPanelContentToContainer_u24lambda_u2d5 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if ($this$attachPanelContentToContainer_u24lambda_u2d5 != null) {
            $this$attachPanelContentToContainer_u24lambda_u2d5.removeView(contentView);
        }
        getDragFrameLayout().addView(contentView);
    }

    /* access modifiers changed from: private */
    public final void detachPanelContentFromContainer() {
        getDragFrameLayout().removeAllViews();
    }

    /* access modifiers changed from: private */
    public final void updatePlayerScale(float changeRatio) {
        BaseVulcanVideoPlayer bindPlayer;
        ViewGroup $this$updatePlayerScale_u24lambda_u2d6;
        if (changeRatio <= 1.0f && changeRatio >= 0.0f) {
            float f2 = this.scaleAnimShrinkRatio;
            float ratio = f2 + ((((float) 1) - f2) * changeRatio);
            if (!Float.isNaN(ratio) && (bindPlayer = getBindPlayer()) != null && ($this$updatePlayerScale_u24lambda_u2d6 = bindPlayer.getAttachedContainer()) != null) {
                $this$updatePlayerScale_u24lambda_u2d6.setScaleX(ratio);
                $this$updatePlayerScale_u24lambda_u2d6.setScaleY(ratio);
            }
        }
    }

    public void onLayerRelease() {
        super.onLayerRelease();
        getDistributePanelSlotManager().removeAllSlots();
    }

    public int[] getSubscribeEvent() {
        return new int[]{5, 3};
    }
}
