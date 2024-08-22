package com.baidu.wallet.lightapp.business;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;

public class TitleBarParams extends LangbridgeBarParams implements Serializable {
    public a barParams;
    public c leftParams;
    public List<d> rightParams;
    public String showMoreDefault;

    public static class a {
        public String a;

        public boolean a() {
            return TextUtils.equals("1", this.a);
        }
    }

    public static final class b {
        public String a;
        public c b;
        public List<d> c;
        public a d;

        public b a(String str) {
            this.a = str;
            return this;
        }

        public b a(c cVar) {
            this.b = cVar;
            return this;
        }

        public b a(List<d> list) {
            this.c = list;
            return this;
        }

        public b a(a aVar) {
            this.d = aVar;
            return this;
        }

        public TitleBarParams a() {
            return new TitleBarParams(this);
        }
    }

    public static class c {
        public String a;

        public boolean a() {
            return TextUtils.equals("1", this.a);
        }
    }

    public static class d {
        public String a;
        public String b;
        public String c;
    }

    public boolean showMoreDefault() {
        return TextUtils.equals("1", this.showMoreDefault);
    }

    public TitleBarParams(b bVar) {
        this.showMoreDefault = bVar.a;
        this.leftParams = bVar.b;
        this.rightParams = bVar.c;
        this.barParams = bVar.d;
    }
}
