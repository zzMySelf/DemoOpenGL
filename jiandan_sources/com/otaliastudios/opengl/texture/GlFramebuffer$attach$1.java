package com.otaliastudios.opengl.texture;

import android.opengl.GLES20;
import fe.vvv.ad.th.th;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class GlFramebuffer$attach$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int $attachment;
    public final /* synthetic */ GlTexture $texture;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlFramebuffer$attach$1(int i2, GlTexture glTexture) {
        super(0);
        this.$attachment = i2;
        this.$texture = glTexture;
    }

    public final void invoke() {
        GLES20.glFramebufferTexture2D(th.rg(), UInt.m1249constructorimpl(this.$attachment), UInt.m1249constructorimpl(this.$texture.th()), UInt.m1249constructorimpl(this.$texture.rg()), 0);
        int r0 = UInt.m1249constructorimpl(GLES20.glCheckFramebufferStatus(th.rg()));
        if (r0 != th.th()) {
            throw new RuntimeException("Invalid framebuffer generation. Error:" + UInt.m1294toStringimpl(r0));
        }
    }
}
