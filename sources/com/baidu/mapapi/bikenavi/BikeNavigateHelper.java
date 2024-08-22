package com.baidu.mapapi.bikenavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import b.a.a.a.c.e.c;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.controllers.UnsupportedBikeNaviException;
import com.baidu.mapapi.bikenavi.controllers.a.d;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.map.VersionInfo;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.m;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

public class BikeNavigateHelper {

    /* renamed from: a  reason: collision with root package name */
    private static BikeNavigateHelper f14024a;

    /* renamed from: b  reason: collision with root package name */
    private d f14025b = new d();

    /* renamed from: c  reason: collision with root package name */
    boolean f14026c;

    /* renamed from: d  reason: collision with root package name */
    Activity f14027d;

    static {
        if (!a.a().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("BDMapSDKException: the version of bikenavi is not match with map");
        } else if (VersionInfo.KIT_NAME.compareToIgnoreCase(VersionInfo.KIT_NAME) == 0) {
            NativeLoader.getInstance().loadLibrary(a.b());
        } else {
            throw new BaiduMapSDKException("BDMapSDKException: sdk of bikenavi is not match the correct map sdk, please integrate baidumapapi_map_for_bikenavi jar and so, instead of baidumapapi_map jar and so");
        }
    }

    private BikeNavigateHelper() {
    }

    public static BikeNavigateHelper getInstance() {
        if (f14024a == null) {
            f14024a = new BikeNavigateHelper();
        }
        return f14024a;
    }

    public void initNaviEngine(Activity activity, IBEngineInitListener iBEngineInitListener) {
        d dVar = this.f14025b;
        if (dVar != null) {
            dVar.a(activity, iBEngineInitListener);
        }
    }

    public View onCreate(Activity activity) {
        d dVar = this.f14025b;
        if (dVar == null) {
            return null;
        }
        this.f14027d = activity;
        return dVar.a(activity);
    }

    public void pause() {
        m.h().M();
        d dVar = this.f14025b;
        if (dVar != null) {
            dVar.e();
        }
    }

    public void quit() {
        if (m.h().z() != null) {
            m.h().z().d();
        }
        m.h().b();
        m.h().O();
        m.h().V();
        d dVar = this.f14025b;
        if (dVar != null) {
            dVar.d();
            this.f14025b = null;
        }
        this.f14026c = false;
        this.f14027d = null;
        if (f14024a != null) {
            f14024a = null;
        }
    }

    public void resume() {
        Activity activity = this.f14027d;
        if (activity != null && !activity.isFinishing()) {
            m.h().R();
            d dVar = this.f14025b;
            if (dVar != null) {
                dVar.f();
            }
        }
    }

    public void routePlanWithParams(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        d dVar = this.f14025b;
        if (dVar == null) {
            return;
        }
        if (!dVar.c()) {
            throw new UnsupportedBikeNaviException("BDMapSDKException: naviengine init failed, please init naviengine first");
        } else if (bikeNaviLaunchParam == null || bikeNaviLaunchParam.getStartPt() == null || bikeNaviLaunchParam.getEndPt() == null) {
            throw new UnsupportedBikeNaviException("BDMapSDKException: launch param or startPt or endPt cannot be null");
        } else {
            GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartPt());
            GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndPt());
            a create = BikeNaviLaunchParam.create();
            if (bikeNaviLaunchParam.getVehicle() == 1) {
                create.c(bikeNaviLaunchParam.getVehicle());
            }
            create.b(1);
            BNavigatorWrapper.getWNavigator().d(1);
            m.h().b(bikeNaviLaunchParam.getStartPt());
            m.h().a(bikeNaviLaunchParam.getEndPt());
            create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 131);
            create.a(0);
            create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{131});
            this.f14025b.a(create, iBRoutePlanListener);
        }
    }

    public void routePlanWithRouteNode(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        d dVar = this.f14025b;
        if (dVar == null) {
            return;
        }
        if (!dVar.c()) {
            throw new UnsupportedBikeNaviException("BDMapSDKException: naviengine init failed, please init naviengine first");
        } else if (bikeNaviLaunchParam == null) {
            throw new UnsupportedBikeNaviException("BDMapSDKException: launch param cannot be null");
        } else if (bikeNaviLaunchParam.getStartNodeInfo() == null || bikeNaviLaunchParam.getEndNodeInfo() == null) {
            throw new UnsupportedBikeNaviException("BDMapSDKException: startNode or endNodeInfo cannot be null");
        } else if (bikeNaviLaunchParam.getStartNodeInfo().getLocation() == null || bikeNaviLaunchParam.getEndNodeInfo().getLocation() == null) {
            throw new UnsupportedBikeNaviException("BDMapSDKException: the start and end location cannot be null");
        } else {
            c cVar = new c();
            cVar.a(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
            m.h().a(cVar);
            GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
            GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndNodeInfo().getLocation());
            a create = BikeNaviLaunchParam.create();
            if (bikeNaviLaunchParam.getVehicle() == 1) {
                create.c(bikeNaviLaunchParam.getVehicle());
            }
            create.b(1);
            BNavigatorWrapper.getWNavigator().d(1);
            m.h().b(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
            m.h().a(bikeNaviLaunchParam.getEndNodeInfo().getLocation());
            create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 131);
            create.a(0);
            create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{131});
            this.f14025b.a(create, iBRoutePlanListener);
        }
    }

    public void setBikeNaviStatusListener(IBNaviStatusListener iBNaviStatusListener) {
        m.h().a(iBNaviStatusListener);
    }

    public boolean setNaviMapUp() {
        MapView b2 = this.f14025b.b();
        if (b2 == null) {
            return false;
        }
        b2.setZOrderMediaOverlay(true);
        return true;
    }

    public void setRouteGuidanceListener(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        if (iBRouteGuidanceListener != null) {
            this.f14025b.a(activity, iBRouteGuidanceListener);
        }
    }

    public void setTTsPlayer(IBTTSPlayer iBTTSPlayer) {
        d dVar = this.f14025b;
        if (dVar != null) {
            dVar.a(iBTTSPlayer);
        }
    }

    public void showUIDebuggable(String str) {
        this.f14025b.a(str);
    }

    public boolean startBikeNavi(Activity activity) {
        if (!m.h().a(activity, (Bundle) null)) {
            return false;
        }
        if (!this.f14026c) {
            if (!m.h().T()) {
                return false;
            }
            this.f14026c = true;
        }
        return true;
    }

    public void triggerLocation(WLocData wLocData) {
        d dVar = this.f14025b;
        if (dVar != null) {
            dVar.a(wLocData);
        }
    }

    public void unInitNaviEngine() {
        m.h().O();
        m.h().V();
        d dVar = this.f14025b;
        if (dVar != null) {
            dVar.d();
            this.f14025b = null;
        }
        this.f14026c = false;
        this.f14027d = null;
        if (f14024a != null) {
            f14024a = null;
        }
    }
}
