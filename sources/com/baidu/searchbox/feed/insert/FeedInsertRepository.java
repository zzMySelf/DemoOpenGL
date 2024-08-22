package com.baidu.searchbox.feed.insert;

import com.baidu.searchbox.feed.insert.InsertRequester;
import com.baidu.searchbox.feed.util.FeedUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/feed/insert/FeedInsertRepository;", "", "()V", "insertRequester", "Lcom/baidu/searchbox/feed/insert/InsertRequester;", "pendingData", "Lcom/baidu/searchbox/feed/insert/FeedInsertData;", "getPendingData", "()Lcom/baidu/searchbox/feed/insert/FeedInsertData;", "setPendingData", "(Lcom/baidu/searchbox/feed/insert/FeedInsertData;)V", "cancelInsertRequest", "", "clearPendingData", "fetchInsertDataByScene", "sceneParams", "Lcom/baidu/searchbox/feed/insert/InsertRequester$SceneParams;", "getPendingDataByChannel", "channelId", "", "getPendingDataByScene", "insertScene", "Lcom/baidu/searchbox/feed/insert/InsertRequester$InsertScene;", "getPendingDataChannel", "getPendingDataProtocol", "Lcom/baidu/searchbox/feed/insert/InsertRequester$InsertProtocol;", "getPendingDataScene", "hasPendingData", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedInsertRepository.kt */
public final class FeedInsertRepository {
    public static final FeedInsertRepository INSTANCE = new FeedInsertRepository();
    private static final InsertRequester insertRequester = new InsertRequester();
    private static FeedInsertData pendingData;

    private FeedInsertRepository() {
    }

    public final FeedInsertData getPendingData() {
        return pendingData;
    }

    public final void setPendingData(FeedInsertData feedInsertData) {
        pendingData = feedInsertData;
    }

    public final void fetchInsertDataByScene(InsertRequester.SceneParams sceneParams) {
        Intrinsics.checkNotNullParameter(sceneParams, "sceneParams");
        insertRequester.fetchInsertDataByScene(sceneParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.sceneParams;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.feed.insert.FeedInsertData getPendingDataByChannel(java.lang.String r3) {
        /*
            r2 = this;
            com.baidu.searchbox.feed.insert.FeedInsertData r0 = pendingData
            r1 = 0
            if (r0 == 0) goto L_0x001a
            if (r0 == 0) goto L_0x0010
            com.baidu.searchbox.feed.insert.InsertRequester$SceneParams r0 = r0.sceneParams
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getChannelId()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x001a
            com.baidu.searchbox.feed.insert.FeedInsertData r1 = pendingData
            goto L_0x001d
        L_0x001a:
            r0 = r1
            com.baidu.searchbox.feed.insert.FeedInsertData r0 = (com.baidu.searchbox.feed.insert.FeedInsertData) r0
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.insert.FeedInsertRepository.getPendingDataByChannel(java.lang.String):com.baidu.searchbox.feed.insert.FeedInsertData");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = r0.sceneParams;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.feed.insert.FeedInsertData getPendingDataByScene(com.baidu.searchbox.feed.insert.InsertRequester.InsertScene r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "insertScene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.baidu.searchbox.feed.insert.FeedInsertData r0 = pendingData
            r1 = 0
            if (r0 == 0) goto L_0x002f
            if (r0 == 0) goto L_0x0015
            com.baidu.searchbox.feed.insert.InsertRequester$SceneParams r0 = r0.sceneParams
            if (r0 == 0) goto L_0x0015
            com.baidu.searchbox.feed.insert.InsertRequester$InsertScene r0 = r0.getScene()
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 != r3) goto L_0x002f
            com.baidu.searchbox.feed.insert.FeedInsertData r0 = pendingData
            if (r0 == 0) goto L_0x0025
            com.baidu.searchbox.feed.insert.InsertRequester$SceneParams r0 = r0.sceneParams
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.getChannelId()
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x002f
            com.baidu.searchbox.feed.insert.FeedInsertData r1 = pendingData
            goto L_0x0032
        L_0x002f:
            r0 = r1
            com.baidu.searchbox.feed.insert.FeedInsertData r0 = (com.baidu.searchbox.feed.insert.FeedInsertData) r0
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.insert.FeedInsertRepository.getPendingDataByScene(com.baidu.searchbox.feed.insert.InsertRequester$InsertScene, java.lang.String):com.baidu.searchbox.feed.insert.FeedInsertData");
    }

    public final void cancelInsertRequest() {
        insertRequester.cancelFetchData();
    }

    public final void clearPendingData() {
        FeedUtil.refreshLog("FeedInsertRepository", "clearPendingData");
        pendingData = null;
    }

    public final boolean hasPendingData() {
        return pendingData != null;
    }

    public final InsertRequester.InsertProtocol getPendingDataProtocol() {
        InsertRequester.SceneParams sceneParams;
        FeedInsertData feedInsertData = pendingData;
        if (feedInsertData == null || (sceneParams = feedInsertData.sceneParams) == null) {
            return null;
        }
        return sceneParams.getProtocol();
    }

    public final InsertRequester.InsertScene getPendingDataScene() {
        InsertRequester.SceneParams sceneParams;
        FeedInsertData feedInsertData = pendingData;
        if (feedInsertData == null || (sceneParams = feedInsertData.sceneParams) == null) {
            return null;
        }
        return sceneParams.getScene();
    }

    public final String getPendingDataChannel() {
        InsertRequester.SceneParams sceneParams;
        FeedInsertData feedInsertData = pendingData;
        if (feedInsertData == null || (sceneParams = feedInsertData.sceneParams) == null) {
            return null;
        }
        return sceneParams.getChannelId();
    }
}
