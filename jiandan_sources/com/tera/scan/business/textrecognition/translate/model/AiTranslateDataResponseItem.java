package com.tera.scan.business.textrecognition.translate.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rHÖ\u0001R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/business/textrecognition/translate/model/AiTranslateDataResponseItem;", "Landroid/os/Parcelable;", "()V", "afterTranslate", "", "getAfterTranslate", "()Ljava/lang/String;", "setAfterTranslate", "(Ljava/lang/String;)V", "transKey", "getTransKey", "setTransKey", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AiTranslateDataResponseItem implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<AiTranslateDataResponseItem> CREATOR = new qw();
    @SerializedName("after_translate")
    @Nullable
    public String afterTranslate;
    @SerializedName("trans_key")
    @Nullable
    public String transKey;

    public static final class qw implements Parcelable.Creator<AiTranslateDataResponseItem> {
        @NotNull
        /* renamed from: ad */
        public final AiTranslateDataResponseItem[] newArray(int i2) {
            return new AiTranslateDataResponseItem[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final AiTranslateDataResponseItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new AiTranslateDataResponseItem();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAfterTranslate() {
        return this.afterTranslate;
    }

    @Nullable
    public final String getTransKey() {
        return this.transKey;
    }

    public final void setAfterTranslate(@Nullable String str) {
        this.afterTranslate = str;
    }

    public final void setTransKey(@Nullable String str) {
        this.transKey = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
