package fe.fe.mmm;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.ubc.UBCUploadTimingManager;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import fe.fe.mmm.aaa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class qqq {
    public final eee qw;

    public qqq(Context context) {
        this.qw = eee.D(context);
    }

    public void a(uk ukVar) {
        this.qw.K(ukVar);
    }

    public int aaa(ArrayList<String> arrayList, boolean z, l lVar) {
        return this.qw.w(arrayList, z, lVar);
    }

    public void ad(l lVar) {
        this.qw.de(lVar);
    }

    public void b(vvv vvv) {
        if (vvv != null) {
            m.rg(vvv.ad(), EnumConstants$RunTime.EVENT_SAVE_DB);
        }
        this.qw.N(vvv);
    }

    public void c(List<vvv> list) {
        ArrayList arrayList = new ArrayList();
        for (vvv ad2 : list) {
            arrayList.add(ad2.ad());
        }
        m.pf(arrayList, (String) null, (String) null, EnumConstants$RunTime.CACHE_TO_DB);
        this.qw.O(list);
    }

    public void d(ddd ddd) {
        this.qw.P(ddd);
    }

    public int ddd(ArrayList<String> arrayList, boolean z, l lVar) {
        lVar.z(10485760);
        return this.qw.w(arrayList, z, lVar);
    }

    public void de(String str, String str2) {
        this.qw.pf(str, str2);
    }

    public void e() {
        this.qw.Q();
    }

    public Map<String, aaa.qw> eee(int i2) {
        return this.qw.G(i2);
    }

    public boolean f(List<Cswitch> list) {
        return this.qw.R(list);
    }

    public void fe(String str, boolean z) {
        this.qw.m122switch(str, z);
    }

    public void g(String str, int i2, String str2) {
        this.qw.S(str, i2, str2);
    }

    public HashMap<String, String> ggg(ArrayList<String> arrayList) {
        return this.qw.t(arrayList);
    }

    public void h(String str) {
        this.qw.T(str);
    }

    public boolean i(l lVar, String str) {
        return this.qw.a(lVar, str);
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m134if(String str) {
        return this.qw.h(str);
    }

    public boolean j(String str, String str2, int i2) {
        return this.qw.U(str, str2, i2);
    }

    public UBCUploadTimingManager.fe mmm() {
        return this.qw.E();
    }

    public ddd nn(String str, int i2) {
        return this.qw.B(str, i2);
    }

    public boolean o(l lVar) {
        return this.qw.f(lVar);
    }

    public int pf(int i2) {
        return this.qw.g(i2);
    }

    public int ppp(l lVar, l lVar2) {
        return this.qw.q(lVar, lVar2);
    }

    public int qqq(l lVar) {
        return this.qw.F(lVar);
    }

    public void qw(l lVar) {
        this.qw.qw(lVar);
    }

    public void rg(String str, int i2) {
        this.qw.mmm(str, i2);
    }

    public xxx rrr(String str) {
        return this.qw.H(str);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m135switch(String str) {
        this.qw.j(str);
    }

    public void th() {
        m.m128switch("clearInvalidData;cold:false", EnumConstants$RunTime.CLEAR_INVALID_DATA);
        this.qw.eee();
    }

    public void tt(SparseArray<ArrayList> sparseArray) {
        this.qw.J(sparseArray);
    }

    public void uk() {
        this.qw.tt();
    }

    public Cswitch vvv(String str) {
        return this.qw.u(str);
    }

    public void when(String str, int i2, long j, JSONArray jSONArray, String str2) {
        m.i(str, i2, EnumConstants$RunTime.FLOW_SAVE_DB);
        this.qw.m(str, i2, j, jSONArray, str2);
    }

    public int xxx() {
        return this.qw.v();
    }

    public void yj(boolean z) {
        m.m128switch("clearInvalidData;cold:" + z, EnumConstants$RunTime.CLEAR_INVALID_DATA);
        this.qw.rrr(z);
    }
}
