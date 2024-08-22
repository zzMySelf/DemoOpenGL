package fe.rg.qw;

import com.bumptech.glide.request.transition.TransitionFactory;
import fe.rg.qw.when.rg.qw;
import fe.rg.qw.yj;

public abstract class yj<CHILD extends yj<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public TransitionFactory<? super TranscodeType> f5102ad = qw.ad();

    /* renamed from: ad */
    public final CHILD clone() {
        try {
            return (yj) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final TransitionFactory<? super TranscodeType> de() {
        return this.f5102ad;
    }
}
