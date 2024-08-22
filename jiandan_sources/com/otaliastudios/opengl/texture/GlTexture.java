package com.otaliastudios.opengl.texture;

import android.opengl.GLES20;
import com.otaliastudios.opengl.core.GlBindable;
import fe.vvv.ad.ad.fe;
import fe.vvv.ad.ad.rg;
import fe.vvv.ad.th.th;
import java.nio.Buffer;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B)\b\u0017\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001bBG\b\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001dBU\b\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/otaliastudios/opengl/texture/GlTexture;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "bind", "()V", "release", "unbind", "", "format", "Ljava/lang/Integer;", "getFormat", "()Ljava/lang/Integer;", "height", "getHeight", "id", "I", "getId", "()I", "target", "getTarget", "type", "getType", "unit", "getUnit", "width", "getWidth", "<init>", "(IILjava/lang/Integer;)V", "internalFormat", "(IIIIIII)V", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "egloo-metadata_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class GlTexture implements GlBindable {

    /* renamed from: ad  reason: collision with root package name */
    public final int f6805ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f6806de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final Integer f6807fe;
    public final int qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final Integer f6808rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public final Integer f6809th;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public final Integer f6810yj;

    @JvmOverloads
    public GlTexture(int i2, int i3) {
        this(i2, i3, (Integer) null, 4, (DefaultConstructorMarker) null);
    }

    public GlTexture(int i2, int i3, Integer num, Integer num2, Integer num3, Integer num4, final Integer num5, Integer num6) {
        int i4;
        this.f6805ad = i2;
        this.f6806de = i3;
        this.f6807fe = num2;
        this.f6808rg = num3;
        this.f6809th = num4;
        this.f6810yj = num6;
        if (num != null) {
            i4 = num.intValue();
        } else {
            int[] r3 = UIntArray.m1302constructorimpl(1);
            int r5 = UIntArray.m1309getSizeimpl(r3);
            int[] iArr = new int[r5];
            for (int i5 = 0; i5 < r5; i5++) {
                iArr[i5] = UIntArray.m1308getpVg5ArA(r3, i5);
            }
            GLES20.glGenTextures(1, iArr, 0);
            Unit unit = Unit.INSTANCE;
            for (int i6 = 0; i6 < 1; i6++) {
                UIntArray.m1313setVXSXFK8(r3, i6, UInt.m1249constructorimpl(iArr[i6]));
            }
            fe.ad("glGenTextures");
            i4 = UIntArray.m1308getpVg5ArA(r3, 0);
        }
        this.qw = i4;
        if (num == null) {
            rg.qw(this, new Function0<Unit>(this) {
                public final /* synthetic */ GlTexture this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    if (!(this.this$0.uk() == null || this.this$0.fe() == null || this.this$0.de() == null || num5 == null || this.this$0.yj() == null)) {
                        GLES20.glTexImage2D(UInt.m1249constructorimpl(this.this$0.th()), 0, num5.intValue(), this.this$0.uk().intValue(), this.this$0.fe().intValue(), 0, UInt.m1249constructorimpl(this.this$0.de().intValue()), UInt.m1249constructorimpl(this.this$0.yj().intValue()), (Buffer) null);
                    }
                    GLES20.glTexParameterf(UInt.m1249constructorimpl(this.this$0.th()), th.when(), th.i());
                    GLES20.glTexParameterf(UInt.m1249constructorimpl(this.this$0.th()), th.m1023switch(), th.yj());
                    GLES20.glTexParameteri(UInt.m1249constructorimpl(this.this$0.th()), th.ppp(), th.qw());
                    GLES20.glTexParameteri(UInt.m1249constructorimpl(this.this$0.th()), th.ggg(), th.qw());
                    fe.ad("glTexParameter");
                }
            });
        }
    }

    public void ad() {
        GLES20.glActiveTexture(UInt.m1249constructorimpl(this.f6805ad));
        GLES20.glBindTexture(UInt.m1249constructorimpl(this.f6806de), UInt.m1249constructorimpl(this.qw));
        fe.ad("bind");
    }

    @Nullable
    public final Integer de() {
        return this.f6809th;
    }

    @Nullable
    public final Integer fe() {
        return this.f6808rg;
    }

    public final void i() {
        int[] iArr = {UInt.m1249constructorimpl(this.qw)};
        int r2 = UIntArray.m1309getSizeimpl(iArr);
        int[] iArr2 = new int[r2];
        for (int i2 = 0; i2 < r2; i2++) {
            iArr2[i2] = UIntArray.m1308getpVg5ArA(iArr, i2);
        }
        GLES20.glDeleteTextures(1, iArr2, 0);
        Unit unit = Unit.INSTANCE;
        for (int i3 = 0; i3 < 1; i3++) {
            UIntArray.m1313setVXSXFK8(iArr, i3, UInt.m1249constructorimpl(iArr2[i3]));
        }
    }

    public void qw() {
        GLES20.glBindTexture(UInt.m1249constructorimpl(this.f6806de), UInt.m1249constructorimpl(0));
        GLES20.glActiveTexture(th.pf());
        fe.ad("unbind");
    }

    public final int rg() {
        return this.qw;
    }

    public final int th() {
        return this.f6806de;
    }

    @Nullable
    public final Integer uk() {
        return this.f6807fe;
    }

    @Nullable
    public final Integer yj() {
        return this.f6810yj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlTexture(int i2, int i3, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? th.pf() : i2, (i4 & 2) != 0 ? th.m1022if() : i3, (i4 & 4) != 0 ? null : num);
    }

    @JvmOverloads
    public GlTexture(int i2, int i3, @Nullable Integer num) {
        this(i2, i3, num, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null);
    }
}
