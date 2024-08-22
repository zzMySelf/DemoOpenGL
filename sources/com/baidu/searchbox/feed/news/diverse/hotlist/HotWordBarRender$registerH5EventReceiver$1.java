package com.baidu.searchbox.feed.news.diverse.hotlist;

import com.baidu.searchbox.datachannel.NAReceiverCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/feed/news/diverse/hotlist/HotWordBarRender$registerH5EventReceiver$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "data", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotWordBarRender.kt */
public final class HotWordBarRender$registerH5EventReceiver$1 extends NAReceiverCallback {
    final /* synthetic */ HotWordBarRender this$0;

    HotWordBarRender$registerH5EventReceiver$1(HotWordBarRender $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021 A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022 A[Catch:{ all -> 0x005c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            com.baidu.searchbox.feed.news.diverse.hotlist.HotWordBarRender r0 = r9.this$0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x005c }
            r1 = r9
            com.baidu.searchbox.feed.news.diverse.hotlist.HotWordBarRender$registerH5EventReceiver$1 r1 = (com.baidu.searchbox.feed.news.diverse.hotlist.HotWordBarRender$registerH5EventReceiver$1) r1     // Catch:{ all -> 0x005c }
            r2 = 0
            java.lang.String r3 = "com.baidu.channel.hotlist.hotword_entry"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r3)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x005b
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x001e
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r3 = 0
            goto L_0x001f
        L_0x001e:
            r3 = 1
        L_0x001f:
            if (r3 == 0) goto L_0x0022
            goto L_0x005b
        L_0x0022:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x005c }
            r3.<init>(r11)     // Catch:{ all -> 0x005c }
            r4 = 0
            com.baidu.searchbox.feed.news.diverse.hotlist.HotWordRenderParams$Companion r5 = com.baidu.searchbox.feed.news.diverse.hotlist.HotWordRenderParams.Companion     // Catch:{ all -> 0x005c }
            com.baidu.searchbox.feed.news.diverse.hotlist.HotWordRenderParams r5 = r5.fromJson(r3)     // Catch:{ all -> 0x005c }
            r6 = 0
            java.lang.String r7 = r5.getNid()     // Catch:{ all -> 0x005c }
            com.baidu.searchbox.feed.news.NewsDetailContainer r8 = r0.container     // Catch:{ all -> 0x005c }
            java.lang.String r8 = r8.getNid()     // Catch:{ all -> 0x005c }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x005c }
            if (r7 == 0) goto L_0x0050
            r0.renderParams = r5     // Catch:{ all -> 0x005c }
            boolean r7 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()     // Catch:{ all -> 0x005c }
            r0.render(r7)     // Catch:{ all -> 0x005c }
            com.baidu.searchbox.feed.news.diverse.hotlist.HotWordEntryStat$Companion r0 = com.baidu.searchbox.feed.news.diverse.hotlist.HotWordEntryStat.Companion     // Catch:{ all -> 0x005c }
            r0.onEntryBarShow(r5)     // Catch:{ all -> 0x005c }
        L_0x0050:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005c }
            kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x005c }
            goto L_0x0066
        L_0x005b:
            return
        L_0x005c:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.news.diverse.hotlist.HotWordBarRender$registerH5EventReceiver$1.onReceive(java.lang.String, java.lang.String):void");
    }
}
