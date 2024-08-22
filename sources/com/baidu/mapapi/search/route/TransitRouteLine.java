package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

public final class TransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<TransitRouteLine> CREATOR = new o();

    /* renamed from: h  reason: collision with root package name */
    private TaxiInfo f14671h;

    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new p();

        /* renamed from: d  reason: collision with root package name */
        private VehicleInfo f14672d;

        /* renamed from: e  reason: collision with root package name */
        private RouteNode f14673e;

        /* renamed from: f  reason: collision with root package name */
        private RouteNode f14674f;

        /* renamed from: g  reason: collision with root package name */
        private TransitRouteStepType f14675g;

        /* renamed from: h  reason: collision with root package name */
        private String f14676h;

        /* renamed from: i  reason: collision with root package name */
        private String f14677i;

        public enum TransitRouteStepType {
            BUSLINE,
            SUBWAY,
            WAKLING
        }

        public TransitStep() {
        }

        protected TransitStep(Parcel parcel) {
            super(parcel);
            this.f14672d = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f14673e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f14674f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int readInt = parcel.readInt();
            this.f14675g = readInt == -1 ? null : TransitRouteStepType.values()[readInt];
            this.f14676h = parcel.readString();
            this.f14677i = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public RouteNode getEntrance() {
            return this.f14673e;
        }

        public RouteNode getExit() {
            return this.f14674f;
        }

        public String getInstructions() {
            return this.f14676h;
        }

        public TransitRouteStepType getStepType() {
            return this.f14675g;
        }

        public VehicleInfo getVehicleInfo() {
            return this.f14672d;
        }

        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f14677i);
            }
            return this.mWayPoints;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f14673e = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f14674f = routeNode;
        }

        public void setInstructions(String str) {
            this.f14676h = str;
        }

        public void setPathString(String str) {
            this.f14677i = str;
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            this.f14675g = transitRouteStepType;
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            this.f14672d = vehicleInfo;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f14672d, 1);
            parcel.writeParcelable(this.f14673e, 1);
            parcel.writeParcelable(this.f14674f, 1);
            TransitRouteStepType transitRouteStepType = this.f14675g;
            parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
            parcel.writeString(this.f14676h);
            parcel.writeString(this.f14677i);
        }
    }

    public TransitRouteLine() {
    }

    protected TransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f14671h = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public TaxiInfo getTaxitInfo() {
        return this.f14671h;
    }

    public void setTaxitInfo(TaxiInfo taxiInfo) {
        this.f14671h = taxiInfo;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.setType(RouteLine.TYPE.TRANSITSTEP);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.f14671h, 1);
    }
}
