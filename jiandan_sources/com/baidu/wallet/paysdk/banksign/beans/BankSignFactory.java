package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanManager;

public final class BankSignFactory implements IBeanFactory {
    public static final int BEAN_ID_BIND_CARD = 771;
    public static final int BEAN_ID_GET_JUMP_URL = 768;
    public static final int BEAN_ID_POLLING = 769;
    public static final int BEAN_ID_QUERY = 770;

    public static class a {
        public static BankSignFactory a = new BankSignFactory();
    }

    public static BankSignFactory getInstance() {
        return a.a;
    }

    public BankSignFactory() {
    }

    public BaseBean<?> getBean(Context context, int i2, String str) {
        BaseBean<?> baseBean;
        Context applicationContext = context.getApplicationContext();
        switch (i2) {
            case 768:
                baseBean = new b(applicationContext);
                break;
            case BEAN_ID_POLLING /*769*/:
                baseBean = new c(applicationContext);
                break;
            case BEAN_ID_QUERY /*770*/:
                baseBean = new d(applicationContext);
                break;
            case BEAN_ID_BIND_CARD /*771*/:
                baseBean = new a(applicationContext);
                break;
            default:
                baseBean = null;
                break;
        }
        if (baseBean != null) {
            BeanManager.getInstance().addBean(str, baseBean);
        }
        return baseBean;
    }
}
