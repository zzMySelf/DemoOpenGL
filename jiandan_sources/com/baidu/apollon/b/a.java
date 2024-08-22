package com.baidu.apollon.b;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a {
    public final Map<String, Set<c>> a;

    /* renamed from: com.baidu.apollon.b.a$a  reason: collision with other inner class name */
    public static class C0025a {
        public static final a a = new a();
    }

    public static a a() {
        return C0025a.a;
    }

    public void b() {
        this.a.clear();
    }

    public a() {
        this.a = new HashMap();
    }

    public Set<c> a(String str) {
        Set<c> set = this.a.get(str);
        return set == null ? Collections.emptySet() : set;
    }

    public a a(@NonNull String str, @NonNull Set<String> set) {
        if (this.a.get(str) == null) {
            this.a.put(str, new HashSet());
        }
        Set set2 = this.a.get(str);
        for (String cVar : set) {
            set2.add(new c(cVar));
        }
        return this;
    }
}
