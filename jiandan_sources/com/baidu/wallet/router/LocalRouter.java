package com.baidu.wallet.router;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.HashMap;

public class LocalRouter implements NoProguard {
    public static final String TAG = "LocalRouter";
    public static LocalRouter sInstance;
    public HashMap<String, RouterProvider> mProviders;

    public LocalRouter(Context context) {
        this.mProviders = null;
        this.mProviders = new HashMap<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        r3 = r0.findAction(r3.getAction());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.wallet.router.RouterAction findRequestAction(com.baidu.wallet.router.RouterRequest r3) {
        /*
            r2 = this;
            java.util.HashMap<java.lang.String, com.baidu.wallet.router.RouterProvider> r0 = r2.mProviders
            java.lang.String r1 = r3.getProvider()
            java.lang.Object r0 = r0.get(r1)
            com.baidu.wallet.router.RouterProvider r0 = (com.baidu.wallet.router.RouterProvider) r0
            com.baidu.wallet.router.ErrorAction r1 = new com.baidu.wallet.router.ErrorAction
            r1.<init>()
            if (r0 != 0) goto L_0x0014
            return r1
        L_0x0014:
            java.lang.String r3 = r3.getAction()
            com.baidu.wallet.router.RouterAction r3 = r0.findAction(r3)
            if (r3 != 0) goto L_0x001f
            return r1
        L_0x001f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.router.LocalRouter.findRequestAction(com.baidu.wallet.router.RouterRequest):com.baidu.wallet.router.RouterAction");
    }

    public static synchronized LocalRouter getInstance(@NonNull Context context) {
        LocalRouter localRouter;
        synchronized (LocalRouter.class) {
            if (sInstance == null) {
                sInstance = new LocalRouter(context);
            }
            localRouter = sInstance;
        }
        return localRouter;
    }

    public boolean isProviderExisted(String str) {
        if (!TextUtils.isEmpty(str) && this.mProviders.get(str) != null) {
            return true;
        }
        return false;
    }

    public boolean isRequestAvailable(RouterRequest routerRequest) {
        RouterProvider routerProvider = this.mProviders.get(routerRequest.getProvider());
        if (routerProvider == null || routerProvider.findAction(routerRequest.getAction()) == null) {
            return false;
        }
        return true;
    }

    public void registerProvider(String str, RouterProvider routerProvider) {
        this.mProviders.put(str, routerProvider);
    }

    public void route(Context context, @NonNull RouterRequest routerRequest, RouterCallback routerCallback) {
        LogUtil.d("LocalRouter", "Process:Local find action start: " + System.currentTimeMillis());
        RouterAction findRequestAction = findRequestAction(routerRequest);
        LogUtil.d("LocalRouter", "Process:Local find action end: " + System.currentTimeMillis());
        try {
            findRequestAction.invoke(context, routerRequest.getData(), routerCallback);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("errorMsg", e.getMessage());
            routerCallback.onResult(1, hashMap);
        }
        LogUtil.d("LocalRouter", "Process:Local route end: " + System.currentTimeMillis());
    }
}
