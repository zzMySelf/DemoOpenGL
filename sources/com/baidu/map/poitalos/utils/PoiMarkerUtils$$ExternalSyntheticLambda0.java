package com.baidu.map.poitalos.utils;

import android.graphics.Bitmap;
import com.baidu.map.poipage.utils.ImageLoader;
import com.baidu.map.poitalos.model.SingleWaterDropModel;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PoiMarkerUtils$$ExternalSyntheticLambda0 implements ImageLoader.ImageLoadListener {
    public final /* synthetic */ SingleWaterDropModel f$0;
    public final /* synthetic */ LatLng f$1;
    public final /* synthetic */ BaiduMap f$2;

    public /* synthetic */ PoiMarkerUtils$$ExternalSyntheticLambda0(SingleWaterDropModel singleWaterDropModel, LatLng latLng, BaiduMap baiduMap) {
        this.f$0 = singleWaterDropModel;
        this.f$1 = latLng;
        this.f$2 = baiduMap;
    }

    public final void onImageLoaded(Bitmap bitmap) {
        PoiMarkerUtils.lambda$showSingleWaterDropMarker$0(this.f$0, this.f$1, this.f$2, bitmap);
    }
}
