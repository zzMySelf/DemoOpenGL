package com.baidu.wallet.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.passport.PassLoginUtil;
import com.baidu.wallet.passport.e;
import com.baidu.wallet.paysdk.ui.PassNormalizeActivity;
import java.util.Map;

public final class PassUtil {
    public static final String NORMALIZE_URL = "normalize_url";
    public static final String PASS_ACCOUNT = "pass_account";
    public static final String PASS_ACCOUNT_TYPE = "pass_account_type";
    public static final String PASS_AUTH_SID = "pass_auth_sid";
    public static final String PASS_DISPLAY_NAME = "pass_display_name";
    public static final String PASS_ERROR_CODE = "pass_error_code";
    public static final String PASS_ERROR_MSG = "pass_error_msg";
    public static final String PASS_NEW_REQ = "pass_new_req";
    public static final String PASS_OPEN_BDUSS = "pass_open_bduss";
    public static final String PASS_PASSWORD = "pass_code";
    public static final String PASS_PTOKEN = "pass_ptoken";
    public static final String PASS_SID = "pass_sid";
    public static final String PASS_STOKEN = "pass_stoken";
    public static final String PASS_TYPE = "pass_util_type";
    public static final String PASS_UBI = "pass_ubi";
    public static final String PASS_UID = "pass_uid";
    public static final String PASS_UNION_ID = "pass_union_id";
    public static final String PASS_USER_NAEME = "pass_user_name";
    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_VERIFY = 2;
    public static IPassNormalize a;
    public static long b;
    public static IPassNormalize c;
    public static final Object d = new Object();

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
            LogUtil.logd(sb.toString());
            if (i2 == 1 && map != null) {
                String str = map.get("pass_open_bduss");
                if ("0".equals(map.get("pass_error_code")) && !TextUtils.isEmpty(str)) {
                    IPassNormalize iPassNormalize = PassUtil.a;
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

    public static long b() {
        long currentTimeMillis = System.currentTimeMillis() - b;
        LogUtil.logd("wait =" + currentTimeMillis);
        if (currentTimeMillis >= 500 || currentTimeMillis <= 0) {
            LogUtil.logd("不需要wait");
            return 0;
        }
        LogUtil.logd("需要wait =" + currentTimeMillis);
        return currentTimeMillis;
    }

    public static void backNormalized(final Context context, final int i2, final Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("pass_error_code")) || !"0".equals(map.get("pass_error_code"))) {
            IPassNormalize iPassNormalize = c;
            if (iPassNormalize != null) {
                iPassNormalize.onNormalize(context, i2, map);
            }
            c = null;
            return;
        }
        PassLoginUtil.getInstance().web2NativeLogin(new e.a() {
            public void a() {
                if (PassUtil.c != null) {
                    PassUtil.c.onNormalize(context, i2, map);
                }
                IPassNormalize unused = PassUtil.c = null;
            }

            public void b() {
                if (PassUtil.c != null) {
                    PassUtil.c.onNormalize(context, i2, map);
                }
                IPassNormalize unused = PassUtil.c = null;
            }

            public void c() {
                WalletLoginHelper.getInstance().getOpenBduss(true, new ILoginBackListener() {
                    public void onFail(int i2, String str) {
                        if (PassUtil.c != null) {
                            IPassNormalize a2 = PassUtil.c;
                            AnonymousClass1 r4 = AnonymousClass1.this;
                            a2.onNormalize(context, i2, map);
                        }
                        IPassNormalize unused = PassUtil.c = null;
                    }

                    public void onSuccess(int i2, String str) {
                        map.put("pass_open_bduss", str);
                        if (PassUtil.c != null) {
                            IPassNormalize a2 = PassUtil.c;
                            AnonymousClass1 r4 = AnonymousClass1.this;
                            a2.onNormalize(context, i2, map);
                        }
                        IPassNormalize unused = PassUtil.c = null;
                    }
                }, 0);
            }

            public void d() {
                if (PassUtil.c != null) {
                    PassUtil.c.onNormalize(context, i2, map);
                }
                IPassNormalize unused = PassUtil.c = null;
            }

            public void e() {
            }

            public void f() {
            }
        });
    }

    public static void onCreate() {
        b = System.currentTimeMillis();
    }

    public static void passNormalized(Context context, String str, int i2, IPassNormalize iPassNormalize) {
        if (iPassNormalize != null && context != null) {
            long b2 = b();
            if (b2 > 0) {
                try {
                    synchronized (d) {
                        LogUtil.logd("before wait");
                        d.wait(b2);
                        LogUtil.logd("after wait");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c = iPassNormalize;
            Intent intent = new Intent(context, PassNormalizeActivity.class);
            intent.putExtra("normalize_url", str);
            intent.putExtra("pass_util_type", i2);
            context.startActivity(intent);
        }
    }

    public static void registerPassNormalize(IPassNormalize iPassNormalize) {
        a = iPassNormalize;
    }
}
