package com.baidu.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    public final SparseArray<ArrayList<b>> a = new SparseArray<>();
    public int b = 0;

    /* renamed from: com.baidu.apollon.a.a$a  reason: collision with other inner class name */
    public interface C0024a {
        void a();
    }

    public class b {
        public int a;
        public int b;
        public int c;
        public C0024a d;

        public b(int i2, int i3, int i4, C0024a aVar) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = aVar;
        }
    }

    public a(int i2) {
        this.b = i2;
    }

    public void a(b bVar) {
        int i2 = bVar.a;
        if (i2 >= 0) {
            ArrayList arrayList = this.a.get(i2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(bVar.a, arrayList);
            }
            arrayList.add(bVar);
        }
    }

    public void b(int i2) {
        ArrayList arrayList = this.a.get(this.b);
        if (arrayList != null && arrayList.size() != 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.c == i2) {
                    this.b = bVar.b;
                    bVar.d.a();
                    return;
                }
            }
        }
    }

    public void a(int i2) {
        this.b = i2;
    }
}
