package com.tera.scan.business.textrecognition.translate.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/business/textrecognition/translate/model/AiTranslateDataItem;", "Landroid/os/Parcelable;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "transKey", "getTransKey", "setTransKey", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AiTranslateDataItem implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<AiTranslateDataItem> CREATOR = new qw();
    @NotNull
    public String content = "";
    @SerializedName("trans_key")
    @NotNull
    public String transKey = "";

    public static final class qw implements Parcelable.Creator<AiTranslateDataItem> {
        @NotNull
        /* renamed from: ad */
        public final AiTranslateDataItem[] newArray(int i2) {
            return new AiTranslateDataItem[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final AiTranslateDataItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new AiTranslateDataItem();
        }
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getTransKey() {
        return this.transKey;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setTransKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.transKey = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
