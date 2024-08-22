package fe.uk.qw;

import com.dxmbumptech.glide.request.transition.TransitionFactory;
import fe.uk.qw.ppp.th.qw;
import fe.uk.qw.uk;

public abstract class uk<CHILD extends uk<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public TransitionFactory<? super TranscodeType> f6041ad = qw.ad();

    /* renamed from: ad */
    public final CHILD clone() {
        try {
            return (uk) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final TransitionFactory<? super TranscodeType> de() {
        return this.f6041ad;
    }
}
