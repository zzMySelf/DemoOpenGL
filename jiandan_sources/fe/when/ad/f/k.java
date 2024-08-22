package fe.when.ad.f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class k extends y0 implements Iterable<y0> {

    /* renamed from: uk  reason: collision with root package name */
    public ArrayList<y0> f9513uk;

    public k() {
        super(5);
        this.f9513uk = new ArrayList<>();
    }

    public boolean a(y0 y0Var) {
        return this.f9513uk.contains(y0Var);
    }

    public void aaa(int i2, y0 y0Var) {
        this.f9513uk.add(i2, y0Var);
    }

    @Deprecated
    public ArrayList<y0> b() {
        return this.f9513uk;
    }

    public x c(int i2) {
        y0 f = f(i2);
        if (f == null || !f.pf()) {
            return null;
        }
        return (x) f;
    }

    public s0 d(int i2) {
        y0 f = f(i2);
        if (f == null || !f.m1125switch()) {
            return null;
        }
        return (s0) f;
    }

    public v0 e(int i2) {
        y0 f = f(i2);
        if (f == null || !f.ppp()) {
            return null;
        }
        return (v0) f;
    }

    public boolean eee(float[] fArr) {
        for (float v0Var : fArr) {
            this.f9513uk.add(new v0(v0Var));
        }
        return true;
    }

    public y0 f(int i2) {
        return m1.ggg(g(i2));
    }

    public y0 g(int i2) {
        return this.f9513uk.get(i2);
    }

    public y0 h(int i2) {
        return this.f9513uk.remove(i2);
    }

    public boolean isEmpty() {
        return this.f9513uk.isEmpty();
    }

    public Iterator<y0> iterator() {
        return this.f9513uk.iterator();
    }

    public y0 j(int i2, y0 y0Var) {
        return this.f9513uk.set(i2, y0Var);
    }

    public void nn(c2 c2Var, OutputStream outputStream) throws IOException {
        c2.g(c2Var, 11, this);
        outputStream.write(91);
        Iterator<y0> it = this.f9513uk.iterator();
        if (it.hasNext()) {
            y0 next = it.next();
            if (next == null) {
                next = u0.f9819uk;
            }
            next.nn(c2Var, outputStream);
        }
        while (it.hasNext()) {
            y0 next2 = it.next();
            if (next2 == null) {
                next2 = u0.f9819uk;
            }
            int mmm = next2.mmm();
            if (!(mmm == 5 || mmm == 6 || mmm == 4 || mmm == 3)) {
                outputStream.write(32);
            }
            next2.nn(c2Var, outputStream);
        }
        outputStream.write(93);
    }

    public boolean qqq(y0 y0Var) {
        return this.f9513uk.add(y0Var);
    }

    public boolean rrr(int[] iArr) {
        for (int v0Var : iArr) {
            this.f9513uk.add(new v0(v0Var));
        }
        return true;
    }

    public int size() {
        return this.f9513uk.size();
    }

    public String toString() {
        return this.f9513uk.toString();
    }

    public void tt(y0 y0Var) {
        this.f9513uk.add(0, y0Var);
    }

    public k(y0 y0Var) {
        super(5);
        ArrayList<y0> arrayList = new ArrayList<>();
        this.f9513uk = arrayList;
        arrayList.add(y0Var);
    }

    public k(float[] fArr) {
        super(5);
        this.f9513uk = new ArrayList<>();
        eee(fArr);
    }

    public k(int[] iArr) {
        super(5);
        this.f9513uk = new ArrayList<>();
        rrr(iArr);
    }

    public k(k kVar) {
        super(5);
        this.f9513uk = new ArrayList<>(kVar.f9513uk);
    }
}
