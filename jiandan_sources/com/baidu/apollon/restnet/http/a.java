package com.baidu.apollon.restnet.http;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.restnet.http.HttpDefines;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class a implements c<String, String> {
    public static final String a = "Host";
    public static final String b = "Accept";
    public static final String c = "Accept-Charset";
    public static final String d = "Accept-Encoding";
    public static final String e = "Accept-Language";
    public static final String f = "Allow";
    public static final String g = "Cache-Control";
    public static final String h = "Content-Disposition";

    /* renamed from: i  reason: collision with root package name */
    public static final String f704i = "Content-Encoding";
    public static final String j = "Content-Length";
    public static final String k = "Content-Type";
    public static final String l = "Date";
    public static final String m = "ETag";
    public static final String n = "Expires";

    /* renamed from: o  reason: collision with root package name */
    public static final String f705o = "If-Modified-Since";
    public static final String p = "If-None-Match";
    public static final String q = "Last-Modified";
    public static final String r = "Location";
    public static final String s = "Pragma";
    public static final String t = "User-Agent";
    public static final String u = "X-BFB-RT";
    public static final String[] v = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM dd HH:mm:ss yyyy"};
    public static TimeZone w = TimeZone.getTimeZone("GMT");
    public final Map<String, List<String>> x;

    public a(Map<String, List<String>> map, boolean z) {
        if (map == null) {
            throw new IllegalArgumentException("'headers' must not be null");
        } else if (z) {
            LinkedCaseInsensitiveMap linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
            for (Map.Entry next : map.entrySet()) {
                linkedCaseInsensitiveMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
            }
            this.x = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
        } else {
            this.x = map;
        }
    }

    public void clear() {
        this.x.clear();
    }

    public boolean containsKey(Object obj) {
        return this.x.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.x.containsValue(obj);
    }

    public String d() {
        return c("Accept-Language");
    }

    public Set<HttpDefines.HttpMethod> e() {
        String k2 = c("Allow");
        if (k2 == null) {
            return EnumSet.noneOf(HttpDefines.HttpMethod.class);
        }
        ArrayList arrayList = new ArrayList(5);
        for (String valueOf : k2.split(",\\s*")) {
            arrayList.add(HttpDefines.HttpMethod.valueOf(valueOf));
        }
        return EnumSet.copyOf(arrayList);
    }

    public Set<Map.Entry<String, List<String>>> entrySet() {
        return this.x.entrySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.x.equals(((a) obj).x);
    }

    public String f() {
        return c("Cache-Control");
    }

    public String g() {
        return c("Content-Encoding");
    }

    public long h() {
        String k2 = c("Content-Length");
        if (k2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(k2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public int hashCode() {
        return this.x.hashCode();
    }

    public String i() {
        return c("Content-Type");
    }

    public boolean isEmpty() {
        return this.x.isEmpty();
    }

    public String j() {
        List list = this.x.get("Content-Type");
        if (list == null || list.size() <= 1) {
            return null;
        }
        return (String) list.get(1);
    }

    public long k() {
        return l("Date");
    }

    public Set<String> keySet() {
        return this.x.keySet();
    }

    public String l() {
        return c("ETag");
    }

    public long m() {
        return l("Expires");
    }

    public long n() {
        return l("If-Modified-Since");
    }

    public List<String> o() {
        ArrayList arrayList = new ArrayList();
        String k2 = c("If-None-Match");
        if (k2 != null) {
            for (String add : k2.split(",\\s*")) {
                arrayList.add(add);
            }
        }
        return arrayList;
    }

    public long p() {
        return l("Last-Modified");
    }

    public void putAll(Map<? extends String, ? extends List<String>> map) {
        this.x.putAll(map);
    }

    public URI q() {
        String k2 = c("Location");
        if (k2 != null) {
            return URI.create(k2);
        }
        return null;
    }

    public String r() {
        return c("Pragma");
    }

    public String s() {
        return c("User-Agent");
    }

    public int size() {
        return this.x.size();
    }

    public Map<String, String> t() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.x.size());
        for (Map.Entry next : this.x.entrySet()) {
            linkedHashMap.put(next.getKey(), ((List) next.getValue()).get(0));
        }
        return linkedHashMap;
    }

    public String toString() {
        return this.x.toString();
    }

    public String u() {
        return c(u);
    }

    public String v() {
        return c("Host");
    }

    public Collection<List<String>> values() {
        return this.x.values();
    }

    public static a a(a aVar) {
        return new a(aVar, true);
    }

    private long l(String str) {
        String k2 = c(str);
        if (k2 == null) {
            return -1;
        }
        String[] strArr = v;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i2], Locale.US);
            simpleDateFormat.setTimeZone(w);
            try {
                return simpleDateFormat.parse(k2).getTime();
            } catch (ParseException unused) {
                i2++;
            }
        }
        throw new IllegalArgumentException("Cannot parse date value \"" + k2 + "\" for \"" + str + "\" header");
    }

    public List<Charset> b() {
        ArrayList arrayList = new ArrayList();
        String k2 = c("Accept-Charset");
        if (k2 != null) {
            String[] split = k2.split(",\\s*");
            int length = split.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = split[i2];
                int indexOf = str.indexOf(59);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
                if (!str.equals("*")) {
                    arrayList.add(Charset.forName(str));
                }
            }
        }
        return arrayList;
    }

    public String c() {
        return c("Accept-Encoding");
    }

    public void d(String str) {
        a("Cache-Control", str);
    }

    public void f(String str) {
        a("Content-Type", str.toString());
    }

    public void g(String str) {
        if (str != null) {
            if (!str.startsWith("\"") && !str.startsWith("W/")) {
                throw new IllegalArgumentException("Invalid eTag, does not start with W/ or \"");
            } else if (!str.endsWith("\"")) {
                throw new IllegalArgumentException("Invalid eTag, does not end with \"");
            }
        }
        a("ETag", str);
    }

    public void i(String str) {
        a("Pragma", str);
    }

    /* renamed from: k */
    public String c(String str) {
        List list = this.x.get(str);
        if (list != null) {
            return (String) list.get(0);
        }
        return null;
    }

    public static String a(Collection<?> collection, String str, String str2, String str3) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2);
            sb.append(it.next());
            sb.append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public void c(String str) {
        a("Accept-Language", str);
    }

    public void d(long j2) {
        a("If-Modified-Since", j2);
    }

    public void h(String str) {
        a("If-None-Match", str);
    }

    public void c(long j2) {
        a("Expires", j2);
    }

    public void j(String str) {
        a("User-Agent", str);
    }

    /* renamed from: c */
    public void a(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        this.x.put(str, linkedList);
    }

    public void e(String str) {
        a("Content-Encoding", str);
    }

    public void e(long j2) {
        a("Last-Modified", j2);
    }

    public a() {
        this(new LinkedCaseInsensitiveMap(8, Locale.ENGLISH), false);
    }

    public void b(String str) {
        a("Accept-Encoding", str);
    }

    public String a() {
        return c("Accept");
    }

    public void b(long j2) {
        a("Date", j2);
    }

    public void a(String str) {
        a("Accept", str);
    }

    public void b(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
        }
        a("If-None-Match", sb.toString());
    }

    public void a(List<Charset> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Charset> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().name().toLowerCase(Locale.ENGLISH));
            if (it.hasNext()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
        }
        a("Accept-Charset", sb.toString());
    }

    public void b(String str, String str2) {
        List list = this.x.get(str);
        if (list == null) {
            list = new LinkedList();
            this.x.put(str, list);
        }
        list.add(str2);
    }

    public void a(Set<HttpDefines.HttpMethod> set) {
        a("Allow", a(set, ",", "", ""));
    }

    public void a(String str, String str2) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("form-data; name=\"");
            sb.append(str);
            sb.append('\"');
            if (str2 != null) {
                sb.append("; filename=\"");
                sb.append(str2);
                sb.append('\"');
            }
            a("Content-Disposition", sb.toString());
            return;
        }
        throw new IllegalArgumentException("'name' must not be null");
    }

    /* renamed from: b */
    public List<String> remove(Object obj) {
        return this.x.remove(obj);
    }

    public void a(long j2) {
        a("Content-Length", Long.toString(j2));
    }

    public void a(URI uri) {
        a("Location", uri.toASCIIString());
    }

    private void a(String str, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(v[0], Locale.US);
        simpleDateFormat.setTimeZone(w);
        a(str, simpleDateFormat.format(new Date(j2)));
    }

    public void a(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            a((String) next.getKey(), (String) next.getValue());
        }
    }

    /* renamed from: a */
    public List<String> get(Object obj) {
        return this.x.get(obj);
    }

    /* renamed from: a */
    public List<String> put(String str, List<String> list) {
        return this.x.put(str, list);
    }
}
