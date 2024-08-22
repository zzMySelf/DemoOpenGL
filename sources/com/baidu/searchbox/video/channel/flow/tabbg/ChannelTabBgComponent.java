package com.baidu.searchbox.video.channel.flow.tabbg;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.utils.TabUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/tabbg/ChannelTabBgComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "HEADER_COVER_PAD", "", "aboveView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAboveView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "aboveView$delegate", "Lkotlin/Lazy;", "backgroundConfig", "getBackgroundConfig", "()Ljava/lang/String;", "backgroundConfig$delegate", "rootContainer", "Landroid/widget/FrameLayout;", "getRootContainer", "()Landroid/widget/FrameLayout;", "rootContainer$delegate", "underView", "getUnderView", "underView$delegate", "createView", "Landroid/view/View;", "getBackgroundCover", "onAttachToManager", "", "onDestroy", "updateTabAboveBg", "updateTabUnderBg", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTabBgComponent.kt */
public final class ChannelTabBgComponent extends LiveDataComponent {
    private final String HEADER_COVER_PAD = "header_cover_pad";
    private final Lazy aboveView$delegate = BdPlayerUtils.lazyNone(new ChannelTabBgComponent$aboveView$2(this));
    private final Lazy backgroundConfig$delegate = BdPlayerUtils.lazyNone(ChannelTabBgComponent$backgroundConfig$2.INSTANCE);
    private final Lazy rootContainer$delegate = BdPlayerUtils.lazyNone(new ChannelTabBgComponent$rootContainer$2(this));
    private final Lazy underView$delegate = BdPlayerUtils.lazyNone(new ChannelTabBgComponent$underView$2(this));

    private final String getBackgroundConfig() {
        return (String) this.backgroundConfig$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SimpleDraweeView getAboveView() {
        return (SimpleDraweeView) this.aboveView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SimpleDraweeView getUnderView() {
        return (SimpleDraweeView) this.underView$delegate.getValue();
    }

    private final FrameLayout getRootContainer() {
        return (FrameLayout) this.rootContainer$delegate.getValue();
    }

    public View createView() {
        return getRootContainer();
    }

    public void onAttachToManager() {
        ChannelTabBgState $this$onAttachToManager_u24lambda_u2d2;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d2 = (ChannelTabBgState) $this$subscribe$iv.subscribe(ChannelTabBgState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d2.getCollapseState().observe(this, new ChannelTabBgComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d2.getTabSelected().observe(this, new ChannelTabBgComponent$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-0  reason: not valid java name */
    public static final void m4953onAttachToManager$lambda2$lambda0(ChannelTabBgComponent this$0, Boolean collapse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateTabAboveBg();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-2$lambda-1  reason: not valid java name */
    public static final void m4954onAttachToManager$lambda2$lambda1(ChannelTabBgComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateTabUnderBg();
        DIFactory.INSTANCE.postDelayed(new ChannelTabBgComponent$onAttachToManager$1$2$1(this$0), 500, "ChannelTabBgComponent");
    }

    /* access modifiers changed from: private */
    public final void updateTabAboveBg() {
        if (!TabUtilsKt.isInNaTheaterTab((Store<?>) getStore())) {
            Store<AbsState> store = getStore();
            boolean z = true;
            if (store == null || !TabUtilsKt.isInShortPlayTab((Store<?>) store)) {
                z = false;
            }
            if (!z && !TabUtilsKt.isInHotTab((Store<?>) getStore())) {
                getAboveView().setVisibility(8);
                return;
            }
        }
        getAboveView().setVisibility(0);
        getAboveView().setImageURI(getBackgroundCover());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r3 != null) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getBackgroundCover() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r8.getBackgroundConfig()     // Catch:{ JSONException -> 0x004f }
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ JSONException -> 0x004f }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x004f }
            if (r2 <= 0) goto L_0x0011
            r2 = 1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            if (r2 == 0) goto L_0x0050
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004f }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x004f }
            com.baidu.searchbox.feed.detail.frame.Store r3 = r8.getStore()     // Catch:{ JSONException -> 0x004f }
            r4 = 0
            if (r3 == 0) goto L_0x0041
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()     // Catch:{ JSONException -> 0x004f }
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x004f }
            if (r7 == 0) goto L_0x002c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6     // Catch:{ JSONException -> 0x004f }
            goto L_0x002d
        L_0x002c:
            r6 = r4
        L_0x002d:
            if (r6 == 0) goto L_0x0036
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r7 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r6 = r6.select(r7)     // Catch:{ JSONException -> 0x004f }
            goto L_0x0037
        L_0x0036:
            r6 = r4
        L_0x0037:
            com.baidu.searchbox.video.feedflow.tab.TabState r6 = (com.baidu.searchbox.video.feedflow.tab.TabState) r6     // Catch:{ JSONException -> 0x004f }
            if (r6 == 0) goto L_0x0041
            java.lang.String r3 = r6.getCurrentTabId()     // Catch:{ JSONException -> 0x004f }
            if (r3 != 0) goto L_0x0042
        L_0x0041:
            r3 = r0
        L_0x0042:
            org.json.JSONObject r3 = r2.optJSONObject(r3)     // Catch:{ JSONException -> 0x004f }
            if (r3 == 0) goto L_0x004e
            java.lang.String r4 = r8.HEADER_COVER_PAD     // Catch:{ JSONException -> 0x004f }
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x004f }
        L_0x004e:
            return r4
        L_0x004f:
            r1 = move-exception
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.flow.tabbg.ChannelTabBgComponent.getBackgroundCover():java.lang.String");
    }

    private final void updateTabUnderBg() {
        getUnderView().setBackgroundColor(-16777216);
        getUnderView().setVisibility(0);
    }

    public void onDestroy() {
        super.onDestroy();
        DIFactory.INSTANCE.removeCallbacks((Object) "ChannelTabBgComponent");
    }
}
