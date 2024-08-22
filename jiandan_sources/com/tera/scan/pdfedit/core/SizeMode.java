package com.tera.scan.pdfedit.core;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/pdfedit/core/SizeMode;", "", "Landroid/os/Parcelable;", "typeValue", "", "(Ljava/lang/String;II)V", "getTypeValue", "()I", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ORIGIN", "A4", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SizeMode implements Parcelable {
    ORIGIN(0),
    A4(1);
    
    @NotNull
    public static final Parcelable.Creator<SizeMode> CREATOR = null;
    public final int typeValue;

    public static final class qw implements Parcelable.Creator<SizeMode> {
        @NotNull
        /* renamed from: ad */
        public final SizeMode[] newArray(int i2) {
            return new SizeMode[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final SizeMode createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return SizeMode.valueOf(parcel.readString());
        }
    }

    /* access modifiers changed from: public */
    static {
        CREATOR = new qw();
    }

    /* access modifiers changed from: public */
    SizeMode(int i2) {
        this.typeValue = i2;
    }

    public int describeContents() {
        return 0;
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(name());
    }
}
