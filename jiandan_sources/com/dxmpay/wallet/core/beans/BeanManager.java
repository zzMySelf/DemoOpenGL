package com.dxmpay.wallet.core.beans;

import com.dxmpay.apollon.beans.ApollonBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class BeanManager {
    public final HashMap<String, ArrayList<ApollonBean<?>>> qw;

    public static class ad {
        public static BeanManager qw = new BeanManager();
    }

    public static BeanManager getInstance() {
        return ad.qw;
    }

    public synchronized void addBean(String str, ApollonBean<?> apollonBean) {
        ArrayList arrayList = this.qw.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.qw.put(str, arrayList);
        }
        arrayList.add(apollonBean);
    }

    public synchronized void removeAllBeans(String str) {
        ArrayList arrayList = this.qw.get(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ApollonBean) it.next()).destroyBean();
            }
            this.qw.remove(str);
        }
    }

    public synchronized void removeBean(BaseBean<?> baseBean) {
        for (String str : this.qw.keySet()) {
            ArrayList arrayList = this.qw.get(str);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (baseBean == ((ApollonBean) it.next())) {
                            arrayList.remove(baseBean);
                            baseBean.destroyBean();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public BeanManager() {
        this.qw = new HashMap<>();
    }
}
