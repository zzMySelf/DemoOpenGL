package com.baidu.searchbox.video.feedflow.ad.position.collnext;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0013\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\t\u00101\u001a\u00020\rHÆ\u0003Jq\u00102\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\bHÖ\u0001J\u0006\u00107\u001a\u000208J\t\u00109\u001a\u00020:HÖ\u0001R \u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R$\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/collnext/AdCollListState;", "", "collAdShow", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "adPortraitCache", "adLandscapeCache", "firstAdPos", "", "lastAd", "Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "lastAdPos", "lastAdEShowTs", "", "sessionStartTime", "(Landroidx/lifecycle/MutableLiveData;Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;ILcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;IJJ)V", "getAdLandscapeCache", "()Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "setAdLandscapeCache", "(Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;)V", "getAdPortraitCache", "setAdPortraitCache", "getCollAdShow", "()Landroidx/lifecycle/MutableLiveData;", "setCollAdShow", "(Landroidx/lifecycle/MutableLiveData;)V", "getFirstAdPos", "()I", "setFirstAdPos", "(I)V", "getLastAd", "()Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;", "setLastAd", "(Lcom/baidu/searchbox/video/feedflow/ad/flow/AdItemModel;)V", "getLastAdEShowTs", "()J", "setLastAdEShowTs", "(J)V", "getLastAdPos", "setLastAdPos", "getSessionStartTime", "setSessionStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "reset", "", "toString", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdCollListState.kt */
public final class AdCollListState {
    private ItemModel<?> adLandscapeCache;
    private ItemModel<?> adPortraitCache;
    private MutableLiveData<ItemModel<?>> collAdShow;
    private int firstAdPos;
    private AdItemModel lastAd;
    private long lastAdEShowTs;
    private int lastAdPos;
    private long sessionStartTime;

    public AdCollListState() {
        this((MutableLiveData) null, (ItemModel) null, (ItemModel) null, 0, (AdItemModel) null, 0, 0, 0, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdCollListState copy$default(AdCollListState adCollListState, MutableLiveData mutableLiveData, ItemModel itemModel, ItemModel itemModel2, int i2, AdItemModel adItemModel, int i3, long j2, long j3, int i4, Object obj) {
        AdCollListState adCollListState2 = adCollListState;
        int i5 = i4;
        return adCollListState.copy((i5 & 1) != 0 ? adCollListState2.collAdShow : mutableLiveData, (i5 & 2) != 0 ? adCollListState2.adPortraitCache : itemModel, (i5 & 4) != 0 ? adCollListState2.adLandscapeCache : itemModel2, (i5 & 8) != 0 ? adCollListState2.firstAdPos : i2, (i5 & 16) != 0 ? adCollListState2.lastAd : adItemModel, (i5 & 32) != 0 ? adCollListState2.lastAdPos : i3, (i5 & 64) != 0 ? adCollListState2.lastAdEShowTs : j2, (i5 & 128) != 0 ? adCollListState2.sessionStartTime : j3);
    }

    public final MutableLiveData<ItemModel<?>> component1() {
        return this.collAdShow;
    }

    public final ItemModel<?> component2() {
        return this.adPortraitCache;
    }

    public final ItemModel<?> component3() {
        return this.adLandscapeCache;
    }

    public final int component4() {
        return this.firstAdPos;
    }

    public final AdItemModel component5() {
        return this.lastAd;
    }

    public final int component6() {
        return this.lastAdPos;
    }

    public final long component7() {
        return this.lastAdEShowTs;
    }

    public final long component8() {
        return this.sessionStartTime;
    }

    public final AdCollListState copy(MutableLiveData<ItemModel<?>> mutableLiveData, ItemModel<?> itemModel, ItemModel<?> itemModel2, int i2, AdItemModel adItemModel, int i3, long j2, long j3) {
        MutableLiveData<ItemModel<?>> mutableLiveData2 = mutableLiveData;
        Intrinsics.checkNotNullParameter(mutableLiveData, "collAdShow");
        return new AdCollListState(mutableLiveData, itemModel, itemModel2, i2, adItemModel, i3, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdCollListState)) {
            return false;
        }
        AdCollListState adCollListState = (AdCollListState) obj;
        return Intrinsics.areEqual((Object) this.collAdShow, (Object) adCollListState.collAdShow) && Intrinsics.areEqual((Object) this.adPortraitCache, (Object) adCollListState.adPortraitCache) && Intrinsics.areEqual((Object) this.adLandscapeCache, (Object) adCollListState.adLandscapeCache) && this.firstAdPos == adCollListState.firstAdPos && Intrinsics.areEqual((Object) this.lastAd, (Object) adCollListState.lastAd) && this.lastAdPos == adCollListState.lastAdPos && this.lastAdEShowTs == adCollListState.lastAdEShowTs && this.sessionStartTime == adCollListState.sessionStartTime;
    }

    public int hashCode() {
        int hashCode = this.collAdShow.hashCode() * 31;
        ItemModel<?> itemModel = this.adPortraitCache;
        int i2 = 0;
        int hashCode2 = (hashCode + (itemModel == null ? 0 : itemModel.hashCode())) * 31;
        ItemModel<?> itemModel2 = this.adLandscapeCache;
        int hashCode3 = (((hashCode2 + (itemModel2 == null ? 0 : itemModel2.hashCode())) * 31) + Integer.hashCode(this.firstAdPos)) * 31;
        AdItemModel adItemModel = this.lastAd;
        if (adItemModel != null) {
            i2 = adItemModel.hashCode();
        }
        return ((((((hashCode3 + i2) * 31) + Integer.hashCode(this.lastAdPos)) * 31) + Long.hashCode(this.lastAdEShowTs)) * 31) + Long.hashCode(this.sessionStartTime);
    }

    public String toString() {
        return "AdCollListState(collAdShow=" + this.collAdShow + ", adPortraitCache=" + this.adPortraitCache + ", adLandscapeCache=" + this.adLandscapeCache + ", firstAdPos=" + this.firstAdPos + ", lastAd=" + this.lastAd + ", lastAdPos=" + this.lastAdPos + ", lastAdEShowTs=" + this.lastAdEShowTs + ", sessionStartTime=" + this.sessionStartTime + ')';
    }

    public AdCollListState(MutableLiveData<ItemModel<?>> collAdShow2, ItemModel<?> adPortraitCache2, ItemModel<?> adLandscapeCache2, int firstAdPos2, AdItemModel lastAd2, int lastAdPos2, long lastAdEShowTs2, long sessionStartTime2) {
        Intrinsics.checkNotNullParameter(collAdShow2, "collAdShow");
        this.collAdShow = collAdShow2;
        this.adPortraitCache = adPortraitCache2;
        this.adLandscapeCache = adLandscapeCache2;
        this.firstAdPos = firstAdPos2;
        this.lastAd = lastAd2;
        this.lastAdPos = lastAdPos2;
        this.lastAdEShowTs = lastAdEShowTs2;
        this.sessionStartTime = sessionStartTime2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdCollListState(androidx.lifecycle.MutableLiveData r12, com.baidu.searchbox.video.feedflow.flow.list.ItemModel r13, com.baidu.searchbox.video.feedflow.flow.list.ItemModel r14, int r15, com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel r16, int r17, long r18, long r20, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r12
        L_0x000d:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0014
            r2 = r3
            goto L_0x0015
        L_0x0014:
            r2 = r13
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            r4 = r3
            goto L_0x001c
        L_0x001b:
            r4 = r14
        L_0x001c:
            r5 = r0 & 8
            r6 = -1
            if (r5 == 0) goto L_0x0023
            r5 = r6
            goto L_0x0024
        L_0x0023:
            r5 = r15
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r3 = r16
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r6 = r17
        L_0x0032:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0039
            r7 = -1
            goto L_0x003b
        L_0x0039:
            r7 = r18
        L_0x003b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0042
            r9 = 0
            goto L_0x0044
        L_0x0042:
            r9 = r20
        L_0x0044:
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r3
            r17 = r6
            r18 = r7
            r20 = r9
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.position.collnext.AdCollListState.<init>(androidx.lifecycle.MutableLiveData, com.baidu.searchbox.video.feedflow.flow.list.ItemModel, com.baidu.searchbox.video.feedflow.flow.list.ItemModel, int, com.baidu.searchbox.video.feedflow.ad.flow.AdItemModel, int, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<ItemModel<?>> getCollAdShow() {
        return this.collAdShow;
    }

    public final void setCollAdShow(MutableLiveData<ItemModel<?>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.collAdShow = mutableLiveData;
    }

    public final ItemModel<?> getAdPortraitCache() {
        return this.adPortraitCache;
    }

    public final void setAdPortraitCache(ItemModel<?> itemModel) {
        this.adPortraitCache = itemModel;
    }

    public final ItemModel<?> getAdLandscapeCache() {
        return this.adLandscapeCache;
    }

    public final void setAdLandscapeCache(ItemModel<?> itemModel) {
        this.adLandscapeCache = itemModel;
    }

    public final int getFirstAdPos() {
        return this.firstAdPos;
    }

    public final void setFirstAdPos(int i2) {
        this.firstAdPos = i2;
    }

    public final AdItemModel getLastAd() {
        return this.lastAd;
    }

    public final void setLastAd(AdItemModel adItemModel) {
        this.lastAd = adItemModel;
    }

    public final int getLastAdPos() {
        return this.lastAdPos;
    }

    public final void setLastAdPos(int i2) {
        this.lastAdPos = i2;
    }

    public final long getLastAdEShowTs() {
        return this.lastAdEShowTs;
    }

    public final void setLastAdEShowTs(long j2) {
        this.lastAdEShowTs = j2;
    }

    public final long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public final void setSessionStartTime(long j2) {
        this.sessionStartTime = j2;
    }

    public final void reset() {
        this.adPortraitCache = null;
        this.adLandscapeCache = null;
        this.lastAd = null;
        this.lastAdPos = -1;
        this.lastAdEShowTs = -1;
        this.firstAdPos = -1;
        this.sessionStartTime = System.currentTimeMillis();
    }
}
