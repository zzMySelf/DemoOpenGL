package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.fingerprint.bean.b;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Collection;
import java.util.HashMap;

public final class PayBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_BALANCE_PAY = 14;
    public static final int BEAN_ID_BIND_CARD = 513;
    public static final int BEAN_ID_BIND_CARD_PROTOCOL = 605;
    public static final int BEAN_ID_CALC_PAYMENT = 16;
    public static final int BEAN_ID_CARD_ADD = 597;
    public static final int BEAN_ID_CASHIER_PROTOCOL_PREVIEW = 618;
    public static final int BEAN_ID_CHECK_CARD_INFO = 5;
    public static final int BEAN_ID_CHECK_CARD_INFO_4_MODIFY_PHONE = 17;
    public static final int BEAN_ID_CHECK_MOBILE_PWD = 258;
    public static final int BEAN_ID_CHECK_PWD = 529;
    public static final int BEAN_ID_CREDIT_PAY = 263;
    public static final int BEAN_ID_FAST_PAY_QUERY = 12;
    public static final int BEAN_ID_FIND_MOBILE_PWD = 260;
    public static final int BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST = 526;
    public static final int BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD = 524;
    public static final int BEAN_ID_GET_CARD_INFO = 4;
    public static final int BEAN_ID_GET_CARD_INFO_4_MODIFY_PHONE = 15;
    public static final int BEAN_ID_GET_JOB = 621;
    public static final int BEAN_ID_GET_PAY_ORDER = 1;
    public static final int BEAN_ID_LICAI_BALANCE_PAY = 622;
    public static final int BEAN_ID_MODIFY_MOBILE_PWD = 259;
    public static final int BEAN_ID_NEW_CHECK_PASSWORD = 606;
    public static final int BEAN_ID_OPEN_FINGERPRINT_REFACTOR = 596;
    public static final int BEAN_ID_PAY = 13;
    public static final int BEAN_ID_QUERY_BANK_INFO = 7;
    public static final int BEAN_ID_QUERY_OFFLINE_PAY = 619;
    public static final int BEAN_ID_QUERY_TRANS = 604;
    public static final int BEAN_ID_SAVE_FEEDBACK = 598;
    public static final int BEAN_ID_SCANCODE_PAY = 594;
    public static final int BEAN_ID_SCANCODE_SEND_SMS_TO_PAY = 595;
    public static final int BEAN_ID_SEND_SMS = 9;
    public static final int BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK = 264;
    public static final int BEAN_ID_SIGN_CHANNEL_LIST = 517;
    public static final int BEAN_ID_USER_HAS_PAY_PASSWORD = 600;
    public static final int BEAN_ID_USER_INFO = 6;
    public static final int BEAN_ID_VERIFY_MOBILE_PWD = 257;
    public static final int BEAN_ID_VERIFY_SMS_CODE = 11;
    public static final int BEAN_ID_WIDTHDRAW = 527;

    public static class a {
        public static PayBeanFactory a = new PayBeanFactory();
    }

    public static PayBeanFactory getInstance() {
        return a.a;
    }

    public PayBeanFactory() {
    }

    public BaseBean<?> getBean(Context context, int i2, String str) {
        Context applicationContext = context.getApplicationContext();
        BaseBean<?> baseBean = null;
        if (i2 == 1) {
            baseBean = new t(applicationContext);
        } else if (i2 == 9) {
            baseBean = new af(applicationContext);
        } else if (i2 == 513) {
            baseBean = new b(applicationContext);
        } else if (i2 == 517) {
            baseBean = new ad(applicationContext);
        } else if (i2 == 524) {
            baseBean = new l(applicationContext);
        } else if (i2 == 526) {
            baseBean = new k(applicationContext);
        } else if (i2 == 529) {
            baseBean = new i(applicationContext);
        } else if (i2 == 600) {
            baseBean = new VerifyPayPasswordBean(applicationContext);
        } else if (i2 == 622) {
            baseBean = new v(applicationContext);
        } else if (i2 == 4) {
            baseBean = new p(applicationContext);
        } else if (i2 == 5) {
            baseBean = new h(applicationContext);
        } else if (i2 == 6) {
            baseBean = new UserInfoBean(applicationContext);
        } else if (i2 == 7) {
            baseBean = new ab(applicationContext);
        } else if (i2 == 263) {
            baseBean = new j(applicationContext);
        } else if (i2 == 264) {
            baseBean = new ae(applicationContext);
        } else if (i2 == 605) {
            baseBean = new c(applicationContext);
        } else if (i2 == 606) {
            baseBean = new x(applicationContext);
        } else if (i2 == 618) {
            baseBean = new f(applicationContext);
        } else if (i2 != 619) {
            switch (i2) {
                case 11:
                    baseBean = new ag(applicationContext);
                    break;
                case 12:
                    baseBean = new aa(applicationContext);
                    break;
                case 13:
                    baseBean = new z(applicationContext);
                    break;
                case 14:
                    baseBean = new a(applicationContext);
                    break;
                case 15:
                    baseBean = new o(applicationContext);
                    break;
                case 16:
                    baseBean = new d(applicationContext);
                    break;
                case 17:
                    baseBean = new g(applicationContext);
                    break;
                default:
                    switch (i2) {
                        case 257:
                        case BEAN_ID_CHECK_MOBILE_PWD /*258*/:
                        case BEAN_ID_MODIFY_MOBILE_PWD /*259*/:
                            baseBean = new w(applicationContext);
                            break;
                        case BEAN_ID_FIND_MOBILE_PWD /*260*/:
                            baseBean = new m(applicationContext);
                            break;
                        default:
                            switch (i2) {
                                case BEAN_ID_SCANCODE_PAY /*594*/:
                                    final BaseBean<?>[] baseBeanArr = {null};
                                    LocalRouter.getInstance(applicationContext).route(applicationContext, new RouterRequest().provider("scancode").action("getLimitPayBean"), new RouterCallback() {
                                        public void onResult(int i2, HashMap hashMap) {
                                            if (i2 == 0 && hashMap != null && hashMap.get("data") != null) {
                                                Object obj = hashMap.get("data");
                                                if (obj != null && (obj instanceof BaseBean)) {
                                                    baseBeanArr[0] = (BaseBean) obj;
                                                }
                                            } else if (i2 == 5) {
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put("provider", "scancode");
                                                hashMap2.put("action", "getLimitPayBean");
                                                StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                                            }
                                        }
                                    });
                                    baseBean = baseBeanArr[0];
                                    break;
                                case BEAN_ID_SCANCODE_SEND_SMS_TO_PAY /*595*/:
                                    final BaseBean<?>[] baseBeanArr2 = {null};
                                    LocalRouter.getInstance(applicationContext).route(applicationContext, new RouterRequest().provider("scancode").action("getSendSmsBean"), new RouterCallback() {
                                        public void onResult(int i2, HashMap hashMap) {
                                            if (i2 == 0 && hashMap != null) {
                                                Object obj = hashMap.get("data");
                                                if (obj != null && (obj instanceof BaseBean)) {
                                                    baseBeanArr2[0] = (BaseBean) obj;
                                                }
                                            } else if (i2 == 5) {
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put("provider", "scancode");
                                                hashMap2.put("action", "getSendSmsBean");
                                                StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                                            }
                                        }
                                    });
                                    baseBean = baseBeanArr2[0];
                                    break;
                                case BEAN_ID_OPEN_FINGERPRINT_REFACTOR /*596*/:
                                    baseBean = new b(applicationContext);
                                    break;
                                case BEAN_ID_CARD_ADD /*597*/:
                                    baseBean = new e(applicationContext);
                                    break;
                                case BEAN_ID_SAVE_FEEDBACK /*598*/:
                                    baseBean = new ac(applicationContext);
                                    break;
                            }
                    }
            }
        } else {
            baseBean = new y(applicationContext);
        }
        if (baseBean != null) {
            BeanManager.getInstance().addBean(str, baseBean);
        }
        return baseBean;
    }
}
