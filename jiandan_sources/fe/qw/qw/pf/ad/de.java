package fe.qw.qw.pf.ad;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ContentModel;
import fe.qw.qw.ggg.yj;
import fe.qw.qw.p009switch.fe;
import fe.qw.qw.p009switch.i.i;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.p009switch.uk.Cif;
import fe.qw.qw.pf.de.when;
import fe.qw.qw.rg;
import java.util.ArrayList;
import java.util.List;

public class de implements DrawingContent, o, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: ad  reason: collision with root package name */
    public RectF f3274ad;

    /* renamed from: de  reason: collision with root package name */
    public final Matrix f3275de;

    /* renamed from: fe  reason: collision with root package name */
    public final Path f3276fe;

    /* renamed from: i  reason: collision with root package name */
    public final rg f3277i;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public List<o> f3278o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public when f3279pf;
    public Paint qw;

    /* renamed from: rg  reason: collision with root package name */
    public final RectF f3280rg;

    /* renamed from: th  reason: collision with root package name */
    public final String f3281th;

    /* renamed from: uk  reason: collision with root package name */
    public final List<Content> f3282uk;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f3283yj;

    public de(rg rgVar, qw qwVar, i iVar) {
        this(rgVar, qwVar, iVar.de(), iVar.fe(), th(rgVar, qwVar, iVar.ad()), uk(iVar.ad()));
    }

    public static List<Content> th(rg rgVar, qw qwVar, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content qw2 = list.get(i2).qw(rgVar, qwVar);
            if (qw2 != null) {
                arrayList.add(qw2);
            }
        }
        return arrayList;
    }

    @Nullable
    public static Cif uk(List<ContentModel> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            ContentModel contentModel = list.get(i2);
            if (contentModel instanceof Cif) {
                return (Cif) contentModel;
            }
        }
        return null;
    }

    public void ad(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f3282uk.size());
        arrayList.addAll(list);
        for (int size = this.f3282uk.size() - 1; size >= 0; size--) {
            Content content = this.f3282uk.get(size);
            content.ad(arrayList, this.f3282uk.subList(0, size));
            arrayList.add(content);
        }
    }

    public <T> void de(T t, @Nullable fe.qw.qw.vvv.de<T> deVar) {
        when when = this.f3279pf;
        if (when != null) {
            when.de(t, deVar);
        }
    }

    public void fe(fe feVar, int i2, List<fe> list, fe feVar2) {
        if (feVar.yj(getName(), i2)) {
            if (!"__container".equals(getName())) {
                feVar2 = feVar2.qw(getName());
                if (feVar.de(getName(), i2)) {
                    list.add(feVar2.i(this));
                }
            }
            if (feVar.uk(getName(), i2)) {
                int rg2 = i2 + feVar.rg(getName(), i2);
                for (int i3 = 0; i3 < this.f3282uk.size(); i3++) {
                    Content content = this.f3282uk.get(i3);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).fe(feVar, rg2, list, feVar2);
                    }
                }
            }
        }
    }

    public String getName() {
        return this.f3281th;
    }

    public Path getPath() {
        this.f3275de.reset();
        when when = this.f3279pf;
        if (when != null) {
            this.f3275de.set(when.th());
        }
        this.f3276fe.reset();
        if (this.f3283yj) {
            return this.f3276fe;
        }
        for (int size = this.f3282uk.size() - 1; size >= 0; size--) {
            Content content = this.f3282uk.get(size);
            if (content instanceof o) {
                this.f3276fe.addPath(((o) content).getPath(), this.f3275de);
            }
        }
        return this.f3276fe;
    }

    public List<o> i() {
        if (this.f3278o == null) {
            this.f3278o = new ArrayList();
            for (int i2 = 0; i2 < this.f3282uk.size(); i2++) {
                Content content = this.f3282uk.get(i2);
                if (content instanceof o) {
                    this.f3278o.add((o) content);
                }
            }
        }
        return this.f3278o;
    }

    public Matrix o() {
        when when = this.f3279pf;
        if (when != null) {
            return when.th();
        }
        this.f3275de.reset();
        return this.f3275de;
    }

    public final boolean pf() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3282uk.size(); i3++) {
            if ((this.f3282uk.get(i3) instanceof DrawingContent) && (i2 = i2 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void qw() {
        this.f3277i.invalidateSelf();
    }

    public void rg(RectF rectF, Matrix matrix, boolean z) {
        this.f3275de.set(matrix);
        when when = this.f3279pf;
        if (when != null) {
            this.f3275de.preConcat(when.th());
        }
        this.f3280rg.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f3282uk.size() - 1; size >= 0; size--) {
            Content content = this.f3282uk.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).rg(this.f3280rg, this.f3275de, z);
                rectF.union(this.f3280rg);
            }
        }
    }

    public void yj(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f3283yj) {
            this.f3275de.set(matrix);
            when when = this.f3279pf;
            if (when != null) {
                this.f3275de.preConcat(when.th());
                i2 = (int) ((((((float) (this.f3279pf.uk() == null ? 100 : this.f3279pf.uk().uk().intValue())) / 100.0f) * ((float) i2)) / 255.0f) * 255.0f);
            }
            boolean z = this.f3277i.m() && pf() && i2 != 255;
            if (z) {
                this.f3274ad.set(0.0f, 0.0f, 0.0f, 0.0f);
                rg(this.f3274ad, this.f3275de, true);
                this.qw.setAlpha(i2);
                yj.m233switch(canvas, this.f3274ad, this.qw);
            }
            if (z) {
                i2 = 255;
            }
            for (int size = this.f3282uk.size() - 1; size >= 0; size--) {
                Content content = this.f3282uk.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).yj(canvas, this.f3275de, i2);
                }
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    public de(rg rgVar, qw qwVar, String str, boolean z, List<Content> list, @Nullable Cif ifVar) {
        this.qw = new fe.qw.qw.pf.qw();
        this.f3274ad = new RectF();
        this.f3275de = new Matrix();
        this.f3276fe = new Path();
        this.f3280rg = new RectF();
        this.f3281th = str;
        this.f3277i = rgVar;
        this.f3283yj = z;
        this.f3282uk = list;
        if (ifVar != null) {
            when ad2 = ifVar.ad();
            this.f3279pf = ad2;
            ad2.qw(qwVar);
            this.f3279pf.ad(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof uk) {
                arrayList.add((uk) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((uk) arrayList.get(size2)).th(list.listIterator(list.size()));
        }
    }
}
