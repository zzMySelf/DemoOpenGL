package fe.fe.o.rg.ad;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public List f2596ad = new ArrayList();
    public int qw = 0;

    public ad() {
    }

    public ad(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    o oVar = new o(jSONObject.getLong("begin"), jSONObject.getLong("end"));
                    long j = jSONObject.getLong("current");
                    oVar.f2599de = j;
                    this.qw = (int) (((long) this.qw) + (j - oVar.qw));
                    this.f2596ad.add(oVar);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public synchronized List ad(int i2, long j) {
        ArrayList arrayList;
        int i3;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator it = this.f2596ad.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            o oVar = (o) it.next();
            if (oVar.f2599de < oVar.f2598ad) {
                if (arrayList2.size() > 0) {
                    o oVar2 = (o) arrayList2.get(0);
                    if (oVar2.f2598ad - oVar2.f2599de < oVar.f2598ad - oVar.f2599de) {
                        arrayList2.add(0, oVar);
                    }
                }
                arrayList2.add(oVar);
            }
        }
        if (arrayList2.size() < i2) {
            int size = arrayList2.size();
            while (size < i2 && i3 < arrayList2.size()) {
                o oVar3 = (o) arrayList2.get(i3);
                long j2 = (oVar3.f2598ad - oVar3.f2599de) / 2;
                if (j2 <= j) {
                    break;
                }
                long j3 = (((j2 + ((long) qw.D)) - 1) / ((long) qw.D)) * ((long) qw.D);
                o oVar4 = new o(oVar3.f2598ad - j3, oVar3.f2598ad);
                oVar3.f2598ad -= j3;
                this.f2596ad.add(oVar4);
                arrayList.add(oVar4);
                size++;
                i3++;
            }
        }
        return arrayList;
    }

    public void de(long j) {
        for (o oVar : this.f2596ad) {
            long j2 = oVar.f2598ad;
            if (j2 == j && oVar.f2599de == j2) {
                return;
            }
        }
    }

    public void fe(long j, long j2) {
        this.f2596ad.add(new o(j, j2));
    }

    public long i() {
        return (long) this.qw;
    }

    public long o(long j) {
        o rg2 = rg(j);
        if (rg2 == null) {
            return 0;
        }
        return rg2.f2598ad;
    }

    public long pf(long j) {
        o rg2 = rg(j);
        if (rg2 == null) {
            return 0;
        }
        return rg2.f2599de;
    }

    public int qw() {
        return this.f2596ad.size();
    }

    public o rg(long j) {
        for (o oVar : this.f2596ad) {
            if (oVar.qw <= j && oVar.f2598ad > j) {
                return oVar;
            }
        }
        return null;
    }

    public List th() {
        return this.f2596ad;
    }

    public String toString() {
        JSONArray jSONArray = new JSONArray();
        for (o oVar : this.f2596ad) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("begin", oVar.qw);
                jSONObject.put("current", oVar.f2599de);
                jSONObject.put("end", oVar.f2598ad);
                jSONArray.put(jSONObject);
            } catch (JSONException unused) {
            }
        }
        return jSONArray.toString();
    }

    public boolean uk(int i2, long j) {
        int i3 = 0;
        for (o oVar : this.f2596ad) {
            if (oVar.f2598ad - oVar.f2599de > j) {
                i3++;
            }
        }
        return i3 >= i2;
    }

    public void yj(long j, long j2) {
        this.qw = 0;
        for (o oVar : this.f2596ad) {
            if (oVar.qw <= j) {
                long j3 = oVar.f2598ad;
                if (j3 > j) {
                    long j4 = oVar.f2599de;
                    if (j4 >= j) {
                        long j5 = j + j2;
                        if (j4 <= j5) {
                            if (j3 > j5) {
                                j3 = j5;
                            }
                            oVar.f2599de = j3;
                        }
                    }
                }
            }
            this.qw = (int) (((long) this.qw) + (oVar.f2599de - oVar.qw));
        }
    }
}
