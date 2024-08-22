package com.baidu.wallet.paysdk.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import java.util.List;

public class b {
    public static a a;

    public static boolean a() {
        return !TextUtils.isEmpty(PayDataCache.getInstance().getPureSign());
    }

    public static boolean b() {
        return "1".equals(PayDataCache.getInstance().getPureSign());
    }

    public static boolean c() {
        return "0".equals(PayDataCache.getInstance().getPureSign());
    }

    public static void a(List<RestNameValuePair> list) {
        if (list != null) {
            list.add(new RestNameValuePair("pure_sign", PayDataCache.getInstance().getPureSign()));
        }
    }

    public static void a(Context context, a aVar) {
        a = aVar;
        Intent intent = new Intent();
        intent.setClass(context, PayTypeActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
