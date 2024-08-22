package com.baidu.apollon.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class BeanManager {
    public static BeanManager a;
    public final HashMap<String, ArrayList<ApollonBean<?>>> b = new HashMap<>();

    public static synchronized BeanManager getInstance() {
        BeanManager beanManager;
        synchronized (BeanManager.class) {
            if (a == null) {
                a = new BeanManager();
            }
            beanManager = a;
        }
        return beanManager;
    }

    public synchronized void addBean(String str, ApollonBean<?> apollonBean) {
        ArrayList arrayList = this.b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.b.put(str, arrayList);
        }
        arrayList.add(apollonBean);
    }

    public synchronized void removeAllBeans(String str) {
        ArrayList arrayList = this.b.get(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ApollonBean) it.next()).destroyBean();
            }
            this.b.remove(str);
        }
    }

    public synchronized void removeBean(ApollonBean<?> apollonBean) {
        for (String str : this.b.keySet()) {
            ArrayList arrayList = this.b.get(str);
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (apollonBean == ((ApollonBean) it.next())) {
                        arrayList.remove(apollonBean);
                        apollonBean.destroyBean();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
