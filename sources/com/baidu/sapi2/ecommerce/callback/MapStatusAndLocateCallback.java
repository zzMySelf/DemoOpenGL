package com.baidu.sapi2.ecommerce.callback;

import android.content.Context;
import com.baidu.pass.ecommerce.callback.GetLocationCallback;
import com.baidu.pass.ecommerce.callback.GetScenePermissionCallback;
import com.baidu.sapi2.ecommerce.dto.AddressScenePermissionDTO;

public interface MapStatusAndLocateCallback {
    boolean isMapInitSuccess();

    void requestLocation(GetLocationCallback getLocationCallback);

    boolean showScenePermissionView(Context context, AddressScenePermissionDTO addressScenePermissionDTO, GetScenePermissionCallback getScenePermissionCallback) {
        return false;
    }
}
