package com.baidu.nadcore.lp.reward.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.nadcore.webpanel.PanelPopupWindow;
import com.baidu.nadcore.webpanel.model.NadWebPanelModel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/nadcore/lp/reward/util/NadRewardWebPanelUtil;", "", "()V", "Companion", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardWebPanelUtil.kt */
public final class NadRewardWebPanelUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static WeakReference<PanelPopupWindow> panel;
    /* access modifiers changed from: private */
    public static boolean shouldCharge;
    /* access modifiers changed from: private */
    public static Runnable shouldChargeTask = new NadRewardWebPanelUtil$$ExternalSyntheticLambda0();

    @JvmStatic
    public static final void closePanelPop() {
        Companion.closePanelPop();
    }

    @JvmStatic
    public static final boolean isAutoPopShowing() {
        return Companion.isAutoPopShowing();
    }

    @JvmStatic
    public static final boolean isShowing() {
        return Companion.isShowing();
    }

    @JvmStatic
    public static final void resetPanelPop() {
        Companion.resetPanelPop();
    }

    @JvmStatic
    public static final void showPanelPop(Context context, NadWebPanelModel nadWebPanelModel) {
        Companion.showPanelPop(context, nadWebPanelModel);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\tH\u0007J\b\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\rH\u0007J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/nadcore/lp/reward/util/NadRewardWebPanelUtil$Companion;", "", "()V", "handler", "Landroid/os/Handler;", "panel", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/nadcore/webpanel/PanelPopupWindow;", "shouldCharge", "", "shouldChargeTask", "Ljava/lang/Runnable;", "closePanelPop", "", "isAutoPopShowing", "isShowing", "resetPanelPop", "showPanelPop", "context", "Landroid/content/Context;", "model", "Lcom/baidu/nadcore/webpanel/model/NadWebPanelModel;", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadRewardWebPanelUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
            r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0.get();
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void showPanelPop(android.content.Context r11, com.baidu.nadcore.webpanel.model.NadWebPanelModel r12) {
            /*
                r10 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.String r0 = "model"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                boolean r0 = com.baidu.nadcore.webpanel.util.FastClickUtils.isFastDoubleClick()
                if (r0 == 0) goto L_0x0011
                return
            L_0x0011:
                java.lang.ref.WeakReference r0 = com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.panel
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x0029
                java.lang.Object r0 = r0.get()
                com.baidu.nadcore.webpanel.PanelPopupWindow r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0
                if (r0 == 0) goto L_0x0029
                boolean r0 = r0.isShowing()
                if (r0 != r2) goto L_0x0029
                r0 = r2
                goto L_0x002a
            L_0x0029:
                r0 = r1
            L_0x002a:
                if (r0 == 0) goto L_0x002d
                return
            L_0x002d:
                long r3 = r12.getChargeDelayTime()
                r5 = -1
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 == 0) goto L_0x0046
                android.os.Handler r0 = com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.handler
                java.lang.Runnable r3 = com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.shouldChargeTask
                long r4 = r12.getChargeDelayTime()
                r0.postDelayed(r3, r4)
            L_0x0046:
                boolean r0 = r11 instanceof android.app.Activity
                if (r0 != 0) goto L_0x0057
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Error, WebPanel need context is Activity."
                r0.<init>(r1)
                java.lang.Exception r0 = (java.lang.Exception) r0
                com.baidu.nadcore.webview.util.DebugLogger.throwException(r0)
                return
            L_0x0057:
                long r3 = java.lang.System.currentTimeMillis()
                com.baidu.nadcore.webpanel.PanelPopupWindow r0 = new com.baidu.nadcore.webpanel.PanelPopupWindow
                com.baidu.nadcore.lp.reward.ioc.INadRewardUIProvider r5 = com.baidu.nadcore.lp.reward.ioc.NadRewardVideoLpRuntime.getUIProvider()
                int r5 = r5.getPanelPopUI()
                r0.<init>(r11, r5)
                r5 = r0
                r6 = 0
                com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil$Companion$showPanelPop$panelPopup$1$1 r7 = new com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil$Companion$showPanelPop$panelPopup$1$1
                r7.<init>(r12, r3)
                com.baidu.nadcore.webpanel.interfaces.IPopUpWindowListener r7 = (com.baidu.nadcore.webpanel.interfaces.IPopUpWindowListener) r7
                r5.setPopUpWindowListener(r7)
                r7 = r12
                r8 = 0
                r7.setRewardVideo(r2)
                r7.setShowTopRightIcon(r2)
                boolean r9 = r7.getAutoPopup()
                r9 = r9 ^ r2
                r7.setShowDownArrow(r9)
                boolean r9 = r7.getAutoPopup()
                r7.setForbidClosePanel(r9)
                boolean r9 = r7.getAutoPopup()
                r7.setForbidMoveFollowHand(r9)
                r7.setForbidMoveUpFollowHand(r2)
                r7.setPanelDismissControlByH5(r1)
                r5.setPanelData(r12)
                r5.showPanelPopWindow()
                java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
                r1.<init>(r0)
                com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.panel = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.Companion.showPanelPop(android.content.Context, com.baidu.nadcore.webpanel.model.NadWebPanelModel):void");
        }

        @JvmStatic
        public final void closePanelPop() {
            PanelPopupWindow panelPopupWindow;
            WeakReference access$getPanel$cp = NadRewardWebPanelUtil.panel;
            if (!(access$getPanel$cp == null || (panelPopupWindow = (PanelPopupWindow) access$getPanel$cp.get()) == null)) {
                panelPopupWindow.closePanelForReset();
            }
            resetPanelPop();
        }

        @JvmStatic
        public final void resetPanelPop() {
            NadRewardWebPanelUtil.handler.removeCallbacks(NadRewardWebPanelUtil.shouldChargeTask);
            NadRewardWebPanelUtil.shouldCharge = false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0.get();
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean isShowing() {
            /*
                r3 = this;
                java.lang.ref.WeakReference r0 = com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.panel
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0017
                java.lang.Object r0 = r0.get()
                com.baidu.nadcore.webpanel.PanelPopupWindow r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0
                if (r0 == 0) goto L_0x0017
                boolean r0 = r0.isShowing()
                if (r0 != r1) goto L_0x0017
                goto L_0x0018
            L_0x0017:
                r1 = r2
            L_0x0018:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.Companion.isShowing():boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0.get();
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean isAutoPopShowing() {
            /*
                r3 = this;
                java.lang.ref.WeakReference r0 = com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.panel
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0018
                java.lang.Object r0 = r0.get()
                com.baidu.nadcore.webpanel.PanelPopupWindow r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0
                if (r0 == 0) goto L_0x0018
                boolean r0 = r0.isShowing()
                if (r0 != r1) goto L_0x0018
                r0 = r1
                goto L_0x0019
            L_0x0018:
                r0 = r2
            L_0x0019:
                if (r0 == 0) goto L_0x003b
                java.lang.ref.WeakReference r0 = com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.panel
                if (r0 == 0) goto L_0x0037
                java.lang.Object r0 = r0.get()
                com.baidu.nadcore.webpanel.PanelPopupWindow r0 = (com.baidu.nadcore.webpanel.PanelPopupWindow) r0
                if (r0 == 0) goto L_0x0037
                com.baidu.nadcore.webpanel.model.NadWebPanelModel r0 = r0.getModel()
                if (r0 == 0) goto L_0x0037
                boolean r0 = r0.getAutoPopup()
                if (r0 != r1) goto L_0x0037
                r0 = r1
                goto L_0x0038
            L_0x0037:
                r0 = r2
            L_0x0038:
                if (r0 == 0) goto L_0x003b
                goto L_0x003c
            L_0x003b:
                r1 = r2
            L_0x003c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nadcore.lp.reward.util.NadRewardWebPanelUtil.Companion.isAutoPopShowing():boolean");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldChargeTask$lambda-0  reason: not valid java name */
    public static final void m14074shouldChargeTask$lambda0() {
        shouldCharge = true;
    }
}
