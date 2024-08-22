package com.sdk.f;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class b {
    public long a = System.currentTimeMillis();
    public a b = new a();
    public String c = "";

    public static class a {
        public List<C0261a> a = new ArrayList();
        public List<String> b = new ArrayList();
        public List<String> c = new ArrayList();
        public String d = "";

        /* renamed from: com.sdk.f.b$a$a  reason: collision with other inner class name */
        public static class C0261a {
            public String a = "";
            public long b;

            public String toString() {
                return "_$101005Bean{url='" + this.a + ExtendedMessageFormat.QUOTE + ", time=" + this.b + ExtendedMessageFormat.END_FE;
            }
        }

        public String toString() {
            return "StatusBean{_$101005=" + this.a + ", _$302001=" + this.b + ", _$302002=" + this.c + ", _$302003='" + this.d + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
    }

    public String toString() {
        return "MobileLog{time=" + this.a + ", status=" + this.b + ExtendedMessageFormat.END_FE;
    }
}
