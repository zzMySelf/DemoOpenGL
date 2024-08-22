package com.tera.scan.pdfedit.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "Landroid/os/Parcelable;", "scanRecordExportFile", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "isSelected", "", "(Lcom/tera/scan/record/model/ScanRecordExportFile;Z)V", "fileName", "", "getFileName", "()Ljava/lang/String;", "fileSize", "", "getFileSize", "()J", "fileSize$delegate", "Lkotlin/Lazy;", "()Z", "setSelected", "(Z)V", "lastModified", "getLastModified", "lastModified$delegate", "getScanRecordExportFile", "()Lcom/tera/scan/record/model/ScanRecordExportFile;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddPdfItemData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<AddPdfItemData> CREATOR = new qw();
    @NotNull
    public final String fileName;
    @NotNull
    public final Lazy fileSize$delegate;
    public boolean isSelected;
    @NotNull
    public final Lazy lastModified$delegate;
    @NotNull
    public final ScanRecordExportFile scanRecordExportFile;

    public static final class qw implements Parcelable.Creator<AddPdfItemData> {
        @NotNull
        /* renamed from: ad */
        public final AddPdfItemData[] newArray(int i2) {
            return new AddPdfItemData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final AddPdfItemData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddPdfItemData((ScanRecordExportFile) parcel.readParcelable(AddPdfItemData.class.getClassLoader()), parcel.readInt() != 0);
        }
    }

    public AddPdfItemData(@NotNull ScanRecordExportFile scanRecordExportFile2, boolean z) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile2, "scanRecordExportFile");
        this.scanRecordExportFile = scanRecordExportFile2;
        this.isSelected = z;
        this.fileName = scanRecordExportFile2.getFileName();
        this.lastModified$delegate = LazyKt__LazyJVMKt.lazy(new AddPdfItemData$lastModified$2(this));
        this.fileSize$delegate = LazyKt__LazyJVMKt.lazy(new AddPdfItemData$fileSize$2(this));
    }

    public static /* synthetic */ AddPdfItemData copy$default(AddPdfItemData addPdfItemData, ScanRecordExportFile scanRecordExportFile2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            scanRecordExportFile2 = addPdfItemData.scanRecordExportFile;
        }
        if ((i2 & 2) != 0) {
            z = addPdfItemData.isSelected;
        }
        return addPdfItemData.copy(scanRecordExportFile2, z);
    }

    @NotNull
    public final ScanRecordExportFile component1() {
        return this.scanRecordExportFile;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    @NotNull
    public final AddPdfItemData copy(@NotNull ScanRecordExportFile scanRecordExportFile2, boolean z) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile2, "scanRecordExportFile");
        return new AddPdfItemData(scanRecordExportFile2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddPdfItemData)) {
            return false;
        }
        AddPdfItemData addPdfItemData = (AddPdfItemData) obj;
        return Intrinsics.areEqual((Object) this.scanRecordExportFile, (Object) addPdfItemData.scanRecordExportFile) && this.isSelected == addPdfItemData.isSelected;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return ((Number) this.fileSize$delegate.getValue()).longValue();
    }

    public final long getLastModified() {
        return ((Number) this.lastModified$delegate.getValue()).longValue();
    }

    @NotNull
    public final ScanRecordExportFile getScanRecordExportFile() {
        return this.scanRecordExportFile;
    }

    public int hashCode() {
        int hashCode = this.scanRecordExportFile.hashCode() * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @NotNull
    public String toString() {
        return "AddPdfItemData(scanRecordExportFile=" + this.scanRecordExportFile + ", isSelected=" + this.isSelected + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.scanRecordExportFile, i2);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddPdfItemData(ScanRecordExportFile scanRecordExportFile2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(scanRecordExportFile2, (i2 & 2) != 0 ? false : z);
    }
}
