package com.baidu.searchbox.dynamicpublisher.locselect;

import com.baidu.ugc.position.model.PoiModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J3\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/locselect/LocSelectPresetModel;", "", "currentPoi", "Lcom/baidu/ugc/position/model/PoiModel;", "recommends", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/baidu/ugc/position/model/PoiModel;Ljava/util/ArrayList;)V", "getCurrentPoi", "()Lcom/baidu/ugc/position/model/PoiModel;", "getRecommends", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocSelectPresetModel.kt */
public final class LocSelectPresetModel {
    private final PoiModel currentPoi;
    private final ArrayList<PoiModel> recommends;

    public LocSelectPresetModel() {
        this((PoiModel) null, (ArrayList) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LocSelectPresetModel copy$default(LocSelectPresetModel locSelectPresetModel, PoiModel poiModel, ArrayList<PoiModel> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            poiModel = locSelectPresetModel.currentPoi;
        }
        if ((i2 & 2) != 0) {
            arrayList = locSelectPresetModel.recommends;
        }
        return locSelectPresetModel.copy(poiModel, arrayList);
    }

    public final PoiModel component1() {
        return this.currentPoi;
    }

    public final ArrayList<PoiModel> component2() {
        return this.recommends;
    }

    public final LocSelectPresetModel copy(PoiModel poiModel, ArrayList<PoiModel> arrayList) {
        return new LocSelectPresetModel(poiModel, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocSelectPresetModel)) {
            return false;
        }
        LocSelectPresetModel locSelectPresetModel = (LocSelectPresetModel) obj;
        return Intrinsics.areEqual((Object) this.currentPoi, (Object) locSelectPresetModel.currentPoi) && Intrinsics.areEqual((Object) this.recommends, (Object) locSelectPresetModel.recommends);
    }

    public int hashCode() {
        PoiModel poiModel = this.currentPoi;
        int i2 = 0;
        int hashCode = (poiModel == null ? 0 : poiModel.hashCode()) * 31;
        ArrayList<PoiModel> arrayList = this.recommends;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "LocSelectPresetModel(currentPoi=" + this.currentPoi + ", recommends=" + this.recommends + ')';
    }

    public LocSelectPresetModel(PoiModel currentPoi2, ArrayList<PoiModel> recommends2) {
        this.currentPoi = currentPoi2;
        this.recommends = recommends2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocSelectPresetModel(PoiModel poiModel, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : poiModel, (i2 & 2) != 0 ? null : arrayList);
    }

    public final PoiModel getCurrentPoi() {
        return this.currentPoi;
    }

    public final ArrayList<PoiModel> getRecommends() {
        return this.recommends;
    }
}
