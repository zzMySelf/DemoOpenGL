package fe.i.qw.th.ad;

import com.baidu.apollon.restnet.http.a;
import com.dxmpay.apollon.restnet.http.LinkedCaseInsensitiveMap;
import com.dxmpay.apollon.restnet.http.b;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class qw implements b<String, String> {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, List<String>> f4490ad;

    static {
        TimeZone.getTimeZone("GMT");
    }

    public qw(Map<String, List<String>> map, boolean z) {
        if (map == null) {
            throw new IllegalArgumentException("'headers' must not be null");
        } else if (z) {
            LinkedCaseInsensitiveMap linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
            for (Map.Entry next : map.entrySet()) {
                linkedCaseInsensitiveMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
            }
            this.f4490ad = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
        } else {
            this.f4490ad = map;
        }
    }

    /* renamed from: ad */
    public List<String> get(Object obj) {
        return this.f4490ad.get(obj);
    }

    public void clear() {
        this.f4490ad.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f4490ad.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f4490ad.containsValue(obj);
    }

    /* renamed from: de */
    public List<String> put(String str, List<String> list) {
        return this.f4490ad.put(str, list);
    }

    public Set<Map.Entry<String, List<String>>> entrySet() {
        return this.f4490ad.entrySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        return this.f4490ad.equals(((qw) obj).f4490ad);
    }

    public void fe(String str) {
        rg("Accept", str);
    }

    public int hashCode() {
        return this.f4490ad.hashCode();
    }

    public String i() {
        return yj("Content-Type");
    }

    public boolean isEmpty() {
        return this.f4490ad.isEmpty();
    }

    public Set<String> keySet() {
        return this.f4490ad.keySet();
    }

    public String o() {
        List list = this.f4490ad.get("Content-Type");
        if (list == null || list.size() <= 1) {
            return null;
        }
        return (String) list.get(1);
    }

    public String pf() {
        return yj(a.u);
    }

    public void putAll(Map<? extends String, ? extends List<String>> map) {
        this.f4490ad.putAll(map);
    }

    public String qw() {
        return yj("Content-Encoding");
    }

    public void rg(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        this.f4490ad.put(str, linkedList);
    }

    public int size() {
        return this.f4490ad.size();
    }

    public long th() {
        String yj2 = yj("Content-Length");
        if (yj2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(yj2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public String toString() {
        return this.f4490ad.toString();
    }

    /* renamed from: uk */
    public List<String> remove(Object obj) {
        return this.f4490ad.remove(obj);
    }

    public Collection<List<String>> values() {
        return this.f4490ad.values();
    }

    public String yj(String str) {
        List list = this.f4490ad.get(str);
        if (list != null) {
            return (String) list.get(0);
        }
        return null;
    }

    public qw() {
        this(new LinkedCaseInsensitiveMap(8, Locale.ENGLISH), false);
    }
}
