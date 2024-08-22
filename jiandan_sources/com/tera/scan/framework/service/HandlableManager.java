package com.tera.scan.framework.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mars.kotlin.service.IHandlable;
import fe.mmm.qw.a.yj.qw.de;
import fe.mmm.qw.i.qw;

public class HandlableManager {

    /* renamed from: ad  reason: collision with root package name */
    public static IHandlable<?>[] f6949ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public static IServiceInitializer f6950de;
    public static final de qw = new de("HandlableManager");

    public interface IServiceInitializer {
        IHandlable<?>[] qw(de deVar, Context context);
    }

    public static synchronized IHandlable<?>[] ad(Context context) {
        IHandlable<?>[] iHandlableArr;
        synchronized (HandlableManager.class) {
            de(context);
            iHandlableArr = f6949ad;
        }
        return iHandlableArr;
    }

    public static void de(Context context) {
        if (f6949ad == null) {
            IServiceInitializer iServiceInitializer = f6950de;
            if (iServiceInitializer == null) {
                qw.rg("HandlableManager", "initializer can not be null, please first call registerServiceInitializer");
            } else {
                f6949ad = iServiceInitializer.qw(qw, context);
            }
        }
    }

    public static void fe(IServiceInitializer iServiceInitializer) {
        f6950de = iServiceInitializer;
    }

    @NonNull
    public static de qw() {
        return qw;
    }
}
