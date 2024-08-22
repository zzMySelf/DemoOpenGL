package com.tera.scan.libanalytics.activation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0019\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/libanalytics/activation/model/Response;", "Lcom/tera/scan/libanalytics/activation/model/IResponse;", "Landroid/os/Parcelable;", "errorNo", "", "requestId", "", "errorMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "yme", "getYme", "()Ljava/lang/String;", "setYme", "(Ljava/lang/String;)V", "describeContents", "getErrorMsg", "getErrorNo", "getHeaderYme", "getRequestId", "isSuccess", "", "setHeaderYme", "", "headerYme", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "lib_analytics_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Response extends fe.mmm.qw.ggg.ad.th.qw implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<Response> CREATOR = new qw();
    @SerializedName("errmsg")
    @Nullable
    public final String errorMsg;
    @SerializedName("errno")
    public final int errorNo;
    @SerializedName("request_id")
    @Nullable
    public final String requestId;
    @NotNull
    public String yme;

    public static final class qw implements Parcelable.Creator<Response> {
        @NotNull
        /* renamed from: ad */
        public final Response[] newArray(int i2) {
            return new Response[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final Response createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Response(parcel.readInt(), parcel.readString(), parcel.readString());
        }
    }

    public Response() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Response(int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2);
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public String getErrorMsg() {
        String str = this.errorMsg;
        return str == null ? "" : str;
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    @NotNull
    public String getHeaderYme() {
        return this.yme;
    }

    @NotNull
    public String getRequestId() {
        String str = this.requestId;
        return str == null ? "" : str;
    }

    @NotNull
    public final String getYme() {
        return this.yme;
    }

    public boolean isSuccess() {
        return this.errorNo == 0;
    }

    public void setHeaderYme(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "headerYme");
        this.yme = str;
    }

    public final void setYme(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.yme = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.errorNo);
        parcel.writeString(this.requestId);
        parcel.writeString(this.errorMsg);
    }

    public Response(int i2, @Nullable String str, @Nullable String str2) {
        this.errorNo = i2;
        this.requestId = str;
        this.errorMsg = str2;
        this.yme = "";
    }
}
