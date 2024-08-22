package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import fe.qw.qw.de;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.p009switch.uk.ad;
import fe.qw.qw.p009switch.uk.o;
import fe.qw.qw.p009switch.uk.pf;
import fe.qw.qw.vvv.qw;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class Layer {
    public final boolean aaa;

    /* renamed from: ad  reason: collision with root package name */
    public final de f616ad;
    @Nullable
    public final ad ddd;

    /* renamed from: de  reason: collision with root package name */
    public final String f617de;

    /* renamed from: fe  reason: collision with root package name */
    public final long f618fe;
    public final int ggg;

    /* renamed from: i  reason: collision with root package name */
    public final Cif f619i;

    /* renamed from: if  reason: not valid java name */
    public final int f2if;
    public final MatteType mmm;
    public final List<qw<Float>> nn;

    /* renamed from: o  reason: collision with root package name */
    public final int f620o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f621pf;
    public final int ppp;
    public final List<ContentModel> qw;

    /* renamed from: rg  reason: collision with root package name */
    public final LayerType f622rg;

    /* renamed from: switch  reason: not valid java name */
    public final float f3switch;

    /* renamed from: th  reason: collision with root package name */
    public final long f623th;

    /* renamed from: uk  reason: collision with root package name */
    public final List<Mask> f624uk;
    @Nullable
    public final o vvv;
    public final float when;
    @Nullable
    public final pf xxx;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final String f625yj;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, de deVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, Cif ifVar, int i2, int i3, int i4, float f, float f2, int i5, int i6, @Nullable o oVar, @Nullable pf pfVar, List<qw<Float>> list3, MatteType matteType, @Nullable ad adVar, boolean z) {
        this.qw = list;
        this.f616ad = deVar;
        this.f617de = str;
        this.f618fe = j;
        this.f622rg = layerType;
        this.f623th = j2;
        this.f625yj = str2;
        this.f624uk = list2;
        this.f619i = ifVar;
        this.f620o = i2;
        this.f621pf = i3;
        this.f2if = i4;
        this.f3switch = f;
        this.when = f2;
        this.ppp = i5;
        this.ggg = i6;
        this.vvv = oVar;
        this.xxx = pfVar;
        this.nn = list3;
        this.mmm = matteType;
        this.ddd = adVar;
        this.aaa = z;
    }

    public boolean aaa() {
        return this.aaa;
    }

    public long ad() {
        return this.f618fe;
    }

    @Nullable
    public ad ddd() {
        return this.ddd;
    }

    public List<qw<Float>> de() {
        return this.nn;
    }

    public LayerType fe() {
        return this.f622rg;
    }

    public float ggg() {
        return this.when / this.f616ad.rg();
    }

    public int i() {
        return this.ggg;
    }

    /* renamed from: if  reason: not valid java name */
    public List<ContentModel> m2if() {
        return this.qw;
    }

    public Cif mmm() {
        return this.f619i;
    }

    public float nn() {
        return this.f3switch;
    }

    public int o() {
        return this.ppp;
    }

    @Nullable
    public String pf() {
        return this.f625yj;
    }

    public int ppp() {
        return this.f620o;
    }

    public String qqq(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(yj());
        sb.append(StringUtils.LF);
        Layer ddd2 = this.f616ad.ddd(uk());
        if (ddd2 != null) {
            sb.append("\t\tParents: ");
            sb.append(ddd2.yj());
            Layer ddd3 = this.f616ad.ddd(ddd2.uk());
            while (ddd3 != null) {
                sb.append("->");
                sb.append(ddd3.yj());
                ddd3 = this.f616ad.ddd(ddd3.uk());
            }
            sb.append(str);
            sb.append(StringUtils.LF);
        }
        if (!rg().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(rg().size());
            sb.append(StringUtils.LF);
        }
        if (!(ppp() == 0 || when() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(ppp()), Integer.valueOf(when()), Integer.valueOf(m3switch())}));
        }
        if (!this.qw.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel next : this.qw) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }

    public de qw() {
        return this.f616ad;
    }

    public List<Mask> rg() {
        return this.f624uk;
    }

    /* renamed from: switch  reason: not valid java name */
    public int m3switch() {
        return this.f2if;
    }

    public MatteType th() {
        return this.mmm;
    }

    public String toString() {
        return qqq("");
    }

    public long uk() {
        return this.f623th;
    }

    @Nullable
    public o vvv() {
        return this.vvv;
    }

    public int when() {
        return this.f621pf;
    }

    @Nullable
    public pf xxx() {
        return this.xxx;
    }

    public String yj() {
        return this.f617de;
    }
}
