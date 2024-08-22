package com.baidu.sofire.xclient.privacycontrol.c;

import android.text.TextUtils;
import com.baidu.sofire.xclient.privacycontrol.b.b;
import com.baidu.sofire.xclient.privacycontrol.b.c;
import java.util.HashMap;

public class f implements e<String> {
    public static final HashMap<Integer, a<String>> c = new HashMap<>();
    public final c a;
    public final int b;

    public f(c cVar, int i2) {
        this.a = cVar;
        this.b = i2;
    }

    public void a(Object obj) {
        T t = (String) obj;
        if (!TextUtils.isEmpty(t)) {
            HashMap<Integer, a<String>> hashMap = c;
            a aVar = hashMap.get(Integer.valueOf(this.b));
            if (aVar == null) {
                hashMap.put(Integer.valueOf(this.b), new a(System.currentTimeMillis(), t));
                return;
            }
            aVar.a = System.currentTimeMillis();
            aVar.b = t;
        }
    }

    public Object b() {
        a aVar = c.get(Integer.valueOf(this.b));
        if (aVar == null) {
            return null;
        }
        return (String) aVar.b;
    }

    public boolean a() {
        a aVar = c.get(Integer.valueOf(this.b));
        if (aVar == null) {
            return true;
        }
        return b.a(this.a, aVar.a);
    }
}
