package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.pf.ad.pf;
import fe.qw.qw.rg;

public class PolystarShape implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final Type f592ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f593de;

    /* renamed from: fe  reason: collision with root package name */
    public final AnimatableValue<PointF, PointF> f594fe;

    /* renamed from: i  reason: collision with root package name */
    public final ad f595i;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f596o;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ad f597rg;

    /* renamed from: th  reason: collision with root package name */
    public final ad f598th;

    /* renamed from: uk  reason: collision with root package name */
    public final ad f599uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ad f600yj;

    public enum Type {
        STAR(1),
        POLYGON(2);
        
        public final int value;

        /* access modifiers changed from: public */
        Type(int i2) {
            this.value = i2;
        }

        public static Type forValue(int i2) {
            for (Type type : values()) {
                if (type.value == i2) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, ad adVar, AnimatableValue<PointF, PointF> animatableValue, ad adVar2, ad adVar3, ad adVar4, ad adVar5, ad adVar6, boolean z) {
        this.qw = str;
        this.f592ad = type;
        this.f593de = adVar;
        this.f594fe = animatableValue;
        this.f597rg = adVar2;
        this.f598th = adVar3;
        this.f600yj = adVar4;
        this.f599uk = adVar5;
        this.f595i = adVar6;
        this.f596o = z;
    }

    public ad ad() {
        return this.f598th;
    }

    public ad de() {
        return this.f599uk;
    }

    public String fe() {
        return this.qw;
    }

    public ad i() {
        return this.f597rg;
    }

    public Type o() {
        return this.f592ad;
    }

    public boolean pf() {
        return this.f596o;
    }

    public Content qw(rg rgVar, qw qwVar) {
        return new pf(rgVar, qwVar, this);
    }

    public ad rg() {
        return this.f600yj;
    }

    public ad th() {
        return this.f595i;
    }

    public AnimatableValue<PointF, PointF> uk() {
        return this.f594fe;
    }

    public ad yj() {
        return this.f593de;
    }
}
