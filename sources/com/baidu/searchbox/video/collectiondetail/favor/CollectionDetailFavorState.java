package com.baidu.searchbox.video.collectiondetail.favor;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.download.center.ui.fusion.manager.decoder.ParseJsonKey;
import com.baidu.searchbox.flowvideo.detail.repos.FavorModel;
import com.baidu.searchbox.video.feedflow.detail.favor.FavorBackModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rR\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/video/collectiondetail/favor/CollectionDetailFavorState;", "", "favorModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/flowvideo/detail/repos/FavorModel;", "favorBackModel", "Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorBackModel;", "isCollFavorBack", "", "ukey", "", "collId", "ubcValue", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;Ljava/lang/String;Ljava/lang/String;)V", "getCollId", "()Ljava/lang/String;", "setCollId", "(Ljava/lang/String;)V", "getFavorBackModel", "()Landroidx/lifecycle/MutableLiveData;", "getFavorModel", "()Z", "setCollFavorBack", "(Z)V", "getUbcValue", "setUbcValue", "getUkey", "setUkey", "(Landroidx/lifecycle/MutableLiveData;)V", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionDetailFavorState.kt */
public final class CollectionDetailFavorState {
    private String collId;
    private final MutableLiveData<FavorBackModel> favorBackModel;
    private final MutableLiveData<FavorModel> favorModel;
    private boolean isCollFavorBack;
    private String ubcValue;
    private MutableLiveData<String> ukey;

    public CollectionDetailFavorState() {
        this((MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public CollectionDetailFavorState(MutableLiveData<FavorModel> favorModel2, MutableLiveData<FavorBackModel> favorBackModel2, boolean isCollFavorBack2, MutableLiveData<String> ukey2, String collId2, String ubcValue2) {
        Intrinsics.checkNotNullParameter(favorModel2, "favorModel");
        Intrinsics.checkNotNullParameter(favorBackModel2, "favorBackModel");
        Intrinsics.checkNotNullParameter(ukey2, "ukey");
        Intrinsics.checkNotNullParameter(collId2, "collId");
        Intrinsics.checkNotNullParameter(ubcValue2, ParseJsonKey.UBC_VALUE);
        this.favorModel = favorModel2;
        this.favorBackModel = favorBackModel2;
        this.isCollFavorBack = isCollFavorBack2;
        this.ukey = ukey2;
        this.collId = collId2;
        this.ubcValue = ubcValue2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CollectionDetailFavorState(androidx.lifecycle.MutableLiveData r5, androidx.lifecycle.MutableLiveData r6, boolean r7, androidx.lifecycle.MutableLiveData r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
        L_0x0009:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0014
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            r12 = r6
            goto L_0x0015
        L_0x0014:
            r12 = r6
        L_0x0015:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x001c
            r7 = 1
            r0 = r7
            goto L_0x001d
        L_0x001c:
            r0 = r7
        L_0x001d:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0028
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x0029
        L_0x0028:
            r1 = r8
        L_0x0029:
            r6 = r11 & 16
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x0031
            r2 = r7
            goto L_0x0032
        L_0x0031:
            r2 = r9
        L_0x0032:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0038
            r3 = r7
            goto L_0x0039
        L_0x0038:
            r3 = r10
        L_0x0039:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, androidx.lifecycle.MutableLiveData, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<FavorModel> getFavorModel() {
        return this.favorModel;
    }

    public final MutableLiveData<FavorBackModel> getFavorBackModel() {
        return this.favorBackModel;
    }

    public final boolean isCollFavorBack() {
        return this.isCollFavorBack;
    }

    public final void setCollFavorBack(boolean z) {
        this.isCollFavorBack = z;
    }

    public final MutableLiveData<String> getUkey() {
        return this.ukey;
    }

    public final void setUkey(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.ukey = mutableLiveData;
    }

    public final String getCollId() {
        return this.collId;
    }

    public final void setCollId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.collId = str;
    }

    public final String getUbcValue() {
        return this.ubcValue;
    }

    public final void setUbcValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ubcValue = str;
    }
}
