package fe.when.ad.f;

import java.util.ArrayList;

public class a2 {

    /* renamed from: ad  reason: collision with root package name */
    public String f9350ad;

    /* renamed from: de  reason: collision with root package name */
    public Float f9351de;
    public ArrayList<Object> qw = new ArrayList<>();

    public a2(String str) {
        ad(str);
    }

    public void ad(String str) {
        if (str.length() > 0) {
            if (this.f9350ad != null) {
                String str2 = this.f9350ad + str;
                this.f9350ad = str2;
                fe(str2);
            } else {
                this.f9350ad = str;
                this.qw.add(str);
            }
            this.f9351de = null;
        }
    }

    public ArrayList<Object> de() {
        return this.qw;
    }

    public final void fe(Object obj) {
        ArrayList<Object> arrayList = this.qw;
        arrayList.set(arrayList.size() - 1, obj);
    }

    public void qw(float f) {
        if (f != 0.0f) {
            if (this.f9351de != null) {
                Float f2 = new Float(f + this.f9351de.floatValue());
                this.f9351de = f2;
                if (f2.floatValue() != 0.0f) {
                    fe(this.f9351de);
                } else {
                    ArrayList<Object> arrayList = this.qw;
                    arrayList.remove(arrayList.size() - 1);
                }
            } else {
                Float f3 = new Float(f);
                this.f9351de = f3;
                this.qw.add(f3);
            }
            this.f9350ad = null;
        }
    }

    public a2() {
    }
}
