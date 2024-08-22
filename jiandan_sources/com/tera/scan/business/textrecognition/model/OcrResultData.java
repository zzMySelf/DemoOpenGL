package com.tera.scan.business.textrecognition.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u001b\u001a\u00020\u0011HÖ\u0001J\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011HÖ\u0001R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006\""}, d2 = {"Lcom/tera/scan/business/textrecognition/model/OcrResultData;", "Landroid/os/Parcelable;", "()V", "combineRet", "", "Lcom/tera/scan/business/textrecognition/model/OcrCombineRetItem;", "getCombineRet", "()Ljava/util/List;", "setCombineRet", "(Ljava/util/List;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errNo", "", "getErrNo", "()Ljava/lang/Integer;", "setErrNo", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "paragraphs", "Lcom/tera/scan/business/textrecognition/model/OcrParagraphItem;", "getParagraphs", "setParagraphs", "describeContents", "transformText", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OcrResultData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<OcrResultData> CREATOR = new qw();
    @SerializedName("combine_ret")
    @Nullable
    public List<OcrCombineRetItem> combineRet;
    @SerializedName("err_msg")
    @Nullable
    public String errMsg;
    @SerializedName("err_no")
    @Nullable
    public Integer errNo;
    @SerializedName("paragraphs")
    @Nullable
    public List<OcrParagraphItem> paragraphs;

    public static final class qw implements Parcelable.Creator<OcrResultData> {
        @NotNull
        /* renamed from: ad */
        public final OcrResultData[] newArray(int i2) {
            return new OcrResultData[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final OcrResultData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new OcrResultData();
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<OcrCombineRetItem> getCombineRet() {
        return this.combineRet;
    }

    @Nullable
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    public final Integer getErrNo() {
        return this.errNo;
    }

    @Nullable
    public final List<OcrParagraphItem> getParagraphs() {
        return this.paragraphs;
    }

    public final void setCombineRet(@Nullable List<OcrCombineRetItem> list) {
        this.combineRet = list;
    }

    public final void setErrMsg(@Nullable String str) {
        this.errMsg = str;
    }

    public final void setErrNo(@Nullable Integer num) {
        this.errNo = num;
    }

    public final void setParagraphs(@Nullable List<OcrParagraphItem> list) {
        this.paragraphs = list;
    }

    @Nullable
    public final String transformText() {
        List<OcrParagraphItem> list = this.paragraphs;
        if (list != null) {
            return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), OcrResultData$transformText$1$1.INSTANCE), new OcrResultData$transformText$1$2(this)), OcrResultData$transformText$1$3.INSTANCE), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return null;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
