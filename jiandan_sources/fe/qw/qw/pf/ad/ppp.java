package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.rg;
import fe.qw.qw.vvv.de;

public class ppp extends qw {
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> ddd;
    public final String ggg;
    public final qw ppp;
    public final boolean vvv;
    public final BaseKeyframeAnimation<Integer, Integer> xxx;

    public ppp(rg rgVar, qw qwVar, ShapeStroke shapeStroke) {
        super(rgVar, qwVar, shapeStroke.ad().toPaintCap(), shapeStroke.rg().toPaintJoin(), shapeStroke.yj(), shapeStroke.i(), shapeStroke.o(), shapeStroke.th(), shapeStroke.fe());
        this.ppp = qwVar;
        this.ggg = shapeStroke.uk();
        this.vvv = shapeStroke.pf();
        BaseKeyframeAnimation<Integer, Integer> qw = shapeStroke.de().qw();
        this.xxx = qw;
        qw.qw(this);
        qwVar.i(this.xxx);
    }

    public <T> void de(T t, @Nullable de<T> deVar) {
        super.de(t, deVar);
        if (t == LottieProperty.f554ad) {
            this.xxx.m1switch(deVar);
        } else if (t == LottieProperty.c) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.ddd;
            if (baseKeyframeAnimation != null) {
                this.ppp.c(baseKeyframeAnimation);
            }
            if (deVar == null) {
                this.ddd = null;
                return;
            }
            fe.qw.qw.pf.de.ppp ppp2 = new fe.qw.qw.pf.de.ppp(deVar);
            this.ddd = ppp2;
            ppp2.qw(this);
            this.ppp.i(this.xxx);
        }
    }

    public String getName() {
        return this.ggg;
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        if (!this.vvv) {
            this.f3324i.setColor(((fe.qw.qw.pf.de.qw) this.xxx).ppp());
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.ddd;
            if (baseKeyframeAnimation != null) {
                this.f3324i.setColorFilter(baseKeyframeAnimation.uk());
            }
            super.yj(canvas, matrix, i2);
        }
    }
}
