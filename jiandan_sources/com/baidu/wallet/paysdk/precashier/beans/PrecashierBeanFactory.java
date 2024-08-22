package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import com.dxmpay.apollon.beans.ApollonBean;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BeanManager;

public class PrecashierBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_PRECASHIER_GET_DEFAULT_PAY_TYPE = 1;
    public static final int BEAN_ID_PRECASHIER_LICAI_FUND_DISPLAY = 4;
    public static final int BEAN_ID_PRECASHIER_MODIFY_PAY_TYPE = 2;

    public static class a {
        public static PrecashierBeanFactory a = new PrecashierBeanFactory();
    }

    public static PrecashierBeanFactory getInstance() {
        return a.a;
    }

    public ApollonBean<?> getBean(Context context, int i2, String str) {
        Context applicationContext = context.getApplicationContext();
        if (i2 == 1) {
            return new PrecashierDefaultPayTypeBean(applicationContext);
        }
        if (i2 == 4) {
            return new PrecashierFundDisplayBean(applicationContext);
        }
        PrecashierModifyPayTypeBean precashierModifyPayTypeBean = null;
        if (i2 == 2) {
            precashierModifyPayTypeBean = new PrecashierModifyPayTypeBean(applicationContext);
        }
        if (precashierModifyPayTypeBean != null) {
            BeanManager.getInstance().addBean(str, precashierModifyPayTypeBean);
        }
        return precashierModifyPayTypeBean;
    }

    public PrecashierBeanFactory() {
    }
}
