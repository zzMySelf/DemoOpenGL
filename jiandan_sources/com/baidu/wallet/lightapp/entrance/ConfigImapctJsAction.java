package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.wallet.lightapp.business.a;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;

public class ConfigImapctJsAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            if (hashMap == null || hashMap.size() == 0) {
                hashMap2.put("errorMsg", "reqValueInvalid");
                routerCallback.onResult(1, hashMap2);
                return;
            }
            String[] strArr = (String[]) hashMap.get("configs");
            String[] strArr2 = (String[]) hashMap.get(SavedStateHandle.KEYS);
            if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
                hashMap2.put("errorMsg", "reqValueInvalid");
                routerCallback.onResult(1, hashMap2);
                return;
            }
            a.a(context, SdkInitResponse.getInstance().getJsHookURl(context), strArr, strArr2);
            routerCallback.onResult(0, hashMap2);
        }
    }
}
