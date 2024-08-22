package com.baidu.map.poitalos.basemap;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import com.baidu.map.poipage.utils.MLog;
import com.baidu.map.poitalos.Common;
import com.baidu.map.poitalos.model.AddMarkerData;
import com.baidu.map.poitalos.utils.DataBuilder;
import com.baidu.map.poitalos.utils.PoiMarkerUtils;
import com.baidu.map.poitalos.utils.ScreenUtils;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.talos.core.callback.Promise;
import java.lang.ref.WeakReference;
import java.util.List;

public class MapViewUtils {
    public static final int PADDING_BOTTOM = 40;
    public static final int PADDING_LEFT = 40;
    public static final int PADDING_RIGHT = 40;
    public static final int PADDING_TOP = 40;
    private static final String TAG = "MapViewUtils";
    private static LatLngBounds bounds;
    private static MapStatus curMapStatus;
    private static int currentStateHeight = 0;
    private static int filterStateHeight = 0;
    private static MapStatus listMapStatus;

    public static void setMapZoomBasedOnPOIs(Context context, BaiduMap baiduMap, AddMarkerData addMarkerData) {
        BaiduMap baiduMap2 = baiduMap;
        try {
            baiduMap.clear();
            String industryIdentifier = addMarkerData.getIndustryIdentifier();
            String currentState = addMarkerData.getCurrentState();
            int currentHeight = addMarkerData.getCurrentHeight();
            int filterHeight = addMarkerData.getFilterHeight();
            List<AddMarkerData.POIData> poiList = addMarkerData.getPoiData();
            if (poiList == null) {
                return;
            }
            if (!poiList.isEmpty()) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (AddMarkerData.POIData poiData : poiList) {
                    double locX = Double.parseDouble(poiData.getLocX());
                    double locY = Double.parseDouble(poiData.getLocY());
                    if (locX != 0.0d) {
                        if (locY != 0.0d) {
                            builder.include(CoordUtil.mc2ll(new GeoPoint(locY, locX)));
                        }
                    }
                }
                bounds = builder.build();
                int density = (int) ScreenUtils.getDensity();
                int paddingLeft = density * 40;
                int paddingRight = density * 40;
                int paddingTop = density * 40;
                int i2 = (currentHeight * density) + (density * 40);
                currentStateHeight = i2;
                if (filterHeight == 0) {
                    filterStateHeight = paddingTop;
                } else {
                    filterStateHeight = (filterHeight * density) + paddingTop;
                }
                baiduMap2.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(bounds, paddingLeft, filterStateHeight, paddingRight, i2));
                curMapStatus = baiduMap.getMapStatus();
                listMapStatus = baiduMap.getMapStatus();
                PoiMarkerUtils.addPoiMarker(new WeakReference<>(baiduMap2), industryIdentifier, poiList);
            }
        } catch (Exception e2) {
            if (Common.DEBUG) {
                Log.d(TAG, "setMapZoomBasedOnPOIs: " + e2.getMessage());
            }
        }
    }

    public static void adjustMapViewByBottom(BaiduMap baiduMap, int bottomViewHeight, Promise promise) {
        if (baiduMap != null && bottomViewHeight >= 0) {
            try {
                if (bounds != null) {
                    currentStateHeight = bottomViewHeight * ((int) ScreenUtils.getDensity());
                    updateMapStatusCenterAndZoom(baiduMap, bounds.getCenter(), listMapStatus, filterStateHeight, currentStateHeight);
                    promise.resolve(DataBuilder.buildSuccessData("operation success"));
                    return;
                }
            } catch (Exception e2) {
                MLog.e(TAG, "adjustMapViewByBottom: " + e2.getMessage());
                return;
            }
        }
        promise.resolve(DataBuilder.buildSuccessData("operation failed"));
    }

    public static void updateUserLocMapStatus(BaiduMap baiduMap, LatLng latLng) {
        if (baiduMap != null && latLng != null) {
            try {
                updateMapStatusCenterAndZoom(baiduMap, latLng, curMapStatus, filterStateHeight, currentStateHeight);
            } catch (Exception e2) {
                MLog.e(TAG, "updateUserLocMapStatus: ", e2);
            }
        }
    }

    public static void updateMapStatusCenterAndZoom(BaiduMap baiduMap, LatLng latLng, MapStatus mapStatus, int topViewHeightInPx, int bottomViewHeightInPx) {
        if (baiduMap != null && latLng != null && mapStatus != null) {
            try {
                baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(mapStatus.zoom).target(latLng).targetScreen(getMapTargetScreen(topViewHeightInPx, bottomViewHeightInPx)).build()));
            } catch (Exception e2) {
                MLog.e(TAG, "updateMapStatusCenterAndZoom: ", e2);
            }
        }
    }

    public static void updateMapStatusCenter(BaiduMap baiduMap, LatLng latLng, int bottomViewHeightInDp) {
        if (baiduMap != null && latLng != null) {
            if (bottomViewHeightInDp < 0) {
                bottomViewHeightInDp = 0;
            }
            try {
                int density = bottomViewHeightInDp * ((int) ScreenUtils.getDensity());
                currentStateHeight = density;
                baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(latLng).targetScreen(getMapTargetScreen(filterStateHeight, density)).build()));
                curMapStatus = baiduMap.getMapStatus();
            } catch (Exception e2) {
                MLog.e(TAG, "updateMapStatusCenterAndZoom: ", e2);
            }
        }
    }

    private static Point getMapTargetScreen(int topContentHeight, int bottomContentHeight) {
        if (topContentHeight < 0) {
            topContentHeight = 0;
        }
        if (bottomContentHeight < 0) {
            bottomContentHeight = 0;
        }
        Point point = new Point(ScreenUtils.getScreenWidth() / 2, ((ScreenUtils.getScreenHeight() + topContentHeight) - bottomContentHeight) / 2);
        MLog.d(TAG, "getMapTargetScreen: " + point);
        return point;
    }

    public static MapStatus.Builder cloneMapStatus(MapStatus status) {
        return new MapStatus.Builder().zoom(status.zoom).overlook(status.overlook).rotate(status.rotate).target(status.target).targetScreen(status.targetScreen);
    }

    public static void clearMapResources() {
        PoiMarkerUtils.removeSingleMarker();
        bounds = null;
        curMapStatus = null;
        listMapStatus = null;
        currentStateHeight = 0;
        filterStateHeight = 0;
        PoiMarkerUtils.uidToMarker.clear();
    }
}
