package com.baidu.searchbox.dynamicpublisher.placeimage;

import com.baidu.searchbox.ugc.bridge.IUgcHostInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PlaceImagePlugin$$ExternalSyntheticLambda1 implements IUgcHostInterface.AllPermissonCallback {
    public final /* synthetic */ PlaceImagePlugin f$0;
    public final /* synthetic */ String[] f$1;

    public /* synthetic */ PlaceImagePlugin$$ExternalSyntheticLambda1(PlaceImagePlugin placeImagePlugin, String[] strArr) {
        this.f$0 = placeImagePlugin;
        this.f$1 = strArr;
    }

    public final void callback(boolean z) {
        PlaceImagePlugin.m18143checkPermission$lambda3(this.f$0, this.f$1, z);
    }
}
