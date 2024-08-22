package com.tera.scan.business.textrecognition.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nHÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/business/textrecognition/model/OcrResultModel;", "Landroid/os/Parcelable;", "()V", "data", "", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OcrResultModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<OcrResultModel> CREATOR = new qw();
    @SerializedName("data")
    @Nullable
    public String data;

    public static final class qw implements Parcelable.Creator<OcrResultModel> {
        @NotNull
        /* renamed from: ad */
        public final OcrResultModel[] newArray(int i2) {
            return new OcrResultModel[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final OcrResultModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new OcrResultModel();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    public final void setData(@Nullable String str) {
        this.data = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
