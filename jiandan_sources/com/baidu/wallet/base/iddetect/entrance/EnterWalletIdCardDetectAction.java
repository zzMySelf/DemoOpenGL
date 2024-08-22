package com.baidu.wallet.base.iddetect.entrance;

import android.content.Context;
import android.os.Bundle;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;

public class EnterWalletIdCardDetectAction implements RouterAction {
    private void startIdCardDetect(Context context, int i2, boolean z, boolean z2, final RouterCallback routerCallback) {
        IdCardDetectionController.getInstance().startIdcarddetect(context, i2, z2, new IdCardDetectionController.IIdCardDetectionListener() {
            public void onDetectFailed(int i2, String str) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(i2));
                    hashMap.put("errMsg", str);
                    routerCallback.onResult(1, hashMap);
                }
            }

            public void onDetectOK(Bundle bundle) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", bundle);
                    routerCallback.onResult(0, hashMap);
                }
            }
        }, z);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("type") && (hashMap.get("type") instanceof Integer) && hashMap.containsKey("showAlbum") && (hashMap.get("showAlbum") instanceof Boolean)) {
            startIdCardDetect(context, ((Integer) hashMap.get("type")).intValue(), ((Boolean) hashMap.get("showAlbum")).booleanValue(), hashMap.containsKey("fromLangbridge") ? ((Boolean) hashMap.get("fromLangbridge")).booleanValue() : false, routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
