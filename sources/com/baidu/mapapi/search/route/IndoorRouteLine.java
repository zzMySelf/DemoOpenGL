package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

public class IndoorRouteLine extends RouteLine<IndoorRouteStep> {
    public static final Parcelable.Creator<IndoorRouteLine> CREATOR = new g();

    public static class IndoorRouteStep extends RouteStep {

        /* renamed from: d  reason: collision with root package name */
        private RouteNode f14623d;

        /* renamed from: e  reason: collision with root package name */
        private RouteNode f14624e;

        /* renamed from: f  reason: collision with root package name */
        private String f14625f;

        /* renamed from: g  reason: collision with root package name */
        private String f14626g;

        /* renamed from: h  reason: collision with root package name */
        private String f14627h;

        /* renamed from: i  reason: collision with root package name */
        private List<IndoorStepNode> f14628i;

        /* renamed from: j  reason: collision with root package name */
        private List<Double> f14629j;

        public static class IndoorStepNode {

            /* renamed from: a  reason: collision with root package name */
            private String f14630a;

            /* renamed from: b  reason: collision with root package name */
            private int f14631b;

            /* renamed from: c  reason: collision with root package name */
            private LatLng f14632c;

            /* renamed from: d  reason: collision with root package name */
            private String f14633d;

            public String getDetail() {
                return this.f14633d;
            }

            public LatLng getLocation() {
                return this.f14632c;
            }

            public String getName() {
                return this.f14630a;
            }

            public int getType() {
                return this.f14631b;
            }

            public void setDetail(String str) {
                this.f14633d = str;
            }

            public void setLocation(LatLng latLng) {
                this.f14632c = latLng;
            }

            public void setName(String str) {
                this.f14630a = str;
            }

            public void setType(int i2) {
                this.f14631b = i2;
            }
        }

        private List<LatLng> a(List<Double> list) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                arrayList.add(new LatLng(list.get(i2).doubleValue(), list.get(i2 + 1).doubleValue()));
            }
            return arrayList;
        }

        public String getBuildingId() {
            return this.f14627h;
        }

        public RouteNode getEntrace() {
            return this.f14623d;
        }

        public RouteNode getExit() {
            return this.f14624e;
        }

        public String getFloorId() {
            return this.f14626g;
        }

        public String getInstructions() {
            return this.f14625f;
        }

        public List<IndoorStepNode> getStepNodes() {
            return this.f14628i;
        }

        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.f14629j);
            }
            return this.mWayPoints;
        }

        public void setBuildingId(String str) {
            this.f14627h = str;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f14623d = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f14624e = routeNode;
        }

        public void setFloorId(String str) {
            this.f14626g = str;
        }

        public void setInstructions(String str) {
            this.f14625f = str;
        }

        public void setPath(List<Double> list) {
            this.f14629j = list;
        }

        public void setStepNodes(List<IndoorStepNode> list) {
            this.f14628i = list;
        }
    }

    public IndoorRouteLine() {
        setType(RouteLine.TYPE.WALKSTEP);
    }

    protected IndoorRouteLine(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteStep> getAllStep() {
        return super.getAllStep();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }
}
