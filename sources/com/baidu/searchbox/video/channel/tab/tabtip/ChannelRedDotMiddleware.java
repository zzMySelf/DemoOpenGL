package com.baidu.searchbox.video.channel.tab.tabtip;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.flow.api.FlowListBean;
import com.baidu.searchbox.video.channel.VideoNewTabManifestKt;
import com.baidu.searchbox.video.channel.tab.ChannelRedDotManager;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.favor.favorshortguide.FavorShortGuideDataUtils;
import com.baidu.searchbox.video.feedflow.detail.favor.favorshortguide.FavorShortGuideDataUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.tabguide.BindTabBubbleData;
import com.baidu.searchbox.video.feedflow.detail.tabguide.ForceShowTabBubbleAction;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.tab.NewTipModel;
import com.baidu.searchbox.video.feedflow.tab.TabBubbleManager;
import com.baidu.searchbox.video.feedflow.tab.TabComponentAction;
import com.baidu.searchbox.video.feedflow.tab.TabInfoModel;
import com.baidu.searchbox.video.feedflow.tab.TabState;
import com.baidu.swan.apps.scheme.actions.history.GetSwanHistoryAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002J$\u0010\u001a\u001a\u00020\u00192\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J*\u0010\u001e\u001a\u00020\u00192\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u0015H\u0002J$\u0010!\u001a\u00020\u00192\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/tabtip/ChannelRedDotMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "hasShownBubble", "", "hasTryShowRedDot", "isCodeEnter", "needShowCommonTabBubble", "needShowHomeOperateBubble", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "canShowRedDot", "data", "Lcom/baidu/searchbox/flowvideo/flow/api/FlowListBean;", "generateColorJson", "", "lightColor", "nightColor", "tryBindShortBubbleData", "", "tryBindTabBubbleData", "itemList", "", "Lcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;", "tryShowRedDot", "tabId", "dotText", "tryShowTabBubble", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRedDotMiddleware.kt */
public final class ChannelRedDotMiddleware implements Middleware<CommonState> {
    private boolean hasShownBubble;
    private boolean hasTryShowRedDot;
    private boolean isCodeEnter = true;
    private boolean needShowCommonTabBubble;
    private boolean needShowHomeOperateBubble;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.Iterable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.lang.Iterable} */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v14, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v17, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.lang.String] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.Action apply(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r24, com.baidu.searchbox.feed.detail.frame.Action r25, com.baidu.searchbox.feed.detail.frame.Next<com.baidu.searchbox.feed.detail.arch.ext.CommonState> r26) {
        /*
            r23 = this;
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "next"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.DetailItemSelected
            r1 = 0
            if (r0 == 0) goto L_0x0022
            r6.isCodeEnter = r1
            goto L_0x02e3
        L_0x0022:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.detail.tabguide.OnTabBubbleVisibleChange
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0047
            r0 = r8
            com.baidu.searchbox.video.feedflow.detail.tabguide.OnTabBubbleVisibleChange r0 = (com.baidu.searchbox.video.feedflow.detail.tabguide.OnTabBubbleVisibleChange) r0
            boolean r0 = r0.getVisible()
            if (r0 == 0) goto L_0x0035
            r6.hasShownBubble = r2
            goto L_0x02e3
        L_0x0035:
            r6.hasShownBubble = r1
            r6.needShowCommonTabBubble = r1
            r6.needShowHomeOperateBubble = r1
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$TryShowRedDot r0 = new com.baidu.searchbox.video.feedflow.tab.TabComponentAction$TryShowRedDot
            r0.<init>(r3, r2, r2, r3)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            goto L_0x02e3
        L_0x0047:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabViewVisibleChange
            if (r0 == 0) goto L_0x0079
            r0 = r8
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$OnTabViewVisibleChange r0 = (com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabViewVisibleChange) r0
            boolean r0 = r0.getVisible()
            if (r0 == 0) goto L_0x02e3
            boolean r0 = r6.needShowCommonTabBubble
            if (r0 != 0) goto L_0x005c
            boolean r0 = r6.needShowHomeOperateBubble
            if (r0 == 0) goto L_0x02e3
        L_0x005c:
            boolean r0 = r6.hasShownBubble
            if (r0 != 0) goto L_0x02e3
            com.baidu.searchbox.video.feedflow.detail.tabguide.TryShowTabBubbleGuide r0 = com.baidu.searchbox.video.feedflow.detail.tabguide.TryShowTabBubbleGuide.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
            boolean r0 = r6.needShowCommonTabBubble
            if (r0 == 0) goto L_0x02e3
            r6.hasTryShowRedDot = r1
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$TryHideRedDot r0 = new com.baidu.searchbox.video.feedflow.tab.TabComponentAction$TryHideRedDot
            r0.<init>(r3, r1, r2, r3)
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            r7.dispatch(r0)
            goto L_0x02e3
        L_0x0079:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.tab.TabComponentAction.TabRenderComplete
            if (r0 == 0) goto L_0x00ee
            com.baidu.searchbox.video.channel.tab.ChannelRedDotManager r0 = com.baidu.searchbox.video.channel.tab.ChannelRedDotManager.INSTANCE
            r4 = r8
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$TabRenderComplete r4 = (com.baidu.searchbox.video.feedflow.tab.TabComponentAction.TabRenderComplete) r4
            java.util.List r4 = r4.getItemList()
            com.baidu.searchbox.video.channel.HomeTabBubbleModel r0 = r0.tryShowBubble(r4)
            if (r0 == 0) goto L_0x02e3
            r4 = 0
            r5 = r24
            r10 = 0
            com.baidu.searchbox.feed.detail.frame.State r11 = r5.getState()
            boolean r12 = r11 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r12 == 0) goto L_0x009b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            goto L_0x009c
        L_0x009b:
            r11 = r3
        L_0x009c:
            if (r11 == 0) goto L_0x00a5
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r12 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r11 = r11.select(r12)
            goto L_0x00a6
        L_0x00a5:
            r11 = r3
        L_0x00a6:
            com.baidu.searchbox.video.feedflow.tab.TabState r11 = (com.baidu.searchbox.video.feedflow.tab.TabState) r11
            if (r11 == 0) goto L_0x00ae
            java.lang.String r3 = r11.getCurrentTabId()
        L_0x00ae:
            if (r3 != 0) goto L_0x00b2
            java.lang.String r3 = ""
        L_0x00b2:
            java.lang.String r5 = r0.getTabId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x00eb
            r6.hasShownBubble = r1
            r6.needShowHomeOperateBubble = r2
            com.baidu.searchbox.video.feedflow.detail.tabguide.BindTabBubbleData r1 = new com.baidu.searchbox.video.feedflow.detail.tabguide.BindTabBubbleData
            java.lang.String r11 = r0.getTabId()
            java.lang.String r12 = r0.getIcon()
            java.lang.String r13 = r0.getTabTips()
            java.lang.Long r14 = r0.getTipsKeepTime()
            java.lang.String r15 = r0.getTipsBubbleColour()
            java.lang.String r16 = r0.getTipsTextColour()
            r17 = 0
            r19 = 0
            r20 = 192(0xc0, float:2.69E-43)
            r21 = 0
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r19, r20, r21)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r1)
        L_0x00eb:
            goto L_0x02e3
        L_0x00ee:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.channel.tab.hometab.HomeTabOperationAction.ForceRefreshTip
            if (r0 == 0) goto L_0x01fe
            r6.needShowCommonTabBubble = r1
            r0 = r24
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0102
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0103
        L_0x0102:
            r5 = r3
        L_0x0103:
            if (r5 == 0) goto L_0x010c
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r10 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x010d
        L_0x010c:
            r5 = r3
        L_0x010d:
            r0 = r5
            com.baidu.searchbox.video.feedflow.tab.TabState r0 = (com.baidu.searchbox.video.feedflow.tab.TabState) r0
            r4 = r8
            com.baidu.searchbox.video.channel.tab.hometab.HomeTabOperationAction$ForceRefreshTip r4 = (com.baidu.searchbox.video.channel.tab.hometab.HomeTabOperationAction.ForceRefreshTip) r4
            boolean r4 = r4.isFromOperation()
            if (r4 == 0) goto L_0x01e4
            r6.hasTryShowRedDot = r1
            com.baidu.searchbox.video.channel.tab.ChannelRedDotManager r4 = com.baidu.searchbox.video.channel.tab.ChannelRedDotManager.INSTANCE
            if (r0 == 0) goto L_0x012c
            androidx.lifecycle.MutableLiveData r5 = r0.getTabItems()
            if (r5 == 0) goto L_0x012c
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            goto L_0x012d
        L_0x012c:
            r5 = r3
        L_0x012d:
            com.baidu.searchbox.video.channel.HomeTabBubbleModel r4 = r4.tryShowBubble(r5)
            if (r4 == 0) goto L_0x0173
            r5 = 0
            if (r0 == 0) goto L_0x013b
            java.lang.String r10 = r0.getDefaultSelectedTagId()
            goto L_0x013c
        L_0x013b:
            r10 = r3
        L_0x013c:
            java.lang.String r11 = r4.getTabId()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 != 0) goto L_0x0171
            r6.hasShownBubble = r1
            r6.needShowHomeOperateBubble = r2
            com.baidu.searchbox.video.feedflow.detail.tabguide.BindTabBubbleData r2 = new com.baidu.searchbox.video.feedflow.detail.tabguide.BindTabBubbleData
            java.lang.String r12 = r4.getTabId()
            java.lang.String r13 = r4.getIcon()
            java.lang.String r14 = r4.getTabTips()
            java.lang.Long r15 = r4.getTipsKeepTime()
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 240(0xf0, float:3.36E-43)
            r22 = 0
            r11 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20, r21, r22)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r2)
        L_0x0171:
        L_0x0173:
            boolean r2 = r6.needShowHomeOperateBubble
            if (r2 != 0) goto L_0x018b
            if (r0 == 0) goto L_0x018b
            androidx.lifecycle.MutableLiveData r2 = r0.getTabItems()
            if (r2 == 0) goto L_0x018b
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x018b
            r4 = 0
            r6.tryShowTabBubble(r7, r2)
        L_0x018b:
            r2 = r24
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r2.getState()
            boolean r10 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x0199
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x019a
        L_0x0199:
            r5 = r3
        L_0x019a:
            if (r5 == 0) goto L_0x01a3
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r10 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r5 = r5.select(r10)
            goto L_0x01a4
        L_0x01a3:
            r5 = r3
        L_0x01a4:
            com.baidu.searchbox.video.feedflow.tab.TabState r5 = (com.baidu.searchbox.video.feedflow.tab.TabState) r5
            if (r5 == 0) goto L_0x01b5
            androidx.lifecycle.MutableLiveData r2 = r5.getTabItems()
            if (r2 == 0) goto L_0x01b5
            java.lang.Object r2 = r2.getValue()
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x01b5:
            if (r3 != 0) goto L_0x01bf
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = r2
            java.util.List r3 = (java.util.List) r3
        L_0x01bf:
            r2 = r3
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x01c8:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x01e1
            java.lang.Object r10 = r5.next()
            r11 = r10
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r11 = (com.baidu.searchbox.video.feedflow.tab.TabInfoModel) r11
            r12 = 0
            com.baidu.searchbox.video.feedflow.tab.RedDotModel r13 = r11.getRedDot()
            if (r13 != 0) goto L_0x01dd
            goto L_0x01c8
        L_0x01dd:
            r13.setShow(r1)
            goto L_0x01c8
        L_0x01e1:
            goto L_0x02e3
        L_0x01e4:
            r6.needShowHomeOperateBubble = r1
            if (r0 == 0) goto L_0x01fc
            androidx.lifecycle.MutableLiveData r1 = r0.getTabItems()
            if (r1 == 0) goto L_0x01fc
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x01fc
            r2 = 0
            r6.tryShowTabBubble(r7, r1)
            goto L_0x02e3
        L_0x01fc:
            goto L_0x02e3
        L_0x01fe:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabSelectedAction
            if (r0 == 0) goto L_0x023b
            com.baidu.searchbox.video.channel.tab.ChannelRedDotManager r0 = com.baidu.searchbox.video.channel.tab.ChannelRedDotManager.INSTANCE
            r1 = r8
            com.baidu.searchbox.video.feedflow.tab.TabComponentAction$OnTabSelectedAction r1 = (com.baidu.searchbox.video.feedflow.tab.TabComponentAction.OnTabSelectedAction) r1
            com.baidu.searchbox.video.feedflow.tab.TabInfoModel r1 = r1.getSelectedTabInfo()
            java.lang.String r1 = r1.getId()
            boolean r0 = r0.canHideBubble(r1)
            if (r0 == 0) goto L_0x021c
            com.baidu.searchbox.video.feedflow.detail.tabguide.HideTabBubbleAction r0 = com.baidu.searchbox.video.feedflow.detail.tabguide.HideTabBubbleAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r0 = (com.baidu.searchbox.feed.detail.frame.Action) r0
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r7, r0)
        L_0x021c:
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInTalosTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 != 0) goto L_0x022e
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInLiveTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 != 0) goto L_0x022e
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInH5Tab(r24)
            if (r0 == 0) goto L_0x02e3
        L_0x022e:
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r23
            r1 = r24
            tryShowRedDot$default(r0, r1, r2, r3, r4, r5)
            goto L_0x02e3
        L_0x023b:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction.ForceRefreshNATab
            if (r0 == 0) goto L_0x026d
            r0 = r8
            com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction$ForceRefreshNATab r0 = (com.baidu.searchbox.video.channel.flow.pageview.VideoChannelFlowPageAction.ForceRefreshNATab) r0
            java.lang.String r0 = r0.getType()
            java.lang.String r1 = "force_refresh_na_type_operate"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x02e3
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInTalosTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 != 0) goto L_0x0260
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInLiveTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 != 0) goto L_0x0260
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInH5Tab(r24)
            if (r0 == 0) goto L_0x02e3
        L_0x0260:
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r23
            r1 = r24
            tryShowRedDot$default(r0, r1, r2, r3, r4, r5)
            goto L_0x02e3
        L_0x026d:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess
            java.lang.String r4 = "2"
            if (r0 == 0) goto L_0x02b8
            r0 = r8
            com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess r0 = (com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess) r0
            java.lang.Object r0 = r0.getData()
            boolean r5 = r0 instanceof com.baidu.searchbox.flowvideo.flow.api.FlowListBean
            if (r5 == 0) goto L_0x0281
            r3 = r0
            com.baidu.searchbox.flowvideo.flow.api.FlowListBean r3 = (com.baidu.searchbox.flowvideo.flow.api.FlowListBean) r3
        L_0x0281:
            r10 = r3
            boolean r0 = r6.canShowRedDot(r10)
            if (r0 == 0) goto L_0x02e3
            if (r10 == 0) goto L_0x0297
            com.baidu.searchbox.flowvideo.flow.api.PoliciesBean r0 = r10.getPolicies()
            if (r0 == 0) goto L_0x0297
            boolean r0 = r0.isShowFollowReddot()
            if (r0 != r2) goto L_0x0297
            r1 = r2
        L_0x0297:
            r11 = r1
            if (r11 == 0) goto L_0x02e3
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.hasAttentionTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 == 0) goto L_0x02e3
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInAttentionTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 != 0) goto L_0x02e3
            com.baidu.searchbox.video.channel.tab.ChannelRedDotManager r0 = com.baidu.searchbox.video.channel.tab.ChannelRedDotManager.INSTANCE
            r0.updateShowSwitchFromServer(r4, r2)
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r2 = "2"
            r0 = r23
            r1 = r24
            tryShowRedDot$default(r0, r1, r2, r3, r4, r5)
            goto L_0x02e3
        L_0x02b8:
            boolean r0 = r8 instanceof com.baidu.searchbox.video.feedflow.tab.live.tip.HasNewLiveAction
            if (r0 == 0) goto L_0x02e3
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.hasAttentionTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 == 0) goto L_0x02e3
            boolean r0 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInAttentionTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r24)
            if (r0 != 0) goto L_0x02e3
            r6.hasTryShowRedDot = r1
            com.baidu.searchbox.video.channel.tab.ChannelRedDotManager r0 = com.baidu.searchbox.video.channel.tab.ChannelRedDotManager.INSTANCE
            r0.updateShowSwitchFromServer(r4, r2)
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            android.content.Context r0 = r0.getAppContext()
            int r1 = com.baidu.searchbox.video.feedflow.component.R.string.video_flow_live
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "DIFactory.getAppContext(…R.string.video_flow_live)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.tryShowRedDot(r7, r4, r0)
        L_0x02e3:
            com.baidu.searchbox.feed.detail.frame.Action r0 = r9.next(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.channel.tab.tabtip.ChannelRedDotMiddleware.apply(com.baidu.searchbox.feed.detail.frame.Store, com.baidu.searchbox.feed.detail.frame.Action, com.baidu.searchbox.feed.detail.frame.Next):com.baidu.searchbox.feed.detail.frame.Action");
    }

    static /* synthetic */ void tryShowRedDot$default(ChannelRedDotMiddleware channelRedDotMiddleware, Store store, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        channelRedDotMiddleware.tryShowRedDot(store, str, str2);
    }

    private final void tryShowRedDot(Store<CommonState> store, String tabId, String dotText) {
        MutableLiveData<List<TabInfoModel>> tabItems;
        if (!this.hasTryShowRedDot) {
            CommonState state = store.getState();
            CommonState commonState = state instanceof CommonState ? state : null;
            TabState tabState = (TabState) (commonState != null ? commonState.select(TabState.class) : null);
            List<TabInfoModel> itemList = (tabState == null || (tabItems = tabState.getTabItems()) == null) ? null : tabItems.getValue();
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
            for (TabInfoModel itemModel : itemList) {
                ChannelRedDotManager.INSTANCE.updateDotText(itemModel, tabId, dotText);
                ChannelRedDotManager.INSTANCE.save(itemModel.getId(), itemModel.getRedDot());
            }
            this.hasTryShowRedDot = true;
            if (this.needShowCommonTabBubble) {
                StoreExtKt.post(store, new TabComponentAction.TryHideRedDot((String) null, false, 1, (DefaultConstructorMarker) null));
            } else {
                StoreExtKt.post(store, new TabComponentAction.TryShowRedDot((String) null, false, 3, (DefaultConstructorMarker) null));
            }
        }
    }

    private final boolean canShowRedDot(FlowListBean data) {
        return VideoNewTabManifestKt.isChannelFirstRequest(data);
    }

    private final String generateColorJson(String lightColor, String nightColor) {
        CharSequence charSequence = lightColor;
        boolean z = false;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "";
        }
        CharSequence charSequence2 = nightColor;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (z) {
            return "";
        }
        return "{\"light\":\"" + lightColor + "\",\"night\":\"" + nightColor + GetSwanHistoryAction.SCHEME_CONSTANT_CONNECT;
    }

    private final void tryBindTabBubbleData(Store<CommonState> store, List<TabInfoModel> itemList) {
        Object obj;
        String str;
        String maxNum;
        TabInfoModel it;
        CommonState state = store.getState();
        String str2 = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        TabState tabState = (TabState) (commonState != null ? commonState.select(TabState.class) : null);
        String curTabId = tabState != null ? tabState.getCurrentTabId() : null;
        if (curTabId == null) {
            curTabId = "";
        }
        Iterator it2 = itemList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            TabInfoModel it3 = (TabInfoModel) obj;
            if (Intrinsics.areEqual((Object) it3.getId(), (Object) curTabId) || it3.getNewTip() == null) {
                it = null;
                continue;
            } else {
                it = 1;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        TabInfoModel tabInfoModel = (TabInfoModel) obj;
        if (tabInfoModel != null) {
            TabInfoModel $this$tryBindTabBubbleData_u24lambda_u2d6 = tabInfoModel;
            NewTipModel newTip = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
            Integer maxNum2 = (newTip == null || (maxNum = newTip.getMaxNum()) == null) ? null : StringsKt.toIntOrNull(maxNum);
            Integer curNum = TabBubbleManager.INSTANCE.getTabBubbleShowNum($this$tryBindTabBubbleData_u24lambda_u2d6.getId());
            NewTipModel newTip2 = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
            if (!Intrinsics.areEqual((Object) newTip2 != null ? newTip2.getTipSwitch() : null, (Object) "1")) {
                Store<CommonState> store2 = store;
            } else if (maxNum2 == null) {
                Store<CommonState> store3 = store;
            } else if (curNum == null) {
                Store<CommonState> store4 = store;
            } else if (curNum.intValue() < maxNum2.intValue()) {
                this.hasShownBubble = false;
                this.needShowCommonTabBubble = true;
                String id = $this$tryBindTabBubbleData_u24lambda_u2d6.getId();
                if (id == null) {
                    str = "";
                } else {
                    str = id;
                }
                NewTipModel newTip3 = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
                Intrinsics.checkNotNull(newTip3);
                String tipText = newTip3.getTipText();
                NewTipModel newTip4 = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
                String bubbleColor = newTip4 != null ? newTip4.getBubbleColor() : null;
                NewTipModel newTip5 = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
                String generateColorJson = generateColorJson(bubbleColor, newTip5 != null ? newTip5.getBubbleColorNight() : null);
                NewTipModel newTip6 = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
                String txtColor = newTip6 != null ? newTip6.getTxtColor() : null;
                NewTipModel newTip7 = $this$tryBindTabBubbleData_u24lambda_u2d6.getNewTip();
                if (newTip7 != null) {
                    str2 = newTip7.getTxtColorNight();
                }
                StoreExtKt.post(store, new BindTabBubbleData(str, "", tipText, 7000L, generateColorJson, generateColorJson(txtColor, str2), 0, (String) null, 192, (DefaultConstructorMarker) null));
            } else {
                Store<CommonState> store5 = store;
            }
        } else {
            Store<CommonState> store6 = store;
        }
    }

    private final void tryShowTabBubble(Store<CommonState> store, List<TabInfoModel> itemList) {
        Boolean bool;
        MutableLiveData<Boolean> isTabVisible;
        if (!this.needShowHomeOperateBubble) {
            tryBindTabBubbleData(store, itemList);
            tryBindShortBubbleData(store);
            Object obj = null;
            if (this.needShowCommonTabBubble) {
                this.hasTryShowRedDot = false;
                store.dispatch(new TabComponentAction.TryHideRedDot((String) null, false, 1, (DefaultConstructorMarker) null));
            }
            if (!this.isCodeEnter) {
                CommonState state = store.getState();
                CommonState commonState = state instanceof CommonState ? state : null;
                if (commonState != null) {
                    obj = commonState.select(TabState.class);
                }
                TabState tabState = (TabState) obj;
                if (tabState == null || (isTabVisible = tabState.isTabVisible()) == null || (bool = isTabVisible.getValue()) == null) {
                    bool = false;
                }
                boolean isTabVisible2 = bool.booleanValue();
                if (this.needShowCommonTabBubble && isTabVisible2 && CommonStateExtKt.isActive(store)) {
                    StoreExtKt.post(store, ForceShowTabBubbleAction.INSTANCE);
                }
            }
        }
    }

    private final void tryBindShortBubbleData(Store<CommonState> store) {
        if (!this.needShowCommonTabBubble && FavorShortGuideDataUtils.INSTANCE.isShownRecallGuide() && !FavorShortGuideDataUtils.INSTANCE.getShortTabBubbleShown() && !FavorShortGuideDataUtils.INSTANCE.getShortTheaterBubbleShown()) {
            this.needShowCommonTabBubble = true;
            String string = DIFactory.INSTANCE.getAppContext().getString(R.string.video_flow_my_playlet_watch_here);
            Intrinsics.checkNotNullExpressionValue(string, "DIFactory.getAppContext(…ow_my_playlet_watch_here)");
            JSONObject jSONObject = new JSONObject();
            JSONObject $this$tryBindShortBubbleData_u24lambda_u2d7 = jSONObject;
            $this$tryBindShortBubbleData_u24lambda_u2d7.put("light", FavorShortGuideDataUtilsKt.getSHORT_TIP_BUBBLE_COLOUR());
            $this$tryBindShortBubbleData_u24lambda_u2d7.put("night", FavorShortGuideDataUtilsKt.getSHORT_TIP_BUBBLE_COLOUR());
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …             }.toString()");
            JSONObject jSONObject3 = new JSONObject();
            JSONObject $this$tryBindShortBubbleData_u24lambda_u2d8 = jSONObject3;
            $this$tryBindShortBubbleData_u24lambda_u2d8.put("light", FavorShortGuideDataUtilsKt.getSHORT_TIP_TEXT_COLOUR());
            $this$tryBindShortBubbleData_u24lambda_u2d8.put("night", FavorShortGuideDataUtilsKt.getSHORT_TIP_TEXT_COLOUR());
            Unit unit2 = Unit.INSTANCE;
            String jSONObject4 = jSONObject3.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject().apply {\n   …             }.toString()");
            StoreExtKt.post(store, new BindTabBubbleData("13", "", string, (Long) null, jSONObject2, jSONObject4, 0, FavorShortGuideDataUtilsKt.getSHORT_PLAYLET_BUBBLE_TAG()));
        }
    }
}
