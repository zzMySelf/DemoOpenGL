package com.baidu.wallet.scheme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class WalletSchemeActivity extends PayBaseBeanActivity {
    public String order;

    public static class SchemeOrder implements NoProguard, Serializable {
        public static final long serialVersionUID = -237137357302783447L;
        public Orderinfo kBWParameters;

        public static class Orderinfo implements NoProguard, Serializable {
            public static final long serialVersionUID = 7620618282105798227L;
            public String kBWPayInfoOrder;
        }
    }

    private void a(Intent intent) {
        Uri uri;
        if (intent == null) {
            finish();
            return;
        }
        try {
            uri = intent.getData();
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null) {
            finish();
            return;
        }
        String fragment = uri.getFragment();
        if (fragment == null) {
            finish();
            return;
        }
        String replace = fragment.replace("www.baifubao.com/pay#", "").replace("www.dxmpay.com/pay#", "");
        "fragment: " + uri.getFragment();
        "scheme: " + uri.getScheme();
        "scheme specific part : " + uri.getSchemeSpecificPart();
        "path : " + uri.getPath();
        "last path segment : " + uri.getLastPathSegment();
        "host : " + uri.getHost();
        "uri : " + uri.toString();
        if (TextUtils.isEmpty(replace)) {
            finish();
            return;
        }
        try {
            String str = new String(Base64Utils.decode(replace));
            if (TextUtils.isEmpty(str)) {
                finish();
                return;
            }
            SchemeOrder schemeOrder = (SchemeOrder) JsonUtils.fromJson(str, SchemeOrder.class);
            if (schemeOrder != null && schemeOrder.kBWParameters != null && !TextUtils.isEmpty(schemeOrder.kBWParameters.kBWPayInfoOrder)) {
                BaiduPayDelegate.getInstance().doPay(this, schemeOrder.kBWParameters.kBWPayInfoOrder, (PayCallBack) null);
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
