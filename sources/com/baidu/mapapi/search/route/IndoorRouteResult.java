package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private List<IndoorRouteLine> f14634a;

    public IndoorRouteResult() {
    }

    protected IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f14634a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f14634a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f14634a = list;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeTypedList(this.f14634a);
    }
}
