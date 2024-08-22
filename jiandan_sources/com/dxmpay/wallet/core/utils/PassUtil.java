package com.dxmpay.wallet.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.paysdk.ui.PassNormalizeActivity;
import java.util.HashMap;
import java.util.Map;

public final class PassUtil {
    public static final String DXM_DID = "dxm_did";
    public static final String NORMALIZE_URL = "normalize_url";
    public static final String PASS_ERROR_CODE = "pass_error_code";
    public static final String PASS_ERROR_MSG = "pass_error_msg";
    public static final String PASS_OPEN_BDUSS = "pass_open_bduss";
    public static final String PASS_TYPE = "pass_util_type";
    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_VERIFY = 2;

    /* renamed from: ad  reason: collision with root package name */
    public static IPassNormalize f4280ad;

    /* renamed from: de  reason: collision with root package name */
    public static final Object f4281de = new Object();

    /* renamed from: fe  reason: collision with root package name */
    public static IPassNormalize f4282fe;
    public static long qw;

    public interface IPassNormalize {
        boolean onNormalize(Context context, int i2, Map<String, String> map);
    }

    public static class PassNormalize implements IPassNormalize {
        public boolean onNormalize(Context context, int i2, Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            sb.append("统一处理正常化 type=");
            sb.append(i2);
            sb.append("#map=");
            sb.append(map == null);
            sb.toString();
            if (i2 == 1 && map != null) {
                String str = map.get("pass_open_bduss");
                if ("0".equals(map.get("pass_error_code")) && !TextUtils.isEmpty(str)) {
                    IPassNormalize iPassNormalize = PassUtil.f4282fe;
                    if (iPassNormalize != null) {
                        iPassNormalize.onNormalize(context, i2, map);
                    }
                    return true;
                }
            }
            if (i2 != 2 || map == null) {
                return false;
            }
            return true;
        }
    }

    public static class ad extends Web2NativeLoginCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4283ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f4284th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Map f4285yj;

        public class qw implements ILoginBackListener {
            public qw() {
            }

            public void onFail(int i2, String str) {
                if (PassUtil.f4280ad != null) {
                    IPassNormalize qw = PassUtil.f4280ad;
                    ad adVar = ad.this;
                    qw.onNormalize(adVar.f4283ad, adVar.f4284th, adVar.f4285yj);
                }
                IPassNormalize unused = PassUtil.f4280ad = null;
            }

            public void onSuccess(int i2, String str) {
                ad.this.f4285yj.put("pass_open_bduss", str);
                if (PassUtil.f4280ad != null) {
                    IPassNormalize qw = PassUtil.f4280ad;
                    ad adVar = ad.this;
                    qw.onNormalize(adVar.f4283ad, adVar.f4284th, adVar.f4285yj);
                }
                IPassNormalize unused = PassUtil.f4280ad = null;
            }
        }

        public ad(Context context, int i2, Map map) {
            this.f4283ad = context;
            this.f4284th = i2;
            this.f4285yj = map;
        }

        /* renamed from: a */
        public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            if (PassUtil.f4280ad != null) {
                PassUtil.f4280ad.onNormalize(this.f4283ad, this.f4284th, this.f4285yj);
            }
            IPassNormalize unused = PassUtil.f4280ad = null;
        }

        /* renamed from: b */
        public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
            WalletLoginHelper.getInstance().getOpenBduss(true, new qw());
        }

        /* renamed from: c */
        public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            if (PassUtil.f4280ad != null) {
                PassUtil.f4280ad.onNormalize(this.f4283ad, this.f4284th, this.f4285yj);
            }
            IPassNormalize unused = PassUtil.f4280ad = null;
        }

        public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            if (PassUtil.f4280ad != null) {
                PassUtil.f4280ad.onNormalize(this.f4283ad, this.f4284th, this.f4285yj);
            }
            IPassNormalize unused = PassUtil.f4280ad = null;
        }

        public void onFinish() {
        }

        public void onStart() {
        }
    }

    public static class qw implements RouterCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4287ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f4288th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Map f4289yj;

        /* renamed from: com.dxmpay.wallet.core.utils.PassUtil$qw$qw  reason: collision with other inner class name */
        public class C0184qw implements ILoginBackListener {
            public C0184qw() {
            }

            public void onFail(int i2, String str) {
                if (PassUtil.f4280ad != null) {
                    IPassNormalize qw = PassUtil.f4280ad;
                    qw qwVar = qw.this;
                    qw.onNormalize(qwVar.f4287ad, qwVar.f4288th, qwVar.f4289yj);
                }
                IPassNormalize unused = PassUtil.f4280ad = null;
            }

            public void onSuccess(int i2, String str) {
                qw.this.f4289yj.put("pass_open_bduss", str);
                if (PassUtil.f4280ad != null) {
                    IPassNormalize qw = PassUtil.f4280ad;
                    qw qwVar = qw.this;
                    qw.onNormalize(qwVar.f4287ad, qwVar.f4288th, qwVar.f4289yj);
                }
                IPassNormalize unused = PassUtil.f4280ad = null;
            }
        }

        public qw(Context context, int i2, Map map) {
            this.f4287ad = context;
            this.f4288th = i2;
            this.f4289yj = map;
        }

        public void onResult(int i2, HashMap hashMap) {
            if (i2 == -4) {
                if (PassUtil.f4280ad != null) {
                    PassUtil.f4280ad.onNormalize(this.f4287ad, this.f4288th, this.f4289yj);
                }
                IPassNormalize unused = PassUtil.f4280ad = null;
            } else if (i2 == -5) {
                if (PassUtil.f4280ad != null) {
                    PassUtil.f4280ad.onNormalize(this.f4287ad, this.f4288th, this.f4289yj);
                }
                IPassNormalize unused2 = PassUtil.f4280ad = null;
            } else if (i2 == 0) {
                WalletLoginHelper.getInstance().getOpenBduss(true, new C0184qw());
            } else if (i2 == 1) {
                if (PassUtil.f4280ad != null) {
                    PassUtil.f4280ad.onNormalize(this.f4287ad, this.f4288th, this.f4289yj);
                }
                IPassNormalize unused3 = PassUtil.f4280ad = null;
            }
        }
    }

    public static void backNormalized(Context context, int i2, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("pass_error_code")) || !"0".equals(map.get("pass_error_code"))) {
            IPassNormalize iPassNormalize = f4280ad;
            if (iPassNormalize != null) {
                iPassNormalize.onNormalize(context, i2, map);
            }
            f4280ad = null;
        } else if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
            DxmPassManagerDelegate.getInstance().web2NativeLogin(new qw(context, i2, map));
        } else {
            SapiAccountManager.getInstance().getAccountService().web2NativeLogin((Web2NativeLoginCallback) new ad(context, i2, map), true);
        }
    }

    public static long de() {
        long currentTimeMillis = System.currentTimeMillis() - qw;
        "wait =" + currentTimeMillis;
        if (currentTimeMillis >= 500 || currentTimeMillis <= 0) {
            return 0;
        }
        "需要wait =" + currentTimeMillis;
        return currentTimeMillis;
    }

    public static void onCreate() {
        qw = System.currentTimeMillis();
    }

    public static void passNormalized(Context context, String str, int i2, IPassNormalize iPassNormalize) {
        if (iPassNormalize != null && context != null) {
            long de2 = de();
            if (de2 > 0) {
                try {
                    synchronized (f4281de) {
                        f4281de.wait(de2);
                    }
                } catch (Exception e) {
                    LogUtil.e("PassUtil", e.getMessage(), e);
                }
            }
            f4280ad = iPassNormalize;
            Intent intent = new Intent(context, PassNormalizeActivity.class);
            intent.putExtra("normalize_url", str);
            intent.putExtra("pass_util_type", i2);
            context.startActivity(intent);
        }
    }

    public static void registerPassNormalize(IPassNormalize iPassNormalize) {
        f4282fe = iPassNormalize;
    }
}
