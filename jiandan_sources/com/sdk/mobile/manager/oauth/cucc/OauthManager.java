package com.sdk.mobile.manager.oauth.cucc;

import android.content.Context;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.sdk.a.e;
import com.sdk.a.f;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.o.a;
import com.sdk.y.d;
import com.sdk.y.f;

public class OauthManager extends SDKManager {
    public static volatile OauthManager manager;
    public Context mContext;

    public OauthManager(Context context) {
        this.mContext = context;
    }

    public static OauthManager getInstance(Context context) {
        if (manager == null) {
            synchronized (OauthManager.class) {
                if (manager == null) {
                    manager = new OauthManager(context);
                }
            }
        }
        return manager;
    }

    public <T> void getAuthoriseCode(int i2, CallBack<T> callBack) {
        new f(this.mContext, i2, callBack).a(1);
    }

    public <T> void getMobileForCode(String str, int i2, CallBack<T> callBack) {
        e eVar;
        if (a.a(str).booleanValue()) {
            SDKManager.toFailed(callBack, 101001, "授权码不能为空");
            return;
        }
        f fVar = new f(this.mContext, i2, callBack);
        com.sdk.b.a.a(fVar.e);
        com.sdk.z.a aVar = new com.sdk.z.a(fVar.e, new com.sdk.y.e(fVar));
        if (a.a((String) null).booleanValue()) {
            DataInfo dataInfo = new DataInfo();
            dataInfo.putData(YYInnerSSOLoginActivity.s, str);
            eVar = aVar.a(aVar.f6817i, "/api/netm/v1.0/qhbt", dataInfo, new com.sdk.g.a(aVar), 0, f.a.POST);
        } else {
            DataInfo dataInfo2 = new DataInfo();
            dataInfo2.putData(YYInnerSSOLoginActivity.s, str);
            dataInfo2.putData("mobile", (Object) null);
            eVar = aVar.a(aVar.f6817i, "/api/netm/v1.0/qhbv", dataInfo2, new com.sdk.g.a(aVar), 0, f.a.POST);
        }
        fVar.g = eVar;
    }

    public <T> void getMobileForCode(String str, String str2, int i2, CallBack<T> callBack) {
        e eVar;
        int i3;
        String str3;
        if (a.a(str).booleanValue()) {
            i3 = 101001;
            str3 = "授权码不能为空";
        } else if (a.a(str2).booleanValue()) {
            i3 = 101002;
            str3 = "认证的手机号不能为空";
        } else {
            com.sdk.y.f fVar = new com.sdk.y.f(this.mContext, i2, callBack);
            Context context = fVar.e;
            a.b(com.sdk.b.a.a, "oauth cache clear", com.sdk.b.a.b);
            com.sdk.k.a.a(context, "accessCode1");
            com.sdk.z.a aVar = new com.sdk.z.a(fVar.e, new d(fVar));
            if (a.a(str2).booleanValue()) {
                DataInfo dataInfo = new DataInfo();
                dataInfo.putData(YYInnerSSOLoginActivity.s, str);
                eVar = aVar.a(aVar.f6817i, "/api/netm/v1.0/qhbt", dataInfo, new com.sdk.g.a(aVar), 0, f.a.POST);
            } else {
                DataInfo dataInfo2 = new DataInfo();
                dataInfo2.putData(YYInnerSSOLoginActivity.s, str);
                dataInfo2.putData("mobile", str2);
                eVar = aVar.a(aVar.f6817i, "/api/netm/v1.0/qhbv", dataInfo2, new com.sdk.g.a(aVar), 0, f.a.POST);
            }
            fVar.g = eVar;
            return;
        }
        SDKManager.toFailed(callBack, i3, str3);
    }
}
