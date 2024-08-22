package com.baidu.sofire.xclient.privacycontrol.c;

import android.text.TextUtils;
import com.baidu.sofire.xclient.privacycontrol.b.b;
import java.util.HashMap;

public class c implements e<String> {
    public static final HashMap<String, a<String>> c = new HashMap<>();
    public final com.baidu.sofire.xclient.privacycontrol.b.c a;
    public final String b;

    public c(String str, com.baidu.sofire.xclient.privacycontrol.b.c cVar) {
        this.b = str;
        this.a = cVar;
    }

    public void a(Object obj) {
        T t = (String) obj;
        if (!TextUtils.isEmpty(t)) {
            HashMap<String, a<String>> hashMap = c;
            a aVar = hashMap.get(this.b);
            if (aVar == null) {
                hashMap.put(this.b, new a(System.currentTimeMillis(), t));
                return;
            }
            aVar.a = System.currentTimeMillis();
            aVar.b = t;
        }
    }

    public Object b() {
        a aVar = c.get(this.b);
        if (aVar == null) {
            return null;
        }
        return (String) aVar.b;
    }

    public boolean a() {
        a aVar;
        if (!TextUtils.isEmpty(this.b) && (aVar = c.get(this.b)) != null) {
            return b.a(this.a, aVar.a);
        }
        return true;
    }
}
