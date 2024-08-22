package com.baidu.wallet.base.iddetect.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;

public final class IDDetectBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_ID_DETECT = 57345;

    public static class SingletonHolder {
        public static IDDetectBeanFactory sInstance = new IDDetectBeanFactory();
    }

    public static IDDetectBeanFactory getInstance() {
        return SingletonHolder.sInstance;
    }

    public IDDetectBeanFactory() {
    }

    public BaseBean<?> getBean(Context context, int i2, String str) {
        IDDetectBean iDDetectBean = i2 != 57345 ? null : new IDDetectBean(context);
        if (iDDetectBean != null) {
            BeanManager.getInstance().addBean(str, iDDetectBean);
        }
        return iDDetectBean;
    }
}
