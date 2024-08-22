package com.tera.scan.business.textrecognition.translate.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tera.scan.network.network.response.DefaultResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/tera/scan/business/textrecognition/translate/model/AiTranslateResponse;", "Lcom/tera/scan/network/network/response/DefaultResponse;", "Landroid/os/Parcelable;", "()V", "data", "Lcom/tera/scan/business/textrecognition/translate/model/AiTranslateResponseData;", "getData", "()Lcom/tera/scan/business/textrecognition/translate/model/AiTranslateResponseData;", "setData", "(Lcom/tera/scan/business/textrecognition/translate/model/AiTranslateResponseData;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AiTranslateResponse extends DefaultResponse implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<AiTranslateResponse> CREATOR = new qw();
    @SerializedName("data")
    @Nullable
    public AiTranslateResponseData data;

    public static final class qw implements Parcelable.Creator<AiTranslateResponse> {
        @NotNull
        /* renamed from: ad */
        public final AiTranslateResponse[] newArray(int i2) {
            return new AiTranslateResponse[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final AiTranslateResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new AiTranslateResponse();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AiTranslateResponseData getData() {
        return this.data;
    }

    public final void setData(@Nullable AiTranslateResponseData aiTranslateResponseData) {
        this.data = aiTranslateResponseData;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
