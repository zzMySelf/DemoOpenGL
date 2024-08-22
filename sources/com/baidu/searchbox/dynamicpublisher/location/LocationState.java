package com.baidu.searchbox.dynamicpublisher.location;

import androidx.lifecycle.MutableLiveData;
import com.baidu.ugc.position.model.PoiModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0013\b\u0002\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b0\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0002\u0010\u0012J\u0014\u0010\u001b\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003HÆ\u0003J#\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b0\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0003J\u0001\u0010\"\u001a\u00020\u00002\u0013\b\u0002\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00032\"\b\u0002\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b0\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R+\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006("}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/location/LocationState;", "", "guideType", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/baidu/searchbox/dynamicpublisher/location/LocGuideType;", "selectedLocModel", "Lcom/baidu/searchbox/dynamicpublisher/location/SelectedLocModel;", "recommendPoiList", "Ljava/util/ArrayList;", "Lcom/baidu/ugc/position/model/PoiModel;", "Lkotlin/collections/ArrayList;", "placePoiModel", "collection", "", "restoration", "hideLocationView", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getCollection", "()Landroidx/lifecycle/MutableLiveData;", "getGuideType", "getHideLocationView", "getPlacePoiModel", "getRecommendPoiList", "getRestoration", "getSelectedLocModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationState.kt */
public final class LocationState {
    private final MutableLiveData<Unit> collection;
    private final MutableLiveData<Integer> guideType;
    private final MutableLiveData<Boolean> hideLocationView;
    private final MutableLiveData<PoiModel> placePoiModel;
    private final MutableLiveData<ArrayList<PoiModel>> recommendPoiList;
    private final MutableLiveData<SelectedLocModel> restoration;
    private final MutableLiveData<SelectedLocModel> selectedLocModel;

    public LocationState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LocationState copy$default(LocationState locationState, MutableLiveData<Integer> mutableLiveData, MutableLiveData<SelectedLocModel> mutableLiveData2, MutableLiveData<ArrayList<PoiModel>> mutableLiveData3, MutableLiveData<PoiModel> mutableLiveData4, MutableLiveData<Unit> mutableLiveData5, MutableLiveData<SelectedLocModel> mutableLiveData6, MutableLiveData<Boolean> mutableLiveData7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = locationState.guideType;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = locationState.selectedLocModel;
        }
        MutableLiveData<SelectedLocModel> mutableLiveData8 = mutableLiveData2;
        if ((i2 & 4) != 0) {
            mutableLiveData3 = locationState.recommendPoiList;
        }
        MutableLiveData<ArrayList<PoiModel>> mutableLiveData9 = mutableLiveData3;
        if ((i2 & 8) != 0) {
            mutableLiveData4 = locationState.placePoiModel;
        }
        MutableLiveData<PoiModel> mutableLiveData10 = mutableLiveData4;
        if ((i2 & 16) != 0) {
            mutableLiveData5 = locationState.collection;
        }
        MutableLiveData<Unit> mutableLiveData11 = mutableLiveData5;
        if ((i2 & 32) != 0) {
            mutableLiveData6 = locationState.restoration;
        }
        MutableLiveData<SelectedLocModel> mutableLiveData12 = mutableLiveData6;
        if ((i2 & 64) != 0) {
            mutableLiveData7 = locationState.hideLocationView;
        }
        return locationState.copy(mutableLiveData, mutableLiveData8, mutableLiveData9, mutableLiveData10, mutableLiveData11, mutableLiveData12, mutableLiveData7);
    }

    public final MutableLiveData<Integer> component1() {
        return this.guideType;
    }

    public final MutableLiveData<SelectedLocModel> component2() {
        return this.selectedLocModel;
    }

    public final MutableLiveData<ArrayList<PoiModel>> component3() {
        return this.recommendPoiList;
    }

    public final MutableLiveData<PoiModel> component4() {
        return this.placePoiModel;
    }

    public final MutableLiveData<Unit> component5() {
        return this.collection;
    }

    public final MutableLiveData<SelectedLocModel> component6() {
        return this.restoration;
    }

    public final MutableLiveData<Boolean> component7() {
        return this.hideLocationView;
    }

    public final LocationState copy(MutableLiveData<Integer> mutableLiveData, MutableLiveData<SelectedLocModel> mutableLiveData2, MutableLiveData<ArrayList<PoiModel>> mutableLiveData3, MutableLiveData<PoiModel> mutableLiveData4, MutableLiveData<Unit> mutableLiveData5, MutableLiveData<SelectedLocModel> mutableLiveData6, MutableLiveData<Boolean> mutableLiveData7) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "guideType");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "selectedLocModel");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "recommendPoiList");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "placePoiModel");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "collection");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "restoration");
        Intrinsics.checkNotNullParameter(mutableLiveData7, "hideLocationView");
        return new LocationState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4, mutableLiveData5, mutableLiveData6, mutableLiveData7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationState)) {
            return false;
        }
        LocationState locationState = (LocationState) obj;
        return Intrinsics.areEqual((Object) this.guideType, (Object) locationState.guideType) && Intrinsics.areEqual((Object) this.selectedLocModel, (Object) locationState.selectedLocModel) && Intrinsics.areEqual((Object) this.recommendPoiList, (Object) locationState.recommendPoiList) && Intrinsics.areEqual((Object) this.placePoiModel, (Object) locationState.placePoiModel) && Intrinsics.areEqual((Object) this.collection, (Object) locationState.collection) && Intrinsics.areEqual((Object) this.restoration, (Object) locationState.restoration) && Intrinsics.areEqual((Object) this.hideLocationView, (Object) locationState.hideLocationView);
    }

    public int hashCode() {
        return (((((((((((this.guideType.hashCode() * 31) + this.selectedLocModel.hashCode()) * 31) + this.recommendPoiList.hashCode()) * 31) + this.placePoiModel.hashCode()) * 31) + this.collection.hashCode()) * 31) + this.restoration.hashCode()) * 31) + this.hideLocationView.hashCode();
    }

    public String toString() {
        return "LocationState(guideType=" + this.guideType + ", selectedLocModel=" + this.selectedLocModel + ", recommendPoiList=" + this.recommendPoiList + ", placePoiModel=" + this.placePoiModel + ", collection=" + this.collection + ", restoration=" + this.restoration + ", hideLocationView=" + this.hideLocationView + ')';
    }

    public LocationState(MutableLiveData<Integer> guideType2, MutableLiveData<SelectedLocModel> selectedLocModel2, MutableLiveData<ArrayList<PoiModel>> recommendPoiList2, MutableLiveData<PoiModel> placePoiModel2, MutableLiveData<Unit> collection2, MutableLiveData<SelectedLocModel> restoration2, MutableLiveData<Boolean> hideLocationView2) {
        Intrinsics.checkNotNullParameter(guideType2, "guideType");
        Intrinsics.checkNotNullParameter(selectedLocModel2, "selectedLocModel");
        Intrinsics.checkNotNullParameter(recommendPoiList2, "recommendPoiList");
        Intrinsics.checkNotNullParameter(placePoiModel2, "placePoiModel");
        Intrinsics.checkNotNullParameter(collection2, "collection");
        Intrinsics.checkNotNullParameter(restoration2, "restoration");
        Intrinsics.checkNotNullParameter(hideLocationView2, "hideLocationView");
        this.guideType = guideType2;
        this.selectedLocModel = selectedLocModel2;
        this.recommendPoiList = recommendPoiList2;
        this.placePoiModel = placePoiModel2;
        this.collection = collection2;
        this.restoration = restoration2;
        this.hideLocationView = hideLocationView2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LocationState(androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, androidx.lifecycle.MutableLiveData r11, androidx.lifecycle.MutableLiveData r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
        L_0x0009:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0014
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r14 = r7
            goto L_0x0015
        L_0x0014:
            r14 = r7
        L_0x0015:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0020
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r0 = r8
            goto L_0x0021
        L_0x0020:
            r0 = r8
        L_0x0021:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x002c
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            r1 = r9
            goto L_0x002d
        L_0x002c:
            r1 = r9
        L_0x002d:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0038
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r2 = r10
            goto L_0x0039
        L_0x0038:
            r2 = r10
        L_0x0039:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0044
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            r11.<init>()
            r3 = r11
            goto L_0x0045
        L_0x0044:
            r3 = r11
        L_0x0045:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0050
            androidx.lifecycle.MutableLiveData r12 = new androidx.lifecycle.MutableLiveData
            r12.<init>()
            r4 = r12
            goto L_0x0051
        L_0x0050:
            r4 = r12
        L_0x0051:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.location.LocationState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Integer> getGuideType() {
        return this.guideType;
    }

    public final MutableLiveData<SelectedLocModel> getSelectedLocModel() {
        return this.selectedLocModel;
    }

    public final MutableLiveData<ArrayList<PoiModel>> getRecommendPoiList() {
        return this.recommendPoiList;
    }

    public final MutableLiveData<PoiModel> getPlacePoiModel() {
        return this.placePoiModel;
    }

    public final MutableLiveData<Unit> getCollection() {
        return this.collection;
    }

    public final MutableLiveData<SelectedLocModel> getRestoration() {
        return this.restoration;
    }

    public final MutableLiveData<Boolean> getHideLocationView() {
        return this.hideLocationView;
    }
}
