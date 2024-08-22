package com.tera.scan.vip.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tera.scan.network.network.response.DefaultResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/tera/scan/vip/network/model/ReportGooglePayTokenResponse;", "Lcom/tera/scan/network/network/response/DefaultResponse;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReportGooglePayTokenResponse extends DefaultResponse implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ReportGooglePayTokenResponse> CREATOR = new qw();

    public static final class qw implements Parcelable.Creator<ReportGooglePayTokenResponse> {
        @NotNull
        /* renamed from: ad */
        public final ReportGooglePayTokenResponse[] newArray(int i2) {
            return new ReportGooglePayTokenResponse[i2];
        }

        @NotNull
        /* renamed from: qw */
        public final ReportGooglePayTokenResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new ReportGooglePayTokenResponse();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
