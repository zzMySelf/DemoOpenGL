package com.baidu.wallet.paysdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class a {
    public final List<C0161a> a;

    /* renamed from: com.baidu.wallet.paysdk.a$a  reason: collision with other inner class name */
    public interface C0161a {
        boolean a(CharSequence charSequence);
    }

    public static class b implements C0161a {
        public static final Pattern a = Pattern.compile("^[A-z0-9*]{1,50}$");

        public b() {
        }

        public boolean a(CharSequence charSequence) {
            return a.matcher(charSequence).matches();
        }
    }

    public static class c implements C0161a {
        public static final Pattern a = Pattern.compile("^[HM]\\d{8,10}$");

        public c() {
        }

        public boolean a(CharSequence charSequence) {
            return a.matcher(charSequence).matches();
        }
    }

    public static class d implements C0161a {
        public static final Pattern a = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");

        public d() {
        }

        public boolean a(CharSequence charSequence) {
            return a.matcher(charSequence).matches();
        }
    }

    public static class e implements C0161a {
        public e() {
        }

        public boolean a(CharSequence charSequence) {
            return true;
        }
    }

    public static class f implements C0161a {
        public static final Pattern a = Pattern.compile("^[A-Za-z0-9]{1,18}$");

        public f() {
        }

        public boolean a(CharSequence charSequence) {
            return a.matcher(charSequence).matches();
        }
    }

    public a() {
        this(14);
    }

    private boolean a(long j, long j2) {
        return (j & j2) > 0;
    }

    public boolean a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        for (C0161a a2 : this.a) {
            if (a2.a(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public a(long j) {
        this.a = new ArrayList();
        if (a(j, 2)) {
            this.a.add(new d());
        }
        if (a(j, 4)) {
            this.a.add(new f());
        }
        if (a(j, 8)) {
            this.a.add(new c());
        }
        if (a(j, 16)) {
            this.a.add(new e());
        }
        if (a(j, 1)) {
            this.a.add(new b());
        }
    }
}
