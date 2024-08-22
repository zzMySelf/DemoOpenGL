package com.baidu.wallet.personal.entrance;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.personal.ui.MyCouponDetailActivity;
import com.baidu.wallet.personal.ui.MyCouponListActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class EnterCouponPageAction implements RouterAction {
    private void accessWalletCoupon(Context context, String str, boolean z) {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            return;
        }
        Intent intent = new Intent();
        boolean z2 = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("enterDetail", 0) == 1) {
                    intent.putExtra("cardType", jSONObject.optInt("cardType", 0));
                    intent.putExtra("couponNum", jSONObject.optString("coupon_num", ""));
                    intent.putExtra("templateNum", jSONObject.optString("template_num", ""));
                    z2 = true;
                } else {
                    intent.putExtra(MyCouponListActivity.EXTRA_DATA, str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                intent.putExtra(MyCouponListActivity.EXTRA_DATA, str);
            }
        }
        intent.setClass(context, z2 ? MyCouponDetailActivity.class : MyCouponListActivity.class);
        BaiduWalletServiceController.loginFirst(context, intent, z);
    }

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("withAnim") && (hashMap.get("withAnim") instanceof String)) {
            accessWalletCoupon(context, !TextUtils.isEmpty((String) hashMap.get(SapiAccount.SAPI_ACCOUNT_EXTRA)) ? (String) hashMap.get(SapiAccount.SAPI_ACCOUNT_EXTRA) : "", Boolean.parseBoolean((String) hashMap.get("withAnim")));
            if (routerCallback != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("desc", SmsLoginView.f.k);
                routerCallback.onResult(0, hashMap2);
            }
        } else if (routerCallback != null) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap3);
        }
    }
}
