package fe.nn.qw;

import fe.nn.qw.rg.qw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Object> f8779ad;
    public final String qw;

    public fe(String str, List<Object> list) {
        this.qw = str;
        this.f8779ad = list == null ? new ArrayList<>() : list;
    }

    public static String o(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return qw((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    public static Object pf(Object obj) {
        if (obj == null) {
            return null;
        }
        if (qw.f8786de) {
            "arg " + obj.getClass().getCanonicalName() + " " + o(obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            byte[] bArr = new byte[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                bArr[i2] = (byte) ((Integer) list.get(i2)).intValue();
            }
            obj = bArr;
        }
        if (qw.f8786de) {
            "arg " + obj.getClass().getCanonicalName() + " " + o(obj);
        }
        return obj;
    }

    public static Map<String, Object> qw(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = qw((Map) value);
            } else {
                obj = o(value);
            }
            hashMap.put(o(next.getKey()), obj);
        }
        return hashMap;
    }

    public String[] ad() {
        return de(this.f8779ad);
    }

    public final String[] de(List<Object> list) {
        return (String[]) uk(list).toArray(new String[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        String str = this.qw;
        if (str != null) {
            if (!str.equals(feVar.qw)) {
                return false;
            }
        } else if (feVar.qw != null) {
            return false;
        }
        if (this.f8779ad.size() != feVar.f8779ad.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f8779ad.size(); i2++) {
            if (!(this.f8779ad.get(i2) instanceof byte[]) || !(feVar.f8779ad.get(i2) instanceof byte[])) {
                if (!this.f8779ad.get(i2).equals(feVar.f8779ad.get(i2))) {
                    return false;
                }
            } else if (!Arrays.equals((byte[]) this.f8779ad.get(i2), (byte[]) feVar.f8779ad.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public List<Object> fe() {
        return this.f8779ad;
    }

    public int hashCode() {
        String str = this.qw;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public fe i() {
        if (this.f8779ad.size() == 0) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int length = this.qw.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = this.qw.charAt(i4);
            if (charAt == '?') {
                int i5 = i4 + 1;
                if (i5 < length && Character.isDigit(this.qw.charAt(i5))) {
                    return this;
                }
                i2++;
                if (i3 >= this.f8779ad.size()) {
                    return this;
                }
                int i6 = i3 + 1;
                Object obj = this.f8779ad.get(i3);
                if ((obj instanceof Integer) || (obj instanceof Long)) {
                    sb.append(obj.toString());
                    i3 = i6;
                } else {
                    arrayList.add(obj);
                    i3 = i6;
                }
            }
            sb.append(charAt);
        }
        if (i2 != this.f8779ad.size()) {
            return this;
        }
        return new fe(sb.toString(), arrayList);
    }

    public String rg() {
        return this.qw;
    }

    public Object[] th() {
        return yj(this.f8779ad);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.qw);
        List<Object> list = this.f8779ad;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + uk(this.f8779ad);
        }
        sb.append(str);
        return sb.toString();
    }

    public final List<String> uk(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object o2 : list) {
                arrayList.add(o(o2));
            }
        }
        return arrayList;
    }

    public final Object[] yj(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object pf2 : list) {
                arrayList.add(pf(pf2));
            }
        }
        return arrayList.toArray(new Object[0]);
    }
}
