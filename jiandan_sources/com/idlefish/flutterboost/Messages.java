package com.idlefish.flutterboost;

import fe.p036switch.qw.Cswitch;
import fe.p036switch.qw.ddd;
import fe.p036switch.qw.ggg;
import fe.p036switch.qw.mmm;
import fe.p036switch.qw.nn;
import fe.p036switch.qw.ppp;
import fe.p036switch.qw.vvv;
import fe.p036switch.qw.when;
import fe.p036switch.qw.xxx;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messages {

    public static class FlutterRouterApi {
        public final BinaryMessenger qw;

        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterRouterApi(BinaryMessenger binaryMessenger) {
            this.qw = binaryMessenger;
        }

        public void ggg(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", new StandardMessageCodec()).send(qwVar.pf(), new Cswitch(reply));
        }

        /* renamed from: if  reason: not valid java name */
        public void m674if(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.onContainerHide", new StandardMessageCodec()).send(qwVar.pf(), new xxx(reply));
        }

        public void o(Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.onBackPressed", new StandardMessageCodec()).send(null, new when(reply));
        }

        public void pf(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.onBackground", new StandardMessageCodec()).send(qwVar.pf(), new ppp(reply));
        }

        public void ppp(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.onNativeResult", new StandardMessageCodec()).send(qwVar.pf(), new ggg(reply));
        }

        /* renamed from: switch  reason: not valid java name */
        public void m675switch(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.onContainerShow", new StandardMessageCodec()).send(qwVar.pf(), new mmm(reply));
        }

        public void vvv(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.removeRoute", new StandardMessageCodec()).send(qwVar.pf(), new nn(reply));
        }

        public void when(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.onForeground", new StandardMessageCodec()).send(qwVar.pf(), new ddd(reply));
        }

        public void xxx(qw qwVar, Reply<Void> reply) {
            new BasicMessageChannel(this.qw, "dev.flutter.pigeon.FlutterRouterApi.sendEventToFlutter", new StandardMessageCodec()).send(qwVar.pf(), new vvv(reply));
        }
    }

    public interface NativeRouterApi {
        void ad(qw qwVar);

        void de(qw qwVar);

        void fe(qw qwVar);

        void qw(qw qwVar, Result<Void> result);

        void rg(ad adVar);

        ad th();
    }

    public interface Result<T> {
        void success(T t);
    }

    public static class ad {

        /* renamed from: ad  reason: collision with root package name */
        public Map<Object, Object> f6516ad;
        public List<Object> qw;

        public static ad qw(Map<String, Object> map) {
            ad adVar = new ad();
            adVar.qw = (List) map.get("containers");
            adVar.f6516ad = (Map) map.get("routes");
            return adVar;
        }

        public Map<String, Object> ad() {
            HashMap hashMap = new HashMap();
            hashMap.put("containers", this.qw);
            hashMap.put("routes", this.f6516ad);
            return hashMap;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f6517ad;

        /* renamed from: de  reason: collision with root package name */
        public Map<Object, Object> f6518de;

        /* renamed from: fe  reason: collision with root package name */
        public Boolean f6519fe;
        public String qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f6520rg;

        public static qw qw(Map<String, Object> map) {
            qw qwVar = new qw();
            qwVar.qw = (String) map.get("pageName");
            qwVar.f6517ad = (String) map.get("uniqueId");
            qwVar.f6518de = (Map) map.get("arguments");
            qwVar.f6519fe = (Boolean) map.get("opaque");
            qwVar.f6520rg = (String) map.get("key");
            return qwVar;
        }

        public Map<Object, Object> ad() {
            return this.f6518de;
        }

        public String de() {
            return this.f6520rg;
        }

        public Boolean fe() {
            return this.f6519fe;
        }

        public void i(String str) {
            this.qw = str;
        }

        public void o(String str) {
            this.f6517ad = str;
        }

        public Map<String, Object> pf() {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", this.qw);
            hashMap.put("uniqueId", this.f6517ad);
            hashMap.put("arguments", this.f6518de);
            hashMap.put("opaque", this.f6519fe);
            hashMap.put("key", this.f6520rg);
            return hashMap;
        }

        public String rg() {
            return this.qw;
        }

        public String th() {
            return this.f6517ad;
        }

        public void uk(String str) {
            this.f6520rg = str;
        }

        public void yj(Map<Object, Object> map) {
            this.f6518de = map;
        }
    }

    public static Map<String, Object> ad(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th2.toString());
        hashMap.put("code", th2.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
