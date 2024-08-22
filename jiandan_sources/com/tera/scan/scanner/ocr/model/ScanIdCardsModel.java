package com.tera.scan.scanner.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006$"}, d2 = {"Lcom/tera/scan/scanner/ocr/model/ScanIdCardsModel;", "Landroid/os/Parcelable;", "category", "", "bigImageRes", "titleRes", "(Ljava/lang/Integer;ILjava/lang/Integer;)V", "getBigImageRes", "()I", "setBigImageRes", "(I)V", "getCategory", "()Ljava/lang/Integer;", "setCategory", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitleRes", "setTitleRes", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;ILjava/lang/Integer;)Lcom/tera/scan/scanner/ocr/model/ScanIdCardsModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ScanIdCardsModel> CREATOR = new qw();
    public int bigImageRes;
    @Nullable
    public Integer category;
    @Nullable
    public Integer titleRes;

    public static final class qw implements Parcelable.Creator<ScanIdCardsModel> {
        @NotNull
        /* renamed from: ad */
        public final ScanIdCardsModel[] newArray(int i2) {
            return new ScanIdCardsModel[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ScanIdCardsModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer num = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new ScanIdCardsModel(valueOf, readInt, num);
        }
    }

    public ScanIdCardsModel() {
        this((Integer) null, 0, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public ScanIdCardsModel(@Nullable Integer num, int i2, @Nullable Integer num2) {
        this.category = num;
        this.bigImageRes = i2;
        this.titleRes = num2;
    }

    public static /* synthetic */ ScanIdCardsModel copy$default(ScanIdCardsModel scanIdCardsModel, Integer num, int i2, Integer num2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = scanIdCardsModel.category;
        }
        if ((i3 & 2) != 0) {
            i2 = scanIdCardsModel.bigImageRes;
        }
        if ((i3 & 4) != 0) {
            num2 = scanIdCardsModel.titleRes;
        }
        return scanIdCardsModel.copy(num, i2, num2);
    }

    @Nullable
    public final Integer component1() {
        return this.category;
    }

    public final int component2() {
        return this.bigImageRes;
    }

    @Nullable
    public final Integer component3() {
        return this.titleRes;
    }

    @NotNull
    public final ScanIdCardsModel copy(@Nullable Integer num, int i2, @Nullable Integer num2) {
        return new ScanIdCardsModel(num, i2, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScanIdCardsModel)) {
            return false;
        }
        ScanIdCardsModel scanIdCardsModel = (ScanIdCardsModel) obj;
        return Intrinsics.areEqual((Object) this.category, (Object) scanIdCardsModel.category) && this.bigImageRes == scanIdCardsModel.bigImageRes && Intrinsics.areEqual((Object) this.titleRes, (Object) scanIdCardsModel.titleRes);
    }

    public final int getBigImageRes() {
        return this.bigImageRes;
    }

    @Nullable
    public final Integer getCategory() {
        return this.category;
    }

    @Nullable
    public final Integer getTitleRes() {
        return this.titleRes;
    }

    public int hashCode() {
        Integer num = this.category;
        int i2 = 0;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.bigImageRes) * 31;
        Integer num2 = this.titleRes;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        return hashCode + i2;
    }

    public final void setBigImageRes(int i2) {
        this.bigImageRes = i2;
    }

    public final void setCategory(@Nullable Integer num) {
        this.category = num;
    }

    public final void setTitleRes(@Nullable Integer num) {
        this.titleRes = num;
    }

    @NotNull
    public String toString() {
        return "ScanIdCardsModel(category=" + this.category + ", bigImageRes=" + this.bigImageRes + ", titleRes=" + this.titleRes + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.category;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.bigImageRes);
        Integer num2 = this.titleRes;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanIdCardsModel(Integer num, int i2, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : num2);
    }
}
