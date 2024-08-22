package com.heytap.openid.sdk;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Keep;
import com.heytap.openid.base.m_a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Keep
public class m_d {
    @Keep
    public static boolean m_a = false;
    @Keep
    public static boolean m_b = false;
    @Keep
    public static boolean m_c = false;

    @Keep
    public static native Context m_a(Context context);

    public static HashMap<String, String> m_a(Context context, int i2) {
        String str;
        int m_a2 = m_a.m_a(i2);
        if (m_a2 == 10000) {
            ArrayList arrayList = new ArrayList();
            if ((i2 & 8) == 8) {
                arrayList.add("OUID");
                arrayList.add("OUID_STATUS");
            }
            if ((i2 & 32) == 32 && !arrayList.contains("OUID_STATUS")) {
                arrayList.add("OUID_STATUS");
            }
            if ((i2 & 2) == 2) {
                arrayList.add("AUID");
            }
            if ((i2 & 16) == 16) {
                arrayList.add("GUID");
            }
            boolean z = true;
            if ((i2 & 1) == 1) {
                arrayList.add("APID");
            }
            if ((i2 & 4) == 4) {
                arrayList.add("DUID");
            }
            if (!m_a || ((!m_b && !m_c) || Looper.myLooper() == Looper.getMainLooper())) {
                z = false;
            }
            if (!z) {
                HashMap<String, String> hashMap = new HashMap<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    hashMap.put(str2, str2 == "OUID_STATUS" ? "FALSE" : "");
                }
                return hashMap;
            }
            m_b m_a3 = m_b.m_a();
            Context m_a4 = m_a(context);
            m_a3.getClass();
            ArrayList arrayList2 = new ArrayList();
            if (m_a3.m_a.isEmpty()) {
                m_a.m_a(m_a4, m_a3.m_a);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                if (m_a3.m_a.containsKey(str3)) {
                    m_f m_f = m_a3.m_a.get(str3);
                    if (!m_f.m_a(str3)) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(str3);
                        m_h.m_a("1025");
                        m_a.m_a.execute(new m_a(m_a3, m_a4, arrayList3));
                    }
                    str = m_f.m_a;
                } else {
                    str = null;
                }
                if (str == null) {
                    arrayList2.add(str3);
                }
            }
            if (!arrayList2.isEmpty()) {
                m_h.m_a("1026");
                m_a3.m_a(m_a4, arrayList2, false);
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str4 = (String) it3.next();
                m_f m_f2 = m_a3.m_a.get(str4);
                hashMap2.put(str4, m_f2 == null ? str4 == "OUID_STATUS" ? "FALSE" : "" : m_f2.m_a);
            }
            m_h.m_a("2025");
            return hashMap2;
        }
        throw new RuntimeException(m_a2 + "");
    }
}
