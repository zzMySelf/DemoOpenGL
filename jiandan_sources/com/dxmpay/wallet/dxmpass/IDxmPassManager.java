package com.dxmpay.wallet.dxmpass;

import android.content.Context;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.core.NoProguard;

public interface IDxmPassManager extends NoProguard {
    int dxmGetLoginType();

    void dxmInitSdk(Context context, SapiConfiguration sapiConfiguration);

    boolean dxmIsLogin();

    void dxmLogout();

    void dxmStartLogin(Context context, WebLoginDTO webLoginDTO, String str, RouterCallback routerCallback);

    int getBdussState();

    String getDxmDid();

    void getOpenBduss(RouterCallback routerCallback);

    void web2NativeLogin(RouterCallback routerCallback);
}
