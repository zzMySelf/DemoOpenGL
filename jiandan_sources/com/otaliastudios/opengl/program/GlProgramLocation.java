package com.otaliastudios.opengl.program;

import android.opengl.GLES20;
import fe.vvv.ad.ad.fe;
import fe.vvv.ad.yj.ad;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0013:\u0002\u0013\u0014B!\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lkotlin/UInt;", "uvalue", "I", "getUvalue-pVg5ArA$egloo_metadata_release", "()I", "", "value", "getValue", "program", "Lcom/otaliastudios/opengl/program/GlProgramLocation$Type;", "type", "<init>", "(ILcom/otaliastudios/opengl/program/GlProgramLocation$Type;Ljava/lang/String;)V", "Companion", "Type", "egloo-metadata_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class GlProgramLocation {

    /* renamed from: fe  reason: collision with root package name */
    public static final qw f6802fe = new qw((DefaultConstructorMarker) null);

    /* renamed from: ad  reason: collision with root package name */
    public final int f6803ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final String f6804de;
    public final int qw;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation$Type;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "ATTRIB", "UNIFORM", "egloo-metadata_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public enum Type {
        ATTRIB,
        UNIFORM
    }

    public static final class qw {
        public qw() {
        }

        @NotNull
        public final GlProgramLocation ad(int i2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new GlProgramLocation(i2, Type.UNIFORM, str, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final GlProgramLocation qw(int i2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new GlProgramLocation(i2, Type.ATTRIB, str, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GlProgramLocation(int i2, Type type, String str) {
        int i3;
        this.f6804de = str;
        int i4 = ad.$EnumSwitchMapping$0[type.ordinal()];
        if (i4 == 1) {
            i3 = GLES20.glGetAttribLocation(UInt.m1249constructorimpl(i2), this.f6804de);
        } else if (i4 == 2) {
            i3 = GLES20.glGetUniformLocation(UInt.m1249constructorimpl(i2), this.f6804de);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.qw = i3;
        fe.de(i3, this.f6804de);
        this.f6803ad = UInt.m1249constructorimpl(this.qw);
    }

    public final int ad() {
        return this.qw;
    }

    public final int qw() {
        return this.f6803ad;
    }

    public /* synthetic */ GlProgramLocation(int i2, Type type, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, type, str);
    }
}
