package com.airbnb.lottie.model.content;

import fe.qw.qw.p009switch.uk.fe;
import fe.qw.qw.p009switch.uk.uk;

public class Mask {

    /* renamed from: ad  reason: collision with root package name */
    public final uk f587ad;

    /* renamed from: de  reason: collision with root package name */
    public final fe f588de;

    /* renamed from: fe  reason: collision with root package name */
    public final boolean f589fe;
    public final MaskMode qw;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, uk ukVar, fe feVar, boolean z) {
        this.qw = maskMode;
        this.f587ad = ukVar;
        this.f588de = feVar;
        this.f589fe = z;
    }

    public uk ad() {
        return this.f587ad;
    }

    public fe de() {
        return this.f588de;
    }

    public boolean fe() {
        return this.f589fe;
    }

    public MaskMode qw() {
        return this.qw;
    }
}
