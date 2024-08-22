package com.airbnb.lottie.model.content;

import com.airbnb.lottie.animation.content.Content;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.pf.ad.ggg;
import fe.qw.qw.rg;

public class ShapeTrimPath implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final Type f611ad;

    /* renamed from: de  reason: collision with root package name */
    public final ad f612de;

    /* renamed from: fe  reason: collision with root package name */
    public final ad f613fe;
    public final String qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ad f614rg;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f615th;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public ShapeTrimPath(String str, Type type, ad adVar, ad adVar2, ad adVar3, boolean z) {
        this.qw = str;
        this.f611ad = type;
        this.f612de = adVar;
        this.f613fe = adVar2;
        this.f614rg = adVar3;
        this.f615th = z;
    }

    public ad ad() {
        return this.f613fe;
    }

    public String de() {
        return this.qw;
    }

    public ad fe() {
        return this.f614rg;
    }

    public Content qw(rg rgVar, qw qwVar) {
        return new ggg(qwVar, this);
    }

    public ad rg() {
        return this.f612de;
    }

    public Type th() {
        return this.f611ad;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f612de + ", end: " + this.f613fe + ", offset: " + this.f614rg + "}";
    }

    public boolean yj() {
        return this.f615th;
    }
}
