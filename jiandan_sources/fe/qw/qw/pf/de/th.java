package fe.qw.qw.pf.de;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.Mask;
import fe.qw.qw.p009switch.i.yj;
import java.util.ArrayList;
import java.util.List;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public final List<BaseKeyframeAnimation<Integer, Integer>> f3375ad;

    /* renamed from: de  reason: collision with root package name */
    public final List<Mask> f3376de;
    public final List<BaseKeyframeAnimation<yj, Path>> qw;

    public th(List<Mask> list) {
        this.f3376de = list;
        this.qw = new ArrayList(list.size());
        this.f3375ad = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.qw.add(list.get(i2).ad().qw());
            this.f3375ad.add(list.get(i2).de().qw());
        }
    }

    public List<Mask> ad() {
        return this.f3376de;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> de() {
        return this.f3375ad;
    }

    public List<BaseKeyframeAnimation<yj, Path>> qw() {
        return this.qw;
    }
}
