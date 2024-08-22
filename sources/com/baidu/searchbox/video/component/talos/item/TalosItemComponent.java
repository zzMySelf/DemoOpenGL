package com.baidu.searchbox.video.component.talos.item;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.talos.TalosConfig;
import com.baidu.searchbox.video.detail.export.ITalosCommonUtils;
import com.baidu.searchbox.video.widget.talos.TalosCommonContainer;
import com.baidu.talos.view.Container;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0014J\b\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/video/component/talos/item/TalosItemComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "talosView", "Lcom/baidu/searchbox/video/widget/talos/TalosCommonContainer;", "getTalosView", "()Lcom/baidu/searchbox/video/widget/talos/TalosCommonContainer;", "talosView$delegate", "Lkotlin/Lazy;", "attachToRoot", "", "buildBizParams", "Landroid/os/Bundle;", "config", "Lcom/baidu/searchbox/video/component/talos/TalosConfig;", "createTalosView", "createView", "Landroid/view/View;", "getPageUUID", "", "onAttachToManager", "onRelease", "onTalosExtraData", "data", "pauseTalos", "preCreateView", "resumeTalos", "sendEnterEvent", "sendLeaveEvent", "setActive", "isActive", "", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosItemComponent.kt */
public class TalosItemComponent extends LiveDataComponent {
    private final Lazy talosView$delegate = BdPlayerUtils.lazyNone(new TalosItemComponent$talosView$2(this));

    /* access modifiers changed from: protected */
    public final TalosCommonContainer getTalosView() {
        return (TalosCommonContainer) this.talosView$delegate.getValue();
    }

    public View createView() {
        return getTalosView();
    }

    public void onAttachToManager() {
        TalosItemState $this$onAttachToManager_u24lambda_u2d4;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || (coreState = (CoreState) $this$subscribe$iv.subscribe(CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new TalosItemComponent$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d4 = (TalosItemState) $this$subscribe$iv2.subscribe(TalosItemState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d4.getOnBindData().observe(this, new TalosItemComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d4.getJsLoadSuccess().observe(this, new TalosItemComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d4.getTlsExtraData().observe(this, new TalosItemComponent$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: onAttachToManager$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5249onAttachToManager$lambda0(com.baidu.searchbox.video.component.talos.item.TalosItemComponent r5, com.baidu.searchbox.feed.detail.arch.ext.NestedAction r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnPageSelected
            if (r0 == 0) goto L_0x0046
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            if (r0 == 0) goto L_0x003f
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r4 = 0
            if (r3 == 0) goto L_0x001e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x001f
        L_0x001e:
            r2 = r4
        L_0x001f:
            if (r2 == 0) goto L_0x0027
            java.lang.Class<com.baidu.searchbox.video.component.talos.item.TalosItemState> r3 = com.baidu.searchbox.video.component.talos.item.TalosItemState.class
            java.lang.Object r4 = r2.select(r3)
        L_0x0027:
            com.baidu.searchbox.video.component.talos.item.TalosItemState r4 = (com.baidu.searchbox.video.component.talos.item.TalosItemState) r4
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.MutableLiveData r0 = r4.getJsLoadSuccess()
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r0.getValue()
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x004d
            r5.sendEnterEvent()
            goto L_0x004d
        L_0x0046:
            boolean r0 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x004d
            r5.sendLeaveEvent()
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.component.talos.item.TalosItemComponent.m5249onAttachToManager$lambda0(com.baidu.searchbox.video.component.talos.item.TalosItemComponent, com.baidu.searchbox.feed.detail.arch.ext.NestedAction):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r6.isActive() == true) goto L_0x0038;
     */
    /* renamed from: onAttachToManager$lambda-4$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5250onAttachToManager$lambda4$lambda1(com.baidu.searchbox.video.component.talos.item.TalosItemComponent r7, com.baidu.searchbox.video.component.talos.TalosConfig r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            r7.preCreateView(r8)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0037
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0023
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0024
        L_0x0023:
            r4 = r6
        L_0x0024:
            if (r4 == 0) goto L_0x002c
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r5 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x002c:
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r6
            if (r6 == 0) goto L_0x0037
            boolean r0 = r6.isActive()
            if (r0 != r1) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r7.resumeTalos()
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.component.talos.item.TalosItemComponent.m5250onAttachToManager$lambda4$lambda1(com.baidu.searchbox.video.component.talos.item.TalosItemComponent, com.baidu.searchbox.video.component.talos.TalosConfig):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r6.isActive() == true) goto L_0x003b;
     */
    /* renamed from: onAttachToManager$lambda-4$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5251onAttachToManager$lambda4$lambda2(com.baidu.searchbox.video.component.talos.item.TalosItemComponent r7, java.lang.Boolean r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "isSuccess"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            boolean r0 = r8.booleanValue()
            if (r0 == 0) goto L_0x0040
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003a
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0026
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0027
        L_0x0026:
            r4 = r6
        L_0x0027:
            if (r4 == 0) goto L_0x002f
            java.lang.Class<com.baidu.searchbox.feed.detail.arch.ext.CoreState> r5 = com.baidu.searchbox.feed.detail.arch.ext.CoreState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x002f:
            com.baidu.searchbox.feed.detail.arch.ext.CoreState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CoreState) r6
            if (r6 == 0) goto L_0x003a
            boolean r0 = r6.isActive()
            if (r0 != r1) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r7.sendEnterEvent()
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.component.talos.item.TalosItemComponent.m5251onAttachToManager$lambda4$lambda2(com.baidu.searchbox.video.component.talos.item.TalosItemComponent, java.lang.Boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-4$lambda-3  reason: not valid java name */
    public static final void m5252onAttachToManager$lambda4$lambda3(TalosItemComponent this$0, String data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.onTalosExtraData(data);
    }

    public void setActive(boolean isActive) {
        super.setActive(isActive);
        if (isActive) {
            resumeTalos();
        } else {
            pauseTalos();
        }
    }

    private final void resumeTalos() {
        getTalosView().resume();
        getTalosView().sendLifeCycleEvent("resume");
    }

    private final void pauseTalos() {
        getTalosView().pause();
        getTalosView().sendLifeCycleEvent("pause");
    }

    private final void preCreateView(TalosConfig config) {
        createTalosView(config);
        attachToRoot();
    }

    private final void createTalosView(TalosConfig config) {
        if (config.checkValid()) {
            getTalosView().release();
            Bundle bizParams = buildBizParams(config);
            Bundle bundle = new Bundle();
            bundle.putBundle("bizparams", bizParams);
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ITalosCommonUtils.Impl.INSTANCE.get().addInitParams(activity, config.getBundleId(), bundle);
                TalosCommonContainer.createVideoTalosView$default(getTalosView(), config.getBundleId(), config.getModuleName(), config.getBundleVersion(), bundle, (Container.StateListener) null, false, getPageUUID(), 48, (Object) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle buildBizParams(com.baidu.searchbox.video.component.talos.TalosConfig r10) {
        /*
            r9 = this;
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r1 = r0
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.Store r3 = r9.getStore()
            r4 = 0
            if (r3 == 0) goto L_0x0031
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x001f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0020
        L_0x001f:
            r6 = r4
        L_0x0020:
            if (r6 == 0) goto L_0x0029
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x002a
        L_0x0029:
            r6 = r4
        L_0x002a:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x0031
            java.lang.String r3 = r6.pd
            goto L_0x0032
        L_0x0031:
            r3 = r4
        L_0x0032:
            java.lang.String r5 = ""
            if (r3 != 0) goto L_0x0037
            r3 = r5
        L_0x0037:
            java.lang.String r6 = "pd"
            r1.putString(r6, r3)
            com.baidu.searchbox.feed.detail.frame.Store r3 = r9.getStore()
            if (r3 == 0) goto L_0x005f
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x004e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x004f
        L_0x004e:
            r7 = r4
        L_0x004f:
            if (r7 == 0) goto L_0x0058
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0059
        L_0x0058:
            r7 = r4
        L_0x0059:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x005f
            java.lang.String r4 = r7.page
        L_0x005f:
            if (r4 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r5 = r4
        L_0x0063:
            java.lang.String r3 = "page"
            r1.putString(r3, r5)
            java.lang.String r3 = "is_preload"
            java.lang.String r4 = "1"
            r1.putString(r3, r4)
            java.lang.String r3 = r10.getNid()
            java.lang.String r4 = "nid"
            r1.putString(r4, r3)
            java.lang.String r3 = r10.getExtData()
            java.lang.String r4 = "talosData"
            r1.putString(r4, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.component.talos.item.TalosItemComponent.buildBizParams(com.baidu.searchbox.video.component.talos.TalosConfig):android.os.Bundle");
    }

    /* access modifiers changed from: protected */
    public String getPageUUID() {
        return "";
    }

    private final void attachToRoot() {
        TalosCommonContainer.attachToRoot$default(getTalosView(), false, 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void sendEnterEvent() {
        MutableLiveData<TalosConfig> onBindData;
        TalosConfig value;
        Map values = new LinkedHashMap();
        values.put("eventType", "talosCardDidSelectedAction");
        Map info = new LinkedHashMap();
        Store $this$select$iv = getStore();
        String str = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            TalosItemState talosItemState = (TalosItemState) (commonState != null ? commonState.select(TalosItemState.class) : null);
            if (!(talosItemState == null || (onBindData = talosItemState.getOnBindData()) == null || (value = onBindData.getValue()) == null)) {
                str = value.getNid();
            }
        }
        if (str == null) {
            str = "";
        }
        info.put("nid", str);
        values.put("info", info);
        getTalosView().sendEvent("searchbox_flow_video_action", values);
    }

    private final void sendLeaveEvent() {
        MutableLiveData<TalosConfig> onBindData;
        TalosConfig value;
        Map values = new LinkedHashMap();
        values.put("eventType", "talosCardDidScrollOffAction");
        Map info = new LinkedHashMap();
        Store $this$select$iv = getStore();
        String str = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            TalosItemState talosItemState = (TalosItemState) (commonState != null ? commonState.select(TalosItemState.class) : null);
            if (!(talosItemState == null || (onBindData = talosItemState.getOnBindData()) == null || (value = onBindData.getValue()) == null)) {
                str = value.getNid();
            }
        }
        if (str == null) {
            str = "";
        }
        info.put("nid", str);
        values.put("info", info);
        getTalosView().sendEvent("searchbox_flow_video_action", values);
    }

    public void onRelease() {
        super.onRelease();
        getTalosView().release();
    }

    /* access modifiers changed from: protected */
    public void onTalosExtraData(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
