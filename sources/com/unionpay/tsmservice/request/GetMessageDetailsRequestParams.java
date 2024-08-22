package com.unionpay.tsmservice.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class GetMessageDetailsRequestParams extends RequestParams {
    public static final Parcelable.Creator<GetMessageDetailsRequestParams> CREATOR = new Parcelable.Creator<GetMessageDetailsRequestParams>() {
        public final GetMessageDetailsRequestParams createFromParcel(Parcel parcel) {
            return new GetMessageDetailsRequestParams(parcel);
        }

        public final GetMessageDetailsRequestParams[] newArray(int i2) {
            return new GetMessageDetailsRequestParams[i2];
        }
    };
    private Bundle mParams;

    public GetMessageDetailsRequestParams() {
    }

    public GetMessageDetailsRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeBundle(this.mParams);
    }
}
