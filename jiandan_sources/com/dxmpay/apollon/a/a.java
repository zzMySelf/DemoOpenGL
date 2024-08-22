package com.dxmpay.apollon.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

public class a {

    /* renamed from: ad  reason: collision with root package name */
    public int f3950ad = 0;
    public final SparseArray<ArrayList<qw>> qw = new SparseArray<>();

    /* renamed from: com.dxmpay.apollon.a.a$a  reason: collision with other inner class name */
    public interface C0180a {
        void a();
    }

    public class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f3951ad;

        /* renamed from: de  reason: collision with root package name */
        public int f3952de;

        /* renamed from: fe  reason: collision with root package name */
        public C0180a f3953fe;
        public int qw;

        public qw(a aVar, int i2, int i3, int i4, C0180a aVar2) {
            this.qw = i2;
            this.f3951ad = i3;
            this.f3952de = i4;
            this.f3953fe = aVar2;
        }
    }

    public a(int i2) {
        this.f3950ad = i2;
    }

    public void ad(qw qwVar) {
        int i2 = qwVar.qw;
        if (i2 >= 0) {
            ArrayList arrayList = this.qw.get(i2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.qw.put(qwVar.qw, arrayList);
            }
            arrayList.add(qwVar);
        }
    }

    public void qw(int i2) {
        ArrayList arrayList = this.qw.get(this.f3950ad);
        if (arrayList != null && arrayList.size() != 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                qw qwVar = (qw) it.next();
                if (qwVar.f3952de == i2) {
                    this.f3950ad = qwVar.f3951ad;
                    qwVar.f3953fe.a();
                    return;
                }
            }
        }
    }
}
