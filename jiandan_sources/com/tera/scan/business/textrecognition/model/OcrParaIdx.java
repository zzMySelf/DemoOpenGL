package com.tera.scan.business.textrecognition.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005HÖ\u0001R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/business/textrecognition/model/OcrParaIdx;", "Landroid/os/Parcelable;", "()V", "idx", "", "", "getIdx", "()Ljava/util/List;", "setIdx", "(Ljava/util/List;)V", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OcrParaIdx implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<OcrParaIdx> CREATOR = new qw();
    @SerializedName("idx")
    @Nullable
    public List<Integer> idx;

    public static final class qw implements Parcelable.Creator<OcrParaIdx> {
        @NotNull
        /* renamed from: ad */
        public final OcrParaIdx[] newArray(int i2) {
            return new OcrParaIdx[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final OcrParaIdx createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new OcrParaIdx();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<Integer> getIdx() {
        return this.idx;
    }

    public final void setIdx(@Nullable List<Integer> list) {
        this.idx = list;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
