package com.baidu.wallet.core.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class BeanManager {
    public final HashMap<String, ArrayList<BaseBean<?>>> a;

    public static class a {
        public static BeanManager a = new BeanManager();
    }

    public static BeanManager getInstance() {
        return a.a;
    }

    public synchronized void addBean(String str, BaseBean<?> baseBean) {
        ArrayList arrayList = this.a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.a.put(str, arrayList);
        }
        arrayList.add(baseBean);
    }

    public synchronized void removeAllBeans(String str) {
        ArrayList arrayList = this.a.get(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((BaseBean) it.next()).destroyBean();
            }
            this.a.remove(str);
        }
    }

    public synchronized void removeBean(BaseBean<?> baseBean) {
        for (String str : this.a.keySet()) {
            ArrayList arrayList = this.a.get(str);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (baseBean == ((BaseBean) it.next())) {
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
        this.a = new HashMap<>();
    }
}
