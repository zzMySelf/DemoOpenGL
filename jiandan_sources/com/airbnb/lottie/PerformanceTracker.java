package com.airbnb.lottie;

import androidx.collection.ArraySet;
import fe.qw.qw.ggg.rg;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {

    /* renamed from: ad  reason: collision with root package name */
    public final Set<FrameListener> f564ad = new ArraySet();

    /* renamed from: de  reason: collision with root package name */
    public final Map<String, rg> f565de = new HashMap();
    public boolean qw = false;

    public interface FrameListener {
        void qw(float f);
    }

    public void ad(boolean z) {
        this.qw = z;
    }

    public void qw(String str, float f) {
        if (this.qw) {
            rg rgVar = this.f565de.get(str);
            if (rgVar == null) {
                rgVar = new rg();
                this.f565de.put(str, rgVar);
            }
            rgVar.qw(f);
            if (str.equals("__container")) {
                for (FrameListener qw2 : this.f564ad) {
                    qw2.qw(f);
                }
            }
        }
    }
}
