package com.baidu.searchbox.dynamicpublisher.selectcategory;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.ugc.category.model.CategoryLabelValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003Jo\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/selectcategory/CategorySelectState;", "", "labelValue", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/ugc/category/model/CategoryLabelValue;", "sourceFrom", "", "collection", "", "restoration", "prePublishSwitch", "", "hideCategorySelectView", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getCollection", "()Landroidx/lifecycle/MutableLiveData;", "getHideCategorySelectView", "getLabelValue", "getPrePublishSwitch", "getRestoration", "getSourceFrom", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CategorySelectState.kt */
public final class CategorySelectState {
    private final MutableLiveData<Unit> collection;
    private final MutableLiveData<Boolean> hideCategorySelectView;
    private final MutableLiveData<CategoryLabelValue> labelValue;
    private final MutableLiveData<Boolean> prePublishSwitch;
    private final MutableLiveData<CategoryLabelValue> restoration;
    private final MutableLiveData<String> sourceFrom;

    public CategorySelectState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CategorySelectState copy$default(CategorySelectState categorySelectState, MutableLiveData<CategoryLabelValue> mutableLiveData, MutableLiveData<String> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<CategoryLabelValue> mutableLiveData4, MutableLiveData<Boolean> mutableLiveData5, MutableLiveData<Boolean> mutableLiveData6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = categorySelectState.labelValue;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = categorySelectState.sourceFrom;
        }
        MutableLiveData<String> mutableLiveData7 = mutableLiveData2;
        if ((i2 & 4) != 0) {
            mutableLiveData3 = categorySelectState.collection;
        }
        MutableLiveData<Unit> mutableLiveData8 = mutableLiveData3;
        if ((i2 & 8) != 0) {
            mutableLiveData4 = categorySelectState.restoration;
        }
        MutableLiveData<CategoryLabelValue> mutableLiveData9 = mutableLiveData4;
        if ((i2 & 16) != 0) {
            mutableLiveData5 = categorySelectState.prePublishSwitch;
        }
        MutableLiveData<Boolean> mutableLiveData10 = mutableLiveData5;
        if ((i2 & 32) != 0) {
            mutableLiveData6 = categorySelectState.hideCategorySelectView;
        }
        return categorySelectState.copy(mutableLiveData, mutableLiveData7, mutableLiveData8, mutableLiveData9, mutableLiveData10, mutableLiveData6);
    }

    public final MutableLiveData<CategoryLabelValue> component1() {
        return this.labelValue;
    }

    public final MutableLiveData<String> component2() {
        return this.sourceFrom;
    }

    public final MutableLiveData<Unit> component3() {
        return this.collection;
    }

    public final MutableLiveData<CategoryLabelValue> component4() {
        return this.restoration;
    }

    public final MutableLiveData<Boolean> component5() {
        return this.prePublishSwitch;
    }

    public final MutableLiveData<Boolean> component6() {
        return this.hideCategorySelectView;
    }

    public final CategorySelectState copy(MutableLiveData<CategoryLabelValue> mutableLiveData, MutableLiveData<String> mutableLiveData2, MutableLiveData<Unit> mutableLiveData3, MutableLiveData<CategoryLabelValue> mutableLiveData4, MutableLiveData<Boolean> mutableLiveData5, MutableLiveData<Boolean> mutableLiveData6) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "labelValue");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "sourceFrom");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "collection");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "restoration");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "prePublishSwitch");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "hideCategorySelectView");
        return new CategorySelectState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4, mutableLiveData5, mutableLiveData6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategorySelectState)) {
            return false;
        }
        CategorySelectState categorySelectState = (CategorySelectState) obj;
        return Intrinsics.areEqual((Object) this.labelValue, (Object) categorySelectState.labelValue) && Intrinsics.areEqual((Object) this.sourceFrom, (Object) categorySelectState.sourceFrom) && Intrinsics.areEqual((Object) this.collection, (Object) categorySelectState.collection) && Intrinsics.areEqual((Object) this.restoration, (Object) categorySelectState.restoration) && Intrinsics.areEqual((Object) this.prePublishSwitch, (Object) categorySelectState.prePublishSwitch) && Intrinsics.areEqual((Object) this.hideCategorySelectView, (Object) categorySelectState.hideCategorySelectView);
    }

    public int hashCode() {
        return (((((((((this.labelValue.hashCode() * 31) + this.sourceFrom.hashCode()) * 31) + this.collection.hashCode()) * 31) + this.restoration.hashCode()) * 31) + this.prePublishSwitch.hashCode()) * 31) + this.hideCategorySelectView.hashCode();
    }

    public String toString() {
        return "CategorySelectState(labelValue=" + this.labelValue + ", sourceFrom=" + this.sourceFrom + ", collection=" + this.collection + ", restoration=" + this.restoration + ", prePublishSwitch=" + this.prePublishSwitch + ", hideCategorySelectView=" + this.hideCategorySelectView + ')';
    }

    public CategorySelectState(MutableLiveData<CategoryLabelValue> labelValue2, MutableLiveData<String> sourceFrom2, MutableLiveData<Unit> collection2, MutableLiveData<CategoryLabelValue> restoration2, MutableLiveData<Boolean> prePublishSwitch2, MutableLiveData<Boolean> hideCategorySelectView2) {
        Intrinsics.checkNotNullParameter(labelValue2, "labelValue");
        Intrinsics.checkNotNullParameter(sourceFrom2, "sourceFrom");
        Intrinsics.checkNotNullParameter(collection2, "collection");
        Intrinsics.checkNotNullParameter(restoration2, "restoration");
        Intrinsics.checkNotNullParameter(prePublishSwitch2, "prePublishSwitch");
        Intrinsics.checkNotNullParameter(hideCategorySelectView2, "hideCategorySelectView");
        this.labelValue = labelValue2;
        this.sourceFrom = sourceFrom2;
        this.collection = collection2;
        this.restoration = restoration2;
        this.prePublishSwitch = prePublishSwitch2;
        this.hideCategorySelectView = hideCategorySelectView2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CategorySelectState(androidx.lifecycle.MutableLiveData r5, androidx.lifecycle.MutableLiveData r6, androidx.lifecycle.MutableLiveData r7, androidx.lifecycle.MutableLiveData r8, androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
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
            if (r6 == 0) goto L_0x0020
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r0 = r7
            goto L_0x0021
        L_0x0020:
            r0 = r7
        L_0x0021:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x002c
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x002d
        L_0x002c:
            r1 = r8
        L_0x002d:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0038
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            r2 = r9
            goto L_0x0039
        L_0x0038:
            r2 = r9
        L_0x0039:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0044
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r3 = r10
            goto L_0x0045
        L_0x0044:
            r3 = r10
        L_0x0045:
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.selectcategory.CategorySelectState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<CategoryLabelValue> getLabelValue() {
        return this.labelValue;
    }

    public final MutableLiveData<String> getSourceFrom() {
        return this.sourceFrom;
    }

    public final MutableLiveData<Unit> getCollection() {
        return this.collection;
    }

    public final MutableLiveData<CategoryLabelValue> getRestoration() {
        return this.restoration;
    }

    public final MutableLiveData<Boolean> getPrePublishSwitch() {
        return this.prePublishSwitch;
    }

    public final MutableLiveData<Boolean> getHideCategorySelectView() {
        return this.hideCategorySelectView;
    }
}
