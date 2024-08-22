package fe.de.qw.qw;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.zzbe;
import com.android.billingclient.api.zzc;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzu;
import fe.de.qw.qw.ppp;
import fe.de.qw.qw.yj;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

public class fe extends de {
    public ExecutorService aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final String f1238ad;
    public boolean ddd;

    /* renamed from: de  reason: collision with root package name */
    public final Handler f1239de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile d0 f1240fe;
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1241i;

    /* renamed from: if  reason: not valid java name */
    public boolean f19if;
    public boolean mmm;
    public boolean nn;

    /* renamed from: o  reason: collision with root package name */
    public int f1242o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f1243pf;
    public boolean ppp;
    public volatile int qw;

    /* renamed from: rg  reason: collision with root package name */
    public Context f1244rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f20switch;

    /* renamed from: th  reason: collision with root package name */
    public volatile zze f1245th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f1246uk;
    public boolean vvv;
    public boolean when;
    public boolean xxx;

    /* renamed from: yj  reason: collision with root package name */
    public volatile b f1247yj;

    @AnyThread
    public fe(Context context, boolean z, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, @Nullable zzc zzc) {
        this.qw = 0;
        this.f1239de = new Handler(Looper.getMainLooper());
        this.f1242o = 0;
        this.f1238ad = str;
        uk(context, purchasesUpdatedListener, z, (zzc) null);
    }

    public static /* bridge */ /* synthetic */ q tt(fe feVar, String str) {
        Bundle bundle;
        zzb.zzn("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzh = zzb.zzh(feVar.f20switch, feVar.nn, feVar.f1238ad);
        String str2 = null;
        do {
            try {
                if (feVar.f20switch) {
                    bundle = feVar.f1245th.zzj(9, feVar.f1244rg.getPackageName(), str, str2, zzh);
                } else {
                    bundle = feVar.f1245th.zzi(3, feVar.f1244rg.getPackageName(), str, str2);
                }
                yj qw2 = r.qw(bundle, "BillingClient", "getPurchase()");
                if (qw2 != l.f1265yj) {
                    return new q(qw2, (List) null);
                }
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i2 = 0;
                while (i2 < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    zzb.zzn("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        Cif ifVar = new Cif(str3, str4);
                        if (TextUtils.isEmpty(ifVar.th())) {
                            zzb.zzo("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(ifVar);
                        i2++;
                    } catch (JSONException e) {
                        zzb.zzp("BillingClient", "Got an exception trying to decode the purchase!", e);
                        return new q(l.f1263th, (List) null);
                    }
                }
                str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
            } catch (Exception e2) {
                zzb.zzp("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                return new q(l.f1264uk, (List) null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new q(l.f1265yj, arrayList);
    }

    @SuppressLint({"PrivateApi"})
    public static String vvv() {
        try {
            return (String) Class.forName("fe.de.qw.ad.qw").getField("VERSION_NAME").get((Object) null);
        } catch (Exception unused) {
            return "5.0.0";
        }
    }

    public final /* synthetic */ Bundle aaa(int i2, String str, String str2, th thVar, Bundle bundle) throws Exception {
        return this.f1245th.zzg(i2, this.f1244rg.getPackageName(), str, str2, (String) null, bundle);
    }

    public final boolean ad() {
        return (this.qw != 2 || this.f1245th == null || this.f1247yj == null) ? false : true;
    }

    public final /* synthetic */ Object b(uk ukVar, ConsumeResponseListener consumeResponseListener) throws Exception {
        String str;
        int i2;
        String qw2 = ukVar.qw();
        try {
            zzb.zzn("BillingClient", "Consuming purchase with token: " + qw2);
            if (this.f20switch) {
                Bundle zze = this.f1245th.zze(9, this.f1244rg.getPackageName(), qw2, zzb.zzd(ukVar, this.f20switch, this.f1238ad));
                i2 = zze.getInt("RESPONSE_CODE");
                str = zzb.zzk(zze, "BillingClient");
            } else {
                i2 = this.f1245th.zza(3, this.f1244rg.getPackageName(), qw2);
                str = "";
            }
            yj.qw de2 = yj.de();
            de2.de(i2);
            de2.ad(str);
            yj qw3 = de2.qw();
            if (i2 == 0) {
                zzb.zzn("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.th(qw3, qw2);
                return null;
            }
            zzb.zzo("BillingClient", "Error consuming purchase with token. Response code: " + i2);
            consumeResponseListener.th(qw3, qw2);
            return null;
        } catch (Exception e) {
            zzb.zzp("BillingClient", "Error consuming purchase!", e);
            consumeResponseListener.th(l.f1264uk, qw2);
            return null;
        }
    }

    public final /* synthetic */ Object c(ppp ppp2, ProductDetailsResponseListener productDetailsResponseListener) throws Exception {
        String str;
        ArrayList arrayList = new ArrayList();
        String de2 = ppp2.de();
        zzu ad2 = ppp2.ad();
        int size = ad2.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            str = "Item is unavailable for purchase.";
            if (i3 >= size) {
                str = "";
                break;
            }
            int i4 = i3 + 20;
            ArrayList arrayList2 = new ArrayList(ad2.subList(i3, i4 > size ? size : i4));
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                arrayList3.add(((ppp.ad) arrayList2.get(i5)).ad());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.f1238ad);
            try {
                int i6 = i4;
                Bundle zzl = this.f1245th.zzl(17, this.f1244rg.getPackageName(), de2, bundle, zzb.zzg(this.f1238ad, arrayList2, (String) null));
                if (zzl == null) {
                    zzb.zzo("BillingClient", "queryProductDetailsAsync got empty product details response.");
                    break;
                } else if (!zzl.containsKey("DETAILS_LIST")) {
                    i2 = zzb.zzb(zzl, "BillingClient");
                    str = zzb.zzk(zzl, "BillingClient");
                    if (i2 != 0) {
                        zzb.zzo("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + i2);
                    } else {
                        zzb.zzo("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                    }
                } else {
                    ArrayList<String> stringArrayList = zzl.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        zzb.zzo("BillingClient", "queryProductDetailsAsync got null response list");
                        break;
                    }
                    int i7 = 0;
                    while (i7 < stringArrayList.size()) {
                        try {
                            o oVar = new o(stringArrayList.get(i7));
                            zzb.zzn("BillingClient", "Got product details: ".concat(oVar.toString()));
                            arrayList.add(oVar);
                            i7++;
                        } catch (JSONException e) {
                            zzb.zzp("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                            str = "Error trying to decode SkuDetails.";
                            i2 = 6;
                            yj.qw de3 = yj.de();
                            de3.de(i2);
                            de3.ad(str);
                            productDetailsResponseListener.qw(de3.qw(), arrayList);
                            return null;
                        }
                    }
                    i3 = i6;
                }
            } catch (Exception e2) {
                zzb.zzp("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e2);
                str = "An internal error occurred.";
            }
        }
        i2 = 4;
        yj.qw de32 = yj.de();
        de32.de(i2);
        de32.ad(str);
        productDetailsResponseListener.qw(de32.qw(), arrayList);
        return null;
    }

    public final void ddd(String str, PurchasesResponseListener purchasesResponseListener) {
        if (!ad()) {
            purchasesResponseListener.qw(l.f1264uk, zzu.zzl());
        } else if (TextUtils.isEmpty(str)) {
            zzb.zzo("BillingClient", "Please provide a valid product type.");
            purchasesResponseListener.qw(l.f1258fe, zzu.zzl());
        } else {
            if (xxx(new qqq(this, str, purchasesResponseListener), 30000, new nn(purchasesResponseListener), when()) == null) {
                purchasesResponseListener.qw(ggg(), zzu.zzl());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0360 A[Catch:{ CancellationException | TimeoutException -> 0x03ac, Exception -> 0x03a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0386 A[Catch:{ CancellationException | TimeoutException -> 0x03ac, Exception -> 0x03a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final fe.de.qw.qw.yj de(android.app.Activity r32, fe.de.qw.qw.th r33) {
        /*
            r31 = this;
            r8 = r31
            r0 = r32
            java.lang.String r1 = "proxyPackageVersion"
            java.lang.String r9 = "BUY_INTENT"
            boolean r2 = r31.ad()
            if (r2 != 0) goto L_0x0014
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1264uk
            r8.ppp(r0)
            return r0
        L_0x0014:
            java.util.ArrayList r2 = r33.th()
            java.util.List r3 = r33.yj()
            r4 = 0
            java.lang.Object r5 = com.google.android.gms.internal.play_billing.zzz.zza(r2, r4)
            fe.de.qw.qw.vvv r5 = (fe.de.qw.qw.vvv) r5
            java.lang.Object r6 = com.google.android.gms.internal.play_billing.zzz.zza(r3, r4)
            fe.de.qw.qw.th$ad r6 = (fe.de.qw.qw.th.ad) r6
            if (r5 == 0) goto L_0x0034
            java.lang.String r7 = r5.qw()
            java.lang.String r10 = r5.ad()
            goto L_0x0044
        L_0x0034:
            fe.de.qw.qw.o r7 = r6.ad()
            java.lang.String r7 = r7.ad()
            fe.de.qw.qw.o r10 = r6.ad()
            java.lang.String r10 = r10.de()
        L_0x0044:
            java.lang.String r11 = "subs"
            boolean r11 = r10.equals(r11)
            java.lang.String r12 = "BillingClient"
            if (r11 == 0) goto L_0x005e
            boolean r11 = r8.f1246uk
            if (r11 == 0) goto L_0x0053
            goto L_0x005e
        L_0x0053:
            java.lang.String r0 = "Current client doesn't support subscriptions."
            com.google.android.gms.internal.play_billing.zzb.zzo(r12, r0)
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1260o
            r8.ppp(r0)
            return r0
        L_0x005e:
            boolean r11 = r33.ggg()
            if (r11 == 0) goto L_0x0074
            boolean r11 = r8.f1243pf
            if (r11 == 0) goto L_0x0069
            goto L_0x0074
        L_0x0069:
            java.lang.String r0 = "Current client doesn't support extra params for buy intent."
            com.google.android.gms.internal.play_billing.zzb.zzo(r12, r0)
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1262rg
            r8.ppp(r0)
            return r0
        L_0x0074:
            int r11 = r2.size()
            r13 = 1
            if (r11 <= r13) goto L_0x008b
            boolean r11 = r8.xxx
            if (r11 == 0) goto L_0x0080
            goto L_0x008b
        L_0x0080:
            java.lang.String r0 = "Current client doesn't support multi-item purchases."
            com.google.android.gms.internal.play_billing.zzb.zzo(r12, r0)
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1261pf
            r8.ppp(r0)
            return r0
        L_0x008b:
            boolean r11 = r3.isEmpty()
            if (r11 != 0) goto L_0x00a1
            boolean r11 = r8.ddd
            if (r11 == 0) goto L_0x0096
            goto L_0x00a1
        L_0x0096:
            java.lang.String r0 = "Current client doesn't support purchases with ProductDetails."
            com.google.android.gms.internal.play_billing.zzb.zzo(r12, r0)
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f22switch
            r8.ppp(r0)
            return r0
        L_0x00a1:
            boolean r11 = r8.f1243pf
            if (r11 == 0) goto L_0x0335
            boolean r11 = r8.f20switch
            boolean r14 = r8.nn
            boolean r15 = r8.mmm
            java.lang.String r4 = r8.f1238ad
            r13 = r33
            android.os.Bundle r11 = com.google.android.gms.internal.play_billing.zzb.zzf(r13, r11, r14, r15, r4)
            boolean r4 = r2.isEmpty()
            java.lang.String r14 = "additionalSkuTypes"
            java.lang.String r15 = "additionalSkus"
            java.lang.String r13 = "skuDetailsTokens"
            r17 = r9
            java.lang.String r9 = "SKU_OFFER_ID_TOKEN_LIST"
            if (r4 != 0) goto L_0x01ce
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r18 = r10
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r19 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r20 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r21 = r2.iterator()
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
        L_0x00ee:
            boolean r26 = r21.hasNext()
            if (r26 == 0) goto L_0x015c
            java.lang.Object r26 = r21.next()
            fe.de.qw.qw.vvv r26 = (fe.de.qw.qw.vvv) r26
            java.lang.String r27 = r26.uk()
            boolean r27 = r27.isEmpty()
            if (r27 != 0) goto L_0x010e
            r27 = r12
            java.lang.String r12 = r26.uk()
            r4.add(r12)
            goto L_0x0110
        L_0x010e:
            r27 = r12
        L_0x0110:
            java.lang.String r12 = r26.rg()
            r28 = r6
            java.lang.String r6 = r26.fe()
            int r29 = r26.de()
            r30 = r5
            java.lang.String r5 = r26.yj()
            r0.add(r12)
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            r16 = 1
            r12 = r12 ^ 1
            r22 = r22 | r12
            r10.add(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r6 = r6 ^ 1
            r23 = r23 | r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r29)
            r7.add(r6)
            if (r29 == 0) goto L_0x0147
            r6 = 1
            goto L_0x0148
        L_0x0147:
            r6 = 0
        L_0x0148:
            r24 = r24 | r6
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r6 = r6 ^ 1
            r25 = r25 | r6
            r1.add(r5)
            r12 = r27
            r6 = r28
            r5 = r30
            goto L_0x00ee
        L_0x015c:
            r30 = r5
            r28 = r6
            r27 = r12
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x016b
            r11.putStringArrayList(r13, r4)
        L_0x016b:
            if (r22 == 0) goto L_0x0170
            r11.putStringArrayList(r9, r0)
        L_0x0170:
            if (r23 == 0) goto L_0x0177
            java.lang.String r0 = "SKU_OFFER_ID_LIST"
            r11.putStringArrayList(r0, r10)
        L_0x0177:
            if (r24 == 0) goto L_0x017e
            java.lang.String r0 = "SKU_OFFER_TYPE_LIST"
            r11.putIntegerArrayList(r0, r7)
        L_0x017e:
            if (r25 == 0) goto L_0x0185
            java.lang.String r0 = "SKU_SERIALIZED_DOCID_LIST"
            r11.putStringArrayList(r0, r1)
        L_0x0185:
            int r0 = r2.size()
            r1 = 1
            if (r0 <= r1) goto L_0x0263
            java.util.ArrayList r0 = new java.util.ArrayList
            int r4 = r2.size()
            int r4 = r4 + -1
            r0.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r2.size()
            int r5 = r5 + -1
            r4.<init>(r5)
            r5 = 1
        L_0x01a3:
            int r6 = r2.size()
            if (r5 >= r6) goto L_0x01c6
            java.lang.Object r6 = r2.get(r5)
            fe.de.qw.qw.vvv r6 = (fe.de.qw.qw.vvv) r6
            java.lang.String r6 = r6.qw()
            r0.add(r6)
            java.lang.Object r6 = r2.get(r5)
            fe.de.qw.qw.vvv r6 = (fe.de.qw.qw.vvv) r6
            java.lang.String r6 = r6.ad()
            r4.add(r6)
            int r5 = r5 + 1
            goto L_0x01a3
        L_0x01c6:
            r11.putStringArrayList(r15, r0)
            r11.putStringArrayList(r14, r4)
            goto L_0x0263
        L_0x01ce:
            r20 = r1
            r30 = r5
            r28 = r6
            r19 = r7
            r18 = r10
            r27 = r12
            r1 = 1
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r3.size()
            int r2 = r2 + -1
            r0.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = r3.size()
            int r4 = r4 + -1
            r2.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
        L_0x01fc:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x024b
            java.lang.Object r7 = r3.get(r6)
            fe.de.qw.qw.th$ad r7 = (fe.de.qw.qw.th.ad) r7
            fe.de.qw.qw.o r10 = r7.ad()
            java.lang.String r12 = r10.th()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x021d
            java.lang.String r10 = r10.th()
            r4.add(r10)
        L_0x021d:
            java.lang.String r7 = r7.de()
            r5.add(r7)
            if (r6 <= 0) goto L_0x0248
            java.lang.Object r7 = r3.get(r6)
            fe.de.qw.qw.th$ad r7 = (fe.de.qw.qw.th.ad) r7
            fe.de.qw.qw.o r7 = r7.ad()
            java.lang.String r7 = r7.ad()
            r0.add(r7)
            java.lang.Object r7 = r3.get(r6)
            fe.de.qw.qw.th$ad r7 = (fe.de.qw.qw.th.ad) r7
            fe.de.qw.qw.o r7 = r7.ad()
            java.lang.String r7 = r7.de()
            r2.add(r7)
        L_0x0248:
            int r6 = r6 + 1
            goto L_0x01fc
        L_0x024b:
            r11.putStringArrayList(r9, r5)
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0257
            r11.putStringArrayList(r13, r4)
        L_0x0257:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x0263
            r11.putStringArrayList(r15, r0)
            r11.putStringArrayList(r14, r2)
        L_0x0263:
            boolean r0 = r11.containsKey(r9)
            if (r0 == 0) goto L_0x0274
            boolean r0 = r8.ggg
            if (r0 == 0) goto L_0x026e
            goto L_0x0274
        L_0x026e:
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f21if
            r8.ppp(r0)
            return r0
        L_0x0274:
            java.lang.String r0 = "skuPackageName"
            if (r30 == 0) goto L_0x028c
            java.lang.String r2 = r30.th()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x028c
            java.lang.String r2 = r30.th()
            r11.putString(r0, r2)
        L_0x0289:
            r0 = 0
            r13 = 1
            goto L_0x02aa
        L_0x028c:
            if (r28 == 0) goto L_0x02a8
            fe.de.qw.qw.o r2 = r28.ad()
            java.lang.String r2 = r2.rg()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02a8
            fe.de.qw.qw.o r2 = r28.ad()
            java.lang.String r2 = r2.rg()
            r11.putString(r0, r2)
            goto L_0x0289
        L_0x02a8:
            r0 = 0
            r13 = 0
        L_0x02aa:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x02b5
            java.lang.String r1 = "accountName"
            r11.putString(r1, r0)
        L_0x02b5:
            android.content.Intent r0 = r32.getIntent()
            if (r0 != 0) goto L_0x02c3
            java.lang.String r0 = "Activity's intent is null."
            r9 = r27
            com.google.android.gms.internal.play_billing.zzb.zzo(r9, r0)
            goto L_0x02f4
        L_0x02c3:
            r9 = r27
            java.lang.String r1 = "PROXY_PACKAGE"
            java.lang.String r2 = r0.getStringExtra(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02f4
            java.lang.String r0 = r0.getStringExtra(r1)
            java.lang.String r1 = "proxyPackage"
            r11.putString(r1, r0)
            android.content.Context r1 = r8.f1244rg     // Catch:{ NameNotFoundException -> 0x02ed }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x02ed }
            r2 = 0
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x02ed }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x02ed }
            r1 = r20
            r11.putString(r1, r0)     // Catch:{ NameNotFoundException -> 0x02ef }
            goto L_0x02f4
        L_0x02ed:
            r1 = r20
        L_0x02ef:
            java.lang.String r0 = "package not found"
            r11.putString(r1, r0)
        L_0x02f4:
            boolean r0 = r8.ddd
            if (r0 == 0) goto L_0x0303
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0303
            r0 = 17
            r3 = 17
            goto L_0x0319
        L_0x0303:
            boolean r0 = r8.vvv
            if (r0 == 0) goto L_0x030e
            if (r13 == 0) goto L_0x030e
            r0 = 15
            r3 = 15
            goto L_0x0319
        L_0x030e:
            boolean r0 = r8.f20switch
            if (r0 == 0) goto L_0x0317
            r0 = 9
            r3 = 9
            goto L_0x0319
        L_0x0317:
            r0 = 6
            r3 = 6
        L_0x0319:
            fe.de.qw.qw.xxx r0 = new fe.de.qw.qw.xxx
            r1 = r0
            r2 = r31
            r4 = r19
            r5 = r18
            r6 = r33
            r7 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r3 = 5000(0x1388, double:2.4703E-320)
            r5 = 0
            android.os.Handler r6 = r8.f1239de
            r1 = r31
            r2 = r0
            java.util.concurrent.Future r0 = r1.xxx(r2, r3, r5, r6)
            goto L_0x034c
        L_0x0335:
            r19 = r7
            r17 = r9
            r18 = r10
            r9 = r12
            fe.de.qw.qw.ddd r2 = new fe.de.qw.qw.ddd
            r2.<init>(r8, r7, r10)
            r3 = 5000(0x1388, double:2.4703E-320)
            r5 = 0
            android.os.Handler r6 = r8.f1239de
            r1 = r31
            java.util.concurrent.Future r0 = r1.xxx(r2, r3, r5, r6)
        L_0x034c:
            r1 = 5000(0x1388, double:2.4703E-320)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            java.lang.Object r0 = r0.get(r1, r3)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            int r1 = com.google.android.gms.internal.play_billing.zzb.zzb(r0, r9)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            java.lang.String r2 = com.google.android.gms.internal.play_billing.zzb.zzk(r0, r9)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            if (r1 == 0) goto L_0x0386
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r0.<init>()     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            java.lang.String r3 = "Unable to buy item, Error response code: "
            r0.append(r3)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r0.append(r1)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            com.google.android.gms.internal.play_billing.zzb.zzo(r9, r0)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            fe.de.qw.qw.yj$qw r0 = fe.de.qw.qw.yj.de()     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r0.de(r1)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r0.ad(r2)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            fe.de.qw.qw.yj r0 = r0.qw()     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r8.ppp(r0)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            return r0
        L_0x0386:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            java.lang.Class<com.android.billingclient.api.ProxyBillingActivity> r2 = com.android.billingclient.api.ProxyBillingActivity.class
            r3 = r32
            r1.<init>(r3, r2)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r2 = r17
            android.os.Parcelable r0 = r0.getParcelable(r2)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r1.putExtra(r2, r0)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            r3.startActivity(r1)     // Catch:{ TimeoutException -> 0x03ae, CancellationException -> 0x03ac, Exception -> 0x03a0 }
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1265yj
            return r0
        L_0x03a0:
            r0 = move-exception
            java.lang.String r1 = "Exception while launching billing flow. Try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzp(r9, r1, r0)
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1264uk
            r8.ppp(r0)
            return r0
        L_0x03ac:
            r0 = move-exception
            goto L_0x03af
        L_0x03ae:
            r0 = move-exception
        L_0x03af:
            java.lang.String r1 = "Time out while launching billing flow. Try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzp(r9, r1, r0)
            fe.de.qw.qw.yj r0 = fe.de.qw.qw.l.f1259i
            r8.ppp(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.de.qw.qw.fe.de(android.app.Activity, fe.de.qw.qw.th):fe.de.qw.qw.yj");
    }

    public final yj ggg() {
        if (this.qw == 0 || this.qw == 3) {
            return l.f1264uk;
        }
        return l.f1263th;
    }

    public final yj ppp(yj yjVar) {
        if (Thread.interrupted()) {
            return yjVar;
        }
        this.f1239de.post(new aaa(this, yjVar));
        return yjVar;
    }

    public final /* synthetic */ Bundle qqq(String str, String str2) throws Exception {
        return this.f1245th.zzf(3, this.f1244rg.getPackageName(), str, str2, (String) null);
    }

    public final void qw(uk ukVar, ConsumeResponseListener consumeResponseListener) {
        if (!ad()) {
            consumeResponseListener.th(l.f1264uk, ukVar.qw());
            return;
        }
        if (xxx(new h0(this, ukVar, consumeResponseListener), 30000, new i0(consumeResponseListener, ukVar), when()) == null) {
            consumeResponseListener.th(ggg(), ukVar.qw());
        }
    }

    public void rg(ppp ppp2, ProductDetailsResponseListener productDetailsResponseListener) {
        if (!ad()) {
            productDetailsResponseListener.qw(l.f1264uk, new ArrayList());
        } else if (!this.ddd) {
            zzb.zzo("BillingClient", "Querying product details is not supported.");
            productDetailsResponseListener.qw(l.f22switch, new ArrayList());
        } else {
            if (xxx(new f0(this, ppp2, productDetailsResponseListener), 30000, new g0(productDetailsResponseListener), when()) == null) {
                productDetailsResponseListener.qw(ggg(), new ArrayList());
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final /* synthetic */ void m56switch(yj yjVar) {
        if (this.f1240fe.de() != null) {
            this.f1240fe.de().fe(yjVar, (List<Cif>) null);
            return;
        }
        this.f1240fe.ad();
        zzb.zzo("BillingClient", "No valid listener is set in BroadcastManager");
    }

    public void th(ggg ggg2, PurchasesResponseListener purchasesResponseListener) {
        ddd(ggg2.ad(), purchasesResponseListener);
    }

    public final void uk(Context context, PurchasesUpdatedListener purchasesUpdatedListener, boolean z, @Nullable zzc zzc) {
        Context applicationContext = context.getApplicationContext();
        this.f1244rg = applicationContext;
        this.f1240fe = new d0(applicationContext, purchasesUpdatedListener, zzc);
        this.nn = z;
        this.mmm = zzc != null;
    }

    public final Handler when() {
        return Looper.myLooper() == null ? this.f1239de : new Handler(Looper.myLooper());
    }

    @Nullable
    public final Future xxx(Callable callable, long j, @Nullable Runnable runnable, Handler handler) {
        long j2 = (long) (((double) j) * 0.95d);
        if (this.aaa == null) {
            this.aaa = Executors.newFixedThreadPool(zzb.zza, new eee(this));
        }
        try {
            Future submit = this.aaa.submit(callable);
            handler.postDelayed(new mmm(submit, runnable), j2);
            return submit;
        } catch (Exception e) {
            zzb.zzp("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public final void yj(BillingClientStateListener billingClientStateListener) {
        ServiceInfo serviceInfo;
        if (ad()) {
            zzb.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.ad(l.f1265yj);
        } else if (this.qw == 1) {
            zzb.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
            billingClientStateListener.ad(l.f1257de);
        } else if (this.qw == 3) {
            zzb.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.ad(l.f1264uk);
        } else {
            this.qw = 1;
            this.f1240fe.fe();
            zzb.zzn("BillingClient", "Starting in-app billing setup.");
            this.f1247yj = new b(this, billingClientStateListener, (a) null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.f1244rg.getPackageManager().queryIntentServices(intent, 0);
            if (!(queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null)) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zzb.zzo("BillingClient", "The device doesn't have valid Play Store.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.f1238ad);
                    if (this.f1244rg.bindService(intent2, this.f1247yj, 1)) {
                        zzb.zzn("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    zzb.zzo("BillingClient", "Connection to Billing service is blocked.");
                }
            }
            this.qw = 0;
            zzb.zzn("BillingClient", "Billing service unavailable on device.");
            billingClientStateListener.ad(l.f1256ad);
        }
    }

    @AnyThread
    public fe(@Nullable String str, boolean z, Context context, zzbe zzbe) {
        this.qw = 0;
        this.f1239de = new Handler(Looper.getMainLooper());
        this.f1242o = 0;
        this.f1238ad = vvv();
        Context applicationContext = context.getApplicationContext();
        this.f1244rg = applicationContext;
        this.f1240fe = new d0(applicationContext, (zzbe) null);
        this.nn = z;
    }

    @AnyThread
    public fe(@Nullable String str, boolean z, Context context, PurchasesUpdatedListener purchasesUpdatedListener, @Nullable zzc zzc) {
        this(context, z, purchasesUpdatedListener, vvv(), (String) null, (zzc) null);
    }
}
