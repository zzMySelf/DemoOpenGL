package com.baidu.swan.apps.impl.map.event;

import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.map.action.helper.MarkerViewCreateHelper;
import com.baidu.swan.apps.impl.map.item.MarkerViewItem;
import com.baidu.swan.apps.impl.map.item.SwanAppMapComponent;

public class MapEventListener implements BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapClickListener, BaiduMap.OnMapRenderCallback, BaiduMap.OnMarkerClickListener, View.OnClickListener, BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMyLocationClickListener {
    private static final int DEFAULT_CHANGE_REASON = 0;
    private SwanAppMapComponent mMapComponent;
    private int mMapStatusChangeReason = 0;

    public MapEventListener(SwanAppMapComponent mapComponent) {
        this.mMapComponent = mapComponent;
    }

    public void onMapLoaded() {
        SwanAppLog.i("map", "onMapLoaded");
        SwanAppMapComponent swanAppMapComponent = this.mMapComponent;
        MarkerViewCreateHelper.updateIncludePoints(swanAppMapComponent, swanAppMapComponent.includePoints, false);
    }

    public void onMapClick(LatLng latLng) {
        MapEventHelper.mapTap(this.mMapComponent, latLng);
        SwanAppLog.i("map", "onMapClick LatLng " + latLng);
    }

    public void onMapPoiClick(MapPoi mapPoi) {
        MapEventHelper.mapPoiClick(this.mMapComponent, mapPoi);
        SwanAppLog.i("map", "onMapPoiClick MapPoi " + mapPoi.getPosition());
    }

    public void onMapRenderFinished() {
        MapEventHelper.mapUpdate(this.mMapComponent);
        SwanAppLog.i("map", "onMapRenderFinished");
    }

    public boolean onMarkerClick(Marker marker) {
        MarkerViewItem markerViewItem;
        SwanAppMapComponent swanAppMapComponent = this.mMapComponent;
        if (swanAppMapComponent == null || (markerViewItem = swanAppMapComponent.getMarkerViewItem(marker)) == null) {
            return false;
        }
        MapEventHelper.markerTap(marker, this.mMapComponent);
        markerViewItem.triggerCallout(this.mMapComponent);
        SwanAppLog.i("map", "onMarkerClick marker id " + marker.getId());
        return true;
    }

    public void onClick(View v) {
        MapEventHelper.controlTap(v, this.mMapComponent);
        SwanAppLog.i("map", "Control View click");
    }

    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    public void onMapStatusChangeStart(MapStatus mapStatus, int mapStatusChangeReason) {
        this.mMapStatusChangeReason = mapStatusChangeReason;
    }

    public void onMapStatusChange(MapStatus mapStatus) {
        SwanAppLog.i("map", "onMapStatusChange");
    }

    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        MapEventHelper.regionChanged(this.mMapComponent, mapStatus, this.mMapStatusChangeReason);
        SwanAppLog.i("map", "onMapStatusChangeFinish");
    }

    public boolean onMyLocationClick() {
        return false;
    }
}
