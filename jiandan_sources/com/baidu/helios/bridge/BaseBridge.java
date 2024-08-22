package com.baidu.helios.bridge;

import android.content.Context;
import android.os.Bundle;
import com.baidu.helios.channels.ChannelFactory;
import com.baidu.helios.ids.IdProviderFactory;
import java.util.concurrent.ExecutorService;

public abstract class BaseBridge {

    /* renamed from: ad  reason: collision with root package name */
    public ad f777ad;
    public qw qw;

    public interface OnGetResultCallback<T> {
        void onResult(T t, Bundle bundle);

        void qw(int i2, Exception exc, Bundle bundle);
    }

    public static class ad {
    }

    public static class de {

        /* renamed from: ad  reason: collision with root package name */
        public int f778ad;

        /* renamed from: de  reason: collision with root package name */
        public Exception f779de;
        public String qw;

        public de() {
        }

        public de(int i2, String str, Exception exc) {
            this.f778ad = i2;
            this.qw = str;
            this.f779de = exc;
        }

        public static de de(String str) {
            de deVar = new de();
            deVar.f778ad = 0;
            deVar.qw = str;
            return deVar;
        }

        public static de qw(int i2, Exception exc) {
            de deVar = new de();
            deVar.f778ad = i2;
            deVar.f779de = exc;
            return deVar;
        }

        public boolean ad() {
            return this.f778ad == 0;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public ChannelFactory.ChannelProvider f780ad;

        /* renamed from: de  reason: collision with root package name */
        public Context f781de;

        /* renamed from: fe  reason: collision with root package name */
        public ExecutorService f782fe;
        public IdProviderFactory.IdFactoryProvider qw;

        /* renamed from: rg  reason: collision with root package name */
        public ExecutorService f783rg;
    }

    public void ad(qw qwVar) {
        this.qw = qwVar;
    }

    public void de(ad adVar) {
        this.f777ad = adVar;
        th(adVar);
    }

    public abstract void fe();

    public abstract void qw(String str, Bundle bundle, OnGetResultCallback<String> onGetResultCallback);

    public abstract boolean rg(String str);

    public abstract void th(ad adVar);

    public abstract de yj(String str, Bundle bundle);
}
