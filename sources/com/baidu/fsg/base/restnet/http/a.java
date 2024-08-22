package com.baidu.fsg.base.restnet.http;

import com.baidu.fsg.base.restnet.http.HttpDefines;
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

public class a implements b<String, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11629a = "Host";

    /* renamed from: b  reason: collision with root package name */
    private static final String f11630b = "Accept";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11631c = "Accept-Charset";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11632d = "Accept-Encoding";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11633e = "Accept-Language";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11634f = "Allow";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11635g = "Cache-Control";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11636h = "Content-Disposition";

    /* renamed from: i  reason: collision with root package name */
    private static final String f11637i = "Content-Encoding";

    /* renamed from: j  reason: collision with root package name */
    private static final String f11638j = "Content-Length";
    private static final String k = "Content-Type";
    private static final String l = "Date";
    private static final String m = "ETag";
    private static final String n = "Expires";
    private static final String o = "If-Modified-Since";
    private static final String p = "If-None-Match";
    private static final String q = "Last-Modified";
    private static final String r = "Location";
    private static final String s = "Pragma";
    private static final String t = "User-Agent";
    private static final String u = "X-BFB-RT";
    private static final String[] v = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM dd HH:mm:ss yyyy"};
    private static TimeZone w = TimeZone.getTimeZone("GMT");
    private final Map<String, List<String>> x;

    public a() {
        this(new LinkedCaseInsensitiveMap(8, Locale.ENGLISH), false);
    }

    public a(Map<String, List<String>> map, boolean z) {
        if (map != null) {
            if (z) {
                LinkedCaseInsensitiveMap linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
                for (Map.Entry next : map.entrySet()) {
                    linkedCaseInsensitiveMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
                }
                map = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
            }
            this.x = map;
            return;
        }
        throw new IllegalArgumentException("'headers' must not be null");
    }

    public static a a(a aVar) {
        return new a(aVar, true);
    }

    public static String a(Collection<?> collection, String str, String str2, String str3) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2).append(it.next()).append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private void a(String str, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(v[0], Locale.US);
        simpleDateFormat.setTimeZone(w);
        a(str, simpleDateFormat.format(new Date(j2)));
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
            } catch (ParseException e2) {
                i2++;
            }
        }
        throw new IllegalArgumentException("Cannot parse date value \"" + k2 + "\" for \"" + str + "\" header");
    }

    public String a() {
        return c("Accept");
    }

    /* renamed from: a */
    public List<String> get(Object obj) {
        return this.x.get(obj);
    }

    /* renamed from: a */
    public List<String> put(String str, List<String> list) {
        return this.x.put(str, list);
    }

    public void a(long j2) {
        a("Content-Length", Long.toString(j2));
    }

    public void a(String str) {
        a("Accept", str);
    }

    public void a(String str, String str2) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("form-data; name=\"");
            sb.append(str).append('\"');
            if (str2 != null) {
                sb.append("; filename=\"");
                sb.append(str2).append('\"');
            }
            a("Content-Disposition", sb.toString());
            return;
        }
        throw new IllegalArgumentException("'name' must not be null");
    }

    public void a(URI uri) {
        a("Location", uri.toASCIIString());
    }

    public void a(List<Charset> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Charset> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().name().toLowerCase(Locale.ENGLISH));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        a(f11631c, sb.toString());
    }

    public void a(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            a((String) next.getKey(), (String) next.getValue());
        }
    }

    public void a(Set<HttpDefines.HttpMethod> set) {
        a(f11634f, a(set, ",", "", ""));
    }

    public List<Charset> b() {
        ArrayList arrayList = new ArrayList();
        String k2 = c(f11631c);
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

    /* renamed from: b */
    public List<String> remove(Object obj) {
        return this.x.remove(obj);
    }

    public void b(long j2) {
        a("Date", j2);
    }

    public void b(String str) {
        a("Accept-Encoding", str);
    }

    public void b(String str, String str2) {
        List list = this.x.get(str);
        if (list == null) {
            list = new LinkedList();
            this.x.put(str, list);
        }
        list.add(str2);
    }

    public void b(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        a("If-None-Match", sb.toString());
    }

    public String c() {
        return c("Accept-Encoding");
    }

    public void c(long j2) {
        a("Expires", j2);
    }

    public void c(String str) {
        a("Accept-Language", str);
    }

    /* renamed from: c */
    public void a(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        this.x.put(str, linkedList);
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

    public void d(long j2) {
        a("If-Modified-Since", j2);
    }

    public void d(String str) {
        a("Cache-Control", str);
    }

    public Set<HttpDefines.HttpMethod> e() {
        String k2 = c(f11634f);
        if (k2 == null) {
            return EnumSet.noneOf(HttpDefines.HttpMethod.class);
        }
        ArrayList arrayList = new ArrayList(5);
        for (String valueOf : k2.split(",\\s*")) {
            arrayList.add(HttpDefines.HttpMethod.valueOf(valueOf));
        }
        return EnumSet.copyOf(arrayList);
    }

    public void e(long j2) {
        a("Last-Modified", j2);
    }

    public void e(String str) {
        a("Content-Encoding", str);
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

    public void f(String str) {
        a("Content-Type", str.toString());
    }

    public String g() {
        return c("Content-Encoding");
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

    public long h() {
        String k2 = c("Content-Length");
        if (k2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(k2);
        } catch (NumberFormatException e2) {
            return -1;
        }
    }

    public void h(String str) {
        a("If-None-Match", str);
    }

    public int hashCode() {
        return this.x.hashCode();
    }

    public String i() {
        return c("Content-Type");
    }

    public void i(String str) {
        a("Pragma", str);
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

    public void j(String str) {
        a("User-Agent", str);
    }

    public long k() {
        return l("Date");
    }

    /* renamed from: k */
    public String c(String str) {
        List list = this.x.get(str);
        if (list != null) {
            return (String) list.get(0);
        }
        return null;
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
}
