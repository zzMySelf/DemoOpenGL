package fe.de.qw.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzm;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.List;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public String f1284ad;

    /* renamed from: de  reason: collision with root package name */
    public String f1285de;

    /* renamed from: fe  reason: collision with root package name */
    public de f1286fe;
    public boolean qw;

    /* renamed from: rg  reason: collision with root package name */
    public zzu f1287rg;

    /* renamed from: th  reason: collision with root package name */
    public ArrayList f1288th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f1289yj;

    public static final class ad {

        /* renamed from: ad  reason: collision with root package name */
        public final String f1290ad;
        public final o qw;

        public static class qw {

            /* renamed from: ad  reason: collision with root package name */
            public String f1291ad;
            public o qw;

            public /* synthetic */ qw(e eVar) {
            }

            @NonNull
            public qw ad(@NonNull String str) {
                this.f1291ad = str;
                return this;
            }

            @NonNull
            public qw de(@NonNull o oVar) {
                this.qw = oVar;
                if (oVar.qw() != null) {
                    if (oVar.qw() != null) {
                        this.f1291ad = oVar.qw().qw();
                    } else {
                        throw null;
                    }
                }
                return this;
            }

            @NonNull
            public ad qw() {
                zzm.zzc(this.qw, "ProductDetails is required for constructing ProductDetailsParams.");
                zzm.zzc(this.f1291ad, "offerToken is required for constructing ProductDetailsParams.");
                return new ad(this, (f) null);
            }
        }

        public /* synthetic */ ad(qw qwVar, f fVar) {
            this.qw = qwVar.qw;
            this.f1290ad = qwVar.f1291ad;
        }

        @NonNull
        public static qw qw() {
            return new qw((e) null);
        }

        @NonNull
        public final o ad() {
            return this.qw;
        }

        @NonNull
        public final String de() {
            return this.f1290ad;
        }
    }

    public static class de {

        /* renamed from: ad  reason: collision with root package name */
        public int f1292ad = 0;
        public String qw;

        public static class qw {

            /* renamed from: ad  reason: collision with root package name */
            public boolean f1293ad;

            /* renamed from: de  reason: collision with root package name */
            public int f1294de = 0;
            public String qw;

            public /* synthetic */ qw(g gVar) {
            }

            @NonNull
            public de qw() {
                boolean z = !TextUtils.isEmpty(this.qw) || !TextUtils.isEmpty((CharSequence) null);
                boolean isEmpty = true ^ TextUtils.isEmpty((CharSequence) null);
                if (z && isEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                } else if (this.f1293ad || z || isEmpty) {
                    de deVar = new de((h) null);
                    deVar.qw = this.qw;
                    deVar.f1292ad = this.f1294de;
                    return deVar;
                } else {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
            }
        }

        public /* synthetic */ de(h hVar) {
        }

        @NonNull
        public static qw qw() {
            return new qw((g) null);
        }

        public final int ad() {
            return this.f1292ad;
        }

        public final String de() {
            return this.qw;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f1295ad;

        /* renamed from: de  reason: collision with root package name */
        public List f1296de;

        /* renamed from: fe  reason: collision with root package name */
        public ArrayList f1297fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f1298rg;

        /* renamed from: th  reason: collision with root package name */
        public de.qw f1299th;

        public /* synthetic */ qw(d dVar) {
            de.qw qw2 = de.qw();
            de.qw unused = qw2.f1293ad = true;
            this.f1299th = qw2;
        }

        @NonNull
        public qw ad(@NonNull String str) {
            this.qw = str;
            return this;
        }

        @NonNull
        public qw de(@NonNull String str) {
            this.f1295ad = str;
            return this;
        }

        @NonNull
        public qw fe(@NonNull List<ad> list) {
            this.f1296de = new ArrayList(list);
            return this;
        }

        @NonNull
        public th qw() {
            ArrayList arrayList;
            zzu zzu;
            ArrayList arrayList2 = this.f1297fe;
            boolean z = true;
            boolean z2 = arrayList2 != null && !arrayList2.isEmpty();
            List list = this.f1296de;
            boolean z3 = list != null && !list.isEmpty();
            if (!z2 && !z3) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            } else if (!z2 || !z3) {
                if (!z2) {
                    ad adVar = (ad) this.f1296de.get(0);
                    int i2 = 0;
                    while (i2 < this.f1296de.size()) {
                        ad adVar2 = (ad) this.f1296de.get(i2);
                        if (adVar2 == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        } else if (i2 == 0 || adVar2.ad().de().equals(adVar.ad().de()) || adVar2.ad().de().equals("play_pass_subs")) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException("All products should have same ProductType.");
                        }
                    }
                    String rg2 = adVar.ad().rg();
                    for (ad adVar3 : this.f1296de) {
                        if (!adVar.ad().de().equals("play_pass_subs") && !adVar3.ad().de().equals("play_pass_subs") && !rg2.equals(adVar3.ad().rg())) {
                            throw new IllegalArgumentException("All products must have the same package name.");
                        }
                    }
                } else if (this.f1297fe.contains((Object) null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                } else if (this.f1297fe.size() > 1) {
                    vvv vvv = (vvv) this.f1297fe.get(0);
                    String ad2 = vvv.ad();
                    ArrayList arrayList3 = this.f1297fe;
                    int size = arrayList3.size();
                    int i3 = 0;
                    while (i3 < size) {
                        vvv vvv2 = (vvv) arrayList3.get(i3);
                        if (ad2.equals("play_pass_subs") || vvv2.ad().equals("play_pass_subs") || ad2.equals(vvv2.ad())) {
                            i3++;
                        } else {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String th2 = vvv.th();
                    ArrayList arrayList4 = this.f1297fe;
                    int size2 = arrayList4.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        vvv vvv3 = (vvv) arrayList4.get(i4);
                        if (ad2.equals("play_pass_subs") || vvv3.ad().equals("play_pass_subs") || th2.equals(vvv3.th())) {
                            i4++;
                        } else {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
                th thVar = new th((j) null);
                if ((!z2 || ((vvv) this.f1297fe.get(0)).th().isEmpty()) && (!z3 || ((ad) this.f1296de.get(0)).ad().rg().isEmpty())) {
                    z = false;
                }
                thVar.qw = z;
                thVar.f1284ad = this.qw;
                thVar.f1285de = this.f1295ad;
                thVar.f1286fe = this.f1299th.qw();
                ArrayList arrayList5 = this.f1297fe;
                if (arrayList5 != null) {
                    arrayList = new ArrayList(arrayList5);
                } else {
                    arrayList = new ArrayList();
                }
                thVar.f1288th = arrayList;
                thVar.f1289yj = this.f1298rg;
                List list2 = this.f1296de;
                if (list2 != null) {
                    zzu = zzu.zzk(list2);
                } else {
                    zzu = zzu.zzl();
                }
                thVar.f1287rg = zzu;
                return thVar;
            } else {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
        }
    }

    public /* synthetic */ th(j jVar) {
    }

    @NonNull
    public static qw qw() {
        return new qw((d) null);
    }

    public final int ad() {
        return this.f1286fe.ad();
    }

    @Nullable
    public final String de() {
        return this.f1284ad;
    }

    @Nullable
    public final String fe() {
        return this.f1285de;
    }

    public final boolean ggg() {
        return (this.f1284ad == null && this.f1285de == null && this.f1286fe.ad() == 0 && !this.qw && !this.f1289yj) ? false : true;
    }

    public final boolean ppp() {
        return this.f1289yj;
    }

    @Nullable
    public final String rg() {
        return this.f1286fe.de();
    }

    @NonNull
    public final ArrayList th() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f1288th);
        return arrayList;
    }

    @NonNull
    public final List yj() {
        return this.f1287rg;
    }
}
