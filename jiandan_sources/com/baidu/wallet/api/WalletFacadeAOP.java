package com.baidu.wallet.api;

import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.utils.MtjCrashHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;

public class WalletFacadeAOP implements NoProguard, InvocationHandler {
    public static final String TAG = "WalletFacadeAOP";
    public static final List<String> b = new ArrayList(Arrays.asList(new String[]{"doPay", "doBind", "doRNAuth", "doCheckPwd", "doBindCardIndependent", "checkPwd", StatServiceEvent.GET_WALLET_OUTER_INTERFACE, "accessWalletEntry", "preOrderPay", "getPayMethod", "changePayMethod", "gotoWalletService"}));
    public final IWalletFacade a;

    /* renamed from: com.baidu.wallet.api.WalletFacadeAOP$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.wallet.api.WalletFacadeAOP$EntranceService[] r0 = com.baidu.wallet.api.WalletFacadeAOP.EntranceService.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.api.WalletFacadeAOP$EntranceService r1 = com.baidu.wallet.api.WalletFacadeAOP.EntranceService.PAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.api.WalletFacadeAOP$EntranceService r1 = com.baidu.wallet.api.WalletFacadeAOP.EntranceService.CREDIT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.wallet.api.WalletFacadeAOP$EntranceService r1 = com.baidu.wallet.api.WalletFacadeAOP.EntranceService.SHARE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.api.WalletFacadeAOP.AnonymousClass1.<clinit>():void");
        }
    }

    public enum EntranceService {
        PAY(0),
        CREDIT(1),
        SHARE(2);
        
        public int val;

        /* access modifiers changed from: public */
        EntranceService(int i2) {
            this.val = i2;
        }
    }

    public WalletFacadeAOP(IWalletFacade iWalletFacade) {
        this.a = iWalletFacade;
    }

    private boolean a() {
        return BaiduWalletDelegate.getInstance().getAppContext() == null;
    }

    private EntranceService b(String str) {
        List<String> list = b;
        if (list == null || !list.contains(str)) {
            return EntranceService.CREDIT;
        }
        if ("gotoWalletService".equals(str)) {
            return EntranceService.SHARE;
        }
        return EntranceService.PAY;
    }

    private void b() {
    }

    private void c(String str) {
        try {
            MtjCrashHandler.init(BaiduWalletDelegate.getInstance().getAppContext());
        } catch (Throwable unused) {
            DXMSdkSAUtils.onEvent("#initMTJLiteFailed");
        }
        EntranceService b2 = b(str);
        LogUtil.d(TAG, "AOP method = " + str);
        int i2 = AnonymousClass1.a[b2.ordinal()];
        if (i2 == 1) {
            WalletLoginHelper.getInstance().clearOpenBduss();
        } else if (i2 == 2) {
            WalletLoginHelper.getInstance().clearOpenBduss();
            WalletLoginHelper.getInstance().clearOpenBduss();
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method != null && a(method.getName())) {
            LogUtil.d(TAG, "crab aop init before method: " + method.getName());
            try {
                if (a()) {
                    return a(method.getReturnType());
                }
                c(method.getName());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        Object invoke = method.invoke(this.a, objArr);
        if (method != null && a(method.getName())) {
            try {
                b();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        return invoke;
    }

    private Object a(Class<?> cls) {
        try {
            if (!cls.isPrimitive()) {
                return cls.newInstance();
            }
            if (cls == Boolean.TYPE) {
                return Boolean.FALSE;
            }
            if (cls == Character.TYPE) {
                return 0;
            }
            if (cls == Byte.TYPE) {
                return Byte.MIN_VALUE;
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(ShortCompanionObject.MIN_VALUE);
            }
            if (cls == Integer.TYPE) {
                return Integer.MIN_VALUE;
            }
            if (cls == Long.TYPE) {
                return Long.MIN_VALUE;
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(Float.MIN_VALUE);
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(Double.MIN_VALUE);
            }
            if (cls == Void.TYPE) {
                return null;
            }
            return new Object();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(String str) {
        if (!"initWallet".equals(str) && !"setDebugOn".equals(str) && !"getBindUrl".equals(str)) {
            return true;
        }
        LogUtil.d(TAG, "crab aop init skip method: " + str);
        return false;
    }
}
