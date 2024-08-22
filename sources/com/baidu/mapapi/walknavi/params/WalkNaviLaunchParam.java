package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
import java.util.LinkedList;
import java.util.List;

public class WalkNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f14776a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f14777b;

    /* renamed from: c  reason: collision with root package name */
    private a f14778c;

    /* renamed from: d  reason: collision with root package name */
    private a f14779d;

    /* renamed from: e  reason: collision with root package name */
    private List<a> f14780e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    private int f14781f;

    public static c create() {
        return new d();
    }

    public WalkNaviLaunchParam endNodeInfo(WalkRouteNodeInfo walkRouteNodeInfo) {
        this.f14779d = walkRouteNodeInfo;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.f14777b = latLng;
        return this;
    }

    public WalkNaviLaunchParam extraNaviMode(int i2) {
        this.f14781f = i2;
        return this;
    }

    public a getEndNodeInfo() {
        return this.f14779d;
    }

    public LatLng getEndPt() {
        return this.f14777b;
    }

    public int getExtraNaviMode() {
        return this.f14781f;
    }

    public a getStartNodeInfo() {
        return this.f14778c;
    }

    public LatLng getStartPt() {
        return this.f14776a;
    }

    public List<a> getViaNodes() {
        return this.f14780e;
    }

    public void setViaNodes(List<a> list) {
        this.f14780e.addAll(list);
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.f14776a = latLng;
        return this;
    }

    public WalkNaviLaunchParam startNodeInfo(WalkRouteNodeInfo walkRouteNodeInfo) {
        this.f14778c = walkRouteNodeInfo;
        return this;
    }
}
