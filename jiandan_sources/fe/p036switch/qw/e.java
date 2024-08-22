package fe.p036switch.qw;

import android.content.Intent;
import android.util.SparseArray;
import com.idlefish.flutterboost.EventListener;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import fe.p036switch.qw.f;
import fe.p036switch.qw.l.ad;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: fe.switch.qw.e  reason: invalid package */
public class e implements FlutterPlugin, Messages.NativeRouterApi, ActivityAware {

    /* renamed from: ad  reason: collision with root package name */
    public FlutterEngine f8798ad;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<String> f8799i;

    /* renamed from: o  reason: collision with root package name */
    public int f8800o = 1000;

    /* renamed from: pf  reason: collision with root package name */
    public HashMap<String, LinkedList<EventListener>> f8801pf = new HashMap<>();

    /* renamed from: th  reason: collision with root package name */
    public Messages.FlutterRouterApi f8802th;

    /* renamed from: uk  reason: collision with root package name */
    public Messages.ad f8803uk;

    /* renamed from: yj  reason: collision with root package name */
    public FlutterBoostDelegate f8804yj;

    public static /* synthetic */ void ddd(Messages.FlutterRouterApi.Reply reply, Void voidR) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public static /* synthetic */ void ggg(Void voidR) {
    }

    public static /* synthetic */ void i(Void voidR) {
    }

    /* renamed from: if  reason: not valid java name */
    public static /* synthetic */ void m1018if(Void voidR) {
    }

    public static /* synthetic */ void pf(Void voidR) {
    }

    public static /* synthetic */ void ppp(Void voidR) {
    }

    /* renamed from: switch  reason: not valid java name */
    public static /* synthetic */ void m1019switch(Void voidR) {
    }

    public static /* synthetic */ void vvv(Void voidR) {
    }

    public static /* synthetic */ void when(Void voidR) {
    }

    public static /* synthetic */ void xxx(Messages.FlutterRouterApi.Reply reply, Void voidR) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public void a(String str) {
        if (this.f8802th != null) {
            yj();
            Messages.qw qwVar = new Messages.qw();
            qwVar.o(str);
            this.f8802th.m675switch(qwVar, th.qw);
            "## onContainerShow: " + str;
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void aaa(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        ad.yj().qw(uniqueId, flutterViewContainer);
        c(uniqueId, flutterViewContainer.getUrl(), flutterViewContainer.getUrlParams(), Cif.qw);
        a(uniqueId);
    }

    public void ad(Messages.qw qwVar) {
        if (this.f8804yj != null) {
            f.ad adVar = new f.ad();
            adVar.i(qwVar.rg());
            adVar.pf(qwVar.th());
            adVar.uk(qwVar.fe().booleanValue());
            adVar.th(qwVar.ad());
            this.f8804yj.ad(adVar.yj());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    public void b() {
        if (this.f8802th != null) {
            yj();
            this.f8802th.when(new Messages.qw(), de.qw);
            "## onForeground: " + this.f8802th;
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void c(String str, String str2, Map<String, Object> map, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.f8802th != null) {
            yj();
            Messages.qw qwVar = new Messages.qw();
            qwVar.o(str);
            qwVar.i(str2);
            qwVar.yj(map);
            this.f8802th.ggg(qwVar, new yj(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void d(String str, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.f8802th != null) {
            yj();
            Messages.qw qwVar = new Messages.qw();
            qwVar.o(str);
            this.f8802th.vvv(qwVar, new uk(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void de(Messages.qw qwVar) {
        String de2 = qwVar.de();
        Map ad2 = qwVar.ad();
        if (ad2 == null) {
            ad2 = new HashMap();
        }
        List<EventListener> list = this.f8801pf.get(de2);
        if (list != null) {
            for (EventListener onEvent : list) {
                onEvent.onEvent(de2, ad2);
            }
        }
    }

    public void e(FlutterBoostDelegate flutterBoostDelegate) {
        this.f8804yj = flutterBoostDelegate;
    }

    public void eee(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        d(uniqueId, fe.qw);
        ad.yj().o(uniqueId);
        if (ad.yj().fe() == 0) {
            FlutterBoost.yj().de(2);
        }
    }

    public void fe(Messages.qw qwVar) {
        if (this.f8804yj != null) {
            int i2 = this.f8800o + 1;
            this.f8800o = i2;
            SparseArray<String> sparseArray = this.f8799i;
            if (sparseArray != null) {
                sparseArray.put(i2, qwVar.rg());
            }
            f.ad adVar = new f.ad();
            adVar.i(qwVar.rg());
            adVar.th(qwVar.ad());
            adVar.o(this.f8800o);
            this.f8804yj.qw(adVar.yj());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    public void mmm() {
        if (this.f8802th != null) {
            yj();
            this.f8802th.pf(new Messages.qw(), o.qw);
            "## onBackground: " + this.f8802th;
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void nn() {
        if (this.f8802th != null) {
            yj();
            this.f8802th.o(pf.qw);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public /* synthetic */ boolean o(int i2, int i3, Intent intent) {
        if (this.f8802th != null) {
            yj();
            Messages.qw qwVar = new Messages.qw();
            String str = this.f8799i.get(i2);
            this.f8799i.remove(i2);
            if (str == null) {
                return true;
            }
            qwVar.i(str);
            if (intent != null) {
                qwVar.yj(h.qw(intent.getExtras()));
            }
            this.f8802th.ppp(qwVar, i.qw);
            return true;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(new ad(this));
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        j.uk(flutterPluginBinding.getBinaryMessenger(), this);
        this.f8798ad = flutterPluginBinding.getFlutterEngine();
        this.f8802th = new Messages.FlutterRouterApi(flutterPluginBinding.getBinaryMessenger());
        this.f8799i = new SparseArray<>();
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f8798ad = null;
        this.f8802th = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    public void qqq(FlutterViewContainer flutterViewContainer) {
        "#onContainerCreated: " + flutterViewContainer.getUniqueId();
        ad.yj().ad(flutterViewContainer.getUniqueId(), flutterViewContainer);
        if (ad.yj().fe() == 1) {
            FlutterBoost.yj().de(0);
        }
    }

    public void qw(Messages.qw qwVar, Messages.Result<Void> result) {
        String th2 = qwVar.th();
        if (th2 != null) {
            FlutterViewContainer de2 = ad.yj().de(th2);
            if (de2 != null) {
                de2.finishContainer(qwVar.ad());
            }
            result.success(null);
            return;
        }
        throw new RuntimeException("Oops!! The unique id is null!");
    }

    public void rg(Messages.ad adVar) {
        this.f8803uk = adVar;
        "#saveStackToHost: " + this.f8803uk;
    }

    public void rrr(FlutterViewContainer flutterViewContainer) {
        tt(flutterViewContainer.getUniqueId());
    }

    public Messages.ad th() {
        if (this.f8803uk == null) {
            return Messages.ad.qw(new HashMap());
        }
        "#getStackFromHost: " + this.f8803uk;
        return this.f8803uk;
    }

    public void tt(String str) {
        if (this.f8802th != null) {
            yj();
            Messages.qw qwVar = new Messages.qw();
            qwVar.o(str);
            this.f8802th.m674if(qwVar, rg.qw);
            "## onContainerHide: " + str;
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public Messages.FlutterRouterApi uk() {
        return this.f8802th;
    }

    public final void yj() {
        FlutterEngine flutterEngine = this.f8798ad;
        if (flutterEngine == null || !flutterEngine.getDartExecutor().isExecutingDart()) {
            throw new RuntimeException("The engine is not ready for use. The message may be drop silently by the engine. You should check 'DartExecutor.isExecutingDart()' first!");
        }
    }
}
