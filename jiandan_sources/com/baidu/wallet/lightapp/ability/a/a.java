package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.ability.b;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public class a extends b {
    public boolean a = false;

    public String a() {
        return LightappBusinessClient.MTD_BINDCARD_INITIATIVE;
    }

    public void a(Activity activity, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        this.a = false;
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLDecoder.decode(str, "gbk");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    str3 = (String) jSONObject.get("orderInfo");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    this.a = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(activity)).route(activity, new RouterRequest().provider("dxmPay").action("enterDoInnerBind").data("showDialog", Boolean.valueOf(this.a)).data("orderInfo", str3), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 != 0) {
                    String str = (String) hashMap.get("errorMsg");
                    a aVar = a.this;
                    ILightappInvokerCallback iLightappInvokerCallback = iLightappInvokerCallback;
                    String str2 = str2;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str)) {
                        str = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    aVar.a(iLightappInvokerCallback, str2, num, str, "#bindCardInitiativeFail");
                } else if (hashMap != null && hashMap.size() > 0) {
                    int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                    String str3 = (String) hashMap.get("params");
                    if (intValue == 0) {
                        iLightappInvokerCallback.onResult(0, str3);
                    } else {
                        a.this.a(iLightappInvokerCallback, str2, "10005", str3, "#bindCardInitiativeFail");
                    }
                }
            }
        });
    }
}
