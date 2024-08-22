package org.json.alipay;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f2931a;

    public a() {
        this.f2931a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                this.f2931a.add(Array.get(obj, i2));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f2931a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c2;
        Object obj;
        ArrayList arrayList;
        char c3 = cVar.c();
        if (c3 == '[') {
            c2 = ']';
        } else if (c3 == '(') {
            c2 = ')';
        } else {
            throw cVar.a("A JSONArray text must start with '['");
        }
        if (cVar.c() != ']') {
            do {
                cVar.a();
                char c4 = cVar.c();
                cVar.a();
                if (c4 == ',') {
                    arrayList = this.f2931a;
                    obj = null;
                } else {
                    arrayList = this.f2931a;
                    obj = cVar.d();
                }
                arrayList.add(obj);
                char c5 = cVar.c();
                if (c5 != ')') {
                    if (c5 != ',' && c5 != ';') {
                        if (c5 != ']') {
                            throw cVar.a("Expected a ',' or ']'");
                        }
                    }
                }
                if (c2 != c5) {
                    throw cVar.a("Expected a '" + new Character(c2) + "'");
                }
                return;
            } while (cVar.c() != ']');
        }
    }

    private String a(String str) {
        int size = this.f2931a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f2931a.get(i2)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f2931a.size();
    }

    public final Object a(int i2) {
        Object obj = (i2 < 0 || i2 >= this.f2931a.size()) ? null : this.f2931a.get(i2);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i2 + "] not found.");
    }

    public String toString() {
        try {
            return RhetoricalTagUtilKt.TAG_START_SYMBOL + a(",") + AbstractJsonLexerKt.END_LIST;
        } catch (Exception e2) {
            return null;
        }
    }
}
