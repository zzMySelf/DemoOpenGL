package fe.fe.pf.fe.qw;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.bridge.BaseBridge;
import com.baidu.helios.channels.ChannelFactory;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.helios.ids.IdProviderFactory;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.sapi2.SapiAccount;
import fe.fe.pf.rg.qw;
import fe.fe.pf.yj.rg.qw;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

public class qw extends BaseBridge {

    /* renamed from: de  reason: collision with root package name */
    public Context f2727de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile th f2728fe;

    /* renamed from: rg  reason: collision with root package name */
    public final Object f2729rg = new Object();

    public class ad implements Callable<Boolean> {
        public ad() {
        }

        /* renamed from: qw */
        public Boolean call() {
            qw qwVar = qw.this;
            qwVar.o(qwVar.f2728fe);
            return Boolean.TRUE;
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ BaseBridge.OnGetResultCallback f2731ad;

        public de(BaseBridge.OnGetResultCallback onGetResultCallback) {
            this.f2731ad = onGetResultCallback;
        }

        public void run() {
            if (qw.this.f2728fe.f2747uk == null) {
                this.f2731ad.qw(-1, (Exception) null, (Bundle) null);
                return;
            }
            this.f2731ad.onResult(qw.this.f2728fe.f2747uk.qw(), (Bundle) null);
        }
    }

    public class fe implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ BaseBridge.OnGetResultCallback f2733ad;

        public fe(qw qwVar, BaseBridge.OnGetResultCallback onGetResultCallback) {
            this.f2733ad = onGetResultCallback;
        }

        public void run() {
            this.f2733ad.qw(-1, (Exception) null, (Bundle) null);
        }
    }

    public static class i {

        /* renamed from: ad  reason: collision with root package name */
        public FileOutputStream f2734ad;

        /* renamed from: de  reason: collision with root package name */
        public FileLock f2735de;
        public qw.C0142qw qw;

        public i(qw.C0142qw qwVar) {
            this.qw = qwVar;
        }

        public boolean ad() {
            FileLock fileLock = this.f2735de;
            if (fileLock == null) {
                return false;
            }
            try {
                fileLock.release();
                FileOutputStream fileOutputStream = this.f2734ad;
                if (fileOutputStream != null) {
                    fe.fe.pf.yj.fe.de.de.ad(fileOutputStream);
                    this.f2734ad = null;
                }
                this.f2735de = null;
                return true;
            } catch (IOException unused) {
                FileOutputStream fileOutputStream2 = this.f2734ad;
                if (fileOutputStream2 != null) {
                    fe.fe.pf.yj.fe.de.de.ad(fileOutputStream2);
                    this.f2734ad = null;
                }
                this.f2735de = null;
                return false;
            } catch (Throwable th2) {
                FileOutputStream fileOutputStream3 = this.f2734ad;
                if (fileOutputStream3 != null) {
                    fe.fe.pf.yj.fe.de.de.ad(fileOutputStream3);
                    this.f2734ad = null;
                }
                this.f2735de = null;
                throw th2;
            }
        }

        public boolean qw() {
            this.qw.qw();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.qw.fe("lock"));
                this.f2734ad = fileOutputStream;
                this.f2735de = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public static class o {

        /* renamed from: ad  reason: collision with root package name */
        public String f2736ad;

        /* renamed from: de  reason: collision with root package name */
        public long f2737de;
        public String qw;

        public o(String str, String str2, long j) {
            this.qw = str;
            this.f2736ad = str2;
            this.f2737de = j;
        }
    }

    public static class pf {
        public List<o> qw = new ArrayList();

        public void ad(String str, String str2, long j) {
            this.qw.add(new o(str, str2, j));
        }

        public String qw() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (o next : this.qw) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, next.qw);
                    jSONObject.put("aid", next.f2736ad);
                    jSONObject.put("priority", next.f2737de);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }
    }

    /* renamed from: fe.fe.pf.fe.qw.qw$qw  reason: collision with other inner class name */
    public class C0121qw implements Callable<Boolean> {
        public C0121qw() {
        }

        /* renamed from: qw */
        public Boolean call() {
            qw qwVar = qw.this;
            qwVar.ppp(qwVar.f2728fe);
            return Boolean.TRUE;
        }
    }

    public static class rg {
        public Map<String, C0122qw> qw = new HashMap();

        /* renamed from: fe.fe.pf.fe.qw.qw$rg$qw  reason: collision with other inner class name */
        public static class C0122qw {

            /* renamed from: ad  reason: collision with root package name */
            public long f2739ad;
            public boolean qw;

            public C0122qw(boolean z, long j) {
                this.qw = z;
                this.f2739ad = j;
            }
        }

        public void ad(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String i2 = trustSubject.i("config-cs");
                if (!TextUtils.isEmpty(i2) && (optJSONObject = new JSONObject(i2).optJSONObject("cs")) != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject = optJSONObject.getJSONObject(next);
                        this.qw.put(next, new C0122qw(jSONObject.optBoolean("enable", true), jSONObject.optLong("priority", -1)));
                    }
                }
            } catch (Exception unused) {
            }
        }

        public C0122qw qw(String str) {
            return this.qw.get(str);
        }
    }

    public static class th {

        /* renamed from: ad  reason: collision with root package name */
        public volatile ChannelFactory f2740ad;

        /* renamed from: de  reason: collision with root package name */
        public volatile TrustSubjectManager f2741de;

        /* renamed from: fe  reason: collision with root package name */
        public volatile TrustSubjectManager.th f2742fe;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, fe.fe.pf.rg.qw> f2743i = new HashMap();

        /* renamed from: o  reason: collision with root package name */
        public volatile Map<String, BaseIdProvider> f2744o = new HashMap();
        public volatile IdProviderFactory qw;

        /* renamed from: rg  reason: collision with root package name */
        public volatile Future<Boolean> f2745rg;

        /* renamed from: th  reason: collision with root package name */
        public volatile Future<Boolean> f2746th;

        /* renamed from: uk  reason: collision with root package name */
        public volatile pf f2747uk;

        /* renamed from: yj  reason: collision with root package name */
        public volatile fe.fe.pf.yj.rg.qw f2748yj;
    }

    public static class uk {
        public Map<String, C0123qw> qw = new HashMap();

        /* renamed from: fe.fe.pf.fe.qw.qw$uk$qw  reason: collision with other inner class name */
        public static class C0123qw {
            public boolean qw;

            public C0123qw(boolean z) {
                this.qw = z;
            }
        }

        public void ad(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String i2 = trustSubject.i("config-ids");
                if (!TextUtils.isEmpty(i2) && (optJSONObject = new JSONObject(i2).optJSONObject("ids")) != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.qw.put(next, new C0123qw(optJSONObject.getJSONObject(next).optBoolean("enable", true)));
                    }
                }
            } catch (Exception unused) {
            }
        }

        public C0123qw qw(String str) {
            return this.qw.get(str);
        }
    }

    public static class yj<T> implements BaseIdProvider.OnGetResultCallback<T> {
        public BaseBridge.OnGetResultCallback<T> qw;

        public yj(BaseBridge.OnGetResultCallback<T> onGetResultCallback) {
            this.qw = onGetResultCallback;
        }

        public void onResult(T t, Bundle bundle) {
            this.qw.onResult(t, bundle);
        }

        public void qw(int i2, Exception exc, Bundle bundle) {
            this.qw.qw(i2, exc, bundle);
        }
    }

    public void fe() {
        vvv();
    }

    public final void i() {
        try {
            this.f2728fe.f2745rg.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void o(th thVar) {
        uk ukVar;
        fe.fe.pf.yj.rg.qw qwVar = new fe.fe.pf.yj.rg.qw(this.f2727de);
        thVar.f2748yj = qwVar;
        i iVar = new i(qwVar.fe().th("init"));
        try {
            iVar.qw();
            TrustSubjectManager.qw qwVar2 = new TrustSubjectManager.qw();
            qwVar2.qw = this.f2727de;
            qwVar2.f858ad = qwVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            thVar.f2741de = trustSubjectManager;
            trustSubjectManager.qw(qwVar2);
            trustSubjectManager.rg(new TrustSubjectManager.ad());
            thVar.f2742fe = trustSubjectManager.yj(new TrustSubjectManager.fe());
            if (thVar.qw == null) {
                thVar.qw = new IdProviderFactory(this.qw.qw);
            }
            IdProviderFactory idProviderFactory = thVar.qw;
            BaseIdProvider.ad adVar = new BaseIdProvider.ad();
            adVar.qw = this.f2727de;
            adVar.f815ad = qwVar;
            adVar.f816de = thVar.f2742fe;
            adVar.f817fe = this.qw.f782fe;
            adVar.f818rg = this.qw.f783rg;
            BaseIdProvider.de deVar = new BaseIdProvider.de();
            deVar.qw = false;
            List<BaseIdProvider> ad2 = idProviderFactory.ad();
            ArrayList<BaseIdProvider> arrayList = ad2 == null ? new ArrayList<>() : new ArrayList<>(ad2);
            uk.C0123qw qwVar3 = null;
            if (thVar.f2742fe.f859ad != null) {
                ukVar = new uk();
                ukVar.ad(thVar.f2742fe.f859ad);
            } else {
                ukVar = null;
            }
            if (arrayList.size() > 0 && ukVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    uk.C0123qw qw = ukVar.qw(((BaseIdProvider) it.next()).rg());
                    if (qw != null && !qw.qw) {
                        it.remove();
                    }
                }
            }
            for (BaseIdProvider baseIdProvider : arrayList) {
                thVar.f2744o.put(baseIdProvider.rg(), baseIdProvider);
                baseIdProvider.qw(adVar);
                baseIdProvider.th(deVar);
            }
            ChannelFactory channelFactory = new ChannelFactory(this.qw.f780ad);
            thVar.f2740ad = channelFactory;
            qw.ad adVar2 = new qw.ad();
            adVar2.qw = this.f2727de;
            adVar2.f2863de = idProviderFactory;
            adVar2.f2862ad = qwVar;
            List<fe.fe.pf.rg.qw> qw2 = channelFactory.qw();
            ArrayList<fe.fe.pf.rg.qw> arrayList2 = qw2 == null ? new ArrayList<>() : new ArrayList<>(qw2);
            if (arrayList2.size() > 0 && thVar.f2742fe.f859ad != null) {
                rg rgVar = new rg();
                rgVar.ad(thVar.f2742fe.f859ad);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    fe.fe.pf.rg.qw qwVar4 = (fe.fe.pf.rg.qw) it2.next();
                    rg.C0122qw qw3 = rgVar.qw(qwVar4.de());
                    if (qw3 != null) {
                        if (!qw3.qw) {
                            it2.remove();
                        } else if (qw3.f2739ad > -1) {
                            qwVar4.yj(qw3.f2739ad);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, fe.fe.pf.rg.qw.f2858rg);
            qw.fe feVar = new qw.fe();
            qw.rg rgVar2 = new qw.rg();
            for (fe.fe.pf.rg.qw qwVar5 : arrayList2) {
                thVar.f2743i.put(qwVar5.de(), qwVar5);
                qwVar5.qw(adVar2);
                qwVar5.rg(feVar);
                qwVar5.th(rgVar2);
            }
            if (ukVar != null) {
                qwVar3 = ukVar.qw("sids");
            }
            if (qwVar3 == null || qwVar3.qw) {
                pf(thVar, arrayList2);
            }
        } finally {
            iVar.ad();
        }
    }

    public final void pf(th thVar, List<fe.fe.pf.rg.qw> list) {
        List<TrustSubject> list2 = thVar.f2742fe.qw;
        qw.yj yjVar = new qw.yj();
        yjVar.qw = true;
        thVar.f2747uk = new pf();
        if (list2 != null) {
            for (TrustSubject next : list2) {
                Iterator<fe.fe.pf.rg.qw> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        qw.uk ad2 = it.next().ad(next.qw, yjVar);
                        if (ad2 != null && ad2.rg()) {
                            thVar.f2747uk.ad(next.qw, ad2.qw, next.m21if());
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public final void ppp(th thVar) {
        fe.fe.pf.yj.rg.qw qwVar = new fe.fe.pf.yj.rg.qw(this.f2727de);
        thVar.f2748yj = qwVar;
        i iVar = new i(qwVar.fe().th("init"));
        try {
            iVar.qw();
            IdProviderFactory idProviderFactory = new IdProviderFactory(this.qw.qw);
            thVar.qw = idProviderFactory;
            BaseIdProvider qw = idProviderFactory.qw("iid");
            BaseIdProvider.ad adVar = new BaseIdProvider.ad();
            adVar.qw = this.f2727de;
            adVar.f815ad = qwVar;
            adVar.f817fe = this.qw.f782fe;
            adVar.f818rg = this.qw.f783rg;
            BaseIdProvider.de deVar = new BaseIdProvider.de();
            deVar.qw = false;
            thVar.f2744o.put(qw.rg(), qw);
            qw.qw(adVar);
            qw.th(deVar);
        } finally {
            iVar.ad();
        }
    }

    public void qw(String str, Bundle bundle, BaseBridge.OnGetResultCallback<String> onGetResultCallback) {
        Runnable runnable;
        ExecutorService executorService;
        m187switch(str);
        BaseIdProvider baseIdProvider = this.f2728fe.f2744o.get(str);
        if (baseIdProvider != null) {
            baseIdProvider.yj(new yj(onGetResultCallback));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.qw.f782fe;
            runnable = new de(onGetResultCallback);
        } else {
            executorService = this.qw.f782fe;
            runnable = new fe(this, onGetResultCallback);
        }
        executorService.submit(runnable);
    }

    public boolean rg(String str) {
        when();
        List<TrustSubject> list = this.f2728fe.f2742fe.qw;
        if (list == null) {
            return false;
        }
        for (TrustSubject trustSubject : list) {
            if (trustSubject.qw.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m187switch(String str) {
        if (TextUtils.equals(str, "iid")) {
            i();
        } else {
            when();
        }
    }

    public void th(BaseBridge.ad adVar) {
        this.f2727de = this.qw.f781de;
        this.f2728fe = new th();
        this.f2728fe.f2745rg = this.qw.f782fe.submit(new C0121qw());
    }

    public final void vvv() {
        synchronized (this.f2729rg) {
            if (this.f2728fe.f2746th == null) {
                this.f2728fe.f2746th = this.qw.f782fe.submit(new ad());
            }
        }
    }

    public final void when() {
        try {
            vvv();
            this.f2728fe.f2746th.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public BaseBridge.de yj(String str, Bundle bundle) {
        m187switch(str);
        BaseIdProvider baseIdProvider = this.f2728fe.f2744o.get(str);
        return baseIdProvider != null ? BaseBridge.de.de(baseIdProvider.de()) : BaseBridge.de.qw(-1, (Exception) null);
    }
}
