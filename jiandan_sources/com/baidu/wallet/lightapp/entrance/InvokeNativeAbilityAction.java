package com.baidu.wallet.lightapp.entrance;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.ability.NativeAbilityInvoker;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;

public class InvokeNativeAbilityAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        NativeAbilityInvoker.a().a((Activity) hashMap.get(ActivityChooserModel.ATTRIBUTE_ACTIVITY), (String) hashMap.get(UBCManager.CONTENT_KEY_SOURCE), (String) hashMap.get("options"), (ILightappInvokerCallback) hashMap.get("callback"));
    }
}
